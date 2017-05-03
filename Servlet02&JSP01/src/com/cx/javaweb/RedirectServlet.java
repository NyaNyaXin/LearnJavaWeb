package com.cx.javaweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectServlet
 */
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("RedirectServlet doget.......");
		request.setAttribute("name", "xjsjs");
		System.out.println("RedirectServlet's name:"+request.getAttribute("name"));
		String path = "testServlet";
		//执行请求的重定向,直接调用response的sendRedirect方法，其中path为要重定向的地址
		response.sendRedirect(path);
	}

}
