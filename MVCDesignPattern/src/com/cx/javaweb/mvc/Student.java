package com.cx.javaweb.mvc;

public class Student {
	private Integer id;
	private String userName;
	private String passWord;
	private String balance;

	public Student() {
	}

	public Student(Integer id, String userName, String passWord, String balance) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.balance = balance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

}
