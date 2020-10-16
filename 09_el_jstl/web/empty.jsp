<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/16
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
//        1 值为null
        request.setAttribute("emptyNull",null);
//        2 值为空串
        request.setAttribute("emptyStr", "");
//        3 值是Object对象类型的数组，并且长度为零
        request.setAttribute("emptyArr",new Object[]{});
//        4 list集合，元素个数为零
        List<String> list = new ArrayList<>();
        request.setAttribute("emptyList",list);
//        5 map集合，元素个数为零
        Map<String,Object> map = new HashMap<>();
//        map.put("girlFrield","古丽娜扎");
        request.setAttribute("emptyMap",map);
    %>
    ${ empty emptyNull } <br>
    ${ empty emptyStr } <br>
    ${ empty emptyArr } <br>
    ${ empty emptyList } <br>
    ${ empty emptyMap } <br>
    <hr>
    ${ 12 == 12 ? "国哥帅呆" : "国哥又骗人" }
</body>
</html>
