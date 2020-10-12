package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @WebServlet 注解表示当前类是一个Servlet程序
 *    <servlet>
 *         <servlet-name>HelloServlet</servlet-name>
 *         <servlet-class>com.atguigu.servlet.HelloServlet</servlet-class>
 *     </servlet>
 *
 *
 * (value = "/hello4")
 *     <servlet-mapping>
 *         <servlet-name>HelloServlet</servlet-name>
 *         <url-pattern>/hello</url-pattern>
 *     </servlet-mapping>
 */
@WebServlet(value = "/hello4")
public class HelloServlet4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(" Hello Servlet4 doGet() 方法 ");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(" Hello Servlet4 doPost() 方法 ");
    }
}
