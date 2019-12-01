package com.zy.user.servlet;


import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSON;
import com.zy.user.domain.Page;
import com.zy.user.domain.Score;
import com.zy.user.domain.ScoreExcel;
import com.zy.user.service.ScoreService;
import com.zy.user.util.StyleExcelHandler;

public class ScoreServlet extends HttpServlet {
	ScoreService scoreService=new ScoreService();
	
	public ScoreServlet() {
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
			if(action.equals("stu_findAllScore")){
				findAll(request,response);
			}else if(action.equals("findAllScore")){
				findAllScore(request,response);
			}else if(action.equals("viewbefore")){
				viewbefore(request,response);
			}else if(action.equals("daoru_score")){
				daoru_score(request,response);
			}else if(action.equals("updatescore_before")){
				updatescore_before(request,response);
			}else if(action.equals("findAll_fushi")){
				findAll_fushi(request,response);
			}else if(action.equals("tea_findAllScore")){
				tea_findAllScore(request,response);
			}else if(action.equals("tea_find_query")){
				tea_find_query(request,response);
			}else if(action.equals("tea_findAll_stu_Score")){
				tea_findAll_stu_Score(request,response);
			}else if(action.equals("tea_findAllScore2")){
				tea_findAllScore2(request,response);
			}else if(action.equals("admin_findAllScore")){
				admin_findAllScore(request,response);
			}else if(action.equals("admin_updatescore_before")){
				admin_updatescore_before(request,response);
			}else if(action.equals("admin_update_score")){
				admin_update_score(request,response);
			}else if("studentWelcomeChart".equals(action)){
				studentWelcomeChart(request,response);
			}else if(action.equals("adm_findAllScore")){
				adm_findAllScore(request,response);
			}else if(action.equals("admin_find_query")){
				admin_find_query(request,response);
			}else if(action.equals("adm_findAllScore2")){
				adm_findAllScore2(request,response);
			}else if ("teaChartScore".equals(action)){
				teaChartScore(request,response);
			}else if ("exportExcel".equals(action)){
				exportExcel(request,response);
			}
			else if ("exportExcel_fushi".equals(action)){
				exportExcel_fushi(request,response);
			}
			else if ("admin_updatescore_before_fushi".equals(action)){
				admin_updatescore_before_fushi(request,response);
			}else if ("admin_update_score_fushi".equals(action)){
				admin_update_score_fushi(request,response);
			}else if ("adm_find_query2".equals(action)){
				adm_find_query2(request,response);
			}else if ("tea_find_query2".equals(action)){
				tea_find_query2(request,response);
			}else if ("admin_find_query2".equals(action)){
				admin_find_query2(request,response);
			}else if ("toExportExcelAll".equals(action)){
				toExportExcelAll(request,response);
			}else if ("exportExcelAll".equals(action)){
				exportExcelAll(request,response);
			}else if ("stackBarData".equals(action)){
				stackBarData(request,response);
			}

			
			
	}

	private void stackBarData(HttpServletRequest request, HttpServletResponse resp) throws IOException {
		String tname = request.getParameter("tname");
//		System.out.println("teaChartScore::"+tname);
		Map<String,Object> result=new HashMap<>();

		//根据教师名查考试名称和id
		List<Map<String,Object>> examlist = scoreService.stackBarData(tname);
		//封装考试名称
		List<String> resultExamList=new ArrayList<>();
		List<String> resultA0List=new ArrayList<>();
		List<String> resultA5List=new ArrayList<>();
		List<String> resultA6List=new ArrayList<>();
		List<String> resultA7List=new ArrayList<>();
		List<String> resultA8List=new ArrayList<>();
		List<String> resultA9List=new ArrayList<>();
		List<String> resultA10List=new ArrayList<>();


		for (int i = 0; i < examlist.size(); i++) {
			resultExamList.add(examlist.get(i).get("ename").toString());
			resultA0List.add(examlist.get(i).get("a0").toString());
			resultA5List.add(examlist.get(i).get("a5").toString());
			resultA6List.add(examlist.get(i).get("a6").toString());
			resultA7List.add(examlist.get(i).get("a7").toString());
			resultA8List.add(examlist.get(i).get("a8").toString());
			resultA9List.add(examlist.get(i).get("a9").toString());
			resultA10List.add(examlist.get(i).get("a10").toString());
		}

		//根据教师名和考试id查平均分

		//查

		result.put("resultExamList",resultExamList);
		result.put("a0",resultA0List);
		result.put("a5",resultA5List);
		result.put("a6",resultA6List);
		result.put("a7",resultA7List);
		result.put("a8",resultA8List);
		result.put("a9",resultA9List);
		result.put("a10",resultA10List);


		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json; charset=utf-8");
		PrintWriter writer = resp.getWriter();
		writer.write(JSON.toJSONString(result));

	}

