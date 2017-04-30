package com.cx.javaweb;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements Servlet {

	@Override
	public void destroy() {
		System.out.println("destroy.......");
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig...");
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo....");
		return null;
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("init...");
		String user = servletConfig.getInitParameter("user");
		System.out.println("user:"+user);
		Enumeration<String> names = servletConfig.getInitParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			String value = servletConfig.getInitParameter(name);
			System.out.println("^.^"+name+":"+value);
		}
		
		String servletName = servletConfig.getServletName();
		System.out.println(servletName);
		
		//获取ServletContext对象
		ServletContext servletContext = servletConfig.getServletContext();
		
		String driver = servletContext.getInitParameter("driver");
		System.out.println("driver"+driver);
		
		Enumeration<String> names2 = servletContext.getInitParameterNames();
		while(names2.hasMoreElements()){
			String name = names2.nextElement();
			System.out.println("-->"+name);
		}
		
		String path  = servletContext.getRealPath("/note.txt");
		System.out.println(path);
		
		String contextpath = servletContext.getContextPath();
		System.out.println(contextpath);
		
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			InputStream is = classLoader.getResourceAsStream("jdbc.properties");
			System.out.println("1." + is);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			InputStream is2 = servletContext.getResourceAsStream("/WEB-INF/classes/jdbc.properties");
			System.out.println("2." + is2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("service....");
	}
	
	public HelloServlet(){
		System.out.println("HelloServlet's Constructor.....");
	}

}
