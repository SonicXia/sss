package com.dgaotech.dgfw.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dgaotech.dgfw.dao.BaseDao;
import com.dgaotech.dgfw.dao.ITrainInfoDao;

@Repository
public class TrainInfoDaoImpl extends BaseDao implements ITrainInfoDao{

	@Override
	public List getAll() {
		String sql = 
				"SELECT trainNo, isSingle, lineNo, isStartFlag, bureau, startStation, endStation, startDate,"
				+ " endDate, spanDays, preOrderable, onlineOrderable FROM train_info ORDER BY trainNo";			
		return this.jdbctemplate.queryForList(sql); 
	}

	@Override
	public List getByPreOrderable() {
		String sql = 
				"SELECT trainNo, isSingle, lineNo, isStartFlag, bureau, startStation, endStation, startDate, endDate,"
				+ " spanDays, preOrderable, onlineOrderable FROM train_info WHERE preOrderable = 1 ORDER BY trainNo";			
		return this.jdbctemplate.queryForList(sql); 
	}

	@Override
	public List getByOnlineOrderable() {
		String sql = 
				"SELECT trainNo, isSingle, lineNo, isStartFlag, bureau, startStation, endStation, startDate, endDate,"
				+ " spanDays, preOrderable, onlineOrderable FROM train_info WHERE onlineOrderable = 1 ORDER BY trainNo";			
		return this.jdbctemplate.queryForList(sql); 
	}

	@Override
	public List getByPreAndOnlineOrderable() {
		String sql = 
				"SELECT trainNo, isSingle, lineNo, isStartFlag, bureau, startStation, endStation, startDate,"
				+ " endDate, spanDays, preOrderable, onlineOrderable FROM train_info "
				+ "WHERE preOrderable = 1 AND onlineOrderable = 1 ORDER BY trainNo";			
		return this.jdbctemplate.queryForList(sql);
	}

	@Override
	public List getBytrainNo(String trainNo) {
		String sql = "SELECT trainNo, startStation, endStation FROM train_info WHERE trainNo = ?";
		return this.jdbctemplate.queryForList(sql, new Object[]{trainNo});
	}
}
