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
import com.dgaotech.dgfw.service.RechargeService;
/**
 * 
 * @author xiaxf
 *
 */
@ResponseBody
@RestController
public class RechargeController {
	
	@Autowired
	private RechargeService rechargeService;
	
	/***
	 * Restful 方式得到两个接口：
	 * 1. 完全调出充值信息
	 * 2. 根据用户mobile号得出充值信息
	 * @param mobile
	 * @return
	 * @throws Exception
	 */	
	  @ResponseBody
	  @RequestMapping(value = "/mobile.service/rechargeinfo", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	  public Map<String, Object> rechargeinfo(@RequestBody JSONObject jsoncode) throws Exception{
		  String pageNow = jsoncode.getString("pageNow");
		  String pageSize = jsoncode.getString("pageSize");
		  String mobile = jsoncode.getString("mobile");
		  if (mobile.equals("")){
			  return  rechargeService.getAll(pageNow, pageSize);
		  }else{
			  return rechargeService.getByMobile(pageNow, pageSize, mobile);
		  }
	  }
}
