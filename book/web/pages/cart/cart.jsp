<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<%@include file="/pages/common/head.jsp"%>
	<script>
		$(function () {
			$(".count_input").change(function () {
				var id = $(this).attr("dataId");
				var count = $(this).val();
				var result = confirm("是否修改"+ $(this).parent().parent().find("td:first").text() +"商品数量");
				if (result) {
					return location.href = "${basePath}cartServlet?action=updateCount&count="+ count +"&id=" + id;
				} else {
					this.value = this.defaultValue;
				}
			})

			$("a.delete_btn").click(function () {
				return confirm("是否要删除"+ $(this).parent().parent().find("td:first").text() +"?");
			})

			$("a.clear_btn").click(function () {
				return confirm("是否要清空购物车?");
			})
		})
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<div>
				<span>欢迎<span class="um_span">韩总</span>光临尚硅谷书城</span>
				<a href="pages/order/order.jsp">我的订单</a>
				<a href="index.jsp">注销</a>&nbsp;&nbsp;
				<a href="index.jsp">返回</a>
			</div>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${empty sessionScope.cart.items}">
				<td colspan="5">暂无购物商品</td>
			</c:if>
			<c:if test="${not empty sessionScope.cart.items}">
				<c:forEach items="${sessionScope.cart.items}" var="item">
					<tr>
						<td>${item.value.name}</td>
						<td><input class="count_input" dataId="${item.value.id}" type="text" value="${item.value.count}"></td>
						<td>${item.value.price}</td>
						<td>${item.value.totalPrice}</td>
						<td><a class="delete_btn" href="cartServlet?action=deleteItem&id=${item.value.id}">删除</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<c:if test="${not empty sessionScope.cart.items && sessionScope.cart.items.length != 0}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span"><a class="clear_btn" href="cartServlet?action=clearItem">清空购物车</a></span>
				<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
			</div>
		</c:if>
	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>