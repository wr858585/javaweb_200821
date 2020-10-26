<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <%@ include file="/pages/commons/header.jsp" %>

    <%--给每本书的加入购物车按钮添加单击事件--%>
    <script type="text/javascript">
        $(function () {
            $("button.addItem").click(function () {
                //获取自定以的bookId的属性值
                var bookId = $(this).attr("bookId");
                //发送请求给服务器
                location.href = "${basePath}cartServlet?action=addItem&id=" + bookId;
            })
        })

    </script>

</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">网上书城</span>
    <div>
        <c:if test="${empty sessionScope.user}">
            <a href="pages/user/login.jsp">登录</a>
            <a href="pages/user/regist.jsp">注册</a>
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
            <a href="pages/order/order.jsp">我的订单</a>
            <a href="index.jsp">注销</a>
        </c:if>
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="pages/manager/manager.jsp">后台管理</a>
    </div>
</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="client/bookServlet" method="get">
                <input type="hidden" name="action" value="pageByPrice">
                价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
                <input id="max" type="text" name="max" value="${param.max}"> 元
                <input type="submit" value="查询"/>
            </form>
        </div>

        <%--购物车回显--%>

        <div style="text-align: center">
            <%--购物车是空的的情况--%>
            <c:if test="empty ${sessionScope.cart.items}">
                <span></span>
                <div>
                    <span style="color:red">当前购物车是空的</span>
                </div>
            </c:if>
            <%--购物车有东西的情况--%>
            <c:if test="${not empty sessionScope.cart.items}">
                <span>您的购物车中有${sessionScope.cart.totalCount}件商品</span>
                <div>
                    您刚刚将<span style="color: red">${sessionScope.lastAddedBookName}</span>加入到了购物车中
                </div>
            </c:if>
        </div>

        <%--遍历的开始--%>
        <c:forEach items="${requestScope.page.items}" var="book">

            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="${book.imgPath}"/>
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add">
                        <button bookId="${book.id}" class="addItem">加入购物车</button>
                    </div>
                </div>
            </div>

        </c:forEach>
        <%--遍历的结束--%>

    </div>

    <%--静态包含分页条代码--%>
    <%@ include file="/pages/commons/page_nav.jsp" %>

</div>

<%--静态包含页脚--%>
<%@ include file="/pages/commons/footer.jsp" %>

</body>
</html>
