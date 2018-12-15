package com.idp.web.table.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idp.common.base.BaseController;
import com.idp.common.persistence.Page;
import com.idp.common.util.ValidateUtils;
import com.idp.web.table.entity.GTable;
import com.idp.web.table.service.GTableService;

import net.sf.json.JSONObject;

/**
 * 
 * 自动建表controller
 * 
 * <pre>
 * 	历史记录：
 * 	2018-12-04 wencun
 * 	新建文件
 * </pre>
 * 
 * @author
 * 
 *         <pre>
 * SD
 * 	wencun
 * PG
 *	wencun
 * UT
 *
 * MA
 *         </pre>
 * 
 * @version $Rev$
 *
 *          <p/>
 *          $Id$
 *
 */
@Controller
@RequestMapping("/gTable")
public class GTableController extends BaseController {

	private Logger logger = Logger.getLogger(GTableController.class);

	@Resource
	private GTableService gTableService;

	/**
	 * 
	 * <pre>
	 * 	2018-12-04 wencun
	 * 	初始化查询页面
	 * </pre>
	 * 
	 * @return
	 */
	@RequestMapping("/init")
	public String init() {

		return "table/gTableSearch";
	}

	/**
	 * 
	 * <pre>
	 * 	2018-12-04 wencun
	 * 	分页查询
	 * </pre>
	 * 
	 * @param gTable
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(GTable gTable, Page<GTable> page, HttpServletRequest request) {

		try {
			gTable.setGroupId("0");
			request.setAttribute("page", gTableService.findByPage(gTable, page));
		} catch (Exception e) {

			logger.error(e.getMessage(), e);
		}

		return "table/gTableList";
	}

	/**
	 * 
	 * <pre>
	 * 	2018-12-04 wencun
	 * 	新增修改页面初始化
	 * </pre>
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/gTable")
	public String gTable(String id, HttpServletRequest request) {

		try {
			request.setAttribute("dbColumnTypes", JdbcType.values());
			if (ValidateUtils.isNotEmpty(id)) {

				GTable gTable = gTableService.getById(id);
				request.setAttribute("gTable", gTable);
			}
		} catch (Exception e) {

			logger.error(e.getMessage(), e);
		}

		return "table/gTable";
	}

	/**
	 * @Description: 自动生成表sql语句建表
	 * @param id
	 * @param request
	 * @return
	 * @return: String
	 * @author: Alex.wen
	 * @date: 2018年12月8日 上午11:42:37
	 */
	@RequestMapping("/generation")
	@ResponseBody
	public String generation(String id, HttpServletRequest request) {
		JSONObject result=new JSONObject();
		try {
			GTable gTable = gTableService.getById(id);
			if(null==gTable){
				return returnBlankResult();
			}
			List<GTable> children = gTable.getChildren();
			if(CollectionUtils.isEmpty(children)){
				return returnExceptionResult("请添加表字段！");
			}
		} catch (Exception e) {

			logger.error(e.getMessage(), e);
		}

		return null;
	}

	/**
	 * 
	 * <pre>
	 * 	2018-12-04 wencun
	 * 	保存
	 * </pre>
	 * 
	 * @param gTable
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(GTable gTable) {
		JSONObject json = new JSONObject();
		try {
			// 修改
			if (ValidateUtils.isNotEmpty(gTable.getId())) {
				gTableService.update(gTable);
			}
			// 新增
			else {
				gTableService.add(gTable);
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
	 * 	2018-12-04 wencun
	 * 	删除
	 * </pre>
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(GTable gTable) {
		JSONObject json = new JSONObject();
		try {
			gTableService.delete(gTable);
			json.put("result", "delete_success");
		} catch (Exception e) {

			logger.error(e.getMessage(), e);
			json.put("result", "delete_fail");
		}

		return json.toString();
	}
}
