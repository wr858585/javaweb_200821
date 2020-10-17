
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //如何动态获取用户输入的地址（全路径），如http://127.0.0.1:8080/book/。否则静态获取的是http://localhost:8080/book/
    //静态的获取地址会导致访问的是用户自己电脑上的资源，则显然没有！应该访问服务器上面的资源，所以需要动态获取用户输入的路径
    //1.先获取用户输入的request中的协议 --> 用request.getScheme()方法
    //2.再写上://
    //3.再获取服务器的ip地址 --> 用request.getServerName()方法
    //4.再写上:
    //5.再获取服务器的端口号 --> 用request.getServerPort()方法
    //6.再获取工程路径 --> 用request.getContextPath()方法
    //7.最后一定要家上/

    String basePath = request.getScheme()
                    + "://"
                    + request.getServerName()
                    + ":"
                    + request.getServerPort()
                    + request.getContextPath()
                    + "/";

    //获取到basePath后，别忘记pageContext上下文对象中去设置这样一个basePath变量！否则获取之后没有操作，没有意义
    //相当于把从request中获取到的信息存储到了域对象pageContext中[pageContext,request,session,application]
    //之后再用EL表达式轻松获取（EL表达式的作用就是输出域对象中存储的数据！）
    //格式为：${key} --> key为
    pageContext.setAttribute("basepath",basePath);
%>

<base href="${basePath}">

<link type="text/css" rel="stylesheet" href="static/css/style.css" >

<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>