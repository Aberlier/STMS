package com.zy.user.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.zy.user.domain.Page;
import com.zy.user.domain.Paper;
import com.zy.user.service.FileService;
import com.zy.user.service.StudentService;
import com.zy.user.util.Down;

public class UploadServlet extends HttpServlet {
	FileService fileService=new FileService();
	StudentService studentService=new StudentService();
	public UploadServlet() {
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
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");//获取action的值
		System.out.println("action"+action);
	    if("goupload".equals(action)){
	    	goupload(request,response);
		}else if("upload".equals(action)){
			//System.out.println("upload");
	    	upload(request,response);
		}else if("teacherupload".equals(action)){
			//System.out.println("upload");
			teacherupload(request,response);
		}else if("studentupload".equals(action)){
			//System.out.println("upload");
			studentupload(request,response);
		}else if("seevideo".equals(action)){
			//System.out.println("upload");
			seevideo(request,response);
		}
		else if ("findAll".equals(action)) {
			findAll(request,response);
		}else if ("findmyfile".equals(action)) {
			findmyfile(request,response);
		}else if ("listone".equals(action)) {
			listone(request,response);
		}else if("down".equals(action)){
			down(request,response);
		}else if("view".equals(action)){
			view(request,response);
		}else if ("adminfindAll".equals(action)) {
			adminfindAll(request,response);
		}else if (action.equals("delete")) {
			delete(request, response);
		}else if (action.equals("seevideo")) {
			seevideo(request, response);
		}else if (action.equals("teacherfindAll")) {
			teacherfindAll(request, response);
		}
	}
	private void seevideo(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		Map<String,String> view=new HashMap<String,String>();
		String filepath=request.getParameter("filepath");
		System.out.println("filepath-----------"+filepath);
		String fileone=filepath.substring(filepath.lastIndexOf("\\")+1);
		view.put("fileone", fileone);
		request.setAttribute("view", view);
		request.getRequestDispatcher("admin/seevideo.jsp").forward(request, response);
		
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
		fileService.delete(Integer.parseInt(id));
		adminfindAll(request, response);
		
	}
	
	/*
	 * 管理员的文件列表
	 */
	private void adminfindAll(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        String cha=request.getParameter("filetype");//关键地方  分页的依据  这里是根据文本进行分页相当于sql语句中的like '%文本%'
        System.out.println("cha--------------"+cha);
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
		
		int pageSize=10;
		if(currPage==null||currPage==0){
			currPage=1;
		}
		int index=(currPage-1)*pageSize;
		int totalCount=Integer.parseInt(fileService.findCount(key).get(0).get("count(id)").toString());
//				System.out.println(totalCount);
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		String filetype=request.getParameter("filetype");
        System.out.println("filetype-----"+filetype);
		//1.获取文件列表，调用Service的findAll方法2.将获取的文本列表保存到request中
        List<Map<String,Object>>list=fileService.PagefindAll(key,index,pageSize);
        System.out.println("list--------------"+list);
		request.setAttribute("list", list);
		
		//3.将请求转发到vedios_list.jsp，files_list.jsp页面
		//System.out.println(ziyuanService.findAll(filetype));
		 if("视频".equals(filetype)){
		    	   request.getRequestDispatcher("admin/vedios_list.jsp").forward(request, response);
		       }else if("文本".equals(filetype)){
		    	   request.getRequestDispatcher("admin/files_list.jsp").forward(request, response);
		       }
		
	}
	private void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String> view=new HashMap<String,String>();
		String filepath=request.getParameter("path");
		String filenamea=request.getParameter("filenamea");
		String fileone=filepath.substring(filepath.lastIndexOf("\\")+1);
		
