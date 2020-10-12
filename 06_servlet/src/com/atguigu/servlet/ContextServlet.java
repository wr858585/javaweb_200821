package com.atguigu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/contextServlet")
public class ContextServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取ServletContext对象
        ServletContext servletContext = getServletContext();
        //        1 获取在web.xml中配置的context-param 上下文参数
        System.out.println("context param   username => " + servletContext.getInitParameter("username"));
        System.out.println("context param   driverClassName => " + servletContext.getInitParameter("driverClassName"));

//        2 获取工程路径
        System.out.println( "工程路径 => " + servletContext.getContextPath() );
//        3 获取工程部署后，在服务器硬盘上的绝对路径
        /**
         * servletContext.getRealPath("/") 获取在服务器上的真实路径 <br/>
         * / 斜杠 表示请求地址为 http://ip:port/工程路径   映射到代码的 web目录 <br/>
         */
        System.out.println("整个web工程部署到 ： " + servletContext.getRealPath("/"));
        System.out.println("web/css在服务器上的位置是：" + servletContext.getRealPath("/css"));
        System.out.println("web/imgs/3.jpg 在服务器上的位置是：" + servletContext.getRealPath("/imgs/3.jpg"));

    }
}
