/**
 * @Title: OrderServiceImpl.java
 * @Package com.edrop.service.impl
 * @Description: 
 * @author 13071
 * @date 2019年12月9日
 * @version V1.0
 */
package com.edrop.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.edrop.jpush.examples.PushExample;
import com.edrop.mapper.OrderMapper;
import com.edrop.pojo.Order;
import com.edrop.service.OrderService;
import com.edrop.utils.Constant;
import com.google.gson.GsonBuilder;

/**
 * @ClassName: OrderServiceImpl
 * @Description: 
 * @author 13071
 * @date 2019年12月9日
 *
 */
@Service
public class OrderServiceImpl implements OrderService{
	@Resource
	private OrderMapper orderMapper;
	/*
	 * 插入订单
	 */
	public int insOrder(String number, Integer userId, Integer employeeId,
			Timestamp reserveTime, Timestamp createTime, Timestamp finishTime,
			int state, int userDeleteState, int employeeDeleteState, String orderAddress,
			String ouname, String outelephone) {
		int index = orderMapper.insOrderInfo(number, userId, employeeId, reserveTime, createTime, finishTime, state, userDeleteState, employeeDeleteState, orderAddress, ouname, outelephone);
		return index;
	}
	
	/*
	 * 通过用户的 id 查询订单
	 */
	public List<Order> selOrderById(Integer id){
		return orderMapper.selOrderById(id);
	}
	
	/*
	 * 通过状态查询所有的订单
	 */
	public List<Order> selOrderByState(Integer state){
		return orderMapper.selOrderByState(state);
	}
	
	/*
	 * 根据 id 跟新指定订单表的状态
	 */
	public int upOrderState(Integer id, Integer state) {
		return orderMapper.upOrderState(id, state);
	}
	
	/*
	 * 根据 id 修改订单表的 employeeId
	 */
	public int upOrderEmployeeId(Integer employeeId, Integer id) {
		return orderMapper.upOrderEmployeeId(employeeId, id);
	}
	/*
	 * 根据 id 修改订单表的 createTime
	 */
	public int upOrderCreateTime(Integer id, Timestamp time) {
		return orderMapper.upOrderCreateTime(id, time);
	}
	/*
	 * 根据员工的 employeeId 和 订单的状态查询订单列表
	 */
	public List<Order> selOrderByEmployeeIdAndState(Integer employeeId, Integer state){
		return orderMapper.selOrderByEmployeeIdAndState(employeeId, state);
	}
	
	/*
	 * 订单完成后状态的更新
	 */
	public int upOrderFinish(Integer id, Timestamp finishTime, Integer state) {
		return orderMapper.upOrderFinish(id, finishTime, state);
	}
	/*
	 * 根据 eid 查询相应的订单
	 */
	public List<Order> selOrdersByEmployeeId(Integer eid){
		return orderMapper.selOrdersByEmployeeId(eid);
	}
	
	/*
	 * 订单完成
	 * <p>Title: orderFinish</p>
	 * <p>Description: </p>
	 * @param id
	 * @param state
	 * @return
	 * @see com.edrop.service.OrderService#orderFinish(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public String orderFinish(Integer id, Integer state) {
		int index = upOrderFinish(id, new Timestamp(System.currentTimeMillis()), state);
		if(index == 1) {
			return "yes";
		} else {
			return "no";
		}
	}
	
	/*
	 * 获得正在进行的订单
	 * <p>Title: getOrderDoing</p>
	 * <p>Description: </p>
	 * @param employeeId
	 * @param state
	 * @return
	 * @see com.edrop.service.OrderService#getOrderDoing(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public String getOrderDoing(Integer employeeId, Integer state) {
		List<Order> orders = selOrderByEmployeeIdAndState(employeeId, state);
		if(orders != null) {
			return new GsonBuilder().serializeNulls().create().toJson(orders);
		} else {
			return "";
		}
	}
	
	/*
	 * 查询已经完成的订单
	 * <p>Title: getOrderFinish</p>
	 * <p>Description: </p>
	 * @param employeeId
	 * @param state
	 * @return
	 * @see com.edrop.service.OrderService#getOrderFinish(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public String getOrderFinish(Integer employeeId, Integer state) {
		List<Order> orders = selOrderByEmployeeIdAndState(employeeId, state);
		if(orders != null) {
			return new GsonBuilder().serializeNulls().create().toJson(orders);
		} else {
			return "";
		}
	}
	
	/*
	 * 接受订单
	 * <p>Title: receiveOrder</p>
	 * <p>Description: </p>
	 * @param id
	 * @param employeeId
	 * @return
	 * @see com.edrop.service.OrderService#receiveOrder(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public String receiveOrder(Integer id, Integer employeeId) {
		//首先更改订单状态，接单改为 0
		int index1 = upOrderState(id, 0);
		
		//然后跟新 employeeId
		int index2 = upOrderEmployeeId(employeeId, id);
		
		//最后修改订单的创建时间
		int index3 = upOrderCreateTime(id, new Timestamp(System.currentTimeMillis()));
		
		if(index1 + index2 + index3 == 3) {
			PushExample.testSendPush_fromJSON();
			return "yes";
		} else {
			return "no";
		}
	}
	
	@Override
	public String generateOrder(String userId, String realName, String phone, String address, String reserveTime) {
		//首先插入订单
		String number = UUID.randomUUID() + "";
		number = number.replace("-", "");
		Timestamp time = Timestamp.valueOf(reserveTime + ":09");
		int index = insOrder(number, Integer.valueOf(userId), null, time, null, null, Constant.ORDER_STATE_NO_RECEIVE, Constant.ORDER_STATE_USER_NO_DELETE, Constant.ORDER_STATE_EMPLOYEE_NO_DELETE, address, realName, phone);
		
		//将用户所有的订单返回
		if(index == 1) {
			List<Order> orderList = selOrderById(Integer.valueOf(userId));
			return new GsonBuilder().serializeNulls().create().toJson(orderList);
		}
		
		//无订单返回空串
		return "";
	}
	
	@Override
	public String getOrderById(Integer id) {
		List<Order> orders = selOrderById(id);
		
		if(orders != null) {
			return new GsonBuilder().serializeNulls().create().toJson(orders);
		} else {
			return "";
		}
	}
	
	@Override
	public String getOrderByState(Integer state) {
		List<Order> orders = selOrderByState(state);
		
		if(orders != null) {
			return new GsonBuilder().serializeNulls().create().toJson(orders);
		} else {
			return "";
		}
	}
	
	@Override
	public String getOrdersByEmployeeId(Integer eid) {
		List<Order> orders = selOrdersByEmployeeId(eid);
		return new GsonBuilder().serializeNulls().create().toJson(orders);
	}
}
