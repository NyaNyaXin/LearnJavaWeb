package com.cx.mvcapp.dao.impl;

import java.util.List;

import com.cx.mvcapp.dao.CriteriaCustomer;
import com.cx.mvcapp.dao.CustomerDao;
import com.cx.mvcapp.dao.Dao;
import com.cx.mvcapp.domain.Customer;

public class CustomerJdbcDaoImpl extends Dao<Customer> implements CustomerDao {

	@Override
	public List<Customer> getAll() {
		String sql = "SELECT id,name,address,phone FROM customers";
		return getForList(sql);
	}

	@Override
	public void save(Customer customer) {
		String sql = "INSERT INTO customers(name,address,phone) VALUES(?,?,?)";
		update(sql, customer.getName(), customer.getAddress(), customer.getPhone());
	}

	@Override
	public Customer get(Integer id) {
		String sql = "SELECT id,name,address,phone FROM customers WHERE id = ?";
		return get(sql, id);
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM customers WHERE id=?";
		update(sql, id);

	}

	@Override
	public long getCountWithName(String name) {
		String sql = "SELECT COUNT(id) FROM customers WHERE name= ?";

		return getForValue(sql, name);
	}

	@Override
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc) {
		String sql = "SELECT id,name,address,phone FROM customers WHERE "
				+ "name LIKE ? AND address LIKE ? AND phone LIKE ?";
		//修改了CriteriaCustomer的getter方法：使其返回的字符串中有"%%"
		//若返回值为null则返回"%%",若不为null则返回"%"+字段本身的值+"%"
		return getForList(sql, cc.getName(),cc.getAddress(),cc.getPhone());
	}

}
