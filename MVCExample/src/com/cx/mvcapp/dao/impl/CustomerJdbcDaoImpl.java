package com.cx.mvcapp.dao.impl;

import java.util.List;

import com.cx.mvcapp.dao.CustomerDao;
import com.cx.mvcapp.dao.Dao;
import com.cx.mvcapp.domain.Customer;

public class CustomerJdbcDaoImpl extends Dao<Customer> implements CustomerDao{

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long getCountWithName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

}
