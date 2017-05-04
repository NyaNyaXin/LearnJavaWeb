package com.cx.mvcapp.test;

import java.util.List;

import org.junit.Test;

import com.cx.mvcapp.dao.CustomerDao;
import com.cx.mvcapp.dao.impl.CustomerJdbcDaoImpl;
import com.cx.mvcapp.domain.Customer;

public class CustomerJdbcDaoImplTest {
	
	private CustomerDao customerDao = new CustomerJdbcDaoImpl();

	@Test
	public void testGetAll() {
		List<Customer> customers = customerDao.getAll();
		System.out.println(customers);
	}

	@Test
	public void testSave() {
		Customer customer = new Customer();
		customer.setName("ding");
		customer.setAddress("tianjin");
		customer.setPhone("13122255455");
		customerDao.save(customer);
	}

	@Test
	public void testGetInteger() {
		Customer cus = customerDao.get(1); 
		System.out.println(cus);
	}

	@Test
	public void testDelete() {
		customerDao.delete(1);
	}

	@Test
	public void testGetCountWithName() {
		long count = customerDao.getCountWithName("xin");
		System.out.println(count);
		
	}

}
