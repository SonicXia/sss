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
import com.dgaotech.dgfw.service.TrainInfoService;
/**
 * 
 * @author xiaxf
 *
 */
@ResponseBody
@RestController
public class TrainInfoController {
	
	@Autowired
	private TrainInfoService trainInfoService;
	
	/***
	 * Restful 方式得到两个接口：
	 * 1. 完全调出充值信息
	 * 2. 根据用户mobile号得出充值信息
	 * @param mobile
	 * @return
	 * @throws Exception
	 */	
	  @ResponseBody
	  @RequestMapping(value = "/mobile.service/traininfo", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	  public Map<String, Object> rechargeinfo(@RequestBody JSONObject jsoncode) throws Exception{
		  return  trainInfoService.getAll();
		  
	  }
}
