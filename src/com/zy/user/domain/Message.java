package com.zy.user.domain;

import java.util.Date;

public class Message {
	private int id;
	private String title;
	private String content;
	private String name;
	private Date publishedDate;
	private String recontent;
	private String replyname;
	private Date redate;
	private String valueKey;
	private String detail;
	private String character;
	
	public String getValueKey() {
		return valueKey;
	}
	public void setValueKey(String valueKey) {
		this.valueKey = valueKey;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getRecontent() {
		return recontent;
	}
	public void setRecontent(String recontent) {
		this.recontent = recontent;
	}
	public String getReplyname() {
		return replyname;
	}
	public void setReplyname(String replyname) {
		this.replyname = replyname;
	}
	public Date getRedate() {
		return redate;
	}
	public void setRedate(Date redate) {
		this.redate = redate;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", title=" + title + ", content="
				+ content + ", name=" + name + ", publishedDate="
				+ publishedDate + ", recontent=" + recontent + ", replyname="
				+ replyname + ", redate=" + redate + ", valueKey=" + valueKey
				+ ", detail=" + detail + ", character=" + character + "]";
	}
	
	
	
}
