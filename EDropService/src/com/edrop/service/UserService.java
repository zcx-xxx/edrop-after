/**
 * @Title: UserService.java
 * @Package com.edrop.service.impl
 * @Description: 
 * @author 13071
 * @date 2019年11月27日
 * @version V1.0
 */
package com.edrop.service;

import java.sql.Timestamp;

import com.edrop.pojo.User;

/**
 * 提供用户的服务
 * @ClassName: UserService
 * @Description: 
 * @author 13071
 * @date 2019年11月27日
 *
 */
public interface UserService {
	
	/**
	 * 获取用户信息
	 * @Title: selUserInfoByUsernameAndPassword
	 * @Description:
	 * @param username
	 * @param password
	 * @return
	 * @return String
	 * @throws
	 */
	public String selUserInfoByUsernameAndPassword(String username, String password);
	
	/**
	 * @Title: selUserByPhone
	 * @Description:
	 * @param phone
	 * @return
	 * @return User
	 * @throws
	 */
	public User selUserByPhone(String phone);

	/**
	 * @Title: selUserInfoByQq
	 * @Description:
	 * @param qq
	 * @return
	 * @return String
	 * @throws
	 */
	public String selUserInfoByQq(String qq);
	
	/**
	 * @Title: insUserPhone
	 * @Description:
	 * @param phone
	 * @param registerTime
	 * @return
	 * @return int
	 * @throws
	 */
	public int insUserPhone(String phone, Timestamp registerTime);
	
	/**
	 * @Title: getUserInfoByPhone
	 * @Description:
	 * @param phone
	 * @return
	 * @return String
	 * @throws
	 */
	public String getUserInfoByPhone(String phone);

	/**
	 * @Title: upUserInfo
	 * @Description:
	 * @param id
	 * @param phone
	 * @param qq
	 * @param username
	 * @param password
	 * @param imgpath
	 * @param imgname
	 * @param address
	 * @param gender
	 * @return
	 * @return String
	 * @throws
	 */
	public String upUserInfo(Integer id, String phone, String qq, String username, String password, String imgpath,
			String imgname, String address, String gender, String detailAddress);

	/**
	 * @Title: registerByUserName
	 * @Description:
	 * @param username
	 * @param password
	 * @return
	 * @return String
	 * @throws
	 */
	public String registerByUserName(String username, String password);

	/**
	 * @Title: insUsernameAndPassword
	 * @Description:
	 * @param username
	 * @param password
	 * @return
	 * @return int
	 * @throws
	 */
	public int insUsernameAndPassword(String username, String password);

	/**
	 * qq 登录
	 * @Title: loginByQq
	 * @Description:
	 * @param username
	 * @param password
	 * @param qq
	 * @param gender
	 * @param address
	 * @param imgpath
	 * @param imgname
	 * @return
	 * @return String
	 * @throws
	 */
	public String loginByQq(String username, String password, String qq, String gender, String address, String imgpath, String imgname);

	/**
	 * @Title: registerByQq
	 * @Description:
	 * @param qq
	 * @param username
	 * @param gender
	 * @param address
	 * @param imgpath
	 * @param imgname
	 * @return
	 * @return boolean
	 * @throws
	 */
	boolean registerByQq(String password, String qq, String username, String gender, String address, String imgpath, String imgname);

	/**
	 * @Title: getUserInfoById
	 * @Description:
	 * @param id
	 * @return
	 * @return String
	 * @throws
	 */
	String getUserInfoById(Integer id);	
}
