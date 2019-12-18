/**
 * @Title: OrderController.java
 * @Package com.edrop.controller
 * @Description: 
 * @author 13071
 * @date 2019年12月9日
 * @version V1.0
 */
package com.edrop.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edrop.service.OrderService;

/**
 * @ClassName: OrderController
 * @Description: 
 * @author 13071
 * @date 2019年12月9日
 *
 */
@Controller
public class OrderController {
	@Resource
	private OrderService orderServiceImpl;
	
	/*
	 * 生成订单
	 */
	@RequestMapping("generateOrder")
	public void generateOrder(HttpServletResponse response, String userId, String realName, String phone, String address, String reserveTime) {
		String res = orderServiceImpl.generateOrder(userId, realName, phone, address, reserveTime);
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 通过用户的 id 获取订单
	 */
	@RequestMapping("getOrderById")
	public void getOrderById(Integer userId, HttpServletResponse response) {
		String res = orderServiceImpl.getOrderById(userId);
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 获得所有相同状态的订单
	 */
	@RequestMapping("getOrderByState")
	public void getOrderByState(Integer state, HttpServletResponse response) {
		String res = orderServiceImpl.getOrderByState(state);
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 通过工作人员的编号和订单的状态获取订单列表
	 */
	@RequestMapping("getOrderDoing")
	public void getOrderDoing(@RequestParam("userId")Integer employeeId, Integer state, HttpServletResponse response) {
		String res = orderServiceImpl.getOrderDoing(employeeId, state);
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 通过工作人员的编号和订单的状态获取订单列表
	 */
	@RequestMapping("getOrderFinish")
	public void getOrderFinish(@RequestParam("userId")Integer employeeId, Integer state, HttpServletResponse response) {
		String res = orderServiceImpl.getOrderDoing(employeeId, state);
//		String res = null;
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 接受订单
	 */
	@RequestMapping("receiveOrder")
	public void receiveOrder(@RequestParam("userId")Integer employeeId, @RequestParam("orderId")Integer id, HttpServletResponse response) {
		String res = orderServiceImpl.receiveOrder(id, employeeId);
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 订单完成
	 */
	@RequestMapping("orderFinish")
	public void orderFinish(@RequestParam("orderId")Integer id, Integer state, HttpServletResponse response) {
		String res = orderServiceImpl.orderFinish(id, state);
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 通过员工的 Id 查询所有的订单
	 */
	@RequestMapping("getOrdersByEmployeeId")
	public void getOrdersByEmployeeId(Integer eid, HttpServletResponse response) {
		String res = orderServiceImpl.getOrdersByEmployeeId(eid);
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
