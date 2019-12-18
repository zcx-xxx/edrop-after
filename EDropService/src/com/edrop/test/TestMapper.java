/**
 * @Title: TestMapper.java
 * @Package com.edrop.test
 * @Description: 
 * @author 13071
 * @date 2019年11月28日
 * @version V1.0
 */
package com.edrop.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.edrop.mapper.RubbishMapper;
import com.edrop.mapper.UserMapper;
import com.edrop.pojo.Rubbish;
import com.edrop.pojo.User;

/**
 * @ClassName: TestMapper
 * @Description: 
 * @author 13071
 * @date 2019年11月28日
 *
 */
public class TestMapper {
	@Test
	public void testQueryUser() throws IOException {
		//创建 Mybatis 对象
		//获取配置文件流对象
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		//获取 SqlSessionFactory 工厂(底层完成了配置文件的解析)
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//获取 SqlSession 对象
		SqlSession ss = factory.openSession();
		//获得 Mapper，相当于之前 Dao 接口的实例化对象
//		UserMapper mapper = ss.getMapper(UserMapper.class);
		RubbishMapper mapper = ss.getMapper(RubbishMapper.class);
		
		List<Rubbish> list = mapper.selRubbishByName("塑");
		System.out.println("haha" + list);
		
//		User user = mapper.queryUserById();
//		String 
		
//		System.out.println(user);
	}
}
