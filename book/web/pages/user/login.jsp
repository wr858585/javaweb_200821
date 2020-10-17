<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/pages/commons/header.jsp"%>
<%@ include file="/pages/commons/footer.jsp"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员登录页面</title>
    <script type="text/javascript">

        $(function () {

            //注册按钮单击事件
            $("#sub_btn").click(function () {

                //获取用户名输入框的值
                var usernameText = $(":text[name='username']").val();
                // usernameText = usernameText.trim();反而不能加，空格是非法字符

                //获取密码输入框的值
                var passwordText = $(":password[name='password']").val();
                // passwordText = passwordText.trim();

                // alert(usernameText);
                // alert(passwordText);

                if(usernameText == ""){
                    $(".errorMsg").text("用户名不能为空");
                    return false;
                }
                if(passwordText == ""){
                    $(".errorMsg").text("密码不能位空");
                    return false;
                }

                //正则表达
                var uniPatt = /^\w{5,12}$/;

                //test()来判断是否合法
                var flag1 = uniPatt.test(usernameText);
                if(!flag1){
                    $(".errorMsg").text("用户名不合法");
                    return false;
                }

                var flag2 = uniPatt.test(passwordText);
                if(!flag2){
                    $(".errorMsg").text("密码不合法");
                    return false;
                }

                //重置errorMsg信息
                $(".errorMsg").text("");

            })

        })

    </script>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>尚硅谷会员</h1>
                    <a href="pages/user/regist.jsp">立即注册</a>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">
                        <%=request.getAttribute("msg") == null? "请输入用户名和密码" : request.getAttribute("msg")%>
                    </span>
                </div>
                <div class="form">
                    <form action="loginServlet" method="post">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username"
                               value="<%=request.getAttribute("username") == null? "" : request.getAttribute("username")%>"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password"/>
                        <br/>
                        <br/>
                        <input type="submit" value="登录" id="sub_btn"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>

</body>
</html>