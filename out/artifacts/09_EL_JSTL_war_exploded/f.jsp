<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 12468
  Date: 2021/11/25
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        HashMap<String, Object> map = new HashMap<>();
        map.put("aaa", "aaaValue");
        map.put("b.b.b", "bbbValue");
        map.put("c+c+c", "cccValue");
    %>
    ${map.aaa}
    ${map["b.b.b"]}
    ${map["c+c+c"]}
</body>
</html>
