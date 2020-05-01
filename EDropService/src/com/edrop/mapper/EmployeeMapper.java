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

import org.apache.ibatis.annotations.Param;
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
	// by username query Employee
	public Employee selEmployeeByUsername(@Param("username")String username);
	
	//插入用户数据
	public int insEmployeeInfo(@Param("phone")String phone, @Param("qq")String qq, @Param("username")String username, 
			@Param("password")String password, @Param("imgpath")String imgpath, @Param("imgname")String imgname, 
			@Param("gender")String gender, @Param("registerTime")Timestamp registerTime);
	
	// by id query Employee
	public Employee selEmployeeInfoById(@Param("id")Integer id);
}
