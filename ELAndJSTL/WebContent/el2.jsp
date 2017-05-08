<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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

	<!-- 7.EL的关系运算符 -->
	<%
		List<String> names = new ArrayList<String>();
		names.add("aaa");
		request.setAttribute("names", names);
		
	%>
	<!-- empty可以作用于一个集合，若该集合不存在或集合中没有元素，其结果都为true -->
	names is empty:${empty requestScope.names} 
	<br>
	${param.score > 60 ? "及格" : "不及格" }
	
	<!-- 6.其他隐含对象：pageContext等(cookie,header,initParam了解)-->
	pageContext:pageContext即为pageContext类型，但只能读取属性,可以一直.下去
	<br>
	contextPath:${pageContext.request.contextPath }
	<br>
	sessionID:${pageContext.session.id }
	<br>
	sessionAttributeName:${pageContext.session.attributeNames }
	<br>
	JSESSIONID:${cookie.JSESSIONID.name }--${cookie.JSESSIONID.value }
	<br>
	Accept-Encoding:${header["Accept-Encoding"]}
	<br>
	init:${initParam.init }
	<br>
	<!-- 5.与输入有关的隐含对象：param,paramValues -->
	names:${paramValues.name[0].class.name }
	
	<%--<%=request.getParameterValues("name")[0].getClass().getName()%>--%>
	
	score:${param.score }
	<%-- <%=request.getParameter("score")%> --%>
	<br>
	<!-- 4.隐含对象之与范围相关的：pageScope,requestScope,sessionScope,applicationScope -->
	time:${applicationScope.time.time}
	<br>
	<%--time:<%=application.getAttribute("time")%> --%>
	<br>
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