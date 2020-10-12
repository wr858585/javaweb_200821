package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println(" 1 构造器 HelloServlet ");
    }

    /**
     * 每次只要Servlet程序接收到请求，都会调用srevice()处理请求。
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        // 我们需要根据请求的方式不同。区分执行不同的业务代码。
        String method = httpServletRequest.getMethod();

        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)) {
            doPost();
        }
    }

    public void doGet(){
        System.out.println("业务GET  doGet()");
    }

    public void doPost(){
        System.out.println("业务post  doPost()");
    }


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println(" 2 init() 初始化 HelloServlet ");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4.destroy() 销毁");
    }
}
