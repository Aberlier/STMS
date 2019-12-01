package com.zy.user.domain;

public class Exam {
	private int eid;
	private String ename;
	private String examtime;
	private String addexamtime;
	private String signuptime;
	private String signdowntime;
	private String examclass;
	private String adminname;
	private String updatename;
	private String updatetime;
	
	
	
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public String getUpdatename() {
		return updatename;
	}
	public void setUpdatename(String updatename) {
		this.updatename = updatename;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getExamtime() {
		return examtime;
	}
	public void setExamtime(String examtime) {
		this.examtime = examtime;
	}
	public String getAddexamtime() {
		return addexamtime;
	}
	public void setAddexamtime(String addexamtime) {
		this.addexamtime = addexamtime;
	}
	public String getSignuptime() {
		return signuptime;
	}
	public void setSignuptime(String signuptime) {
		this.signuptime = signuptime;
	}
	public String getSigndowntime() {
		return signdowntime;
	}
	public void setSigndowntime(String signdowntime) {
		this.signdowntime = signdowntime;
	}
	public String getExamclass() {
		return examclass;
	}
	public void setExamclass(String examclass) {
		this.examclass = examclass;
	}
	@Override
	public String toString() {
		return "Exam [eid=" + eid + ", ename=" + ename + ", examtime="
				+ examtime + ", addexamtime=" + addexamtime + ", signuptime="
				+ signuptime + ", signdowntime=" + signdowntime
				+ ", examclass=" + examclass + ", adminname=" + adminname
				+ ", updatename=" + updatename + ", updatetime=" + updatetime
				+ "]";
	}
	
	
	
	

}
