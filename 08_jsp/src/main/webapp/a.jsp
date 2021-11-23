<%--
  Created by IntelliJ IDEA.
  User: 12468
  Date: 2021/11/23
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page
        contentType="text/html;charset=UTF-8"
        language="java"
        errorPage="/error500.jsp"
%>
<!--
    errorPage表示错误后自动跳转去的路径
    这个路径一般是以斜杠打头，他表示请求的地址为http://ip:port/工程路径/
    映射到代码web目录
-->
<html>
<head>
    <title>Title</title>
</head>
<body>
    这是jsp返回的html页面
    <%
        int a = 12 / 0;
    %>
</body>
</html>