		view.put("filenamea", filenamea);
		view.put("fileone", fileone);
		request.setAttribute("view", view);
		request.getRequestDispatcher("view.jsp").forward(request, response);	
		
	}

	private void goupload(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("upload.jsp").forward(request, response);		
	}

	private void upload(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("application/force-download");
		request.setCharacterEncoding("utf-8");
		String valueKey=request.getParameter("valuekey");
		System.out.println("valuekey--------------"+valueKey);
		String filedetail=request.getParameter("filedetail");
		System.out.println("filedetail--------------"+filedetail);
		String filetype=request.getParameter("filetype");
		System.out.println("filetype1111111111"+filetype);
		try {
			
			//1.创建DiskFileItemFactory工厂对象
			DiskFileItemFactory factory=new DiskFileItemFactory();
//			File f=new File("E:\\temp");
//			if(!f.exists())
//			{
//				f.mkdirs();
//			}
			//2.创建ServletFileUpload对象
			ServletFileUpload fileupload=new ServletFileUpload(factory);			
			fileupload.setHeaderEncoding("utf-8");
			Map<String,String> map = new HashMap<String, String>();
			//3.解析request，得到上传文件的FileItem对象
			List<FileItem> fileitems=fileupload.parseRequest(request);
			//获取字符流
			PrintWriter writer=response.getWriter();
			//遍历集合
			for(FileItem fileitem:fileitems){
				String name=fileitem.getFieldName();
				String valueString=fileitem.getString("utf-8");
				System.out.println("name:--------------"+name);
				System.out.println("valueString:----------"+valueString);
				map.put(name, valueString);
				
				//判断是否为普通字段
				if(fileitem.isFormField()){
					//获得字段名和字段值
					if(name.equals("filename"))
					{
						//如果name不为空，将其保存在value中
						if(!fileitem.getString().equals(""))
						{
							String value=fileitem.getString("utf-8");
							writer.print("上传者："+value+"<br/>");
						}	
					}
				}if(name.equals("filetype"))
				{
					//如果name不为空，将其保存在value中
					if(!fileitem.getString().equals(""))
					{
						String value=fileitem.getString("utf-8");
					
						System.out.println("filetype---"+value);
						filetype=value;
					}	
				}
			else{
					//获取上传文件名
					String filename=fileitem.getName();
					//处理上传文件
					if(filename!=null&&!filename.equals("")){
						writer.print("上传的文件名称是："+filename+"<br/>");
						//截取出文件名
						//C:\Users\Administrator\Desktop\Lemon Tree (Live) - 刘伟男.mp3
						filename=filename.substring(filename.lastIndexOf("\\")+1);
						//文件名需要唯一
						//filename=UUID.randomUUID().toString()+"_"+filename;
						//在服务器上创建同名文件
						String webPath="/upload/";
						//将服务器中文件夹路径与文件名组合成完整的服务器路径
						String filepath=getServletContext().getRealPath(webPath+filename);
						//创建文件
						File file=new File(filepath);
						file.getParentFile().mkdirs();
						file.createNewFile();
						//获得上传文件流
						InputStream in=fileitem.getInputStream();
						//使用FileOutputStream打开服务器端的上传文件
						FileOutputStream out=new FileOutputStream(file);
						//流的对拷
						byte[] buffer=new byte[1024];//每次读取一个字节
						int len;
						//开始读取上传文件的字节，并将其输出到服务器的上传文件输出流中
						while((len=in.read(buffer))>0){
							out.write(buffer,0,len);
						}
						//关闭流
						in.close();
						out.close();
						//删除临时文件
						fileitem.delete();
						writer.print("上传成功！<br/>");
						response.setContentType("text/html;charset=utf-8");
						request.setCharacterEncoding("utf-8");
						//1.获取表单数据
						//String filetitle=request.getParameter("filetitle");
						HttpSession session = request.getSession();
						String filer=(String) session.getAttribute("sno");
						System.out.println("filer--------"+filer);
						System.out.println("Map:"+map);
//						String filetype=map.get("filetype");
//						System.out.println("filetype--------"+filetype);
						String filetitle=map.get("filetitle");
					    String filenamea=fileitem.getName(); 							
						//System.out.println("filetitle"+filetitle+"  filer"+filer+"  filetype"+filetype);
						Paper afile=new Paper();
						afile.setFiletitle(filetitle);
						afile.setFilenamea(filenamea);
						afile.setFiler(filer);
						afile.setFilepath(filepath);
						afile.setFiletype(filetype);
						afile.setUploaddate(new Date());
						afile.setValueKey(valueKey);
						afile.setFiledetail(filedetail);
						System.out.println("afile:"+afile);
						System.out.println("afile.setFiledetail(filedetail)--------"+filedetail);
						fileService.newupload(afile);
				       	request.setAttribute("list", fileService.findAll(filetype));
				       	if("视频".equals(filetype)){
					    	   request.getRequestDispatcher("vedios_list.jsp").forward(request, response);
					       }else if("文本".equals(filetype)){
					    	   request.getRequestDispatcher("files_list.jsp").forward(request, response);
					       }
					   
					}
				}
			}
		} catch (FileUploadException e) {			
			e.printStackTrace();
		}
		
	}
	/**
	 * 注册上传图片
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void registupload(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("textml;charset=utf-8");
		String myname="";
		String path=null;
		String filename_f="";
		String filedetail=request.getParameter("filedetail");
		String filetype =request.getParameter("filetype");
		System.out.println("filetype1111-----------"+filetype);
		String filetitle =request.getParameter("filetitle");
		try {
			
			//1.创建DiskFileItemFactory工厂对象
			DiskFileItemFactory factory=new DiskFileItemFactory();
			File f=new File("E:\\temp");
			if(!f.exists())
			{
				f.mkdirs();
			}
			//2.创建ServletFileUpload对象
			ServletFileUpload fileupload=new ServletFileUpload(factory);
			fileupload.setHeaderEncoding("utf-8");
			Map<String,String> map = new HashMap<String, String>();
			//3.解析request，得到上传文件的FileItem对象
			List<FileItem> fileitems=fileupload.parseRequest(request);
			//获取字符流
			PrintWriter writer=response.getWriter();
			//遍历集合
			for(FileItem fileitem:fileitems){
				//判断是否为普通字段
				if(fileitem.isFormField()){
					//获得字段名和字段值
					String name=fileitem.getFieldName();
					if(name.equals("filetype"))
					{
						//如果name不为空，将其保存在value中
						if(!fileitem.getString().equals(""))
						{
							String value=fileitem.getString("utf-8");
							System.out.println("filetp456---"+value);
							
						}	
					}
					if(name.equals("filename"))
					{
						//如果name不为空，将其保存在value中
						if(!fileitem.getString().equals(""))
						{
							String value=fileitem.getString("utf-8");
							//writer.print("上传者："+value+"<br/>");
							System.out.println("filename---"+value);
						}	
					}
					if(name.equals("filedetail"))
					{
						//如果name不为空，将其保存在value中
						if(!fileitem.getString().equals(""))
						{
							String value=fileitem.getString("utf-8");
						
							System.out.println("filedetail---"+value);
							filedetail=value;
						}	
					}
					
				if(name.equals("filetitle"))
				{
					//如果name不为空，将其保存在value中
					if(!fileitem.getString().equals(""))
					{
						String value=fileitem.getString("utf-8");
					
						System.out.println("filetitle---"+value);
						filetitle=value;
					}	
				}
			}else{
					//获取上传文件名
					String filename=fileitem.getName();
					//处理上传文件
					if(filename!=null&&!filename.equals("")){
						//writer.print("上传的文件名称是："+filename+"<br/>");
						//截取出文件名
						filename=filename.substring(filename.lastIndexOf("\\")+1);
						filename_f=filename;
						path="upload/"+filename;
						//文件名需要唯一
						//filename=UUID.randomUUID().toString()+"_"+filename;
						
						System.out.println("filename---"+filename);
						
						//在服务器上创建同名文件
						String webPath="/upload/";
						//将服务器中文件夹路径与文件名组合成完整的服务器路径
						String filepath=getServletContext().getRealPath(webPath+filename);
//						path=filepath;
						System.out.println("path---"+path);
						//创建文件
						File file=new File(filepath);
						file.getParentFile().mkdirs();
						file.createNewFile();
						//获得上传文件流
						InputStream in=fileitem.getInputStream();
						//使用FileOutputStream打开服务器端的上传文件
						FileOutputStream out=new FileOutputStream(file);
						//流的对拷
						byte[] buffer=new byte[1024];//每次读取一个字节
						int len;
						//开始读取上传文件的字节，并将其输出到服务器的上传文件输出流中
						while((len=in.read(buffer))>0){
							out.write(buffer,0,len);
						}
						//关闭流
						in.close();
						out.close();
						//删除临时文件
						fileitem.delete();
						writer.print("上传成功！<br/>");
						response.setContentType("text/html;charset=utf-8");
						request.setCharacterEncoding("utf-8");
						//1.获取表单数据
						//String filetitle=request.getParameter("filetitle");
						HttpSession session = request.getSession();
						String filer=(String) session.getAttribute("sname");
						System.out.println("filer--------"+filer);
						
					    String filenamea=fileitem.getName(); 							
						System.out.println("filetitle"+filetitle+"  filer"+filer+"  filetype"+filetype);
						Paper afile=new Paper();
						afile.setFiletitle(filetitle);
						afile.setFilenamea(filenamea);
						afile.setFiler(filer);
						afile.setFilepath(filepath);
						afile.setFiletype(filetype);
						afile.setUploaddate(new Date());
//						afile.setValueKey(valueKey);
						afile.setFiledetail(filedetail);
						System.out.println("afile:"+afile);
						System.out.println("afile.setFiledetail(filedetail)--------"+filedetail);
						fileService.newupload(afile);
				       	request.setAttribute("list", fileService.findAll(filetype));
				       	if("视频".equals(filetype)){
				       		teacherfindAll(request, response);
					       }else if("文本".equals(filetype)){
					    	   teacherfindAll(request, response);
					       }
						}
				}
			}
		} catch (FileUploadException e) {			
			e.printStackTrace();
		}
		
	}
	private void teacherupload(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("textml;charset=utf-8");
		String myname="";
		String path=null;
		String filename_f="";
		String filedetail=request.getParameter("filedetail");
		String filetype =request.getParameter("filetype");
		System.out.println("filetype1111-----------"+filetype);
		String filetitle =request.getParameter("filetitle");
		try {
			
			//1.创建DiskFileItemFactory工厂对象
			DiskFileItemFactory factory=new DiskFileItemFactory();
			File f=new File("E:\\temp");
			if(!f.exists())
			{
				f.mkdirs();
			}
			//2.创建ServletFileUpload对象
			ServletFileUpload fileupload=new ServletFileUpload(factory);
			fileupload.setHeaderEncoding("utf-8");
			Map<String,String> map = new HashMap<String, String>();
			//3.解析request，得到上传文件的FileItem对象
			List<FileItem> fileitems=fileupload.parseRequest(request);
			//获取字符流
			PrintWriter writer=response.getWriter();
			//遍历集合
			for(FileItem fileitem:fileitems){
				//判断是否为普通字段
				if(fileitem.isFormField()){
					//获得字段名和字段值
					String name=fileitem.getFieldName();
					if(name.equals("filetype"))
					{
						//如果name不为空，将其保存在value中
						if(!fileitem.getString().equals(""))
						{
							String value=fileitem.getString("utf-8");
							System.out.println("filetp456---"+value);
							
						}	
					}
					if(name.equals("filename"))
					{
						//如果name不为空，将其保存在value中
						if(!fileitem.getString().equals(""))
						{
							String value=fileitem.getString("utf-8");
							//writer.print("上传者："+value+"<br/>");
							System.out.println("filename---"+value);
						}	
					}
					if(name.equals("filedetail"))
					{
						//如果name不为空，将其保存在value中
						if(!fileitem.getString().equals(""))
						{
							String value=fileitem.getString("utf-8");
						
							System.out.println("filedetail---"+value);
							filedetail=value;
						}	
					}
					
				if(name.equals("filetitle"))
				{
					//如果name不为空，将其保存在value中
					if(!fileitem.getString().equals(""))
					{
						String value=fileitem.getString("utf-8");
					
						System.out.println("filetitle---"+value);
						filetitle=value;
					}	
				}
			}else{
					//获取上传文件名
					String filename=fileitem.getName();
					//处理上传文件
					if(filename!=null&&!filename.equals("")){
						//writer.print("上传的文件名称是："+filename+"<br/>");
						//截取出文件名
						filename=filename.substring(filename.lastIndexOf("\\")+1);
						filename_f=filename;
						path="upload/"+filename;
						//文件名需要唯一
						//filename=UUID.randomUUID().toString()+"_"+filename;
						
						System.out.println("filename---"+filename);
						
						//在服务器上创建同名文件
						String webPath="/upload/";
						//将服务器中文件夹路径与文件名组合成完整的服务器路径
						String filepath=getServletContext().getRealPath(webPath+filename);
//						path=filepath;
						System.out.println("path---"+path);
						//创建文件
						File file=new File(filepath);
						file.getParentFile().mkdirs();
						file.createNewFile();
						//获得上传文件流
						InputStream in=fileitem.getInputStream();
						//使用FileOutputStream打开服务器端的上传文件
						FileOutputStream out=new FileOutputStream(file);
						//流的对拷
						byte[] buffer=new byte[1024];//每次读取一个字节
						int len;
						//开始读取上传文件的字节，并将其输出到服务器的上传文件输出流中
						while((len=in.read(buffer))>0){
							out.write(buffer,0,len);
						}
						//关闭流
						in.close();
						out.close();
						//删除临时文件
						fileitem.delete();
						writer.print("上传成功！<br/>");
						response.setContentType("text/html;charset=utf-8");
						request.setCharacterEncoding("utf-8");
						//1.获取表单数据
						//String filetitle=request.getParameter("filetitle");
						HttpSession session = request.getSession();
						String filer=(String) session.getAttribute("tno");
						System.out.println("filer--------"+filer);
						
					    String filenamea=fileitem.getName(); 							
						System.out.println("filetitle"+filetitle+"  filer"+filer+"  filetype"+filetype);
						Paper afile=new Paper();
						afile.setFiletitle(filetitle);
						afile.setFilenamea(filenamea);
						afile.setFiler(filer);
						afile.setFilepath(filepath);
						afile.setFiletype(filetype);
						afile.setUploaddate(new Date());
//						afile.setValueKey(valueKey);
						afile.setFiledetail(filedetail);
						System.out.println("afile:"+afile);
						System.out.println("afile.setFiledetail(filedetail)--------"+filedetail);
						fileService.newupload(afile);
				       	request.setAttribute("list", fileService.findAll(filetype));
				       	if("视频".equals(filetype)){
				       		teacherfindAll(request, response);
					       }else if("文本".equals(filetype)){
					    	   teacherfindAll(request, response);
					       }
						}
				}
			}
		} catch (FileUploadException e) {			
			e.printStackTrace();
		}
		
	}
	
	/*
	 * 学生上传文件
	 */
	private void studentupload(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("textml;charset=utf-8");
		String myname="";
		String path=null;
		String filename_f="";
		String filedetail=request.getParameter("filedetail");
		String filetype =request.getParameter("filetype");
		System.out.println("filetype1111-----------"+filetype);
		String filetitle =request.getParameter("filetitle");
		try {
			
			//1.创建DiskFileItemFactory工厂对象
			DiskFileItemFactory factory=new DiskFileItemFactory();
			File f=new File("E:\\temp");
			if(!f.exists())
			{
				f.mkdirs();
			}
			//2.创建ServletFileUpload对象
			ServletFileUpload fileupload=new ServletFileUpload(factory);
			fileupload.setHeaderEncoding("utf-8");
			Map<String,String> map = new HashMap<String, String>();
			//3.解析request，得到上传文件的FileItem对象
			List<FileItem> fileitems=fileupload.parseRequest(request);
			//获取字符流
			PrintWriter writer=response.getWriter();
			//遍历集合
			for(FileItem fileitem:fileitems){
				//判断是否为普通字段
				if(fileitem.isFormField()){
					//获得字段名和字段值
					String name=fileitem.getFieldName();
					if(name.equals("filetype"))
					{
						//如果name不为空，将其保存在value中
						if(!fileitem.getString().equals(""))
						{
							String value=fileitem.getString("utf-8");
							System.out.println("filetp456---"+value);
							
						}	
					}
					if(name.equals("filename"))
					{
						//如果name不为空，将其保存在value中
						if(!fileitem.getString().equals(""))
						{
							String value=fileitem.getString("utf-8");
							//writer.print("上传者："+value+"<br/>");
							System.out.println("filename---"+value);
						}	
					}
					if(name.equals("filedetail"))
					{
						//如果name不为空，将其保存在value中
						if(!fileitem.getString().equals(""))
						{
							String value=fileitem.getString("utf-8");
						
							System.out.println("filedetail---"+value);
							filedetail=value;
						}	
					}
					
				if(name.equals("filetitle"))
				{
					//如果name不为空，将其保存在value中
					if(!fileitem.getString().equals(""))
					{
						String value=fileitem.getString("utf-8");
					
						System.out.println("filetitle---"+value);
						filetitle=value;
					}	
				}
			}else{
					//获取上传文件名
					String filename=fileitem.getName();
					//处理上传文件
					if(filename!=null&&!filename.equals("")){
						//writer.print("上传的文件名称是："+filename+"<br/>");
						//截取出文件名
						filename=filename.substring(filename.lastIndexOf("\\")+1);
						filename_f=filename;
						path="upload/"+filename;
						//文件名需要唯一
						//filename=UUID.randomUUID().toString()+"_"+filename;
						
						System.out.println("filename---"+filename);
						
						//在服务器上创建同名文件
						String webPath="/upload/";
						//将服务器中文件夹路径与文件名组合成完整的服务器路径
						String filepath=getServletContext().getRealPath(webPath+filename);
//						path=filepath;
						System.out.println("path---"+path);
						//创建文件
						File file=new File(filepath);
						file.getParentFile().mkdirs();
						file.createNewFile();
						//获得上传文件流
						InputStream in=fileitem.getInputStream();
						//使用FileOutputStream打开服务器端的上传文件
						FileOutputStream out=new FileOutputStream(file);
						//流的对拷
						byte[] buffer=new byte[1024];//每次读取一个字节
						int len;
						//开始读取上传文件的字节，并将其输出到服务器的上传文件输出流中
						while((len=in.read(buffer))>0){
							out.write(buffer,0,len);
						}
						//关闭流
						in.close();
						out.close();
						//删除临时文件
						fileitem.delete();
						writer.print("上传成功！<br/>");
						response.setContentType("text/html;charset=utf-8");
						request.setCharacterEncoding("utf-8");
						//1.获取表单数据
						//String filetitle=request.getParameter("filetitle");
						HttpSession session = request.getSession();
						String filer=(String) session.getAttribute("sno");
						System.out.println("filer--------"+filer);
						
					    String filenamea=fileitem.getName(); 							
						System.out.println("filetitle"+filetitle+"  filer"+filer+"  filetype"+filetype);
						Paper afile=new Paper();
						afile.setFiletitle(filetitle);
						afile.setFilenamea(filenamea);
						afile.setFiler(filer);
						afile.setFilepath(filepath);
						afile.setFiletype(filetype);
						afile.setUploaddate(new Date());
//						afile.setValueKey(valueKey);
						afile.setFiledetail(filedetail);
						System.out.println("afile:"+afile);
						System.out.println("afile.setFiledetail(filedetail)--------"+filedetail);
						fileService.newupload(afile);//上传一个文件到数据库
				       	request.setAttribute("list", fileService.findAll(filetype));//插入成功之后才会调到这里
				       	if("视频".equals(filetype)){
				       		teacherfindAll(request, response);
					       }else if("文本".equals(filetype)){
					    	   teacherfindAll(request, response);
					       }
						}
				}
			}
		} catch (FileUploadException e) {			
			e.printStackTrace();
		}
		
	}
	
	
	private void teacherfindAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        String cha=request.getParameter("filetype");//关键地方  分页的依据  这里是根据文本进行分页相当于sql语句中的like '%文本%'
        System.out.println("cha--------------"+cha);
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
		
		int pageSize=10;
		if(currPage==null||currPage==0){
			currPage=1;
		}
		int index=(currPage-1)*pageSize;
		int totalCount=Integer.parseInt(fileService.findCount(key).get(0).get("count(id)").toString());
