/**
 * @Title: Competition.java
 * @Package com.edrop.mapper
 * @Description: 
 * @author 13071
 * @date 2019年12月10日
 * @version V1.0
 */
package com.edrop.mapper;

import java.util.List;

import com.edrop.pojo.Competition;

/**
 * @ClassName: Competition
 * @Description: 
 * @author 13071
 * @date 2019年12月10日
 *
 */
public interface CompetitionMapper {
	/*
	 * 随机查询数据
	 */
	public List<Competition> selRandData();
}
