package com.zy.user.service;

import java.util.List;
import java.util.Map;

import com.zy.user.dao.StudentDao;
import com.zy.user.domain.Admin;
import com.zy.user.domain.ExaminationBaoKao;
import com.zy.user.domain.Student;
import com.zy.user.domain.SuperAdmin;

public class StudentService {
	StudentDao dao=new StudentDao();
	public void addStudent(Student student){
		dao.insert(student);
	}	
	public void delete(String sname){
		dao.delete(sname);
	}
	public void delete_baokao(int id){
		dao.delete_baokao(id);
	}
	
	public void updateStudent(Student anuser) {
			dao.update(anuser);
	}
	public void admin_update_stu(Student anuser) {
		dao.admin_update_stu(anuser);
}
	
	public void update_baokao(ExaminationBaoKao anuser) {
		dao.update_baokao(anuser);
}
	public void updateStudentSingle(Student anuser) {
		dao.updateSingle(anuser);
}

	public List<Map<String,Object>> findbyId2(int id){
		return dao.findbyId2(id);
	}
	public List<Map<String,Object>> findbyId_baokao(int id){
		return dao.findbyId_baokao(id);
	}
	public List<Map<String,Object>> findbyId(String key2,String key,int index,int pageSize){
		return dao.findbyId(key2,key,index,pageSize);
	}
	public List<Map<String,Object>> admin_findbyId(String key,int index, int pageSize){
		return dao.admin_findbyId(key,index,pageSize);
	}
	public List<Map<String,Object>> findbyIdTea(String key,int index, int pageSize){
		return dao.findbyIdTea(key,index,pageSize);
	}
	public List<Map<String,Object>> findbyName_baokao(String key,String key2, int index, int pageSize){
		return dao.findbyName_baokao(key,key2,index,pageSize);
	}
	public List<Map<String,Object>> admin_findbyName_baokao(String key, int index, int pageSize){
		return dao.admin_findbyName_baokao(key,index,pageSize);
	}
	public List<Map<String,Object>> findbyphoto(String sname){
		return dao.findbyphoto(sname);
	}
	public List<Map<String, Object>> findCount_baokao(String key) {
		return dao.findCount_baokao(key);
	}
	public List<Map<String, Object>> admin_findCount_baokao() {
		return dao.admin_findCount_baokao();
	}
	
	public List<Map<String, Object>> findCount(String key2,String key) {
		return dao.findCount(key2,key);
		}
	public List<Map<String, Object>> findCount(String key) {
		return dao.findCount(key);
		}
	public  List<Map<String,Object>> findAll(String key,int index,int pageSize){
		return dao.findAll(key,index,pageSize);
	}
	public  List<Map<String,Object>> findAll_baokao(String headmaster,int index,int pageSize){
		return dao.findAll_baokao(headmaster,index,pageSize);
	}
	public  List<Map<String,Object>> admin_findAll_baokao(int index,int pageSize){
		return dao.admin_findAll_baokao(index,pageSize);
	}
	public void updatemeStudent(Student anuser) {
		dao.updateme(anuser);
}
	public void studentupdateme(Student anuser) {
		dao.updateStudent(anuser);
}
	public void addbaokao(ExaminationBaoKao student) {
		dao.insertbaokao(student);
	}
	public void admin_addbaokao(ExaminationBaoKao student) {
		dao.admin_insertbaokao(student);
	}
	public void tea_stop(ExaminationBaoKao anuser) {
		dao.update_baokao_single(anuser);		
	}
	public void tea_start(ExaminationBaoKao anuser) {
		dao.update_baokao_single(anuser);		
	}
	public List<Map<String, Object>> admin_findCount_baokao_findbyname(String key) {
		return dao.admin_findCount_baokao_findbyname(key);
	}
	public List<Map<String, Object>> findCount_baokao_findbyname(String key) {
		return dao.findCount_baokao_findbyname(key);
	}
	public void updatemeAdmin(Admin anuser) {
		dao.updatemeAdmin(anuser);
	}
	public void update_SuperAdmin(SuperAdmin anuser) {
		dao.update_SuperAdmin(anuser);
	}
	
}
