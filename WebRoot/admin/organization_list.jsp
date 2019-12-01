<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
 <script src="js/laydate/laydate.js" type="text/javascript"></script>
 <script type="text/javascript" src="js/json2.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/jquery.dataTables.bootstrap.js"></script>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <script src="js/css3-mediaqueries.js"  type="text/javascript"></script>
<title>个人信息</title>
</head>
<!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <script src="js/css3-mediaqueries.js"  type="text/javascript"></script>
  <![endif]-->
<body style="width:1500px;">
${msg}
<div class="margin Competence_style" id="page_style">
<div class="operation clearfix">
<!-- <button class="btn button_btn btn-danger" type="button" onclick=""><i class="fa fa-trash-o"></i>&nbsp;删除</button> -->
<a href="admin/add_organization.jsp"  class="btn button_btn bg-deep-blue" title="添加培训机构"><i class="fa  fa-edit"></i>&nbsp;添加培训机构</a>
  
   <div class="search  clearfix">
</div>
</div>
   
<div class="compete_list">
      <table id="sample_table" class="table table_list table_striped table-bordered dataTable no-footer">
           <thead>
			<tr>
              <!-- <th width="150px"class="center"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th> -->
			  <th width="150px">编号</th>
			  <th width="150px">机构编号</th>
			  <th width="150px">机构名称</th>
              <th width="150px">负责人</th>
              <th width="150px">添加时间</th>
              <th width="150px">联系电话</th>
              <th width="150px">地址</th> 
              <th width="150px">操作</th>        
             </tr>
		    </thead>
            <tbody>
            <c:forEach items="${list}" var="list">
             <tr>
            <!--  <td class="center"><label><input type="checkbox" class="ace"/><span class="lbl"></span></label></td> -->
             <td>${list.id}</td>
             <td>${list.oid}</td>
             <td>${list.organizationname}</td>
             <td>${list.operson}</td>
             <td>${list.addtime}</td>
             <td>${list.otel}</td>
             <td>${list.oaddress}</td>
             <td>
             <a title="编辑"onclick="myselfinfo(${list.id})" href="javascript:;" class="btn button_btn bg-deep-blue">编辑</a>
          	<a title="删除"href="OrganizationServlet?action=deleteorg&id=${list.id}" class="btn button_btn bg-deep-blue">删除</a></td>
             </tr>
            </c:forEach>
            <tr >
				<td align="center" colspan="10" bgcolor="#ffffff" >	
		   	 <ul class="pagination">
			    <li <c:if test="${page.currPage eq '1'}"> class="disabled"</c:if>><a <c:if test="${page.currPage ne '1'}">href="OrganizationServlet?action=findAll&currPage=${page.currPage -1}"</c:if>>上一页</a></li>
			    <c:if test="${page.totalPage eq '0'}"><li><!--  class="active" --><a href="OrganizationServlet?action=findAll&currPage=1">1</a></li></c:if>
			    <c:forEach begin="1" end="${page.totalPage }" var="var">
			    	<li <c:if test="${var eq page.currPage}"> class="active"</c:if>><a href="OrganizationServlet?action=findAll&currPage=${var}">${var}</a></li>
			    </c:forEach>
			    <li  <c:if test="${page.currPage eq page.totalPage }"> class="disabled"</c:if>><a <c:if test="${page.currPage ne page.totalPage }">href="OrganizationServlet?action=findAll&currPage=${page.currPage +1}"</c:if>>下一页</a></li>
			  </ul>	
         		</td>
			</tr>
            </tbody>
         </table>   
         </div>
      
  </body>
</html>
<script>
 function chaxun(){
         var oid=document.getElementById("oid");
         if(oid.value=="" || oid.value==null){
           alert("请输入要查询的机构编号！");
         oid.focus();
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
		content:'<%=basePath%>OrganizationServlet?action=update_organize_before&id='+id
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

