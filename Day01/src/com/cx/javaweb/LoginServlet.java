package com.cx.javaweb;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginServlet implements Servlet{

	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("ÇëÇóÀ´ÁË¡£¡£¡£¡£¡£");
		System.out.println(arg0);
		String user = arg0.getParameter("user");
		String password = arg0.getParameter("password");
		System.out.println(user+","+password);
		
		String instersting = arg0.getParameter("instersting");
		System.out.println(instersting);
		
		String[] insterstings = arg0.getParameterValues("instersting");
		for(String instersting1:insterstings){
			System.out.println("-->"+instersting1);
		}
		
		Enumeration<String> names = arg0.getParameterNames();
		while(names.hasMoreElements()){
			System.out.println(arg0.getParameter(names.nextElement()));
			
		}
		Map<String, String[]> map = arg0.getParameterMap();
		for(Map.Entry<String, String[]> entry:map.entrySet()){
			System.out.println(entry.getKey()+":"+Arrays.asList(entry.getValue()));
		}
		
		HttpServletRequest httpServletRequest = (HttpServletRequest)arg0;
		String requestURI = httpServletRequest.getRequestURI();
		System.out.println(requestURI);
		
		String method = httpServletRequest.getMethod();
		System.out.println(method);
		
		String queryString = httpServletRequest.getQueryString();
		System.out.println(queryString);
		
		String servletPath = httpServletRequest.getServletPath();
		System.out.println(servletPath);
		
	}

}
