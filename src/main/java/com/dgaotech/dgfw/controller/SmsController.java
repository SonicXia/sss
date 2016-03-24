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
import com.dgaotech.dgfw.service.SmsService;

/**
 * 
 * @author xiaxf
 *
 */
@ResponseBody
@RestController
public class SmsController {
	@Autowired
	private SmsService smsService;

	@ResponseBody
	@RequestMapping(value = "/mobile.service/smssender", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> smsTemplate(@RequestBody JSONObject jsoncode, HttpServletResponse response)
			throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,OPTIONS,POST");
		response.setHeader("Access-Control-Allow-Headers", "Origin,Accept,Content-Type*,X-Requested-With");
		return smsService.smsTemplate(jsoncode.getString("id"), jsoncode.getJSONObject("data"),
				jsoncode.getString("username"), jsoncode.getString("password"), jsoncode.getString("mobiles"));
	}
}
