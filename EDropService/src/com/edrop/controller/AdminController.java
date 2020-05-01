package com.edrop.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.edrop.service.AdminService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource
	private AdminService adminServiceImpl;
	
	@RequestMapping("/login")
	public void login(String userName, String password, HttpServletResponse response) throws IOException {
		String res = adminServiceImpl.loginByUserNameAndPassword(userName, password);
		JSONObject json = new JSONObject();
		json.put("state", res);
		response.getWriter().print(json.toJSONString());
	}
	
	@RequestMapping("/add")
	public void addAdmin(String userName, String password, HttpServletResponse response) throws IOException {
		String res = adminServiceImpl.addAdmin(userName, password);
		JSONObject json = new JSONObject();
		json.put("state", res);
		response.getWriter().print(json.toJSONString());
	}
}
