package com.cx.javaweb.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	public List<Student> getAll() {
		List<Student> students = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String driverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql:///javaweb";
			String user = "root";
			String password = "123456";
			Class.forName(driverClass); 
			connection = DriverManager.getConnection(url, user, password);
			String sql = "SELECT id,username,password,balance FROM users";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				int id = resultSet.getInt(1);
				String username = resultSet.getString(2);
				String userpassword = resultSet.getString(3);
				String balance = resultSet.getString(4);
				Student student = new Student(id, username, userpassword, balance);
				students.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return students;
	}
	
	public void deleteById(Integer id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			String driverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql:///javaweb";
			String user = "root";
			String password = "123456";
			Class.forName(driverClass); 
			connection = DriverManager.getConnection(url, user, password);
			String sql = "DELETE FROM users WHERE id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
 			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
