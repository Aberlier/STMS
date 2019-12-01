package com.zy.user.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zy.user.service.AdminService;
import com.zy.user.service.StudentService;
import com.zy.user.service.loginService;
import com.zy.user.util.MD5Util;

public class loginServlet extends HttpServlet {
	private loginService loginService=new loginService();
	private StudentService studentService=new StudentService();
	private AdminService adminService =new AdminService();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");//设置编码格式为utf-8
		String action=request.getParameter("action");//获取action的值
		System.out.println(action);
		//根据action的值进行判断，是什么请求
		if("login".equals(action)){
			//登录
			login(request,response);
		}
		else if(action.equals("regist_stu_before")){
			regist_stu_before(request,response);
		}
		
	}
	
	private void regist_stu_before(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<Map<String,Object>> list=adminService.findAll_tea_teaname();
		List<Map<String,Object>> list2=loginService.search_dpart_organize();
		request.setAttribute("list2", list2);
		request.setAttribute("list", list);
		request.getRequestDispatcher("regist.jsp").forward(request, response);
	}

	/**
	 * 登录功能
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String role=request.getParameter("role");
		System.out.println(role);
		String loginname= request.getParameter("loginname");
		String loginpass=request.getParameter("loginpass");
		System.out.println("loginpass---"+loginpass);
		  //校验验证码，先要获取表单，获取图片上的文字  
        String ver = request.getParameter("verifyCode");  
        //真正的验证码保存在session  
        String vcode = (String) request.getSession().getAttribute("vCode");  
		if(ver.equalsIgnoreCase(vcode)==true){
			
        int totlogin=1;
	if(loginname.equals("") || loginpass.equals("") || role.equals("")){
		String failurl=request.getContextPath()+"/login.jsp";
		String msg = "<script>window.confirm('登录失败');window.location.href='"+failurl+"';</script>";
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("msg.jsp").forward(request, response);	
	}
	
	else{
		String superadminokurl=request.getContextPath()+"/admin/SuperAdmin_index.jsp";
		String failurl=request.getContextPath()+"/login.jsp";
		String msg = "";
		if (role.equals("超级管理员")) {      //dao层中判断，如果为true，跳转到欢迎界面
		
				String superadminname= request.getParameter("loginname");
				String superadminpassword=MD5Util.md5Encrypt32Upper(request.getParameter("loginpass"));
				List<Map<String, Object>> flag_before=loginService.FnidSuperAdminCheckName(superadminname);
				if(flag_before.size()>0){
					int flag= loginService.SuperAdmincheckLogin(superadminname, superadminpassword,totlogin,role);
					if(flag==1){
						HttpSession session = request.getSession();
						session.setAttribute("loginname", superadminname);
						session.setAttribute("role", role);
						msg = "<script>alert('登陆成功');window.location.href='"+superadminokurl+"';</script>";
					}else if(flag==0||flag==2){
						msg = "<script>alert('账号或密码错误，请重新登录！');window.location.href='"+failurl+"';</script>";
					}
					
				}else{
					msg = "<script>alert('不存在该用户，请重新登录！');window.location.href='"+failurl+"';</script>";
				}
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("msg.jsp").forward(request, response);	
		
		}
		else if (role.equals("管理员")) {
			String adminokurl=request.getContextPath()+"/admin/Admin_index.jsp";
			try {
				String adminname= request.getParameter("loginname");
				String adminpass=MD5Util.md5Encrypt32Upper(request.getParameter("loginpass"));
				System.out.println("adminpass----------///"+adminpass);
				int index = loginService.checkLogin(adminname, adminpass,totlogin,role);
				
				if (index==1) {
					HttpSession session = request.getSession();
					 session.setAttribute("loginname", adminname);
					 session.setAttribute("role", role);
					 msg = "<script>alert('登陆成功');window.location.href='"+adminokurl+"';</script>";				 
				}else{
					 if(index==0||index==2){
						 msg = "<script>alert('账号或密码错误！');window.location.href='"+failurl+"';</script>";	
					 }else if(index==3){
						 msg = "<script>alert('账号还未通过审核！请及时联系超级管理员!');window.location.href='"+failurl+"';</script>";	
					 }
				}
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("msg.jsp").forward(request, response);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if (role.equals("学生")) {
			String stuokurl=request.getContextPath()+"/student/Student_index.jsp";
			try {
				String sname= request.getParameter("loginname");
				String spwd=MD5Util.md5Encrypt32Upper(request.getParameter("loginpass"));
				int index = loginService.ScheckLogin(sname, spwd,totlogin,role);
				if (index==1) {
					HttpSession session = request.getSession();
					 session.setAttribute("sname", sname);
					 session.setAttribute("role", role);
					 List<Map<String,Object>> list=studentService.findbyphoto(sname);
					 System.out.println("Student_list--------------"+list);
					 request.setAttribute("list", list);
					 session.setAttribute("list", list);
					 msg = "<script>alert('登陆成功');window.location.href='"+stuokurl+"';</script>";
				}else{
					 if(index==0||index==2){
						 msg = "<script>alert('账号或者密码有误，请重新登录！');window.location.href='"+failurl+"';</script>";
					 }else if(index==3){
						 msg = "<script>alert('账号还未通过审核！请及时联系管理员！');window.location.href='"+failurl+"';</script>";
					 }
				}
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("msg.jsp").forward(request, response);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (role.equals("教师")) {
			String teaokurl=request.getContextPath()+"/teacher/Teacher_index.jsp";
			try {
				String tname= request.getParameter("loginname");
				System.out.println(tname);
				String tpwd=MD5Util.md5Encrypt32Upper(request.getParameter("loginpass"));
				System.out.println(tpwd);
				int index = loginService.TcheckLogin(tname,tpwd,totlogin,role);
				if (index==1) {
					HttpSession session = request.getSession();
					 session.setAttribute("tname", tname);
					 session.setAttribute("role", role);
					 msg = "<script>alert('登陆成功');window.location.href='"+teaokurl+"';</script>";
				}else{
					 if(index==0||index==2){
						 msg = "<script>alert('账号或者密码有误，请重新登录！');window.location.href='"+failurl+"';</script>";
					 }else if(index==3){
						 msg = "<script>alert('账号还未通过审核！请及时联系管理员！');window.location.href='"+failurl+"';</script>";
					 }
				}
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("msg.jsp").forward(request, response);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}else{
	String failurl=request.getContextPath()+"/login.jsp";
	 String msg = "<script>alert('请输入正确的验证码');window.location.href='"+failurl+"';</script>";
	 request.setAttribute("msg", msg);
	 request.getRequestDispatcher("msg.jsp").forward(request, response);	
		}
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);//post请求提交
	}

}
