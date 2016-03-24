package com.dgaotech.dgfw.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dgaotech.dgfw.dao.BaseDao;
import com.dgaotech.dgfw.dao.IReserveProductDao;

@Repository
public class ReserveProductDaoImpl extends BaseDao implements IReserveProductDao{
	@Override
	public List getByPreSale() {
		String sql = 
				"SELECT productCode, productName, productType, imgName, brand, unit, price"
				+ " FROM product_info WHERE preSale = 1 ORDER BY productCode";			
		return this.jdbctemplate.queryForList(sql);
	}

}
