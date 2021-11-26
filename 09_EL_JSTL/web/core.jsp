<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 12468
  Date: 2021/11/26
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
        <c:set>的使用
            域对象.setAttribute(key, value);
            scope属性表示设置保存到那个域
                page表示pageContext域(默认值)
                request表示Request域
                session表示Session域
                application表示ServletContext域
            var属性设置key值
            value属性设置值

    --%>

    保存之前：${sessionScope.abc} <br>
    <c:set scope="session" var="abc" value="abcValue"></c:set>
    保存之后：${sessionScope.abc} <br>

    <%--
        <c:if></c:if用于条件判断
            test属性表示判断的条件(使用EL表达式输出)
    --%>

    <hr />

    <c:if test="<%=12 == 12%>">
        v-if的标签
    </c:if>

    <hr />

    <%
        request.setAttribute("height", 198);
    %>
    <c:choose>
        <c:when test="${requestScope.height > 190}">
            <h1>小巨人</h1>
        </c:when>
        <c:when test="${requestScope.height > 180}">
            <h1>很高</h1>
        </c:when>
        <c:when test="${requestScope.height > 170}">
            <h1>比较高</h1>
        </c:when>
        <c:otherwise>
            <h1>小于170的情况</h1>
        </c:otherwise>
    </c:choose>
</body>
</html>
