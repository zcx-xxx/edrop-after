/**
 * @Title: RubbishServiceImpl.java
 * @Package com.edrop.service.impl
 * @Description: 
 * @author 13071
 * @date 2019年12月1日
 * @version V1.0
 */
package com.edrop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.edrop.mapper.RubbishMapper;
import com.edrop.pojo.Rubbish;
import com.edrop.service.RubbishService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @ClassName: RubbishServiceImpl
 * @Description: 
 * @author 13071
 * @date 2019年12月1日
 *
 */
@Service
public class RubbishServiceImpl implements RubbishService {
	@Resource
	private RubbishMapper rubbishMapper;
	/* (非 Javadoc)
	 * <p>Title: selRubbishByName</p>
	 * <p>Description: </p>
	 * @param name
	 * @return
	 * @see com.edrop.service.RubbishService#selRubbishByName(java.lang.String)
	 */
	@Override
	public String selRubbishByName(String name) {
		List<Rubbish> ruList = rubbishMapper.selRubbishByName(name);
		
		Gson gson = new  GsonBuilder().serializeNulls().create();
		String resGson = gson.toJson(ruList);
		
		return resGson;
	}
}
