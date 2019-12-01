package com.zy.user.service;

import java.util.List;
import java.util.Map;

import com.zy.user.dao.FileDao;
import com.zy.user.domain.Paper;

public class FileService {
private FileDao fileDao=new FileDao();
	
	public void newupload(Paper afile){
		fileDao.newupload(afile);
		
	}
	public  List<Map<String,Object>> findAll(String filetype){
		return fileDao.findAll(filetype);
	}
	public  List<Map<String,Object>> PagefindAll(String key,int index,int pageSize){
		return fileDao.PagefindAll(key,index,pageSize);
	}
	public List<Map<String, Object>> findCount(String key) {
		return fileDao.findCount(key);
		}
	public  List<Map<String,Object>> findmyfile(String filer){
		return fileDao.findmyfile(filer);
	}
	public List<Map<String,Object>> listone(String filetitle){
		return fileDao.listone(filetitle);
	}
	public void delete(int id) {
		// TODO Auto-generated method stub
		fileDao.delete(id);
	}
}
