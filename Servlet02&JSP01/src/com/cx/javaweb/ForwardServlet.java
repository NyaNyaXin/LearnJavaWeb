package com.cx.javaweb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardServlet
 */
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ForwardServlet's doGet Method。。。");
		//请求的转发：
		//1.调用HttpServletRequest的getRequestDispatcher()方法获取RequestDispatcher对象
		String path="testServlet";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/"+path);
		//调用方法时，需要传入要转发的地址
		//2.HttpServletRequest的forward(request,response)方法,进行请求的转发
		requestDispatcher.forward(request, response);
	}

}
