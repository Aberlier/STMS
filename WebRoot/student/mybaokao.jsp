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
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
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
<!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <script src="js/css3-mediaqueries.js"  type="text/javascript"></script>
  <![endif]-->
<body>
${msg}
<div class="margin Competence_style" id="page_style">
    <div class="operation clearfix">
<!-- <button class="btn button_btn btn-danger" type="button" onclick=""><i class="fa fa-trash-o"></i>&nbsp;删除</button> -->
<!-- <a href="admin/add_student.jsp"  class="btn button_btn bg-deep-blue" title="添加学生"><i class="fa  fa-edit"></i>&nbsp;添加学生</a> -->
 
   <div class="search  clearfix">
 
</div>
</div>
	<div align="center"><span style="color:red">特别声明：</span>凡[状态]显示 <span class="label label-success label-sm">NO</span> 是没有经过管理员审核的报考信息，请第一时间联系管理员进行审核，审核后显示 <span class="label label-success label-sm">YES</span></div></br>
<form action="<c:url value='/ListServlet'/>" method="post">
<div class="compete_list"style="width: 100%;overflow-x:scroll;">

       <table id="sample_table" class="table table_list table_striped table-bordered dataTable no-footer"style="width:1700px">
		 <thead>
			<tr>
			 <!--  <th class="center"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th> -->
			  <th>编号</th>
			  <th>报考年级</th>
			  <th>学校</th>
			  <th>户籍所在地</th>
              <th>所在学校</th>
              <th>培训机构</th>
              <th>辅导教师</th>
              <th>家长姓名</th>
              <th>家长电话</th>
              <th>意向院校1</th>
              <th>意向院校2</th>
			  <th class="hidden-480">注册时间</th>  
              <th>教师提交状态</th>
              <th>管理员审核状态</th>      
			 <!--  <th class="hidden-480">操作</th> -->
             </tr>
		    </thead>
             <tbody>
            <c:forEach items="${list}" var="record">
			  <tr>
				<!-- <td class="center"><label><input type="checkbox" class="ace"/><span class="lbl"></span></label></td> -->
				<td>${record.id}</td>
				<td>${record.classname}</td>
				<td>${record.school}</td>
				<td>${record.place}</td>
				<td>${record.school2}</td>
				<td>${record.fudaoclass}</td>
				<td>${record.fudaoteacher}</td>
				<td>${record.parentsname}</td>
				<td>${record.parentstel}</td>
				<td>${record.intentionalschool}</td>
				<td>${record.school2}</td>
				<td >${record.baokaotime}</td>
 				<td class="td-status"><c:if test="${record.teasingle=='已提交'}"><span class="label label-success label-sm">YES</span></c:if><c:if test="${record.teasingle=='未提交'}"><span class="label label-success label-sm">NO</span></c:if></td>
                <td class="td-status"><c:if test="${record.adminsingle=='已审核'}"><span class="btn button_btn btn-danger">YES</span></c:if><c:if test="${record.adminsingle=='未审核'}"><span class="btn button_btn btn-danger" >NO</span></c:if></td>
                
				<%-- <td class="td-manage">
				
                 <a title="编辑"onclick="myselfinfo(${record.id})"href="javascript:;" class="btn button_btn bg-deep-blue">编辑</a>        
                 <a title="删除" onclick="Competence_delete(this,'12')"href="ExaminationServlet?action=delete&id=${record.id}" onclick="Competence_del(this,'1')" class="btn button_btn btn-danger">删除</a>
                 
				</td> --%>
			   </tr>
			  </c:forEach>
			  <tr >
				<td align="center" colspan="18" bgcolor="#ffffff" >	
		   	 <ul class="pagination">
			    <li <c:if test="${page.currPage eq '1'}"> class="disabled"</c:if>><a <c:if test="${page.currPage ne '1'}">href="ExaminationServlet?action=findAll&currPage=${page.currPage -1}"</c:if>>上一页</a></li>
			    <c:if test="${page.totalPage eq '0'}"><li> class="active"<a href="ExaminationServlet?action=findAll&currPage=1">1</a></li></c:if>
			    <c:forEach begin="1" end="${page.totalPage }" var="var">
			    	<li <c:if test="${var eq page.currPage}"> class="active"</c:if>><a href="ExaminationServlet?action=findAll&currPage=${var}">${var}</a></li>
			    </c:forEach>
			    <li  <c:if test="${page.currPage eq page.totalPage }"> class="disabled"</c:if>><a <c:if test="${page.currPage ne page.totalPage }">href="ExaminationServlet?action=findAll&currPage=${page.currPage +1}"</c:if>>下一页</a></li>
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
function chaxun(){
         var ename=document.getElementById("ename");
          var sname=document.getElementById("sname");
         if(ename.value=="显示全部" || ename.value==null){
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


	function myselfinfo(id){
	layer.open({
		type: 2,
		area: ['850px','500px'],
		fix: false, //不固定
		maxmin: true,
		shade:0.4,
		title: '查看信息',
		//content: '<table style="text-align:center;"><th style="text-align:center;"><h5 >个人信息</h5></th><tr><td>姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名：<input type="" name="" value=""></td></tr><tr><td>联系方式：<input type="text" name="" value=""></td></tr><tr><td>所在职责：<input type="text" name="" value=""></td></tr><tr><td>所管机房：<input type="text" name="" value=""></td></tr></table>'
		content:'<%=basePath%>ExaminationServlet?action=update_baokao_before&id='+id
	});
}

<%-- function award_myselfinfo(sid){
	layer.open({
		type: 2,
		area: ['600px','400px'],
		fix: false, //不固定
		maxmin: true,
		shade:0.4,
		title: '查看信息',
		//content: '<table style="text-align:center;"><th style="text-align:center;"><h5 >个人信息</h5></th><tr><td>姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名：<input type="" name="" value=""></td></tr><tr><td>联系方式：<input type="text" name="" value=""></td></tr><tr><td>所在职责：<input type="text" name="" value=""></td></tr><tr><td>所管机房：<input type="text" name="" value=""></td></tr></table>'
		content:'<%=basePath%>ExaminationServlet?action=admin_addaward_before&sid='+sid
	});
} --%>
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
