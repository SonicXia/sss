package com.dgaotech.dgfw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.dgaotech.dgfw.service.LineService;

@ResponseBody
@RestController
public class LineController {

	@Autowired
	private LineService lineService;
	
	/***
	 * Restful 方式得到两个接口：
	 * 1. 完全调出线路信息
	 * 2.根据线路id号得出线路信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	
	  @ResponseBody
	  @RequestMapping(value = "/lineinfo/{id}", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	  public List lineinfo(@PathVariable("id") String id,@RequestBody JSONObject jsoncode) throws Exception{
		  //return "the id is"+id;
		  //这里获取json值
		  System.out.println("这里获得值："+jsoncode.getString("code"));
		  
		  if ("*".equals(id)){
			  return  lineService.getAll();
		  }else{
			  return lineService.getById(id);
		  }
	  }
	  

	  
//	  @ResponseBody
//	  @RequestMapping(value = "/line", method = RequestMethod.GET)
//	  public String allLine() throws Exception{
//		  List<?> lst= lineService.getAll();
//		  return JsonUtil.getJsonStrByObject(lst);
//	  }
	  
	  @RequestMapping(value="/as/{namespace}/{set}/getAll/{key}",method=RequestMethod.GET)
	   public @ResponseBody String getAll(@PathVariable("namespace") String namespace, 
	          @PathVariable("set") String set,
	          @PathVariable("key") String keyvalue) throws Exception {
	     return null;
	  }
	  /***
		 * Restful 方式得到两个接口：
		 * 1. 完全调出线路信息
		 * 2.根据线路id号得出线路信息
		 * @param id
		 * @return
		 * @throws Exception
		 */
		
//		  @ResponseBody
//		  @RequestMapping(value = "/mykey", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
//		  public String lineinfo() {
//			  return lineService.getMyKey();
//		  }

}
