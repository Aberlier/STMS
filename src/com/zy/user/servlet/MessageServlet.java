package com.zy.user.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zy.user.domain.Message;
import com.zy.user.domain.Page;
import com.zy.user.service.MessageService;

public class MessageServlet extends HttpServlet {
	private MessageService messageService=new MessageService();
	private String  title;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");//获取action的值
		
		//根据action的值进行判断，是什么请求
		if("newmessage".equals(action)){
			newmessage(request,response);
		}else if ("findAll".equals(action)) {
			findAll(request,response);
		}else if ("teacherfindAll".equals(action)) {
			teacherfindAll(request,response);
		}else if ("teachernewmessage".equals(action)) {
			teachernewmessage(request,response);
		}else if ("replay".equals(action)) {
			response(request,response);
		}
		
		else if ("adminfindAll".equals(action)) {
			adminfindAll(request,response);
		}else if ("replay".equals(action)) {
			response(request,response);
		}else if ("studentreplay".equals(action)) {
			studentresponse(request,response);
		}else if ("findAllresponse".equals(action)) {
			title=request.getParameter("title");
			studentfindAllresponse(request,response,title);
		}else if ("teacherfindAllresponse".equals(action)) {
			title=request.getParameter("title");
			teacherfindAllresponse(request,response,title);
		}else if ("studentfindAllresponse".equals(action)) {
			title=request.getParameter("title");
			studentfindAllresponse(request,response,title);
		}
		else if ("adminfindAllresponse".equals(action)) {
			title=request.getParameter("title");
			adminfindAllresponse(request,response,title);
		}
		else if ("newresponse".equals(action)) {
			newresponse(request,response,title);
		}else if("listmymessage".equals(action)){
			listmymessage(request,response);
		}else if("teacherlistmymessage".equals(action)){
			teacherlistmymessage(request,response);
		}else if("listmyreply".equals(action)){
			listmyreply(request,response);
		}else if("teacherlistmyreply".equals(action)){
			teacherlistmyreply(request,response);
		}
		
