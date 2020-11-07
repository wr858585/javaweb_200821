<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单管理</title>
    <%@ include file="/pages/commons/header.jsp" %>

</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif">
    <span class="wel_word">订单管理系统</span>
    <%@ include file="/pages/commons/manager_menu.jsp" %>

</div>

<div id="main">
    <table>
        <tr>
            <td>日期</td>
            <td>用户ID</td>
            <td>订单ID</td>
            <td>金额</td>
            <td>状态</td>
            <td>操作</td>

        </tr>
        <tr>
            <c:forEach items="${requestScope.orders}" var="order">
        <tr>
            <td>${order.createTime}</td>
            <td>${order.userId}</td>
            <td>${order.orderId}</td>
            <td>${order.price}</td>
            <td>${order.status}</td>
            <td><a href="orderServlet?action=sendOrder&orderId=${order.orderId}">发货</a></td>
        </tr>
        </c:forEach>
        </tr>

    </table>
</div>
<%@ include file="/pages/commons/footer.jsp" %>


</body>
</html>