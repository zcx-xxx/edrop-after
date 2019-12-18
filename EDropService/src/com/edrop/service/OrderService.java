/**
 * @Title: OrderService.java
 * @Package com.edrop.service
 * @Description: 
 * @author 13071
 * @date 2019年12月9日
 * @version V1.0
 */
package com.edrop.service;

/**
 * @ClassName: OrderService
 * @Description: 
 * @author 13071
 * @date 2019年12月9日
 *
 */
public interface OrderService {

	/**
	 * 生成订单
	 * @Title: generateOrder
	 * @Description:
	 * @param userId
	 * @param realName
	 * @param phone
	 * @param address
	 * @param reserveTime
	 * @return
	 * @return String
	 * @throws
	 */
	public String generateOrder(String userId, String realName, String phone, String address, String reserveTime);

	/**
	 * @Title: getOrderById
	 * @Description:
	 * @param id
	 * @return
	 * @return String
	 * @throws
	 */
	public String getOrderById(Integer id);

	/**
	 * @Title: getOrderByState
	 * @Description:
	 * @param state
	 * @return
	 * @return String
	 * @throws
	 */
	public String getOrderByState(Integer state);

	/**
	 * 接受订单
	 * @Title: receiveOrder
	 * @Description:
	 * @param id
	 * @param employeeId
	 * @return
	 * @return String
	 * @throws
	 */
	public String receiveOrder(Integer id, Integer employeeId);

	/**
	 * @Title: getOrderDoing
	 * @Description:
	 * @param employeeId
	 * @param state
	 * @return
	 * @return String
	 * @throws
	 */
	public String getOrderDoing(Integer employeeId, Integer state);

	/**
	 * 订单完成
	 * @Title: orderFinish
	 * @Description:
	 * @param id
	 * @param state
	 * @return
	 * @return String
	 * @throws
	 */
	public String orderFinish(Integer id, Integer state);

	/**
	 * @Title: getOrderFinish
	 * @Description:
	 * @param employeeId
	 * @param state
	 * @return
	 * @return String
	 * @throws
	 */
	public String getOrderFinish(Integer employeeId, Integer state);

	/**
	 * @Title: getOrdersByEmployeeId
	 * @Description:
	 * @param eid
	 * @return
	 * @return String
	 * @throws
	 */
	public String getOrdersByEmployeeId(Integer eid);
}
