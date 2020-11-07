<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的订单</title>
    <%@ include file="/pages/commons/header.jsp" %>

    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif">
    <span class="wel_word">我的订单</span>
    <%@ include file="/pages/commons/login_success_menu.jsp" %>

</div>

<div id="main">

    <table>
        <tr>
            <td>日期</td>
            <td>金额</td>
            <td>状态</td>
            <td colspan="2">操作</td>
        </tr>

        <tr>
            <c:forEach items="${requestScope.orders}" var="order">
        <tr>
            <td>${order.createTime}</td>
            <td>${order.price}</td>
            <c:choose>
                <c:when test="${order.status == 0}">
                    <td>未发货</td>
                </c:when>
                <c:when test="${order.status == 1}">
                    <td>已发货</td>
                </c:when>
                <c:otherwise>
                    <td>已收货</td>
                </c:otherwise>
            </c:choose>
            <td><a href="orderServlet?action=orderDetails&orderId=${order.orderId}">查看详情</a></td>
            <td><a href="orderServlet?action=receiveOrder&orderId=${order.orderId}">确认收货</a></td>
        </tr>
        </c:forEach>
        </tr>
    </table>


</div>
<%@ include file="/pages/commons/footer.jsp" %>


</body>
</html>