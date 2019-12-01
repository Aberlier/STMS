package com.zy.user.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.zy.user.domain.Admin;
import com.zy.user.domain.Score;
import com.zy.user.util.DBHelper;

public class ScoreDao {
	
	public List<Map<String,Object>> findAllScore(String sname){
		String sql="select * from tb_score where sname like ? ";
		return 	DBHelper.find(sql,sname);
	}
	public List<Map<String,Object>> findAllExam(){
		String sql="select * from tb_exam where 1=1";
		return 	DBHelper.find(sql);
	}
	public List<Map<String,Object>> findAllStudentName(String headmaster){
		String sql="select sname from tb_student where headmaster=?";
		return 	DBHelper.find(sql,headmaster);
	}
	public List<Map<String,Object>> findAllStudentName(){
		String sql="select sname from tb_student";
		return 	DBHelper.find(sql);
	}
	public List<Map<String,Object>> admin_findAllStudentName(){
		String sql="select sname from tb_student";
		return 	DBHelper.find(sql);
	}
	public List<Map<String,Object>> findAll(String key,int index,int pageSize){
		String sql="select *  from tb_score LEFT OUTER JOIN tb_exam ON tb_score.eid = tb_exam.eid where sname like ? limit ?,?";
		return 	DBHelper.find(sql,key,index,pageSize);
	}
	public List<Map<String,Object>> findAll_fushi(String key,int index,int pageSize){
		String sql="select *  from tb_score_fushi  LEFT OUTER JOIN tb_exam ON tb_score_fushi.eid = tb_exam.eid where sname like ? limit ?,?";
		return 	DBHelper.find(sql,key,index,pageSize);
	}
	
