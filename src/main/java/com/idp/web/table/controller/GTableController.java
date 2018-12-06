package com.idp.web.table.controller;

import com.idp.web.table.entity.GTable;
import com.idp.web.table.service.GTableService;
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
