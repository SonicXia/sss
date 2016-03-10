package com.dgaotech.dgfw.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dgaotech.dgfw.dao.BaseDao;
import com.dgaotech.dgfw.dao.IRechargeDao;

@Repository
public class RechargeDaoImpl extends BaseDao implements IRechargeDao{

	@Override
	public List getAll(String pageNow, String pageSize) {
		String sql = 
				"SELECT accountId, mobile, amount, totalAmt, date, type, payTradeNo "
				+ "FROM recharge_info WHERE success = 1 ORDER BY date DESC LIMIT ? , ?";	
		int startPage = (Integer.parseInt(pageNow) - 1) * (Integer.parseInt(pageSize));	
		int pageSize1 = Integer.parseInt(pageSize);
		return this.jdbctemplate.queryForList(sql, new Object[]{startPage, pageSize1}); 
	}

	@Override
	public List getByMobile(String pageNow, String pageSize, String mobile) {
		String sql = 
				"SELECT accountId, mobile, amount, totalAmt, date, type, payTradeNo "
				+ "FROM recharge_info WHERE success = 1 AND mobile = ? ORDER BY date DESC LIMIT ? , ?";
		int startPage = (Integer.parseInt(pageNow) - 1) * (Integer.parseInt(pageSize));	
		int pageSize1 = Integer.parseInt(pageSize);
		return this.jdbctemplate.queryForList(sql, new Object[]{mobile, startPage, pageSize1});
	}
}
