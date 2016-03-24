package com.dgaotech.dgfw.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	/**
	 * Restful 方式得到接口,查询列车信息
	 * 
	 * @param jsoncode：仅包含一个flag，对应的值有四种情况：“0”、“1”、“2”、“3”，如{"flag":"1"}
	 *            flag=0时，显示所有列车记录
	 *            flag=1时，显示preOrderable和onlineOrderable字段等于1的记录
	 *            flag=2时，显示preOrderable字段等于1的记录
	 *            flag=3时，显示onlineOrderable字段等于1的记录
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/mobile.service/traininfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> rechargeinfo(@RequestBody JSONObject jsoncode, HttpServletResponse response)
			throws Exception {

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,OPTIONS,POST");
		response.setHeader("Access-Control-Allow-Headers", "Origin,Accept,Content-Type*,X-Requested-With");

		int flag = Integer.parseInt(jsoncode.getString("flag"));
		return trainInfoService.getTrainInfo(flag);

	}
}
