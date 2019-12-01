package com.zy.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.zy.user.domain.Admin;
import com.zy.user.domain.Student;
import com.zy.user.domain.Teacher;
import com.zy.user.domain.User;
import com.zy.user.util.DBHelper;

	public class loginDao {
		public static Connection con = null;
		public static PreparedStatement ps = null;
		public static ResultSet rs = null;
		public static int totlogin=0;
		public int SuperAdmincheckLogin(String superadminname, String superadminpassword,int totlogin,String role) {
			try {
				con = DBHelper.getConnection();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			String sql = "select * from tb_superadmin where superadminname = ? and superadminpassword = ? and role=?";
			try {
					ps = con.prepareStatement(sql);
					ps.setString(1, superadminname);
					ps.setString(2, superadminpassword);
					ps.setString(3,role);
				
					rs = ps.executeQuery();
					while (rs.next()) {
						
						String name = rs.getString("superadminname");
						if (name.equals(superadminname)) {
							totlogin = rs.getInt("totlogin");
							totlogin++;
							User user=new User();
							user.setTotlogin(totlogin);
							sql = "update tb_superadmin set totlogin=? where superadminname=?";
							ps = con.prepareStatement(sql);
							ps.setInt(1, totlogin);
							ps.setString(2, superadminname);
							ps.executeUpdate();
							return 1;
						}else{
							return 2;
						}
					}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					rs = null;
				}
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					ps = null;
				}
			}
			return 0;
	}
public int checkLogin(String adminname, String adminpass,int totlogin,String role) {//检查登录，这里传入的两个参数分别是从jsp传过来的账号和密码
			try {
				con = DBHelper.getConnection();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			String sql = "select * from tb_admin where adminname = ? and adminpass= ? and role=?";//查询语句，先把loginname设置为？，后面在赋值
			try {
					ps = con.prepareStatement(sql);
					ps.setString(1,adminname);
					ps.setString(2,adminpass);
					ps.setString(3,role);
					rs = ps.executeQuery();
					while (rs.next()) {
						if("不通过".equals(rs.getString("sign"))){
							return 3;
						}
						String pwd = rs.getString("adminpass");//找到数据类里面user所对应的passwrod
						String name = rs.getString("adminname");
						if (name.equals(adminname) && pwd.equals(adminpass)) {//把我们从数据库中找出来的loginpass和从jsp中传过来的loginpass比较
							totlogin = rs.getInt("totlogin");
							totlogin++;
							User user=new User();
							user.setTotlogin(totlogin);
							sql = "update tb_admin set totlogin=? where adminname=?";
							ps = con.prepareStatement(sql);
							ps.setInt(1, totlogin);
							ps.setString(2, adminname);
							ps.executeUpdate();
							return 1; 
						}else{
							return 2;
						}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally { 
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					rs = null;
				}
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					ps = null;
				}
			}
			return 0;
	}
		
public int ScheckLogin(String sname, String spwd,int totlogin,String role) {//检查登录，这里传入的两个参数分别是从jsp传过来的账号和密码
			
			try {
				con = DBHelper.getConnection();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			String sql = "select * from tb_student where sname = ? and spwd=? and role=?";//查询语句，先把loginname设置为？，后面在赋值
			try {
					ps = con.prepareStatement(sql);
					ps.setString(1, sname);//赋值
					ps.setString(2, spwd);
					ps.setString(3,role);
					rs = ps.executeQuery();//执行查询语句，返回一个ResultSet,这个就是我们数据库里面的user
					while (rs.next()) {
						if("不通过".equals(rs.getString("single"))){
							return 3;
						}
						
						String pwd = rs.getString("spwd");
						String name = rs.getString("sname");
						String role1 = rs.getString("role");
						if (role1.equals(role)||name.equals(sname)||pwd.equals(spwd)) {
							totlogin = rs.getInt("totlogin");
							totlogin++;
							User user=new User();
							user.setTotlogin(totlogin);
							sql = "update tb_student set totlogin=? where sname=?";
							ps = con.prepareStatement(sql);
							ps.setInt(1, totlogin);
							ps.setString(2, sname);
							ps.executeUpdate();
							return 1; 
						}else{
							return 2;
						}
						}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					rs = null;
				}
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					ps = null;
				}
			}
			return 0;
	}
