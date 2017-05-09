package com.cx.javaweb.filters;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("destory....");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Before HelloFilter's doFilter...");
		//放行
		chain.doFilter(request, response);
		System.out.println("After HelloFilter's doFilter...");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Init......");
	}

}
