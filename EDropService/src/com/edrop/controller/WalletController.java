/**
 * @Title: WalletController.java
 * @Package com.edrop.controller
 * @Description: 
 * @author 13071
 * @date 2019年12月11日
 * @version V1.0
 */
package com.edrop.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edrop.service.WalletService;

/**
 * @ClassName: WalletController
 * @Description: 
 * @author 13071
 * @date 2019年12月11日
 *
 */
@Controller
public class WalletController {
	@Resource
	private WalletService walletServiceImpl;
	/*
	 * 获取余额
	 */
	@RequestMapping("getSurplus")
	public void getSurplus(Integer uid, HttpServletResponse response) {
		String res = walletServiceImpl.getSurplus(uid);
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("modifyMoney")
	public void modifyMoney(Integer uid, Double money, Integer state, HttpServletResponse response) {
		String res = walletServiceImpl.modifyMoney(uid, money, state);
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
