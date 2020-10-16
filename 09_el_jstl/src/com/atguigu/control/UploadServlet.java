package com.atguigu.control;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author oono
 * @date 2020 10 16
 */
@WebServlet(value = "/uploadServlet")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.首先，需要创建ServletFileUpload所需参数FileItemFactory资源类对象，它是接口，用唯一的实现类DiskFileItemFactory
        FileItemFactory fileItemFactory = new DiskFileItemFactory();
        //2.创建用于解析user上传数据的工具类 --> ServletFileUpload
        ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
        //3.判断是否有上传文件（上传文件的表单类型是type="multipart/form-data")
        servletFileUpload.setHeaderEncoding("UTF-8");
        if(ServletFileUpload.isMultipartContent(request)){
            //4.再把上传内容解析成FileItem，装到list中
            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);
                System.out.println("表单项个数：" + list.size());
                for (FileItem item : list) {
                    if(item.isFormField()){
                        System.out.println("表单名：" + item.getFieldName());
                        System.out.println("用户名：" + item.getString("UTF-8"));
                    } else{
                        System.out.println("上传了：" + item.getName());
                        item.write(new File("D:/" + item.getName()));
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
