package com.dgaotech.dgfw.dao.impl;

import org.springframework.stereotype.Repository;

import com.dgaotech.dgfw.dao.BaseDao;
import com.dgaotech.dgfw.dao.IOrderStatusDao;

/**
 * 
 * @author xiaxf
 *
 */
@Repository
public class OrderStatusDaoImpl extends BaseDao implements IOrderStatusDao{

	@Override
	public void updateOrderStatus(String orderNo) {
		String sql = "UPDATE order_info SET orderStatus = 1 WHERE orderNo = ?";
		this.jdbctemplate.update(sql, new Object[]{orderNo}); 
	}
}
