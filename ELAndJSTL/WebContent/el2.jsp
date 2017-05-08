<%@page import="com.cx.javaweb.bean.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 3.EL可以进行自动的类型转化 -->
	score:${param.score+11}
	<br>
	<!-- 2.El中的隐含对象 -->
	<%
		Customer cus2 = new Customer();
		cus2.setAge(28);
		request.setAttribute("cus2", cus2);
	%>
	
	<!-- 1.El中的.或[]运算符 -->
	name:${cus2.age }
	<br>
	name:${sessionScope.customer["name"] }
	<%--
		Customer customer = (Customer)session.getAttribute("customer");
		out.print(customer.getName());
	--%>
	
	<%
		Customer customer  = new Customer();
		customer.setName("chenxin");
		
		session.setAttribute("com.cx.customer", customer);
	%>
	
	<br>
	<!-- 
		如果域对象中的属性名带有特殊字符，则使用[]运算符会很方便
	 -->
	name:${sessionScope["com.cx.customer"].name }
</body>
</html>