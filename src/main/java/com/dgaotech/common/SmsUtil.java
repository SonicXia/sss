package com.dgaotech.common;

import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author xiaxf
 *
 */
public class SmsUtil {

	public static String composeMessage(String template,Properties data) throws Exception{
        Iterator it =data.entrySet().iterator();
        while(it.hasNext()){
            Object o=it.next();
            template=template.replaceFirst("\\$\\{"+o.toString().split("=")[0]+"}", o.toString().split("=")[1]);
        }         
        return template;
    }

	public static String buildMsg(String template,JSONObject data ) {
        Properties p=new Properties();
        Set<String> keySet = data.keySet();
        for(String key:keySet) {
        	p.put(key, data.get(key));
        }
        String str = "";
        try {
			str = composeMessage(template,p);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return str;
	}
	
	public static boolean validate(String username, String password,String name,String pwd) throws IOException{
//		Props prop = new Props();
//		
//		prop.load(new File(System.getProperty("java.class.path")+"validate.properties"));
//		String name = prop.getValue("username");
//		String pwd = prop.getValue("password");
//	    if(username.equals(name) && password.equals(pwd)){
//	    	return true;
//	    }      
//		return false;
		if (username.equals(name) && password.equals(pwd)){
			return true;
		}
		else{
			return false;
		}
	}
	
}
