package com.zy.user.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.zy.user.domain.Score;
import com.zy.user.service.ScoreService;

public class UploadHandleServlet extends HttpServlet {

	ScoreService scoreService=new ScoreService();
	 private Score t = null;
	public UploadHandleServlet() {
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
		if(action.equals("inportTitles")){
			String headmaster=request.getParameter("headmaster");
			inportTitles(headmaster,request,response);
		}
		else if(action.equals("admin_inportTitles")){
			String headmaster=request.getParameter("headmaster");
			admin_inportTitles(headmaster,request,response);
		}

	}


	/**
     * 通过导入excel文件，读出每个单元格的内容。
     * InputStream来自于文件上传时的MultipartFile对象
     */
	  /**
     * 导入文件
     */
    private void inportTitles(String headmaster,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		
    	String territoryIds1 = null;
        response.setContentType("text/html;charset=UTF-8");
        try {
            FileItemFactory factory = new DiskFileItemFactory();
            //文件上传核心工具类
            ServletFileUpload upload = new ServletFileUpload(factory);
            //单个文件大小限制
            upload.setFileSizeMax(10 * 1024 * 1024);
            //总文件大小限制
            upload.setSizeMax(50 * 1024 * 1024);
            //对中文编码处理
            upload.setHeaderEncoding("UTF-8");

            if (ServletFileUpload.isMultipartContent(request)) {
                List<FileItem> list = upload.parseRequest(request);
                //遍历
                for (FileItem item : list) {
                	
                    String name = item.getFieldName(); // 获取name属性的值（必须要写的，当前端的表单有text类型的数据时候），就这样获取表单的元素
                    String value = item.getString("utf-8"); // 获取value属性的值
                    if (name.equals("territory")) {
                        territoryIds1 = value;
                     
                    }
                    if (!item.isFormField()) {
                    	int territoryIds=Integer.parseInt(territoryIds1);
                    	readXls(territoryIds,headmaster,item.getInputStream(), request, response);
                    }
                   
                }
            }
        } catch (Exception e) {
        	request.setAttribute("msg", "<script>alert('请检查各科成绩是否为空！')</script>");
          	request.getRequestDispatcher("ScoreServlet?action=tea_findAllScore&headmaster="+headmaster).forward(request, response);
		}

 }
    private void admin_inportTitles(String headmaster,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		
    	String territoryIds1 = null;
        response.setContentType("text/html;charset=UTF-8");
        try {
            FileItemFactory factory = new DiskFileItemFactory();
            //文件上传核心工具类
            ServletFileUpload upload = new ServletFileUpload(factory);
            //单个文件大小限制
            upload.setFileSizeMax(10 * 1024 * 1024);
            //总文件大小限制
            upload.setSizeMax(50 * 1024 * 1024);
            //对中文编码处理
            upload.setHeaderEncoding("UTF-8");

            if (ServletFileUpload.isMultipartContent(request)) {
                List<FileItem> list = upload.parseRequest(request);
               /* SYSTEM.OUT.PRINTLN("LIST---------"+LIST);*/
                //遍历
                for (FileItem item : list) {
                    String name = item.getFieldName(); // 获取name属性的值（必须要写的，当前端的表单有text类型的数据时候），就这样获取表单的元素
                    String value = item.getString("utf-8"); // 获取value属性的值
                    if (name.equals("territory")) {
                        territoryIds1 = value;
                     
                    }
                    if (name.equals("headmaster")) {
                    	headmaster = value;
                    }
                    if (!item.isFormField()) {
                        //读取文件
                    	int territoryIds=Integer.parseInt(territoryIds1);
                    	  admin_readXls(territoryIds,headmaster,item.getInputStream(), request, response);
                    }
                }
            }
        } catch (Exception e) {
        	 request.setAttribute("msg", "<script>alert('请检查文件Sheet表内容是否为空！')</script>");
         	request.getRequestDispatcher("ScoreServlet?action=adm_findAllScore").forward(request, response);
        }

 }
  
 
    public void admin_readXls(int territoryIds,String headmaster,InputStream path,HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Score> scoreList = new ArrayList<>();
        HttpSession session =request.getSession();
        session.setAttribute("scoreList", scoreList);
        XSSFWorkbook hssfWorkbook = new XSSFWorkbook(path);
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            System.out.println("总列数:"+hssfSheet.getRow(numSheet).getLastCellNum()+ ",总行数:"  + hssfSheet.getLastRowNum());
           /* if (hssfSheet == null) {
                continue;
            }*/
            // 循环行Row
            for (int rowNum = 1; rowNum <=hssfSheet.getLastRowNum(); rowNum++) {
            	
                XSSFRow hssfRow = hssfSheet.getRow(rowNum);
                /*System.out.println("hssfRow----------"+hssfRow);*/
                if (hssfRow != null) {
                    t = new Score();
                    XSSFCell sname1 = hssfRow.getCell(0);
                    sname1.setCellType(CellType.STRING);
                    String sname=sname1.getStringCellValue();
                    
                    XSSFCell chinese1 = hssfRow.getCell(1);
                    chinese1.setCellType(CellType.STRING);
                    String chinese2=chinese1.getStringCellValue();
                    double chinese=Double.parseDouble(chinese2);
                    
                    XSSFCell math1 = hssfRow.getCell(2);
                    math1.setCellType(CellType.STRING);
                    String math2=math1.getStringCellValue();
                    double math=Double.parseDouble(math2);
                    
                    XSSFCell english1 = hssfRow.getCell(3);
                    english1.setCellType(CellType.STRING);
                    String english2=english1.getStringCellValue();
                    double english=Double.parseDouble(english2);
                    
                    XSSFCell physics1 = hssfRow.getCell(4);
                    physics1.setCellType(CellType.STRING);
                    String physics2=physics1.getStringCellValue();
                    double physics=Double.parseDouble(physics2);
                    
                    XSSFCell chemistry1 = hssfRow.getCell(5);
                    chemistry1.setCellType(CellType.STRING);
                    String chemistry2=chemistry1.getStringCellValue();
                    double chemistry=Double.parseDouble(chemistry2);
                    
                    XSSFCell politics1 = hssfRow.getCell(6);
                    politics1.setCellType(CellType.STRING);
                    String politics2=politics1.getStringCellValue();
                    double politics=Double.parseDouble(politics2);
                    
                    XSSFCell history1 = hssfRow.getCell(7);
                    history1.setCellType(CellType.STRING);
                    String history2=history1.getStringCellValue();
                    double history=Double.parseDouble(history2);
                    
                    XSSFCell geography1 = hssfRow.getCell(8);
                    geography1.setCellType(CellType.STRING);
                    String geography2=geography1.getStringCellValue();
                    double geography=Double.parseDouble(geography2);
                    
                    XSSFCell biology1 = hssfRow.getCell(9);
                    biology1.setCellType(CellType.STRING);
                    String biology2=biology1.getStringCellValue();
                    double biology=Double.parseDouble(biology2);
                    double sum1=chinese+math+english+physics+chemistry+
            				politics+history+geography+biology;
            		/*int sum=(int) (sum1);*/
            		DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
            		String sum=decimalFormat.format(sum1);
            		double sum2=Double.parseDouble(sum);
            		double avg1=sum1/9.0f;
                    String avg=decimalFormat.format(avg1);//format 返回的是字符串
                    t.setSname(sname);
                    t.setChinese(chinese);
                    t.setMath(math);
                    t.setEnglish(english);
                    t.setPhysics(physics);
                    t.setChemistry(chemistry);
                    t.setPolitics(politics);
                    t.setHistory(history);
                    t.setGeography(geography);
                    t.setBiology(biology);
                    t.setSum(sum2);
                    t.setAvg(avg);
                    t.setHeadmaster(headmaster);
                 
                    t.setEid(territoryIds);
                
                    scoreList.add(t);
                
                }
               
            }

            //区域排名
            Collections.sort(scoreList);

            for (int i = 0; i <scoreList.size(); i++) {
                scoreList.get(i).setRegionalranking(i+1+"");
                System.out.println("score--------"+scoreList.get(i));
                scoreService.addscore(scoreList.get(i));
            }
            //总排名
            List<Score> listAll = scoreService.findByEid(scoreList.get(0).getEid());
            Collections.sort(listAll);
            for (int i = 0; i <listAll.size(); i++) {
                listAll.get(i).setProvincialranking(i+1+"");
                scoreService.updateProvincialranking(listAll.get(i));
            }
            	   request.setAttribute("msg", "<script>alert('文件导入成功')</script>");
            	   request.getRequestDispatcher("/ScoreServlet?action=adm_findAllScore").forward(request, response);
            	   return; 
            
           
        }
        
    
    }
    
    public void readXls(int territoryIds,String headmaster,InputStream path,HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Score> scoreList = new ArrayList<>();
        XSSFWorkbook hssfWorkbook = new XSSFWorkbook(path);
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            System.out.println("总列数:"+hssfSheet.getRow(numSheet).getLastCellNum()+ ",总行数:"  + hssfSheet.getLastRowNum());
            // 循环行Row
            for (int rowNum = 1; rowNum <=hssfSheet.getLastRowNum(); rowNum++) {
            	
                XSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if(hssfRow==null){
                	 request.setAttribute("msg", "<script>alert('请检查各科成绩是否为空！')</script>");
                 	request.getRequestDispatcher("ScoreServlet?action=tea_findAllScore&headmaster="+headmaster).forward(request, response);
                }
                if (hssfRow != null) {
                    t = new Score();
                    XSSFCell sname1 = hssfRow.getCell(0);
                    sname1.setCellType(CellType.STRING);
                    String sname=sname1.getStringCellValue();
                    
                    XSSFCell chinese1 = hssfRow.getCell(1);
                    chinese1.setCellType(CellType.STRING);
                    String chinese2=chinese1.getStringCellValue();
                    double chinese=Double.parseDouble(chinese2);
                    
                    XSSFCell math1 = hssfRow.getCell(2);
                    math1.setCellType(CellType.STRING);
                    String math2=math1.getStringCellValue();
                    double math=Double.parseDouble(math2);
                    
                    XSSFCell english1 = hssfRow.getCell(3);
                    english1.setCellType(CellType.STRING);
                    String english2=english1.getStringCellValue();
                    double english=Double.parseDouble(english2);
                    
                    XSSFCell physics1 = hssfRow.getCell(4);
                    physics1.setCellType(CellType.STRING);
                    String physics2=physics1.getStringCellValue();
                    double physics=Double.parseDouble(physics2);
                    
                    XSSFCell chemistry1 = hssfRow.getCell(5);
                    chemistry1.setCellType(CellType.STRING);
                    String chemistry2=chemistry1.getStringCellValue();
                    double chemistry=Double.parseDouble(chemistry2);
                    
                    XSSFCell politics1 = hssfRow.getCell(6);
                    politics1.setCellType(CellType.STRING);
                    String politics2=politics1.getStringCellValue();
                    double politics=Double.parseDouble(politics2);
                    
                    XSSFCell history1 = hssfRow.getCell(7);
                    history1.setCellType(CellType.STRING);
                    String history2=history1.getStringCellValue();
                    double history=Double.parseDouble(history2);
                    
                    XSSFCell geography1 = hssfRow.getCell(8);
                    geography1.setCellType(CellType.STRING);
                    String geography2=geography1.getStringCellValue();
                    double geography=Double.parseDouble(geography2);
                    
                    XSSFCell biology1 = hssfRow.getCell(9);
                    biology1.setCellType(CellType.STRING);
                    String biology2=biology1.getStringCellValue();
                    double biology=Double.parseDouble(biology2);
                    
                  /*  int sum=Integer.parseInt(chinese1.getStringCellValue())+Integer.parseInt(math1.getStringCellValue())+
                    		Integer.parseInt(english1.getStringCellValue())+Integer.parseInt(physics1.getStringCellValue())+
                    		Integer.parseInt(chemistry1.getStringCellValue())+Integer.parseInt(politics1.getStringCellValue())+
                    		Integer.parseInt(history1.getStringCellValue())+Integer.parseInt(geography1.getStringCellValue())+Integer.parseInt(biology1.getStringCellValue());              
                    float avg1=sum/9.0f;//(hssfSheet.getRow(numSheet).getLastCellNum()-2)
                    //保留两位小数
                    DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
                    String avg=decimalFormat.format(avg1);//format 返回的是字符串
*/       
                    double sum1=chinese+math+english+physics+chemistry+
            				politics+history+geography+biology;
            		/*int sum=(int) (sum1);*/
            		DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
            		String sum=decimalFormat.format(sum1);
            		double sum2=Double.parseDouble(sum);
            		double avg1=sum1/9.0f;
                    String avg=decimalFormat.format(avg1);//format 返回的是字符串
                    
                    t.setSname(sname);
                    t.setChinese(chinese);
                    t.setMath(math);
                    t.setEnglish(english);
                    t.setPhysics(physics);
                    t.setChemistry(chemistry);
                    t.setPolitics(politics);
                    t.setHistory(history);
                    t.setGeography(geography);
                    t.setBiology(biology);
                    t.setSum(sum2);
                    t.setAvg(avg);
                   
                    t.setHeadmaster(headmaster);
                    t.setEid(territoryIds);
                  
                    scoreList.add(t);
                 
                }
               
            }
            //区域排名
            Collections.sort(scoreList);

            for (int i = 0; i <scoreList.size(); i++) {
                scoreList.get(i).setRegionalranking(i+1+"");
                scoreService.addscore(scoreList.get(i));
            }
            //总排名
            List<Score> listAll = scoreService.findByEid(scoreList.get(0).getEid());
            Collections.sort(listAll);
            for (int i = 0; i <listAll.size(); i++) {
                listAll.get(i).setProvincialranking(i+1+"");
                scoreService.updateProvincialranking(listAll.get(i));
            }

            	   request.setAttribute("msg", "<script>alert('文件导入成功')</script>");
            	   request.getRequestDispatcher("/ScoreServlet?action=tea_findAllScore&headmaster="+headmaster).forward(request, response);
            	   return; 

        }
        
    
    }

	public void init() throws ServletException {
		// Put your code here
	}

}
