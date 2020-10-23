package com.atguigu.controller;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.impl.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author oono
 * @date 2020 10 23
 */
@WebServlet(value = "/cartServlet")
public class CartServlet extends BaseServlet {

    BookService bookService = new BookServiceImpl();

    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //1.获取request中的参数：商品id
        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);

        //2.通过bookService.queryBookById()来查询是什么图书
        Book book = bookService.queryBookById(id);

        //3.将获取到的book对象转化为cartItem对象（一本书，所以count为1，totalPrice为price）
        CartItem cartItem = new CartItem(id,book.getName(),book.getPrice(),1,book.getPrice());

        //4.获取购物车对象
        //注意：不能new一个cart对象，否则每次addItem添加一本书都会使用一个新的cart，逻辑不对！是在同一个购物车中添加商品
        Object cart = request.getSession().getAttribute("cart");
        //强转
        Cart cart1 = (Cart) cart;

        //如果cart1==null，说明之前没有购物车对象，new一个
        if(cart1 == null){
            cart1 = new Cart();
            //别忘记把数据存储到域对象中
            request.getSession().setAttribute("cart",cart1);
        }

        //5.调用cart.addItem()，把cartItem添加到方法调用者cart对象中
        cart1.addItem(cartItem);
        System.out.println(cart1);

        //6.跳回商品列表页面 --> 重定向
        response.sendRedirect(request.getHeader("Referer"));

    }

}
