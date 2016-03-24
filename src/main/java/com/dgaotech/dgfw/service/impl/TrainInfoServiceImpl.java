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
	public Map<String, Object> getTrainInfo(int flag) {
		Map<String, Object> rsp = new HashMap<String, Object>();
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String syncTime = sdf.format(date);
		rsp.put("syncTime", syncTime);
		if(flag == 0){	//flag == 0，不加过滤条件，显示所有记录
			rsp.put("status", "ok");
			List<TrainInfoVO> trainList = new ArrayList<TrainInfoVO>();
			trainList = trainInfoDao.getAll();	
			rsp.put("data", trainList);	
		}else if(flag == 1){	//flag == 1，显示preOrderable和onlineOrderable等于1的记录
			rsp.put("status", "ok");
			List<TrainInfoVO> trainList = new ArrayList<TrainInfoVO>();
			trainList = trainInfoDao.getByPreAndOnlineOrderable();	
			rsp.put("data", trainList);	
		}else if(flag == 2){	//flag == 2，显示preOrderable等于1的记录
			rsp.put("status", "ok");
			List<TrainInfoVO> trainList = new ArrayList<TrainInfoVO>();
			trainList = trainInfoDao.getByPreOrderable();	
			rsp.put("data", trainList);	
		}else if(flag == 3){	//flag == 3，显示onlineOrderable等于1的记录
			rsp.put("status", "ok");
			List<TrainInfoVO> trainList = new ArrayList<TrainInfoVO>();
			trainList = trainInfoDao.getByOnlineOrderable();	
			rsp.put("data", trainList);	
		}else{	//flag等于其他值时，返回错误信息
			rsp.put("status", "failed");
			String msg = "请传入正确的flag值";
			rsp.put("msg", msg);
			}
		return rsp;
	}

}
