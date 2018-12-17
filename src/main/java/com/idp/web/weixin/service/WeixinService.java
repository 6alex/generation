package com.idp.web.weixin.service;
import com.idp.web.weixin.entity.Weixin;
import java.util.List;

import com.idp.common.persistence.Page;

/**
 * 
 * 微信爬虫service接口
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
public interface WeixinService{
	
 	/**
	 * 
	 * <pre>
	 * 	2018-12-17 wen
	 * 	分页查询
	 * </pre>
	 * 
	 * @param weixin
	 * @param page
	 * @return
	 */
	public Page<Weixin> findByPage(Weixin weixin,Page<Weixin> page);
	
	/**
	 * 
	 * <pre>
	 * 	2018-12-17 wen
	 * 	查询
	 * </pre>
	 * 
	 * @param weixin
	 * @return
	 */
	public List<Weixin> findBySearch(Weixin weixin);
	
	/**
	 * 
	 * <pre>
	 * 	2018-12-17 wen
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param Weixin
	 * @return
	 */
	public Weixin getById(String id);
	
	/**
	 * 
	 * <pre>
	 * 	2018-12-17 wen
	 * 	新增
	 * </pre>
	 * 
	 * @param weixin
	 */
	public void add(Weixin weixin);
	
	/**
	 * 
	 * <pre>
	 * 	2018-12-17 wen
	 * 	修改
	 * </pre>
	 * 
	 * @param weixin
	 */
	public void update(Weixin weixin);
	
	/**
	 * 
	 * <pre>
	 * 	2018-12-17 wen
	 * 	删除
	 * </pre>
	 * 
	 * @param id
	 */
	public void delete(String id);
}
