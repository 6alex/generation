package com.idp.web.table.dao;
import java.util.List;

import com.idp.common.base.BaseDao;
import com.idp.web.table.entity.GTable;

/**
 * 
 * 自动建表dao接口.
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
public interface GTableDao extends BaseDao<GTable, String> {

	/**
	 * 根据分组id获取信息
	 * 
	 * @param groupId
	 * @return
	 */
	public List<GTable> getByGroupId(String groupId);
	
	/**
	 * 根据分组id删除信息
	 * 
	 * @param groupId
	 */
	public void deleteByGroupId(String groupId);
	
	/**
	 * 根据分组code获取信息
	 * 
	 * @param code
	 * @return
	 */
	public GTable getByGroupCode(String code);


}