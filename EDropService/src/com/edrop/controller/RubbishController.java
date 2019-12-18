/**
 * @Title: RubbishController.java
 * @Package com.edrop.controller
 * @Description: 
 * @author 13071
 * @date 2019年11月28日
 * @version V1.0
 */
package com.edrop.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edrop.service.RubbishService;
import com.edrop.utils.IndentifyGarbageUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: RubbishController
 * @Description: 
 * @author 13071
 * @date 2019年11月28日
 *
 */
@Controller
public class RubbishController {
	@Resource
	private RubbishService rubbishServiceImpl;
	
	@RequestMapping("indentify")
	public void identifyGarbage(HttpServletRequest request, HttpServletResponse response) {
		try {
			InputStream is = request.getInputStream();
			
			File fpath = new File(request.getServletContext().getRealPath("/images"));
			if(!fpath.exists()) {
				//如果目录不存在，则创建
				fpath.mkdirs();
			}
			//通过目录加文件名存储文件
			File file = new File(fpath, "tmp.jpg");
			FileOutputStream fos = new FileOutputStream(file);
			
			int len = 0;
			byte[] bytes = new byte[1024];
			while((len = is.read(bytes)) != -1) {
				fos.write(bytes, 0, len);
			}
			
			is.close();
			fos.close();
			System.out.println("indetify");
			String json = IndentifyGarbageUtil.indentifyGarbage(file);
			if(json == null || json.length() == 0) {
				response.getWriter().print("fail");				
			} else {
				response.getWriter().print(json);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("searchRubbishByName")
	public void searchRubbishByName(String name, HttpServletResponse response) {
		System.out.println(name);
		String res = rubbishServiceImpl.selRubbishByName(name);
		System.out.println(res);
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
