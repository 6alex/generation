package com.idp.web.cms.controller;
import com.idp.web.cms.entity.TCms;
import com.idp.web.cms.service.TCmsService;
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
 * 通用cmscontroller
 * 
 * <pre>
 * 	历史记录：
 * 	2018-12-07 wen
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
@RequestMapping("/tCms")
public class TCmsController extends BaseController {

	private Logger logger = Logger.getLogger(TCmsController.class);

	@Resource
	private TCmsService tCmsService;
	
	/**
	 * 
	 * <pre>
	 * 	2018-12-07 wen
	 * 	初始化查询页面
	 * </pre>
	 * 
	 * @return
	 */
	@RequestMapping("/init")
	public String init(){
		
		return "cms/tCmsSearch";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2018-12-07 wen
	 * 	分页查询
	 * </pre>
	 * 
	 * @param tCms
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(TCms tCms,Page<TCms> page,HttpServletRequest request){
		
		try {
			
			request.setAttribute("page", tCmsService.findByPage(tCms, page));
		} catch (Exception e) {
		
			logger.error(e.getMessage(), e);
		}
		
		return "cms/tCmsList";
	}

	/**
	 * 
	 * <pre>
	 * 	2018-12-07 wen
	 * 	新增修改页面初始化
	 * </pre>
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/tCms")
	public String tCms(String id,HttpServletRequest request){
		
		try {
			
			if(ValidateUtils.isNotEmpty(id)){
				
				TCms tCms = tCmsService.getById(id);
				request.setAttribute("tCms", tCms);
			}
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
		}
		
		return "cms/tCms";
	}
	
	/**
	 * 
	 * <pre>
	 * 	2018-12-07 wen
	 * 	保存
	 * </pre>
	 * 
	 * @param tCms
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(TCms tCms){
		
		JSONObject json = new JSONObject();
		
		try {
			
			// 修改
			if(ValidateUtils.isNotEmpty(tCms.getId())){
				
				tCmsService.update(tCms);
			}
			// 新增
			else{
				
				tCmsService.add(tCms);
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
	 * 	2018-12-07 wen
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
			
			tCmsService.delete(id);
			json.put("result", "delete_success");
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			json.put("result", "delete_fail");
		}
		
		return json.toString();
	}
}
