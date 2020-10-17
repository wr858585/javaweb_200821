package com.atguigu.control;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author oono
 * @date 2020 10 17
 */
@WebServlet(value = "/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取下载请求的文件参数
        //也可以用request.getParameter("");从别的地方获取
        String filename = "1.jpg";

        ServletContext servletContext = getServletContext();

        //4.告诉客户端这是什么类型的数据
        String mimeType = servletContext.getMimeType(filename);
        System.out.println("mimeType --> " + mimeType);
        response.setContentType(mimeType);

        //5.通过设置响应头，告诉客户端收到的数据，用于客户端下载
        response.setHeader("Content-Disposition","attachement; filename=" + filename);

        //2.读取要下载的文件内容
        InputStream is = servletContext.getResourceAsStream("/file/" + filename);

        //3.通过响应流回传给客户端
        ServletOutputStream os = response.getOutputStream();

        //把输入流中的数据，原封不动的写给输出流
        IOUtils.copy(is,os);
        os.close();


    }
}