		else if("deletereply".equals(action)){
			deletereply(request,response);
		}else if("teacherdeletereply".equals(action)){
			teacherdeletereply(request,response);
		}else if("admindeletereply".equals(action)){
			admindeletereply(request,response);
		}
		else if("deletemessage".equals(action)){
			deletemessage(request,response);
		}else if("teacherdeletemessage".equals(action)){
			teacherdeletemessage(request,response);
		}
		else if("teacherlistmymessage".equals(action)){
			teacherlistmymessage(request,response);
		}else if ("teachernewresponse".equals(action)) {
			teachernewresponse(request,response);
		}else if ("studentnewresponse".equals(action)) {
			studentnewresponse(request,response);
		}
	}
	
	private void deletemessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.获取id
		 * 2.调用Service进行删除
		 * 3.获取新闻列表，直接调用findAll方法
		 */
		//1.获取id
		String name=request.getParameter("sname");
		 System.out.println("name---deletemessage--------"+name);
		String id = request.getParameter("id");
		//2.调用Service进行删除
		messageService.deletemessage(Integer.parseInt(id));
		//3.获取新闻列表，直接调用findAll方法
		request.setAttribute("list", messageService.listmymessage(name));
		//3.请求转发给listmymessage.jsp
		request.getRequestDispatcher("student/mymessage.jsp").forward(request, response);
		
	}
	private void teacherdeletemessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.获取id
		 * 2.调用Service进行删除
		 * 3.获取新闻列表，直接调用findAll方法
		 */
		//1.获取id
		String name=request.getParameter("tname");
		 System.out.println("name---deletemessage--------"+name);
		String id = request.getParameter("id");
		//2.调用Service进行删除
		messageService.deletemessage(Integer.parseInt(id));
		//3.获取新闻列表，直接调用findAll方法
		request.setAttribute("list", messageService.listmymessage(name));
		//3.请求转发给listmymessage.jsp
		request.getRequestDispatcher("teacher/mymessage.jsp").forward(request, response);
		
	}

	private void teacherdeletereply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.获取id
		 * 2.调用Service进行删除
		 * 3.获取新闻列表，直接调用findAll方法
		 */
		//1.获取id
		String id = request.getParameter("id");
		//2.调用Service进行删除
		messageService.deletereply(Integer.parseInt(id));
		//3.获取新闻列表，直接调用findAll方法
		teacherlistmyreply(request,response);
		
	}
	private void admindeletereply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.获取id
		 * 2.调用Service进行删除
		 * 3.获取新闻列表，直接调用findAll方法
		 */
		//1.获取id
		String id = request.getParameter("id");
		//2.调用Service进行删除
		messageService.deletereply(Integer.parseInt(id));
		//3.获取新闻列表，直接调用findAll方法
	
		
	}
	private void deletereply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.获取id
		 * 2.调用Service进行删除
		 * 3.获取新闻列表，直接调用findAll方法
		 */
		//1.获取id
		String id = request.getParameter("id");
		//2.调用Service进行删除
		messageService.deletereply(Integer.parseInt(id));
		//3.获取新闻列表，直接调用findAll方法
		listmyreply(request,response);
		
	}
	
	private void teachernewresponse(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//1.获取表单内容
		String title=request.getParameter("title");
		System.out.println("title----------"+title);
		String recontent=request.getParameter("recontent");
		System.out.println("recontent----------"+recontent);
		String replyname=request.getParameter("tname");
		System.out.println("replyname----------"+replyname);
		
		//2.将值封装
		Message annew=new Message();
		annew.setTitle(title);
		annew.setRecontent(recontent);
		annew.setReplyname(replyname);
		annew.setRedate(new Date());
		//3.调用Service层中的newresponse方法将数据插入到数据库中
		messageService.newresponse(annew);
		//4.调用findAllresponse方法将新插入的数据显示在列表中
		teacherfindAllresponse(request, response, title);
	
	}
	private void studentnewresponse(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//1.获取表单内容
		String title=request.getParameter("title");
		System.out.println("title----------"+title);
		String recontent=request.getParameter("recontent");
		System.out.println("recontent----------"+recontent);
		String replyname=request.getParameter("sname");
		System.out.println("replyname----------"+replyname);
		
		//2.将值封装
		Message annew=new Message();
		annew.setTitle(title);
		annew.setRecontent(recontent);
		annew.setReplyname(replyname);
		annew.setRedate(new Date());
		//3.调用Service层中的newresponse方法将数据插入到数据库中
		messageService.newresponse(annew);
		//4.调用findAllresponse方法将新插入的数据显示在列表中
		teacherfindAllresponse(request, response, title);
	
	}
	private void newresponse(HttpServletRequest request,
			HttpServletResponse response,String title) throws ServletException, IOException {
		//1.获取表单内容
		String recontent=request.getParameter("recontent");
		HttpSession session = request.getSession();
		String replyname=(String) session.getAttribute("username");	
		//2.将值封装
		Message annew=new Message();
		annew.setTitle(title);
		annew.setRecontent(recontent);
		annew.setReplyname(replyname);
		annew.setRedate(new Date());
		//3.调用Service层中的newresponse方法将数据插入到数据库中
		messageService.newresponse(annew);
		//4.调用findAllresponse方法将新插入的数据显示在列表中
		studentfindAllresponse(request, response, title);
	
	}


	/*
	 * 学生发布留言
	 */
	private void newmessage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException { 
		    request.setCharacterEncoding("utf-8");
	
			String title=request.getParameter("title");
			String valueKey=request.getParameter("valueKey");
			String detail=request.getParameter("detail");
			String character=request.getParameter("character");
			String content=request.getParameter("content");
			
//			HttpSession session = request.getSession();
//			String name=(String) session.getAttribute("sno");
			String name=request.getParameter("sname");
			System.out.println("name-----------"+name);
			Message annew=new Message();
			annew.setTitle(title);
			annew.setDetail(detail);
			annew.setValueKey(valueKey);
			annew.setCharacter(character);
			annew.setContent(content);
			annew.setName(name);
			annew.setPublishedDate(new Date());
			
	
			messageService.add(annew);
			findAll(request, response);
//			PrintWriter out=response.getWriter();
//			   out.println("<h3>发布问题成功，5秒后返回<a href=\"allmessage.jsp\">所有问题及回复界面</a>!</h3>");
//			   response.setHeader("Refresh", "5;url=allmessage.jsp");
	}
	
	/*
	 * 教师发布留言
	 */
	private void teachernewmessage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException { 
		    request.setCharacterEncoding("utf-8");
	
			String title=request.getParameter("title");
			String valueKey=request.getParameter("valueKey");
			String detail=request.getParameter("detail");
			String character=request.getParameter("character");
			String content=request.getParameter("content");
			
//			HttpSession session = request.getSession();
//			String name=(String) session.getAttribute("sno");
			String name=request.getParameter("tname");
			System.out.println("name-----------"+name);
			Message annew=new Message();
			annew.setTitle(title);
			annew.setDetail(detail);
			annew.setValueKey(valueKey);
			annew.setCharacter(character);
			annew.setContent(content);
			annew.setName(name);
			annew.setPublishedDate(new Date());
			
	
			messageService.add(annew);
			findAll(request, response);
//			PrintWriter out=response.getWriter();
//			   out.println("<h3>发布问题成功，5秒后返回<a href=\"allmessage.jsp\">所有问题及回复界面</a>!</h3>");
//			   response.setHeader("Refresh", "5;url=allmessage.jsp");
	}
	
	/*
	 * 学生留言列表
	 */
	public void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
   
		String cha=request.getParameter("cha");
		String key="%%";
		if(cha!=null){
			key="%"+cha+"%";
		}
		//分页
		Integer currPage=null;
		String currPag=request.getParameter("currPage");
		if(currPag==null){
			currPage=1;
		}else{
			currPage=Integer.parseInt(currPag);
		}
		
		int pageSize=5;
		if(currPage==null||currPage==0){
			currPage=1;
		}
		int index=(currPage-1)*pageSize;
		int totalCount=Integer.parseInt(messageService.findCount(key).get(0).get("count(id)").toString());
