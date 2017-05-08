<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 导入标签库(描述文件) -->
<%@ taglib uri="http://www.cx.com/mytag/core" prefix="cx"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<cx:readerFile src="/WEB-INF/note.txt"/>
	<br>
	<cx:max num2="${param.num1}" num1="${param.num2}"/>
	<br>
	<cx:hello value="${param.name }" count="10"/>
</body>
</html>