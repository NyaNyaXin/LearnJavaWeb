<%@page import="com.cx.javaweb.bean.Customer"%>
<%@page import="java.util.ArrayList"%>
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
		//模拟Servlet中的操作
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(1,11,"chen"));
		customers.add(new Customer(2,12,"xin"));
		customers.add(new Customer(3,13,"ding"));
		customers.add(new Customer(4,14,"jian"));
		customers.add(new Customer(5,15,"hui"));
		
		request.setAttribute("customers", customers);
	%>
	
	
	<jsp:forward page="testtag.jsp"></jsp:forward>
</body>
</html>