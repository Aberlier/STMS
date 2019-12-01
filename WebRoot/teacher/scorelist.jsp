<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

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
<title>管理员列表</title>
</head>

<body style="width:1500px;">
${msg}
<div class="margin Competence_style" id="page_style">
    <div class="operation clearfix">
<!-- <button class="btn button_btn btn-danger" type="button" onclick=""><i class="fa fa-trash-o"></i>&nbsp;删除</button> -->
 <!--  <form action="ScoreServlet?action=tea_find_examClass" method="post"> -->
    <select class="select Competence_sort" name="admin-role" size="1" id="Competence_sort">
					<option value="0">显示全部</option>
					<c:forEach items="${list3}" var="record">
					<option value="${record.eid}">${record.ename}</option>
					</c:forEach>
				</select>
<!--   </form>	 -->
<div style="margin-left:20%;">
<form action="${pageContext.request.contextPath}/UploadHandleServlet?action=inportTitles&headmaster=${headmaster}" id="formFile" enctype="multipart/form-data" method="post">
                        <label >选择导入成绩所对应的考试批次：</label>                      
                            <select name="territory" id="territoryIdss" class="select Competence_sort">
                                <option >请选择考试批次</option>
									<c:forEach items="${list3}" var="record">
									<option value="${record.eid}">${record.ename}</option>
									</c:forEach>
								
                            </select>
                        <label >选择需要导入的文件：</label>
                            <input id="articleImageFile" name="f1" type="file" class="select Competence_sort"/>
                            <input type="button" class="btn button_btn btn-danger" style="margin-left:-80px" onclick="UploadFile()" value="点击导入"/>
                           
                           
                </form>
               
                </div>
      </div>
      <div align="center"><span style="color:red">特别声明：</span>导入成绩前要确保每个学生在系统当中都已注册，否则导入不成功！</br>
<div class="search clearfix">

 <form action="ScoreServlet?action=tea_find_query&headmaster=${headmaster}" name="form2" id="form2" method="post">
  <select class="select Competence_sort" name="ename" size="1" id="ename">
					<option value="">显示全部</option>
					<c:forEach items="${list3}" var="record">
					<option>
					${record.ename}
					</option>
					</c:forEach>
				</select>
  <select class="select Competence_sort" name="sname" size="1" id="sname">
					<option value="">选择学生姓名</option>
					<c:forEach items="${list2}" var="record">
					<option>
					${record.sname}
					</option>
					</c:forEach>
					
	</select>
<!-- <input id="sno" name="sno"type="text"  class="form-control col-xs-8"/> -->
  <button class="btn button_btn bg-deep-blue" style="margin:0 auto" onclick="chaxun()"  type="button"><i class="fa  fa-search"></i>&nbsp;搜索</button>
   </form>
 
</div>

  </br>
