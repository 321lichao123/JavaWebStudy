<%--
  Created by IntelliJ IDEA.
  User: 12468
  Date: 2021/11/29
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!--
1、base一般写在title下面
2、写base标签，永远固定相对路径跳转的结果
3、写base路径，一般都要修改静态资源的路径，因为base路径是相对于web工程的路径
-->
<%
    String basePath = request.getScheme() +
            "://" + request.getServerName() +
            ":" + request.getServerPort() +
                 request.getContextPath() +
            "/";
%>

<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
