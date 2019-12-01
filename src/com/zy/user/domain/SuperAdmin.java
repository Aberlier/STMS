package com.zy.user.domain;

public class SuperAdmin {
	private int id;
	private String superadminname;
	private String superadminpassword;
	private int totlogin;
	private String role;
	private String addtime;
	private String sign;
	private String sex;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSuperadminname() {
		return superadminname;
	}
	public void setSuperadminname(String superadminname) {
		this.superadminname = superadminname;
	}
	public String getSuperadminpassword() {
		return superadminpassword;
	}
	public void setSuperadminpassword(String superadminpassword) {
		this.superadminpassword = superadminpassword;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "SuperAdmin [id=" + id + ", superadminname=" + superadminname
				+ ", superadminpassword=" + superadminpassword + ", totlogin="
				+ totlogin + ", role=" + role + ", addtime=" + addtime
				+ ", sign=" + sign + ", sex=" + sex + "]";
	}
	
	
}
