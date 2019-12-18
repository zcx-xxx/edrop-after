/**
 * @Title: RubbishService.java
 * @Package com.edrop.service.impl
 * @Description: 
 * @author 13071
 * @date 2019年12月1日
 * @version V1.0
 */
package com.edrop.service;

/**
 * @ClassName: RubbishService
 * @Description: 
 * @author 13071
 * @date 2019年12月1日
 *
 */
public interface RubbishService {
	//根据名字模糊查询垃圾
	public String selRubbishByName(String name);
}
