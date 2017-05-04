package com.cx.mvcapp.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cx.mvcapp.dao.CriteriaCustomer;
import com.cx.mvcapp.dao.CustomerDao;
import com.cx.mvcapp.dao.impl.CustomerJdbcDaoImpl;
import com.cx.mvcapp.domain.Customer;

public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CustomerDao customerDao = new CustomerJdbcDaoImpl();

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
		//获取模糊查询的请求参数
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		//把请求参数封装为一个CriteriaCustomer对象
		CriteriaCustomer cc = new CriteriaCustomer(name, address, phone);
		//1.调用CustomerDao的getForListWithCriteriaCustomer()方法得到Customer的集合
		List<Customer> customers = customerDao.getForListWithCriteriaCustomer(cc);
		//2.把Customer的集合放入到request中
		request.setAttribute("customers", customers);
		//3.转发页面到index.jsp(不能使用重定向)
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("addCustomer");
	}
}