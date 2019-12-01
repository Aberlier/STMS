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
${msg }
<div class="margin Competence_style" id="page_style">
<div class="operation clearfix">
<!-- <button class="btn button_btn btn-danger" type="button" onclick=""><i class="fa fa-trash-o"></i>&nbsp;删除</button> -->
<a href="admin/addAdmin.jsp"  class="btn button_btn bg-deep-blue" title="添加管理员"><i class="fa  fa-edit"></i>&nbsp;添加管理员</a>
  <select class="select Competence_sort" name="admin-role" size="1" id="Competence_sort">
					<option value="0">显示全部</option>
					<option value="1">女</option>
					<option value="2">男</option>
					<option value="3">YES</option>
					<option value="4">NO</option>
				</select>
   <div class="search  clearfix">
 
</div>
</div>

<form action="<c:url value='/ListServlet'/>" method="post">
<div class="compete_list">

       <table id="sample_table" class="table table_list table_striped table-bordered dataTable no-footer">
		 <thead>
			<tr>
			 <!--  <th class="center"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th> -->
			  <th>编号</th>
			  <th>姓名</th>
			  <th>密码</th>
			  <th>登录次数</th>
              <th>角色</th>
			  <th class="hidden-480">添加时间</th>  
              <th>状态</th>         
              <th width="250px"class="hidden-480">操作</th>  
             </tr>
		    </thead>
             <tbody>
            <c:forEach items="${list}" var="list">
			  <tr>
				<!-- <td class="center"><label><input type="checkbox" class="ace"/><span class="lbl"></span></label></td> -->
				<td>${list.id}</td>
				<td>${list.adminname}</td>
				<td>${list.adminpass}</td>
				<td>${list.totlogin}</td>
				<td>${list.role}</td>
				<td>${list.addtime}</td>

                 <td class="td-status"><c:if test="${list.sign=='通过'}"><span class="label label-success label-sm">YES</span></c:if><c:if test="${list.sign=='不通过'}"><span class="label label-success label-sm">NO</span></c:if></td>
				<td class="td-manage">
				<c:if test="${list.sign=='通过'}">
                 <a title="停用"  href="AdminServlet?action=stop_adm&adminname=${list.adminname}" class="btn button_btn btn-Dark-success">停用</a>
                 </c:if> 
                 <c:if test="${list.sign=='不通过'}">
                 <a title="启用"  href="AdminServlet?action=start_adm&adminname=${list.adminname}" class="btn button_btn btn-Dark-success">启用</a>
                 </c:if> 
				
				<a title="编辑" onclick="myselfinfo(${list.id})" href="javascript:;" class="btn button_btn bg-deep-blue">编辑</a>        
                 <a title="删除" href="AdminServlet?action=deleteadm&adminname=${list.adminname}"  class="btn button_btn btn-danger">删除</a></td>
			   </tr>
			  </c:forEach>
			  
			  
			  <tr >
				<td align="center" colspan="24" bgcolor="#ffffff" >	
		   	 <ul class="pagination">
			    <li <c:if test="${page.currPage eq '1'}"> class="disabled"</c:if>><a <c:if test="${page.currPage ne '1'}">href="AdminServlet?action=findAll_adm&currPage=${page.currPage -1}"</c:if>>上一页</a></li>
			    <c:if test="${page.totalPage eq '0'}"><li><a href="AdminServlet?action=findAll_adm&currPage=1">1</a></li></c:if>
			    <c:forEach begin="1" end="${page.totalPage }" var="var">
			    	<li <c:if test="${var eq page.currPage}"> class="active"</c:if>><a href="AdminServlet?action=findAll_adm&currPage=${var}">${var}</a></li>
			    </c:forEach>
			    <li  <c:if test="${page.currPage eq page.totalPage }"> class="disabled"</c:if>><a <c:if test="${page.currPage ne page.totalPage }">href="AdminServlet?action=findAll_adm&currPage=${page.currPage +1}"</c:if>>下一页</a></li>
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
         var sno=document.getElementById("sno");
         if(sno.value=="" || sno.value==null){
           alert("请输入要查询的学号！");
         sno.focus();
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
		content:'<%=basePath%>AdminServlet?action=update_admin_before&id='+id
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
