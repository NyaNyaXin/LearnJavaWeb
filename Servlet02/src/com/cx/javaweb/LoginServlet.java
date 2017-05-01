package com.cx.javaweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginServlet extends GenericServlet {
	
	//�Ե�ǰ��Servlet���г�ʼ��������init����
	@Override
	public void init() throws ServletException {
		System.out.println("��ʼ��������������");
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		//��ȡ����ʽ��GET����POST
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String method = httpServletRequest.getMethod();
		System.out.println(method);
		
		// 1.��ȡ�������username,password
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 2.��ȡ��ǰwebӦ�õĳ�ʼ������user,password
		// ��Ҫʹ��ServletContext����
		
		String initUser = getServletContext().getInitParameter("user");
		String initPassword = getServletContext().getInitParameter("password");
		
		PrintWriter out = response.getWriter();
		// 3.�ȶ�
		if(initUser.equals(username)&&initPassword.equals(password)){
			// 4.��ӡ��Ӧ���ַ���
			out.print("Hello:"+username);
		}
		else{
			out.print("Sorry:"+username);
		}
		

	}

}
