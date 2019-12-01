package com.zy.user.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.zy.user.dao.AdminDao;
import com.zy.user.domain.Admin;
import com.zy.user.domain.Award;
import com.zy.user.domain.ExaminationBaoKao;
import com.zy.user.domain.Student;
import com.zy.user.domain.Teacher;

public class AdminService {
private AdminDao dao=new AdminDao();
	public List<Map<String,Object>> findbyId(String adminname){
		return dao.findbyId(adminname);
	}
	public List<Map<String,Object>> superadmin_findbyId(String superadminname){
		return dao.superadmin_findbyId(superadminname);
	}
	public List<Map<String,Object>> admin_query_org(String key,int index,int pageSize){
		return dao.admin_query_org(key,index,pageSize);
	}
	public List<Map<String,Object>> admin_query_tea_org(String key,int index,int pageSize){
		return dao.admin_query_tea_org(key,index,pageSize);
	}
	
	/*
	 * 管理员修改个人信息
	 */
	public void updateme(Admin anuser) {
		dao.updateme(anuser);
	}
	
	public List<Map<String, Object>> findCountTea() {
		return dao.findCountTea();
	}public List<Map<String, Object>> TeafindCount(String key) {
		return dao.TeafindCount(key);
	}
	public List<Map<String, Object>> findCountTea(String key) {
		return dao.findCountTea(key);
	}
	public List<Map<String, Object>> findCount(String key) {
		return dao.findCount(key);
	}
	public List<Map<String, Object>> findStuCount(String key) {
		return dao.findStuCount(key);
	}
	public List<Map<String, Object>> findStuCount() {
		return dao.findStuCount();
	}
	public  List<Map<String,Object>> findAll_stu(int index,int pageSize){
		return dao.findAll_stu(index,pageSize);
	}
	public  List<Map<String,Object>> findAll_tea(int index,int pageSize){
		return dao.findAll_tea(index,pageSize);
	}
	public  List<Map<String,Object>> findAll_tea_teaname(){
		return dao.findAll_tea_teaname();
	}
	
	public void addTeacher(Teacher teacher){
		dao.insert_tea(teacher);
	}	
	public void updateTeacherSingle(Teacher anuser) {
		dao.updateSingle_tea(anuser);
	}
	public void updateStudentSingle(Student anuser) {
		dao.updateSingle_stu(anuser);
	}
	
	public void delete_tea(String tname){
		dao.delete_tea(tname);
	}
	public void addstu(Student stu) throws SQLException {
		dao.addstu(stu);
		
	}public List<Map<String,Object>> SfindbyId(String sname){
		return dao.SfindbyId(sname);
	}public List<Map<String,Object>> TfindbyId(String tname){
		return dao.TfindbyId(tname);
	}
	public void deletestu(String sname){
		dao.deletestu(sname);
	}
	public void addtea(Teacher tea){
		dao.addtea(tea);
	}
	public List<Map<String, Object>> findCount_adm() {
		return dao.findCount_adm();
	}
	public List<Map<String, Object>> findCount_award() {
		return dao.findCount_award();
	}
	public Object findAll_adm(int index, int pageSize) {
		return dao.findAll_adm(index,pageSize);
	}
	public Object findAll_award(int index, int pageSize) {
		return dao.findAll_award(index,pageSize);
	}
	public void updateAdminSign(Admin anuser) {
		dao.updateSingle_adm(anuser);
	}
	public void deleteadm(String adminname) {
		dao.deleteadm(adminname);
	}
	public List<Map<String, Object>> findbyId(int id) {
		return dao.findbyId(id);
	}
	public void updateAdmin(Admin admin) {
		dao.updateAdmin(admin);
	}
	public void addadmin(Admin admin) {
		dao.addadmin(admin);
	}
	public void delete_award(String aid) {
		dao.delete_award(aid);
	}
	public void admin_update_baokao_Single(ExaminationBaoKao anuser) {
		dao.admin_update_baokao_Single(anuser);
	}
	public void addAward(Award a) {
		dao.addAward(a);
	}
}
