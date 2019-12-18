/**
 * @Title: MyCon.java
 * @Package com.edrop.controller
 * @Description: 
 * @author 13071
 * @date 2019年11月27日
 * @version V1.0
 */
package com.edrop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edrop.service.UserService;

/**
 * @ClassName: MyCon
 * @Description: 
 * @author 13071
 * @date 2019年11月27日
 *
 */
@Controller
public class MyCon {
	@Resource
	private UserService userServiceImpl;
	
//	@RequestMapping("login")
//	public void userLogin(String uname, String pwd) {
//		System.out.println(uname + " " + pwd);
//		DDUser user = userServiceImpl.selUserInfoService(uname, pwd);
//		
//		if(user == null) {
//			System.out.println("fail");
//		} else {
//			System.out.println("success");
//		}
	
//		return;
//	}
	
	@RequestMapping("hello")
	public void hello() {
//		System.out.println("hello");
	}
}
