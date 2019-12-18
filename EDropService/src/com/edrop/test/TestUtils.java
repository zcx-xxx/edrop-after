/**
 * @Title: TestUtils.java
 * @Package com.edrop.test
 * @Description: 
 * @author 13071
 * @date 2019年11月28日
 * @version V1.0
 */
package com.edrop.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import com.edrop.utils.IndentifyGarbageUtil;

/**
 * @ClassName: TestUtils
 * @Description: 
 * @author 13071
 * @date 2019年11月28日
 *
 */
public class TestUtils {
	@Test
	public void testIndentifyGarbage() throws IOException {
		File file = new File("H://test.jpg");
		FileInputStream fis = new FileInputStream(file);
		int len = 0;
		byte[] bytes = new byte[1024];
		StringBuffer buffer = new StringBuffer();
		
		while((len = fis.read(bytes)) != -1) {
			buffer.append(new String(bytes, 0, len));
		}
//		IndentifyGarbageUtil.indentifyGarbage("H:\\test.jpg");
//		util.indentifyGarbage();
	}
}
