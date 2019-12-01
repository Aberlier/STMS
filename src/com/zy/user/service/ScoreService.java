package com.zy.user.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.zy.user.dao.ScoreDao;
import com.zy.user.domain.Score;
import com.zy.user.domain.ScoreExcel;

public class ScoreService {
	ScoreDao dao=new ScoreDao();
	
	public Object addscore(Score score){
		return dao.addscore(score);
	}
	public Object addscore2(Score score){
		return dao.addscore2(score);
	}
	public List<Map<String, Object>> findCount(String key) {
		return dao.findCount(key);
	}
	public List<Map<String, Object>> findCount_fushi(String key) {
		return dao.findCount_fushi(key);
	}
	
	public List<Map<String, Object>> tea_findCount(String key) {
		return dao.tea_findCount(key);
	}
	public List<Map<String, Object>> adm_findCount() {
		return dao.adm_findCount();
	}
	public List<Map<String, Object>> adm_findCount2() {
		return dao.adm_findCount2();
	}
	public List<Map<String, Object>> admin_findCount() {
		return dao.admin_findCount();
	}
	public List<Map<String, Object>> tea_findCount2(String key) {
		return dao.tea_findCount2(key);
	}
	public  List<Map<String,Object>> findAll(String key,int index,int pageSize){
		return dao.findAll(key,index,pageSize);
	}
	public  List<Map<String,Object>> findAll_fushi(String key,int index,int pageSize){
		return dao.findAll_fushi(key,index,pageSize);
	}
	public  List<Map<String,Object>> tea_findAll(String key,int index,int pageSize){
		return dao.tea_findAll(key,index,pageSize);
	}
	public  List<Map<String,Object>> adm_findAll(int index,int pageSize){
		return dao.adm_findAll(index,pageSize);
	}
	public  List<Map<String,Object>> admin_findAll(int index,int pageSize){
		return dao.admin_findAll(index,pageSize);
	}
	public  List<Map<String,Object>> tea_findAll2(String key,int index,int pageSize){
		return dao.tea_findAll2(key,index,pageSize);
	}
	public  List<Map<String,Object>> tea_findAll_query2(String ename,String sname,String key,int index,int pageSize){
		return dao.tea_findAll_query2(ename,sname,key,index,pageSize);
	}
	public  List<Map<String,Object>> tea_findAll_query(String ename,String sname,String key,int index,int pageSize){
		return dao.tea_findAll_query(ename,sname,key,index,pageSize);
	}

	public  List<Map<String,Object>> adm_findAll_query(String ename,String sname,int index,int pageSize){
		return dao.adm_findAll_query(ename,sname,index,pageSize);
	}
	public  List<Map<String,Object>> adm_findAll_query2(String ename,String sname,int index,int pageSize){
		return dao.adm_findAll_query2(ename,sname,index,pageSize);
	}
	
	public  List<Map<String,Object>> findAllScore(String sname){
		return dao.findAllScore(sname);
	}
	public  List<Map<String,Object>> findAllStudentName(String headmaster){
		return dao.findAllStudentName(headmaster);
	}
	public  List<Map<String,Object>> findAllStudentName(){
		return dao.findAllStudentName();
	}
	public  List<Map<String,Object>> admin_findAllStudentName(){
		return dao.admin_findAllStudentName();
	}
	public  List<Map<String,Object>> findAllExam(){
		return dao.findAllExam();
	}
	public  List<Map<String,Object>> findAllTea(){
		return dao.findAllTea();
	}
	public List<Map<String,Object>> findbyId(String sname){
		return dao.findbyId(sname);
	}
	public List<Map<String,Object>> findbyscore(int sid){
		return dao.findbyscore(sid);
	}
	public List<Map<String,Object>> findbyscore_eid(int sid){
		return dao.findbyscore_eid(sid);
	}
	public List<Map<String,Object>> findbyscore_headmaster(int sid){
		return dao.findbyscore_headmaster(sid);
	}
	public List<Map<String,Object>> findbyscore_fushi(int sid){
		return dao.findbyscore_fushi(sid);
	}
	public List<Map<String, Object>> tea_findAll_stu_Score(String headmaster) {
		return dao.tea_findAll_stu_Score(headmaster);
	}
	public List<Map<String, Object>> tea_findAll_stu_Score2(String headmaster) {
		return dao.tea_findAll_stu_Score2(headmaster);
	}
	public int admin_update_score(Score score) {
		return dao.admin_update_score(score);
	}
	public int admin_update_score_fushi(Score score) {
		return dao.admin_update_score_fushi(score);
	}
	public List<Score> findByEid(int eid) {
		return dao.findByEid(eid);
	}

	public int updateProvincialranking(Score score) {
		return dao.updateProvincialranking(score);
	}
	
	public int updateRegionalranking(Score score) {
		return dao.updateRegionalranking(score);
	}
	
	public List<Score> findByEid2(int eid) {
		return dao.findByEid2(eid);
	}

	public int updateProvincialranking2(Score score) {
		return dao.updateProvincialranking2(score);
	}

	public List<String> getExamsBySname(String sname) {
		return dao.getExamsBySname(sname);
	}

	public List<String> getSumBySname(String sname) {
		return dao.getSumBySname(sname);
	}
	public List<String> getAvgBySname(String sname) {
		return dao.getAvgBySname(sname);
	}
	public List<Map<String, Object>> adm_findAll2(int index, int pageSize) {
		return dao.adm_findAll2(index, pageSize);
	}
	public List<ScoreExcel> findScoreExcelByTname(String tname,String eid) {
		List<Map<String,Object>> listMap=dao.findScoreExcelByTname(tname,eid);
		List<ScoreExcel> result = JSON.parseArray(JSON.toJSONString(listMap), ScoreExcel.class);
		return result;
	}public List<ScoreExcel> find_fushi_ScoreExcelByTname(String tname,String eid) {
		List<Map<String,Object>> listMap=dao.find_fushi_ScoreExcelByTname(tname,eid);
		List<ScoreExcel> result = JSON.parseArray(JSON.toJSONString(listMap), ScoreExcel.class);
		return result;
	}
	
	public List<Map<String, Object>> findExamByTname(String tname) {
		return dao.findExamByTname(tname);
	}
	public List<Map<String, Object>> findBySname(String sname) {
		return dao.findBySname(sname);
	}

	public List<Map<String, Object>> findExportExcelAll() {
		return dao.findExportExcelAll();
	}

    public List<Map<String, Object>> findAllExamByTname(String headmaster) {
		return dao.findAllExamByTname(headmaster);
    }

	public List<Map<String, Object>> stackBarData(String tname) {
		return dao.selStackbarData(tname);
	}
	public List<Score> findProvincialranking(int eid) {
			return dao.findProvincialranking(eid);
	}
	public List<Score> findProvincialranking_update(int eid) {
		return dao.findProvincialranking_update(eid);
}
	public List<Score> findRegionalranking(int eid,String headmaster) {
		return dao.findRegionalranking(eid,headmaster);
	}public List<Score> findRegionalranking_update(int eid,String headmaster) {
	return dao.findRegionalranking_update(eid,headmaster);
	}
}
