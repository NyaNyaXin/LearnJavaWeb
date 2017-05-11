<%@page import="java.util.Date"%>
<%@page import="com.cx.javaweb.entities.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>HttpSessionBindingListener</h4>
	<%--
		Customer customer = new Customer();
		session.setAttribute("customer", customer);
		System.out.println("------------------------------");
		session.removeAttribute("customer");
	--%>
	
	<%
		Customer customer = (Customer)session.getAttribute("customer");
		if(customer==null){
			customer = new Customer();
			customer.setTime(""+new Date());
			session.setAttribute("customer", customer);
			System.out.println("创建一个新的Customer对象:"+customer+"，并放入到session中");
		}else{
			System.out.println("从session中读取到customer对象"+customer);
		}
	%>
</body>
</html>