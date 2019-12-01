package com.zy.user.domain;

public class ExamByWay {
	private int bid;
	private String oname;
	private String examname;
	private String examplace;
	private String busline;
	private String sign;
	private String addpeople;
	private String addExamByWayTime;
	
	
	
	public String getAddExamByWayTime() {
		return addExamByWayTime;
	}
	public void setAddExamByWayTime(String addExamByWayTime) {
		this.addExamByWayTime = addExamByWayTime;
	}
	public String getAddpeople() {
		return addpeople;
	}
	public void setAddpeople(String addpeople) {
		this.addpeople = addpeople;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	
	
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getExamname() {
		return examname;
	}
	public void setExamname(String examname) {
		this.examname = examname;
	}
	public String getExamplace() {
		return examplace;
	}
	public void setExamplace(String examplace) {
		this.examplace = examplace;
	}
	public String getBusline() {
		return busline;
	}
	public void setBusline(String busline) {
		this.busline = busline;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	@Override
	public String toString() {
		return "ExamByWay [bid=" + bid + ", oname=" + oname + ", examname="
				+ examname + ", examplace=" + examplace + ", busline="
				+ busline + ", sign=" + sign + ", addpeople=" + addpeople
				+ ", addExamByWayTime=" + addExamByWayTime + "]";
	}
	

}
