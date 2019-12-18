/**
 * @Title: Evaluation.java
 * @Package com.edrop.pojo
 * @Description: 
 * @author 13071
 * @date 2019年11月28日
 * @version V1.0
 */
package com.edrop.pojo;

/**
 * 用户评价表
 * @ClassName: Evaluation
 * @Description: 
 * @author 13071
 * @date 2019年11月28日
 *
 */
public class Evaluation {
	private Integer id;
	private Integer userId;
	private Integer employeeId;
	private String content;
	private int star;
	private User user;
	private Employee employee;
	
	public Evaluation(Integer id, Integer userId, Integer employeeId, String content, int star, User user,
			Employee employee) {
		super();
		this.id = id;
		this.userId = userId;
		this.employeeId = employeeId;
		this.content = content;
		this.star = star;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	@Override
	public String toString() {
		return "Evaluation [id=" + id + ", userId=" + userId + ", employeeId=" + employeeId + ", content=" + content
				+ ", star=" + star + ", user=" + user + ", employee=" + employee + "]";
	}
	public Evaluation() {
		super();
		// TODO Auto-generated constructor stub
	}
}
