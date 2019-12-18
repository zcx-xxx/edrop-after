/**
 * @Title: EmployeeService.java
 * @Package com.edrop.service
 * @Description: 
 * @author 13071
 * @date 2019年12月16日
 * @version V1.0
 */
package com.edrop.service;


/**
 * @ClassName: EmployeeService
 * @Description: 
 * @author 13071
 * @date 2019年12月16日
 *
 */
public interface EmployeeService {

	/**
	 * @Title: loginEmployeeByUsernameAndPassword
	 * @Description:
	 * @param username
	 * @param password
	 * @return
	 * @return String
	 * @throws
	 */
	public String loginEmployeeByUsernameAndPassword(String username, String password);

	/**
	 * @Title: registerEmployeeByUserName
	 * @Description:
	 * @param username
	 * @param password
	 * @return
	 * @return String
	 * @throws
	 */
	public String registerEmployeeByUserName(String username, String password);

	/**
	 * @Title: getEmployeeInfoById
	 * @Description:
	 * @param id
	 * @return
	 * @return String
	 * @throws
	 */
	public String getEmployeeInfoById(Integer id);
}
