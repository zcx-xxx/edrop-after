/**
 * @Title: CompetitionController.java
 * @Package com.edrop.controller
 * @Description: 
 * @author 13071
 * @date 2019年12月10日
 * @version V1.0
 */
package com.edrop.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edrop.service.CompetitionService;

/**
 * @ClassName: CompetitionController
 * @Description: 
 * @author 13071
 * @date 2019年12月10日
 *
 */
@Controller
public class CompetitionController {
	@Resource
	private CompetitionService competitionServiceImpl;
	
	@RequestMapping("getRandData")
	public void getRandData(HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		String res = competitionServiceImpl.selRandData();
		try {
			response.getWriter().print(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
