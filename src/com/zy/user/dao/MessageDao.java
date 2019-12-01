
package com.zy.user.dao;

import java.util.List;
import java.util.Map;

import com.zy.user.domain.Message;
import com.zy.user.util.DBHelper;


public class MessageDao {
	

	public void insert(Message annew){
			String sql="insert into tb_message values(null,?,?,?,?,?,?,?)";
			Object params[]={
					annew.getTitle(),
					annew.getDetail(),
					annew.getValueKey(),
					annew.getCharacter(),
					annew.getContent(),
					annew.getName(),
					new java.sql.Date(annew.getPublishedDate().getTime()),
			};
			Object key=DBHelper.insert(sql, params);
			int id=Integer.parseInt(key.toString());
			annew.setId(id);
	}
	
	public void insertresponse(Message annew){
			String sql="insert into tb_reply values(null,?,?,?,?)";
			Object params[]={
					annew.getTitle(),
					annew.getRecontent(),
					annew.getReplyname(),
					new java.sql.Date(annew.getRedate().getTime()),
			};
			Object key=DBHelper.insert(sql, params);
			int id=Integer.parseInt(key.toString());
			annew.setId(id);
	}
	
	
	public List<Map<String,Object>> findAll(String key,int index,int pageSize){
		
		
		String sql = "select * from tb_message where title like ? limit ?,? ";
		return 	DBHelper.find(sql,key,index,pageSize);
	}
public List<Map<String,Object>> teacherlistmyreply(String key,int index,int pageSize){
		
		
		String sql = "select * from tb_reply where replyname like ? limit ?,? ";
		return 	DBHelper.find(sql,key,index,pageSize);
	}
public List<Map<String,Object>> findAllresponse(String title){
		String sql="select * from tb_reply where title=?";
		List<Map<String,Object>> list=DBHelper.find(sql, title);
        return list;	
	}
	
public List<Map<String,Object>> listmymessage(String name){
	String sql="select * from tb_message where name=?";
	List<Map<String,Object>> list=DBHelper.find(sql, name);
    return list;	
}
public List<Map<String,Object>> teacherlistmymessage(String name){
	String sql="select * from tb_message where name=?";
	List<Map<String,Object>> list=DBHelper.find(sql, name);
    return list;	
}
public List<Map<String,Object>> listmyreply(String key,int index,int pageSize){
	String sql="select * from tb_reply where replyname like ? limit ?,?";
	List<Map<String,Object>> list=DBHelper.find(sql,key,index,pageSize);
    return list;	
}

public void deletereply(int id)
{
	String sql = "delete from tb_reply where id=?";
	DBHelper.update(sql,id);
}  
public void deletemessage(int id)
{
	String sql = "delete from tb_message where id=?";
	DBHelper.update(sql,id);
}
public List<Map<String, Object>> findCount(String key) {
	
	String	sql="select count(id) from tb_message where title like ?";
	
	return DBHelper.find(sql,key);
}
}
