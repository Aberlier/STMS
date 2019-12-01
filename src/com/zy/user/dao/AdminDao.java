package com.zy.user.dao;

import java.util.List;
import java.util.Map;

import com.zy.user.domain.Admin;
import com.zy.user.domain.Award;
import com.zy.user.domain.ExaminationBaoKao;
import com.zy.user.domain.Student;
import com.zy.user.domain.Teacher;
import com.zy.user.util.DBHelper;

public class AdminDao {

	public List<Map<String, Object>> findbyId(String adminname){
		String sql="select * from tb_admin where adminname=?";
		List<Map<String,Object>> list=DBHelper.find(sql, adminname);
        return list;
		
	}
	public List<Map<String, Object>> superadmin_findbyId(String superadminname){
		String sql="select * from tb_superadmin where superadminname=?";
		List<Map<String,Object>> list=DBHelper.find(sql, superadminname);
        return list;
		
	}
		public void updateme(Admin anuser){
		String sql="update tb_admin set adminpass=? where adminname=?";
		Object[] params={
				anuser.getAdminpass(),anuser.getAdminname()
		};
		DBHelper.update(sql, params);
	}
		public List<Map<String, Object>> findCount(String key) {
			String	sql="select count(id) from tb_student where fudaoclass like ?";
			return DBHelper.query(sql,key);
		}
		public List<Map<String, Object>> findStuCount(String key) {
			String	sql="select count(id) from tb_student where sname like ?";
			return DBHelper.query(sql,key);
		}
		public List<Map<String, Object>> findStuCount() {
			String	sql="select count(id) from tb_student";
			return DBHelper.find(sql);
		}
		public List<Map<String, Object>> findCountTea() {
			String	sql="select count(id) from tb_teacher";
			return DBHelper.find(sql);
		}
		public List<Map<String, Object>> TeafindCount(String key) {
			String	sql="select count(id) from tb_teacher where tname like ?";
			return DBHelper.query(sql,key);
		}
		public List<Map<String, Object>> findCountTea(String key) {
			String	sql="select count(id) from tb_teacher where organize like ?";
			return DBHelper.query(sql,key);
		}
		public List<Map<String,Object>> findAll_stu(int index,int pageSize){
		String sql="select * from tb_student limit ?,?";
		return 	DBHelper.find(sql,index,pageSize);
	}
		public List<Map<String,Object>> findAll_tea(int index,int pageSize){
			String sql="select * from tb_teacher limit ?,? ";
			return 	DBHelper.find(sql,index,pageSize);
		}
		public List<Map<String,Object>> findAll_tea_teaname(){
			String sql="select * from tb_teacher";
			return 	DBHelper.find(sql);
		}
		public void insert_tea(Teacher teacher){
			
			String sql="insert into tb_teacher(tno,tname,tsex,temail,tpwd,single,registData,depart,role) values(?,?,?,?,?,?,?,?,?)";
			Object params[]={
					teacher.getTno(),teacher.getTname(),
					teacher.getTsex(),teacher.getTemail(),
					teacher.getTpwd(),teacher.getSingle(),
					teacher.getRegistData(),teacher.getDepart(),teacher.getRole()
			};
			DBHelper.insert(sql, params);
			
	}
		public void delete_tea(String tname)
		{
			String sql = "delete from tb_teacher where id=?";
			DBHelper.update(sql,tname);
		}
		public void admin_update_baokao_Single(ExaminationBaoKao anuser){
			String sql="update tb_examinationbaokao set adminsingle=? where id=?";
			Object []params={
					anuser.getAdminsingle(),anuser.getId()
			};
			DBHelper.update(sql, params);
		}
		public void updateSingle_tea(Teacher anuser){
			String sql="update tb_teacher set single=? where tname=?";
			Object []params={
					anuser.getSingle(),anuser.getTname()
			};
			DBHelper.update(sql, params);
		}
		public void updateSingle_stu(Student anuser){
			String sql="update tb_student set single=? where sname=?";
			Object []params={
					anuser.getSingle(),anuser.getSname()
			};
			DBHelper.update(sql, params);
		}
		public void addstu(Student student){
			String sql="insert into tb_student(id,sname,sex,single,role,old,born,place,schoolname,fudaoclass,fudaoteacher,parentsname,parentstel,registdata,headmaster) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			Object params[]={
					student.getId(),
					student.getSname(),
					student.getSex(),
					student.getSingle(),student.getRole(),student.getOld(),
					student.getBorn(),student.getPlace(),student.getSchoolname(),student.getFudaoclass(),student.getFudaoteacher(),
					student.getParentsname(),student.getParentstel(),
					student.getRigestdata(),student.getHeadmaster()
			};
			DBHelper.insert(sql, params);
	}
		public List<Map<String, Object>> SfindbyId(String sname){
			String sql="select * from tb_student where sname=?";
			List<Map<String,Object>> list=DBHelper.find(sql, sname);
	        return list;
			
		}
		public List<Map<String, Object>> TfindbyId(String tname){
			String sql="select * from tb_teacher where tname=?";
			List<Map<String,Object>> list=DBHelper.find(sql, tname);
	        return list;
			
		}
		public void deletestu(String sname) {
			String sql = "DELETE tb_student,tb_score from tb_student LEFT JOIN tb_score ON tb_student.sname=tb_score.sname WHERE tb_student.sname=?";
			DBHelper.update(sql,sname);
		}
		
		public void addtea(Teacher tea){
			String sql="insert into tb_teacher(tno,tname,tsex,temail,tpwd,single,registData,depart,role,organize) values(?,?,?,?,?,?,?,?,?,?)";
			Object params[]={
					tea.getTno(),
					tea.getTname(),
					tea.getTsex(),tea.getTemail(),
					tea.getTpwd(),tea.getSingle(),tea.getRegistData(),tea.getDepart(),tea.getRole(),
					tea.getOrganize()
					
			};
			DBHelper.insert(sql, params);
		}
		public List<Map<String, Object>> findCount_adm() {
			String	sql="select count(id) from tb_admin";
			return DBHelper.find(sql);
		}
		public List<Map<String, Object>> findCount_award() {
			String	sql="select count(aid) from tb_award";
			return DBHelper.find(sql);
		}
		
		public Object findAll_adm(int index, int pageSize) {
			String sql="select * from tb_admin limit ?,?";
			return 	DBHelper.find(sql,index,pageSize);
		}
		public Object findAll_award(int index, int pageSize) {
			String sql="select * from tb_award limit ?,?";
			return 	DBHelper.find(sql,index,pageSize);
		}
		
		public void updateSingle_adm(Admin anuser) {
			String sql="update tb_admin set sign=? where adminname=?";
			Object params[]={
					anuser.getSign(),anuser.getAdminname()
			};
			DBHelper.update(sql, params);
		}
		public void deleteadm(String adminname) {
			String sql = "delete from tb_admin where adminname=?";
			DBHelper.update(sql,adminname);
		}
		public List<Map<String, Object>> findbyId(int id){
			String sql="select * from tb_admin where id=?";
			List<Map<String,Object>> list=DBHelper.find(sql, id);
	        return list;
			
		}
		public void updateAdmin(Admin admin) {
			String sql="update tb_admin set adminname=?,adminpass=? where id=?";
			Object params[]={
					admin.getAdminname(),admin.getAdminpass(),admin.getId()
			};
			DBHelper.update(sql, params);
		}
		public void addadmin(Admin admin) {
			String sql="insert into tb_admin(adminname,adminpass,role,addtime,sign,sex) values(?,?,?,?,?,?)";
			Object params[]={
					admin.getAdminname(),admin.getAdminpass(),admin.getRole(),admin.getAddtime(),admin.getSign(),admin.getSex()
			};
			DBHelper.insert(sql, params);
		}
		public void delete_award(String aid) {
			String sql = "delete from tb_award where aid=?";
			DBHelper.update(sql,aid);
		}
		public void addAward(Award a) {
			String sql="insert into tb_award (award) values (?)";
			Object params[]={
					a.getAward()
			};
			DBHelper.insert(sql, params);
		}
		public List<Map<String, Object>> admin_query_org(String key,int index,int pageSize) {
			String sql="select * from tb_student WHERE fudaoclass like ? limit ?,?";
			List<Map<String,Object>> list=DBHelper.find(sql,key,index,pageSize);
	        return list;
		}
		public List<Map<String, Object>> admin_query_tea_org(String key,int index,int pageSize) {
			String sql="select * from tb_teacher WHERE organize like ? limit ?,?";
			List<Map<String,Object>> list=DBHelper.find(sql,key,index,pageSize);
	        return list;
		}

}
