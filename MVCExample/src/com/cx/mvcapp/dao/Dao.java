package com.cx.mvcapp.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.cx.mvcapp.db.JdbcUtils;

/**
 * 封装了基本的CRUD方法，以供子类继承使用
 * 当前Dao直接在方法中获取数据库连接
 * 整个DAO采取DBUtils解决方案
 * @param <T>:当前Dao处理的实体类的类型
 * **/

public class Dao<T> {
	
	private QueryRunner queryRunner = new QueryRunner();
	
	private Class<T> clazz;
	
	public Dao() {
		Type superClass = getClass().getGenericSuperclass();
		if(superClass instanceof ParameterizedType){
			ParameterizedType parameterizedType = (ParameterizedType) superClass;
			Type[] typeArgs = parameterizedType.getActualTypeArguments();
			if(typeArgs!=null&&typeArgs.length>0){
				if(typeArgs[0] instanceof Class){
					clazz = (Class<T>) typeArgs[0];
				}
			}
		}
	}
	
	/**
	 * 返回某一个字段的值：如数据表中的记录数等
	 * **/
	public <E> E getForValue(String sql,Object...args){
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			return (E) queryRunner.query(connection, sql, new ScalarHandler(), args);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			JdbcUtils.releaseConnection(connection);
		}
		
		return null;
	}
	
	/**
	 * 返回T所对应的List
	 * **/
	public List<T> getForList(String sql,Object...args){
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), args);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			JdbcUtils.releaseConnection(connection);
		}
		return null;
	}
	/**
	 * 返回对应的T的实例类的对象
	 * @throws SQLException 
	 * */
	public T get(String sql,Object...args){
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanHandler<>(clazz), args);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			JdbcUtils.releaseConnection(connection);
		}
		return null;
	}
	/**
	 * 该方法封装了INSERT，DELETE，UPDATE操作
	 * @param sql:SQL语句
	 * @param args:填充sql语句的占位符
	 * **/
	public void update(String sql,Object ...args){
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			queryRunner.update(connection, sql,args);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.releaseConnection(connection);
		}
	}
}
