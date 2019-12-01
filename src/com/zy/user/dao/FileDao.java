package com.zy.user.dao;

import java.util.List;
import java.util.Map;

import com.zy.user.domain.Paper;
import com.zy.user.util.DBHelper;

public class FileDao {

	public void newupload(Paper afile){
			String sql="insert into tb_files values(null,?,?,?,?,?,?,?,?)";
			Object params[]={
					afile.getFiletitle(),
					afile.getFilenamea(),
					afile.getFiler(),
					afile.getFilepath(),
					afile.getFiletype(),
					new java.sql.Date(afile.getUploaddate().getTime()),
					afile.getValueKey(),
					afile.getFiledetail(),
			};
			Object key=DBHelper.insert(sql, params);
			int id=Integer.parseInt(key.toString());
			afile.setId(id);
	}
	
	public List<Map<String,Object>> findAll(String filetype){
		String sql="select * from tb_files where filetype=?";
		List<Map<String,Object>> list=DBHelper.find(sql, filetype);
	    return list;
	}
	public List<Map<String,Object>> PagefindAll(String key,int index,int pageSize){
		String sql="select * from tb_files where filetype like ? limit ?,?";
		return 	DBHelper.find(sql,key,index,pageSize);
	}
public List<Map<String, Object>> findCount(String key) {
		String	sql="select count(id) from tb_files where filetype like ?";
		return DBHelper.find(sql,key);
	}
	public List<Map<String,Object>> findmyfile(String filer){
		String sql="select * from tb_files where filer=?";
		List<Map<String,Object>> list=DBHelper.find(sql, filer);
	    return list;
	}
	public List<Map<String,Object>> listone(String filetitle){
		String sql="select * from tb_files where filetitle=?";
		List<Map<String,Object>> list=DBHelper.find(sql, filetitle);
        return list;	
	}
	public void delete(int id) {
		String sql = "delete from tb_files where id=?";
		DBHelper.update(sql,id);
	}
}
