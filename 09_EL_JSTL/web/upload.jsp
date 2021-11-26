<%--
  Created by IntelliJ IDEA.
  User: 12468
  Date: 2021/11/26
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="uploadServlet" method="post" enctype="multipart/form-data">
        用户名： <input type="text" name="username"> <br>
        头像 <input type="file" name="photo"> <br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
