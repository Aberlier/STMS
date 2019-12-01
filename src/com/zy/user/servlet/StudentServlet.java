package com.zy.user.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zy.user.domain.ExaminationBaoKao;
import com.zy.user.domain.Page;
import com.zy.user.domain.Student;
import com.zy.user.service.AdminService;
import com.zy.user.service.ExaminationService;
import com.zy.user.service.StudentService;
import com.zy.user.service.loginService;
import com.zy.user.util.MD5Util;

public class StudentServlet extends HttpServlet {
private StudentService studentService=new StudentService();
private AdminService adminService=new AdminService();
private loginService loginService=new loginService();
private ExaminationService examinationService=new ExaminationService();
	public StudentServlet() {
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
		response.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");
		System.out.println(action);
		if (action.equals("addstu")) {
			addStudent(request, response);
		}else if(action.equals("del_baokao")){
			del_baokao(request, response);
		}else if(action.equals("updatestu")){
			updateStudent(request, response);
		}else if(action.equals("updatebefore")){
			updatebefore(request, response);
		}else if(action.equals("update_baokao_before")){
			update_baokao_before(request, response);
		}else if(action.equals("admin_findbyId")){
			admin_findbyId(request, response);
		}
		else if(action.equals("findbyId")){
			findbyId(request, response);
		}else if(action.equals("findAll")){
            findAll(request,response);
		}else if(action.equals("findAll_baokao")){
			findAll_baokao(request,response);
		}else if(action.equals("update_baokao")){
			update_baokao(request, response);
		}else if(action.equals("add_baokao"))
		{
			add_baokao(request,response);
		}else if(action.equals("addbaokao_before")){
			addbaokao_before(request,response);
		}else if(action.equals("tea_stop"))
		{
			tea_stop(request,response);
		}else if(action.equals("tea_start"))
		{
			tea_start(request,response);
		}else if(action.equals("admin_findAll_baokao"))
		{
			admin_findAll_baokao(request,response);
		}else if(action.equals("adm_stop_baokao")){
			adm_stop_baokao(request,response);
		}else if(action.equals("adm_start_baokao")){
			adm_start_baokao(request,response);
		}else if(action.equals("findBaoKaobyName")){
			findBaoKaobyName(request,response);
		}else if(action.equals("admin_update_stu")){
			admin_update_stu(request,response);
		}else if(action.equals("admin_update_stu_before")){
			admin_update_stu_before(request,response);
		}
		else if(action.equals("admin_addbaokao_before")){
			admin_addbaokao_before(request,response);
		}else if(action.equals("admin_add_baokao")){
			admin_add_baokao(request,response);
		}else if(action.equals("admin_del_baokao")){
			admin_del_baokao(request,response);
		}else if(action.equals("addstu_before")){
			addstu_before(request,response);
		}else if(action.equals("addstu_before")){
			addstu_before(request,response);
		}else if(action.equals("deletestu")){
			deletestu(request,response);
		}else if(action.equals("admin_findbytea")){
			admin_findbytea(request,response);
		}
		
	}
	
	private void deletestu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sname= request.getParameter("sname");
		String headmaster= request.getParameter("headmaster");
		request.setAttribute("headmaster", headmaster);
		adminService.deletestu(sname);
		findAll(request, response);	
	}
	
	
	private void adm_start_baokao(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		String id1=request.getParameter("id");
		int id=Integer.parseInt(id1);
		String admsingle="已审核";
		ExaminationBaoKao anuser=new ExaminationBaoKao();
		anuser.setId(id);
		anuser.setAdminsingle(admsingle);
		adminService.admin_update_baokao_Single(anuser);
		admin_findAll_baokao(request, response);	
	
	}

	private void adm_stop_baokao(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		String id1=request.getParameter("id");
		int id=Integer.parseInt(id1);
		String admsingle="未审核";
		ExaminationBaoKao anuser=new ExaminationBaoKao();
		anuser.setId(id);
		anuser.setAdminsingle(admsingle);
		adminService.admin_update_baokao_Single(anuser);
		admin_findAll_baokao(request, response);	
	
	}
	
	private void tea_stop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id1=request.getParameter("id");
		int id=Integer.parseInt(id1);
		String teasingle="未提交";
		ExaminationBaoKao anuser=new ExaminationBaoKao();
		anuser.setId(id);
		anuser.setTeasingle(teasingle);
		studentService.tea_stop(anuser);
		findAll_baokao(request, response);	
	
}

