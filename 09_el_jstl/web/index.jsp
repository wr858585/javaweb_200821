<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/16
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>我是可爱滴上传页面</title>
  </head>
  <body>
  <form action="uploadServlet" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="username"><br/>
    选择文件：<input type="file" name="userUpload"><br/>
    <input type="submit" value="上传">
  </form>
  </body>
</html>
