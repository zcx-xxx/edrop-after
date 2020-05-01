package com.edrop.test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.multipart.MultipartFile;

import com.edrop.controller.UserController;
import com.sun.jersey.api.client.UniformInterfaceException;

@RunWith(SpringJUnit4ClassRunner.class) 
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:springmvc.xml","classpath:applicationcontext.xml"})
public class UserControllerTest extends AbstractTransactionalJUnit4SpringContextTests {
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	@Before
	public void setUp() throws Exception {
		this.request = new MockHttpServletRequest();
		this.response = new MockHttpServletResponse();
	}
/*
(HttpServletRequest request, HttpServletResponse response,
			Integer id, String detailAddress, String phone, String qq, String username, 
			String password, MultipartFile imgFile, String address, String gender)
 * 
 */
	@Test
	public void testAddUserInfo() throws UniformInterfaceException, IOException {
//		String id = "1025";;
		Integer id = 1025;
		String username = "zcx";
		String  phone = "15231165185";
		String gender = "男";
		String address = "山西省";
		String detailAddress = "长治市襄垣县";
		UserController userController = (UserController) this.applicationContext.getBean("userController");
		userController.addUserInfo(request, response, id, detailAddress, phone, null, username,
				null, null, address, gender);
//		fail("Not yet implemented");
	}

}
