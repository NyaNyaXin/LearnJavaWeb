<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>AAA PAGE</h1>
	<!-- 在a.jsp中包含b.jsp -->
	<%--<jsp:include page="b.jsp"></jsp:include> --%>
	
	<jsp:forward page="/include/b.jsp">
		<jsp:param value="abc" name="abcd"/>
	</jsp:forward>
</body>
</html>