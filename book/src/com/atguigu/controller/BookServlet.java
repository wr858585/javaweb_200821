package com.atguigu.controller;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.impl.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author oono
 * @date 2020 10 19
 */
@WebServlet(value = "/manager/bookServlet")
public class BookServlet extends BaseServlet {

    BookService bookService = new BookServiceImpl();

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //1.获取请求连接，如果有

        //2.调用bookService.queryBooks()查询全部图书
        List<Book> books = bookService.queryBooks();

        //3.保存到Request域中
        request.setAttribute("books",books);

        //4.请求转发到/pages/manager/book_manager.jsp
        //这里由于在request域中保存了数据，所以需要请求转发，把数据一起发过去（都是request.）
        //一般的，如果在有要转发的数据（一般存在request域对象中），则用请求转发；如果不需要，则多用重定向，不容易出问题
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);

    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //1.获取连接的参数，封装为Bean对象
        Book book = WebUtils.copyParam2Bean(new Book(),request.getParameterMap());

        //2.调用BookService.addBook(book)
        bookService.addBook(book);

        //3.重定向到图书列表管理页面/book/manager/bookServlet?action=list
        //这里需要使用重定向，直接跳转回list页面；如果用请求转发则不对，因为页面仍然仍停留在add页面，只是把add的request用post的形式传了一遍
        //所以前者刷新不存在影响，在list页面刷新；后者刷新则是在add页面刷新（因为浏览器地址不会变！），会重复提交表单add
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=list");
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //1.获取请求的参数商品编号，转换为int
        Integer id = WebUtils.parseInt(request.getParameter("id"),0);

        //2.调用bookService.deleteBookById(id)
        bookService.deleteBookById(id);

        //3.重定向到图书列表管理页面list（同样不要用请求转发）
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=list");
    }

    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //1.获取请求的参数商品编号，转换为int
        Integer id = WebUtils.parseInt(request.getParameter("id"),0);

        //2.调用bookService.queryBook()方法先调出来是哪本书
        Book book = bookService.queryBookById(id);

        //3.把书存到request域中
        request.setAttribute("book",book);

        //4.请求转发到pages/manager/book_edit页面
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request,response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //1.获取请求的参数，封装为book对象
        Book book = WebUtils.copyParam2Bean(new Book(),request.getParameterMap());

        //2.调用bookService().update()方法修改图书信息
        bookService.updateBook(book);

        //3.重定向到list页面
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=list");
    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //1.获取请求的参数：pageNo, pageSize
        Integer pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        Integer pageSize = WebUtils.parseInt(request.getParameter("pageSize"),Page.PAGE_SIZE);

        //2.调用bookService.page()方法处理分页逻辑
        Page page = bookService.page(pageNo, pageSize);

        //3.将page对象保存为request域对象
        request.setAttribute("page",page);

        //4.重定向到list页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp");

    }

}
