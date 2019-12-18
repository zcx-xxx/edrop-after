/**
 * @Title: EmployeeServiceImpl.java
 * @Package com.edrop.service.impl
 * @Description: 
 * @author 13071
 * @date 2019年12月16日
 * @version V1.0
 */
package com.edrop.service.impl;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.edrop.mapper.EmployeeMapper;
import com.edrop.pojo.Employee;
import com.edrop.service.EmployeeService;
import com.edrop.service.WalletService;
import com.edrop.utils.Constant;
import com.edrop.utils.MD5Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @ClassName: EmployeeServiceImpl
 * @Description: 
 * @author 13071
 * @date 2019年12月16日
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Resource
	private EmployeeMapper employeeMapper;
	@Resource
	private WalletService walletServiceImpl;
	
	/************ 分装增删改查 ***************/
	public Employee selEmployeeByUsername(String username) {
		return employeeMapper.selEmployeeByUsername(username);
	}
	
	public int insEmployeeUsernameAndPassword(String username, String password) {
		return employeeMapper.insEmployeeInfo(null, null, username, password, "/imgs", "defaulthead.jpg", null, null);
	}
	
	public Employee selEmployeeInfoById(Integer id) {
		return employeeMapper.selEmployeeInfoById(id);
	}
	
	/************* 具体操作 *******************/
	@Override
	public String loginEmployeeByUsernameAndPassword(String username, String password) {
		Employee employee = selEmployeeByUsername(username);
		
		JSONObject object = new JSONObject();
		
		//查不到返回用户不存在
		if(employee == null) {
			object.put("state", Constant.USER_NO_EXISTS);
		} else {
			//查询成功，判断密码是否正确
			if(password != null) {
				//对密码进行 MD5 加密
				password = MD5Utils.MD5Encode(password);
				
				//密码不匹配返回密码错误
				if(!password.equals(employee.getPassword())) {
					object.put("state", Constant.PASSWORD_WRONG);					
				} else {     //否则返回登录成功
					object.put("state", Constant.LOGIN_SUCCESS);
					object.put("user", new Gson().toJson(employee));
				}
			} 
		}

		return object.toString();
	}
	
	@Override
	public String registerEmployeeByUserName(String username, String password) {
//		User user = userMapper.selUserByUsername(username);
		Employee employee = selEmployeeByUsername(username);
		
		JSONObject object = new JSONObject();
		
		//用户不存在，可以成功注册
		if(employee == null) {
			//插入新用户
			int index = insEmployeeUsernameAndPassword(username, password);
			
			//钱包设为 0
			Employee e = selEmployeeByUsername(username);
			int eid = e.getId();
			walletServiceImpl.addNewUser(eid);
			
			//返回结果
			if(index != -1) {
				object.put("state", Constant.REGISTER_SUCCESS);
			} else {
				object.put("state", Constant.REGISTER_FAIL);
			}
		} else {  //用户以存在，注册失败
			object.put("state", Constant.REGISTER_FAIL);
		}
		
		return object.toString();
	}
	
	/*
	 * 通过 id 获取员工的信息
	 */
	@Override
	public String getEmployeeInfoById(Integer id) {
		Employee employee = selEmployeeInfoById(id);
		return new GsonBuilder().serializeNulls().create().toJson(employee);
	}
	
}
