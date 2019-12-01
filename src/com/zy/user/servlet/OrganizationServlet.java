package com.zy.user.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zy.user.domain.ExaminationBaoKao;
import com.zy.user.domain.Organize;
import com.zy.user.domain.Page;
import com.zy.user.service.OrganizationService;
import com.zy.user.service.StudentService;

public class OrganizationServlet extends HttpServlet {
	private OrganizationService organizationService=new OrganizationService();
	public OrganizationServlet() {
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
		String action=request.getParameter("action");
		if(action.equals("findAll")){
			findAll(request,response);
		}else if(action.equals("update_organize")){
			update_organize(request,response);
		}else if(action.equals("update_organize_before")){
			update_organize_before(request,response);
		}else if(action.equals("addOrganization")){
			addOrganization(request,response);
		}else if(action.equals("findbyId")){
			findbyId(request,response);
		}else if(action.equals("deleteorg")){
			deleteorg(request,response);
		}
		
	}

	private void deleteorg(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException {
		String id1=request.getParameter("id");
		int id=Integer.parseInt(id1);
		organizationService.deleteorg(id);
		findAll(request, response);
	}
	private void findbyId(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException {
		String oid1=request.getParameter("oid");
		int oid=Integer.parseInt(oid1);
		List<Map<String,Object>> list=organizationService.findbyId_organization(oid);
		request.setAttribute("list", list);
		request.getRequestDispatcher("admin/organization_list.jsp").forward(request, response);
		
	}
	private void update_organize_before(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException {
		String id1=request.getParameter("id");
		System.out.println("id1-----------"+id1);
		int id=Integer.parseInt(id1);
		List<Map<String, Object>> list=organizationService.findbyId_organization(id);
		System.out.println("list-----------"+list);
		request.setAttribute("list", list);
		request.getRequestDispatcher("admin/update_organization.jsp").forward(request, response);				
	}
	private void update_organize(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException {
		String organizationname=request.getParameter("organizationname");
		String oid=request.getParameter("oid");
		String operson=request.getParameter("operson");
		String otel=request.getParameter("otel");
		String oaddress=request.getParameter("oaddress");
		Organize anuser=new Organize();
		anuser.setOrganizationname(organizationname);
		anuser.setOperson(operson);
		anuser.setOtel(otel);
		anuser.setOaddress(oaddress);
		anuser.setOid(oid);
		System.out.println("anuser---------"+anuser);
		organizationService.update_organization(anuser);
		findAll(request, response);
		
	}
	private void findAll(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException {
		/*
		 * 如果想带字段进行标志性分页可采用
		 * String cha=request.getParameter("cha");
		String key="%%";
		if(cha!=null){
			key="%"+cha+"%";
		}*/
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
		int totalCount=Integer.parseInt(organizationService.findCount_all().get(0).get("count(id)").toString());
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		 List<Map<String,Object>> list=organizationService.findAll(index,pageSize);
		//1.获取学生列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
		request.setAttribute("list", list);
		System.out.println("Scorelist------------"+list);
		//3.将请求转发到students_list.jsp页面
		request.getRequestDispatcher("/admin/organization_list.jsp").forward(request, response);//跳转到success.jsp页面
		
	}
	public void addOrganization(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String organizationname=request.getParameter("organizationname");//获取表单传过来的sno
		String oid=request.getParameter("oid");
		String operson=request.getParameter("operson");
		String otel=request.getParameter("otel");
		String oaddress=request.getParameter("oaddress");
		Date date = new Date(new java.util.Date().getTime());//获取当前日期时间
		System.out.println(date);//打印当前日期时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String now = format.format(date);//以格式处理date
		
		System.out.println("now-----------"+now);
		//2.将表单数据封装到student对象中
		Organize org=new Organize();
		org.setOrganizationname(organizationname);
		org.setOid(oid);
		org.setOperson(operson);
		org.setOtel(otel);
		org.setOaddress(oaddress);
		org.setAddtime(now);
		//3.调用Service的updateUser方法，修改新闻
		System.out.println("org------------"+org);
		organizationService.addOrganization(org);
		//转发到newsList.jsp页面
		findAll(request, response);
	}
	
	
	public void init() throws ServletException {
		// Put your code here
	}

}
