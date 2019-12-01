package com.zy.user.domain;

public class Admin {
	private int id;
	private String adminname;
	private String adminpass;
	private int totlogin;
	private String role;
	private String addtime;
	private String sign;
	private String sex;
	
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpass() {
		return adminpass;
	}
	public void setAdminpass(String adminpass) {
		this.adminpass = adminpass;
	}
	public int getTotlogin() {
		return totlogin;
	}
	public void setTotlogin(int totlogin) {
		this.totlogin = totlogin;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminname=" + adminname + ", adminpass="
				+ adminpass + ", totlogin=" + totlogin + ", role=" + role
				+ ", addtime=" + addtime + ", sign=" + sign + "]";
	}
	
}
