<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
<link href="css/shop.css" type="text/css" rel="stylesheet" />
<link href="css/Sellerber.css" type="text/css"  rel="stylesheet" />
<link href="css/bkg_ui.css" type="text/css"  rel="stylesheet" />
<link href="font/css/font-awesome.min.css"  rel="stylesheet" type="text/css" />
<script src="js/jquery-1.9.1.min.js" type="text/javascript" ></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script src="js/shopFrame.js" type="text/javascript"></script>
<script src="js/Sellerber.js" type="text/javascript"></script>
<script src="js/layer/layer.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/jquery.dataTables.bootstrap.js"></script>
<script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <script src="js/css3-mediaqueries.js"  type="text/javascript"></script>
<title>管理员列表</title>

</head>
<!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <script src="js/css3-mediaqueries.js"  type="text/javascript"></script>
  <![endif]-->
<body>
${msg }
<div class="margin Competence_style" id="page_style">
    <div class="operation clearfix">
<!-- <button class="btn button_btn btn-danger" type="button" onclick=""><i class="fa fa-trash-o"></i>&nbsp;删除</button> -->
<a href="javascript:history.go(-1)"  class="btn button_btn bg-deep-blue" title="返回上一页"><i class="fa  fa-edit"></i>&nbsp;返回上一页</a>
 <label style="color:red"><i class="c-red">*</i>按<span style="color:blue">条件/辅导机构</span>查询：</label> 
  <div style="margin-left:25%;margin-top:-38px;width:80%" >
   <form method="post" id="form3" name="form3" action="AdminServlet?action=teaquery"> 
   <input id="Competence_sort" name="admin_query_org"type="text" placeholder="请输入想要查询的辅导机构关键字或全名！" class="col-xs-4"/>
   <button class="btn button_btn btn-danger" onclick="query()"  type="button"><i class="fa  fa-search"></i>&nbsp;搜索</button>
   </form>	
</div>
 <div class="search  clearfix">
  <form action="StudentServlet?action=admin_findbytea" name="form2" id="form2" method="post">
   <input id="tname" name="tname"type="text" placeholder="请输入想要查询的教师姓名！" class="form-control col-xs-8"/><button class="btn button_btn bg-deep-blue " onclick="chaxun()"  type="button"><i class="fa  fa-search"></i>&nbsp;搜索</button>
   </form>
</div>
</div>
<div align="center"><span style="color:red">特别声明：</span>凡[状态]显示 <span class="label label-success label-sm">NO</span> 是没有经过管理员审核的信息，请第一时间联系管理员进行审核，审核后显示 <span class="label label-success label-sm">YES</span></div></br>

