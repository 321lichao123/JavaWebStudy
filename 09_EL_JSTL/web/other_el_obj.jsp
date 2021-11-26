<%--
  Created by IntelliJ IDEA.
  User: 12468
  Date: 2021/11/26
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${param} <br>
    获取username的值：${param.username}  <br>
    获取password的值：${param.password}  <br>
    ${paramValues} <br>

    获取多参数的hobby的值： ${paramValues.hobby[0]}

    <hr>

    获取头部信息：${header["user-agent"]} <br>
    获取头部信息：${headerValues["user-agent"][0]}

    <hr>
    获取cookie的key信息：${cookie.JSESSIONID.name} <br>
    获取cookie的value信息：${cookie.JSESSIONID.value}
</body>
</html>
