<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<%@ include file="/pages/commons/header.jsp"%>


	<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}

	h1 a {
		color:red;
	}
</style>
</head>
<body>
		<div id="header">
				<img class="logo_img" alt="" src="static/img/logo.gif" >
				<span class="wel_word"></span>
			<%@ include file="/pages/commons/login_success_menu.jsp"%>

		</div>

		<div id="main">

			<h1>注册成功! <a href="../../index1.jsp">转到主页</a></h1>

		</div>
		<%@ include file="/pages/commons/footer.jsp"%>


</body>
</html>