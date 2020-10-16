package com.atguigu.controller;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.UserServiceImpl;

import java.io.IOException;

/**
 * @author oono
 * @date 2020 10 16
 */
@javax.servlet.annotation.WebServlet(value = "/loginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {

    //登录服务器响应程序要做的事，无非就是：用户登录login，
    UserService userService = new UserServiceImpl();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        //获取用户输入的信息 --> 用request对象的getParameter方法！
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //用userService对象的login方法登录用户
        User login = userService.login(new User(null, username, password, null));

        //根据login的返回值，做不同的响应
        if(login == null){
            System.out.println("用户名或密码输入有误，登录失败");
            //需要跳转回登录页面
            request.getRequestDispatcher("/pages/user/login.html").forward(request,response);
        } else{
            System.out.println("登录成功");
            request.getRequestDispatcher("/pages/user/login_success.html").forward(request,response);
        }

    }

}
