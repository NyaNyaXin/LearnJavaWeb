package com.cx.javaweb;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * �Զ���һ��Servlet�ӿڵ�ʵ���ࣺ�ÿ������κ�Servlet���̳и��࣬�Լ򻯿���
 * **/

public abstract class MyGenericServlet implements Servlet,ServletConfig{

	@Override
	public void destroy() {}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return servletConfig;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	private ServletConfig servletConfig;
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.servletConfig = servletConfig;
		init();
	}

	public void init() throws ServletException{}

	@Override
	public abstract void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException;

	//���·���ΪServletConfig�ӿڵķ���
	@Override
	public String getInitParameter(String arg0) {
		
		return servletConfig.getInitParameter(arg0);
	}

	@Override
	public Enumeration getInitParameterNames() {
		return servletConfig.getInitParameterNames();
	}

	@Override
	public ServletContext getServletContext() {
		return servletConfig.getServletContext();
	}

	@Override
	public String getServletName() {
		return servletConfig.getServletName();
	}

}
