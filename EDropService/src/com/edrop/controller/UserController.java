/**
 * @Title: UserController.java
 * @Package com.edrop.controller
 * @Description: 
 * @author 13071
 * @date 2019年11月29日
 * @version V1.0
 */
package com.edrop.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.edrop.service.UserService;
import com.sun.jersey.api.client.UniformInterfaceException;

/**
 * @ClassName: UserController
 * @Description: 
 * @author 13071
 * @date 2019年11月29日
 *
 */
@Controller
public class UserController {
	@Resource
	private UserService userServiceImpl;
	
	//使用用户名和密码判断用户是否存在
	@RequestMapping("loginByUsernameAndPassword")
	public void loginByUsernameAndPassword(String username, String password, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		System.out.println(username + " " + password);
		String res = userServiceImpl.selUserInfoByUsernameAndPassword(username, password);
		System.out.println(res);
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//使用手机号判断用户是否存在
	@RequestMapping("loginByPhone")
	public void loginByPhone(String phone, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		String res = userServiceImpl.getUserInfoByPhone(phone);
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//使用 qq 判断用户是否存在
	@RequestMapping("loginByQq")
	public void loginByQq(String username, String password, String qq, String gender, String address, MultipartFile imgFile, HttpServletResponse response, HttpServletRequest request) {
		response.setCharacterEncoding("utf-8");
		String newName = null;
		if(imgFile != null) {
			//获取后缀名
			String suffixName = imgFile.getOriginalFilename().substring(imgFile.getOriginalFilename().lastIndexOf("."));
			//动态生成文件名
			String fileName = "" + UUID.randomUUID() + System.currentTimeMillis();
			//拼接文件名
			newName = fileName + suffixName;
			
			//路径
			String path = request.getServletContext().getRealPath("/imgs");
			File fpath = new File(path);
			
			//通过目录加文件名存储文件
			File file = new File(fpath, newName);
			try {
				//将文件存储到服务器
				imgFile.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		String res = userServiceImpl.loginByQq(username, password, qq, gender, address, "/imgs", newName);
		
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//手机号注册
	@RequestMapping("registerByPhone")
	public void registerByPhone(String phone, String username, String password) {
		
	}
	
	//更新用户数据
	@RequestMapping("addUserInfo")
	public void addUserInfo(HttpServletRequest request, HttpServletResponse response, Integer id, String detailAddress, String phone, String qq, String username, String password, MultipartFile imgFile, String address, String gender) throws UniformInterfaceException, IOException {
		System.out.println(id + " " + gender);
		String newName = "";
		
		if(imgFile != null) {
			//获取后缀名
			String suffixName = imgFile.getOriginalFilename().substring(imgFile.getOriginalFilename().lastIndexOf("."));
			//动态生成文件名
			String fileName = "" + UUID.randomUUID() + System.currentTimeMillis();
			//拼接文件名
			newName = fileName + suffixName;
			String path = request.getServletContext().getRealPath("/imgs");
			File fpath = new File(path);
			//通过目录加文件名存储文件
			File file = new File(fpath, newName);

			try {
				//将文件存储到服务器
				imgFile.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		//更新数据
		String res = userServiceImpl.upUserInfo(id, phone, qq, username, password, "/imgs", newName, address, gender, detailAddress);
		System.out.println(res);
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 通过用户名注册
	 */
	@RequestMapping("registerByUserName")
	public void registerByUserName(String username, String password, HttpServletResponse response) {
		String res = userServiceImpl.registerByUserName(username, password);
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
	@RequestMapping("getUserInfoById")
	public void getUserInfoById(Integer id, HttpServletResponse response) {
		String res = userServiceImpl.getUserInfoById(id);
		System.out.println(res);
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
















