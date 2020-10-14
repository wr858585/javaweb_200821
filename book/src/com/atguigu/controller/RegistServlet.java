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

/**
 * @author oono
 * @date 2020 10 14
 */
@WebServlet(value = "/registServlet")
public class RegistServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                request.getRequestDispatcher("/pages/user/regist.html").forward(request,response);
            } else{
                //4.调用XxxService.registUser()来处理业务
                userService.registUser(new User(null,username,password,email));
                //5.跳转到注册成功页面
                request.getRequestDispatcher("/pages/user/regist_success.html").forward(request,response);
            }
        } else{
            System.out.println("验证码不正确");
            //跳回到regist.html页面
            request.getRequestDispatcher("/pages/user/regist.html").forward(request,response);
        }
    }
}
