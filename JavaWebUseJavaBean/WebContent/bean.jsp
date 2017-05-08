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
	<jsp:useBean id="customer" class="com.cx.javaweb.bean.Customer"
		scope="request"></jsp:useBean>
	<%--
		//1.从scope(session)获取id(customer)属性值,赋给class(com.cx.javaweb.bean.Customer)类型的id(customer)变量
		Customer customer2 = (Customer)session.getAttribute("customer");
		//2.若属性值为空则利用反射创建一个新的对象，把该对象赋给id，并以id为属性名放入到scope中
		if(customer2==null){
			customer2 = (Customer)Class.forName("com.cx.javaweb.bean.Customer").newInstance();
			session.setAttribute("customer2", customer2);
		}
	--%>
	<jsp:useBean id="customer2" beanName="com.cx.javaweb.bean.Customer"
		type="java.lang.Object" scope="request"></jsp:useBean>
	<%--
		Object customer3 = request.getAttribute("customer3");
		if(customer3==null){
			customer3=Class.forName("com.cx.javaweb.bean.Customer").newInstance();
			request.setAttribute("customer3", customer3);
		}
	--%>

	<!-- 若property的值为*，省略value属性，将自动为所有属性赋值为对应的请求参数的值 -->
	<jsp:setProperty property="*" name="customer" />
	<%--
	<jsp:setProperty property="name" value="dingjianhui" name="customer"/>
	 --%>
	<br>
	<%--
		customer.setAge(10);
	--%>
	age:<jsp:getProperty property="age" name="customer" />
	<br> id:<jsp:getProperty property="id" name="customer" />
	<br> name:<jsp:getProperty property="name" name="customer" />
	<%--<%=customer.getAge()%>--%>
</body>
</html>