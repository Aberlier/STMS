package com.zy.user.service;

import java.util.List;
import java.util.Map;

import com.zy.user.dao.TeacherDao;
import com.zy.user.domain.Organize;
import com.zy.user.domain.Teacher;

public class TeacherService {
	TeacherDao dao=new TeacherDao();
	
	public void updateTeacher(Teacher anuser) {
			dao.update(anuser);
	}
	public void updateOrganize(Organize anuser) {
		dao.updateOrganize(anuser);
	}
	
	public void Teacherupdateme(Teacher anuser) {
		dao.updateTeacher(anuser);
	}
	public void updatemeTeacher(Teacher anuser) {
		dao.updateme(anuser);
	}
	public List<Map<String,Object>> findbyId(String tname){
		return dao.findbyId(tname);
	}
	public List<Map<String,Object>> updatetea_findbyId(int id){
		return dao.updatetea_findbyId(id);
	}
	public List<Map<String,Object>> findbyId_oid(int oid){
		return dao.findbyOrganize_oid(oid);
	}
	public List<Map<String,Object>> findbyOrganize(String key,int index,int pageSize){
		return dao.findbyOrganize(key,index,pageSize);
	}
	public List<Map<String, Object>> findCount(String key) {
		return dao.findCount(key);
		}
	
	//删除多条记录
//	public void deleteMore(String ids[]){
//		/*
//		 * 调用Dao层来删除多条记录
//		 */
//		dao.deletemore(ids);
//	}
//	public void updateStudent(User anuser){
//		dao.update(anuser);
//	}
}
