package com.idp.web.shop.service;
import java.util.List;

import com.idp.common.persistence.Page;
import com.idp.web.shop.entity.YShop;

/**
 * 
 * 云圣商铺service接口
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
public interface YShopService{
	
 	/**
	 * 
	 * <pre>
	 * 	2019-01-04 wen
	 * 	分页查询
	 * </pre>
	 * 
	 * @param yShop
	 * @param page
	 * @return
	 */
	public Page<YShop> findByPage(YShop yShop,Page<YShop> page);
	
	/**
	 * 
	 * <pre>
	 * 	2019-01-04 wen
	 * 	查询
	 * </pre>
	 * 
	 * @param yShop
	 * @return
	 */
	public List<YShop> findBySearch(YShop yShop);
	
	/**
	 * 
	 * <pre>
	 * 	2019-01-04 wen
	 * 	通过ID查询
	 * </pre>
	 * 
	 * @param YShop
	 * @return
	 */
    public YShop getById(String id);
	
	/**
	 * 
	 * <pre>
	 * 	2019-01-04 wen
	 * 	新增
	 * </pre>
	 * 
	 * @param yShop
	 */
	public void add(YShop yShop);
	
	/**
	 * 
	 * <pre>
	 * 	2019-01-04 wen
	 * 	修改
	 * </pre>
	 * 
	 * @param yShop
	 */
	public void update(YShop yShop);
	
	/**
	 * 
	 * <pre>
	 * 	2019-01-04 wen
	 * 	删除
	 * </pre>
	 * 
	 * @param id
	 */
    public void delete(String id);
}
