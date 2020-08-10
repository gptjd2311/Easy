package com.easy.test0805.dto;

import java.sql.Timestamp;

public class ReserveVO {

	private int resId,proId,resNum,resCharge,resPay,resGroup;
	private String memId,proName,proType,resData;
	private Timestamp resDate;
	
	public ReserveVO() {
		
	}
	public ReserveVO(int resId,String memId, int proId,String proType, String proName, int resNum, int resCharge, int resPay, Timestamp resDate,String resData,int resGroup) {
		super();
		this.resId = resId;
		this.proId = proId;
		this.resNum = resNum;
		this.resCharge = resCharge;
		this.resPay = resPay;
		this.memId = memId;
		this.proName = proName;
		this.proType = proType;
		this.resDate = resDate;
		this.resData = resData;
		this.resGroup = resGroup;
	}

	public ReserveVO(int resId,String memId, int proId,String proType, String proName, int resNum, int resCharge, int resPay, Timestamp resDate,String resData) {
		super();
		this.resId = resId;
		this.proId = proId;
		this.resNum = resNum;
		this.resCharge = resCharge;
		this.resPay = resPay;
		this.memId = memId;
		this.proName = proName;
		this.proType = proType;
		this.resDate = resDate;
		this.resData = resData;

	}



	@Override
	public String toString() {
		return "ReserveVO [resId=" + resId + ", proId=" + proId + ", resNum=" + resNum + ", resCharge=" + resCharge
				+ ", resPay=" + resPay + ", memId=" + memId + ", proName=" + proName + ", proType=" + proType
				+ ", resData=" + resData + ", resDate=" + resDate + "]";
	}
	
	

	public int getResGroup() {
		return resGroup;
	}

	public void setResGroup(int resGroup) {
		this.resGroup = resGroup;
	}

	public String getResData() {
		return resData;
	}

	public void setResData(String resData) {
		this.resData = resData;
	}

	public Timestamp getResDate() {
		return resDate;
	}


	public void setResDate(Timestamp resDate) {
		this.resDate = resDate;
	}


	public String getProType() {
		return proType;
	}

	public void setProType(String proType) {
		this.proType = proType;
	}


	public int getResId() {
		return resId;
	}
	public void setResId(int resId) {
		this.resId = resId;
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public int getResNum() {
		return resNum;
	}
	public void setResNum(int resNum) {
		this.resNum = resNum;
	}
	public int getResCharge() {
		return resCharge;
	}
	public void setResCharge(int resCharge) {
		this.resCharge = resCharge;
	}
	public int getResPay() {
		return resPay;
	}
	public void setResPay(int resPay) {
		this.resPay = resPay;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}



	public Object add(ReserveVO rVo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
