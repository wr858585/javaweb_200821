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
    <span class="wel_word">订单详情</span>
    <%@ include file="/pages/commons/manager_menu.jsp" %>

</div>

<div id="main">
    <table>
        <div style="font-size: large;color: #39987c">${requestScope.orderId}</div>
        <tr>
            <td>书名</td>
            <td>价格</td>
            <td>数量</td>
            <td>总价</td>

        </tr>
        <tr>
            <c:forEach items="${requestScope.orderItems}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.price}</td>
                <td>${item.count}</td>
                <td>${item.totalPrice}</td>
            </tr>
             </c:forEach>
        </tr>

    </table>
</div>
<%@ include file="/pages/commons/footer.jsp" %>


</body>
</html>