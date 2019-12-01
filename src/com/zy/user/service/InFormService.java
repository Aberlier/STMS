package com.zy.user.service;

import java.util.List;
import java.util.Map;

import com.zy.user.dao.InFormDao;
import com.zy.user.domain.InForm;
import com.zy.user.domain.Message;

public class InFormService {
	InFormDao dao=new InFormDao();
	public  List<InForm> findAll(){
		return dao.findAll();
	}
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}
	public void update(InForm inf) {
		dao.update(inf);
		
	}
	public List<Map<String, Object>> findbyId(String id) {
			return dao.findbyId(id);
	}
	public void add(InForm annew) {
			dao.insert(annew);
	}
}
