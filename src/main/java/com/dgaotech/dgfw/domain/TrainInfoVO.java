package com.dgaotech.dgfw.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * 
 * @author xiaxf
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrainInfoVO {
	//车次
	private String trainNo;
	//是否单列
	private int isSingle;
	//所属交路
	private String lineNo;
	//是否首发车次
	private int isStartFlag;
	//所属路局
	private String bureau;
	//始发站
	private String startStation;
	//终点站
	private String endStation;
	//始发站发车时间
	private String startDate;
	//终点站到站时间
	private String endDate;
	//跨天数
	private int spanDays;
	//是否可【提前订餐】
	private int preOrderable;
	//是否可【列车点餐】
	private int onlineOrderable;
	
	private List<TrainInfoVO> trainInfoList;

	public String getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}

	public int getIsSingle() {
		return isSingle;
	}

	public void setIsSingle(int isSingle) {
		this.isSingle = isSingle;
	}

	public String getLineNo() {
		return lineNo;
	}

	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}

	public int getIsStartFlag() {
		return isStartFlag;
	}

	public void setIsStartFlag(int isStartFlag) {
		this.isStartFlag = isStartFlag;
	}

	public String getBureau() {
		return bureau;
	}

	public void setBureau(String bureau) {
		this.bureau = bureau;
	}

	public String getStartStation() {
		return startStation;
	}

	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}

	public String getEndStation() {
		return endStation;
	}

	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getSpanDays() {
		return spanDays;
	}

	public void setSpanDays(int spanDays) {
		this.spanDays = spanDays;
	}

	public List<TrainInfoVO> getTrainInfoList() {
		return trainInfoList;
	}

	public void setTrainInfoList(List<TrainInfoVO> trainInfoList) {
		this.trainInfoList = trainInfoList;
	}

	public int getOnlineOrderable() {
		return onlineOrderable;
	}

	public void setOnlineOrderable(int onlineOrderable) {
		this.onlineOrderable = onlineOrderable;
	}

	public int getPreOrderable() {
		return preOrderable;
	}

	public void setPreOrderable(int preOrderable) {
		this.preOrderable = preOrderable;
	}

	
}
