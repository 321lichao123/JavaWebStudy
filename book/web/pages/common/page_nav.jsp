<%--
  Created by IntelliJ IDEA.
  User: 12468
  Date: 2021/12/5
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.pageNo - 1}">上一页</a>
    </c:if>
    <%-- 页码输出的开始 --%>
    <c:choose>
        <%-- 情况1：如果总页码小于等于5的情况，页码的范围是：1到总页码 --%>
        <c:when test="${requestScope.page.pageTotal <= 5}">
            <c:forEach begin="1" end="${requestScope.page.pageTotal}" var="i">
                <c:if test="${i == requestScope.page.pageNo}">
                    【${i}】
                </c:if>
                <c:if test="${i != requestScope.page.pageNo}">
                    <a href="${requestScope.page.url}&pageNo=${i}&pageSize=${requestScope.page.pageSize}">${i}</a>
                </c:if>
            </c:forEach>
        </c:when>
        <%-- 情况2：总页码大于5的情况 --%>
        <c:when test="${requestScope.page.pageTotal > 5}">
            <c:choose>
                <c:when test="${requestScope.page.pageNo <= 3}">
                    <c:set var="begin" value="1"></c:set>
                    <c:set var="end" value="5"></c:set>
                </c:when>
                <c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal - 3}">
                    <c:set var="begin" value="${requestScope.page.pageTotal - 4}"></c:set>
                    <c:set var="end" value="${requestScope.page.pageTotal}"></c:set>
                </c:when>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageTotal - 2}"></c:set>
                    <c:set var="end" value="${requestScope.page.pageTotal + 2}"></c:set>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>
    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i == requestScope.page.pageNo}">
            【${i}】
        </c:if>
        <c:if test="${i != requestScope.page.pageNo}">
            <a href="${requestScope.page.url}&pageNo=${i}&pageSize=${requestScope.page.pageSize}">${i}</a>
        </c:if>
    </c:forEach>
    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo + 1}&pageSize=${requestScope.page.pageSize}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}&pageSize=${requestScope.page.pageSize}">末页</a>
    </c:if>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录 到第<input min="1" max="${requestScope.page.pageTotal}" value="${param.pageNo}" name="pn" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">
    <script>
        $(function () {
            $("#searchPageBtn").click(function () {
                var pageNo = $("#pn_input").val();
                var pageTotal = ${requestScope.page.pageTotal}
                if (pageNo < 1) {
                    pageNo = 1;
                } else if(pageNo > pageTotal) {
                    pageNo = pageTotal;
                }
                location.href = "${pageScope.basePath}${requestScope.page.url}&pageNo="+ pageNo+"&pageSize=4"
            })
        })
    </script>
</div>
