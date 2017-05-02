<%@page import="java.util.Date"%>
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
		Date date = new Date();
		//System.out.println(date);
	%>
	<%
		String str = date.toString();
		//没有声明就可以使用的对象
		String name = request.getParameter("name");
		System.out.println(name);
		Class clazz = response.getClass();
		System.out.println(clazz);
		
		ServletRequest request2 = pageContext.getRequest();
		System.out.println(request==request2);
		
		System.out.println(session.getId());
		System.out.println(application.getInitParameter("user"));
		
		System.out.println(config.getInitParameter("test"));
		out.println(request.getParameter("name"));
		out.println("<br/>");
		out.println(application.getInitParameter("user"));
		
		out.println(this);
		out.println(page);
		
		
	%>
</body>
</html>