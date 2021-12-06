<%--
  Created by IntelliJ IDEA.
  User: 12468
  Date: 2021/12/6
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="loginServlet" method="get">
        用户名： <input type="text" name="username" value="${cookie.username.value}" /> <br>
        密   码： <input type="password" name="password" /> <br>
        <input type="submit" value="登录" />
    </form>
</body>
</html>
