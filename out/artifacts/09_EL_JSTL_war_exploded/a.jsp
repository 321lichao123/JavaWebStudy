<%--
  Created by IntelliJ IDEA.
  User: 12468
  Date: 2021/11/24
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL_JSTL</title>
</head>
<body>
  <%
      request.setAttribute("key", "值");
  %>
    表达式脚本输出key值是：<%=request.getAttribute("key")%> <br />
    EL表达式输出key的值是：${key} <br />

    ==================如果key不对情况下======================== <br />

    表达式脚本输出key值是：<%=request.getAttribute("key1") == null ? "" : request.getAttribute("key1")%> <br />
    EL表达式输出key的值是：${key1}
</body>
</html>
