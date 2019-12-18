/**
 * @Title: UserServiceImpl.java
 * @Package com.edrop.service.impl
 * @Description: 
 * @author 13071
 * @date 2019年11月27日
 * @version V1.0
 */
package com.edrop.service.impl;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.edrop.mapper.UserMapper;
import com.edrop.pojo.User;
import com.edrop.service.UserService;
import com.edrop.service.WalletService;
import com.edrop.utils.Constant;
import com.edrop.utils.MD5Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @ClassName: UserServiceImpl
 * @Description: 
 * @author 13071
 * @date 2019年11月27日
 *
 */
//注解方式配置为 bean 对象
@Service
public class UserServiceImpl implements UserService {
	//注解进行依赖注入（已经在配置文件中声明按名字进行依赖注入 ）
	@Resource
	private UserMapper userMapper;
	@Resource
	private WalletService walletServiceImpl;
	/** 
	 * 通过用户名和密码查询用户信息
	 * <p>Title: getUserInfo</p>
	 * <p>Description: </p>
	 * @param username
	 * @param password
	 * @return
	 * @see com.edrop.service.impl.UserService#getUserInfo(java.lang.String, java.lang.String)
	 */
	public int insUserInfo(String phone, String qq, String username, String password, String imgpath, String imgname, String address, String detailAddress, String gender, Timestamp registerTime) {
		return userMapper.insUserInfo(phone, qq, username, password, "/imgs", "defaulthead.jpg", address, detailAddress, gender, registerTime);
	}
	
	@Override
	public String selUserInfoByUsernameAndPassword(String username, String password) {
		User user = userMapper.selUserByUsername(username);
		
		JSONObject object = new JSONObject();
		
		//查不到返回用户不存在
		if(user == null) {
			object.put("state", Constant.USER_NO_EXISTS);
		} else {
			//查询成功，判断密码是否正确
			if(password != null) {
				//对密码进行 MD5 加密
				password = MD5Utils.MD5Encode(password);
				
				//密码不匹配返回密码错误
				if(!password.equals(user.getPassword())) {
					object.put("state", Constant.PASSWORD_WRONG);					
				} else {     //否则返回登录成功
					object.put("state", Constant.LOGIN_SUCCESS);
					object.put("user", new Gson().toJson(user));
				}
			} 
		}

		return object.toString();
	}
	/** 
	 * by phone search user
	 * (非 Javadoc)
	 * <p>Title: getUserInfo</p>
	 * <p>Description: </p>
	 * @param phone
	 * @return
	 * @see com.edrop.service.impl.UserService#getUserInfo(java.lang.String)
	 */
	@Override
	public User selUserByPhone(String phone) {
		User user = userMapper.selUserByPhone(phone);
		
		return user;
	}
	/**
	 *  (非 Javadoc)
	 * <p>Title: getUserInfoByQq</p>
	 * <p>Description: </p>
	 * @param qq
	 * @return
	 * @see com.edrop.service.impl.UserService#getUserInfoByQq(java.lang.String)
	 */
	@Override
	public String selUserInfoByQq(String qq) {
		User user = userMapper.selUserByQq(qq);
		
		JSONObject object = new JSONObject();
		
		if(user == null) {
			object.put("state", Constant.USER_NO_EXISTS);
		} else {
			object.put("state", Constant.LOGIN_SUCCESS);
			object.put("user", new Gson().toJson(user));
		}

		return object.toString();
	}
	/** 
	 * 插入手机号
	 * (非 Javadoc)
	 * <p>Title: insUserPhone</p>
	 * <p>Description: </p>
	 * @param phone
	 * @return
	 * @see com.edrop.service.UserService#insUserPhone(java.lang.String)
	 */
	@Override
	public int insUserPhone(String phone, Timestamp registerTime) {
		int index = insUserInfo(phone, null, null, null, null, null, null, null, null, registerTime);
		return index;
	}	
	/**
	 * 通过手机号获取用户信息，用户不存在进行注册
	 * 如果进行注册，同时需要在钱包中插入一条数据，余额置为 0
	 * (非 Javadoc)
	 * <p>Title: getUserInfoByPhone</p>
	 * <p>Description: </p>
	 * @param phone
	 * @return
	 * @see com.edrop.service.UserService#getUserInfoByPhone(java.lang.String)
	 */
	@Override
	public String getUserInfoByPhone(String phone) {
		User user = selUserByPhone(phone);
		
		JSONObject object = new JSONObject();
		//用户不存在，插入手机号
		if(user == null) {
			Timestamp registerTime = new Timestamp(System.currentTimeMillis());
			int index = insUserPhone(phone, registerTime);
			
			//插入成功
			if(index != -1) {
				//插入钱包
				User u = selUserByPhone(phone);
				int uid = u.getId();
				walletServiceImpl.addNewUser(uid);
				
				//封装用户信息返回
				user = new User();
				user.setPhone(phone);
				user.setId(uid);
				user.setRegisterTime(registerTime);
				object.put("state", Constant.NEW_USER);
			} else {
				object.put("state", Constant.LOGIN_FAIL);
				return object.toString();
			}
		} else {
			object.put("state", Constant.LOGIN_SUCCESS);
		}
		object.put("user", new GsonBuilder().serializeNulls().create().toJson(user));
		
		return object.toString();
	}
	
