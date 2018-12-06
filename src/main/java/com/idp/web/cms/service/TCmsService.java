package com.idp.web.cms.service;
import com.idp.web.cms.entity.TCms;
import java.util.List;

import com.idp.common.persistence.Page;

/**
 * 
 * 通用cmsservice接口
 * 
 * <pre>
 * 	历史记录：
 * 	2018-12-03 wencun
 * 	新建文件
 * </pre>
 * 
 * @author 
 * <pre>
 * SD
 * 	wencun
 * PG
 *	wencun
 * UT
 *
 * MA
 * </pre>
 * @version $Rev$
 *
 * <p/> $Id$
 *
 */
public interface TCmsService{
	
 	/**
	 * 
	 * <pre>
	 * 	2018-12-03 wencun
	 * 	分页查询
	 * </pre>
	 * 
	 * @param tCms
	 * @param page
	 * @return
	 */
	public Page<TCms> findByPage(TCms tCms,Page<TCms> page);
	
	/**
	 * 
	 * <pre>
	 * 	2018-12-03 wencun
	 * 	查询
	 * </pre>
	 * 
	 * @param tCms
	 * @return
	 */
	public List<TCms> findBySearch(TCms tCms);
	
	/**
	 * 
	 * <pre>
	 * 	2018-12-03 wencun
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param TCms
	 * @return
	 */
	public TCms getById(String id);
	
	/**
	 * 
	 * <pre>
	 * 	2018-12-03 wencun
	 * 	新增
	 * </pre>
	 * 
	 * @param tCms
	 */
	public void add(TCms tCms);
	
	/**
	 * 
	 * <pre>
	 * 	2018-12-03 wencun
	 * 	修改
	 * </pre>
	 * 
	 * @param tCms
	 */
	public void update(TCms tCms);
	
	/**
	 * 
	 * <pre>
	 * 	2018-12-03 wencun
	 * 	删除
	 * </pre>
	 * 
	 * @param id
	 */
	public void delete(String id);
}
