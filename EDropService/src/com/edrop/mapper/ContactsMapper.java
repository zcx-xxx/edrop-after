/**
 * @Title: ContactsMapper.java
 * @Package com.edrop.mapper
 * @Description: 
 * @author 13071
 * @date 2019年12月17日
 * @version V1.0
 */
package com.edrop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.edrop.pojo.Contacts;

/**
 * @ClassName: ContactsMapper
 * @Description: 
 * @author 13071
 * @date 2019年12月17日
 *
 */
public interface ContactsMapper {
	@Insert("insert into contacts values(default, #{param1}, #{param2})")
	public int insContact(Integer userId, Integer employeeId);
	
	@Select("select * from contacts where userId = #{param1} and employeeId = #{param2}")
	public Contacts selContactByUserIdAndEmployeeId(Integer userId, Integer employeeId);
	
	/*
	 * 通过 userId 或者 employeeId 查询聊天列表
	 */
	public List<Contacts> selContactByUserIdOrEmployeeId(Integer userId, Integer employeeId);

}
