/**
 * @Title: Constant.java
 * @Package com.edrop.utils
 * @Description: 
 * @author 13071
 * @date 2019年11月29日
 * @version V1.0
 */
package com.edrop.utils;

/**
 * @ClassName: Constant
 * @Description: 
 * @author 13071
 * @date 2019年11月29日
 *
 */
public class Constant {
	//登录相关
	public static final int USER_NO_EXISTS = 1;
	public static final int PASSWORD_WRONG = 3;
	public static final int LOGIN_FAIL = 5;
	public static final int LOGIN_SUCCESS = 2;
	public static final int NEW_USER = 4;
	public static final int SEARCH_SUCCESS = 6;
	
	//跟新用户数据
	public static final int UPDATE_USER_FAIL = 7;
	public static final int UPDATE_USER_SUCCESS = 8;
	
	//注册相关
	public static final int REGISTER_FAIL = 9;
	public static final int REGISTER_SUCCESS = 10;
	
	//订单相关
	public static final int ORDER_STATE_NO_RECEIVE = -1;    //未接单
	public static final int ORDER_STATE_NO_FINISH = 0;    //未完成
	public static final int ORDER_STATE_FINISH = 1;    //已完成
	public static final int ORDER_STATE_USER_DELETED = 1;    //删除
	public static final int ORDER_STATE_USER_NO_DELETE = 0;    //未删除
	public static final int ORDER_STATE_EMPLOYEE_DELETED = 1;    //删除
	public static final int ORDER_STATE_EMPLOYEE_NO_DELETE = 0;    //未删除
	
	//图片路径
	public static final String path = "http://122.51.69.212:8080/img/";
	
}
