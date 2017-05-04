package com.cx.mvcapp.dao;

import java.util.List;

import com.cx.mvcapp.domain.Customer;

public interface CustomerDao {
	/**
	 * 返回满足查询条件的List
	 * @param cc:封装了查询条件
	 * **/
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc);
	public List<Customer> getAll();
	
	public void save(Customer customer);
	
	public Customer get(Integer id);
	
	public void delete(Integer id);
	
	/**
	 * 返回和name相等的记录数
	 * **/
	public long getCountWithName(String name);
}