	public List<Map<String,Object>> tea_findAll(String key,int index,int pageSize){
		String sql="select *  from tb_exam  LEFT OUTER JOIN tb_score ON tb_score.eid = tb_exam.eid inner join tb_student on tb_score.sname=tb_student.sname where tb_score.headmaster like ?  order by tb_score.sid DESC limit ?,?";
		return 	DBHelper.find(sql,key,index,pageSize);
	}
	public List<Map<String,Object>> adm_findAll(int index,int pageSize){
		String sql="select *  from tb_exam  LEFT OUTER JOIN tb_score ON tb_score.eid = tb_exam.eid inner join tb_student on tb_score.sname=tb_student.sname order by tb_score.sid DESC limit ?,?";
		return 	DBHelper.find(sql,index,pageSize);
	}
	public List<Map<String,Object>> admin_findAll(int index,int pageSize){
		String sql="select *  from tb_exam  LEFT OUTER JOIN tb_score ON tb_score.eid = tb_exam.eid inner join tb_student on tb_score.sname=tb_student.sname  limit ?,?";
		return 	DBHelper.find(sql,index,pageSize);
	}
	public List<Map<String,Object>> tea_findAll2(String key,int index,int pageSize){
		String sql="select *  from tb_exam  LEFT OUTER JOIN tb_score_fushi ON tb_score_fushi.eid = tb_exam.eid inner join tb_student on tb_score_fushi.sname=tb_student.sname  where tb_score_fushi.headmaster like ? limit ?,?";
		return 	DBHelper.find(sql,key,index,pageSize);
	}
	public List<Map<String,Object>> adm_findAll2(int index,int pageSize){
		String sql="select *  from tb_exam  LEFT OUTER JOIN tb_score_fushi ON tb_score_fushi.eid = tb_exam.eid inner join tb_student on tb_score_fushi.sname=tb_student.sname limit ?,?";
		return 	DBHelper.find(sql,index,pageSize);
	}
	public List<Map<String,Object>> tea_findAll_query(String ename,String sname,String key,int index,int pageSize){
		String sql="select * from tb_score" +
				" LEFT OUTER JOIN tb_exam ON tb_score.eid = tb_exam.eid" +
				" where 1=1 and ename like ? and sname like ? having tb_score.headmaster like ? limit ?,?";
		Object[] params={
				ename,sname,key,index,pageSize
		};
		if ("".equals(ename)){
			sql="select * from tb_score" +
					" LEFT OUTER JOIN tb_exam ON tb_score.eid = tb_exam.eid" +
					" where 1=1 and sname like ? having tb_score.headmaster like ? limit ?,?";
			params= new Object[]{
					 sname, key, index, pageSize
			};
		}
		else if ("".equals(sname)){
			sql="select * from tb_score" +
					" LEFT OUTER JOIN tb_exam ON tb_score.eid = tb_exam.eid" +
					" where 1=1 and ename like ? having tb_score.headmaster like ? limit ?,?";
			params= new Object[]{
					ename, key, index, pageSize
			};
		}
		return 	DBHelper.find(sql,params);
	}
	public List<Map<String,Object>> tea_findAll_query2(String ename,String sname,String key,int index,int pageSize){
		String sql="select * from tb_score_fushi LEFT OUTER JOIN tb_exam ON tb_score_fushi.eid = tb_exam.eid " +
				"where 1=1 and ename like ? and sname like ? having tb_score_fushi.headmaster like ? limit ?,?";
		Object[] params={
				ename,sname,key,index,pageSize
		};
		if ("".equals(ename)){
			sql="select * from tb_score_fushi LEFT OUTER JOIN tb_exam ON tb_score_fushi.eid = tb_exam.eid " +
					"where 1=1 and sname like ? having tb_score_fushi.headmaster like ? limit ?,?";
			params= new Object[]{
					sname, key, index, pageSize
			};
		}
		else if ("".equals(sname)){
			sql="select * from tb_score_fushi LEFT OUTER JOIN tb_exam ON tb_score_fushi.eid = tb_exam.eid " +
					"where 1=1 and ename like ? having tb_score_fushi.headmaster like ? limit ?,?";
			params= new Object[]{
					ename, key, index, pageSize
			};
		}
		return 	DBHelper.find(sql,params);
	}
	public List<Map<String,Object>> adm_findAll_query(String ename,String sname,int index,int pageSize){
		String sql="select * from tb_score LEFT OUTER JOIN tb_exam ON tb_score.eid = tb_exam.eid " +
				"where 1=1 and ename like ? and sname like ? limit ?,?";
		Object[] params={
				ename,sname,index,pageSize
		};
		if ("".equals(ename)){
			sql="select * from tb_score LEFT OUTER JOIN tb_exam ON tb_score.eid = tb_exam.eid " +
					"where 1=1 and sname like ? limit ?,?";
			params= new Object[]{
					sname, index, pageSize
			};
		}
		else if ("".equals(sname)){
			sql="select * from tb_score LEFT OUTER JOIN tb_exam ON tb_score.eid = tb_exam.eid " +
					"where 1=1 and ename like ? limit ?,?";
			params= new Object[]{
					ename,  index, pageSize
			};
		}
		return 	DBHelper.find(sql,params);
	}
	public List<Map<String,Object>> adm_findAll_query2(String ename,String sname,int index,int pageSize){
		String sql="select * from tb_score_fushi LEFT OUTER JOIN tb_exam ON tb_score_fushi.eid = tb_exam.eid" +
				" where 1=1 and ename like ? and sname like ? limit ?,?";
		Object[] params={
				ename,sname,index,pageSize
		};
		if ("".equals(ename)){
			sql="select * from tb_score_fushi LEFT OUTER JOIN tb_exam ON tb_score_fushi.eid = tb_exam.eid" +
					" where 1=1 and sname like ? limit ?,?";
			params= new Object[]{
					sname, index, pageSize
			};
		}
		else if ("".equals(sname)){
			sql="select * from tb_score_fushi LEFT OUTER JOIN tb_exam ON tb_score_fushi.eid = tb_exam.eid" +
					" where 1=1 and ename like ? limit ?,?";
			params= new Object[]{
					ename,  index, pageSize
			};
		}
		return 	DBHelper.find(sql,params);
	}
	public List<Map<String, Object>> findCount(String key) {
		
		String	sql="select count(sid) from tb_score where sname like ?";
		
		return DBHelper.find(sql,key);
	}
	public List<Map<String, Object>> findCount_fushi(String key) {
		
		String	sql="select count(sid) from tb_score_fushi where sname like ?";
		
		return DBHelper.find(sql,key);
	}
public List<Map<String, Object>> tea_findCount2(String key) {
		
		String	sql="select count(sid) from tb_score_fushi where headmaster like ?";
		
		return DBHelper.find(sql,key);
	}
	
