package com.zy.user.domain;

import java.sql.Date;

public class Student {
	private int id;
	private String sname;
	private String sex;
	private String spwd;
	private String single;
	private String rigestdata;
	private String role;
	private String uppicture;
	private int old;
	private String born;
	private String photo;
	private String photopath;
	private String place;
	private String schoolname;
	private String fudaoclass;
	private String fudaoteacher;
	private String parentsname;
	private String parentstel;
	private String headmaster;
	
	
	
	public String getHeadmaster() {
		return headmaster;
	}
	public void setHeadmaster(String headmaster) {
		this.headmaster = headmaster;
	}
	public String getPhotopath() {
		return photopath;
	}
	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSpwd() {
		return spwd;
	}
	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}
	public String getSingle() {
		return single;
	}
	public void setSingle(String single) {
		this.single = single;
	}
	
	public String getRigestdata() {
		return rigestdata;
	}
	public void setRigestdata(String rigestdata) {
		this.rigestdata = rigestdata;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUppicture() {
		return uppicture;
	}
	public void setUppicture(String uppicture) {
		this.uppicture = uppicture;
	}
	public String getBorn() {
		return born;
	}
	public void setBorn(String born) {
		this.born = born;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getSchoolname() {
		return schoolname;
	}
	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
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
	public int getOld() {
		return old;
	}
	public void setOld(int old) {
		this.old = old;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", sname=" + sname + ", sex=" + sex
				+ ", spwd=" + spwd + ", single=" + single + ", rigestdata="
				+ rigestdata + ", role=" + role + ", uppicture=" + uppicture
				+ ", old=" + old + ", born=" + born + ", photo=" + photo
				+ ", photopath=" + photopath + ", place=" + place
				+ ", schoolname=" + schoolname + ", fudaoclass=" + fudaoclass
				+ ", fudaoteacher=" + fudaoteacher + ", parentsname="
				+ parentsname + ", parentstel=" + parentstel + "]";
	}
	
	
	
}
