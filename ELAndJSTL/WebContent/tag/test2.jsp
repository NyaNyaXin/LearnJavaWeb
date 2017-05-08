<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cx.javaweb.tag.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.cx.com/mytag2/core" prefix="cx"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<cx:testJspFragment>Hello:${param.name}</cx:testJspFragment>
	<br>
	<cx:printUpperTag time="10">chenxin</cx:printUpperTag>
	<br>
	<%
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(1,"AAA"));
		customers.add(new Customer(2,"BBB"));
		customers.add(new Customer(3,"CCC"));
		customers.add(new Customer(4,"DDD"));
		customers.add(new Customer(5,"EEE"));
		customers.add(new Customer(6,"FFF"));
		
		request.setAttribute("customers", customers);
		
		Map<String,Customer> customerMap = new HashMap<String,Customer>();
		customerMap.put("a", customers.get(0));
		customerMap.put("b", customers.get(1));
		customerMap.put("c", customers.get(2));
		customerMap.put("d", customers.get(3));
		customerMap.put("e", customers.get(4));
		customerMap.put("f", customers.get(5));
		
		request.setAttribute("customerMap", customerMap);
		
		
	%>
	<br>
	<c:forEach items="${requestScope.customerMap }" var="cust">
		${pageScope.cust.key } -- ${cust.value.id} --${cust.value.name}<br>
	</c:forEach>
	<br>
	<cx:forEachTag items="${requestScope.customers }" var="cust">
		${pageScope.cust.id } -- ${cust.name}<br> 
	</cx:forEachTag>
	<br>
	<!-- 父标签打印name值到控制台 -->
	<cx:parentTag>
		<!-- 子标签以父标签的标签体的形式存在， 子标签把父标签的name属性打印到jsp页面上 -->
		<cx:sonTag/>
	</cx:parentTag>
	<br>
	
	<c:choose>
	 	<c:when test="${param.age>24}">大学毕业</c:when>
	 	<c:when test="${param.age>20}">高中毕业</c:when>
	 	<c:otherwise>高中以下。。。。</c:otherwise>
	</c:choose>
</body>
</html>