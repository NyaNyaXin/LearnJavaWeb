package com.cx.javaweb;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//模拟从数据库中查询数据
		List<String> cities = Arrays.asList("Beijing","Shanghai","Guangzhou");
		request.setAttribute("cities", cities);
		
		//通过转发的方式响应/path/b.jsp
		//request.getRequestDispatcher("/path/b.jsp").forward(request, response);
		
		response.sendRedirect(request.getContextPath()+"/path/c.jsp");
	}

}
