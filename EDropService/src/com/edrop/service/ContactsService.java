/**
 * @Title: ContactsService.java
 * @Package com.edrop.service
 * @Description: 
 * @author 13071
 * @date 2019年12月17日
 * @version V1.0
 */
package com.edrop.service;

/**
 * @ClassName: ContactsService
 * @Description: 
 * @author 13071
 * @date 2019年12月17日
 *
 */
public interface ContactsService {

	/**
	 * @Title: addContact
	 * @Description:
	 * @param userId
	 * @param employeeId
	 * @return
	 * @return String
	 * @throws
	 */
	public String addContact(Integer userId, Integer employeeId);

	/**
	 * @Title: getContactsById
	 * @Description:
	 * @param userId
	 * @param employeeId
	 * @return
	 * @return String
	 * @throws
	 */
	public String getContactsById(Integer userId, Integer employeeId);

	/**
	 * @Title: getContactById
	 * @Description:
	 * @param userId
	 * @param employeeId
	 * @return
	 * @return String
	 * @throws
	 */
	public String getContactInfo(Integer userId, Integer employeeId);
}
