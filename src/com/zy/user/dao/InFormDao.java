package com.zy.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zy.user.domain.InForm;
import com.zy.user.domain.Message;
import com.zy.user.util.DBHelper;

public class InFormDao {
	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	public List<InForm> findAll(){
		List<InForm> list=new ArrayList<InForm>();
		try {
		con = DBHelper.getConnection();
		String sql="select * from tb_inform";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
		InForm inf=new InForm();
		inf.setId(rs.getInt(1));
		inf.setTitle(rs.getString(2));
		inf.setContent(rs.getString(3));
		inf.setInformdata(rs.getDate(4));
		list.add(inf);
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}finally{
			DBHelper.release(con, ps, null);
		}
		return list;
		}
	
	
	public void delete(int id) {
		String sql = "delete from tb_inform where id=?";
		DBHelper.update(sql,id);
	}
	
	
	public void update(InForm inf){
		String sql="update tb_inform set title=?,content=? where id=?";
		
		Object[] params={
				
				inf.getTitle(),inf.getContent(),
				inf.getId(),
		};
		DBHelper.update(sql, params);
	}
	public List<Map<String, Object>> findbyId(String id) {
			String sql="select * from tb_inform where id=?";
			List<Map<String,Object>> list=DBHelper.find(sql, id);
	        return list;
	}
	public void insert(InForm annew) {
			String sql="insert into tb_inform values(null,?,?,?)";
			Object params[]={
					annew.getTitle(),
					annew.getContent(),
					new java.sql.Date(annew.getInformdata().getTime()),
			};
			Object key=DBHelper.insert(sql, params);
			int id=Integer.parseInt(key.toString());
			annew.setId(id);
	}

}