//				System.out.println(totalCount);
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		//1.调用Service层中的findALL方法获取所有问题列表
		MessageService messageService=new MessageService();
		List<Map<String,Object>> list=messageService.findAll(key,index,pageSize);
		//2.将获取的问题列表对象list保存到request中
		request.setAttribute("list", list);
		
		//3.请求转发allmessage.jsp
		request.getRequestDispatcher("student/allmessage.jsp").forward(request, response);
	}
	
	
	public void teacherfindAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String cha=request.getParameter("cha");
		String key="%%";
		if(cha!=null){
			key="%"+cha+"%";
		}
		//分页
		Integer currPage=null;
		String currPag=request.getParameter("currPage");
		if(currPag==null){
			currPage=1;
		}else{
			currPage=Integer.parseInt(currPag);
		}
		
		int pageSize=5;
		if(currPage==null||currPage==0){
			currPage=1;
		}
		int index=(currPage-1)*pageSize;
		int totalCount=Integer.parseInt(messageService.findCount(key).get(0).get("count(id)").toString());
//				System.out.println(totalCount);
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		//1.调用Service层中的findALL方法获取所有问题列表
		MessageService messageService=new MessageService();
		List<Map<String,Object>> list=messageService.findAll(key,index,pageSize);
		//2.将获取的问题列表对象list保存到request中
		request.setAttribute("list", list);
		
		//3.请求转发allmessage.jsp
		request.getRequestDispatcher("teacher/allmessage.jsp").forward(request, response);
	}
	
	/*
	 * 管理员的留言列表
	 */
	public void adminfindAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
   
		String cha=request.getParameter("cha");
		String key="%%";
		if(cha!=null){
			key="%"+cha+"%";
		}
		//分页
		Integer currPage=null;
		String currPag=request.getParameter("currPage");
		if(currPag==null){
			currPage=1;
		}else{
			currPage=Integer.parseInt(currPag);
		}
		
		int pageSize=5;
		if(currPage==null||currPage==0){
			currPage=1;
		}
		int index=(currPage-1)*pageSize;
		int totalCount=Integer.parseInt(messageService.findCount(key).get(0).get("count(id)").toString());
