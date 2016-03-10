package com.dgaotech.dgfw.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dgaotech.dgfw.dao.IRechargeDao;
import com.dgaotech.dgfw.domain.RechargeVO;
import com.dgaotech.dgfw.service.RechargeService;
/**
 * 
 * @author xiaxf
 *
 */
@Service
public class RechargeServiceImpl implements RechargeService {
	
	@Autowired
	private IRechargeDao rechargeDao;
	
//	@Override
//	@Transactional
////	@Cacheable(value = "recharge_getall", keyGenerator = "wiselyKeyGenerator")
//	public List getAll(String pageNow, String pageSize){	
//		return rechargeDao.getAll(pageNow, pageSize);
//	}

//	@Override
//	@Transactional
////	@Cacheable(value = "recharge_get_by_mobile", keyGenerator = "wiselyKeyGenerator")
////	@CacheEvict(value = "recharge_get_by_mobile", allEntries=true)
//	public List getByMobile(String pageNow, String pageSize, String mobile) {
//		return rechargeDao.getByMobile(pageNow, pageSize, mobile);
//	}
	
	@Override
	@Transactional
	public Map<String, Object> getAll(String pageNow, String pageSize){				
		Map<String, Object> rsp = new HashMap<String, Object>();
		rsp.put("status", "ok");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String syncTime = sdf.format(date);
		rsp.put("syncTime", syncTime);
		List<RechargeVO> RechargeList = new ArrayList<RechargeVO>();
		RechargeList = rechargeDao.getAll(pageNow, pageSize);	
		rsp.put("data", RechargeList);	
		return rsp;
	}

	@Override
	@Transactional
	public Map<String, Object> getByMobile(String pageNow, String pageSize, String mobile) {		
		Map<String, Object> rsp = new HashMap<String, Object>();
		rsp.put("status", "ok");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String syncTime = sdf.format(date);
		rsp.put("syncTime", syncTime);
		List<RechargeVO> RechargeList = new ArrayList<RechargeVO>();
		RechargeList = rechargeDao.getByMobile(pageNow, pageSize, mobile);	
		rsp.put("data", RechargeList);		
		return rsp;
	}
}
