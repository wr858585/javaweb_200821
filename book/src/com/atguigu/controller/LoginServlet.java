package com.atguigu.controller;

import com.atguigu.pojo.User;
import com.atguigu.service.impl.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;

/**
 * @author oono
 * @date 2020 10 14
 */
@WebServlet(value = "/loginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {

    UserService userService = new UserServiceImpl();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        //1.获取请求的参数，用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //2.调用UserService.login():User，登录业务
        User loginUser = userService.login(new User(null, username, password, null));

        //3.根据login()方法的返回值，决定是否登录成功
        if(loginUser == null){
            System.out.println("登录失败");
            //跳回login.html页面
            request.getRequestDispatcher("/pages/user/login.html").forward(request,response);
        } else{
            System.out.println("登录成功");
            request.getRequestDispatcher("/pages/user/login_success.html").forward(request,response);
        }
    }

}
