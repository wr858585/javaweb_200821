<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/pages/commons/header.jsp"%>
<%@ include file="/pages/commons/footer.jsp"%>
<%@ include file="/pages/commons/login_success.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<base href="http://localhost:8080/BookStore02/">
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>

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
			<tr>
				<td>时间简史</td>
				<td>2</td>
				<td>30.00</td>
				<td>60.00</td>
				<td><a href="#">删除</a></td>
			</tr>	
			
			<tr>
				<td>母猪的产后护理</td>
				<td>1</td>
				<td>10.00</td>
				<td>10.00</td>
				<td><a href="#">删除</a></td>
			</tr>	
			
			<tr>
				<td>百年孤独</td>
				<td>1</td>
				<td>20.00</td>
				<td>20.00</td>
				<td><a href="#">删除</a></td>
			</tr>		
			
		</table>
		
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">4</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">90.00</span>元</span>
			<span class="cart_span"><a href="#">清空购物车</a></span>
			<span class="cart_span"><a href="pages/cart/checkout.jsp">去结账</a></span>
		</div>
	
	</div>
	

</body>
</html>