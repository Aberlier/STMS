package com.zy.user.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.zy.user.domain.Admin;
import com.zy.user.domain.Award;
import com.zy.user.domain.Page;
import com.zy.user.domain.Student;
import com.zy.user.domain.SuperAdmin;
import com.zy.user.domain.Teacher;
import com.zy.user.service.AdminService;
import com.zy.user.service.ExaminationService;
import com.zy.user.service.StudentService;
import com.zy.user.service.loginService;
import com.zy.user.util.MD5Util;

public class AdminServlet extends HttpServlet {
private AdminService adminService=new AdminService();
private loginService loginService=new loginService();
private StudentService studentService=new StudentService();
private ExaminationService examinationService=new ExaminationService();
	public AdminServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");//设置编码格式为utf-8
		String action=request.getParameter("action");//获取action的值
		if("admin_findbyId".equals(action)){
			findbyId(request,response);
		}else if(action.equals("superadmin_findbyId")){
			superadmin_findbyId(request,response);
		}else if("updateme".equals(action)){
			updateme(request,response);
		}else if("findAll_stu".equals(action)){
			findAll_stu(request,response);
		}else if("findAll_tea".equals(action)){
			findAll_tea(request,response);
		}else if("delTeacher".equals(action)){
			delTeacher(request,response);
		}else if(action.equals("stop_tea")){
			stop_tea(request,response);
		}else if(action.equals("start_tea")){
			start_tea(request,response);
		}else if(action.equals("stop_stu")){
            stop_stu(request,response);
		}else if(action.equals("start_stu")){
			start_stu(request,response);
		}else if(action.equals("addstu")){
			addstu(request,response);
		}else if(action.equals("addtea")){
			addtea(request,response);
		}else if(action.equals("addstu_before")){
			addstu_before(request,response);
		}else if(action.equals("addtea_before")){
			addtea_before(request,response);
		}else if(action.equals("deletestu")){
			deletestu(request,response);
		}else if(action.equals("findAll_adm")){
			findAll_adm(request,response);
		}else if(action.equals("start_adm")){
			start_adm(request,response);
		}else if(action.equals("stop_adm")){
			stop_adm(request,response);
		}else if(action.equals("deleteadm")){
			deleteadm(request,response);
		}else if(action.equals("update_admin_before")){
			update_admin_before(request,response);
		}else if(action.equals("update_admin")){
			update_admin(request,response);
		}else if(action.equals("addAdmin")){
			addAdmin(request,response);
		}else if(action.equals("findAll_award")){
			findAll_award(request,response);
		}else if(action.equals("delete_award")){
			delete_award(request,response);
		}else if(action.equals("admin_updateme_pass")){
			//登录
			admin_updateme_pass(request,response);
		}else if(action.equals("addAward")){
			//登录
			addAward(request,response);
		}else if(action.equals("addAward_before")){
			//登录
			addAward_before(request,response);
		}else if(action.equals("superadmin_updateme_pass")){
			//登录
			superadmin_updateme_pass(request,response);
		}else if(action.equals("query")){
			//登录
			query(request,response);
		}else if(action.equals("teaquery")){
			//登录
			teaquery(request,response);
		}
		
	}
	private void teaquery(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String admin_query_org=request.getParameter("admin_query_org");
		String key=null;
		if(admin_query_org!=null){
			key="%"+admin_query_org+"%";
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
		int totalCount=Integer.parseInt(adminService.findCountTea(key).get(0).get("count(id)").toString());
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		List<Map<String,Object>> list=adminService.admin_query_tea_org(key,index,pageSize);
		request.setAttribute("list", list);
		request.setAttribute("admin_query_org", admin_query_org);
		request.getRequestDispatcher("TeaFudaoQueryList.jsp").forward(request, response);
	}

	private void query(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		String admin_query_org=request.getParameter("admin_query_org");
		String key="%%";
		if(admin_query_org!=null){
			key="%"+admin_query_org+"%";
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
		int totalCount=Integer.parseInt(adminService.findCount(key).get(0).get("count(id)").toString());
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		List<Map<String,Object>> list=adminService.admin_query_org(key,index,pageSize);
		request.setAttribute("list", list);
		request.setAttribute("admin_query_org", admin_query_org);
		request.getRequestDispatcher("FudaoQueryList.jsp").forward(request, response);
	}
	private void superadmin_findbyId(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
			String superadminname=request.getParameter("adminname");
			List<Map<String,Object>> list=adminService.superadmin_findbyId(superadminname);
			request.setAttribute("list", list);
			request.getRequestDispatcher("admin/superadmin_welcome.jsp").forward(request, response);//请求转发

	}

	private void addAward_before(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		request.getRequestDispatcher("admin/add_award_number.jsp").forward(request, response);
	}
	private void addAward(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String award=request.getParameter("award");
		Award a=new Award();
		a.setAward(award);
		adminService.addAward(a);
		findAll_award(request, response);
	}

	private void admin_updateme_pass(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// 1.获取表单数据
					String adminname=request.getParameter("adminname");
					String newadminpass=MD5Util.md5Encrypt32Upper(request.getParameter("newadminpass"));
					//2.将表单数据封装到New对象中
					Admin anuser=new Admin();
					anuser.setAdminname(adminname);
					anuser.setAdminpass(newadminpass);
					//3.调用Service的updateUser方法
					studentService.updatemeAdmin(anuser);
					request.setAttribute("msg","<script>alert('修改成功！')</script>");
					//request.getRequestDispatcher("admin/admin_welcome.jsp").forward(request, response);
					findbyId(request, response);
	}
	private void superadmin_updateme_pass(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// 1.获取表单数据
					String superadminname=request.getParameter("adminname");
					String newadminpass=MD5Util.md5Encrypt32Upper(request.getParameter("newadminpass"));
					//2.将表单数据封装到New对象中
					SuperAdmin anuser=new SuperAdmin();
					anuser.setSuperadminname(superadminname);
					anuser.setSuperadminpassword(newadminpass);
					//3.调用Service的updateUser方法
					studentService.update_SuperAdmin(anuser);
					request.setAttribute("msg","<script>alert('修改成功！')</script>");
					//request.getRequestDispatcher("admin/admin_welcome.jsp").forward(request, response);
					superadmin_findbyId(request, response);
	}

	private void delete_award(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String aid= request.getParameter("aid");
		adminService.delete_award(aid);
		//3.请求转发到学生列表，直接调用findAll方法
		findAll_award(request, response);
	}

	private void findAll_award(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
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
				int totalCount=Integer.parseInt(adminService.findCount_award().get(0).get("count(aid)").toString());
				Page page=new Page();
				page.setPageSize(pageSize);
				page.setTotalCount(totalCount);
				page.setCurrPage(currPage);
				request.setAttribute("page", page);
				
				//1.获取学生列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
				request.setAttribute("list", adminService.findAll_award(index,pageSize));
				//3.将请求转发到students_list.jsp页面
				request.getRequestDispatcher("/admin/AwardList.jsp").forward(request, response);//跳转到success.jsp页面
	}

	private void addAdmin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String adminname=request.getParameter("adminname");
		String adminpass1=request.getParameter("adminpassword");
		String adminpass=MD5Util.md5Encrypt32Upper(adminpass1);
		String role=request.getParameter("role");
		String sex=request.getParameter("sex");
		String sign=request.getParameter("sign");
		Date date = new Date(new java.util.Date().getTime());//获取当前日期时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String now = format.format(date);//以格式处理date
		Admin admin=new Admin();
		admin.setAdminname(adminname);
		admin.setAdminpass(adminpass);
		admin.setRole(role);
		admin.setSign(sign);
		admin.setSex(sex);
		admin.setAddtime(now);
		
		
		List<Map<String,Object>> b=loginService.AfindbyId(admin.getAdminname());
		if(b.size()>0){
			request.setAttribute("msg", "<script>alert('该用户已注册，请重新注册！')</script>");
			request.getRequestDispatcher("admin/addAdmin.jsp").forward(request, response);
		}else{
			adminService.addadmin(admin);
			request.setAttribute("msg", "<script>alert('注册成功！')</script>");
			findAll_adm(request, response);
		}
	}

	private void update_admin(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String id1=request.getParameter("id");
		int id=Integer.parseInt(id1);
		String adminname=request.getParameter("adminname");
		String adminpassword=request.getParameter("adminpassword");
		Admin admin=new Admin();
		admin.setAdminname(adminname);
		admin.setAdminpass(adminpassword);
		admin.setId(id);
		adminService.updateAdmin(admin);
		findAll_adm(request, response);
	}

	private void update_admin_before(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String id1=request.getParameter("id");
		int id=Integer.parseInt(id1);
		List<Map<String, Object>> list=adminService.findbyId(id);
		request.setAttribute("list", list);
		request.setAttribute("id", id);
		request.getRequestDispatcher("admin/update_admin.jsp").forward(request, response);
	}

	private void findAll_adm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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
		int totalCount=Integer.parseInt(adminService.findCount_adm().get(0).get("count(id)").toString());
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		
		//1.获取学生列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
		request.setAttribute("list", adminService.findAll_adm(index,pageSize));
		//3.将请求转发到students_list.jsp页面
		request.getRequestDispatcher("/admin/AdminList.jsp").forward(request, response);//跳转到success.jsp页面
	}

	private void addtea_before(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<Map<String,Object>> list=loginService.search_dpart_organize();
		request.setAttribute("list", list);
		List<Map<String,Object>> list2=loginService.search_dpart();
		request.setAttribute("list2", list2);
		request.getRequestDispatcher("admin/add_teacher.jsp").forward(request, response);
	}

	private void addstu_before(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<Map<String,Object>> list=adminService.findAll_tea_teaname();
		List<Map<String,Object>> list2=loginService.search_dpart_organize();
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		request.getRequestDispatcher("admin/add_student.jsp").forward(request, response);
	}
	
	
	private void addstu(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
			String sname=request.getParameter("sname");
			String sex=request.getParameter("sex");
			String spwd1=request.getParameter("spwd");
			String spwd=MD5Util.md5Encrypt32Upper(spwd1);
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
			stu.setSpwd(spwd);
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
			System.out.println(id);
			stu.setId(id);

			List<Map<String,Object>> b=adminService.SfindbyId(stu.getSname());
			if(b.size()>0){
				request.setAttribute("msg", "<script>alert('该用户已注册，请重新注册！')</script>");
				addstu_before(request, response);
			}else{
				try {
				adminService.addstu(stu);
				request.setAttribute("msg", "<script>alert('注册成功！')</script>");
				findAll_stu(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

	}
	
	//管理员添加教师
	private void addtea(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			String tname=request.getParameter("tname");
			String tsex=request.getParameter("tsex");
			int tno=(int)((Math.random()*9+1)*100000);
			String tpwd1=request.getParameter("tpwd");
			String tpwd=MD5Util.md5Encrypt32Upper(tpwd1);
			String temail=request.getParameter("temail");
			String single=request.getParameter("single");
			String role=request.getParameter("role");
			String depart=request.getParameter("depart");
			String organize=request.getParameter("organize");
			Date date = new Date(new java.util.Date().getTime());//获取当前日期时间
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String now = format.format(date);//以格式处理date
			Teacher tea=new Teacher();
			tea.setDepart(depart);
			tea.setOrganize(organize);
			tea.setRegistData(now);
			tea.setRole(role);
			tea.setSingle(single);
			tea.setTemail(temail);
			tea.setTname(tname);
			tea.setTno(tno);
			tea.setTpwd(tpwd);
			tea.setTsex(tsex);
			
			List<Map<String,Object>> b=loginService.TfindbyId(tea.getTname());
			if(b.size()>0){
				request.setAttribute("msg", "<script>alert('该用户已注册，请重新注册！')</script>");
				/*response.sendRedirect("add_teacher.jsp");*/
				addtea_before(request, response);
			}else{
				adminService.addtea(tea);
				request.setAttribute("msg", "<script>alert('注册成功，请联系管理员放权！')</script>");
				findAll_tea(request, response);
			}
		
	}
	
	/*
	 * 管理员的教师管理
	 */
	private void findAll_tea(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
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
		int totalCount=Integer.parseInt(adminService.findCountTea().get(0).get("count(id)").toString());
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		List<Map<String,Object>> list=adminService.findAll_tea(index,pageSize);
		List<Map<String, Object>> list2=examinationService.findOrganization();
		request.setAttribute("list2", list2);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/admin/TeacherList.jsp").forward(request, response);//跳转到success.jsp页面
	}
	//添加教师
	public void addTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String tno1=request.getParameter("tno");//获取表单传过来的sno
		int tno=Integer.parseInt(tno1);
		System.out.println(tno);
		String tname=request.getParameter("tname");
		System.out.println(tname);
		String tsex=request.getParameter("tsex");
		System.out.println(tsex);
		String temail=request.getParameter("temail");
		System.out.println(temail);
		String tpwd1=request.getParameter("tpwd");
		String tpwd=MD5Util.md5Encrypt32Upper(tpwd1);
		System.out.println(tpwd);
		String single=request.getParameter("single");
		System.out.println(single);
		String role=request.getParameter("role");
		Date date = new Date();//获取当前日期时间
		System.out.println(date);//打印当前日期时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String now = format.format(date);//以格式处理date
		
		System.out.println("now-----------"+now);
		String depart=request.getParameter("depart");
		//2.将表单数据封装到student对象中
		Teacher teacher=new Teacher();
		teacher.setTno(tno);
		teacher.setTname(tname);
		teacher.setTsex(tsex);
		teacher.setTemail(temail);
		teacher.setTpwd(tpwd);
		teacher.setSingle(single);
		teacher.setRole(role);
		teacher.setRegistData(now);
		teacher.setDepart(depart);
		//3.调用Service的updateUser方法，修改新闻
		adminService.addTeacher(teacher);
		//转发到newsList.jsp页面
//		request.getRequestDispatcher("TeacherServlet?action=stulist").forward(request, response);
		findAll_tea(request, response);
	}

	
	private void delTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String id = request.getParameter("id");
			adminService.delete_tea(id);
			//3.请求转发到学生列表，直接调用findAll方法
			findAll_tea(request, response);
		}
	//通过管理员姓名查询个人信息
	private void findbyId(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String adminname=request.getParameter("adminname");
		System.out.println("adminname--------"+adminname);
		List<Map<String,Object>> list=adminService.findbyId(adminname);
		request.setAttribute("list", list);
		request.getRequestDispatcher("admin/admin_welcome.jsp").forward(request, response);//请求转发

	}
	private void updateme(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			// 1.获取表单数据
						String adminname=request.getParameter("adminname");
						System.out.println("adminname============"+adminname);
						String adminpass=request.getParameter("adminpass");
						System.out.println("adminpass============"+adminpass);
						//2.将表单数据封装到New对象中
						Admin anuser=new Admin();
						anuser.setAdminname(adminname);
						anuser.setAdminpass(adminpass);
						//3.调用Service的updateUser方法
						adminService.updateme(anuser);
						request.setAttribute("list", anuser);
						findbyId(request, response);			
		}
		/*
		 * 管理员对学生管理
		 */
		private void findAll_stu(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			
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
			int totalCount=Integer.parseInt(adminService.findStuCount().get(0).get("count(id)").toString());
			System.out.println("totalCount-----------"+totalCount);
			Page page=new Page();
			page.setPageSize(pageSize);
			page.setTotalCount(totalCount);
			page.setCurrPage(currPage);
			request.setAttribute("page", page);
			List<Map<String, Object>> list2=examinationService.findOrganization();
			request.setAttribute("list2", list2);
			//1.获取学生列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
			request.setAttribute("list", adminService.findAll_stu(index,pageSize));
			//3.将请求转发到students_list.jsp页面
			request.getRequestDispatcher("/admin/StudentList.jsp").forward(request, response);//跳转到success.jsp页面
		}
		
		/*
		 * 管理员不通过
		 */
		private void stop_adm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String adminname=request.getParameter("adminname");
				String stop="不通过";
				Admin anuser=new Admin();
				anuser.setAdminname(adminname);
				anuser.setSign(stop);
				adminService.updateAdminSign(anuser);
				findAll_adm(request, response);
			
		}
		
		/*
		 * 管理员通过
		 */
		private void start_adm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String adminname=request.getParameter("adminname");
			String stop="通过";
			Admin anuser=new Admin();
			anuser.setAdminname(adminname);
			anuser.setSign(stop);
			adminService.updateAdminSign(anuser);
			findAll_adm(request, response);
		}

		
		/*
		 * 管理员不通过
		 */
		private void stop_tea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String tname=request.getParameter("tname");
				String stop="不通过";
				Teacher anuser=new Teacher();
				anuser.setTname(tname);
				anuser.setSingle(stop);
				System.out.println(anuser);
				adminService.updateTeacherSingle(anuser);
				findAll_tea(request, response);	
			
		}
		
		/*
		 * 管理员通过
		 */
		private void start_tea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String tname=request.getParameter("tname");
			String stop="通过";
			Teacher anuser=new Teacher();
			anuser.setTname(tname);
			anuser.setSingle(stop);
			adminService.updateTeacherSingle(anuser);
			findAll_tea(request, response);
		}

		/*
		 * 管理员不通过
		 */
		private void stop_stu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String sname=request.getParameter("sname");
				System.out.println("sname-------"+sname);
				String stop="不通过";
				System.out.println("stop-------"+stop);
				Student anuser=new Student();
				anuser.setSname(sname);
				anuser.setSingle(stop);
				System.out.println(anuser);
				adminService.updateStudentSingle(anuser);
				findAll_stu(request, response);	
			
		}
		
		/*
		 * 管理员通过
		 */
		private void start_stu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String sname=request.getParameter("sname");
			String stop="通过";
			Student anuser=new Student();
			anuser.setSname(sname);
			anuser.setSingle(stop);
			adminService.updateStudentSingle(anuser);
			findAll_stu(request, response);
		}
		
		private void deletestu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String sname= request.getParameter("sname");
			adminService.deletestu(sname);
			findAll_stu(request, response);	
		}

		private void deleteadm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String adminname = request.getParameter("adminname");
			adminService.deleteadm(adminname);
			findAll_adm(request, response);	
		}
	public void init() throws ServletException {
	}

}
