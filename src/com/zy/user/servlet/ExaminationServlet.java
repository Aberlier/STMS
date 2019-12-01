package com.zy.user.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zy.user.domain.Exam;
import com.zy.user.domain.ExamByWay;
import com.zy.user.domain.ExaminationBaoKao;
import com.zy.user.domain.Page;
import com.zy.user.domain.Score;
import com.zy.user.domain.Teacher;
import com.zy.user.service.ExaminationService;
import com.zy.user.service.ScoreService;
import com.zy.user.util.DBHelper;

public class ExaminationServlet extends HttpServlet {
	ExaminationService examinationService=new ExaminationService();
	public ExaminationServlet() {
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
		System.out.println(action);
		if (action.equals("add")) {
			add(request, response);
		}else if(action.equals("delete")){
			del(request, response);
		}else if(action.equals("update_baokao")){
			update_baokao(request, response);
		}else if(action.equals("update_baokao_before")){
			updatebefore(request, response);
		}else if(action.equals("findAll")){
            findAll(request,response);
		}else if(action.equals("findAll_ExamByWay")){
			findAll_ExamByWay(request,response);
		}else if(action.equals("addExam")){
			addExam(request,response);
		}else if(action.equals("updateExambefore")){
			updateExambefore(request,response);
		}else if(action.equals("updateExam")){
			updateExam(request,response);
		}else if(action.equals("deleteExam")){
			del_Exam(request,response);
		}else if(action.equals("findAll_exam")){
			findAll_exam(request,response);
		}else if(action.equals("add_exam_before")){
			add_exam_before(request,response);
		}else if(action.equals("delete_ExamByWay")){
			delete_ExamByWay(request,response);
		}else if(action.equals("update_exambyway_before")){
			update_exambyway_before(request,response);
		}else if(action.equals("update_ExamByWay")){
			update_ExamByWay(request,response);
		}
		else if(action.equals("stop_ExamByWay")){
			stop_ExamByWay(request,response);
		}else if(action.equals("start_ExamByWay")){
			start_ExamByWay(request,response);
		}else if(action.equals("add_ExamByWay")){
			add_ExamByWay(request,response);
		}else if(action.equals("add_ExamByWay_before")){
			add_ExamByWay_before(request,response);
		}else if(action.equals("admin_addaward_before")){
			admin_addaward_before(request,response);
		}else if(action.equals("admin_addaward_before2")){
			admin_addaward_before2(request,response);
		}
		else if(action.equals("addAward")){
			addaward(request,response);
		}
		else if(action.equals("addAward2")){
			addaward2(request,response);
		}
		else if(action.equals("addbaokao_before")){
			addbaokao_before(request,response);
		}else if(action.equals("admin_deleteScore")){
			admin_deleteScore(request,response);
		}
		
	}


	private void admin_deleteScore(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		String id1 = request.getParameter("sid");
		int sid=Integer.parseInt(id1);
		examinationService.admin_deleteScore(sid);
		
		String eid1= request.getParameter("eid");
		int eid=Integer.parseInt(eid1);
		String headmaster = request.getParameter("headmaster");
		ScoreService scoreService=new ScoreService();
		//区域排名
		List<Score> listAllR = scoreService.findRegionalranking(eid,headmaster);
		if(listAllR==null||listAllR.equals("")){
			String msg = "<script>window.alert('该考试批次已不存在相关学生成绩！');</script>";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("ScoreServlet?action=adm_findAllScore").forward(request, response);	
		}else{
			Collections.sort(listAllR);
	        for (int i = 0; i <listAllR.size(); i++) {
	        	listAllR.get(i).setRegionalranking(i+1+"");
	            scoreService.updateRegionalranking(listAllR.get(i));
	        }
	    
		}
		
		//总排名 
		
        List<Score> listAll = scoreService.findProvincialranking(eid);
        if(listAll==null||listAll.equals("")){
			String msg = "<script>window.alert('该考试批次已不存在相关学生成绩！');</script>";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("ScoreServlet?action=adm_findAllScore").forward(request, response);	
		}else{
        System.out.println("listAll--------"+listAll);
        Collections.sort(listAll);
        for (int i = 0; i <listAll.size(); i++) {
            listAll.get(i).setProvincialranking(i+1+"");
            scoreService.updateProvincialranking(listAll.get(i));
        }
	}
        String msg = "<script>window.alert('删除成绩成功！');</script>";
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("ScoreServlet?action=adm_findAllScore").forward(request, response);	
	}


