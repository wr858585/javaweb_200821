package com.atguigu.controller;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author oono
 * @date 2020 10 16
 */
@WebServlet(value = "/registServlet")
public class RegistServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //先获取用户输入的信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");

        if("abcde".equalsIgnoreCase(code)){
            //验证码正确，继续判断用户名是否可用
            if(!userService.existsUsername(username)){
                //用户名可用
                //把用户信息存到数据库
                userService.registUser(new User(null,username,password,email));
                //跳转到注册成功页面
                request.getRequestDispatcher("/pages/user/regist_success.html").forward(request,response);
            } else{
                //用户名不可用
                System.out.println("用户名[" + username + "]不可用");
                //跳转回此页面
                request.getRequestDispatcher("/pages/user/regist.html").forward(request,response);
            }
        } else{
            //验证码不正确
            System.out.println("验证码输入有误");
            request.getRequestDispatcher("/pages/user/regist.html").forward(request,response);
        }
    }

}
