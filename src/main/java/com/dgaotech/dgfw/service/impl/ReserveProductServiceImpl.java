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

import com.dgaotech.dgfw.dao.IReserveProductDao;
import com.dgaotech.dgfw.domain.ReserveProductVO;
import com.dgaotech.dgfw.service.ReserveProductService;

/**
 * 
 * @author xiaxf
 *
 */
@Service
public class ReserveProductServiceImpl implements ReserveProductService {

	@Autowired
	private IReserveProductDao reserveProductDao;

	@Override
	@Transactional
	public Map<String, Object> getByPreSale() {
		Map<String, Object> rsp = new HashMap<String, Object>();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String syncTime = sdf.format(date);
		rsp.put("syncTime", syncTime);
		try{	
			rsp.put("status", "ok");
			rsp.put("msg", null);
			List<ReserveProductVO> productList = new ArrayList<ReserveProductVO>();
			productList = reserveProductDao.getByPreSale();
			rsp.put("data", productList);
		}catch(Exception e){	
			rsp.put("status", "false");			
			rsp.put("msg", 
					"Exception: " + e.getCause().getMessage()+", "+e.getCause().getMessage());
		}
		return rsp;
	}
}
