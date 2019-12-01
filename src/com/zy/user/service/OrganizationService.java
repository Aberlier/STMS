package com.zy.user.service;

import java.util.List;
import java.util.Map;

import com.zy.user.dao.OrganizationDao;
import com.zy.user.domain.Organize;

public class OrganizationService {
	OrganizationDao dao=new OrganizationDao();
	public List<Map<String, Object>> findCount_all() {
		return dao.findCount_all();
	}
	public List<Map<String, Object>> findAll(int index, int pageSize) {
		return  dao.findAll(index,pageSize);
	}
	public void addOrganization(Organize org){
		dao.addOrganization(org);
	}
	public List<Map<String, Object>> findbyId_organization(int id) {
		
		return dao.findbyId_organization(id);
	}
	public void update_organization(Organize anuser) {
		dao.update_organization(anuser);
	}
	public void deleteorg(int id) {
		dao.deleteorg(id);
	}
	
}
