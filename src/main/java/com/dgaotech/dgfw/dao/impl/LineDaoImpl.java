package com.dgaotech.dgfw.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dgaotech.dgfw.dao.BaseDao;
import com.dgaotech.dgfw.dao.ILineDao;

@Repository
public class LineDaoImpl extends BaseDao implements ILineDao{

	@Override
	public List getAll() {
		
		return this.jdbctemplate.queryForList("SELECT * FROM line_info");
	}

	@Override
	public List getById(String id) {
		 return this.jdbctemplate.queryForList("SELECT * FROM line_info WHERE id=?", new Object[]{id});
	} 

}
