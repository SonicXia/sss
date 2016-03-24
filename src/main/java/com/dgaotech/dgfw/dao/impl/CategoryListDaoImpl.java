package com.dgaotech.dgfw.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dgaotech.dgfw.dao.BaseDao;
import com.dgaotech.dgfw.dao.ICategoryListDao;

@Repository
public class CategoryListDaoImpl extends BaseDao implements ICategoryListDao{
	@Override
	public List getAllCategoryListFromProductInfo() {
		String sql = "SELECT DISTINCT a.id, a.category, a.typeValue, a.optId "
				+ "FROM product_category a WHERE a.isActive = 1 ORDER BY a.id";			
		return this.jdbctemplate.queryForList(sql);
	}
}
