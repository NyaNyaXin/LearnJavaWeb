package com.cx.javaweb.filters.encoding;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cx.javaweb.filters.HttpFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
public class EncodingFilter extends HttpFilter  {
	private String encoding;
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			encoding = getFilterConfig().getServletContext().getInitParameter("encoding");
			request.setCharacterEncoding(encoding);
			chain.doFilter(request, response);
	}
       
   

}
