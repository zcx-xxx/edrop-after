/**
 * @Title: RubbishMapper.java
 * @Package com.edrop.mapper
 * @Description: 
 * @author 13071
 * @date 2019年12月1日
 * @version V1.0
 */
package com.edrop.mapper;

import java.util.List;

import com.edrop.pojo.Rubbish;

/**
 * @ClassName: RubbishMapper
 * @Description: 
 * @author 13071
 * @date 2019年12月1日
 *
 */
public interface RubbishMapper {
	//通过名字对垃圾进行模糊查询
	public List<Rubbish> selRubbishByName(String name);
}
