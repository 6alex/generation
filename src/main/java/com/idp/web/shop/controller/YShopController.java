package com.idp.web.shop.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idp.common.base.BaseController;
import com.idp.common.persistence.Page;
import com.idp.common.util.ValidateUtils;
import com.idp.web.shop.entity.YShop;
import com.idp.web.shop.service.YShopService;

import net.sf.json.JSONObject;

/**
 * 
 * 云圣商铺controller
 * 
 * <pre>
 * 	历史记录：
 * 	2019-01-04 wen
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
@RequestMapping("/yShop")
public class YShopController extends BaseController {

    private Logger       logger = Logger.getLogger(YShopController.class);

    @Resource
    private YShopService yShopService;

    /**
     * 
     * <pre>
     * 	2019-01-04 wen
     * 	初始化查询页面
     * </pre>
     * 
     * @return
     */
    @RequestMapping("/init")
    public String init() {

        return "shop/yShopSearch";
    }

    /**
     * 
     * <pre>
     * 	2019-01-04 wen
     * 	分页查询
     * </pre>
     * 
     * @param yShop
     * @param page
     * @param request
     * @return
     */
    @RequestMapping("/list")
    public String list(YShop yShop, Page<YShop> page, HttpServletRequest request) {

        try {

            request.setAttribute("page", yShopService.findByPage(yShop, page));
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
        }

        return "shop/yShopList";
    }

    /**
     * 
     * <pre>
     * 	2019-01-04 wen
     * 	新增修改页面初始化
     * </pre>
     * 
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/yShop")
    public String yShop(String id, HttpServletRequest request) {

        try {

            if (ValidateUtils.isNotEmpty(id)) {

                YShop yShop = yShopService.getById(id);
                request.setAttribute("yShop", yShop);
            }
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
        }

        return "shop/yShop";
    }

    /**
     * 
     * <pre>
     * 	2019-01-04 wen
     * 	保存
     * </pre>
     * 
     * @param yShop
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public String save(YShop yShop) {

        JSONObject json = new JSONObject();

        try {

            // 修改
            if (ValidateUtils.isNotEmpty(yShop.getId())) {

                yShopService.update(yShop);
            }
            // 新增
            else {

                yShopService.add(yShop);
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
     * 	2019-01-04 wen
     * 	删除
     * </pre>
     * 
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(String id) {
        JSONObject json = new JSONObject();
        try {
            yShopService.delete(id);
            json.put("result", "delete_success");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            json.put("result", "delete_fail");
        }
        return json.toString();
    }
}
