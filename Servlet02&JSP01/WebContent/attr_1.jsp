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
		pageContext.setAttribute("pageContextAttr", "pageContextValue");
		request.setAttribute("requestAttr", "requestValue");
		String sessionValue = "aaaaa";
		session.setAttribute("sessionAttr", sessionValue);
		application.setAttribute("applicationAttr", "applicationValue");
	%>
	<h2>Attr 1 Page</h2>
	<br/>
	"pageContextAttr":<%= pageContext.getAttribute("pageContextAttr") %>
	<br/>
	"requestAttr":<%= request.getAttribute("requestAttr") %>
	<br/>
	"sessionAttr":<%= session.getAttribute("sessionAttr") %>
	<br/>
	"applicationAttr":<%= application.getAttribute("applicationAttr") %>
	
	<a href="attr_2.jsp">To Attr2 Page</a>
	<a href="testAttr">To Attr Servlet</a>
</body>
</html>