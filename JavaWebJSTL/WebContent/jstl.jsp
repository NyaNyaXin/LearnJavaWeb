<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
	<h4>
		c:url:产生一个url地址。可以根据Cookie是否可用来智能进行Url重写，对GET请求的参数编码
		可以把产生的URL存储在域对象的属性中
		还可以使用c:param为URL添加参数，c:url会对参数进行自动的转码
		value中的 /代表的是当前web应用的根目录
	</h4>
	<c:url value="/test.jsp" var="testurl" scope="page">
		<c:param name="name" value="chenxin"></c:param>
	</c:url>
	URL:${testurl }
	<br>
	<h4>
		c:redirect:使当前jsp页面重定向到指定页面.是当前jsp转发到指定的页面可以使用<br>
			<%--
			<jsp:forward page="test.jsp"></jsp:forward>
			 --%>
		/ 代表的是当前web应用的根目录<br>
		response.sendRedirect("/")代表WEB站点的根目录
	</h4>
	<%--<c:redirect url="/test.jsp" ></c:redirect> --%>
	<h4>c:import 可以包含任何页面到当前页面</h4>
	<%--<c:import url="http://www.baidu.com"></c:import> --%>

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
	<br>
	<h4>c:forEach： 可以对数组,Collection,Map进行遍历,begin(对于集合begin从0开始算),end,step</h4>
	<c:forEach begin="1" end="10" step="3" var="i">
		${i } -- 
	</c:forEach>
	<br>
	<%
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(1001,"AAA"));
		customers.add(new Customer(1002,"BBB"));
		customers.add(new Customer(1003,"CCC"));
		customers.add(new Customer(1004,"DDD"));
		customers.add(new Customer(1005,"EEE"));
		customers.add(new Customer(1006,"FFF"));
		customers.add(new Customer(1007,"GGG"));
		customers.add(new Customer(1008,"HHH"));
		customers.add(new Customer(1009,"III"));
		customers.add(new Customer(1010,"JJJ"));
		
		request.setAttribute("customers", customers);
	%>
	<!-- 遍历Collection，遍历数组与之相同 -->
	<c:forEach items="${requestScope.customers }" var="customer" begin="0" step="2" end="5" varStatus="status">
		${status.index}--${status.count}--${status.first}--${status.last}--${customer.id }---${customer.name }<br>
	</c:forEach>
	<br>
	<!-- 遍历Map -->
	<%
		Map<String,Customer> customers2 = new HashMap<String,Customer>();
		customers2.put("a",new Customer(1001,"AAA"));
		customers2.put("b",new Customer(1002,"BBB"));
		customers2.put("c",new Customer(1003,"CCC"));
		customers2.put("d",new Customer(1004,"DDD"));
		customers2.put("e",new Customer(1005,"EEE"));
		customers2.put("f",new Customer(1006,"FFF"));
		customers2.put("g",new Customer(1007,"GGG"));
		customers2.put("h",new Customer(1008,"HHH"));
		customers2.put("i",new Customer(1009,"III"));
		customers2.put("j",new Customer(1010,"JJJ"));
		
		request.setAttribute("customers2", customers2);
	%>
	<c:forEach items="${requestScope.customers2}" var="cust">
		${cust.key }----${cust.value.id }---${cust.value.name }<br>
	</c:forEach>
	<br>
	<h4>c:forTokens:用来处理字符串的，类似于String的split方法</h4>
	<c:set value="a,b,c.d.e.f;g;h;i" var="test" scope="request"></c:set>
	<c:forTokens items="${requestScope.test }" delims="." var="s">
		${s }<br>
	</c:forTokens>
</body>
</html>