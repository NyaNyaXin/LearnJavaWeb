package com.cx.javaweb.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

/**
 * 自定义的HttpFilter，实现自Filter接口
 * 
 */
public abstract class HttpFilter implements Filter {

	/**
	 * 空的destory方法
	 * **/
	@Override
	public void destroy() {
	}

	/**
	 * 原生的doFilter方法，在方法内部把ServletRequest和ServletResponse转为了HttpServletRequest和HttpServletResponse
	 * 并调用了doFilter(HttpServletRequest request, HttpServletResponse response,
	 * FilterChain chain)方法
	 * 
	 * 若编写Filter的过滤方法不建议直接继承该方法。而建议继承doFilter(HttpServletRequest request,
	 * HttpServletResponse response, FilterChain chain)方法
	 **/
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		doFilter(request, response, chain);
	}

	/**
	 * 抽象方法，为Http请求定制。必须实现的方法
	 * **/
	public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException;

	/**
	 * 用于保存FilterConfig对象
	 **/
	private FilterConfig filterConfig;

	/**
	 * 不建议子类直接覆盖。若直接覆盖将有可能会导致FilterConfig成员变量初始化失败
	 **/
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.filterConfig = arg0;
		init();
	}

	/**
	 * 供子类继承的初始化方法，可以通过getFilterConfig方法获取FilterConfig对象
	 **/
	protected void init() {
	}

	/**
	 * 直接返回init(ServletConfig)的FilterConfig对象
	 **/
	public FilterConfig getFilterConfig() {
		return filterConfig;
	}
}
