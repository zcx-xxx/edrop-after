package com.edrop.jpush.push;

import cn.jiguang.common.resp.BaseResult;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class CIDResult extends BaseResult {

    /**
	 * @Fields field:field:
	 */
	private static final long serialVersionUID = 1L;
	@Expose public List<String> cidlist = new ArrayList<String>();
}
