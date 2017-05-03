package com.cx.mvcapp.dao;

import java.util.List;

import com.cx.mvcapp.domain.Customer;

public interface CustomerDao {
	public List<Customer> getAll();
	
	public void save(Customer customer);
	
	public Customer get(Integer id);
	
	public void delete(Integer id);
	
	/**
	 * 返回和name相等的记录数
	 * **/
	public long getCountWithName(String name);
}
