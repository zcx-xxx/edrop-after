/**
 * @Title: WalletMapper.java
 * @Package com.edrop.mapper
 * @Description: 
 * @author 13071
 * @date 2019年12月11日
 * @version V1.0
 */
package com.edrop.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.edrop.pojo.Wallet;

/**
 * @ClassName: WalletMapper
 * @Description: 
 * @author 13071
 * @date 2019年12月11日
 *
 */
public interface WalletMapper {
	/*
	 * 查询余额
	 */
	@Select("select * from wallet where pid = #{param1}")
	public Wallet selSurplus(Integer uid);
	
	/*
	 * 修改 余额
	 */
	public int upMoney(Integer uid, Double money);
	
	/*
	 * 注册新用户时插入
	 */
	@Insert("insert into wallet values(default, #{param1}, 0)")
	public int insNewUser(Integer id);
}
