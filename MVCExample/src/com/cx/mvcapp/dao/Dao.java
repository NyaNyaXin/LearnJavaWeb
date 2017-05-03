package com.cx.mvcapp.dao;

import java.util.List;

/**
 * 封装了基本的CRUD方法，以供子类继承使用
 * 当前Dao直接在方法中获取数据库连接
 * 整个DAO采取DBUtils解决方案
 * @param <T>:当前Dao处理的实体类的类型
 * **/

public class Dao<T> {
	
	private Class<T> clazz;
	
	/**
	 * 返回某一个字段的值：如数据表中的记录数等
	 * **/
	public <E> E getForValue(String sql,Object...args){
		return null;
	}
	
	/**
	 * 返回T所对应的List
	 * **/
	public List<T> getForList(String sql,Object...args){
		return null;
	}
	/**
	 * 返回对应的T的实例类的对象
	 * */
	public T get(String sql,Object...args){
		return null;
	}
	/**
	 * 该方法封装了INSERT，DELETE，UPDATE操作
	 * @param sql:SQL语句
	 * @param args:填充sql语句的占位符
	 * **/
	public void update(String sql,Object ...args){
		
	}
}
