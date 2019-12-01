package com.zy.user.domain;

public class Organize {
	private int id;
	private String organizationname;
	private String oid;
	private String addtime;
	private String operson;
	private String otel;
	private String oaddress;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrganizationname() {
		return organizationname;
	}
	public void setOrganizationname(String organizationname) {
		this.organizationname = organizationname;
	}
	
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public String getOperson() {
		return operson;
	}
	public void setOperson(String operson) {
		this.operson = operson;
	}
	public String getOtel() {
		return otel;
	}
	public void setOtel(String otel) {
		this.otel = otel;
	}
	public String getOaddress() {
		return oaddress;
	}
	public void setOaddress(String oaddress) {
		this.oaddress = oaddress;
	}
	@Override
	public String toString() {
		return "Organize [id=" + id + ", organizationname=" + organizationname
				+ ", oid=" + oid + ", addtime=" + addtime + ", operson="
				+ operson + ", otel=" + otel + ", oaddress=" + oaddress + "]";
	}
	
	
}
