/**
 * @Title: ContactsServiceImpl.java
 * @Package com.edrop.service.impl
 * @Description: 
 * @author 13071
 * @date 2019年12月17日
 * @version V1.0
 */
package com.edrop.service.impl;

import javax.annotation.Resource;
import java.util.*;
import org.springframework.stereotype.Service;

import com.edrop.mapper.ContactsMapper;
import com.edrop.pojo.Contacts;
import com.edrop.service.ContactsService;
import com.google.gson.GsonBuilder;

/**
 * @ClassName: ContactsServiceImpl
 * @Description: 
 * @author 13071
 * @date 2019年12月17日
 *
 */
@Service
public class ContactsServiceImpl implements ContactsService {
	@Resource
	private ContactsMapper contactsMapper;
	/*
	 * 插入联系人
	 */
	public int insContact(Integer userId, Integer employeeId) {
		return contactsMapper.insContact(userId, employeeId);
	}
	/*
	 * 查询联系人记录
	 */
	public Contacts selContact(Integer userId, Integer employeeId) {
		return contactsMapper.selContactByUserIdAndEmployeeId(userId, employeeId);
	}
	
	/*
	 * 根据 id 查询联系人列表
	 */
	public List<Contacts> selContactByUserIdOrEmployeeId(Integer userId, Integer employeeId){
		return contactsMapper.selContactByUserIdOrEmployeeId(userId, employeeId);
	}
	
	/*
	 * 添加联系人
	 */
	@Override
	public String addContact(Integer userId, Integer employeeId) {
		Contacts contacts = selContact(userId, employeeId);
		
		if(contacts == null) {
			int index = insContact(userId, employeeId);
			if(index == 1) {
				return "yes";
			} else {
				return "no";
			}
		}
		
		return "yes";
	}
	
	/*
	 * 获得联系人列表
	 * (非 Javadoc)
	 * <p>Title: getContactsById</p>
	 * <p>Description: </p>
	 * @param userId
	 * @param employeeId
	 * @return
	 * @see com.edrop.service.ContactsService#getContactsById(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public String getContactsById(Integer userId, Integer employeeId) {
		List<Contacts> contacts = selContactByUserIdOrEmployeeId(userId, employeeId);
		
		String res = "";
		if(contacts != null) {
			res = new GsonBuilder().serializeNulls().create().toJson(contacts);			
		}
		
		return res;
	}
	
	@Override
	public String getContactInfo(Integer userId, Integer employeeId) {
		Contacts contacts = selContact(userId, employeeId);
		return new GsonBuilder().serializeNulls().create().toJson(contacts);
	}
}
