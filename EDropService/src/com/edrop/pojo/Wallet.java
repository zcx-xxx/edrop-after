/**
 * @Title: Wallet.java
 * @Package com.edrop.pojo
 * @Description: 
 * @author 13071
 * @date 2019年12月11日
 * @version V1.0
 */
package com.edrop.pojo;

/**
 * @ClassName: Wallet
 * @Description: 
 * @author 13071
 * @date 2019年12月11日
 *
 */
public class Wallet {
	private Integer id;
	private Integer pid;
	private Double money;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Wallet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Wallet(Integer id, Integer pid, Double money) {
		super();
		this.id = id;
		this.pid = pid;
		this.money = money;
	}
	@Override
	public String toString() {
		return "Wallet [id=" + id + ", pid=" + pid + ", money=" + money + "]";
	}
	
	
}
