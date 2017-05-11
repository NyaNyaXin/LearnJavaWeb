package com.cx.javaweb.fileupload.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取请求信息
//		String file = request.getParameter("file");
//		String desc = request.getParameter("desc");
//		System.out.println(file);
//		System.out.println(desc);
		
		InputStream in = request.getInputStream();
		Reader reader = new InputStreamReader(in);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String str = null;
		if((str = bufferedReader.readLine())!=null) {
			System.out.println(str);
		}
	}

}
