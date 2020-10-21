<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <%@ include file="/pages/commons/header.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("a.deletaA").click(function () {
                return confirm("你确定要删除" + $(this).parent().parent().find("td:first").text() + "吗？");
            })
        })
    </script>

</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">图书管理系统</span>
    <%@ include file="/pages/commons/manager_menu.jsp" %>

</div>

<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>

        <c:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="manager/bookServlet?action=getBook&id=${book.id}">修改</a></td>
                <td><a class="deletaA" href="manager/bookServlet?action=delete&id=${book.id}">删除</a></td>

            </tr>
        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
        </tr>
    </table>

    <div id="page_nav">
        <%--不是第一页，才显示首页和上一页，否则隐藏--%>
        <c:if test="${requestScope.page.pageNo > 1}">
            <a href="manager/bookServlet?action=page&pageNo=1">首页</a>
            <a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo-1}">上一页</a>
        </c:if>
        <%--
                    <a href="#">首页</a>
                    <a href="#">上一页</a>
        --%>

        <c:choose>

            <%--情况一：如果总页码小于等于5，则：页码的范围是1到总页码--%>
            <c:when test="${requestScope.page.pageTotal <= 5}">
                <c:forEach begin="1" end="${requestScope.page.pageTotal}" var="i">
                    <c:if test="${i == requestScope.page.pageNo}">
                        【${i}】
                    </c:if>
                    <c:if test="${i != requestScope.page.pageNo}">
                        <a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
                    </c:if>
                </c:forEach>
            </c:when>

            <%--情况二：如果总页码大于5，假设为10页--%>
            <c:when test="${requestScope.page.pageTotal > 5}">
                <c:choose>

                    <%--如果当前页码为前三个，1，2，3，则：页码范围是1到--%>
                    <c:when test="${requestScope.page.pageNo <= 3}">
                        <c:forEach begin="1" end="5" var="i">
                            <c:if test="${i == requestScope.page.pageNo}">
                                【${i}】
                            </c:if>
                            <c:if test="${i != requestScope.page.pageNo}">
                                <a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
                            </c:if>
                        </c:forEach>
                    </c:when>

                    <%--如果当前页码为最后三个，8，9，10，则：页码范围是总页码-4到总页码--%>
                    <c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal - 3}">
                        <c:forEach begin="${requestScope.page.pageTotal-4}" end="${requestScope.page.pageTotal}" var="i">
                            <c:if test="${i == requestScope.page.pageNo}">
                                【${i}】
                            </c:if>
                            <c:if test="${i != requestScope.page.pageNo}">
                                <a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
                            </c:if>
                        </c:forEach>
                    </c:when>

                    <%--情况三：剩余的情况为中间4，5，6，7，则：页码范围是当前页码-2到当前页码+2--%>
                    <c:otherwise>
                        <c:forEach begin="${requestScope.page.pageNo-2}" end="${requestScope.page.pageNo+2}" var="i">
                            <c:if test="${i == requestScope.page.pageNo}">
                                【${i}】
                            </c:if>
                            <c:if test="${i != requestScope.page.pageNo}">
                                <a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
                            </c:if>
                        </c:forEach>
                    </c:otherwise>

                </c:choose>

            </c:when>

        </c:choose>

        <%--不是最后一页 ，才显示末页和下一页，否则隐藏--%>
        <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
            <a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo+1}">下一页</a>
            <a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageTotal}">末页</a>
        </c:if>
        <a href="#">下一页</a>
        <a href="#">末页</a>

        共${requestScope.page.pageTotal}页，${requestScope.page.pageCount}条记录 跳到第
        <input value="${pageScope.page.pageNo}" name="pn" id="pn_input">页
        <input type="button" id="gotoPageNo" value="确定">

        <script type="text/javascript">
            $(function () {
                //给跳转到指定页面的按钮，绑定单击事件
                $("#gotoPageNo").click(function () {
                    //获取输入框中用户输入的页码的值
                    var pageNo = $("#pn_input").val();
                    //使用正则表达式，验证里面的内容必须是数字
                    var pageNoPatt = /^[0-9]*$/
                    //用test()方法判断是否合法
                    var flag = pageNoPatt.test(pageNo);
                    //如果数据不合法，提示用户，并阻止表单提交
                    if (!flag) {
                        alert("输入的页码格式不正确")
                        return false;
                    }
                    //再比较，输入的数字不能小于1，或者大于总页码pageTotal
                    var pageTotal = ${requestScope.page.pageTotal};
                    if (pageNo >= 1 && pageNo <= pageTotal) {
                        //允许浏览器跳转
                        //在javascript中，提供一个现成的对象，叫location --> 表示浏览器地址栏
                        //这个对象有一个属性是href，表示浏览器栏中的地址
                        //这个href属性，可读，可写
                        location.href = "${basePath}manager/bookServlet?action=page&pageNo=" + pageNo;
                    } else {
                        alert("您输入的内容超出了有效范围，请重新输入")
                    }

                })
            })
        </script>

    </div>

</div>
<%@ include file="/pages/commons/footer.jsp" %>


</body>

</html>