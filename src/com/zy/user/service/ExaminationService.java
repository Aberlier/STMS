package com.zy.user.service;

import java.util.List;
import java.util.Map;

import com.zy.user.dao.ExaminationDao;
import com.zy.user.domain.Exam;
import com.zy.user.domain.ExamByWay;
import com.zy.user.domain.ExaminationBaoKao;
import com.zy.user.domain.Score;
import com.zy.user.util.DBHelper;

public class ExaminationService {
	ExaminationDao dao=new ExaminationDao();
	public int add(ExaminationBaoKao eb){
		return dao.insert(eb);
	}	
	public void delete(int id){
		dao.delete(id);
	}
	public int update(ExaminationBaoKao baokao) {
			return dao.update_baokao(baokao);
	}

	public List<Map<String,Object>> findbyId(int id){
		return dao.findbyId(id);
	}
	
	public List<Map<String, Object>> findCount(String key) {
		return dao.findCount(key);
	}
	public List<Map<String, Object>> findCount_exam() {
		return dao.findCount_exam();
	}
	
	public  List<Map<String,Object>> findAll(String key,int index,int pageSize){
		return dao.findAll(key,index,pageSize);
	}
	public  List<Map<String,Object>> findAll_exam(int index,int pageSize){
		return dao.findAll_exam(index,pageSize);
	}
	public Object addExam(Exam exam) {
		return dao.addExam(exam);
	}
	public List<Map<String, Object>> findbyId_Exam(int eid) {
		return dao.findbyId_Exam(eid);
	}
	public void update_Exam(Exam anuser) {
		dao.update_Exam(anuser);
	}
	public void delete_Exam(int eid) {
		dao.delete_exam(eid);
	}
	public List<Map<String, Object>> findCount_exambyway() {
		return dao.findCount_exambyway();
	}
	public List<Map<String, Object>> findAll_exambyway(int index, int pageSize) {
		return dao.findAll_exambyway(index,pageSize);
	}
	public void delete_ExamByWay(int id) {
		dao.delete_exam_byway(id);
	}
	public List<Map<String, Object>> findbyId_ExamByWay(int bid) {
		return dao.findbyId_ExamByWay(bid);
	}
	public void update_ExamByWaySign(ExamByWay anuser) {
		dao.update_ExamByWaySign(anuser);
	}
	public Object addExamByWay(ExamByWay ebw) {
		return dao.addExamByWay(ebw);
	}
	public List<Map<String, Object>> findExamOfExamByWay() {
		return dao.findExamOfExamByWay();
	}
	public List<Map<String, Object>> findOrganizationOfExamByWay() {
		return dao.findOrganizationOfExamByWay();
	}
	public List<Map<String, Object>> findAward() {
		return dao.findAward();
	}
	public void addAward(Score score) {
		dao.addAward(score);
	}
	public void addAward2(Score score) {
		dao.addAward2(score);
	}
	public List<Map<String, Object>> findGrade() {
		return dao.findGrade();
	}
	public List<Map<String, Object>> findOrganization() {
		return dao.findOrganization();
	}
	public List<Map<String, Object>> findTeacher() {
		return dao.findTeacher();
	}
	public  void update_ExamByWay(ExamByWay ebw) {
		dao.update_ExamByWay(ebw);
	}
	public List<Map<String, Object>> findAllStudent() {
		return dao.findAllStudent();
	}
	public void admin_deleteScore(int sid) {
		dao.admin_deleteScore(sid);
	}
	
}
