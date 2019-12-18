/**
 * @Title: EmployeeController.java
 * @Package com.edrop.controller
 * @Description: 
 * @author 13071
 * @date 2019年12月16日
 * @version V1.0
 */
package com.edrop.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edrop.service.EmployeeService;

/**
 * @ClassName: EmployeeController
 * @Description: 
 * @author 13071
 * @date 2019年12月16日
 *
 */
@Controller
public class EmployeeController {
	@Resource
	private EmployeeService employeeServiceImpl;
	
	//使用用户名和密码判断用户是否存在
	@RequestMapping("loginEmployeeByUsernameAndPassword")
	public void loginEmployeeByUsernameAndPassword(String username, String password, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		System.out.println(username + " " + password);
		String res = employeeServiceImpl.loginEmployeeByUsernameAndPassword(username, password);
//		System.out.println(res);
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 通过用户名注册
	 */
	@RequestMapping("registerEmployeeByUserName")
	public void registerEmployeeByUserName(String username, String password, HttpServletResponse response) {
		String res = employeeServiceImpl.registerEmployeeByUserName(username, password);
		System.out.println(res);
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 根据 id 获取用户信息
	 */
	@RequestMapping("getEmployeeInfoById")
	public void getEmployeeInfoById(Integer id, HttpServletResponse response) {
		String res = employeeServiceImpl.getEmployeeInfoById(id);
		System.out.println(res);
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
