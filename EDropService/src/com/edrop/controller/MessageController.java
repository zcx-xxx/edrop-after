/**
 * @Title: MessageController.java
 * @Package com.edrop.controller
 * @Description: 
 * @author 13071
 * @date 2019年12月18日
 * @version V1.0
 */
package com.edrop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.edrop.service.MessageService;

/**
 * @ClassName: MessageController
 * @Description: 
 * @author 13071
 * @date 2019年12月18日
 *
 */
@Controller
public class MessageController {
	@Resource
	private MessageService messageServiceImpl;
	
	
}