//				System.out.println(totalCount);
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		//1.调用Service层中的findALL方法获取所有问题列表
		MessageService messageService=new MessageService();
		List<Map<String,Object>> list=messageService.findAll(key,index,pageSize);
		//2.将获取的问题列表对象list保存到request中
		request.setAttribute("list", list);
		
		//3.请求转发allmessage.jsp
		request.getRequestDispatcher("admin/allmessage.jsp").forward(request, response);
	}
	public void studentfindAllresponse(HttpServletRequest request, HttpServletResponse response,String title)
			throws ServletException, IOException {
      
		//1.调用Service层中的findALL方法获取所有回复列表
		MessageService messageService=new MessageService();
		List<Map<String,Object>> list=messageService.findAllresponse(title);
		//2.将获取的回复列表对象list保存到request中
		request.setAttribute("list", list);
		//3.请求转发allresponse.jsp
		request.getRequestDispatcher("student/allresponse.jsp").forward(request, response);
	}
	public void teacherfindAllresponse(HttpServletRequest request, HttpServletResponse response,String title)
			throws ServletException, IOException {
      
		//1.调用Service层中的findALL方法获取所有回复列表
		MessageService messageService=new MessageService();
		List<Map<String,Object>> list=messageService.findAllresponse(title);
		//2.将获取的回复列表对象list保存到request中
		request.setAttribute("list", list);
		//3.请求转发allresponse.jsp
		request.getRequestDispatcher("teacher/allresponse.jsp").forward(request, response);
	}
	public void adminfindAllresponse(HttpServletRequest request, HttpServletResponse response,String title)
			throws ServletException, IOException {
      
		//1.调用Service层中的findALL方法获取所有回复列表
		MessageService messageService=new MessageService();
		List<Map<String,Object>> list=messageService.findAllresponse(title);
		//2.将获取的回复列表对象list保存到request中
		request.setAttribute("list", list);
		//3.请求转发allresponse.jsp
		request.getRequestDispatcher("admin/allresponse.jsp").forward(request, response);
	}
	
	public void response(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tname=request.getParameter("tname");
		String title=request.getParameter("title");
		System.out.println("title----------"+tname);
		request.setAttribute("tname", tname);
		request.setAttribute("title", title);
		request.getRequestDispatcher("teacher/replay.jsp").forward(request, response);
	}public void studentresponse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sname=request.getParameter("sname");
		String title=request.getParameter("title");
		System.out.println("title----------"+sname);
		request.setAttribute("sname", sname);
		request.setAttribute("title", title);
		request.getRequestDispatcher("student/replay.jsp").forward(request, response);
	}
	
	/*
	 * 学生的我的留言
	 */
	private void listmymessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取用户名
		String name=request.getParameter("sname");
		//2.调用Service层的listmymessage方法将返回的数据放到list中
		request.setAttribute("list", messageService.listmymessage(name));
		//3.请求转发给mymessage.jsp
		request.getRequestDispatcher("student/mymessage.jsp").forward(request, response);
		
	}
	
	/*
	 * 教师的我的留言
	 */
	private void teacherlistmymessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取用户名
		String name=request.getParameter("tname");
		System.out.println("tname------------"+name);
		//2.调用Service层的listmymessage方法将返回的数据放到list中
		request.setAttribute("list", messageService.teacherlistmymessage(name));
		//3.请求转发给listmymessage.jsp
		request.getRequestDispatcher("teacher/mymessage.jsp").forward(request, response);
		
	}
	private void listmyreply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String replyname=request.getParameter("sname");
		String key="%%";
		if(replyname!=null){
			key="%"+replyname+"%";
		}
		//分页
		Integer currPage=null;
		String currPag=request.getParameter("currPage");
		if(currPag==null){
			currPage=1;
		}else{
			currPage=Integer.parseInt(currPag);
		}
		
		int pageSize=5;
		if(currPage==null||currPage==0){
			currPage=1;
		}
		int index=(currPage-1)*pageSize;
		int totalCount=Integer.parseInt(messageService.findCount(key).get(0).get("count(id)").toString());
//				System.out.println(totalCount);
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		//1.调用Service层中的findALL方法获取所有问题列表
		MessageService messageService=new MessageService();
		List<Map<String,Object>> list=messageService.listmyreply(key,index,pageSize);
		System.out.println("list------------"+list);
		//2.将获取的问题列表对象list保存到request中
		request.setAttribute("list", list);
		
		//3.请求转发allmessage.jsp
		request.getRequestDispatcher("student/listmyreply.jsp").forward(request, response);
		
	}
	private void teacherlistmyreply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String replyname=request.getParameter("tname");
		String key="%%";
		if(replyname!=null){
			key="%"+replyname+"%";
		}
		//分页
		Integer currPage=null;
		String currPag=request.getParameter("currPage");
		if(currPag==null){
			currPage=1;
		}else{
			currPage=Integer.parseInt(currPag);
		}
		
		int pageSize=5;
		if(currPage==null||currPage==0){
			currPage=1;
		}
		int index=(currPage-1)*pageSize;
		int totalCount=Integer.parseInt(messageService.findCount(key).get(0).get("count(id)").toString());
//				System.out.println(totalCount);
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		//1.调用Service层中的findALL方法获取所有问题列表
		MessageService messageService=new MessageService();
		List<Map<String,Object>> list=messageService.teacherlistmyreply(key,index,pageSize);
		System.out.println("list------------"+list);
		//2.将获取的问题列表对象list保存到request中
		request.setAttribute("list", list);
		
		//3.请求转发allmessage.jsp
		request.getRequestDispatcher("teacher/listmyreply.jsp").forward(request, response);
	}
}
