<%--
  Created by IntelliJ IDEA.
  User: 12468
  Date: 2021/12/9
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        System.out.println("执行a.jsp页面");
        Object user = session.getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
    %>
    这是admin目录的a.jsp页面
</body>
</html>