	private void update_ExamByWay(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String id1=request.getParameter("id");
		
		int id=Integer.parseInt(id1);
		String examname=request.getParameter("examname");
		String examplace=request.getParameter("examplace");
		String busline=request.getParameter("busline");
		ExamByWay ebw=new ExamByWay();
		ebw.setExamname(examname);
		ebw.setBid(id);
		ebw.setExamplace(examplace);
		ebw.setBusline(busline);
		examinationService.update_ExamByWay(ebw);
		findAll_ExamByWay(request,response);
		
	}


	private void addbaokao_before(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String sname=request.getParameter("sname");
		List<Map<String, Object>> list=examinationService.findGrade();
		List<Map<String, Object>> list2=examinationService.findOrganization();
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		request.setAttribute("sname", sname);
		request.getRequestDispatcher("student/add_baokao.jsp").forward(request, response);
	}


	private void addaward(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String award=request.getParameter("award");
		String sid1=request.getParameter("sid");
		int sid=Integer.parseInt(sid1);
		Score score=new Score();
		score.setAward(award);
		score.setSid(sid);
		examinationService.addAward(score);
		request.getRequestDispatcher("ScoreServlet?action=admin_findAllScore").forward(request, response);
	}
	private void addaward2(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String award=request.getParameter("award");
		String sid1=request.getParameter("sid");
		int sid=Integer.parseInt(sid1);
		Score score=new Score();
		score.setAward(award);
		score.setSid(sid);
		examinationService.addAward2(score);
		request.getRequestDispatcher("ScoreServlet?action=admin_findAllScore2").forward(request, response);
	}


	private void admin_addaward_before(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String sid=request.getParameter("sid");
		List<Map<String, Object>> list=examinationService.findAward();
		request.setAttribute("list", list);
		request.setAttribute("sid", sid);
		request.getRequestDispatcher("admin/add_award.jsp").forward(request, response);
	}
	private void admin_addaward_before2(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String sid=request.getParameter("sid");
		List<Map<String, Object>> list=examinationService.findAward();
		request.setAttribute("list", list);
		request.setAttribute("sid", sid);
		request.getRequestDispatcher("admin/add_award2.jsp").forward(request, response);
	}


	private void add_ExamByWay_before(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String addpeople=request.getParameter("addpeople");
		List<Map<String, Object>> list=examinationService.findExamOfExamByWay();
		request.setAttribute("list", list);
		List<Map<String, Object>> list2=examinationService.findOrganizationOfExamByWay();
		request.setAttribute("list2", list2);
		request.setAttribute("addpeople", addpeople);
		request.getRequestDispatcher("admin/add_examByWay.jsp").forward(request, response);
	}


	private void add_ExamByWay(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String addpeople=request.getParameter("addpeople");
		String oname=request.getParameter("oname");
		String examname=request.getParameter("examname");
		String examplace=request.getParameter("examplace");
		String busline=request.getParameter("busline");
		String sign=request.getParameter("sign");
		Date date = new Date(new java.util.Date().getTime());//获取当前日期时间
		System.out.println(date);//打印当前日期时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String now = format.format(date);//以格式处理date
		ExamByWay ebw=new ExamByWay();
		ebw.setAddpeople(addpeople);
		ebw.setOname(oname);
		ebw.setExamname(examname);
		ebw.setExamplace(examplace);
		ebw.setBusline(busline);
		ebw.setAddExamByWayTime(now);
		ebw.setSign(sign);
		examinationService.addExamByWay(ebw);
		findAll_ExamByWay(request, response);
	}


