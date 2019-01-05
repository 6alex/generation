package com.idp.web.shop.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idp.common.persistence.Page;
import com.idp.web.shop.dao.YShopDao;
import com.idp.web.shop.entity.YShop;
import com.idp.web.shop.service.YShopService;

/**
 * 
 * 云圣商铺service实现类
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
@Service("yShopService")
public class YShopServiceImpl implements YShopService {

	@Resource
	private YShopDao yShopDao;
	
	@Override
	public Page<YShop> findByPage(YShop yShop, Page<YShop> page) {

		page.setResult(yShopDao.find(yShop, page));
		
		return page;
	}
	
	@Override
	public List<YShop> findBySearch(YShop yShop) {

		return yShopDao.find(yShop);
	}
	
	@Override
    public YShop getById(String id) {

		return yShopDao.getById(id);
	}

	@Override
	public void add(YShop yShop) {
		yShopDao.add(yShop);
	}
	
	@Override
	public void update(YShop yShop) {

		yShopDao.update(yShop);
	}

	@Override
    public void delete(String id) {

		yShopDao.delete(id);
	}
 	
}