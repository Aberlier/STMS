package com.zy.user.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.zy.user.dao.loginDao;
import com.zy.user.domain.Admin;
import com.zy.user.domain.Student;
import com.zy.user.domain.Teacher;

public class loginService {
		loginDao dao=new loginDao();
	public int checkLogin(String adminname, String adminpass,int totlogin,String role) throws SQLException {
		return dao.checkLogin(adminname, adminpass,totlogin,role);
	}
	public void registe(Student stu) throws SQLException {
		dao.registe(stu);
		
	}
	public void tearegiste(Teacher tea) throws SQLException {
		dao.tearegiste(tea);
		
	}
	public int ScheckLogin(String sname, String spwd, int totlogin,String role) {
		return dao.ScheckLogin(sname, spwd,totlogin,role);
		
	}
	public int SuperAdmincheckLogin(String superadminname, String superadminpassword, int totlogin,String role) {
		return dao.SuperAdmincheckLogin(superadminname, superadminpassword,totlogin,role);
		
	}
	public int TcheckLogin(String tname, String tpwd, int totlogin,String role) {
		return dao.TcheckLogin(tname, tpwd,totlogin,role);
		
	}
	/*
	 * 管理员修改个人信息
	 */
	public void updateme(Admin anuser) {
		dao.updateme(anuser);
}
	
	public List<Map<String,Object>> SfindbyId(String sname){
		return dao.SfindbyId(sname);
	}
	public List<Map<String,Object>> TfindbyId(String tname){
		return dao.TfindbyId(tname);
	}
	public List<Map<String,Object>> search_dpart_organize(){
		return dao.search_dpart_organize();
	}public List<Map<String,Object>> search_dpart(){
		return dao.search_dpart();
	}
	public List<Map<String, Object>> FnidSuperAdminCheckName(String superadminname) {
		return dao.FnidSuperAdminCheckName(superadminname);
	}
	public List<Map<String, Object>> AfindbyId(String adminname) {
		return dao.AfindbyId(adminname);
	}
}
