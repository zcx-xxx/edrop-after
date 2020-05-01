package com.edrop.service.impl;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.edrop.mapper.AdminMapper;
import com.edrop.pojo.Admin;
import com.edrop.service.AdminService;
import com.edrop.utils.MD5Utils;

@Service
public class AdminServiceImpl implements AdminService{
	@Resource
	private AdminMapper adminMapper;

	@Override
	public String loginByUserNameAndPassword(String userName, String password) {
		String state = "";
		// 查询用户名和密码是否匹配
		if (password != null && password.length() > 0) {
			password = MD5Utils.MD5Encode(password);
			Admin admin = adminMapper.selectAdminByUserNameAndPassword(userName, password);
			if (admin != null) {
				// 匹配更新最后登录时间
				adminMapper.updateLastLoginTime(userName,new Timestamp(System.currentTimeMillis()));
				state = "success";
			} else {
				state = "fail";
			}
		} else {
			state = "fail";
		}
		
		return state;
	}

	@Override
	public String addAdmin(String userName, String password) {
		// 查询用户名是否已经存在
		String state = "";
		Admin admin = adminMapper.selectAdminByUserName(userName);
		if (admin != null) {
			state = "fail";
		} else {       // 不存在添加
			password = MD5Utils.MD5Encode(password);
			adminMapper.insertAdmin(userName, password, new Timestamp(System.currentTimeMillis()), 
					new Timestamp(System.currentTimeMillis()));
			state = "success";
		}
		return state;
	}
	
}
