/**
 * @Title: WalletService.java
 * @Package com.edrop.service
 * @Description: 
 * @author 13071
 * @date 2019年12月11日
 * @version V1.0
 */
package com.edrop.service;

/**
 * @ClassName: WalletService
 * @Description: 
 * @author 13071
 * @date 2019年12月11日
 *
 */
public interface WalletService {

	/**
	 * @Title: getSurplus
	 * @Description:
	 * @param uid
	 * @return
	 * @return String
	 * @throws
	 */
	public String getSurplus(Integer uid);

	/**
	 * @Title: modifyMoney
	 * @Description:
	 * @param uid
	 * @param money
	 * @return
	 * @return String
	 * @throws
	 */
	public String modifyMoney(Integer uid, Double money, Integer state);

	/**
	 * @Title: addNewUser
	 * @Description:
	 * @param id
	 * @return
	 * @return String
	 * @throws
	 */
	public String addNewUser(Integer id);

}