	private void exportExcelAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Content-disposition", "attachment; filename=" + "exam.xlsx");
		response.setContentType("application/msexcel;charset=UTF-8");//设置类型
		response.setHeader("Pragma", "No-cache");//设置头
		response.setHeader("Cache-Control", "no-cache");//设置头
		response.setDateHeader("Expires", 0);//设置日期头
		// 文件输出位置
		OutputStream out = response.getOutputStream();
		//设置样式
		ExcelWriter writer = new ExcelWriter(null, out, ExcelTypeEnum.XLSX, true, new StyleExcelHandler());

		String ids = request.getParameter("ids");

		String[] idsArr = ids.split(",");
		List<Map<String,Object>> list = scoreService.findExportExcelAll();

		for (int i = 0; i < idsArr.length; i++) {
			Map<String, Object> map = list.get(Integer.parseInt(idsArr[i]));
			System.out.println(map.get("ename"));
			List<ScoreExcel> scoreExcelList=new ArrayList<>();
			if ("初试".equals(map.get("type"))){
				scoreExcelList=scoreService.findScoreExcelByTname(map.get("headmaster").toString(),map.get("eid").toString());
			}else if ("复试".equals(map.get("type"))){
				scoreExcelList=scoreService.find_fushi_ScoreExcelByTname(map.get("headmaster").toString(),map.get("eid").toString());
			}
			System.out.println(scoreExcelList.size());
			if (scoreExcelList.size()>0){
				Sheet sheet = new Sheet(i+1, 1, ScoreExcel.class, map.get("ename").toString()+map.get("type").toString(), null);
				writer.write(scoreExcelList, sheet);
			}

		}
		writer.finish();
		// 关闭流
		out.close();
	}

	private void toExportExcelAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String,Object>> list = scoreService.findExportExcelAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/admin/exportExcelAll.jsp").forward(request, response);

	}

	private void exportExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//添加响应头信息
		String headmaster=request.getParameter("headmaster");
		String eid=request.getParameter("ename");
		response.setHeader("Content-disposition", "attachment; filename=" + "exam.xlsx");
		response.setContentType("application/msexcel;charset=UTF-8");//设置类型
		response.setHeader("Pragma", "No-cache");//设置头
		response.setHeader("Cache-Control", "no-cache");//设置头
		response.setDateHeader("Expires", 0);//设置日期头

		List<ScoreExcel> list=scoreService.findScoreExcelByTname(headmaster,eid);
		System.out.println(list.get(0));


		// 文件输出位置
		OutputStream out = response.getOutputStream();
		//设置样式
		ExcelWriter writer = new ExcelWriter(null, out, ExcelTypeEnum.XLSX, true, new StyleExcelHandler());

		// 创建sheet
		Sheet sheet1 = new Sheet(1, 0, ScoreExcel.class);
//		Sheet sheet2 = new Sheet(2, 1, ScoreExcel.class, list.get(0).getEname()+1, null);

		// 第一个 sheet 名称
		sheet1.setSheetName(list.get(0).getEname());

		// 写数据到 Writer 上下文中
		// 入参1: 创建要写入的模型数据
		// 入参2: 要写入的目标 sheet
		writer.write(list, sheet1);
