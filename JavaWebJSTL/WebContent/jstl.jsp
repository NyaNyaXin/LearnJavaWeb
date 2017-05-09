<%@page import="com.cx.javaweb.entities.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>c:out:可以对特殊字符进行转换</h4>
	<%
		request.setAttribute("book", "<<Java>>");
	%>
	<c:out value="${requestScope.book2}" default="bookTitle"></c:out>
	<br>
	
	<h4>c:set:可以为域对象的属性赋值，value属性支持EL表达式，还可以为域对象中的JavaBean属性赋值，target和value属性都支持EL表达式</h4>
	<c:set var="name" value="chenxin" scope="page"></c:set>
	<%--
		pageContext.setAttribute("name", "chenxin");
	--%>
	name:${pageScope.name}
	<br>
	<%
		Customer cust = new Customer();
		cust.setId(1001);
		request.setAttribute("cust", cust);
	%>
	ID：${requestScope.cust.id }
	<c:set target="${requestScope.cust }" property="id" value="${param.id }"></c:set>
	<br>
	ID：${requestScope.cust.id }
	
	<h4>c:remove： 移除指定域对象的指定属性</h4>
	<c:set value="1922-12-12" var="date" scope="session"></c:set>
	Date:${sessionScope.date }
	<br>
	<c:remove var="date" scope="session"/>
	Date:${sessionScope.date }  
	<br>
	 
	<h4>c:if：不能实现else操作，但可以把判断的结果储存起来,已被之后使用</h4>
	<c:set value="20" var="age" scope="request"></c:set>
	<c:if test="${requestScope.age>18}">成年了</c:if>
	<br>
	<c:if test="${requestScope.age>18}" var="isAdult" scope="session"></c:if>
	isAdult:${sessionScope.isAdult}
	<br>
	
	<h4>
		c:choose,c:when,c:otherwise:可以实现"if...else if...else..."的效果。但较为麻烦<br>
		其中c:choose以c:when和c:otherwise的父标签出现，<br>
		c:when和c:otherwise不能脱离父标签c:choose而单独使用<br>
		c:otherwise必须在c:when之后使用<br>
	</h4>
	<c:choose>
		<c:when test="${param.age>60}">老年</c:when>
		<c:when test="${param.age>40}">中年</c:when>
		<c:when test="${param.age>18}">成年</c:when>
		<c:otherwise>未成年</c:otherwise>
	</c:choose>
</body>
</html>