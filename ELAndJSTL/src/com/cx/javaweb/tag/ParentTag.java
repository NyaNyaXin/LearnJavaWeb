package com.cx.javaweb.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ParentTag extends SimpleTagSupport{
	private String name="chenxin";
	public String getName() {
		return name;
	}
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("父标签处理器类的name:"+name);
		getJspBody().invoke(null);
	}
}
