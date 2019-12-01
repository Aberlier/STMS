package com.zy.user.dao;

import java.util.List;
import java.util.Map;

import com.zy.user.domain.Exam;
import com.zy.user.domain.ExamByWay;
import com.zy.user.domain.ExaminationBaoKao;
import com.zy.user.domain.Score;
import com.zy.user.util.DBHelper;

public class ExaminationDao {
public int insert(ExaminationBaoKao eb){
		
		String sql="insert into tb_examinationbaokao (sname,myclass,school,place,school2,fudaoclass,fudaoteacher,parentsname,parentstel,intentionalschool,teasingle,adminsingle,baokaotime) " +
				"values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object params[]={
				eb.getSname(),
				eb.getMyclass(),eb.getSchool(),eb.getPlace(),eb.getSchool2(),
				eb.getFudaoclass(),eb.getFudaoteacher(),eb.getParentsname(),
				eb.getParentstel(),eb.getIntentionalschool(),eb.getTeasingle(),eb.getAdminsingle(),eb.getBaokaotime()
				
		};
		return DBHelper.insert(sql, params);
		
}
	public void delete(int id)
	{
		String sql = "delete from tb_examinationbaokao where id=?";
		DBHelper.update(sql,id);
	}
	public void delete_exam(int eid)
	{
		String sql = "DELETE tb_exam,tb_exam_byway from tb_exam LEFT JOIN tb_exam_byway ON tb_exam.ename=tb_exam_byway.examname WHERE tb_exam.eid=?";
		DBHelper.update(sql,eid);
	}
	public int update_baokao(ExaminationBaoKao baokao){
		String sql="update tb_examinationbaokao set myclass=?,school=?,place=?,fudaoclass=?,fudaoteacher=?,parentsname=?,parentstel=?,intentionalschool=?,school2=? where id=?";
		Object[] params={
				baokao.getMyclass(),baokao.getPlace(),
				baokao.getSchool(),baokao.getFudaoclass(),baokao.getFudaoteacher(),
				baokao.getParentsname(),baokao.getParentstel(),baokao.getIntentionalschool(),baokao.getSchool2(),baokao.getId()
		};
		
		return DBHelper.update(sql, params);
	}
	
	public List<Map<String, Object>> findbyId(int id){
		String sql="select * from tb_examinationbaokao where id=?";
		List<Map<String,Object>> list=DBHelper.find(sql, id);
        return list;
		
	}
	public List<Map<String,Object>> findAll(String key,int index,int pageSize){
		String sql="select * from tb_examinationbaokao LEFT OUTER JOIN tb_grade ON tb_examinationbaokao.myclass = tb_grade.classname where sname like ? limit ?,?";
		return 	DBHelper.find(sql,key,index,pageSize);
	}
	public List<Map<String,Object>> findAll_exam(int index,int pageSize){
		String sql="select * from tb_exam limit ?,?";
		return 	DBHelper.find(sql,index,pageSize);
	}
	public List<Map<String, Object>> findCount(String key) {
		String	sql="select count(id) from tb_examinationbaokao where sname like ?";
		return DBHelper.find(sql,key);
	}
	public List<Map<String, Object>> findCount_exam() {
		String	sql="select count(eid) from tb_exam";
		return DBHelper.find(sql);
	}
	public Object addExam(Exam exam) {
	String sql="insert into tb_exam (ename,examclass,addexamtime,examtime,signuptime,signdowntime,adminname) " +
			"values(?,?,?,?,?,?,?)";
	Object params[]={
			exam.getEname(),exam.getExamclass(),exam.getAddexamtime(),exam.getExamtime(),exam.getSignuptime(),exam.getSigndowntime(),exam.getAdminname()
		};
	Object error=DBHelper.insert(sql, params);
	return error;
}
	public List<Map<String, Object>> findbyId_Exam(int eid) {
		String sql="select * from tb_exam where eid=?";
		List<Map<String,Object>> list=DBHelper.find(sql, eid);
        return list;
	}
	public void update_Exam(Exam anuser) {
		String sql="update tb_exam set ename=?,examtime=?,signuptime=?,signdowntime=? where eid=?";
		Object[] params={
				anuser.getEname(),anuser.getExamtime(),anuser.getSignuptime(),anuser.getSigndowntime(),anuser.getEid()
		};
		DBHelper.update(sql, params);
	}
	public List<Map<String, Object>> findCount_exambyway() {
		String	sql="select count(bid) from tb_exam_byway";
		return DBHelper.find(sql);
	}
	public List<Map<String, Object>> findAll_exambyway(int index, int pageSize) {
		String sql="select * from tb_exam_byway LEFT OUTER JOIN tb_tea_organization ON tb_exam_byway.oname = tb_tea_organization.organizationname  INNER JOIN tb_exam ON tb_exam_byway.examname = tb_exam.ename limit ?,?";
		return 	DBHelper.find(sql,index,pageSize);
	}
	public void delete_exam_byway(int id) {
		String sql = "delete from tb_exam_byway where bid=?";
		DBHelper.update(sql,id);
	}
	public List<Map<String, Object>> findbyId_ExamByWay(int bid) {
		String sql="select * from tb_exam_byway LEFT OUTER JOIN tb_tea_organization ON tb_exam_byway.oname = tb_tea_organization.organizationname  INNER JOIN tb_exam ON tb_exam_byway.examname = tb_exam.ename where tb_exam_byway.bid=?";
		List<Map<String,Object>> list=DBHelper.find(sql,bid);
        return list;
	}public void update_ExamByWaySign(ExamByWay anuser){
		String sql="update tb_exam_byway set sign=? where bid=?";
		Object []params={
				anuser.getSign(),anuser.getBid()
		};
		DBHelper.update(sql, params);
	}
	public Object addExamByWay(ExamByWay ebw) {
		String sql="insert into tb_exam_byway (oname,examname,examplace,busline,addpeople,addexambywaytime,sign) " +
				"values(?,?,?,?,?,?,?)";
		Object params[]={
				ebw.getOname(),
				ebw.getExamname(),ebw.getExamplace(),ebw.getBusline(),
				ebw.getAddpeople(),ebw.getAddExamByWayTime(),ebw.getSign()
		};
		Object error=DBHelper.insert(sql, params);
		return error;
	}
	public List<Map<String, Object>> findExamOfExamByWay() {
			String sql="select * from tb_exam";
			List<Map<String,Object>> list=DBHelper.find(sql);
	        return list;
	}
	public List<Map<String, Object>> findOrganizationOfExamByWay() {
		String sql="select * from tb_tea_organization";
		List<Map<String,Object>> list=DBHelper.find(sql);
        return list;
}
	public List<Map<String, Object>> findAward() {
		String sql="select * from tb_award";
		List<Map<String,Object>> list=DBHelper.find(sql);
        return list;
	}
	public void addAward(Score score) {
		String sql="update tb_score set award=? where sid=?";
		Object []params={
				score.getAward(),score.getSid()
		};
		DBHelper.update(sql, params);
	}
	public void addAward2(Score score) {
		String sql="update tb_score_fushi set award=? where sid=?";
		Object []params={
				score.getAward(),score.getSid()
		};
		DBHelper.update(sql, params);
	}
	public List<Map<String, Object>> findGrade() {
		String sql="select * from tb_grade";
		List<Map<String,Object>> list=DBHelper.find(sql);
        return list;
	}
	public List<Map<String, Object>> findOrganization() {
		String sql="select * from tb_tea_organization";
		List<Map<String,Object>> list=DBHelper.find(sql);
        return list;
	}
	public List<Map<String, Object>> findTeacher() {
		String sql="select * from tb_teacher";
		List<Map<String,Object>> list=DBHelper.find(sql);
        return list;
	}
	public void update_ExamByWay(ExamByWay ebw) {
		String sql="update tb_exam_byway set examname=?,examplace=?,busline=? where bid=?";
		Object []params={
				ebw.getExamname(),ebw.getExamplace(),ebw.getBusline(),ebw.getBid()
		};
		DBHelper.update(sql, params);
	}
	public List<Map<String,Object>> findAllStudent(){
			String sql="select * from tb_student";
			return 	DBHelper.find(sql);
		}
	public void admin_deleteScore(int sid) {
		String sql = "delete from tb_score where sid=?";
		DBHelper.update(sql,sid);
	}
	
}
