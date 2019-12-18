/**
 * @Title: UserMapper.java
 * @Package com.zcx.mapper
 * @Description: 
 * @author 13071
 * @date 2019年11月27日
 * @version V1.0
 */
package com.edrop.mapper;

import java.sql.Timestamp;

import org.apache.ibatis.annotations.Select;

import com.edrop.pojo.User;

/**
 * @ClassName: UserMapper
 * @Description: 
 * @author 13071
 * @date 2019年11月27日
 *
 */
public interface UserMapper {

	//通过用户名查询用户的信息
	@Select("select * from user where username like #{param1}")
	public User selUserByUsername(String username);
	
	//通过电话查询用户的信息
	@Select("select * from user where phone like #{param1}")
	public User selUserByPhone(String phone);

	//通过 qq 查询用户的信息
	@Select("select * from user where qq like #{param1}")
	public User selUserByQq(String qq);

	//跟新用户信息
	public int upUserInfo(Integer id, String phone, String qq, String username, String password, String imgpath, String imgname, String address, String gender, String detailAddress);
	
	//插入用户数据
	public int insUserInfo(String phone, String qq, String username, String password, String imgpath, String imgname, String address, String detailAddress, String gender, Timestamp registerTime);

	//密码查询用户信息
	@Select("select * from user where id = #{param1}")
	public User selUserInfoById(Integer id);
}
