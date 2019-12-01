package com.zy.user.domain;

import java.util.Date;

public class InForm {
	private int id;
	private String title;
	private String content;
	private Date informdata;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getInformdata() {
		return informdata;
	}
	public void setInformdata(Date informdata) {
		this.informdata = informdata;
	}
	@Override
	public String toString() {
		return "InForm [id=" + id + ", title=" + title + ", content=" + content
				+ ", informdata=" + informdata + "]";
	}
	
	
}
