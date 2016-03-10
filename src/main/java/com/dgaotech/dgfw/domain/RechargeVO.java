package com.dgaotech.dgfw.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * 
 * @author xiaxf
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RechargeVO {
	//充值流水号
	private String accountId;
	//充值手机号码
	private String mobile;
	//本次充值或退款金额
	private String amount;
	//累计充值金额
	private String totalAmt;
	//充值或退款日期
	private Date date;
	//充值方式：0=线下充值，1=线上充值，2=线下退款
	private int type;
	//微信或支付宝支付订单流水号
	private String payTradeNo;
	
	private List<RechargeVO> rechargeList;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getPayTradeNo() {
		return payTradeNo;
	}

	public void setPayTradeNo(String payTradeNo) {
		this.payTradeNo = payTradeNo;
	}

	public List<RechargeVO> getRechargeList() {
		return rechargeList;
	}

	public void setRechargeList(List<RechargeVO> rechargeList) {
		this.rechargeList = rechargeList;
	}
	
	
}
