package com.dgaotech.dgfw.dao;

import java.util.List;

public interface ITrainInfoDao {	
	public List getAll();
	public List getByPreOrderable();
	public List getByOnlineOrderable();
	public List getByPreAndOnlineOrderable();
	public List getBytrainNo(String trainNo);
}
