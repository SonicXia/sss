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
				"SELECT trainNo, isSingle, lineNo, isStartFlag, bureau, startStation,"
				+ " endStation, startDate, endDate, spanDays FROM train_info";			
		return this.jdbctemplate.queryForList(sql); 
	}
}
