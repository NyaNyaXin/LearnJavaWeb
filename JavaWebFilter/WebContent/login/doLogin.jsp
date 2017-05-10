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
		//1.获取用户的登陆信息
		String username = request.getParameter("username");
		//2.若登陆信息完整，则把登陆信息放入到session中
		if(username!=null&&!username.trim().equals("")){
			session.setAttribute(application.getInitParameter("userSessionKey"), username);
			//3.重定向到list.jsp
			response.sendRedirect("list.jsp");
		}else{
			response.sendRedirect("login.jsp");
		}
		
	%>
</body>
</html>