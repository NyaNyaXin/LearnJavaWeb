<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>bbb page</h4>
	<%
		//1.请求转发的代码
		//request.getRequestDispatcher("/c.jsp").forward(request, response);
		//2.请求的重定向
		response.sendRedirect("c.jsp");
		//response.sendRedirect("http://www.baidu.com");
	%>
</body>
</html>