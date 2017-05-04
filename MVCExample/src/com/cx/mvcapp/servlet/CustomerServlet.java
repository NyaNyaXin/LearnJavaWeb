package com.cx.mvcapp.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String method = request.getParameter("method");
//		switch (method) {
//		case "add":
//			add(request, response);
//			break;
//		case "query":
//			query(request, response);
//			break;
//		case "delete":
//			delete(request, response);
//			break;
//		case "update":
//			update(request,response);
//			break;
//		}
//		
//
//	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.获取ServletPath：/edit.do等
		String servletPath = req.getServletPath();
		String methodName = servletPath.substring(1);
		//2.去除/和.do得到类似于edit这样的字符串 
		methodName = methodName.substring(0, methodName.indexOf('.'));
		System.out.println(methodName);
		try {
			//3.利用反射获取methodName对应的方法
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			//4.利用反射调用对应的方法
			method.invoke(this, req,resp);
		} catch (Exception e) {
			//e.printStackTrace();
			resp.sendRedirect("error.jsp");
		}  
	}
 
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("update");
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("edit");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("delete");
	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("query");
	}

	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("addCustomer");
	}
}