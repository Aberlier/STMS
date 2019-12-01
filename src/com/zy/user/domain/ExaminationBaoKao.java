package com.zy.user.domain;

import java.sql.Date;

public class ExaminationBaoKao {
	private int id;
	private String sname;
	private String myclass;
	private String classname;
	private String school;
	private String place;
	private String school2;
	private String fudaoclass;
	private String fudaoteacher;
	private String parentsname;
	private String parentstel;
	private String intentionalschool;
	private String baokaotime;
	private String teasingle;
	private String adminsingle;
	private String headmaster;
	private String adminname;
	
	
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getHeadmaster() {
		return headmaster;
	}
	public void setHeadmaster(String headmaster) {
		this.headmaster = headmaster;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	
	public String getTeasingle() {
		return teasingle;
	}
	public void setTeasingle(String teasingle) {
		this.teasingle = teasingle;
	}
	public String getAdminsingle() {
		return adminsingle;
	}
	public void setAdminsingle(String adminsingle) {
		this.adminsingle = adminsingle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getMyclass() {
		return myclass;
	}
	public void setMyclass(String myclass) {
		this.myclass = myclass;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getSchool2() {
		return school2;
	}
	public void setSchool2(String school2) {
		this.school2 = school2;
	}
	public String getFudaoclass() {
		return fudaoclass;
	}
	public void setFudaoclass(String fudaoclass) {
		this.fudaoclass = fudaoclass;
	}
	public String getFudaoteacher() {
		return fudaoteacher;
	}
	public void setFudaoteacher(String fudaoteacher) {
		this.fudaoteacher = fudaoteacher;
	}
	public String getParentsname() {
		return parentsname;
	}
	public void setParentsname(String parentsname) {
		this.parentsname = parentsname;
	}
	public String getParentstel() {
		return parentstel;
	}
	public void setParentstel(String parentstel) {
		this.parentstel = parentstel;
	}
	public String getIntentionalschool() {
		return intentionalschool;
	}
	public void setIntentionalschool(String intentionalschool) {
		this.intentionalschool = intentionalschool;
	}
	public String getBaokaotime() {
		return baokaotime;
	}
	public void setBaokaotime(String baokaotime) {
		this.baokaotime = baokaotime;
	}
	@Override
	public String toString() {
		return "ExaminationBaoKao [id=" + id + ", sname=" + sname
				+ ", myclass=" + myclass + ", classname=" + classname
				+ ", school=" + school + ", place=" + place + ", school2="
				+ school2 + ", fudaoclass=" + fudaoclass + ", fudaoteacher="
				+ fudaoteacher + ", parentsname=" + parentsname
				+ ", parentstel=" + parentstel + ", intentionalschool="
				+ intentionalschool + ", baokaotime=" + baokaotime
				+ ", teasingle=" + teasingle + ", adminsingle=" + adminsingle
				+ "]";
	}
	
	
	
	
}
