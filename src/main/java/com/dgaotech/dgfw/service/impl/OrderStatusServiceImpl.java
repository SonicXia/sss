package com.dgaotech.dgfw.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgaotech.dgfw.dao.IOrderStatusDao;
import com.dgaotech.dgfw.service.OrderStatusService;
/**
 * 
 * @author xiaxf
 *
 */
@Service
public class OrderStatusServiceImpl implements OrderStatusService {
	
	@Autowired
	private IOrderStatusDao orderStatusDao;	

	@Override
	public Map<String, Object> updateOrderStatus(String orderNo) {
		Map<String, Object> rsp = new HashMap<String, Object>();
		try{
			orderStatusDao.updateOrderStatus(orderNo);
			rsp.put("status", "ok");
			rsp.put("msg", "支付成功！");
		}catch(Exception e){
			e.printStackTrace();
			rsp.put("status", "failed");
			rsp.put("msg", "支付失败！");
		}
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String syncTime = sdf.format(date);
		rsp.put("syncTime", syncTime);		
		return rsp;
	}

}
