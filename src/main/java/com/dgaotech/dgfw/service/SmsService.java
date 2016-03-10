package com.dgaotech.dgfw.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface SmsService {

	public Map<String, String> smsTemplate(String id,JSONObject data, String username,
			String password, String mobiles) throws Exception;
	
}
