/**
 * @Title: User.java
 * @Package com.zcx.pojo
 * @Description: 
 * @author 13071
 * @date 2019年11月26日
 * @version V1.0
 */
package com.edrop.pojo;

/**
 * 用户实体类
 * @ClassName: User
 * @Description: 
 * @author 13071
 * @date 2019年11月26日
 *
 */
public class DDUser {
	private Integer uid;
	private String uname;
	private String pwd;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public DDUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DDUser(Integer uid, String uname, String pwd) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", pwd=" + pwd + "]";
	}
}
