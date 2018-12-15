package com.idp.web.table.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.idp.common.persistence.Page;
import com.idp.common.util.ResourceUtils;
import com.idp.web.table.dao.GTableDao;
import com.idp.web.table.entity.GTable;
import com.idp.web.table.service.GTableService;

/**
 * 
 * 自动建表service实现类
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
@Service("gTableService")
public class GTableServiceImpl implements GTableService {

	@Resource
	private GTableDao gTableDao;

	@Override
	public Page<GTable> findByPage(GTable gTable, Page<GTable> page) {

		page.setResult(gTableDao.find(gTable, page));

		return page;
	}

	@Override
	public List<GTable> findBySearch(GTable gTable) {

		return gTableDao.find(gTable);
	}

	@Override
	public GTable getById(String id) {
		GTable table = gTableDao.getById(id);
		GTable model = new GTable();
		model.setGroupId(id);
		table.setChildren(gTableDao.find(model));
		return table;

	}

	@Override
	public void add(GTable gTable) {
		gTable.setId(ResourceUtils.getUUID());
		gTable.setGroupId("0");
		gTableDao.add(gTable);
		if (gTable.getChildren() != null && gTable.getChildren().size() > 0) {
			for (GTable child : gTable.getChildren()) {
				child.setId(ResourceUtils.getUUID());
				child.setGroupId(gTable.getId());
			}
			gTableDao.batchAdd(gTable.getChildren());
		}
	}

	@Override
	@CacheEvict(value = "gTableCache", key = "#gTable.code")
	public void update(GTable gTable) {
		gTable.setGroupId("0");
		gTableDao.update(gTable);
		gTableDao.deleteByGroupId(gTable.getId());
		if (gTable.getChildren() != null && gTable.getChildren().size() > 0) {
			for (GTable child : gTable.getChildren()) {
				child.setId(ResourceUtils.getUUID());
				child.setGroupId(gTable.getId());
			}
			gTableDao.batchAdd(gTable.getChildren());
		}
	}

	@Override
	@CacheEvict(value = "gTableCache", key = "#gTable.code")
	public void delete(GTable gTable) {
		gTableDao.delete(gTable.getId());
		gTableDao.deleteByGroupId(gTable.getId());
	}

	@Override
	@Cacheable(value = "gTableCache", key = "#code")
	public GTable getByCode(String code) {
		GTable gTable = gTableDao.getByGroupCode(code);
		gTable.setChildren(gTableDao.getByGroupId(gTable.getId()));
		return gTable;
	}

	@Override
	public void delete(String id) {
		gTableDao.delete(id);
	}

}