package com.zy.user.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
public class DBHelper {
	//这个是添加的jar包里面的一个类。可以在referenced Libraries里面找到

	/*这个是本地数据库中的一个database，名字叫User.localhost表示自己的电脑，

	3306是一个端口，表示访问的是数据库。后面?之后的就代表的是编号格式以及使用ssl

	协议，想了解的可以百度下。

	*/
	private static String driver;
	private static String url;
	private static String name;
	private static String password;
	//当类被加载时，会被执行一次，且只会执行一次
	public static Connection getConnection() throws SQLException{
		try {
			Properties props=new Properties();
			InputStream in=DBHelper.class.getClassLoader().getResourceAsStream("dbUtil.properties");
			props.load(in);
			driver=props.getProperty("driver");
			url=props.getProperty("url");
			name=props.getProperty("name");
			password=props.getProperty("password");
			Class.forName(driver);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return DriverManager.getConnection(url,name,password);
	}
	
	//关闭连接
	public static void release(Connection conn,Statement stmt,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//增加一条记录，用于返回自增的主键
		public static int insert(String sql,Object... params){
			/*
			 * 向数据库插入一条记录
			 */
			Connection conn=null;
			PreparedStatement pre=null;
			ResultSet rs=null;
			int key=-1;
			try {
				//获取数据库连接
				conn= DBHelper.getConnection();
				//访问数据库
				pre=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				//2.1设置sql语句的参数值
				if(params!=null){
					for(int i=0;i<params.length;i++){
						pre.setObject(i+1, params[i]);
					}
				}
				//调用pre的方法来访问数据库
				pre.executeUpdate();
				//获取该条记录的主键
				rs=pre.getGeneratedKeys();
				if(rs.next()){
					key=rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				//3.关闭数据库的连接
				release(conn,pre,rs);
			}
			return key;
		}

		
		
		//修改、删除操作
		
			public static int update(String sql,Object... params){
				//向数据库中写入一条记录
				int flag=-1;
				Connection conn=null;
				PreparedStatement pre=null;
				try {
					conn=DBHelper.getConnection();
					
					//访问数据库
					pre=conn.prepareStatement(sql);
					//设置参数值

					if(params!=null){
						for(int i=0;i<params.length;i++){
							pre.setObject(i+1, params[i]);
						}
					}
					
					//向数据库发送sql语句
					flag=pre.executeUpdate();
				
				} catch (Exception e) {
					throw new RuntimeException(e);
				}finally{
					DBHelper.release(conn, pre, null);
				}
				return flag;
			}
			//查询	
			//读取所有的新闻
			public static List<Map<String,Object>> find(String sql,Object... params){
				/*
				 * 1.建立数数据库的连接
				 * 2.访问数据库（从tb_news表中读取所有的数据）
				 * 3.关闭数据库的连接
				 */
				Connection  conn=null;
				PreparedStatement pre=null;
				ResultSet rs=null;
				List<Map<String,Object>> list=null;
				try {
					//1.建立数数据库的连接
					conn=DBHelper.getConnection();
					
					//创建Statement对象
					pre=conn.prepareStatement(sql);
					//设置参数值
					if(params!=null){
						for(int i=0;i<params.length;i++){
							pre.setObject(i+1, params[i]);
						}
					}
					rs=pre.executeQuery();
					//将rs转换成列表
					list=RSToList(rs);
					
				} catch (Exception e) {
					throw new RuntimeException(e);
				}finally{
					DBHelper.release(conn, pre, rs);
				}
				return list;
			}
			
			public static List<Map<String,Object>> query(String sql,Object... params){
				/*
				 * 1.建立数数据库的连接
				 * 2.访问数据库（从tb_news表中读取所有的数据）
				 * 3.关闭数据库的连接
				 */
				Connection  conn=null;
				PreparedStatement pre=null;
				ResultSet rs=null;
				List<Map<String,Object>> list=null;
				try {
					//1.建立数数据库的连接
					conn=DBHelper.getConnection();
					
					//创建Statement对象
					pre=conn.prepareStatement(sql);
					//设置参数值
					if(params!=null){
						for(int i=0;i<params.length;i++){
							pre.setObject(i+1, "%"+params[i]+"%");
						}
					}
					rs=pre.executeQuery();
					//将rs转换成列表
					list=RSToList(rs);
					
				} catch (Exception e) {
					throw new RuntimeException(e);
				}finally{
					DBHelper.release(conn, pre, rs);
				}
				return list;
			}
			//将rs转换成List保存起来
			private static List<Map<String,Object>> RSToList(ResultSet rs) throws SQLException { 
				List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
				//获取表结构
				ResultSetMetaData rsmd=rs.getMetaData();
				//通过循环每次读出一条记录
				while(rs.next()){
					//map用来存储当前读出的一条记录
					Map<String,Object> map=new HashMap<String,Object>();
					//通过循环将当前记录中的字段和字段值读出
					for(int i=1;i<=rsmd.getColumnCount();i++){
						//读取字段名：rsmd.getColumnName(i),当做key
						//读取字段值：rs.getObject(i),对应的value
						map.put(rsmd.getColumnName(i).toLowerCase(), rs.getObject(i));
					}
					list.add(map);
				}
				return list;
			}
			

}