	/**
	 * 跟新用户信息
	 * (非 Javadoc)
	 * <p>Title: upUserInfo</p>
	 * <p>Description: </p>
	 * @param id
	 * @param phone
	 * @param qq
	 * @param username
	 * @param password
	 * @param imgpath
	 * @param imgname
	 * @param address
	 * @param gender
	 * @param detailAddress
	 * @return
	 * @see com.edrop.service.UserService#upUserInfo(java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String upUserInfo(Integer id, String phone, String qq, String username, String password, String imgpath, String imgname, String address, String gender, String detailAddress) {
		if(password != null && !password.equals("")) {
			password = MD5Utils.MD5Encode(password);
		}
		
		int index = userMapper.upUserInfo(id, phone, qq, username, password, imgpath, imgname, address, gender, detailAddress);
		
		JSONObject object = new JSONObject();
		
		if(index <= 0) {
			object.put("state", Constant.UPDATE_USER_FAIL);
		} else {
			object.put("state", Constant.UPDATE_USER_SUCCESS);
		}
		
		return object.toString();
	}
	
	/**
	 * 用户名注册
	 * (非 Javadoc)
	 * <p>Title: registerByUserName</p>
	 * <p>Description: </p>
	 * @param username
	 * @param password
	 * @return
	 * @see com.edrop.service.UserService#registerByUserName(java.lang.String, java.lang.String)
	 */
	@Override
	public String registerByUserName(String username, String password) {
		User user = userMapper.selUserByUsername(username);
		
		JSONObject object = new JSONObject();
		
		//用户不存在，可以成功注册
		if(user == null) {
			//插入新用户
			int index = insUsernameAndPassword(username, password);
			
			//钱包设为 0
			User u = userMapper.selUserByUsername(username);
			int uid = u.getId();
			walletServiceImpl.addNewUser(uid);
			
			//返回结果
			if(index != -1) {
				object.put("state", Constant.REGISTER_SUCCESS);
			} else {
				object.put("state", Constant.REGISTER_FAIL);
			}
		} else {  //用户以存在，注册失败
			object.put("state", Constant.REGISTER_FAIL);
		}
		
		return object.toString();
	}
	
	/**
	 * 插入用户名和密码
	 * (非 Javadoc)
	 * <p>Title: insUsernameAndPassword</p>
	 * <p>Description: </p>
	 * @param username
	 * @param password
	 * @return
	 * @see com.edrop.service.UserService#insUsernameAndPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public int insUsernameAndPassword(String username, String password) {
		Timestamp registerTime = new Timestamp(System.currentTimeMillis());
		if(password != null && password.length() > 0) {
			password = MD5Utils.MD5Encode(password);
		}
		int index = insUserInfo(null, null, username, password, null, null, null, null, null, registerTime);
		return index;
	}
	/**
	 * qq 注册
	 * @Title: registerByQq
	 * @Description:
	 * @param qq
	 * @param username
	 * @param gender
	 * @param address
	 * @param imgpath
	 * @param imgname
	 * @return
	 * @return boolean
	 * @throws
	 */
	@Override
	public boolean registerByQq(String password, String qq, String username, String gender, String address, String imgpath, String imgname) {
		//插入新用户
		Timestamp registerTime = new Timestamp(System.currentTimeMillis());
		int index = insUserInfo(null, qq, username, password, imgpath, imgname, address, null, gender, registerTime);

		if(index == 1) {
			//插入钱包
			User user = userMapper.selUserByQq(qq);
			int uid = user.getId();
			walletServiceImpl.addNewUser(uid);
			return true;
		} 
		return false;
	}
	
	/**
	 * qq 登录
	 * @Title: loginByQq
	 * @Description:
	 * @param qq
	 * @param gender
	 * @param address
	 * @param imgpath
	 * @param imgname
	 * @return
	 * @return String
	 * @throws
	 */
	@Override
	public String loginByQq(String username, String password, String qq, String gender, String address, String imgpath, String imgname) {
		//根据 qq 判断用户是否注册
		User user = userMapper.selUserByQq(qq);
		
		JSONObject object = new JSONObject();
		
		if(user == null) {
			//注册用户
//			String username =  System.currentTimeMillis() + "";
			boolean flag = registerByQq(password, qq, username, gender, address, imgpath, imgname);
			
			//返回结果信息
			if(flag) {
				object.put("state", Constant.REGISTER_SUCCESS);
				user = userMapper.selUserByQq(qq);
			} else {
				object.put("state", Constant.REGISTER_FAIL);
			}
		} else {
			object.put("state", Constant.LOGIN_SUCCESS);
		}
		object.put("user", new GsonBuilder().serializeNulls().create().toJson(user));
		return object.toString();
	}
	
	/**
	 * 根据 id 查询用户信息
	 * @Title: selUserInfoById
	 * @Description:
	 * @param id
	 * @return
	 * @return User
	 * @throws
	 */
	public User selUserInfoById(Integer id) {
		return userMapper.selUserInfoById(id);
	}
	
	/*
	 * 根据 id 获取用户信息
	 * <p>Title: getUserInfoById</p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 * @see com.edrop.service.UserService#getUserInfoById(java.lang.Integer)
	 */
	@Override
	public String getUserInfoById(Integer id) {
		User user = selUserInfoById(id);
		return new GsonBuilder().serializeNulls().create().toJson(user);
	}
}
