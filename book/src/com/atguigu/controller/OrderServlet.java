package com.atguigu.controller;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import com.atguigu.pojo.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author oono
 * @date 2020 10 26
 */
@WebServlet(value = "/orderServlet")
//注解路径要写成/manager下的Servlet，因为后面filter会统一拦截所有再manager下直接访问资源的请求，必须先登录才能访问到相关servlet操作
public class OrderServlet extends BaseServlet {

    OrderService orderService = new OrderServiceImpl();

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
        String orderId = orderService.createOrder(userId, cart);
        //把订单号，保存到request域中
        request.setAttribute("orderId", orderId);
        //最后跳转到结账checkout页面
        request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request,response);
    }

    protected void myOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("经过OrderServlet#myOrders()方法");
        //获取用户id
        User user = (User)request.getSession().getAttribute("user");
        //判断用户是否已登录
        if(user == null){
            //尚未登陆，转发到登录页面
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }
        //若已登录，获取用户id
        Integer userId = user.getId();
        //调用orderService.myOrders()方法，获取该用户所有订单
        List<Order> orders = orderService.myOrders(userId);
        //把获取到的订单信息存储到request域对象中
        request.setAttribute("orders", orders);
        //最后跳转到订单页面
        request.getRequestDispatcher("/pages/order/order.jsp").forward(request,response);
    }

    protected void receiveOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //获取请求的参数：orderId
        String orderId = request.getParameter("orderId");
        //调用orderService.receiveOrder()方法，
        orderService.receiveOrder(orderId);
        //最后跳转到订单页面
        request.getRequestDispatcher("/pages/order/order.jsp").forward(request,response);
    }

    protected void orderDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //获取请求的参数：orderId
        String orderId = request.getParameter("orderId");
        //调用orderService.orderDetails()方法，获取该订单中所有的商品信息，返回集合
        List<OrderItem> orderItems = orderService.orderDetails(orderId);
        System.out.println(orderItems);
        //在request域中保存该信息，便于order_details.jsp页面拿出来遍历
        request.setAttribute("orderItems",orderItems);
        //最后跳转到order.jsp页面
        request.getRequestDispatcher("/pages/order/order_details.jsp").forward(request,response);
    }

    protected void allOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //首先，必须要获取用户id。因为此操作非admin登录不能被允许进行
        User user = (User)request.getSession().getAttribute("user");
        //判断是否登录
        if (user == null){
            //未登录，转发到登录页面
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }
        //调用orderService.allOrders()方法，把所有订单信息orders保存到request域中
        List<Order> orders = orderService.allOrders();
        request.setAttribute("orders",orders);
        //最后跳转到order_manager.jsp页面
        request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request,response);
    }

    protected void sendOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //首先，必须要获取用户id，此操作非admin登录不能进行
        User user = (User)request.getSession().getAttribute("user");
        //判断是否登录
        if(user == null){
            //未登录，转发到登录页面
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }
        //已登录，获取请求的参数：要发货的order
        String orderId = request.getParameter("orderId");
        //调用orderService.sendOrder()方法，把订单确认发货
        orderService.sendOrder(orderId);
        //最后，跳转到order_manager.jsp页面
        request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request,response);
    }


}
