package com.atguigu.controller;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author oono
 * @date 2020 10 21
 */
@WebServlet(value = "/client/bookServlet")
//之所以把bookServlet分成两个写，一个放在client路径下，一个再manager路径下，是因为之后filter过滤
//client路径下的这个servlet响应程序的功能，分页，是不用用户登录就必须要执行的操作，filter不过滤client路径下的请求，可以访问资源
//而manager路径下的servlet响应程序的功能，必须要登录才能操作，所以用filter过滤掉所有未登录而直接请求访问managerServlet资源的请求
public class ClientBookServlet extends BaseServlet {

    BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //1.获取请求的参数：pageNo, pageSize
        Integer pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        Integer pageSize = WebUtils.parseInt(request.getParameter("pageSize"),Page.PAGE_SIZE);

        //2.调用bookService.page()方法处理分页逻辑
        Page page = bookService.page(pageNo, pageSize);
        page.setUrl("client/bookServlet?action=page");

        //3.将page对象保存为request域对象
        request.setAttribute("page",page);

        //4.请求转发到list页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);

    }

    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //1.获取请求的参数：pageNo,pageSize,min,max
        Integer pageNo = WebUtils.parseInt(request.getParameter("pageNo"),1);
        Integer pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        Integer min = WebUtils.parseInt(request.getParameter("min"),0);
        Integer max = WebUtils.parseInt(request.getParameter("max"),Integer.MAX_VALUE);

        //2.调用bookService.pageByPrice()方法处理分页逻辑
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);

        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");

        //如果用户输入了最小的值，就追加到url中
        if(request.getParameter("min") != null){
            sb.append("&min=").append(request.getParameter("min"));
        }
        //同理，如果用户输入了最大的值，也追加到url中
        if(request.getParameter("max") != null){
            sb.append("&max=").append(request.getParameter("max"));
        }

        //最后再设置url
        page.setUrl(sb.toString());

        //3.将page对象保存为request域对象
        request.setAttribute("page",page);

        //4.请求转发
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);

    }


}