//				System.out.println(totalCount);
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		String filetype=request.getParameter("filetype");
        System.out.println("filetype-----"+filetype);
		//1.获取新闻列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
        List<Map<String,Object>>list=fileService.PagefindAll(key,index,pageSize);
        System.out.println("list--------------"+list);
		request.setAttribute("list", list);
		
		//3.将请求转发到students_list.jsp页面
		//System.out.println(ziyuanService.findAll(filetype));
		 if("视频".equals(filetype)){
		    	   request.getRequestDispatcher("teacher/vedios_list.jsp").forward(request, response);
		       }else if("文本".equals(filetype)){
		    	   request.getRequestDispatcher("teacher/files_list.jsp").forward(request, response);
		       }

	}
	
	/*
	 * 学生文件视频列表显示
	 */
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        String cha=request.getParameter("filetype");//关键地方  分页的依据  这里是根据文本进行分页相当于sql语句中的like '%文本%'
        System.out.println("cha--------------"+cha);
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
		
		int pageSize=10;
		if(currPage==null||currPage==0){
			currPage=1;
		}
		int index=(currPage-1)*pageSize;
		int totalCount=Integer.parseInt(fileService.findCount(key).get(0).get("count(id)").toString());
//				System.out.println(totalCount);
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		String filetype=request.getParameter("filetype");
        System.out.println("filetype-----"+filetype);
		//1.获取新闻列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
        List<Map<String,Object>>list=fileService.PagefindAll(key,index,pageSize);
        System.out.println("list--------------"+list);
		request.setAttribute("list", list);
		
		//3.将请求转发到students_list.jsp页面
		//System.out.println(ziyuanService.findAll(filetype));
		 if("视频".equals(filetype)){
		    	   request.getRequestDispatcher("student/vedios_list.jsp").forward(request, response);
		       }else if("文本".equals(filetype)){
		    	   request.getRequestDispatcher("student/files_list.jsp").forward(request, response);
		       }

	}
	
	private void findmyfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.将用户名从session中取出来
		HttpSession session = request.getSession();
		String filer=(String) session.getAttribute("username");
        //2.调用service层的findmyfile方法，并将返回的数据放到list中
		request.setAttribute("list", fileService.findmyfile(filer));
		//3.请求转发到files_list.jsp页面
		request.getRequestDispatcher("files_list.jsp").forward(request, response);
		
	}
	
	
	private void listone(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String filetitle=request.getParameter("filetitle");
		List<Map<String,Object>> list=fileService.listone(filetitle);
		request.setAttribute("list", list);
		request.getRequestDispatcher("files_list.jsp").forward(request, response);
//		findAll(request,response);
	}
	private void down(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		/*
		 * 获取下载地址，下载
		 */
		//获取相对路径
		String filename = request.getParameter("path").replace("\\", "/");
		//String filename ="D:/apache-tomcat-7.0.42/webapps/manage/upload/d0a0629a-e988-4839-8a85-8e4c4eaad80c_实验二.doc";
		System.out.println("filenamedown--------------"+filename);
		Down.down(filename,request,response);
	}
	public void init() throws ServletException {
	}

}
