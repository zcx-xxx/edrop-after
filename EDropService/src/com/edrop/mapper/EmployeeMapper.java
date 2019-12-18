/**
 * @Title: EmployeeMapper.java
 * @Package com.edrop.mapper
 * @Description: 
 * @author 13071
 * @date 2019年12月16日
 * @version V1.0
 */
package com.edrop.mapper;

import java.sql.Timestamp;

import org.apache.ibatis.annotations.Select;

import com.edrop.pojo.Employee;

/**
 * @ClassName: EmployeeMapper
 * @Description: 
 * @author 13071
 * @date 2019年12月16日
 *
 */
public interface EmployeeMapper {
	@Select("select * from employee where username like #{param1}")
	public Employee selEmployeeByUsername(String username);
	
	//插入用户数据
	public int insEmployeeInfo(String phone, String qq, String username, String password, String imgpath, String imgname, String gender, Timestamp registerTime);

	/*
	 * 根据 id 查询用户信息
	 */
	@Select("select * from employee where id=#{param1}")
	public Employee selEmployeeInfoById(Integer id);
}
