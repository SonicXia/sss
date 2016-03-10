package com.dgaotech.dgfw.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.dgaotech.common.HttpSender;
import com.dgaotech.common.SmsUtil;
import com.dgaotech.dgfw.dao.ISmsTemplateDao;
import com.dgaotech.dgfw.service.SmsService;
/**
 * 
 * @author xiaxf
 *
 */
@Service
public class SmsServiceImpl implements SmsService {
	/**
	 *  模板1：尊敬的${customerName}：您已成功下达火车票订单，正在为您努力出票中。稍后将会短信通知您占座或出票结果。
		模板2：尊敬的${customerName}：您已经成功占座${trainInfo}，请您在30分钟内在本软件【火车购票】中的【车票详情】支付订单，以免耽误行程。
		模板3：尊敬的${customerName}：您所预定的${trainInfo}占座失败，请重新下单。
		模板4：尊敬的${customerName}：您已成功订购${ticketNum}张车票，${trainInfo}请您持有效证件及时取票、乘车。
		模板5：尊敬的${customerName}：您所订购的${trainInfo}出票失败，退款将会在${days}个工作日内按照您原有的付款渠道返回到您的账户上。由此带来的不便我们向您道歉！
		模板6：尊敬的${customerName}：您已退票成功，退款将会在${days}个工作日内按照您原有的付款渠道返回到您的账户上。如有问题请联系客服${serviceNo}。
		模板7：尊敬的${customerName}：您的退票请求处理失败，请联系客服${serviceNo}进行处理，由此带来的不便我们向您道歉！
		模板8：${trainNo}有新订单，手机号码：${mobileNo}，送达位置：${seatNo}，订单总额：${amount}元，商品明细：${order_detail}请及时处理。
		模板9：尊敬的${mobileNo}乘客：您已成功订购以下${productNum}件物品：${order_detail}订单总额：${amount}元。餐服员正在处理配送中，如未能及时送达，请主动联系车上餐服员，或拨打${serviceNo}客服专线处理。感谢您的配合！
		模板10：乘客${mobileNo}预订单：${trainNo}，送达位置：${seatNo}，预订商品：${order_detail}订单总额：${amount}元，请及时处理。
		模板11：尊敬的${mobileNo}乘客：您已成功预订${trainNo}以下${productNum}件物品：${order_detail}订单总额：${amount}元，配送方式：${seatNo}。请您上车后请主动联系车上餐服员，或拨打${serviceNo}客服专线处理。感谢您的配合！
		模板12：尊敬的${customerName}乘客：您已成功充值人民币${amount}元。您可以使用此充值购买火车票、在车上点餐和购买商品。您在使用过程中如有意见或疑问，请拨打${serviceNo}客服专线进行处理。感谢您的支持！
	 * @param id 选用模板的类型。当id=1时对应模板1，id=2时对应模板2，以此类推。
	 * @param data 传入模板的参数
	 * @param username 传入的用户名，用于验证
	 * @param password 传入的用户密码，用于验证
	 */
	
	@Autowired
	private ISmsTemplateDao smsTemplateDao;
	
	@Value("${sms.url}")
	public String smsUrl;
	@Value("${sms.account}")
	public String account;
	@Value("${sms.pswd}")
	public String pswd;
	
	@Value("${smsuser.user1}")
	public String name;
	@Value("${smsuser.password}")
	public  String pwd ;

	public Map<String, String> smsTemplate(String id,JSONObject data, String username, String password, String mobiles)
	 throws Exception{	
		Map<String, String> rsp = new HashMap<String, String>();		
		if(SmsUtil.validate(username, password,name,pwd)){
			String mobile = mobiles;// 手机号码，多个号码使用","分割
			boolean needstatus = true;// 是否需要状态报告，需要true，不需要false
			String product = null;// 产品ID
			String extno = null;// 扩展码	
			
//			//读取template 文件			
//			File templateFile = ClassLoaderUtil.getResourceFile("/SmsTemplate.txt");
//	    	String[] templateStrs = null;
//			templateStrs = FileUtil.readLines(templateFile);		
//			//type对应模板类型
//			int index = Integer.parseInt(type, 10);
//	    	String template = templateStrs[index];
			
	    	//从数据库中读取相应模板信息
	    	String template = smsTemplateDao.getById(id).toString();
	    	int index = template.indexOf("=");	
	    	template = template.substring(index + 1, template.length() - 2);	    	
	        String msg= SmsUtil.buildMsg(template,data);
	        
	        if(msg.indexOf("${") >=0 ){
	        	rsp.put("status", "false");
	        	rsp.put("msg", "请检查data参数与对应的短信模板id是否匹配！");
	        	Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String syncTime = sdf.format(date);
				rsp.put("syncTime", syncTime);
	        }else{
				HttpSender.batchSend(smsUrl, account, pswd, mobile, msg, needstatus, product, extno);
				rsp.put("status", "ok");
				rsp.put("msg", msg);
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String syncTime = sdf.format(date);
				rsp.put("syncTime", syncTime);
	        }
		}else {
			rsp.put("status", "false");
			rsp.put("msg", "用户名或密码错误!");
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String syncTime = sdf.format(date);
			rsp.put("syncTime", syncTime);
		}
		return rsp;
	}
}
