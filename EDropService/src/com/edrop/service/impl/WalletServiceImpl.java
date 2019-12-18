/**
 * @Title: WalletServiceImpl.java
 * @Package com.edrop.service.impl
 * @Description: 
 * @author 13071
 * @date 2019年12月11日
 * @version V1.0
 */
package com.edrop.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.edrop.mapper.WalletMapper;
import com.edrop.pojo.Wallet;
import com.edrop.service.WalletService;
import com.google.gson.GsonBuilder;

/**
 * @ClassName: WalletServiceImpl
 * @Description: 
 * @author 13071
 * @date 2019年12月11日
 *
 */
@Service
public class WalletServiceImpl implements WalletService {
	@Resource
	private WalletMapper walletMapper;
	
	/*******************增删改查方法*******************/
	public Wallet selSurplus(Integer uid) {
		Wallet wallet = walletMapper.selSurplus(uid);
		return wallet;
	}
	
	public int upMoney(Integer uid, Double money) {
		int index = walletMapper.upMoney(uid, money);
		return index;
	}
	
	public int insUser(Integer id) {
		int index = walletMapper.insNewUser(id);
		return index;
	}
	
	/*******************业务操作*******************/
	/*
	 * 查询余额
	 */
	@Override
	public String getSurplus(Integer uid) {
		Wallet wallet = selSurplus(uid);
		if(wallet == null) {
			return "";
		} else {
			return new GsonBuilder().serializeNulls().create().toJson(wallet);
		}
	}
	/*
	 * 更新余额
	 * <p>Title: modifyMoney</p>
	 * <p>Description: </p>
	 * @param uid
	 * @param money
	 * @param state
	 * @return yes 表示修改成功，no 表示修改失败
	 * @see com.edrop.service.WalletService#modifyMoney(java.lang.Integer, java.lang.Double, java.lang.Integer)
	 */
	@Override
	public String modifyMoney(Integer uid, Double money, Integer state) {
		//规定 state 为 0 表示减钱，1 表示加钱
		if(state == 0) {
			money = money * (-1);
		}
		//更新
		int index = upMoney(uid, money);
		if(index == 1) {
			return "yes";
		} else {
			return "no";
		}
	}
	
	/*
	 * 插入新用户(非 Javadoc)
	 * <p>Title: addNewUser</p>
	 * <p>Description: </p>
	 * @param id
	 * @return yes 表示插入成功，no 表示插入失败
	 * @see com.edrop.service.WalletService#addNewUser(java.lang.Integer)
	 */
	@Override
	public String addNewUser(Integer id) {
		int index = insUser(id);
		if(index == 1) {
			return "yes";
		} else {
			return "no";
		}
	}
}
