<%@page import="com.cx.javaweb.mvc.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Student> students = (List<Student>) request.getAttribute("students");
	%>

	<table border="1px" cellpadding="10" cellspacing="0" align="center">
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Password</th>
			<th>Balance</th>
			<th>Delete</th>
		</tr>
		<%
			for (Student student : students) {
		%>
		<tr>
			<td><%= student.getId() %></td>
			<td><%= student.getUserName() %></td>
			<td><%= student.getPassWord() %></td>
			<td><%= student.getBalance() %></td>
			<td><a href="deleteStudent?id=<%=student.getId()%>">Delete</a> </td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>