<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
<%@include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>
			<%@include file="/pages/common/manager_menu.jsp"%>requestScope
		</div>
		
		<div id="main">
			<form action="manager/bookServlet" method="get">
				<input type="hidden" name="action" value="${param.method}" />
				<table>
					<tr>
						<td style="display: none;">id</td>
						<td>名称</td>
						<td>作者</td>
						<td>价格</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>
					<tr>
						<td style="display: none;"><input name="id" type="text" value="${requestScope.book.id}" /></td>
						<td><input name="name" type="text" value="${requestScope.book.name}" /></td>
						<td><input name="author" type="text" value="${requestScope.book.author}" /></td>
						<td><input name="price" type="text" value="${requestScope.book.price}" /></td>
						<td><input name="sales" type="text" value="${requestScope.book.sales}" /></td>
						<td><input name="stock" type="text"value="${requestScope.book.stock}" /></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>

		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>