package com.zy.user.dao;

import java.util.List;
import java.util.Map;

import com.zy.user.domain.Organize;
import com.zy.user.util.DBHelper;

public class OrganizationDao {

	public List<Map<String, Object>> findCount_all() {
		String	sql="select count(id) from tb_tea_organization";
		return DBHelper.find(sql);
	}

	public List<Map<String, Object>> findAll(int index, int pageSize) {
		String sql="select *  from tb_tea_organization limit ?,?";
		return 	DBHelper.find(sql,index,pageSize);
	}

	public void addOrganization(Organize org){
		String sql="insert into tb_tea_organization(organizationname,oid,operson,otel,oaddress,addtime) values(?,?,?,?,?,?)";
		Object params[]={
				org.getOrganizationname(),
				org.getOid(),
				org.getOperson(),org.getOtel(),org.getOaddress(),
				org.getAddtime()
		};
		DBHelper.insert(sql, params);
	}

	public List<Map<String, Object>> findbyId_organization(int id) {
		String sql="select * from tb_tea_organization where id=?";
		List<Map<String,Object>> list=DBHelper.find(sql, id);
        return list;
	}
	public List<Map<String, Object>> findbyId(String sname){
		String sql="select * from tb_student like sname=?";
		List<Map<String,Object>> list=DBHelper.find(sql, sname);
        return list;
		
	}
	public void update_organization(Organize anuser) {
		String sql="update tb_tea_organization set organizationname=?,operson=?,otel=?,oaddress=? where oid=?";
		Object[] params={
			anuser.getOrganizationname(),anuser.getOperson(),anuser.getOtel(),anuser.getOaddress(),anuser.getOid()
		};
		DBHelper.update(sql, params);
	}
	public void deleteorg(int id)
	{
		String sql = "delete from tb_tea_organization where id=?";
		DBHelper.update(sql,id);
	}
}