/*
 * 管理员通过
 */
private void tea_start(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id1=request.getParameter("id");
	int id=Integer.parseInt(id1);
	String teasingle="已提交";
	ExaminationBaoKao anuser=new ExaminationBaoKao();
	anuser.setId(id);
	anuser.setTeasingle(teasingle);
	studentService.tea_start(anuser);
	findAll_baokao(request, response);
}
	
	private void updatebefore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		StudentService studentService=new StudentService();
		String id1=request.getParameter("id");
		int id=Integer.parseInt(id1);
		List<Map<String, Object>> list=studentService.findbyId2(id);
		System.out.println(list);
		HttpSession session=request.getSession();
		session.setAttribute("list",list);//session.setAttribute(String name,Object value);	名  对象
		response.sendRedirect(request.getContextPath()+"/teacher/update_student.jsp");//项目路径
		/*request.setAttribute("list", list);
		request.getRequestDispatcher("admin/update_student.jsp").forward(request, response);		*/
	  }
	private void admin_update_stu_before(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id1=request.getParameter("id");
		int id=Integer.parseInt(id1);
		List<Map<String, Object>> list=studentService.findbyId2(id);
		System.out.println(list);
		HttpSession session=request.getSession();
		session.setAttribute("list",list);//session.setAttribute(String name,Object value);	名  对象
		response.sendRedirect(request.getContextPath()+"/admin/update_student.jsp");//项目路径
		/*request.setAttribute("list", list);
		request.getRequestDispatcher("admin/update_student.jsp").forward(request, response);		*/
	  }
	
	private void update_baokao_before(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		StudentService studentService=new StudentService();
		String id1=request.getParameter("id");
		int id=Integer.parseInt(id1);
		List<Map<String, Object>> list=studentService.findbyId_baokao(id);
		List<Map<String, Object>> list2=examinationService.findGrade();
		List<Map<String, Object>> list3=examinationService.findOrganization();
		List<Map<String, Object>> list4=examinationService.findTeacher();
		HttpSession session=request.getSession();
		session.setAttribute("list2",list2);
		session.setAttribute("list3",list3);
		session.setAttribute("list4",list4);
		session.setAttribute("list",list);//session.setAttribute(String name,Object value);	名  对象
		response.sendRedirect(request.getContextPath()+"/teacher/update_baokao.jsp");//项目路径
		/*request.setAttribute("list", list);
		request.getRequestDispatcher("admin/update_student.jsp").forward(request, response);		*/
	  }
	
	
	
	private void update_baokao(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		 StudentService studentService=new StudentService();
		// 1.获取表单数据
					String fudaoclass=request.getParameter("fudaoclass");
					String fudaoteacher=request.getParameter("fudaoteacher");
					String parentsname=request.getParameter("parentsname");
					String parentstel=request.getParameter("parentstel");
					String id1=request.getParameter("id");
					int id=Integer.parseInt(id1);
					ExaminationBaoKao anuser=new ExaminationBaoKao();
					anuser.setFudaoclass(fudaoclass);
					anuser.setFudaoteacher(fudaoteacher);
					anuser.setParentsname(parentsname);
					anuser.setParentstel(parentstel);
					anuser.setId(id);
					studentService.update_baokao(anuser);
					request.setAttribute("list", anuser);
					//request.getRequestDispatcher("StudentServlet?action=stulist").forward(request, response);
					findAll_baokao(request, response);
	}
	private void updateStudent(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			 StudentService studentService=new StudentService();
			// 1.获取表单数据
			 			String sex=request.getParameter("sex");
			 			String old1=request.getParameter("old");
			 			int old=Integer.parseInt(old1);
			 			String born=request.getParameter("born");
			 			String place=request.getParameter("place");
			 			String schoolname=request.getParameter("schoolname");
						String fudaoclass=request.getParameter("fudaoclass");
						String fudaoteacher=request.getParameter("fudaoteacher");
						String parentsname=request.getParameter("parentsname");
						String parentstel=request.getParameter("parentstel");
						String sname=request.getParameter("sname");
						Student anuser=new Student();
						anuser.setSex(sex);
						anuser.setOld(old);
						anuser.setBorn(born);
						anuser.setPlace(place);
						anuser.setSchoolname(schoolname);
						anuser.setFudaoclass(fudaoclass);
						anuser.setFudaoteacher(fudaoteacher);
						anuser.setParentsname(parentsname);
						anuser.setParentstel(parentstel);
						anuser.setSname(sname);
						studentService.updateStudent(anuser);
						request.setAttribute("list", anuser);
						//request.getRequestDispatcher("StudentServlet?action=stulist").forward(request, response);
						findAll(request, response);
		}
	
	private void admin_update_stu(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		 StudentService studentService=new StudentService();
		// 1.获取表单数据
		 			String sex=request.getParameter("sex");
		 			String old1=request.getParameter("old");
		 			int old=Integer.parseInt(old1);
		 			String born=request.getParameter("born");
		 			String place=request.getParameter("place");
		 			String schoolname=request.getParameter("schoolname");
					String fudaoclass=request.getParameter("fudaoclass");
					String fudaoteacher=request.getParameter("fudaoteacher");
					String parentsname=request.getParameter("parentsname");
					String parentstel=request.getParameter("parentstel");
					String sname=request.getParameter("sname");
					String headmaster=request.getParameter("headmaster");
					
					Student anuser=new Student();
					anuser.setSex(sex);
					anuser.setOld(old);
					anuser.setBorn(born);
					anuser.setPlace(place);
					anuser.setSchoolname(schoolname);
					anuser.setFudaoclass(fudaoclass);
					anuser.setFudaoteacher(fudaoteacher);
					anuser.setParentsname(parentsname);
					anuser.setParentstel(parentstel);
					anuser.setSname(sname);
					anuser.setHeadmaster(headmaster);
					studentService.admin_update_stu	(anuser);
					findAll_stu(request, response);
	}
	
	private void findAll_stu(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
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
		int totalCount=Integer.parseInt(adminService.findStuCount().get(0).get("count(id)").toString());
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		
		//1.获取学生列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
		request.setAttribute("list", adminService.findAll_stu(index,pageSize));
		//3.将请求转发到students_list.jsp页面
		request.getRequestDispatcher("/admin/StudentList.jsp").forward(request, response);//跳转到success.jsp页面
	}
	
	
	private void del_baokao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String id1= request.getParameter("id");
			System.out.println("id1-----------"+id1);
			int id=Integer.parseInt(id1);
			studentService.delete_baokao(id);
			//request.getRequestDispatcher("ListServlet?action=stulist").forward(request, response);
			findAll_baokao(request, response);
			
		}
	private void admin_del_baokao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String id1= request.getParameter("id");
			System.out.println("id1-----------"+id1);
			int id=Integer.parseInt(id1);
			studentService.delete_baokao(id);
			//request.getRequestDispatcher("ListServlet?action=stulist").forward(request, response);
			admin_findAll_baokao(request, response);
			
		}
	
	/**
	 * 增加学生addServlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addStudent(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

					String sname=request.getParameter("sname");
					String sex=request.getParameter("sex");
					String single=request.getParameter("single");
					String role=request.getParameter("role");
					String old1=request.getParameter("old");
					int old=Integer.parseInt(old1);
					String born=request.getParameter("born");
					String place=request.getParameter("place");
					String schoolname=request.getParameter("schoolname");
					String fudaoclass=request.getParameter("fudaoclass");
					String fudaoteacher=request.getParameter("fudaoteacher");
					String parentsname=request.getParameter("parentsname");
					String parentstel=request.getParameter("parentstel");
					String headmaster=request.getParameter("headmaster");
					Date date = new Date(new java.util.Date().getTime());//获取当前日期时间
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
					String now = format.format(date);//以格式处理date
					Student stu =new Student();
					stu.setSname(sname);
					stu.setSex(sex);
					stu.setSingle(single);
					stu.setRole(role);
					stu.setOld(old);
					stu.setBorn(born);
					stu.setPlace(place);
					stu.setSchoolname(schoolname);
					stu.setFudaoclass(fudaoclass);
					stu.setFudaoteacher(fudaoteacher);
					stu.setParentsname(parentsname);
					stu.setParentstel(parentstel);
					stu.setHeadmaster(headmaster);
					stu.setRigestdata(now);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
					String dateString = sdf.format(new java.util.Date());
					Integer id = Integer.valueOf(dateString.substring(dateString.length() - 11));
					stu.setId(id);

					List<Map<String,Object>> b=adminService.SfindbyId(stu.getSname());
					if(b.size()>0){
						request.setAttribute("msg", "<script>alert('该用户已注册，请重新注册！')</script>");
						/*response.sendRedirect("add_student.jsp");		*/
						addstu_before(request, response);
					}else{
						
						try {
							adminService.addstu(stu);
						request.setAttribute("headmaster",headmaster);
						request.setAttribute("headmaster",stu.getHeadmaster());
						request.setAttribute("msg", "<script>alert('注册成功，请联系管理员放权！')</script>");
						findAll(request, response);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	}
	//查询单个学生信息
	private void findbyId(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String sname=request.getParameter("sname");
		String headmaster=request.getParameter("headmaster");
		
		String key="%%";
		String key2="%%";
		if(headmaster!=null){
			key="%"+headmaster+"%";
		}if(sname!=null){
			key2="%"+sname+"%";
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
		int totalCount=Integer.parseInt(studentService.findCount(key2,key).get(0).get("count(id)").toString());
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		List<Map<String,Object>> list=studentService.findbyId(key2,key,index,pageSize);
		
		if(list.size()>0){
			request.setAttribute("list", list);
			request.setAttribute("sname", sname);
			request.setAttribute("headmaster", headmaster);
			request.getRequestDispatcher("StudentList.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "<script>alert('请查看该学生是否为本班学生！')</script>");
			request.setAttribute("headmaster", headmaster);
			findAll(request, response);
		}
		

	}
	private void admin_findbyId(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String sname=request.getParameter("sname");
		String key=null;
		if(sname!=null){
			key="%"+sname+"%";
		}
		
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
		int totalCount=Integer.parseInt(adminService.findStuCount(key).get(0).get("count(id)").toString());
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		List<Map<String,Object>> list=studentService.admin_findbyId(key,index,pageSize);
		request.setAttribute("list", list);
		request.setAttribute("sname", sname);
		request.getRequestDispatcher("AdminStudentList.jsp").forward(request, response);

	}
	private void admin_findbytea(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String tname=request.getParameter("tname");
		String key=null;
		if(tname!=null){
			key="%"+tname+"%";
		}
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
		int totalCount=Integer.parseInt(adminService.TeafindCount(key).get(0).get("count(id)").toString());
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		System.out.println(tname);
		List<Map<String,Object>> list=studentService.findbyIdTea(key,index,pageSize);
		request.setAttribute("list", list);
		request.setAttribute("tname", tname);
		request.getRequestDispatcher("TeacherList.jsp").forward(request, response);

	}
	private void findBaoKaobyName(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String role=request.getParameter("role");
		if(role.equals("教师")){
			String sname=request.getParameter("sname");
			String headmaster=request.getParameter("headmaster");
			String key=null;
			String key2=null;
			if(sname!=null){
				key="%"+sname+"%";
			}
			if(headmaster!=null){
				key2="%"+headmaster+"%";
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
			int totalCount=Integer.parseInt(studentService.admin_findCount_baokao_findbyname(key).get(0).get("count(tb_examinationbaokao.id)").toString());
//			System.out.println(totalCount);
			Page page=new Page();
			page.setPageSize(pageSize);
			page.setTotalCount(totalCount);
			page.setCurrPage(currPage);
			request.setAttribute("page", page);
			//1.获取新闻列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
			request.setAttribute("role", role);
			request.setAttribute("sname", sname);
			request.setAttribute("headmaster", headmaster);
			request.setAttribute("list",studentService.findbyName_baokao(key,key2,index,pageSize));
			request.getRequestDispatcher("teacher/baokaoList_find.jsp").forward(request, response);
		}else if(role.equals("管理员")||role.equals("超级管理员")){
			String sname=request.getParameter("sname");
			String key=null;
			if(sname!=null){
				key="%"+sname+"%";
			}
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
			int totalCount=Integer.parseInt(studentService.findCount_baokao_findbyname(key).get(0).get("count(id)").toString());
			Page page=new Page();
			page.setPageSize(pageSize);
			page.setTotalCount(totalCount);
			page.setCurrPage(currPage);
			request.setAttribute("page", page);
			//1.获取新闻列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
			request.setAttribute("role", role);
			request.setAttribute("sname", sname);
			request.setAttribute("list",studentService.admin_findbyName_baokao(key,index,pageSize));
			request.getRequestDispatcher("admin/baokaoList_find.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "无角色信息,不予显示!");
		}
		

	}
	private void addstu_before(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String headmaster=request.getParameter("headmaster");
		List<Map<String,Object>> list2=loginService.TfindbyId(headmaster);
		request.setAttribute("list2", list2);
		request.setAttribute("headmaster", headmaster);
		request.getRequestDispatcher("teacher/add_student.jsp").forward(request, response);
	}
	/*
	 * 教师的学生管理
	 */
	private void findAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		String headmaster=request.getParameter("headmaster");
		String key="%%";
		if(headmaster!=null){
			key="%"+headmaster+"%";
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
		int totalCount=Integer.parseInt(studentService.findCount(key).get(0).get("count(id)").toString());
		
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		request.setAttribute("headmaster", headmaster);
		//1.获取学生列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
		request.setAttribute("list", studentService.findAll(key,index,pageSize));
		//3.将请求转发到students_list.jsp页面
		request.getRequestDispatcher("/teacher/StudentList.jsp").forward(request, response);//跳转到success.jsp页面
	}
	private void addbaokao_before(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		
		List<Map<String, Object>> list=examinationService.findGrade();
		List<Map<String, Object>> list2=examinationService.findOrganization();
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
	
		request.getRequestDispatcher("teacher/add_baokao.jsp").forward(request, response);
	}
	private void admin_addbaokao_before(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {

		List<Map<String, Object>> list=examinationService.findGrade();
		List<Map<String, Object>> list2=examinationService.findOrganization();
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		request.getRequestDispatcher("admin/add_baokao.jsp").forward(request, response);
	}
	
	private void add_baokao(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String myclass=request.getParameter("myclass");
		String sname=request.getParameter("sname");
		String school=request.getParameter("school");
		String intentionalschool2=request.getParameter("intentionalschool2");
		String place=request.getParameter("place");
		String intentionalschool=request.getParameter("intentionalschool1");
		String fudaoclass=request.getParameter("fudaoclass");
		String fudaoteacher=request.getParameter("fudaoteacher");
		String parentsname=request.getParameter("parentsname");
		String parentstel=request.getParameter("parentstel");
		String teasingle=request.getParameter("teasingle");
		String adminsingle=request.getParameter("adminsingle");
		Date date = new Date(new java.util.Date().getTime());//获取当前日期时间
		System.out.println(date);//打印当前日期时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String now = format.format(date);//以格式处理date
		//2.将表单数据封装到student对象中
		ExaminationBaoKao student=new ExaminationBaoKao();
		student.setMyclass(myclass);
		student.setSname(sname);
		student.setSchool(school);
		student.setSchool2(intentionalschool2);
		student.setPlace(place);
		student.setIntentionalschool(intentionalschool);
		student.setFudaoclass(fudaoclass);
		student.setFudaoteacher(fudaoteacher);
		student.setParentsname(parentsname);
		student.setParentstel(parentstel);
		student.setTeasingle(teasingle);
		student.setAdminsingle(adminsingle);
		student.setBaokaotime(now);
	
		studentService.addbaokao(student);
		//转发到newsList.jsp页面
		findAll_baokao(request, response);
		
	}
	private void admin_add_baokao(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String myclass=request.getParameter("myclass");
		System.out.println("myclass--------"+myclass);
		String sname=request.getParameter("sname");
		String school=request.getParameter("school");
		String intentionalschool2=request.getParameter("intentionalschool2");

		String place=request.getParameter("place");
		String intentionalschool=request.getParameter("intentionalschool1");
		String fudaoclass=request.getParameter("fudaoclass");
		String fudaoteacher=request.getParameter("fudaoteacher");
		String parentsname=request.getParameter("parentsname");
		String parentstel=request.getParameter("parentstel");
		String teasingle=request.getParameter("teasingle");
		String adminsingle=request.getParameter("adminsingle");
		Date date = new Date(new java.util.Date().getTime());//获取当前日期时间
		System.out.println(date);//打印当前日期时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String now = format.format(date);//以格式处理date

		//2.将表单数据封装到student对象中
		ExaminationBaoKao student=new ExaminationBaoKao();
		student.setMyclass(myclass);
		student.setSname(sname);
		student.setSchool(school);
		student.setSchool2(intentionalschool2);
		student.setPlace(place);
		student.setIntentionalschool(intentionalschool);
		student.setFudaoclass(fudaoclass);
		student.setFudaoteacher(fudaoteacher);
		student.setParentsname(parentsname);
		student.setParentstel(parentstel);
		student.setTeasingle(teasingle);
		student.setAdminsingle(adminsingle);
		student.setBaokaotime(now);
		studentService.admin_addbaokao(student);
		//转发到newsList.jsp页面
		admin_findAll_baokao(request, response);
		
	}
	
	/*
	 * 教师对报考管理
	 */
	private void findAll_baokao(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String headmaster=request.getParameter("headmaster");
		String role=request.getParameter("role");
		String key="%%";
		if(headmaster!=null){
			key="%"+headmaster+"%";
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
		int totalCount=Integer.parseInt(studentService.findCount_baokao(key).get(0).get("count(tb_examinationbaokao.id)").toString());
	
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		request.setAttribute("role", role);
		request.setAttribute("headmaster", headmaster);
		//1.获取新闻列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
		request.setAttribute("list",studentService.findAll_baokao(headmaster,index,pageSize));
		//3.将请求转发到students_list.jsp页面
		request.getRequestDispatcher("/teacher/baokaoList.jsp").forward(request, response);//跳转到success.jsp页面
	}
	
private void admin_findAll_baokao(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String adminname=request.getParameter("adminname");
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
		int totalCount=Integer.parseInt(studentService.admin_findCount_baokao().get(0).get("count(id)").toString());
//		System.out.println(totalCount);
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		request.setAttribute("adminname", adminname);
		//1.获取新闻列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
		request.setAttribute("list",studentService.admin_findAll_baokao(index,pageSize));
		//3.将请求转发到students_list.jsp页面
		request.getRequestDispatcher("/admin/baokaoList.jsp").forward(request, response);//跳转到success.jsp页面
	}

/*private void Studentupdateme(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
					
					String sname=request.getParameter("sname");
					String old1=request.getParameter("old");
					int old=Integer.parseInt(old1);
					String schoolname=request.getParameter("schoolname");
					String fudaoclass=request.getParameter("fudaoclass");
					String place=request.getParameter("place");
					String fudaoteacher=request.getParameter("fudaoteacher");
					String parentsname=request.getParameter("parentsname");
					String parentstel=request.getParameter("parentstel");
					//2.将表单数据封装到New对象中
					Student anuser=new Student();
					anuser.setSname(sname);
					anuser.setOld(old);
					anuser.setSchoolname(schoolname);
					anuser.setFudaoclass(fudaoclass);
					anuser.setFudaoteacher(fudaoteacher);
					anuser.setPlace(place);
					anuser.setParentsname(parentsname);
					anuser.setParentstel(parentstel);
					System.out.println("anuser--------"+anuser);
					//3.调用Service的updateUser方法
					studentService.studentupdateme(anuser);
					request.setAttribute("list", anuser);
					studentfindbyId(request, response);
	}*/
/*private void updatemeStudent(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	// 1.获取表单数据
				String sno=request.getParameter("sno");
				System.out.println("sno============"+sno);
				String spwd=request.getParameter("newpassword");
				System.out.println("tpwd============"+spwd);
				//2.将表单数据封装到New对象中
				Student anuser=new Student();
			
				anuser.setSpwd(spwd);
				//3.调用Service的updateUser方法
				studentService.updatemeStudent(anuser);
				request.setAttribute("list", anuser);
				studentfindbyId(request, response);
				
}*/
/*private void studentfindbyId(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
	String sname=request.getParameter("sname");
	System.out.println("--------------sname"+sname);
	List<Map<String,Object>> list=studentService.findbyId(sname);
	System.out.println("--------------Student_list"+list);
	request.setAttribute("list", list);
	
	request.getRequestDispatcher("student/welcome.jsp").forward(request, response);

}*/

	public void init() throws ServletException {
		
		
	}

}
