package com.zy.user.service;

import java.util.List;
import java.util.Map;

import com.zy.user.dao.MessageDao;
import com.zy.user.domain.Message;

public class MessageService {
	private MessageDao messageDao=new MessageDao();
	public List<Map<String,Object>> findAll(String key,int index,int pageSize){
		return messageDao.findAll(key,index,pageSize);
	}
	public List<Map<String,Object>> teacherlistmyreply(String key,int index,int pageSize){
		return messageDao.teacherlistmyreply(key,index,pageSize);
	}
	public List<Map<String,Object>> findAllresponse(String title){
		return messageDao.findAllresponse(title);
	}
	
	public void add(Message annew){
		messageDao.insert(annew);
	}
	
	public void newresponse(Message annew){
		messageDao.insertresponse(annew);
	}
	 public List<Map<String,Object>> listmymessage(String name){
			return messageDao.listmymessage(name);
		}
	 public List<Map<String,Object>> teacherlistmymessage(String name){
			return messageDao.teacherlistmymessage(name);
		}
	 public List<Map<String,Object>> listmyreply(String key,int index,int pageSize){
			return messageDao.listmyreply(key,index,pageSize);
		}
	 
	 public  void deletereply(int id){
			messageDao.deletereply(id);
		}
	 
	 public  void deletemessage(int id){
			messageDao.deletemessage(id);
		}
	 public List<Map<String, Object>> findCount(String key) {
			
		 return messageDao.findCount(key);
		}
}
