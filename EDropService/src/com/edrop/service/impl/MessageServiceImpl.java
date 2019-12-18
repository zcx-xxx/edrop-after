/**
 * @Title: MessageServiceImpl.java
 * @Package com.edrop.service.impl
 * @Description: 
 * @author 13071
 * @date 2019年12月18日
 * @version V1.0
 */
package com.edrop.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.edrop.mapper.MessageMapper;
import com.edrop.service.MessageService;

/**
 * @ClassName: MessageServiceImpl
 * @Description: 
 * @author 13071
 * @date 2019年12月18日
 *
 */
@Service
public class MessageServiceImpl implements MessageService {
	@Resource
	private MessageMapper messageMapper;
}
