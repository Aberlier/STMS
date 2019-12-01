package com.zy.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import com.zy.user.domain.Admin;
import com.zy.user.domain.ExaminationBaoKao;
import com.zy.user.domain.Student;
import com.zy.user.domain.SuperAdmin;
import com.zy.user.domain.Teacher;
import com.zy.user.util.DBHelper;

public class StudentDao {
	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	public void insert(Student student){
		
		String sql="insert into tb_student(sname,sex,spwd,single,rigestdata,role) values(?,?,?,?,?,?,?,?,?)";
		Object params[]={
				student.getSname(),
				student.getSex(),
				student.getSpwd(),student.getSingle(),
				student.getRigestdata(),student.getRole()
		};
		DBHelper.insert(sql, params);
		
}
	public void delete(String sname)
	{
		String sql = "delete from tb_student where sname=?";
		DBHelper.update(sql,sname);
	}
	public void delete_baokao(int id)
	{
		String sql = "delete from tb_examinationbaokao where id=?";
		DBHelper.update(sql,id);
	}
	public void update(Student anuser){
		String sql="update tb_student set fudaoclass=?,fudaoteacher=?,parentsname=?,parentstel=? where sname=?";
		Object[] params={
				anuser.getFudaoclass(),
				anuser.getFudaoteacher(),
				anuser.getParentsname(),anuser.getParentstel(),anuser.getSname()
		};
		
		DBHelper.update(sql, params);
	}
	public void admin_update_stu(Student anuser){
		String sql="update tb_student set sex=?,old=?,born=?,place=?,schoolname=?,fudaoclass=?,fudaoteacher=?,parentsname=?,parentstel=?,headmaster=? where sname=?";
		System.out.println(sql);
		Object[] params={
				anuser.getSex(),
				anuser.getOld(),
				anuser.getBorn(),
				anuser.getPlace(),
				anuser.getSchoolname(),
				anuser.getFudaoclass(),
				anuser.getFudaoteacher(),
				anuser.getParentsname(),anuser.getParentstel(),anuser.getHeadmaster(),anuser.getSname()
		};
		
		DBHelper.update(sql, params);
	}
	public void update_baokao(ExaminationBaoKao anuser){
		String sql="update tb_examinationbaokao set fudaoclass=?,fudaoteacher=?,parentsname=?,parentstel=? where id=?";
		Object[] params={
				anuser.getFudaoclass(),
				anuser.getFudaoteacher(),
				anuser.getParentsname(),anuser.getParentstel(),anuser.getId()
		};
		
		DBHelper.update(sql, params);
	}
	public void updateStudent(Student anuser){
		String sql="update tb_student set old=?,place=?,schoolname=?,fudaoclass=?,fudaoteacher=?,parentsname=?,parentstel=? where sname=?";
		Object []params={
				anuser.getOld(),anuser.getPlace(),anuser.getSchoolname(),
				anuser.getFudaoclass(),anuser.getFudaoteacher(),anuser.getParentsname(),anuser.getParentstel(),anuser.getSname()
		};
		
		DBHelper.update(sql, params);
	}
	public void updateSingle(Student anuser){
		String sql="update tb_student set single=? where sname=?";
		Object []params={
				anuser.getSingle(),anuser.getSname()
		};

		DBHelper.update(sql, params);
	}
	public List<Map<String, Object>> findbyId2(int id){
		String sql="select * from tb_student where id=?";
		List<Map<String,Object>> list=DBHelper.find(sql, id);
        return list;
		
	}
	public List<Map<String, Object>> findbyId_baokao(int id){
		String sql="select * from tb_examinationbaokao where id=?";
		List<Map<String,Object>> list=DBHelper.find(sql, id);
        return list;
		
	}
	public List<Map<String, Object>> findbyId(String key2,String key,int index,int pageSize){
		String sql="select * from tb_student where sname like ? having headmaster like ? limit ?,?";
		List<Map<String,Object>> list=DBHelper.find(sql, key2,key,index,pageSize);
        return list;
		
	}
	public List<Map<String, Object>> admin_findbyId(String key,int index, int pageSize){
		String sql="select * from tb_student where sname like ? limit ?,?";
		List<Map<String,Object>> list=DBHelper.find(sql, key,index,pageSize);
        return list;
		
	}
	public List<Map<String, Object>> findbyIdTea(String key,int index, int pageSize){
		String sql="select * from tb_teacher where tname like ? limit ?,?";
		List<Map<String,Object>> list=DBHelper.find(sql, key,index,pageSize);
        return list;
		
	}
	
