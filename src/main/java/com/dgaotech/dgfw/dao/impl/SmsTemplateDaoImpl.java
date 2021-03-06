package com.dgaotech.dgfw.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dgaotech.dgfw.dao.BaseDao;
import com.dgaotech.dgfw.dao.ISmsTemplateDao;

@Repository
public class SmsTemplateDaoImpl extends BaseDao implements ISmsTemplateDao{

	@Override
	public List getById(String id) {
		return this.jdbctemplate.queryForList(
				"SELECT template FROM sms_template WHERE id=?", new Object[]{id});
	}
	
}
