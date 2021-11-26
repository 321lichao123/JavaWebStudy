<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.atguigu.pojo.Student" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 12468
  Date: 2021/11/26
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        td {
            padding: 10px;
            text-align: center;
        }
    </style>
</head>
<body>
    <%
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            students.add(new Student(i, "name" + i, 18 + i, "phone" + 1));
        }
        request.setAttribute("stds", students);
    %>
    <table border="1" cellspacing="0" cellpadding="0">
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>手机号</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${requestScope.stds}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.age}</td>
                <td>${item.phone}</td>
                <td>编辑、删除</td>
            </tr>
        </c:forEach>
    </table>

<hr />

    <table border="1">
        <c:forEach begin="1" end="10" var="i">
            <tr>
                <td>${i}</td>
            </tr>
        </c:forEach>
    </table>

    <hr />

    <%
        request.setAttribute("arr", new String[]{"15755135890", "15755135891", "15755135892"});
    %>
    <c:forEach items="${requestScope.arr}" var="item">
        ${item}
    </c:forEach>

    <hr />

    <%
        HashMap<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        request.setAttribute("map", map);
    %>

    <c:forEach items="${requestScope.map}" var="entry">
        <h1>${entry.key} -->> ${entry.value}</h1>
    </c:forEach>


</body>
</html>