<div class="compete_list" style="width: 100%;overflow-x:scroll;">

       <table id="sample_table" class="table table_list table_striped table-bordered dataTable no-footer" style="width:1700px;">
		 <thead>
			<tr>
			  <!-- <th class="center"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th> -->
			 <th>编号</th>		
			  <th>工号</th>
			  <th>姓名</th>
			  <th>所教科目</th>
              <th>性别</th>
              <th>邮箱</th>
              <th>所属机构</th>
              <th>状态</th>         
			  <th class="hidden-480">操作</th>
             </tr>
		    </thead>
             <tbody>
            <c:forEach items="${list}" var="list">
			  <tr>
				<!-- <td class="center"><label><input type="checkbox" class="ace"/><span class="lbl"></span></label></td> -->
				<td>${list.id}</td>
				<td>${list.tno}</td>
				<td>${list.tname}</td>
				<td>${list.depart}</td>
				<td>${list.tsex}</td>
				<td>${list.temail}</td>
				<td>${list.organize}</td>
                <td class="td-status"><c:if test="${list.single=='通过'}"><span class="label label-success label-sm">已启用</span></c:if><c:if test="${list.single=='不通过'}"><span class="label label-success label-sm">未启用</span></c:if></td>
				<td class="td-manage">
				<c:if test="${list.single=='通过'}">
                  <a title="停用"  href="AdminServlet?action=stop_tea&tname=${list.tname}" class="btn button_btn btn-Dark-success">停用</a>
                 </c:if> 
                 <c:if test="${list.single=='不通过'}">
                   <a title="启用"  href="AdminServlet?action=start_tea&tname=${list.tname}" class="btn button_btn btn-Dark-success">启用</a>
                 </c:if> 
                 <a title="编辑"onclick="myselfinfo(${list.id})"href="javascript:;" class="btn button_btn bg-deep-blue">编辑</a>        
                 <a title="删除" href="AdminServlet?action=delTeacher&id=${list.id}"  class="btn button_btn btn-danger">删除</a>
                 <!-- <a title="查看" href="javascript:;" onclick="Competence_View(this,'1')" class="btn button_btn btn-green">查看</a> -->
				</td>
			   </tr>
			  </c:forEach>
			  <tr >
				<td align="center" colspan="10" bgcolor="#ffffff" >	
		    <ul class="pagination">
			    <li <c:if test="${page.currPage eq '1'}"> class="disabled"</c:if>><a <c:if test="${page.currPage ne '1'}">href="StudentServlet?action=admin_findbytea&tname=${tname}&currPage=${page.currPage -1}"</c:if>>上一页</a></li>
			    <c:if test="${page.totalPage eq '0'}"><li> <!-- class="active" --><a href="StudentServlet?action=admin_findbytea&tname=${tname}&currPage=1">1</a></li></c:if>
			    <c:forEach begin="1" end="${page.totalPage }" var="var">
			    	<li <c:if test="${var eq page.currPage}"> class="active"</c:if>><a href="StudentServlet?action=admin_findbytea&tname=${tname}&currPage=${var}">${var}</a></li>
			    </c:forEach>
			    <li  <c:if test="${page.currPage eq page.totalPage }"> class="disabled"</c:if>><a <c:if test="${page.currPage ne page.totalPage }">href="StudentServlet?action=admin_findbytea&tname=&{tname}&currPage=${page.currPage +1}"</c:if>>下一页</a></li>
			  </ul>
			
         </td>
				
				</tr>
		      </tbody>
	        </table>
	        
     </div>
</div>

</body>
</html>
<script>
function query(){
         var Competence_sort=document.getElementById("Competence_sort");
         if(Competence_sort.value==""){
         alert("请输入所要查询的辅导机构！");
         Competence_sort.focus();
         return;
      }	
   document.getElementById("form3").submit();  
 }
function chaxun(){
         var tname=document.getElementById("tname");
         if(tname.value=="" || tname.value==null){
           alert("请输入要查询的教师姓名！");
         tname.focus();
         return;
      }	
   document.getElementById("form2").submit();  
 }
$(function(){
	$("#Competence_sort").click(function(){
		var option=$(this).find("option:selected").text();
		var value=$(this).val();
		if(value==0){
			  
			$("#sample_table tbody tr").show()
			}
			else{
		$("#sample_table tbody tr").hide().filter(":contains('"+(option)+"')").show();	
			}
		}).click();	
	});

/*******滚动条*******/
$("body").niceScroll({  
	cursorcolor:"#888888",  
	cursoropacitymax:1,  
	touchbehavior:false,  
	cursorwidth:"5px",  
	cursorborder:"0",  
	cursorborderradius:"5px"  
});

	function myselfinfo(id){
	layer.open({
		type: 2,
		 area: ['60%','80%'],
		fix: false, //不固定
		maxmin: true,
		shade:0.4,
		title: '查看信息',
		//content: '<table style="text-align:center;"><th style="text-align:center;"><h5 >个人信息</h5></th><tr><td>姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名：<input type="" name="" value=""></td></tr><tr><td>联系方式：<input type="text" name="" value=""></td></tr><tr><td>所在职责：<input type="text" name="" value=""></td></tr><tr><td>所管机房：<input type="text" name="" value=""></td></tr></table>'
		content:'<%=basePath%>TeacherServlet?action=updatebefore&id='+id
	});
}
/****复选框选中******/
$('table th input:checkbox').on('click' , function(){
					var that = this;
					$(this).closest('table').find('tr > td:first-child input:checkbox')
					.each(function(){
						this.checked = that.checked;
						$(this).closest('tr').toggleClass('selected');
					});
						
				});
</script>
