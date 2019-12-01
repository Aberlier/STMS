package com.zy.user.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zy.user.domain.Organize;
import com.zy.user.domain.Page;
import com.zy.user.domain.Teacher;
import com.zy.user.service.TeacherService;
import com.zy.user.util.MD5Util;

public class TeacherServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TeacherService teacherService=new TeacherService();
	public TeacherServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");
		System.out.println("action--------------"+action);
		System.out.println(action);
		if(action.equals("updatetea")){
			updateTeacher(request, response);
		}else if(action.equals("updatetea_o")){
			updateTeacher_o(request, response);
		}
		else if(action.equals("Teacherupdateme")){
			Teacherupdateme(request, response);
		}else if(action.equals("updateme")){
			updatemeTeacher(request, response);
		}
		else if(action.equals("updatebefore")){
			updatebefore(request, response);
		}
		else if(action.equals("updatebefore_o")){
			updatebefore_o(request, response);
		}
		else if(action.equals("findbyId")){
			findbyId(request, response);
		}else if(action.equals("teacherfindbyId")){
			teacherfindbyId(request, response);
		}
		
		
	}
	
	/*
	 * 管理员编辑教师的跳转页面
	 */
	private void updatebefore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		TeacherService teacherService=new TeacherService();
		String id1=request.getParameter("id");
		int id=Integer.parseInt(id1);
		List<Map<String, Object>> list=teacherService.updatetea_findbyId(id);
		HttpSession session=request.getSession();
		session.setAttribute("list",list);//session.setAttribute(String name,Object value);	名  对象
		session.setAttribute("id",id);
		response.sendRedirect(request.getContextPath()+"/admin/update_teacher.jsp");//项目路径
		/*request.setAttribute("list", list);
		request.getRequestDispatcher("admin/update_student.jsp").forward(request, response);		*/
	  }
	private void updatebefore_o(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		TeacherService teacherService=new TeacherService();
		String oid1=request.getParameter("oid");
		int oid=Integer.parseInt(oid1);
		List<Map<String, Object>> list=teacherService.findbyId_oid(oid);
		System.out.println(list);
		HttpSession session=request.getSession();
		session.setAttribute("list",list);//session.setAttribute(String name,Object value);	名  对象
		response.sendRedirect(request.getContextPath()+"/teacher/update_o.jsp");//项目路径
		/*request.setAttribute("list", list);
		request.getRequestDispatcher("admin/update_student.jsp").forward(request, response);		*/
	  }
	
	private void Teacherupdateme(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		 TeacherService teacherService=new TeacherService();
		// 1.获取表单数据
		 			String tname=request.getParameter("tname");
					String depart=request.getParameter("depart");
					String temail=request.getParameter("temail");
					
					//2.将表单数据封装到New对象中
					Teacher anuser=new Teacher();
					anuser.setTname(tname);
					anuser.setDepart(depart);
					anuser.setTemail(temail);
					//3.调用Service的updateUser方法
					teacherService.Teacherupdateme(anuser);
					teacherfindbyId(request, response);
	}

	private void updateTeacher(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			 TeacherService teacherService=new TeacherService();
			// 1.获取表单数据
					
						
						String id1=request.getParameter("id");
						int id=Integer.parseInt(id1);
						System.out.println("id//////////////"+id);
						String tname=request.getParameter("tname");
						String depart=request.getParameter("depart");
						String tsex=request.getParameter("tsex");
						String temail=request.getParameter("temail");
						
						//2.将表单数据封装到New对象中
						Teacher anuser=new Teacher();
						anuser.setId(id);
						anuser.setTname(tname);
						anuser.setTemail(temail);
						anuser.setTsex(tsex);
						anuser.setDepart(depart);
						//3.调用Service的updateUser方法
						teacherService.updateTeacher(anuser);
						System.out.println("anuser//////////////"+anuser);
						request.getRequestDispatcher("AdminServlet?action=findAll_tea").forward(request, response)
;		}
	private void updateTeacher_o(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		 TeacherService teacherService=new TeacherService();
		// 1.获取表单数据
					String oid=request.getParameter("oid");
					String organizationname=request.getParameter("organizationname");
					String otel=request.getParameter("otel");
					String oaddress=request.getParameter("oaddress");
					
					//2.将表单数据封装到New对象中
					Organize anuser=new Organize();
					anuser.setOid(oid);
					anuser.setOrganizationname(organizationname);
					anuser.setOtel(otel);
					anuser.setOaddress(oaddress);
					//3.调用Service的updateUser方法
					teacherService.updateOrganize(anuser);
					request.setAttribute("list", anuser);
					
					teacherfindbyId(request, response);
	}
	private void updatemeTeacher(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		 TeacherService teacherService=new TeacherService();
		// 1.获取表单数据
					String tname=request.getParameter("tname");
					String tpwd=MD5Util.md5Encrypt32Upper(request.getParameter("newpassword"));
					
					//2.将表单数据封装到New对象中
					Teacher anuser=new Teacher();
					anuser.setTname(tname);
					anuser.setTpwd(tpwd);
					//3.调用Service的updateUser方法
					teacherService.updatemeTeacher(anuser);
					request.setAttribute("list", anuser);
					teacherfindbyId(request, response);
					
	}
	
	/**
	 * 增加学生addServlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	
	private void findbyId(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String tname=request.getParameter("tname");
		List<Map<String,Object>> list=teacherService.findbyId(tname);
		request.setAttribute("list", list);
		request.getRequestDispatcher("admin/StudentList.jsp").forward(request, response);

	}
	
	private void teacherfindbyId(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String tname=request.getParameter("tname");
	
		List<Map<String,Object>> list=teacherService.findbyId(tname);
		System.out.println("tealist-----------"+list);
		request.setAttribute("list", list);
		
		
		String key="%%";
		if(tname!=null){
			key="%"+tname+"%";
		}
		//分页
		Integer currPage=null;
		String currPag=request.getParameter("currPage");
		if(currPag==null){
			currPage=1;
		}else{
			currPage=Integer.parseInt(currPag);
		}
		
		int pageSize=50;
		if(currPage==null||currPage==0){
			currPage=1;
		}
		int index=(currPage-1)*pageSize;
		int totalCount=Integer.parseInt(teacherService.findCount(key).get(0).get("count(id)").toString());
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		List<Map<String,Object>> list2=teacherService.findbyOrganize(key,index,pageSize);
		System.out.println("tealist-----------"+list2);
		request.setAttribute("list2", list2);
		
		request.getRequestDispatcher("teacher/welcome.jsp").forward(request, response);

	}
	
	
	
	public void init() throws ServletException {
		
		
	}


}
