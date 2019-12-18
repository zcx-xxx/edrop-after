/**
 * @Title: TestRubbishService.java
 * @Package com.edrop.test
 * @Description: 
 * @author 13071
 * @date 2019年12月3日
 * @version V1.0
 */
package com.edrop.test;

import java.util.List;

import org.junit.Test;

import com.edrop.pojo.Rubbish;
import com.edrop.service.RubbishService;
import com.edrop.service.impl.RubbishServiceImpl;

/**
 * @ClassName: TestRubbishService
 * @Description: 
 * @author 13071
 * @date 2019年12月3日
 *
 */
public class TestRubbishService {
	@Test
	public void testSelRubbish() {
		RubbishService test = new RubbishServiceImpl();
		String list = test.selRubbishByName("塑");
		System.out.println(list);
	}
}
