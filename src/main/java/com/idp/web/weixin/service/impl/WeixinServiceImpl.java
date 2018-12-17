package com.idp.web.weixin.service.impl;
import com.idp.web.weixin.service.WeixinService;
import com.idp.web.weixin.dao.WeixinDao;
import com.idp.web.weixin.entity.Weixin;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idp.common.persistence.Page;
import com.idp.common.util.ResourceUtils;

/**
 * 
 * 微信爬虫service实现类
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
@Service("weixinService")
public class WeixinServiceImpl implements WeixinService {

	@Resource
	private WeixinDao weixinDao;
	
	@Override
	public Page<Weixin> findByPage(Weixin weixin, Page<Weixin> page) {

		page.setResult(weixinDao.find(weixin, page));
		
		return page;
	}
	
	@Override
	public List<Weixin> findBySearch(Weixin weixin) {

		return weixinDao.find(weixin);
	}
	
	@Override
	public Weixin getById(String id) {

		return weixinDao.getById(id);
	}

	@Override
	public void add(Weixin weixin) {

		weixin.setId(ResourceUtils.getUUID());
		weixinDao.add(weixin);
	}
	
	@Override
	public void update(Weixin weixin) {

		weixinDao.update(weixin);
	}

	@Override
	public void delete(String id) {

		weixinDao.delete(id);
	}
 	
}