<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="el.jsp" method="post">
		username:<input type="text" name="username"
			value="<%=request.getParameter("username") == null ? "" : request.getParameter("username")%>" />
		username:<input type="text" name="username"
			value="${param.username}" />
		<input type="submit" value="Submit" />
	</form>
	username:<%=request.getParameter("username")%>
	
	<jsp:useBean id="customer" class="com.cx.javaweb.bean.Customer" scope="session"></jsp:useBean>
	<jsp:setProperty property="name" name="customer" value="chenxin"/>
	<br>
	name:<jsp:getProperty property="name" name="customer"/>
	
	<br>
	<a href="el2.jsp?score=89">To el2.jsp</a>
</body>
</html>