	public List<Map<String, Object>> tea_findCount(String key) {
		
		String	sql="select count(sid) from tb_score where headmaster like ?";
		
		return DBHelper.find(sql,key);
	}
	public List<Map<String, Object>> adm_findCount() {
		String	sql="select count(sid) from tb_score";
		return DBHelper.find(sql);
	}
	public List<Map<String, Object>> adm_findCount2() {
		String	sql="select count(sid) from tb_score_fushi";
		return DBHelper.find(sql);
	}
public List<Map<String, Object>> admin_findCount() {
		
		String	sql="select count(sid) from tb_score";
		
		return DBHelper.find(sql);
	}
public List<Map<String, Object>> tea_findCount_ename(String key) {
		
		String	sql="select count(id) from tb_score where ename like ?";
		
		return DBHelper.find(sql,key);
	}
	 //根据sname读取一条记录
		public List<Map<String, Object>> findbyId(String sname){
			String sql="select * from tb_student where sname=?";
			List<Map<String,Object>> list=DBHelper.find(sql, sname);
	        return list;
			
		}
		public List<Map<String, Object>> findbyscore(int sid){
			String sql="select * from tb_score where sid=?";
			List<Map<String,Object>> list=DBHelper.find(sql,sid);
	        return list;
			
		}
		public List<Map<String, Object>> findbyscore_headmaster(int sid){
			String sql="select * from tb_score where sid=?";
			List<Map<String,Object>> list=DBHelper.find(sql,sid);
	        return list;
			
		}public List<Map<String, Object>> findbyscore_eid(int sid){
			String sql="select * from tb_score where sid=?";
			List<Map<String,Object>> list=DBHelper.find(sql,sid);
	        return list;
			
		}
	