//		writer.write(list, sheet2);
		// 将上下文中的最终 outputStream 写入到指定文件中
		writer.finish();

		// 关闭流
		out.close();
	}
	private void exportExcel_fushi(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//添加响应头信息
		String headmaster=request.getParameter("headmaster");
		String eid=request.getParameter("ename");
		response.setHeader("Content-disposition", "attachment; filename=" + "exam.xlsx");
		response.setContentType("application/msexcel;charset=UTF-8");//设置类型
		response.setHeader("Pragma", "No-cache");//设置头
		response.setHeader("Cache-Control", "no-cache");//设置头
		response.setDateHeader("Expires", 0);//设置日期头

		List<ScoreExcel> list=scoreService.find_fushi_ScoreExcelByTname(headmaster,eid);
		System.out.println(list.get(0));


		// 文件输出位置
		OutputStream out = response.getOutputStream();
		//设置样式
		ExcelWriter writer = new ExcelWriter(null, out, ExcelTypeEnum.XLSX, true, new StyleExcelHandler());

		// 创建sheet
		Sheet sheet1 = new Sheet(1, 0, ScoreExcel.class);
//		Sheet sheet2 = new Sheet(2, 1, ScoreExcel.class, list.get(0).getEname()+1, null);

		// 第一个 sheet 名称
		sheet1.setSheetName(list.get(0).getEname());

		// 写数据到 Writer 上下文中
		// 入参1: 创建要写入的模型数据
		// 入参2: 要写入的目标 sheet
		writer.write(list, sheet1);
//		writer.write(list, sheet2);
		// 将上下文中的最终 outputStream 写入到指定文件中
		writer.finish();

		// 关闭流
		out.close();
	}
	
	private void teaChartScore(HttpServletRequest request, HttpServletResponse resp) throws IOException {
		String tname = request.getParameter("tname");
//		System.out.println("teaChartScore::"+tname);
		Map<String,Object> result=new HashMap<>();

		//根据教师名查考试名称和id
		List<Map<String,Object>> examlist = scoreService.findExamByTname(tname);
		//封装考试名称
		List<String> resultExamList=new ArrayList<>();
		List<String> resultAvgList=new ArrayList<>();
		List<String> resultJigelvList=new ArrayList<>();
		List<String> resultYouxiulvlvList=new ArrayList<>();
		for (int i = 0; i < examlist.size(); i++) {
			resultExamList.add(examlist.get(i).get("ename").toString());
			if (examlist.get(i).get("pingjunfen").toString().length()>=5){
				resultAvgList.add(examlist.get(i).get("pingjunfen").toString().substring(0,5));
			}else {
				resultAvgList.add(examlist.get(i).get("pingjunfen").toString());
			}

			if (examlist.get(i).get("jigelv").toString().length()>=5){
				resultJigelvList.add(examlist.get(i).get("jigelv").toString().substring(0,5));
			}else {
				resultAvgList.add(examlist.get(i).get("jigelv").toString());
			}

			if (examlist.get(i).get("youxiulv").toString().length()>=5){
				resultYouxiulvlvList.add(examlist.get(i).get("youxiulv").toString().substring(0,5));
			}else {
				resultAvgList.add(examlist.get(i).get("youxiulv").toString());
			}
		}

		//根据教师名和考试id查平均分

		//查

	result.put("resultExamList",resultExamList);
	result.put("resultAvgList",resultAvgList);
	result.put("resultJigelvList",resultJigelvList);
	result.put("resultYouxiulvList",resultYouxiulvlvList);
	resp.setCharacterEncoding("utf-8");
	resp.setContentType("application/json; charset=utf-8");
	PrintWriter writer = resp.getWriter();
	writer.write(JSON.toJSONString(result));
	}




	private void studentWelcomeChart(HttpServletRequest request, HttpServletResponse resp) throws IOException {
		Map<String,Object> result=new HashMap<>();

		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json; charset=utf-8");
		PrintWriter writer = resp.getWriter();
		String sname=request.getParameter("sname");


		//根据sname获取考试名称列表
		//	['摸底考试','第一次周考','第二次周考','第三次周考','期中考试','第一次模拟考试','第二次模拟考试']
//		List<String> examList = scoreService.getExamsBySname(sname);
//
//		//根据sname每次考试获取总分
//		List<Double> sumList = scoreService.getSumBySname(sname);
//
//		//根据sname每次考试获取平均分
//		List<Double> avgList = scoreService.getAvgBySname(sname);

		//总体平均分、平均总分
		List<Double> allAvgList=new ArrayList<>();
		List<Double> allSumList=new ArrayList<>();
		//个人平均分、总分
		List<Double> avgList = new ArrayList<>();
		List<Double> sumList =new ArrayList<>();
		//考试列表
		List<String> examList=new ArrayList<>();
		//一次获取数据
		List<Map<String,Object>> list = scoreService.findBySname(sname);
		//包装数据
		for (int i = 0; i < list.size(); i++) {
			examList.add(list.get(i).get("ename").toString());
			Double avg = Double.valueOf(list.get(i).get("avg").toString());
			Double pingjunfen = Double.valueOf(list.get(i).get("pingjunfen").toString());
			Double zongfen = Double.valueOf(list.get(i).get("zongfen").toString());
			avgList.add((double) Math.round(avg * 100) / 100);
			sumList.add(Double.valueOf(list.get(i).get("sum").toString()));
			allAvgList.add((double) Math.round(pingjunfen * 100) / 100);
			allSumList.add((double) Math.round(zongfen * 100) / 100);
		}
		result.put("examlist",examList);
		result.put("sumlist",sumList);
		result.put("avglist",avgList);
		result.put("allAvgList",allAvgList);
		result.put("allSumList",allSumList);
		//写出json
		writer.write(JSON.toJSONString(result));

	}


	private void findAll_fushi(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException {
		String sname=request.getParameter("sname");
		String key="%%";
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
		int totalCount=Integer.parseInt(scoreService.findCount_fushi(key).get(0).get("count(sid)").toString());
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		 List<Map<String,Object>> list=scoreService.findAll_fushi(key,index,pageSize);
		//1.获取学生列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
		request.setAttribute("list", list);
		//3.将请求转发到students_list.jsp页面
		request.getRequestDispatcher("/student/score_fushi_list.jsp").forward(request, response);//跳转到success.jsp页面
	}


	
	private void admin_update_score_fushi(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException {
		String sid1=request.getParameter("sid");
		int sid=Integer.parseInt(sid1);
		String chinese1=request.getParameter("chinese");
		double chinese=Double.parseDouble(chinese1);
		String math1=request.getParameter("math");
		double math=Double.parseDouble(math1);
		String english1=request.getParameter("english");
		double english=Double.parseDouble(english1);
		String physics1=request.getParameter("physics");
		double physics=Double.parseDouble(physics1);
		String chemistry1=request.getParameter("chemistry");
		double chemistry=Double.parseDouble(chemistry1);
		String politics1=request.getParameter("politics");
		double politics=Double.parseDouble(politics1);
		String history1=request.getParameter("history");
		double history=Double.parseDouble(history1);
		String geography1=request.getParameter("geography");
		double geography=Double.parseDouble(geography1);
		String biology1=request.getParameter("biology");
		double biology=Double.parseDouble(biology1);
		double sum1=chinese+math+english+physics+chemistry+
				politics+history+geography+biology;
		DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
		String sum=decimalFormat.format(sum1);
		int sum2=Integer.parseInt(sum);
		double avg1=sum1/9.0f;
        String avg=decimalFormat.format(avg1);//format 返回的是字符串
		Score score=new Score();
		score.setSid(sid);
		score.setChinese(chinese);
		score.setMath(math);
		score.setEnglish(english);
		score.setPhysics(physics);
		score.setChemistry(chemistry);
		score.setPolitics(politics);
		score.setHistory(history);
		score.setGeography(geography);
		score.setBiology(biology);
		score.setSum(sum2);
		score.setAvg(avg);
		int flag=scoreService.admin_update_score_fushi(score);
		if(flag>0){
			request.setAttribute("msg", "<script>alert('修改成功')</script>");
			adm_findAllScore2(request, response);
		}else{
			request.setAttribute("msg", "<script>alert('修改失败')</script>");
			request.getRequestDispatcher("admin/updatescore_fushi.jsp").forward(request, response);
		}
		
	}
	private void admin_update_score(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException {
		
		
		String eid1=request.getParameter("eid");
		int eid=Integer.parseInt(eid1);
		String headmaster=request.getParameter("headmaster");
		
		String sid1=request.getParameter("sid");
		int sid=Integer.parseInt(sid1);
	
		String chinese1=request.getParameter("chinese");
		
		String math1=request.getParameter("math");
		
		String english1=request.getParameter("english");
		
		String physics1=request.getParameter("physics");
		
		String chemistry1=request.getParameter("chemistry");
		
		String politics1=request.getParameter("politics");
		
		String history1=request.getParameter("history");
		
			
	
		String geography1=request.getParameter("geography");
		
		String biology1=request.getParameter("biology");
		
		double chinese=Double.parseDouble(chinese1);
		double math=Double.parseDouble(math1);
		double english=Double.parseDouble(english1);
		double physics=Double.parseDouble(physics1);
		double chemistry=Double.parseDouble(chemistry1);
		double politics=Double.parseDouble(politics1);
		double history=Double.parseDouble(history1);
		double geography=Double.parseDouble(geography1);
		double biology=Double.parseDouble(biology1);
		
	
		
		/*String regionalranking=request.getParameter("regionalranking");
		int regionalranking=Integer.parseInt(regionalranking1);
		String provincialranking=request.getParameter("provincialranking");
		int provincialranking=Integer.parseInt(provincialranking1);*/
		double sum1=chinese+math+english+physics+chemistry+
				politics+history+geography+biology;
		/*int sum=(int) (sum1);*/
		DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
		String sum=decimalFormat.format(sum1);
		double sum2=Double.parseDouble(sum);
		double avg1=sum1/9.0f;
        String avg=decimalFormat.format(avg1);//format 返回的是字符串
	
        
        Score score=new Score();
		score.setSid(sid);
		score.setChinese(chinese);
		score.setMath(math);
		score.setEnglish(english);
		score.setPhysics(physics);
		score.setChemistry(chemistry);
		score.setPolitics(politics);
		score.setHistory(history);
		score.setGeography(geography);
		score.setBiology(biology);
		score.setSum(sum2);
		score.setAvg(avg);
		
        
		int flag=scoreService.admin_update_score(score);
		
	
		
		
		if(flag>0){
			request.setAttribute("eid", eid);
			request.setAttribute("headmaster",headmaster);
			request.setAttribute("msg", "<script>alert('修改成功')</script>");
			admin_findAllScore(request, response);
		}else{
			request.setAttribute("msg", "<script>alert('修改失败')</script>");
			request.getRequestDispatcher("admin/updatescore.jsp").forward(request, response);
		}
		
	}


	private void daoru_score(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException {
		String headmaster=request.getParameter("headmaster");
		request.setAttribute("headmaster", headmaster);
		request.getRequestDispatcher("/teacher/exl.jsp").forward(request, response);
	}
	private void adm_find_query2(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException {
	
		String ename=request.getParameter("ename");
		String sname=request.getParameter("sname");
		//记得写查询全部的判断
		if(ename.equals("显示全部")||sname.equals("选择学生姓名")){
			adm_findAllScore2(request, response);
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
		int totalCount=Integer.parseInt(scoreService.adm_findCount2().get(0).get("count(sid)").toString());
		
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		 List<Map<String,Object>> list=scoreService.adm_findAll_query2(ename,sname,index, pageSize);
		 
			List<Map<String,Object>> list3=scoreService.findAllExam();
		 //1.获取学生列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
		request.setAttribute("list", list);request.setAttribute("list3", list3);
		request.setAttribute("ename", ename);
		request.setAttribute("sname", sname);
		//3.将请求转发到students_list.jsp页面
		request.getRequestDispatcher("/admin/scorelist_query.jsp").forward(request, response);//跳转到success.jsp页面
	}

	private void tea_find_query(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException {
		String headmaster=request.getParameter("headmaster");
		String ename=request.getParameter("ename");
		String sname=request.getParameter("sname");
		//记得写查询全部的判断
		if(ename.equals("")||sname.equals("")){
			tea_findAllScore(request, response);
		}
		String key="%%";
		if(headmaster!=null){
			key="%"+headmaster+"%";
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
		int totalCount=Integer.parseInt(scoreService.tea_findCount(key).get(0).get("count(sid)").toString());
	
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		 List<Map<String,Object>> list=scoreService.tea_findAll_query(ename,sname, key, index, pageSize);
		 List<Map<String,Object>> list2=scoreService.findAllStudentName(headmaster);
			List<Map<String,Object>> list3=scoreService.findAllExam();
		 //1.获取学生列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);
		request.setAttribute("headmaster", headmaster);
		request.setAttribute("ename", ename);
		request.setAttribute("sname", sname);
		
		//3.将请求转发到students_list.jsp页面
		request.getRequestDispatcher("/teacher/scorelist_query.jsp").forward(request, response);//跳转到success.jsp页面
	}
	private void tea_find_query2(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException {
		String headmaster=request.getParameter("headmaster");
		String ename=request.getParameter("ename");
		String sname=request.getParameter("sname");
		//记得写查询全部的判断
		if(ename.equals("")&&sname.equals("")){
			tea_findAllScore2(request, response);
		}
		String key="%%";
		if(headmaster!=null){
			key="%"+headmaster+"%";
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
		int totalCount=Integer.parseInt(scoreService.tea_findCount(key).get(0).get("count(sid)").toString());
		System.out.println("totalCount-----------"+totalCount);
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		 List<Map<String,Object>> list=scoreService.tea_findAll_query(ename,sname, key, index, pageSize);
		 List<Map<String,Object>> list2=scoreService.findAllStudentName(headmaster);
			List<Map<String,Object>> list3=scoreService.findAllExam();
		 //1.获取学生列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);
		request.setAttribute("headmaster", headmaster);
		request.setAttribute("ename", ename);
		request.setAttribute("sname", sname);
		System.out.println("Scorelist------------"+list);
		//3.将请求转发到students_list.jsp页面
		request.getRequestDispatcher("/teacher/scorelist_query.jsp").forward(request, response);//跳转到success.jsp页面
	}
	
	private void admin_find_query(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException {
		
		String ename=request.getParameter("ename");
		String sname=request.getParameter("sname");
		if(ename.equals("")&&sname.equals("")){
			adm_findAllScore(request, response);
		}
		//记得写查询全部的判断
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
		int totalCount=Integer.parseInt(scoreService.adm_findCount().get(0).get("count(sid)").toString());
		System.out.println("totalCount-----------"+totalCount);
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		List<Map<String,Object>> list=scoreService.adm_findAll_query(ename,sname, index, pageSize);
		List<Map<String,Object>> list2=scoreService.findAllStudentName();
		List<Map<String,Object>> list3=scoreService.findAllExam();
		List<Map<String,Object>> list4=scoreService.findAllTea();
		 //1.获取学生列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);
		request.setAttribute("list4", list4);
		request.setAttribute("ename", ename);
		request.setAttribute("sname", sname);
		//3.将请求转发到students_list.jsp页面
		request.getRequestDispatcher("/admin/scorelist_query.jsp").forward(request, response);//跳转到success.jsp页面
	}
	private void admin_find_query2(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException {
		
		String ename=request.getParameter("ename");
		String sname=request.getParameter("sname");
		if(ename.equals("")&&sname.equals("")){
			adm_findAllScore2(request, response);
		}
		//记得写查询全部的判断
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
		int totalCount=Integer.parseInt(scoreService.adm_findCount().get(0).get("count(sid)").toString());
		System.out.println("totalCount-----------"+totalCount);
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		List<Map<String,Object>> list=scoreService.adm_findAll_query(ename,sname, index, pageSize);
		List<Map<String,Object>> list2=scoreService.findAllStudentName();
		List<Map<String,Object>> list3=scoreService.findAllExam();
		List<Map<String,Object>> list4=scoreService.findAllTea();
		 //1.获取学生列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);
		request.setAttribute("list4", list4);
		request.setAttribute("ename", ename);
		request.setAttribute("sname", sname);
		//3.将请求转发到students_list.jsp页面
		request.getRequestDispatcher("/admin/scorelist_query.jsp").forward(request, response);//跳转到success.jsp页面
	}

	private void findAllScore(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException {
		String sname=request.getParameter("sname");
		List<Map<String,Object>> list=scoreService.findAllScore(sname);
		if(list!=null){
			//1.获取学生列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
			request.setAttribute("list",list);
			//3.将请求转发到students_list.jsp页面
			request.getRequestDispatcher("/student/scoreChart.jsp").forward(request, response);//跳转到success.jsp页面	
		}
	}
	private void tea_findAll_stu_Score(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException {
		String headmaster=request.getParameter("headmaster");
		String role=request.getParameter("role");
//		List<Map<String,Object>> list=scoreService.tea_findAll_stu_Score(headmaster);
//		List<Map<String,Object>> list2=scoreService.tea_findAll_stu_Score2(headmaster);
//		if(list!=null){
//			//1.获取学生列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
//			request.setAttribute("list",list);
//			request.setAttribute("list2",list2);
//			request.setAttribute("role", role);
//			//3.将请求转发到students_list.jsp页面
//			request.getRequestDispatcher("/teacher/chart_score.jsp").forward(request, response);//跳转到success.jsp页面
//		}
		request.setAttribute("tname", headmaster);
		request.setAttribute("role", role);
		request.getRequestDispatcher("/teacher/tea_chart_score.jsp").forward(request, response);
	}
	
	
	
	//教师查看对应的班级成绩
	private void tea_findAllScore(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException {
		String headmaster=request.getParameter("headmaster");
		String key="%%";
		if(headmaster!=null){
			key="%"+headmaster+"%";
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
		int totalCount=Integer.parseInt(scoreService.tea_findCount(key).get(0).get("count(sid)").toString());
		System.out.println("totalCount-----------"+totalCount);
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		List<Map<String,Object>> list=scoreService.tea_findAll(key,index,pageSize);
		if(list.isEmpty()){
			request.setAttribute("msg", "<script>alert('请检查学生是否全部在系统注册！')</script>");
		}
			List<Map<String,Object>> list2=scoreService.findAllStudentName(headmaster);
			List<Map<String,Object>> list3=scoreService.findAllExam();
			//1.获取学生列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
			request.setAttribute("list", list);
			request.setAttribute("list2", list2);
			request.setAttribute("list3", list3);
			request.setAttribute("headmaster", headmaster);
			//3.将请求转发到students_list.jsp页面
			request.getRequestDispatcher("/teacher/scorelist.jsp").forward(request, response);//跳转到success.jsp页面
		
	}
	
	private void adm_findAllScore(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException {
	
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
		int totalCount=Integer.parseInt(scoreService.adm_findCount().get(0).get("count(sid)").toString());
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		List<Map<String,Object>> list=scoreService.adm_findAll(index,pageSize);
		if(list.isEmpty()){
			request.setAttribute("msg", "<script>alert('请检查学生是否全部在系统注册！')</script>");
		}
			List<Map<String,Object>> list2=scoreService.findAllStudentName();
			List<Map<String,Object>> list3=scoreService.findAllExam();
			List<Map<String,Object>> list4=scoreService.findAllTea();
			//1.获取学生列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
			request.setAttribute("list", list);
			request.setAttribute("list2", list2);
			request.setAttribute("list3", list3);
			request.setAttribute("list4", list4);
			//3.将请求转发到students_list.jsp页面
			request.getRequestDispatcher("/admin/scorelist.jsp").forward(request, response);//跳转到success.jsp页面
		
	}

	private void adm_findAllScore2(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException {
	
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
		int totalCount=Integer.parseInt(scoreService.adm_findCount2().get(0).get("count(sid)").toString());
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		List<Map<String,Object>> list=scoreService.adm_findAll2(index,pageSize);
		if(list.isEmpty()){
			request.setAttribute("msg", "<script>alert('请检查学生是否全部在系统注册！')</script>");
		}
			List<Map<String,Object>> list2=scoreService.findAllStudentName();
			List<Map<String,Object>> list3=scoreService.findAllExam();
			List<Map<String,Object>> list4=scoreService.findAllTea();
			//1.获取学生列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
			request.setAttribute("list", list);
			request.setAttribute("list2", list2);
			request.setAttribute("list3", list3);
			request.setAttribute("list4", list4);
			//3.将请求转发到students_list.jsp页面
			request.getRequestDispatcher("/admin/scorelist2.jsp").forward(request, response);//跳转到success.jsp页面
		
	}
	private void tea_findAllScore2(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException {
		String headmaster=request.getParameter("headmaster");
		System.out.println("headmaster--------"+headmaster);
		String key="%%";
		if(headmaster!=null){
			key="%"+headmaster+"%";
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
		int totalCount=Integer.parseInt(scoreService.tea_findCount2(key).get(0).get("count(sid)").toString());
		System.out.println("totalCount-----------"+totalCount);
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		List<Map<String,Object>> list=scoreService.tea_findAll2(key,index,pageSize);
		if(list.isEmpty()){
			request.setAttribute("msg", "<script>alert('请检查学生是否全部在系统注册！')</script>");
		}
			List<Map<String,Object>> list2=scoreService.findAllStudentName(headmaster);
			List<Map<String,Object>> list3=scoreService.findAllExam();
			//1.获取学生列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
			request.setAttribute("list", list);
			request.setAttribute("list2", list2);
			request.setAttribute("list3", list3);
			request.setAttribute("headmaster", headmaster);
			//3.将请求转发到students_list.jsp页面
			request.getRequestDispatcher("/teacher/scorelist2.jsp").forward(request, response);//跳转到success.jsp页面
		
	}
	private void admin_findAllScore(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException {
		String eid1=request.getParameter("eid");
		System.out.println("eid1-------------"+eid1);
		int eid=Integer.parseInt(eid1);
		String headmaster =request.getParameter("headmaster");
		System.out.println("headmaster-------------"+headmaster);
/*		//区域排名
		List<Score> listAllR = scoreService.findRegionalranking_update(eid,headmaster);
		System.out.println("////////////////"+listAllR);
			Collections.sort(listAllR);
	        for (int i = 0; i <listAllR.size(); i++) {
	        	listAllR.get(i).setRegionalranking(i+1+"");
	            scoreService.updateRegionalranking_update(listAllR.get(i));
	        }
		//总排名 
		
        List<Score> listAll = scoreService.findProvincialranking_update(eid);

        Collections.sort(listAll);
        for (int i = 0; i <listAll.size(); i++) {
        	listAll.get(i).setProvincialranking(i+1+"");
            scoreService.updateProvincialranking_update(listAll.get(i));
        }*/
		
		//区域排名
				List<Score> listAllR = scoreService.findRegionalranking(eid,headmaster);
				
					Collections.sort(listAllR);
			        for (int i = 0; i <listAllR.size(); i++) {
			        
			        	listAllR.get(i).setRegionalranking(i+1+"");
			            scoreService.updateRegionalranking(listAllR.get(i));
			        }
			    
				
				
				//总排名 
				
		        List<Score> listAll = scoreService.findProvincialranking(eid);
		       
		        System.out.println("listAll--------"+listAll);
		        Collections.sort(listAll);
		        for (int i = 0; i <listAll.size(); i++) {
		        	
		            listAll.get(i).setProvincialranking(i+1+"");
		            scoreService.updateProvincialranking(listAll.get(i));
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
		int totalCount=Integer.parseInt(scoreService.admin_findCount().get(0).get("count(sid)").toString());
		System.out.println("totalCount-----------"+totalCount);
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		List<Map<String,Object>> list=scoreService.admin_findAll(index,pageSize);
		if(list.isEmpty()){
			request.setAttribute("msg", "<script>alert('请检查学生是否全部在系统注册！')</script>");
		}
			List<Map<String,Object>> list2=scoreService.admin_findAllStudentName();
			List<Map<String,Object>> list3=scoreService.findAllExam();
			//1.获取学生列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
			request.setAttribute("list", list);
			request.setAttribute("list2", list2);
			request.setAttribute("list3", list3);
			//3.将请求转发到students_list.jsp页面
			request.getRequestDispatcher("/admin/scorelist.jsp").forward(request, response);//跳转到success.jsp页面
		
	}
	
	
	private void findAll(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException {
		String sname=request.getParameter("sname");
		String key="%%";
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
		int totalCount=Integer.parseInt(scoreService.findCount(key).get(0).get("count(sid)").toString());
		System.out.println("totalCount-----------"+totalCount);
		Page page=new Page();
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setCurrPage(currPage);
		request.setAttribute("page", page);
		 List<Map<String,Object>> list=scoreService.findAll(key,index,pageSize);
		//1.获取学生列表，调用Service的findAll方法2.将获取的新闻列表保存到request中
		request.setAttribute("list", list);
		System.out.println("Scorelist------------"+list);
		//3.将请求转发到students_list.jsp页面
		request.getRequestDispatcher("student/scorelist.jsp").forward(request, response);//跳转到success.jsp页面
	}

	private void updatescore_before(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id1=request.getParameter("sid");
		int sid=Integer.parseInt(id1);
		List<Map<String, Object>> list=scoreService.findbyscore(sid);
		System.out.println(list);
		HttpSession session=request.getSession();
		session.setAttribute("list",list);//session.setAttribute(String name,Object value);	名  对象
		response.sendRedirect(request.getContextPath()+"/teacher/update_score.jsp");//项目路径
	
	  }
	private void admin_updatescore_before(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id1=request.getParameter("sid");
		int sid=Integer.parseInt(id1);
		List<Map<String, Object>> list=scoreService.findbyscore(sid);
		/*System.out.println("list-------"+list);
		Map map = (Map)list.get(0);
		Set<String> set = map.keySet();
		for (String s:set) {
		System.out.println(s+","+map.get(s));
		}
		String str = (String)map.get(0);
		System.out.println("str-------"+str);*/
	/*	Map map = (Map)list.get(0);
		System.out.println("list.get(6)----"+map.get(6));
		request.setAttribute("list111", list.get(6));*/
		List<Map<String, Object>> list_eid=scoreService.findbyscore_eid(sid);
		request.setAttribute("list_eid",list_eid);
		List<Map<String, Object>> list_headmaster=scoreService.findbyscore_headmaster(sid);
		request.setAttribute("list_headmaster",list_headmaster);
		request.setAttribute("list",list);
		request.setAttribute("sid",sid);
		request.getRequestDispatcher("/admin/updatescore.jsp").forward(request, response);
		
	  }
	private void admin_updatescore_before_fushi(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id1=request.getParameter("sid");
		System.out.println("sid-----------"+id1);
		int sid=Integer.parseInt(id1);
		List<Map<String, Object>> list=scoreService.findbyscore_fushi(sid);
		System.out.println(list);
		HttpSession session=request.getSession();
		session.setAttribute("list",list);//session.setAttribute(String name,Object value);	名  对象
		session.setAttribute("sid",sid);
		response.sendRedirect(request.getContextPath()+"/admin/updatescore_fushi.jsp");//项目路径
		/*request.setAttribute("list", list);
		request.getRequestDispatcher("admin/update_student.jsp").forward(request, response);		*/
	  }
	
	private void viewbefore(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String sname=request.getParameter("sname");
		List<Map<String, Object>> list=scoreService.findbyId(sname);
		System.out.println(list);
		HttpSession session=request.getSession();
		session.setAttribute("list",list);//session.setAttribute(String name,Object value);	名  对象
		response.sendRedirect(request.getContextPath()+"/student/viewstudent.jsp");//项目路径
		
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
