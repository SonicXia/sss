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

import com.dgaotech.dgfw.dao.ITrainInfoDao;
import com.dgaotech.dgfw.domain.TrainInfoVO;
import com.dgaotech.dgfw.service.TrainInfoService;
/**
 * 
 * @author xiaxf
 *
 */
@Service
public class TrainInfoServiceImpl implements TrainInfoService {
	
	@Autowired
	private ITrainInfoDao trainInfoDao;
	
	@Override
	@Transactional
	public Map<String, Object> getAll(){				
		Map<String, Object> rsp = new HashMap<String, Object>();
		rsp.put("status", "ok");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String syncTime = sdf.format(date);
		rsp.put("syncTime", syncTime);
		
		List<TrainInfoVO> trainList = new ArrayList<TrainInfoVO>();
		trainList = trainInfoDao.getAll();	
		rsp.put("data", trainList);	
		return rsp;
	}

}
