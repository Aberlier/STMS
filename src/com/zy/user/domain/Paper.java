package com.zy.user.domain;

import java.util.Date;

public class Paper {

	private int id;
	private String filetitle;
	private String filenamea;
	private String valueKey;
	private String filedetail;
	private String filer;
	private String filepath;
	private String filetype;
	private Date uploaddate;
	
	public String getValueKey() {
		return valueKey;
	}
	public void setValueKey(String valueKey) {
		this.valueKey = valueKey;
	}
	public String getFiledetail() {
		return filedetail;
	}
	public void setFiledetail(String filedetail) {
		this.filedetail = filedetail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFiletitle() {
		return filetitle;
	}
	public void setFiletitle(String filetitle) {
		this.filetitle = filetitle;
	}
	public String getFilenamea() {
		return filenamea;
	}
	public void setFilenamea(String filenamea) {
		this.filenamea = filenamea;
	}
	public String getFiler() {
		return filer;
	}
	public void setFiler(String filer) {
		this.filer = filer;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public Date getUploaddate() {
		return uploaddate;
	}
	public void setUploaddate(Date uploaddate) {
		this.uploaddate = uploaddate;
	}
	@Override
	public String toString() {
		return "Paper [id=" + id + ", filetitle=" + filetitle + ", filenamea="
				+ filenamea + ", valueKey=" + valueKey + ", filedetail="
				+ filedetail + ", filer=" + filer + ", filepath=" + filepath
				+ ", filetype=" + filetype + ", uploaddate=" + uploaddate + "]";
	}
	
	
	
	
	
	
}
