package com.cx.javaweb.filters.login;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cx.javaweb.filters.HttpFilter;

public class LoginFilter extends HttpFilter {

	// 1.从web.xml文件中获取sessionKey，redirectUrl，unCheckUrls
	private String sessionKey;
	private String redirectUrl;
	private String uncheckUrls;
	
	@Override
	protected void init() {
		ServletContext servletContext = getFilterConfig().getServletContext();
		sessionKey = servletContext.getInitParameter("userSessionKey");
		redirectUrl = servletContext.getInitParameter("redirectPage");
		// /login/a.jsp,/login/list.jsp,/login/login.jsp,/login/doLogin.jsp
		uncheckUrls = servletContext.getInitParameter("unCheckUrls");
	}
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 1.获取请求的ServletPath
		String servletPath = request.getServletPath();
		// 2.检查1获取的servletPath是否为不需要检查额url中的一个，若是则直接放行。方法结束
		List<String> urls = Arrays.asList(uncheckUrls.split(","));
		if(urls.contains(servletPath)) {
			chain.doFilter(request, response);
			return;
		}
		// 3.从session中获取sessionKey对应的值，若值不存在，则重定向到redirectUrl
		Object user = request.getSession().getAttribute(sessionKey);
		if(user==null) {
			response.sendRedirect(request.getContextPath()+redirectUrl);
			return;
		}
		// 4.若存在，则放行，允许访问
		chain.doFilter(request, response);
	}

}
