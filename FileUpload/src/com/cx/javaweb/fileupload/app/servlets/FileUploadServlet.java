package com.cx.javaweb.fileupload.app.servlets;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.cx.javaweb.fileupload.app.beans.FileUploadBean;
import com.cx.javaweb.fileupload.app.utils.FileUploadAppProperties;

/**
 * Servlet implementation class FileUploadServlet
 */
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletFileUpload upload = getServletFileUpload();

		try {
			//把需要上传的FileItem都放入到该Map中
			//键：文件待存放的路径，值：对应的FileItem对象
			Map<String, FileItem> uploadFiles = new HashMap<String, FileItem>();
			//解析请求，得到FileItem的集合
			List<FileItem> items = upload.parseRequest(request);
			
			//1.构建FileUploadBean的集合，同时填充uploadFiles
			List<FileUploadBean> beans = buildFileUploadBeans(items,uploadFiles);
			
			//2.校验扩展名
			validateExtName(beans);
			
			//3.校验文件的大小：在解析时已经校验了，我们只需要通过异常得到结果
			
			//4.进行文件的上传操作
			upload(uploadFiles);

			//5.把上传的信息保存到数据库中
			savedBeans(beans);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void savedBeans(List<FileUploadBean> beans) {
		// TODO Auto-generated method stub
		
	}

	private void upload(Map<String, FileItem> uploadFiles) {
		// TODO Auto-generated method stub
		
	}

	private void validateExtName(List<FileUploadBean> beans) {
		// TODO Auto-generated method stub
		
	}

	private List<FileUploadBean> buildFileUploadBeans(List<FileItem> items, Map<String, FileItem> uploadFiles) {
		// TODO Auto-generated method stub
		return null;
	}

	private ServletFileUpload getServletFileUpload() {
		String exts = FileUploadAppProperties.getInstance().getProperty("exts");
		String fileMaxSize = FileUploadAppProperties.getInstance().getProperty("file.max.size");
		String totalFileMaxSize = FileUploadAppProperties.getInstance().getProperty("total.file.max.size");

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024 * 500);
		File tempDirectory = new File("d:\\tempDirectory");
		factory.setRepository(tempDirectory);

		ServletFileUpload upload = new ServletFileUpload(factory);

		upload.setFileSizeMax(Integer.parseInt(fileMaxSize));
		upload.setSizeMax(Integer.parseInt(totalFileMaxSize));
		return upload;
	}

}
