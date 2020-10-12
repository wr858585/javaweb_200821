package com.atguigu.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ConfigServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);//调用父类中的init方法
//        1 获取Servlet-name标签的值
        System.out.println( "servlet-name => " + config.getServletName() );
//        2 获取init-param初始化参数
        System.out.println(" init-param username => " + config.getInitParameter("username"));
        System.out.println(" init-param url => " + config.getInitParameter("url"));
//        3 获取ServletContext对象
        System.out.println(config.getServletContext());
    }




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
