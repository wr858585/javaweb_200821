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
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("key","data");
%>
jsp表达式脚本输出：<%=request.getAttribute("key")==null?"":request.getAttribute("key")%> <br>
el表达式：${key} <br>
</body>
</html>
