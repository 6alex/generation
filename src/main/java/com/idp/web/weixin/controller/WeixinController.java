package com.idp.web.weixin.controller;
import com.idp.web.weixin.entity.Weixin;
import com.idp.web.weixin.service.WeixinService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idp.common.base.BaseController;
import com.idp.common.persistence.Page;
import com.idp.common.util.ValidateUtils;

import net.sf.json.JSONObject;

/**
 * 
 * 微信爬虫controller
 * 
 * <pre>
 * 	历史记录：
 * 	2018-12-17 wen
 * 	新建文件
 * </pre>
 * 
 * @author 
 * <pre>
 * SD
 * 	wen
 * PG
 *	wen
 * UT
 *
 * MA
 * </pre>
 * @version $Rev$
 *
 * <p/> $Id$
 *
 */
@Controller
@RequestMapping("/weixin")
public class WeixinController extends BaseController {

	private Logger logger = Logger.getLogger(WeixinController.class);

	@Resource
	private WeixinService weixinService;
	
	/**
	 * 
	 * <pre>
	 * 	2018-12-17 wen
	 * 	初始化查询页面
	 * </pre>
	 * 
	 * @return
	 */
	@RequestMapping("/init")
	public String init(){
		
		return "weixin/weixinSearch";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2018-12-17 wen
	 * 	分页查询
	 * </pre>
	 * 
	 * @param weixin
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Weixin weixin,Page<Weixin> page,HttpServletRequest request){
		
		try {
			
			request.setAttribute("page", weixinService.findByPage(weixin, page));
		} catch (Exception e) {
		
			logger.error(e.getMessage(), e);
		}
		
		return "weixin/weixinList";
	}

	/**
	 * 
	 * <pre>
	 * 	2018-12-17 wen
	 * 	新增修改页面初始化
	 * </pre>
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/weixin")
	public String weixin(String id,HttpServletRequest request){
		
		try {
			
			if(ValidateUtils.isNotEmpty(id)){
				
				Weixin weixin = weixinService.getById(id);
				request.setAttribute("weixin", weixin);
			}
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
		}
		
		return "weixin/weixin";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2018-12-17 wen
	 * 	保存
	 * </pre>
	 * 
	 * @param weixin
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(Weixin weixin){
		
		JSONObject json = new JSONObject();
		
		try {
			
			// 修改
			if(ValidateUtils.isNotEmpty(weixin.getId())){
				
				weixinService.update(weixin);
			}
			// 新增
			else{
				
				weixinService.add(weixin);
			}
			json.put("result", "save_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "save_fail");
		}
		
		return json.toString();
	}
	
	/**
	 * 
	 * <pre>
	 * 	2018-12-17 wen
	 * 	删除
	 * </pre>
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(String id){
		
		JSONObject json = new JSONObject();
		
		try {
			
			weixinService.delete(id);
			json.put("result", "delete_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "delete_fail");
		}
		
		return json.toString();
	}
}
