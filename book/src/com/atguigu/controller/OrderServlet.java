package com.atguigu.controller;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author oono
 * @date 2020 10 26
 */
@WebServlet(value = "/orderServlet")
public class OrderServlet extends BaseServlet {
    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("经过OrderServlet#createOrder()方法");
        //获取用户id
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
            return;
        }
        Integer userId = user.getId();
        //获取购物车对象
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        //调用orderService.createOrder()生成订单


    }

}
