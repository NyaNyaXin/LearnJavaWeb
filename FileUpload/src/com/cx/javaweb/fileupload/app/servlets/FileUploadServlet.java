package com.cx.javaweb.fileupload.app.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cx.javaweb.fileupload.app.utils.FileUploadAppProperties;

/**
 * Servlet implementation class FileUploadServlet
 */
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String exts = FileUploadAppProperties.getInstance().getProperty("exts");
		String fileMaxSize = FileUploadAppProperties.getInstance().getProperty("file.max.size");
		String totalFileMaxSize = FileUploadAppProperties.getInstance().getProperty("total.file.max.size");
		
		System.out.println(exts);
		System.out.println(fileMaxSize);
		System.out.println(totalFileMaxSize);
	}

}
