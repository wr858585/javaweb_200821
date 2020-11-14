package com.atguigu.filter;

import com.atguigu.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * /pages/manager/*表示拦截所有manager文件夹下的页面
 * /manager/bookServlet表示拦截BookServlet程序
 * @author oono
 * @date 2020 11 06
 */

/**
 * "/pages/manager/*"表示拦截访问所有在/pages/manager/目录下的所有页面
 * "/manager/bookServlet"表示拦截/manager/目录下的bookServlet程序
 */
@WebFilter(value = {"/pages/manager/*","/manager/bookServlet"})
public class ManagerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //向下强转
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        //获取session中用户的登录信息
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if(user == null){
            httpServletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest,servletResponse);
        } else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
