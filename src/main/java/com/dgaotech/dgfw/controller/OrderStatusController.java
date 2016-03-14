package com.dgaotech.dgfw.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.dgaotech.dgfw.service.OrderStatusService;
/**
 * 
 * @author xiaxf
 *
 */
@ResponseBody
@RestController
public class OrderStatusController {
	
	@Autowired
	private OrderStatusService orderStatusService;
	
	/***
	 * Restful 方式得到两个接口：
	 * 1. 完全调出充值信息
	 * 2. 根据用户mobile号得出充值信息
	 * @param mobile
	 * @return
	 * @throws Exception
	 */	
	  @ResponseBody
	  @RequestMapping(value = "/mobile.service/ordersuccess", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	  public Map<String, Object> rechargeinfo(@RequestBody JSONObject jsoncode) throws Exception{
		  
		  String orderNo = jsoncode.getString("orderNo");
		  return  orderStatusService.updateOrderStatus(orderNo);
		  
	  }
}
