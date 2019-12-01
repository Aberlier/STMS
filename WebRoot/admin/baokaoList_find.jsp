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

<body style="width:1500px;">
<div class="margin Competence_style" id="page_style">
<div class="operation clearfix">
<a href="teacher/add_baokao.jsp?headmaster=${headmaster}"  class="btn button_btn bg-deep-blue" title="添加报考"><i class="fa  fa-edit"></i>&nbsp;添加报考</a>
  <select class="select Competence_sort" name="admin-role" size="1" id="Competence_sort">
					<option value="0">显示全部</option>
					<option value="3">YES</option>
					<option value="4">NO</option>
				</select>
   <div class="search  clearfix">
  <form action="StudentServlet?action=findBaoKaobyName&role=${role}" name="form2" id="form2" method="post">
   <input id="sname" name="sname"type="text" placeholder="请输入报考学生姓名！" class="form-control col-xs-8"/><button class="btn button_btn bg-deep-blue " onclick="chaxun()"  type="button"><i class="fa  fa-search"></i>&nbsp;搜索</button>
   </form>
</div>
</div>
<div align="center"><span style="color:red">特别声明：</span>凡[状态]显示 <span class="label label-success label-sm">NO</span> 是没有经过管理员审核的报考信息，请第一时间联系管理员进行审核，审核后显示 <span class="label label-success label-sm">YES</span></div></br>
<form action="<c:url value='/ListServlet'/>" method="post">
<div class="compete_list">

       <table id="sample_table" class="table table_list table_striped table-bordered dataTable no-footer">
		 <thead>
			<tr>
			 
			  <th>编号</th>
			  <th>年级</th>
			  <th>学生姓名</th>
			  <th>学校</th>
              <th>出生地</th>
              <th>所在学校</th>
              <th>辅导机构</th>
              <th>辅导教师</th>
              <th>家长姓名</th>
              <th>家长电话</th>
              <th>意向学校</th>
              
              <th>教师提交状态</th>
              <th>管理员审核状态</th>         
              <th class="hidden-480">操作</th>  
             </tr>
		    </thead>
             <tbody>
            <c:forEach items="${list}" var="list">
			  <tr>
				
				<td>${list.id}</td>
				<td>${list.myclass}</td>
				<td>${list.sname}</td>
				<td>${list.school}</td>
				<td>${list.place}</td>
				<td>${list.school2}</td>
				<td>${list.fudaoclass}</td>
				<td>${list.fudaoteacher}</td>
				<td>${list.parentsname}</td>
				<td>${list.parentstel}</td>
				<td>${list.intentionalschool}</td>
                
                <td class="td-status"><c:if test="${list.teasingle=='已提交'}"><span class="label label-success label-sm">YES</span></c:if><c:if test="${list.teasingle=='未提交'}"><span class="label label-success label-sm">NO</span></c:if></td>
                 <td class="td-status"><c:if test="${list.adminsingle=='已审核'}"><span class="btn button_btn btn-danger">YES</span></c:if><c:if test="${list.adminsingle=='未审核'}"><span class="btn button_btn btn-danger">NO</span></c:if></td>
				<td>
				<c:if test="${list.adminsingle=='已审核'}">
                 <a title="停用"  href="StudentServlet?action=adm_stop_baokao&id=${list.id}" class="btn button_btn btn-Dark-success">取消审核</a>
                 </c:if> 
                 <c:if test="${list.adminsingle=='未审核'}">
                 <a title="启用"  href="StudentServlet?action=adm_start_baokao&id=${list.id}" class="btn button_btn btn-Dark-success">通过审核</a>
                 </c:if> 
				<a title="编辑" onclick="myselfinfo(${list.id})" href="javascript:;" class="btn button_btn bg-deep-blue">编辑</a>        
                 <a title="删除" onclick="Competence_delete(this,'12')"href="StudentServlet?action=del_baokao&sname=${list.sname}" onclick="Competence_del(this,'1')" class="btn button_btn btn-danger">删除</a>
                 </td>
			   </tr>
			  </c:forEach>
			
			  
			 <tr >
				<td align="center" colspan="17" bgcolor="#ffffff" >	
		   	 	<ul class="pagination">
			    <li <c:if test="${page.currPage eq '1'}"> class="disabled"</c:if>><a <c:if test="${page.currPage ne '1'}">href="StudentServlet?action=findBaoKaobyName&sname=${sname}&role=${role}&currPage=${page.currPage -1}"</c:if>>上一页</a></li>
			    <c:if test="${page.totalPage eq '0'}"><li> <a href="StudentServlet?action=findBaoKaobyName&sname=${sname}&role=${role}&currPage=1">1</a></li></c:if>
			    <c:forEach begin="1" end="${page.totalPage }" var="var">
			    <li <c:if test="${var eq page.currPage}"> class="active"</c:if>><a href="StudentServlet?action=findBaoKaobyName&sname=${sname}&role=${role}&currPage=${var}">${var}</a></li>
			    </c:forEach>
			    <li  <c:if test="${page.currPage eq page.totalPage }"> class="disabled"</c:if>><a <c:if test="${page.currPage ne page.totalPage }">href="StudentServlet?action=findBaoKaobyName&sname=${sname}&role=${role}&currPage=${page.currPage +1}"</c:if>>下一页</a></li>
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
<script>
function chaxun(){
         var sname=document.getElementById("sname");
         if(sname.value=="" || sname.value==null){
           alert("请输入要查询的学生姓名！");
         sname.focus();
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
		content:'<%=basePath%>StudentServlet?action=update_baokao_before&id='+id
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