	private void update_exambyway_before(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String eid1=request.getParameter("bid");
		System.out.println("eid1-------"+eid1);
		int bid=Integer.parseInt(eid1);
		List<Map<String, Object>> list=examinationService.findbyId_ExamByWay(bid);
		HttpSession session=request.getSession();
		session.setAttribute("list",list);//session.setAttribute(String name,Object value);	名  对象
		session.setAttribute("bid",bid);
		response.sendRedirect(request.getContextPath()+"/admin/update_ExamByWay.jsp");//项目路径
		
	}
	/*
	 * 管理员不通过
	 */
	private void stop_ExamByWay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String id1=request.getParameter("bid");
			int id=Integer.parseInt(id1);
			String stop="0";
			ExamByWay anuser=new ExamByWay();
			anuser.setBid(id);
			anuser.setSign(stop);
			System.out.println(anuser);
			examinationService.update_ExamByWaySign(anuser);
			findAll_ExamByWay(request, response);	
		
	}
	
	/*
	 * 管理员通过
	 */
	private void start_ExamByWay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id1=request.getParameter("bid");
		int id=Integer.parseInt(id1);
		String stop="1";
		ExamByWay anuser=new ExamByWay();
		anuser.setBid(id);
		anuser.setSign(stop);
		System.out.println(anuser);
		examinationService.update_ExamByWaySign(anuser);
		findAll_ExamByWay(request, response);	
	}


	private void delete_ExamByWay(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String id1 = request.getParameter("bid");
		int id=Integer.parseInt(id1);
		System.out.println("id--------"+id);
		//2.调用Service进行删除
		examinationService.delete_ExamByWay(id);
		//3.请求转发到学生列表，直接调用findAll方法
		findAll_ExamByWay(request, response);	
	}


	private void findAll_ExamByWay(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
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
		int totalCount=Integer.parseInt(examinationService.findCount_exambyway().get(0).get("count(bid)").toString());
		System.out.println("totalCount-----------"+totalCount);
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		 List<Map<String,Object>>list=examinationService.findAll_exambyway(index,pageSize);
		 System.out.println("examinationlist--------"+list);
		request.setAttribute("list", list);
		//3.将请求转发到students_list.jsp页面
		request.getRequestDispatcher("/admin/Exambyway_list.jsp").forward(request, response);//跳转到success.jsp页面	
	}


	private void add_exam_before(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String adminname=request.getParameter("adminname");
		request.setAttribute("adminname", adminname);
		request.getRequestDispatcher("admin/add_exam.jsp").forward(request, response);
	}


	private void update_baokao(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String id1=request.getParameter("id");
		int id=Integer.parseInt(id1);
		String myclass=request.getParameter("myclass");
		String school=request.getParameter("school");
		String place=request.getParameter("place");
		String fudaoclass=request.getParameter("fudaoclass");
		String fudaoteacher=request.getParameter("fudaoteacher");
		String parentsname=request.getParameter("parentsname");
		String parentstel=request.getParameter("parentstel");
		String intentionalschool=request.getParameter("intentionalschool1");
		String intentionalschool2=request.getParameter("intentionalschool");
		ExaminationBaoKao baokao=new ExaminationBaoKao();
		baokao.setId(id);
		baokao.setMyclass(myclass);
		baokao.setSchool(school);
		baokao.setPlace(place);
		baokao.setFudaoclass(fudaoclass);
		baokao.setFudaoteacher(fudaoteacher);
		baokao.setParentsname(parentsname);
		baokao.setParentstel(parentstel);
		baokao.setIntentionalschool(intentionalschool);
		baokao.setSchool2(intentionalschool2);
		examinationService.update(baokao);
		findAll(request, response);
		
	}

	private void addExam(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String adminname=request.getParameter("adminname");
		System.out.println("adminname-----------"+adminname);
		String examclass=request.getParameter("examclass");
		String ename=request.getParameter("ename");
		String examtime=request.getParameter("examtime");
		String signuptime=request.getParameter("signuptime");
		String signdowntime=request.getParameter("signdowntime");
		
		Date date = new Date(new java.util.Date().getTime());//获取当前日期时间
		System.out.println(date);//打印当前日期时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String now = format.format(date);//以格式处理date
		Exam exam=new Exam();
		exam.setEname(ename);
		exam.setExamclass(examclass);
		exam.setExamtime(examtime);
		exam.setSignuptime(signuptime);
		exam.setSigndowntime(signdowntime);
		exam.setAddexamtime(now);
		exam.setAdminname(adminname);

		examinationService.addExam(exam);
		request.setAttribute("adminname", adminname);
		findAll_exam(request, response);
		}


	private void findAll_exam(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		String adminname=request.getParameter("adminname");
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
		int totalCount=Integer.parseInt(examinationService.findCount_exam().get(0).get("count(eid)").toString());
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		 List<Map<String,Object>>list=examinationService.findAll_exam(index,pageSize);
		request.setAttribute("list", list);
		request.setAttribute("adminname", adminname);
		request.getRequestDispatcher("/admin/examlist.jsp").forward(request, response);//跳转到success.jsp页面
	}


	private void add(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String sname=request.getParameter("sname");
		String myclass=request.getParameter("myclass");//获取表单传过来的sno
		String school=request.getParameter("school");
		String place=request.getParameter("place");
		String school2=request.getParameter("intentionalschool2");
		String fudaoclass=request.getParameter("fudaoclass");
		String fudaoteacher=request.getParameter("fudaoteacher");
		String parentsname=request.getParameter("parentsname");
		String parentstel=request.getParameter("parentstel");
		String intentionalschool=request.getParameter("intentionalschool1");
		String teasingle=request.getParameter("teasingle");
		String adminsingle=request.getParameter("adminsingle");
		Date date = new Date(new java.util.Date().getTime());//获取当前日期时间
		System.out.println(date);//打印当前日期时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String now = format.format(date);//以格式处理date
		//2.将表单数据封装到student对象中
		ExaminationBaoKao eb=new ExaminationBaoKao();
		eb.setSname(sname);
		eb.setMyclass(myclass);
		eb.setSchool(school);
		eb.setPlace(place);
		eb.setSchool2(school2);
		eb.setFudaoclass(fudaoclass);
		eb.setFudaoteacher(fudaoteacher);
		eb.setParentsname(parentsname);
		eb.setParentstel(parentstel);
		eb.setIntentionalschool(intentionalschool);
		eb.setTeasingle(teasingle);
		eb.setAdminsingle(adminsingle);
		eb.setBaokaotime(now);
		//3.调用Service的updateUser方法，修改新闻
		int error=examinationService.add(eb);
		if(error>0){
			request.setAttribute("msg","<script>alert('操作成功');</script>");
			findAll(request, response);
		}else{
			request.setAttribute("msg","<script>alert('操作失败');</script>");
			request.getRequestDispatcher("student/add_baokao.jsp").forward(request, response);
		}
		
	}


	private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id1 = request.getParameter("id");
		int id=Integer.parseInt(id1);
		System.out.println("id--------"+id);
		//2.调用Service进行删除
		examinationService.delete(id);
		//3.请求转发到学生列表，直接调用findAll方法
		findAll(request, response);	
	}
	
	private void del_Exam(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eid1 = request.getParameter("eid");
		int eid=Integer.parseInt(eid1);
		System.out.println("eid--------"+eid);
		//2.调用Service进行删除
		examinationService.delete_Exam(eid);
		//3.请求转发到学生列表，直接调用findAll方法
		findAll_exam(request, response);	
	}


	private void updateExam(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eid1=request.getParameter("eid");
		int eid=Integer.parseInt(eid1);
		String ename=request.getParameter("ename");
		String examtime=request.getParameter("examtime");
		String signuptime=request.getParameter("signuptime");
		String signdowntime=request.getParameter("signdowntime");
		Exam anuser=new Exam();
		anuser.setEid(eid);
		anuser.setEname(ename);
		anuser.setExamtime(examtime);
		anuser.setSignuptime(signuptime);
		anuser.setSigndowntime(signdowntime);
		examinationService.update_Exam(anuser);
		findAll_exam(request, response);
	}

	private void updateExambefore(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		String eid1=request.getParameter("eid");
		int eid=Integer.parseInt(eid1);
		String adminname=request.getParameter("adminname");
		List<Map<String, Object>> list=examinationService.findbyId_Exam(eid);
		request.setAttribute("list",list);
		request.setAttribute("eid",eid);
		request.setAttribute("adminname", adminname);
		request.getRequestDispatcher("admin/update_Exam.jsp").forward(request, response);
		
	}
	
	private void updatebefore(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		String id1=request.getParameter("id");
		int id=Integer.parseInt(id1);
		List<Map<String, Object>> list=examinationService.findbyId(id);
		List<Map<String, Object>> list2=examinationService.findGrade();
		List<Map<String, Object>> list3=examinationService.findOrganization();
		List<Map<String, Object>> list4=examinationService.findTeacher();
		HttpSession session=request.getSession();
		session.setAttribute("list",list);//session.setAttribute(String name,Object value);	名  对象
		session.setAttribute("list2",list2);
		session.setAttribute("list3",list3);
		session.setAttribute("list4",list4);
		response.sendRedirect(request.getContextPath()+"/student/update_baokao.jsp");//项目路径
		/*request.setAttribute("list", list);
		request.getRequestDispatcher("admin/update_student.jsp").forward(request, response);		*/
		
	}



	private void findAll(HttpServletRequest request,HttpServletResponse response)  throws ServletException, IOException {
		String sname=request.getParameter("sname");
		String key="%%";
		if(sname!=null){
			key="%"+sname+"%";
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
		int totalCount=Integer.parseInt(examinationService.findCount(key).get(0).get("count(id)").toString());
		System.out.println("totalCount-----------"+totalCount);
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		 List<Map<String,Object>>list=examinationService.findAll(key,index,pageSize);
		 System.out.println("examinationlist--------"+list);
		request.setAttribute("list", list);
		//3.将请求转发到students_list.jsp页面
		request.getRequestDispatcher("/student/mybaokao.jsp").forward(request, response);//跳转到success.jsp页面
		
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
