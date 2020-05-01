package com.edrop.service;

import com.edrop.pojo.Admin;

public interface AdminService {
	/**
	 * login by userName and password
	 * @Title: loginByUserNameAndPassword   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param userName
	 * @param: @param password
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public String loginByUserNameAndPassword(String userName, String password);
	
	/**
	 * add Admin
	 * @Title: addAdmin   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param userName
	 * @param: @param password
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public String addAdmin(String userName, String password);
}
