/**
 * @Title: ContactsController.java
 * @Package com.edrop.controller
 * @Description: 
 * @author 13071
 * @date 2019年12月17日
 * @version V1.0
 */
package com.edrop.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edrop.service.ContactsService;

/**
 * @ClassName: ContactsController
 * @Description: 
 * @author 13071
 * @date 2019年12月17日
 *
 */
@Controller
public class ContactsController {
	@Resource
	private ContactsService contactsServiceImpl;
	
	@RequestMapping("addContact")
	public void addContact(Integer userId, Integer employeeId, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		String res = contactsServiceImpl.addContact(userId, employeeId);
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("getContactsById")
	public void getContactsById(Integer userId, Integer employeeId, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		String res = contactsServiceImpl.getContactsById(userId, employeeId);
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("getContactInfo")
	public void getContactInfo(Integer userId, Integer employeeId, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		String res = contactsServiceImpl.getContactInfo(userId, employeeId);
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