	public List<Map<String, Object>> findbyName_baokao(String key,String key2, int index, int pageSize){
		String sql="select * from tb_examinationbaokao LEFT OUTER JOIN tb_student ON tb_examinationbaokao.sname = tb_student.sname where tb_examinationbaokao.sname like ? having tb_student.headmaster like ? limit ?,?";
		List<Map<String,Object>> list=DBHelper.find(sql,key,key2,index,pageSize);
        return list;
		
	}
	public List<Map<String, Object>> admin_findbyName_baokao(String key, int index, int pageSize){
		String sql="select * from tb_examinationbaokao where sname like ? limit ?,?";
		List<Map<String,Object>> list=DBHelper.find(sql, key,index,pageSize);
        return list;
		
	}
	public List<Map<String, Object>> findbyphoto(String sname){
		String sql="select photo from tb_student where sname=?";
		List<Map<String,Object>> list=DBHelper.find(sql, sname);
        return list;
		
	}
	public List<Map<String,Object>> findAll(String key,int index,int pageSize){
		String sql="select * from tb_student where headmaster like ? limit ?,? ";
		return 	DBHelper.find(sql,key,index,pageSize);
	}
	public List<Map<String,Object>> findAll_baokao(String headmaster,int index,int pageSize){
		String sql="select * from tb_examinationbaokao LEFT OUTER JOIN tb_student ON tb_examinationbaokao.sname = tb_student.sname where tb_student.headmaster=? limit ?,? ";
		return 	DBHelper.find(sql,headmaster,index,pageSize);
	}public List<Map<String,Object>> admin_findAll_baokao(int index,int pageSize){
		String sql=" select * from tb_examinationbaokao limit ?,? ";
		return 	DBHelper.find(sql,index,pageSize);
	}
	public List<Map<String, Object>> findCount(String key2,String key) {
		String	sql="select count(id) from tb_student where sname like ? and headmaster like ?";
		return DBHelper.query(sql,key2,key);
	}
	public List<Map<String, Object>> findCount(String key) {
		String	sql="select count(id) from tb_student where headmaster like ?";
		return DBHelper.find(sql,key);
	}
	public List<Map<String, Object>> findCount_baokao(String key) {
		String	sql="select count(tb_examinationbaokao.id) from tb_examinationbaokao LEFT OUTER JOIN tb_student ON tb_examinationbaokao.sname = tb_student.sname where tb_student.headmaster like ? ";	
		return DBHelper.find(sql,key);
	}
	public List<Map<String, Object>> admin_findCount_baokao() {
		String	sql="select count(id) from tb_examinationbaokao";	
		return DBHelper.find(sql);
	}
	public void updateme(Student anuser){
		String sql="update tb_student set spwd=? where sname=?";
		Object[] params={
				
				anuser.getSpwd(),anuser.getSname()
		};
		DBHelper.update(sql, params);
	}
	public void insertbaokao(ExaminationBaoKao student) {

		String sql="insert into tb_examinationbaokao(myclass,sname,school,school2,place,intentionalschool,fudaoclass,fudaoteacher,parentsname,parentstel,teasingle,adminsingle,baokaotime) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object params[]={
				student.getMyclass(),
				student.getSname(),
				student.getSchool(),student.getSchool2(),student.getPlace(),
				student.getIntentionalschool(),student.getFudaoclass(),student.getFudaoteacher(),student.getParentsname(),student.getParentstel(),
				student.getTeasingle(),student.getAdminsingle(),
				student.getBaokaotime()
		};
		DBHelper.insert(sql, params);
		
	}
	public void admin_insertbaokao(ExaminationBaoKao student) {

		String sql="insert into tb_examinationbaokao(myclass,sname,school,school2,place,intentionalschool,fudaoclass,fudaoteacher,parentsname,parentstel,teasingle,adminsingle,baokaotime) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object params[]={
				student.getMyclass(),
				student.getSname(),
				student.getSchool(),student.getSchool2(),student.getPlace(),
				student.getIntentionalschool(),student.getFudaoclass(),student.getFudaoteacher(),student.getParentsname(),student.getParentstel(),
				student.getTeasingle(),student.getAdminsingle(),
				student.getBaokaotime()
		};
		DBHelper.insert(sql, params);
		
	}
	public void update_baokao_single(ExaminationBaoKao anuser){
			String sql="update tb_examinationbaokao set teasingle=? where id=?";
			Object []params={
					anuser.getTeasingle(),anuser.getId()
			};
			DBHelper.update(sql, params);
		}
	public List<Map<String, Object>> admin_findCount_baokao_findbyname(String key) {
		String	sql="select count(tb_examinationbaokao.id) from tb_examinationbaokao LEFT OUTER JOIN tb_student ON tb_examinationbaokao.sname = tb_student.sname where tb_examinationbaokao.sname like ?";	
		return DBHelper.query(sql,key);
	}
	public List<Map<String, Object>> findCount_baokao_findbyname(String key) {
		String	sql="select count(id) from tb_examinationbaokao where sname like ?";	
		return DBHelper.query(sql,key);
	}
	public void updatemeAdmin(Admin anuser) {
			String sql="update tb_admin set adminpass=? where adminname=?";
			Object[] params={
					anuser.getAdminpass(),anuser.getAdminname()
			};
			DBHelper.update(sql, params);
	}
	public void update_SuperAdmin(SuperAdmin anuser) {
		String sql="update tb_superadmin set superadminpassword=? where superadminname=?";
		Object[] params={
				anuser.getSuperadminpassword(),anuser.getSuperadminname()
		};
		DBHelper.update(sql, params);
	}
	
}