<form action="<c:url value='/ScoreServlet'/>" method="post">
<div class="compete_list" >
			 <table id="sample_table" class="table table_list table_striped table-bordered dataTable no-footer" >
		 <thead>
			<tr>
			
			  <th>成绩编号</th>
			  <th>学生姓名</th>
			  <th>性别</th>
			  <th>考试批次</th>
			  <th>语文</th>
			  <th>数学</th>
			  <th>英语</th>
			  <th>物理</th>
			  <th>化学</th>
			  <th>政治</th>
			  <th>历史</th>
			  <th>地理</th>
			  <th>生物</th>
			  <th>平均成绩</th>
			  <th>总成绩</th>
			  <th>取得奖别</th>
			  <th>辅导机构</th>
			  <th>区域排名</th>
			  <th>全省排名</th>      
			  <th class="hidden-480">操作</th>
             </tr>
		    </thead>
		    
				<tbody>
				<c:forEach items="${list}" var="record" >
					<tr>
					<!-- <td class="center"><label><input type="checkbox" class="ace"/><span class="lbl"></span></label></td> -->
						<td>${record.sid}</td>
						<td>${record.sname}</td>
						<td>${record.sex}</td>
						<td>${record.ename}</td>
						<td>${record.chinese}</td>
						<td>${record.math}</td>
						<td>${record.english}</td>
						<td>${record.physics}</td>
						<td>${record.chemistry}</td>
						<td>${record.politics}</td>
						<td>${record.history}</td>
						<td>${record.geography}</td>
						<td>${record.biology}</td>
						<td>${record.avg}</td>
						<td>${record.sum}</td>
						<td class="td-manage"><c:if test="${record.award==null}"><span>暂未取得名次</span></c:if><c:if test="${record.award!=''}"><span>${record.award}</span></c:if></td>
						<td>${record.fudaoclass}</td>
						<td>${record.regionalranking}</td>
						<td>${record.provincialranking}</td>
						<td class="td-manage"><a title="编辑" onclick="myselfinfo(${record.sid})"href="javascript:;" class="btn button_btn bg-deep-blue">编辑</a></td>
					</tr>
				
					
				</c:forEach>
					  <tr >
				<td align="center" colspan="24" bgcolor="#ffffff" >	
		   	 <ul class="pagination">
			    <li <c:if test="${page.currPage eq '1'}"> class="disabled"</c:if>><a <c:if test="${page.currPage ne '1'}">href="ScoreServlet?action=tea_findAllScore&currPage=${page.currPage -1}"</c:if>>上一页</a></li>
			    <c:if test="${page.totalPage eq '0'}"><li><a href="ScoreServlet?action=tea_findAllScore&currPage=1&headmaster=${headmaster}">1</a></li></c:if>
			    <c:forEach begin="1" end="${page.totalPage }" var="var">
			    	<li <c:if test="${var eq page.currPage}"> class="active"</c:if>><a href="ScoreServlet?action=tea_findAllScore&currPage=${var}&headmaster=${headmaster}">${var}</a></li>
			    </c:forEach>
			    <li  <c:if test="${page.currPage eq page.totalPage }"> class="disabled"</c:if>><a <c:if test="${page.currPage ne page.totalPage }">href="ScoreServlet?action=tea_findAllScore&headmaster=${headmaster}&currPage=${page.currPage +1}"</c:if>>下一页</a></li>
			  </ul>	
         		</td>
			</tr>
				</tbody>
			</table>
			
		</div>
	</form>
	</div>
</body>
</html>

<script type="text/javascript">
function UploadFile(){
	var territoryIdss=document.getElementById("territoryIdss");
	if(territoryIdss.value=="请选择考试批次"||territoryIdss.value==null){
		alert("请选择考试批次！");
		territoryIdss.focus();
		return;
	}
	var articleImageFile=document.getElementById("articleImageFile");
	if(articleImageFile.value==""||articleImageFile.value==null){
		alert("请选择文件！");
		articleImageFile.focus();
		return;
	}
	document.getElementById("formFile").submit();  
}

function chaxun(){
         if(ename.value=="显示全部" || ename.value==""||sname.value=="选择学生姓名" || sname.value==""){
          alert("请选择所要查询的内容！");
         ename.focus();
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
/* //删除
function Competence_delete(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$(obj).parents("tr").find(".btn button_btn btn-danger").prepend('<a style="text-decoration:none" class="btn button_btn btn-gray" onClick="Competence_delete(this,id)" href="" title="删除">已删除</a>');
		$(obj).remove();
		layer.msg('已删除!',{icon: 5,time:1000});
	});
}
 */


	function myselfinfo(sid){
	layer.open({
		type: 2,
		area: ['60%','80%'],
		fix: false, //不固定
		maxmin: true,
		shade:0.4,
		title: '查看信息',
		//content: '<table style="text-align:center;"><th style="text-align:center;"><h5 >个人信息</h5></th><tr><td>姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名：<input type="" name="" value=""></td></tr><tr><td>联系方式：<input type="text" name="" value=""></td></tr><tr><td>所在职责：<input type="text" name="" value=""></td></tr><tr><td>所管机房：<input type="text" name="" value=""></td></tr></table>'
		content:'<%=basePath%>ScoreServlet?action=updatescore_before&sid='+sid
	});
}

/* /****复选框选中******/
$('table th input:checkbox').on('click' , function(){
					var that = this;
					$(this).closest('table').find('tr > td:first-child input:checkbox')
					.each(function(){
						this.checked = that.checked;
						$(this).closest('tr').toggleClass('selected');
					});
						
				});
				
</script>