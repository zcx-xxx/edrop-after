package com.edrop.mapper;

import java.sql.Timestamp;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.edrop.pojo.Admin;

public interface AdminMapper {
	// select admin by username and password
	public Admin selectAdminByUserNameAndPassword(String userName, String password);
	
	// insert admin
	@Insert("insert into admin(username, password, register_time, last_login_time) values(#{param1},#{param2},#{param3},#{param4})")
	public Integer insertAdmin(String userName, String password, Timestamp registerTime, Timestamp lastLoginTime);
	
	// update last login time
	@Update("update admin set last_login_time=#{param2} where username like #{param1}")
	public Integer updateLastLoginTime(String userName, Timestamp lastLoginTime);
	
	// select admin by username
	public Admin selectAdminByUserName(String userName);
}
