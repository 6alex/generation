package com.idp.web.cms.service.impl;
import com.idp.web.cms.service.TCmsService;
import com.idp.web.cms.dao.TCmsDao;
import com.idp.web.cms.entity.TCms;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idp.common.persistence.Page;
import com.idp.common.util.ResourceUtils;

/**
 * 
 * 通用cmsservice实现类
 * 
 * <pre>
 * 	历史记录：
 * 	2018-12-07 wen
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
@Service("tCmsService")
public class TCmsServiceImpl implements TCmsService {

	@Resource
	private TCmsDao tCmsDao;
	
	@Override
	public Page<TCms> findByPage(TCms tCms, Page<TCms> page) {

		page.setResult(tCmsDao.find(tCms, page));
		
		return page;
	}
	
	@Override
	public List<TCms> findBySearch(TCms tCms) {

		return tCmsDao.find(tCms);
	}
	
	@Override
	public TCms getById(String id) {

		return tCmsDao.getById(id);
	}

	@Override
	public void add(TCms tCms) {

		tCms.setId(ResourceUtils.getUUID());
		tCmsDao.add(tCms);
	}
	
	@Override
	public void update(TCms tCms) {

		tCmsDao.update(tCms);
	}

	@Override
	public void delete(String id) {

		tCmsDao.delete(id);
	}
 	
}