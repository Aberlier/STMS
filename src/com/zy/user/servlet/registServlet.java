package com.zy.user.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.zy.user.domain.ExaminationBaoKao;
import com.zy.user.domain.Student;
import com.zy.user.domain.Teacher;
import com.zy.user.service.loginService;
import com.zy.user.util.MD5Util;

public class registServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	loginService loginService=new loginService();
	public registServlet() {
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
		if(action.equals("sturegist"))
		{
			sturegist(request,response);
		}else if(action.equals("tearegist"))
		{
			tearegist(request,response);
		}else if(action.equals("departAndorganize"))
		{
			departAndorganize(request,response);
		}
		
	}
	
	
	private void departAndorganize(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		List<Map<String,Object>> list1=loginService.search_dpart_organize();
		System.out.println("list1-----------"+list1);
		request.setAttribute("list1", list1);
		List<Map<String,Object>> list2=loginService.search_dpart();
		request.setAttribute("list2", list2);
		request.getRequestDispatcher("/Tearegist.jsp").forward(request, response);
		
	}
	
	private void tearegist(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
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
				/*response.sendRedirect("regist.jsp");*/
				request.getRequestDispatcher("registServlet?action=departAndorganize").forward(request, response);
			}else if(b.size()<=0){
				try {
					loginService.tearegiste(tea);
				request.setAttribute("msg", "<script>alert('注册成功，请联系管理员放权！')</script>");
				request.getRequestDispatcher("login.jsp").forward(request, response); //重新跳转到登录界面
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}

	
	
	private void sturegist(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	
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
			List<Map<String,Object>> b=loginService.SfindbyId(stu.getSname());
			System.out.println("b----------"+b);
			if(b.size()>0){
				request.setAttribute("msg", "<script>alert('该用户已经注册，请联系管理员放权！')</script>");
				/*response.sendRedirect("regist.jsp");*/
				request.getRequestDispatcher("loginServlet?action=regist_stu_before").forward(request, response);
			}else{
				try {
					loginService.registe(stu);
				request.setAttribute("msg", "<script>alert('注册成功，请联系管理员放权！')</script>");
				request.getRequestDispatcher("login.jsp").forward(request, response); //重新跳转到登录界面
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

	}

public void init() throws ServletException {
	}

}
