<%--
  Created by IntelliJ IDEA.
  User: 12468
  Date: 2021/11/26
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%=request.getscheme()%>
    1、协议：${pageContext.request.scheme} <br />
    2、服务器ip：${pageContext.request.saverName} <br />
</body>
</html>
