/**
 * @Title: OrderMapper.java
 * @Package com.edrop.mapper
 * @Description: 
 * @author 13071
 * @date 2019年12月9日
 * @version V1.0
 */
package com.edrop.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.edrop.pojo.Order;

/**
 * @ClassName: OrderMapper
 * @Description: 
 * @author 13071
 * @date 2019年12月9日
 *
 */
public interface OrderMapper {
	/*
	 * 插入订单信息
	 */
	public int insOrderInfo(String number, Integer userId, Integer employeeId,
			Timestamp reserveTime, Timestamp createTime, Timestamp finishTime,
			int state, int userDeleteState, int employeeDeleteState, String orderAddress,
			String ouname, String outelephone);
	/*
	 * 查询所有订单
	 */
	@Select("select * from orders where userId = #{param1} order by id desc")
	public List<Order> selOrderById(Integer id);
	/*
	 * 根据员工的 employeeId 和 订单的状态查询订单列表
	 */
	@Select("select * from orders where employeeId=#{param1} and state=#{param2} order by id desc")
	public List<Order> selOrderByEmployeeIdAndState(Integer employeeId, Integer state);
	
	/*
	 * 根据指定的状态查询所有的订单
	 */
	@Select("select * from orders where state=#{param1} order by id desc")
	public List<Order> selOrderByState(Integer state);
	
	/*
	 * 跟新指定订单的订单状态
	 */
	@Update("update orders set state=#{param2} where id=#{param1} and state=#{param2}-1")
	public int upOrderState(Integer id, Integer state);
	
	/*
	 * 更新订单表的员工 id
	 */
	@Update("update orders set employeeId=#{param1} where id=#{param2}")
	public int upOrderEmployeeId(Integer employeeId, Integer id);
	/*
	 * 更新订单表的员工 id
	 */
	@Update("update orders set createTime=#{param2} where id=#{param1}")
	public int upOrderCreateTime(Integer id, Timestamp createTime);
	/*
	 * 更新订单表的完成时间和状态
	 */
	@Update("update orders set finishTime=#{param2},state=#{param3} where id=#{param1}")
	public int upOrderFinish(Integer id, Timestamp finishTime, Integer state);
	/*
	 * 根据员工的 id 查询其所有的订单
	 */
	@Select("select * from orders where employeeId=#{param1} and state!=-1")
	public List<Order> selOrdersByEmployeeId(Integer eid);
}
