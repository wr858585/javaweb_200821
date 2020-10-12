package com.atguigu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(" HelloServlet3 doPost() 方法 ");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(" HelloServlet3 doGet() 方法 ");

        ServletContext servletContext = getServletContext();
        System.out.println( "HelloServlet3 中获取 key 的值 => " + servletContext.getAttribute("key") );

    }
}
