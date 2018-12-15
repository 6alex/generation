package com.idp.common.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.idp.common.constant.SessionAttr;
import com.idp.common.interceptor.DateConvertEditor;
import com.idp.common.util.ContextHolderUtil;
import com.idp.web.system.entity.SysUser;

import net.sf.json.JSONObject;

/**
 * 基础controller
 * 
 * @author King
 *
 */
public class BaseController {

	/**
	 * 将前台传递过来的日期格式的字符串，自动转化为Date类型
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {

		binder.registerCustomEditor(Date.class, new DateConvertEditor());
	}
	
	/**
	 * 抽取由逗号分隔的主键列表
	 * 
	 * @param ids
	 * @return
	 */
	protected List<String> extractIdListByComma(String ids) {
        List<String> result = new ArrayList<String>();
        if (StringUtils.hasText(ids)) {
            for (String id : ids.split(",")) {
                if (StringUtils.hasLength(id)) {
                    result.add(id.trim());
                }
            }
        }

        return result;
    }
	
	/**
	 * 获取登录的当前用户信息
	 * 
	 * @return
	 */
	public SysUser getCurrentUser(){
		
		HttpSession session = ContextHolderUtil.getSession();
		SysUser user = (SysUser)session.getAttribute(SessionAttr.USER_LOGIN.getValue());
		
		return user;
	}
	
	public String returnBlankResult(){
		JSONObject result = new JSONObject();
		result.put("msg", "数据为空！");
		result.put("code", "1");
		return result.toString();
	}
	
	public String returnExceptionResult(String msg){
		JSONObject result = new JSONObject();
		result.put("msg", msg);
		result.put("code", "1");
		return result.toString();
	}
	
	public String returnSuccessResult(JSONObject data){
		JSONObject result = new JSONObject();
		result.put("msg", "成功");
		result.put("code", "0");
		result.put("data", data);
		return result.toString();
	}
}
