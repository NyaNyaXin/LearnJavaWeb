package com.cx.mvcapp.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cx.mvcapp.dao.CriteriaCustomer;
import com.cx.mvcapp.dao.CustomerDao;
import com.cx.mvcapp.dao.impl.CustomerJdbcDaoImpl;
import com.cx.mvcapp.domain.Customer;

public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerDao customerDao = new CustomerJdbcDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	// protected void doPost(HttpServletRequest request, HttpServletResponse
	// response)
	// throws ServletException, IOException {
	// String method = request.getParameter("method");
	// switch (method) {
	// case "add":
	// add(request, response);
	// break;
	// case "query":
	// query(request, response);
	// break;
	// case "delete":
	// delete(request, response);
	// break;
	// case "update":
	// update(request,response);
	// break;
	// }
	//
	//
	// }
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.获取ServletPath：/edit.do等
		String servletPath = req.getServletPath();
		String methodName = servletPath.substring(1);
		// 2.去除/和.do得到类似于edit这样的字符串
		methodName = methodName.substring(0, methodName.indexOf('.'));
		System.out.println(methodName);
		try {
			// 3.利用反射获取methodName对应的方法
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			// 4.利用反射调用对应的方法
			method.invoke(this, req, resp);
		} catch (Exception e) {
			// e.printStackTrace();
			resp.sendRedirect("error.jsp");
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("update");
		// 1.获取表单参数id,name,address,phone,oldName
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String oldNama = request.getParameter("oldName");
		// 2.检验name是否已经被占用
		// 2.1.先比较name和oldName是否相同，若相同说明那么可用，若不相同则调用调用CustomerDao的getCountWithName方法获取name在数据库中是否存在
		if (!oldNama.equalsIgnoreCase(name)) {

			long count = customerDao.getCountWithName(name);
			// 2.2.若返回值大于0，则响应updatecustomer.jsp页面,通过转发的方式来响应updatecustomer.jsp页面
			if (count > 0) {
				// 2.2.1.要求在updatecustomer.jsp页面显示一个错误消息：用户名name已经被占用，请检查后填写
				// 在request中放入一个属性message：用户名name已经被占用，请检查后填写!在页面上通过request.getAttribute("message")的方式来显示
				request.setAttribute("message", "用户名" + name + "已经被占用，请检查后填写!");
				// 2.2.2.updatecustomer.jsp的表单值可以回显
				// address,phone显示提交表单的新的值，而name显示OldName，而不是新提交的name
				// 2.2.3.结束方法 ：return
				request.getRequestDispatcher("/updatecustomer.jsp").forward(request, response);
				return;
			}
		}

		// 3.若验证通过，则把表单参数封装为一个Customer对象
		Customer customer = new Customer(name, address, phone);
		customer.setId(Integer.parseInt(id));
		// 4.调用 CustomerDao的update() 方法执行保存操作
		customerDao.update(customer);
		// 5.重定向到query.do:使用重定向可以避免表单出现重复提交问题
		response.sendRedirect("query.do");
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("edit");
		String forwardPath = "/error.jsp";
		// 1.获取请求参数id
		String idStr = request.getParameter("id");
		// 2.调用cutomerDao的get方法获取和id对应的customer对象
		try {
			Customer customer = customerDao.get(Integer.parseInt(idStr));
			if (customer != null) {
				forwardPath = "/updatecustomer.jsp";
				// 3.将customer放入到request中
				request.setAttribute("customer", customer);
			}
		} catch (Exception e) {

		}

		// 4.响应updatecustomer.jsp页面：请求转发
		request.getRequestDispatcher(forwardPath).forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("delete");
		String idStr = request.getParameter("id");
		int id = 0;
		// 作用：防止idStr不能转为int类型，若不能转，id=0，无法进行任何操作
		try {
			id = Integer.parseInt(idStr);
			customerDao.delete(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		response.sendRedirect("query.do");

	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("query");
		// 获取模糊查询的请求参数
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		// 把请求参数封装为一个CriteriaCustomer对象
		CriteriaCustomer cc = new CriteriaCustomer(name, address, phone);
		// 1.调用CustomerDao的getForListWithCriteriaCustomer()方法得到Customer的集合
		List<Customer> customers = customerDao.getForListWithCriteriaCustomer(cc);
		// 2.把Customer的集合放入到request中
		request.setAttribute("customers", customers);
		// 3.转发页面到index.jsp(不能使用重定向)
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private void addCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("addCustomer");
		// 1.获取表单参数address,name,phone
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		// 2.检验name是否已经被占用
		// 2.1.调用CustomerDao的getCountWithName方法获取name在数据库中是否存在
		long count = customerDao.getCountWithName(name);
		// 2.2.若返回值大于0，则响应newcustomer.jsp页面
		// 通过转发的方式来响应newcustomer.jsp页面
		if (count > 0) {
			// 2.2.1.要求在newcustomer.jsp页面显示一个错误消息：用户名name已经被占用，请检查后填写
			// 在request中放入一个属性message：用户名name已经被占用，请检查后填写!在页面上通过request.getAttribute("message")的方式来显示
			request.setAttribute("message", "用户名" + name + "已经被占用，请检查后填写!");
			// 2.2.2.newcustomer.jsp的表单值可以回显
			// 通过value="<%= request.getParameter("name")==null? "":
			// request.getParameter("name")%>
			// 来进行回显
			request.getRequestDispatcher("/newcustomer.jsp").forward(request, response);
			// 2.2.3.结束方法 ：return
			return;
		}

		// 3.若验证通过，则把表单参数封装为一个Customer对象
		Customer customer = new Customer(name, address, phone);
		// 4.调用 CustomerDao的save() 方法执行保存操作
		customerDao.save(customer);
		// 5.重定向到success.jsp页面:使用重定向可以避免表单出现重复提交问题
		response.sendRedirect("success.jsp");
	}
}