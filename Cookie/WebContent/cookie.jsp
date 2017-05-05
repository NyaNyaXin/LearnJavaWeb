<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//在JavaWeb规范中使用Cookie类代表cookie
		 		
		//1.获取cookie
		Cookie[] cookies = request.getCookies();
		if(cookies!=null&&cookies.length>0){
			for(Cookie cookie:cookies){
				//2.获取Cookie的name和value
				out.print(cookie.getName()+":"+cookie.getValue());
				out.print("<br>");
			}
		}else{
			out.print("没有一个Cookie，正在创建并返回");
			//1.创建一个Cookie对象
			Cookie cookie = new Cookie("name","chenxin");
			//设置cookie的最大时效，以秒为单位，若为0表示立即删除该cookie，若为负数表示不存储cookie，若为正数，表示该cookie的存储时间
			cookie.setMaxAge(30);
			//2.调用response的一个方法把Cookie传给客户端。
			response.addCookie(cookie);
		}
	%>
</body>
</html>