<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Step1:选择你要购买的图书</h4>
	<form action="<%=request.getContextPath() %>/processStep1" method="post">
		<table cellpadding="10" cellspacing="0" border="1 ">
			<tr>
				<td>书名</td>
				<td>购买</td>
			</tr>
			
			<tr>
				<td>Java</td>
				<td><input type="checkbox" name="book" value="Java" /></td>
			</tr>
			
			<tr>
				<td>Oracle</td>
				<td><input type="checkbox" name="book" value="Oracle" /></td>
			</tr>
			
			<tr>
				<td>Struts</td>
				<td><input type="checkbox" name="book" value="Struts" /></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="Submit">
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>