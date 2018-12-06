package com.idp.web.table.service;
import java.util.List;

import com.idp.common.persistence.Page;
import com.idp.web.table.entity.GTable;

/**
 * 
 * 自动建表service接口
 * 
 * <pre>
 * 	历史记录：
 * 	2018-12-04 wencun
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
public interface GTableService{
	
 	/**
	 * 
	 * <pre>
	 * 	2018-12-04 wencun
	 * 	分页查询
	 * </pre>
	 * 
	 * @param gTable
	 * @param page
	 * @return
	 */
	public Page<GTable> findByPage(GTable gTable,Page<GTable> page);
	
	/**
	 * 
	 * <pre>
	 * 	2018-12-04 wencun
	 * 	查询
	 * </pre>
	 * 
	 * @param gTable
	 * @return
	 */
	public List<GTable> findBySearch(GTable gTable);
	
	/**
	 * 
	 * <pre>
	 * 	2018-12-04 wencun
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param GTable
	 * @return
	 */
	public GTable getById(String id);
	
	/**
	 * 
	 * <pre>
	 * 	2018-12-04 wencun
	 * 	新增
	 * </pre>
	 * 
	 * @param gTable
	 */
	public void add(GTable gTable);
	
	/**
	 * 
	 * <pre>
	 * 	2018-12-04 wencun
	 * 	修改
	 * </pre>
	 * 
	 * @param gTable
	 */
	public void update(GTable gTable);
	
	/**
	 * 
	 * <pre>
	 * 	2018-12-04 wencun
	 * 	删除
	 * </pre>
	 * 
	 * @param id
	 */
	public void delete(String id);

	public void delete(GTable gTable);

	public GTable getByCode(String code);
}
