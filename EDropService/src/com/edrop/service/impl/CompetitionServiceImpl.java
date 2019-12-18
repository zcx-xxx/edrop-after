/**
 * @Title: CompetitionServiceImpl.java
 * @Package com.edrop.service.impl
 * @Description: 
 * @author 13071
 * @date 2019年12月10日
 * @version V1.0
 */
package com.edrop.service.impl;

import org.springframework.stereotype.Service;

import com.edrop.mapper.CompetitionMapper;
import com.edrop.pojo.Competition;
import com.edrop.service.CompetitionService;
import com.google.gson.GsonBuilder;

import java.util.*;

import javax.annotation.Resource;

/**
 * @ClassName: CompetitionServiceImpl
 * @Description: 
 * @author 13071
 * @date 2019年12月10日
 *
 */
@Service
public class CompetitionServiceImpl implements CompetitionService{
	@Resource
	private CompetitionMapper competitionMapper;
	
	/*
	 * 随机查询十条数据
	 */
	@Override
	public String selRandData() {
		List<Competition> comps = competitionMapper.selRandData();
		String json = new GsonBuilder().serializeNulls().create().toJson(comps);
		return json;
	}
}
