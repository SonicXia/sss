package com.dgaotech.dgfw.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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

	/**
	 * Restful 方式得到接口：当支付成功时，设置orderStatus=1
	 * 
	 * @param jsoncode
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/mobile.service/ordersuccess", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> rechargeinfo(@RequestBody JSONObject jsoncode, HttpServletResponse response)
			throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,OPTIONS,POST");
		response.setHeader("Access-Control-Allow-Headers", "Origin,Accept,Content-Type*,X-Requested-With");
		String orderNo = jsoncode.getString("orderNo");
		return orderStatusService.updateOrderStatus(orderNo);

	}
}
