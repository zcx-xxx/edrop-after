package com.edrop.pojo;

import java.sql.Timestamp;

public class Admin {
	private Integer id;
	private String userName;
	private String password;
	private Timestamp registerTime;
	private Timestamp lastLoginTime;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}
	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", userName=" + userName + ", password=" + password + ", registerTime="
				+ registerTime + ", lastLoginTime=" + lastLoginTime + "]";
	}
	public Admin(Integer id, String userName, String password, Timestamp registerTime, Timestamp lastLoginTime) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.registerTime = registerTime;
		this.lastLoginTime = lastLoginTime;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
}
