package com.zy.user.domain;

import java.util.Date;

public class Teacher {
	private int id;
	private int tno;
	private String tname;
	private String tsex;
	private String temail;
	private String tpwd;
	private String single;
	private String registData;
	private String depart;
	private String role;
	private String organize;
	private String photo;
	private String photopath;
	
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getPhotopath() {
		return photopath;
	}
	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}
	public String getOrganize() {
		return organize;
	}
	public void setOrganize(String organize) {
		this.organize = organize;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTsex() {
		return tsex;
	}
	public void setTsex(String tsex) {
		this.tsex = tsex;
	}
	public String getTemail() {
		return temail;
	}
	public void setTemail(String temail) {
		this.temail = temail;
	}
	public String getTpwd() {
		return tpwd;
	}
	public void setTpwd(String tpwd) {
		this.tpwd = tpwd;
	}
	public String getSingle() {
		return single;
	}
	public void setSingle(String single) {
		this.single = single;
	}
	
	
	public String getRegistData() {
		return registData;
	}
	public void setRegistData(String registData) {
		this.registData = registData;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", tno=" + tno + ", tname=" + tname
				+ ", tsex=" + tsex + ", temail=" + temail + ", tpwd=" + tpwd
				+ ", single=" + single + ", registData=" + registData
				+ ", depart=" + depart + ", role=" + role + ", organize="
				+ organize + ", photo=" + photo + ", photopath=" + photopath
				+ "]";
	}
		
	
}