public int TcheckLogin(String tname, String tpwd,int totlogin,String role) {//检查登录，这里传入的两个参数分别是从jsp传过来的账号和密码
	
	try {
		con = DBHelper.getConnection();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	String sql = "select * from tb_teacher where tname = ? and tpwd=? and role=?";//查询语句，先把loginname设置为？，后面在赋值
	try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tname);//赋值
			ps.setString(2, tpwd);
			ps.setString(3,role);
			rs = ps.executeQuery();//执行查询语句，返回一个ResultSet,这个就是我们数据库里面的user
			while (rs.next()) {
				if("不通过".equals(rs.getString("single"))){
					return 3;
				}
				String pwd = rs.getString("tpwd");//找到数据类里面user所对应的passwrod
				String name = rs.getString("tname");
				String role1 = rs.getString("role");
				if (role1.equals(role)||name.equals(tname)||pwd.equals(tpwd)) {//把我们从数据库中找出来的loginpass和从jsp中传过来的loginpass比较
					totlogin = rs.getInt("totlogin");
					totlogin++;
					User user=new User();
					user.setTotlogin(totlogin);
					 //登录次数加一
					sql = "update tb_teacher set totlogin=? where tname=?";
					ps = con.prepareStatement(sql);
					ps.setInt(1, totlogin);
					ps.setString(2, tname);
					ps.executeUpdate();
					return 1;
				}else{
					return 2;
				}
				}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally { 
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			ps = null;
		}
	}
	return 0;
}
		public void registe(Student student){
			String sql="insert into tb_student(id,sname,sex,spwd,single,role,old,born,place,schoolname,fudaoclass,fudaoteacher,parentsname,parentstel,registdata,photo,photopath,headmaster) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			Object params[]={
					student.getId(),
					student.getSname(),
					student.getSex(),
					student.getSpwd(),student.getSingle(),student.getRole(),student.getOld(),
					student.getBorn(),student.getPlace(),student.getSchoolname(),student.getFudaoclass(),student.getFudaoteacher(),
					student.getParentsname(),student.getParentstel(),
					student.getRigestdata(),student.getPhoto(),student.getPhotopath(),student.getHeadmaster()
			};
			DBHelper.insert(sql, params);
	}
		public void tearegiste(Teacher tea){//向数据库注册一个新的用户
			String sql="insert into tb_teacher(tno,tname,tsex,temail,tpwd,single,registData,depart,role,organize) values(?,?,?,?,?,?,?,?,?,?)";
			Object params[]={
					tea.getTno(),
					tea.getTname(),
					tea.getTsex(),tea.getTemail(),
					tea.getTpwd(),tea.getSingle(),tea.getRegistData(),tea.getDepart(),tea.getRole(),
					tea.getOrganize()
					
			};
			DBHelper.insert(sql, params);
	}
		public void updateme(Admin anuser){
		String sql="update tb_admin set adminpass=? where adminname=?";
		Object[] params={
				
				anuser.getAdminpass(),anuser.getAdminname()
		};
		DBHelper.update(sql, params);
	}
		
		public List<Map<String, Object>> SfindbyId(String sname){
			String sql="select * from tb_student where sname=?";
			List<Map<String,Object>> list=DBHelper.find(sql, sname);
	        return list;
			
		}
		public List<Map<String, Object>> TfindbyId(String tname){
			String sql="select * from tb_teacher where tname=?";
			List<Map<String,Object>> list=DBHelper.find(sql, tname);
	        return list;
			
		}
		public List<Map<String, Object>> search_dpart_organize(){
			String sql="select * from tb_tea_organization";
			List<Map<String,Object>> list=DBHelper.find(sql);
	        return list;
			
		}
		public List<Map<String, Object>> search_dpart(){
			String sql="select * from tb_subject";
			List<Map<String,Object>> list=DBHelper.find(sql);
	        return list;
			
		}
		public List<Map<String, Object>> FnidSuperAdminCheckName(String superadminname) {
			String sql="select superadminname from tb_superadmin where superadminname=?";
			List<Map<String,Object>> list=DBHelper.find(sql,superadminname);
			return list;
		}
		public List<Map<String, Object>> AfindbyId(String adminname) {
				String sql="select * from tb_admin where adminname=?";
				List<Map<String,Object>> list=DBHelper.find(sql, adminname);
		        return list;
				
		}
		
}