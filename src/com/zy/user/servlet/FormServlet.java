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

import com.zy.user.domain.InForm;
import com.zy.user.domain.Message;
import com.zy.user.service.InFormService;

public class FormServlet extends HttpServlet {
	InFormService informService=new InFormService();//创建UserService对象，
	/**
	 * Constructor of the object.
	 */
	public FormServlet() {
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
		if (action.equals("findAll")) {
			findAll(request, response);
		}else if (action.equals("adminfindAll")) {
			adminfindAll(request, response);
		}else if (action.equals("delete")) {
			delete(request, response);
		}else if (action.equals("update")) {
			update(request, response);
		}else if(action.equals("updatebefore")) {
			updatebefore(request, response);
		}else if (action.equals("addinform")) {
			addinform(request, response);
		}
	}
	
	/*
	 * 学生的公告列表
	 */
public void findAll(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	List<InForm> list=informService.findAll();
	System.out.println("informlist----------"+list);
	request.setAttribute("list", list);
	request.getRequestDispatcher("student/inform.jsp").forward(request, response);//跳转到inform.jsp页面
}


/*
 * 管理员的公告列表
 */
public void adminfindAll(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	List<InForm> list=informService.findAll();
	System.out.println("informlist----------"+list);
	request.setAttribute("list", list);
	request.getRequestDispatcher("admin/inform.jsp").forward(request, response);//跳转到success.jsp页面
}


private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*
	 * 1.获取id
	 * 2.调用Service进行删除
	 * 3.获取新闻列表，直接调用findAll方法
	 */
	//1.获取id
	String id = request.getParameter("id");
	System.out.println("id----------"+id);
	//2.调用Service进行删除
	informService.delete(Integer.parseInt(id));
	adminfindAll(request, response);
}
private void updatebefore(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
	String id=request.getParameter("id");
	List<Map<String, Object>> list=informService.findbyId(id);
	System.out.println(list);
	HttpSession session=request.getSession();
	session.setAttribute("list",list);//session.setAttribute(String name,Object value);	名  对象
	response.sendRedirect(request.getContextPath()+"/admin/update_inform.jsp");//项目路径
	/*request.setAttribute("list", list);
	request.getRequestDispatcher("admin/update_student.jsp").forward(request, response);		*/
  }
private void update(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	 
	// 1.获取表单数据
				String idn=request.getParameter("id");
				int id= Integer.parseInt(idn); 
				System.out.println("id---------"+id);
				String title=request.getParameter("title");
				System.out.println("title---------"+title);
				String content=request.getParameter("content");
				System.out.println("content---------"+content);
				//2.将表单数据封装到New对象中
				InForm inf=new InForm();
				inf.setId(id);
				inf.setTitle(title);
				inf.setContent(content);
				//3.调用Service的updateUser方法
				informService.update(inf);
				request.setAttribute("list",inf);
				adminfindAll(request, response);
				
}

/*
 * 管理员发布公告
 */
private void addinform(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException { 
	    request.setCharacterEncoding("utf-8");
		String title=request.getParameter("title");
		String content=request.getParameter("content");		
		InForm annew=new InForm();
		annew.setTitle(title);
		annew.setContent(content);
		annew.setInformdata(new Date());
		

		informService.add(annew);
		adminfindAll(request, response);
//		PrintWriter out=response.getWriter();
//		   out.println("<h3>发布问题成功，5秒后返回<a href=\"allmessage.jsp\">所有问题及回复界面</a>!</h3>");
//		   response.setHeader("Refresh", "5;url=allmessage.jsp");
}


	public void init() throws ServletException {
		// Put your code here
	}

}