		public List<Map<String, Object>> findbyscore_fushi(int sid){
			String sql="select * from tb_score_fushi where sid=?";
			List<Map<String,Object>> list=DBHelper.find(sql,sid);
	        return list;
			
		}
		public Object addscore(Score score){
			String sql="insert into tb_score(sname,chinese,math,english,physics,chemistry,politics,history,geography,biology,headmaster,eid,sum,avg,regionalranking) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			Object params[]={
					score.getSname(),
					score.getChinese(),
					score.getMath(),score.getEnglish(),score.getPhysics(),score.getChemistry(),score.getPolitics(),score.getHistory(),
					score.getGeography(),score.getBiology(),score.getHeadmaster(),score.getEid(),score.getSum(),score.getAvg(),score.getRegionalranking()
			};
			return DBHelper.insert(sql, params);
		}
		public Object addscore2(Score score){
			String sql="insert into tb_score_fushi(sname,chinese,math,english,physics,chemistry,politics,history,geography,biology,headmaster,eid,sum,avg,regionalranking) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			Object params[]={
					score.getSname(),
					score.getChinese(),
					score.getMath(),score.getEnglish(),score.getPhysics(),score.getChemistry(),score.getPolitics(),score.getHistory(),
					score.getGeography(),score.getBiology(),score.getHeadmaster(),score.getEid(),score.getSum(),score.getAvg(),score.getRegionalranking()
			};
			return DBHelper.insert(sql, params);
		}
		public List<Map<String, Object>> tea_findAll_stu_Score(String headmaster) {
		String getGradeSql="select distinct classname from tb_grade";
		List<Map<String,Object>> list=DBHelper.find(getGradeSql);	
		
		return list;
		}
		
		public List<Map<String, Object>> tea_findAll_stu_Score2(String headmaster) {
			String getMajorSql="select classnum from tb_classname";
			List<Map<String,Object>> list2=DBHelper.find(getMajorSql);
			return list2;
			}
		public int admin_update_score(Score score) {
			String sql="update tb_score set chinese=?,math=?,english=?,physics=?,chemistry=?,politics=?,history=?,geography=?,biology=?,avg=?,sum=? where sid=?";
			Object[] params={
					score.getChinese(),score.getMath(),score.getEnglish(),score.getPhysics(),score.getChemistry(),score.getPolitics(),
					score.getHistory(),score.getGeography(),score.getBiology(),score.getAvg(),score.getSum(),score.getSid()
			};
			return DBHelper.update(sql, params);
		}
		public int admin_update_score_fushi(Score score) {
			String sql="update tb_score_fushi set chinese=?,math=?,english=?,physics=?,chemistry=?,politics=?,history=?,geography=?,biology=?,avg=?,sum=? where sid=?";
			Object[] params={
					score.getChinese(),score.getMath(),score.getEnglish(),score.getPhysics(),score.getChemistry(),score.getPolitics(),
					score.getHistory(),score.getGeography(),score.getBiology(),score.getAvg(),score.getSum(),score.getSid()
			};
			return DBHelper.update(sql, params);
		}


	public List<Score> findByEid(int eid) {
		List<Score> resultList = null;
		String sql="select *  from tb_score where eid=?";
		List<Map<String, Object>> list = DBHelper.find(sql, eid);
		if (list.size()>0){
			resultList=new ArrayList<>();

			for (Map<String, Object> scoreMap : list) {
				Score score = JSONObject.parseObject(JSONObject.toJSONString(scoreMap), Score.class);
				resultList.add(score);
			}
		}

		return resultList;

	}
	

	public int updateProvincialranking(Score score) {
		String sql="update tb_score set provincialranking=? where sid=?";
		return DBHelper.update(sql, score.getProvincialranking(),score.getSid());
	}

	public List<Score> findByEid2(int eid) {
		List<Score> resultList = new ArrayList<>();
		String sql="select *  from tb_score_fushi where eid=?";
		List<Map<String, Object>> list = DBHelper.find(sql, eid);
		if (list.size()>0){

			for (Map<String, Object> scoreMap : list) {
				Score score = JSONObject.parseObject(JSONObject.toJSONString(scoreMap), Score.class);
				resultList.add(score);
			}
		}

		return resultList;

	}

	public int updateProvincialranking2(Score score) {
		String sql="update tb_score_fushi set provincialranking=? where sid=?";
		return DBHelper.update(sql, score.getProvincialranking(),score.getSid());
	}

	public List<String> getExamsBySname(String sname) {
		List<String> resultList = new ArrayList<>();
		String sql = "select e.ename from tb_score as s \n" +
				"join tb_exam as e on s.eid=e.eid and s.sname=? group by e.ename order by s.sid asc";
		List<Map<String, Object>> list = DBHelper.find(sql, sname);
		if (list.size()>0){
			for (Map<String, Object> map : list) {
				resultList.add(map.get("ename").toString());
			}
		}
		return resultList;
	}

	public List<String> getSumBySname(String sname) {
		List<String> resultList = new ArrayList<>();
		String sql = "select s.sum from tb_score as s \n" +
				"where s.sname=? order by s.sid asc";
		List<Map<String, Object>> list = DBHelper.find(sql, sname);
		if (list.size()>0){
			for (Map<String, Object> map : list) {
				resultList.add(map.get("sum").toString());
			}
		}
		return resultList;
	}

	public List<String> getAvgBySname(String sname) {
		List<String> resultList = new ArrayList<>();
		String sql = "select s.avg from tb_score as s \n" +
				"where s.sname=? order by s.sid asc";
		List<Map<String, Object>> list = DBHelper.find(sql, sname);
		if (list.size()>0){
			for (Map<String, Object> map : list) {
				resultList.add(map.get("avg").toString());
			}
		}
		return resultList;
	}
	public List<Map<String, Object>> findAllTea() {
		String sql="select * from tb_teacher";
		List<Map<String,Object>> list=DBHelper.find(sql);
		return list;
	}
	public List<Map<String, Object>> findExamByTname(String tname) {
		String sql ="select " +
				"s.eid,e.ename,avg(s.avg) pingjunfen,sum(case when avg>=80 then 1 else 0 end)/count(*)*100 jigelv,sum(case when avg>=85 then 1 else 0 end)/count(*)*100 youxiulv " +
				"from tb_score  as s\n" +
				"join tb_exam  as e on s.eid=e.eid\n" +
				"where s.headmaster=? " +
				"group by s.eid";
		return DBHelper.find(sql, tname);
	}

	public List<Map<String, Object>> findBySname(String sname) {
		String sql="SELECT s.eid,e.ename,sa.avg,sa.sum,AVG(s.avg) pingjunfen,AVG(s.sum) zongfen FROM \n" +
				"tb_score AS s\n" +
				"JOIN tb_exam AS e ON s.`eid`=e.`eid`\n" +
				"JOIN (SELECT regionalranking sum,AVG,eid FROM tb_score WHERE sname=?) AS sa ON sa.eid=s.eid\n" +
				"WHERE s.eid IN(SELECT eid FROM tb_score WHERE sname=? GROUP BY eid)\n" +
				"GROUP BY s.eid ";
		return DBHelper.find(sql, sname,sname);
	}

	public List<Map<String, Object>> findScoreExcelByTname(String tname,String eid) {
		String sql="select s.*,e.ename from tb_score as s\n" +
				"join tb_exam as e on s.eid=e.eid\n" +
				"where s.headmaster=? and s.eid=?";
		return DBHelper.find(sql, tname,eid);
	}
	public List<Map<String, Object>> find_fushi_ScoreExcelByTname(String tname,String eid) {
		String sql="select s.*,e.ename from tb_score_fushi as s\n" +
				"join tb_exam as e on s.eid=e.eid\n" +
				"where s.headmaster=? and s.eid=?";
		return DBHelper.find(sql, tname,eid);
	}
	
	public List<Map<String, Object>> findExportExcelAll() {
		String sql="select s.eid,s.headmaster,e.ename,'初试' as type from tb_score as s\n" +
				"join tb_exam as e on s.eid=e.eid\n" +
				"group by s.eid\n" +
				"UNION\n" +
				"select s.eid,s.headmaster,e.ename,'复试' as type from tb_score_fushi as s\n" +
				"join tb_exam as e on s.eid=e.eid\n" +
				"group by s.eid";
		return DBHelper.find(sql);
	}

    public List<Map<String, Object>> findAllExamByTname(String headmaster) {
		String sql="select s.eid,e.ename from tb_score as s\n" +
				"join tb_exam as e on s.eid=e.eid\n" +
				"where s.headmaster=?\n" +
				"group by s.eid order by s.sid desc";
		return DBHelper.find(sql,headmaster);
    }

	public List<Map<String, Object>> selStackbarData(String tname) {
		String sql="select \n" +
				"sum(case when s.sum between 0 and 100 then 1 else 0 end) as a0,\n" +
				"sum(case when s.sum between 101 and 200 then 1 else 0 end) as a5,\n" +
				"sum(case when s.sum between 201 and 300 then 1 else 0 end) as a6,\n" +
				"sum(case when s.sum between 301 and 400 then 1 else 0 end) as a7,\n" +
				"sum(case when s.sum between 401 and 500 then 1 else 0 end) as a8,\n" +
				"sum(case when s.sum between 501 and 600 then 1 else 0 end) as a9,\n" +
				"sum(case when s.sum between 601 and 800 then 1 else 0 end) as a10,\n" +
				"e.ename as ename\n" +
				" from tb_score as s\n" +
				"join tb_exam as e on s.eid=e.eid\n" +
				"where s.headmaster=?\n" +
				"group by s.eid\n";
		return DBHelper.find(sql,tname);
	}
	
	public List<Score> findProvincialranking(int eid) {
		List<Score> resultList = null;
		String sql="select * from tb_score where eid=?";
		List<Map<String, Object>> list = DBHelper.find(sql,eid);
		if (list.size()>0){
			resultList=new ArrayList<>();
			for (Map<String, Object> scoreMap : list) {
				Score score = JSONObject.parseObject(JSONObject.toJSONString(scoreMap), Score.class);
				resultList.add(score);
			}
		}
		return resultList;
	}
	
	public List<Score> findProvincialranking_update(int eid) {
		List<Score> resultList = null;
		String sql="select * from tb_score where eid=?";
		List<Map<String, Object>> list = DBHelper.find(sql,eid);
		if (list.size()>0){
			resultList=new ArrayList<>();
			for (Map<String, Object> scoreMap : list) {
				Score score = JSONObject.parseObject(JSONObject.toJSONString(scoreMap), Score.class);
				resultList.add(score);
			}
		}
		return resultList;
	}
	public List<Score> findRegionalranking(int eid,String headmaster) {
		List<Score> resultList = null;
		String sql="select * from tb_score where eid=? and headmaster=?";
		List<Map<String, Object>> list = DBHelper.find(sql,eid,headmaster);
		if (list.size()>0){
			resultList=new ArrayList<>();
			for (Map<String, Object> scoreMap : list) {
				Score score = JSONObject.parseObject(JSONObject.toJSONString(scoreMap), Score.class);
				resultList.add(score);
			}
		}
		return resultList;
	}
	public List<Score> findRegionalranking_update(int eid,String headmaster) {
		List<Score> resultList = null;
		String sql="select * from tb_score where eid=? and headmaster=?";
		List<Map<String, Object>> list = DBHelper.find(sql,eid,headmaster);
		if (list.size()>0){
			resultList=new ArrayList<>();
			for (Map<String, Object> scoreMap : list) {
				Score score = JSONObject.parseObject(JSONObject.toJSONString(scoreMap), Score.class);
				resultList.add(score);
			}
		}
		return resultList;
	}
	public int updateRegionalranking(Score score) {
			String sql="update tb_score set regionalranking=? where sid=? and headmaster = ?";
			return DBHelper.update(sql, score.getRegionalranking(),score.getSid(),score.getHeadmaster());
	}
	
	
}
