package com.zy.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import com.zy.user.domain.Organize;
import com.zy.user.domain.Teacher;
import com.zy.user.util.DBHelper;

public class TeacherDao {
	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	public void updateOrganize(Organize anuser){
		String sql="update tb_tea_organization set organizationname=?,otel=?,oaddress=? where oid=?";
		Object []params={
				anuser.getOrganizationname(),
				anuser.getOtel(),
				anuser.getOaddress(),anuser.getOid()
		};
		DBHelper.update(sql, params);
	}
	
	public void update(Teacher anuser){
		String sql="update tb_teacher set tname=?,tsex=?,temail=?,depart=? where id=?";
		Object []params={
				anuser.getTname(),
				anuser.getTsex(),
				anuser.getTemail(),anuser.getDepart(),anuser.getId()
		};
		DBHelper.update(sql, params);
	}
	public void updateTeacher(Teacher anuser){
		String sql="update tb_teacher set depart=?,temail=? where tname=?";
		Object []params={
				anuser.getDepart(),
				anuser.getTemail(),anuser.getTname()
		};
		DBHelper.update(sql, params);
	}
	public void updateme(Teacher anuser){
		String sql="update tb_teacher set tpwd=? where tname=?";
		Object[] params={
				anuser.getTpwd(),
				anuser.getTname()
		};
		DBHelper.update(sql, params);
	}
	
	public List<Map<String, Object>> findbyId(String tname){
		String sql="select * from tb_teacher LEFT OUTER JOIN tb_tea_organization ON tb_teacher.organize=tb_tea_organization.organizationname where tname=?";
		List<Map<String,Object>> list=DBHelper.find(sql, tname);
        return list;
		
	}
	public List<Map<String, Object>> updatetea_findbyId(int id){
		String sql="select * from tb_teacher where id=?";
		List<Map<String,Object>> list=DBHelper.find(sql, id);
        return list;
		
	}
	public List<Map<String, Object>> findbyOrganize(String key,int index,int pageSize){
		String sql="select * from tb_tea_organization LEFT OUTER JOIN tb_teacher ON tb_tea_organization.operson=tb_teacher.tname where tname like ? limit ?,?";
		List<Map<String,Object>> list=DBHelper.find(sql,key,index,pageSize);
        return list;
		
	}
	public List<Map<String, Object>> findbyOrganize_oid(int oid){
		String sql="select * from tb_tea_organization LEFT OUTER JOIN tb_teacher ON tb_tea_organization.operson=tb_teacher.tname where oid=?";
		List<Map<String,Object>> list=DBHelper.find(sql,oid);
        return list;
		
	}
	
	public List<Map<String, Object>> findCount(String key) {
		
		String	sql="select count(id) from tb_teacher where tname like ?";
		
		return DBHelper.find(sql,key);
	}
}
