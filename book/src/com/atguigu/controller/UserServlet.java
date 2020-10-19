package com.atguigu.controller;

import com.atguigu.pojo.User;
import com.atguigu.service.impl.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author oono
 * @date 2020 10 19
 */
@WebServlet(value = "/userServlet")
public class UserServlet extends BaseServlet {

    UserService userService = new UserServiceImpl();

    protected void login(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        //1.获取请求的参数，用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //2.调用UserService.login():User，登录业务
        User loginUser = userService.login(new User(null, username, password, null));

        //3.根据login()方法的返回值，决定是否登录成功
        if(loginUser == null){
            //控制台打印"登录失败"信息
            System.out.println("登录失败");
            //给用户友好提示：把errorMsg设置为"用户名或密码输入有误，请重新输入"
            request.setAttribute("msg","用户名或密码输入有误，请重新输入");
            //界面优化，跳回login.html页面时保留客户输入的非敏感信息，如username。提升用户体验，避免重复填写
            request.setAttribute("username",username);
            //跳回login.html页面
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        } else{
            System.out.println("登录成功");
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
        }
    }

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求的参数（封装为User对象）
        String username =  request.getParameter("username");
        String password =  request.getParameter("password");
        String email =  request.getParameter("email");
        String code =  request.getParameter("code");

        //2.检查验证码是否正确
        if("abcde".equalsIgnoreCase(code)){
            //3.检查用户名是否被占用
            if(userService.existsUsername(username)){
                System.out.println("用户名：[" + username +"]已被占用");
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
            } else{
                //4.调用XxxService.registUser()来处理业务
                userService.registUser(new User(null,username,password,email));
                //5.跳转到注册成功页面
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
            }
        } else{
            System.out.println("验证码不正确");
            //跳回到regist.html页面
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
        }
    }

    //由于抽取了BaseServlet,所以子类（UserServlet,BookServlet)不用重写doPost方法，直接继承后调用父类的doPost方法即可

/*
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

*/
/*
        if("login".equals(action)){
            login(request,response);
        } else if("regist".equals(action)){
            regist(request,response);
        }
*//*


        //用反射可以替代if-else结构，优化大量业务方法的调用代码
        try{
            //通过action业务鉴别字符串，得到相应的反射方法
            Method declaredMethod = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            //反射调用目标方法
            declaredMethod.invoke(this,request,response);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
*/
}
