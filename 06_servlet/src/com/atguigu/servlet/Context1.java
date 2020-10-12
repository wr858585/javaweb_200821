package com.atguigu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/context1")
public class Context1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(" Context1 中开始保存数据到ServletConetxt域中 ");

        ServletContext servletContext = getServletContext();
        System.out.println(servletContext);

        servletContext.setAttribute("key","value");

        System.out.println( "Context1 中获取 key 的值 => " + servletContext.getAttribute("key") );

    }
}
