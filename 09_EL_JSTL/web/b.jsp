<%--
  Created by IntelliJ IDEA.
  User: 12468
  Date: 2021/11/24
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
      // 往四个域中都保存相同的key的数据
    pageContext.setAttribute("key", "pageContext");
    request.setAttribute("key", "request");
    session.setAttribute("key", "session");
    application.setAttribute("key", "application");
  %>

    ${key}
</body>
</html>
