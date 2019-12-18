/**
 * @Title: Reservation.java
 * @Package com.edrop.pojo
 * @Description: 
 * @author 13071
 * @date 2019年11月28日
 * @version V1.0
 */
package com.edrop.pojo;

import java.sql.Timestamp;
/**
 * 预约表
 * @ClassName: Reservation
 * @Description: 
 * @author 13071
 * @date 2019年11月28日
 *
 */
public class Reservation {
	private Integer id;
	private String address;
	private Timestamp reserveTime;
	private int state;
	private Timestamp createTime;
	private Integer userId;
	private Integer employeeId;
	private User user;
	private Employee employee;
	
	
	public Reservation(Integer id, String address, Timestamp reserveTime, int state, Timestamp createTime,
			Integer userId, Integer employeeId, User user, Employee employee) {
		super();
		this.id = id;
		this.address = address;
		this.reserveTime = reserveTime;
		this.state = state;
		this.createTime = createTime;
		this.userId = userId;
		this.employeeId = employeeId;
		this.user = user;
		this.employee = employee;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getReserveTime() {
		return reserveTime;
	}
	public void setReserveTime(Timestamp reserveTime) {
		this.reserveTime = reserveTime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", address=" + address + ", reserveTime=" + reserveTime + ", state=" + state
				+ ", createTime=" + createTime + ", userId=" + userId + ", employeeId=" + employeeId + ", user=" + user
				+ ", employee=" + employee + "]";
	}
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
}
