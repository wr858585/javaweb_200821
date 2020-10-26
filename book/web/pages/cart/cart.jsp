<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%@ include file="/pages/commons/header.jsp"%>

	<script type="text/javascript">
		$(function () {

			//给删除按钮增加单击事件
			$("a.deleteItem").click(function () {
				//在事件响应的function函数中，有一个this对象，它相当于当前正在响应事件的dom对象
				return confirm("你确定要删除" + $(this).parent().parent().find("td:first").text() + "商品吗？");
			})

			//清空购物车单击事件
			$("#clearCart").click(function () {
				return confirm("你确定清空购物车吗？")
			})

			//给用户自己更改商品数量的input添加改变内容事件！而非单击事件
			$("input.updateCountInput").change(function () {

				//1.获取信息
				var name = $(this).parent().parent().find("td:first").text();
				var count = this.value;
				var id = $(this).attr("bookId");

				//2.提示用户，是否确认修改
				if(confirm("你确定要将【" + name + "】的数量修改为" + count + "吗？")){
					//如果用户点击确定，则confirm()方法会返回true，继续执行下面代码
					//发请求给服务器确认修改
					location.href = "${basePath}cartServlet?action=updateCount&id=" + id + "&count=" + count;
				} else{
					//用户取消操作，返回原数量
					//.defaultValue是dom对象的一个属性，表示默认值
					this.value = this.defaultValue;
				}

			})
		})
	</script>


</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
		<%@ include file="/pages/commons/login_success_menu.jsp"%>

	</div>

	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>

			<%--如果购物车非空，就显示其商品--%>

			<c:if test="${not empty sessionScope.cart.items}">
				<c:forEach items="${sessionScope.cart.items}" var="entry">
					<tr>
						<td>${entry.value.name}</td>
						<td>${entry.value.price}</td>
						<td>
							<%--修改成为：让用户自己去修改商品数量的input标签--%>
							<input type="text" value="${entry.value.count}" bookId="${entry.value.id}"
								   style="width:60px;" class="updateCountInput">
						</td>
						<td>${entry.value.totalPrice}</td>
						<td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
					</tr>
				</c:forEach>
			</c:if>

			<%--如果购物车是空的，就显示 当前购物车是空的 --%>
			<c:if test="${empty sessionScope.cart.items}">
				<tr>
					<td colspan="5"><a href="index.jsp">当前购物车是空滴，去首页看看吧O(∩_∩)O</a></td>
				</tr>
			</c:if>
			
		</table>

		<%--购物车要非空才能显示--%>

		<c:if test="${not empty sessionScope.cart.items}">

		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
			<span class="cart_span"><a href="cartServlet?action=clear" id="clearCart">清空购物车</a></span>
			<span class="cart_span"><a href="pages/cart/checkout.jsp">去结账</a></span>
		</div>

		</c:if>

	</div>
	<%@ include file="/pages/commons/footer.jsp"%>


</body>
</html>