package com.cx.javaweb.tag;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class HelloSimpleTag implements SimpleTag {
	
	private String value;
	private String count;
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public void setCount(String count) {
		this.count = count;
	}

	//标签体逻辑实际应该编写到该方法中
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("value:"+value+",count："+count);
//		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
//		pageContext.getOut().print("Hello:"+request.getParameter("name"));
		JspWriter out = pageContext.getOut();
		int c = 0;
		c = Integer.parseInt(count);
		for(int i=0;i<c;i++){
			out.print(value);
			out.print("<br>");
		}
	}

	@Override
	public JspTag getParent() {
		System.out.println("getParent");
		return null;
	}

	@Override
	public void setJspBody(JspFragment arg0) {
		System.out.println("setJspBody");
	}
	private PageContext pageContext;
	@Override
	//JSP引擎调用，把代表jsp页面的PageContext传入
	//PageContext可以获取JSP页面的其他8个隐含对象
	//所以凡是JSP页面可以做的标签处理器都可以完成
	public void setJspContext(JspContext arg0) {
		System.out.println(arg0 instanceof PageContext);
		this.pageContext = (PageContext) arg0;
	}

	@Override
	public void setParent(JspTag arg0) {
		System.out.println("setParent");
	}

}
