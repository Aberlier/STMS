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
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script src="js/shopFrame.js" type="text/javascript"></script>
<script src="js/Sellerber.js" type="text/javascript"></script>
<script src="js/layer/layer.js" type="text/javascript"></script>
<script src="js/common.js" type="text/javascript"></script>
<script src="js/html5shiv.js" type="text/javascript"></script>
<script src="js/respond.min.js"></script>
<script src="js/css3-mediaqueries.js"  type="text/javascript"></script>
<title>公告管理</title>
</head>
<body>
<div class="margin" id="page_style">
 <div class="Single_page">
  <div class="Prompt"><b>提示：</b>本页面所提示内容都为校级真实活动内容，如有请假请联系相关辅导员。</div>
  
  <div class="Single_page_list margin-sx">
    <ul>
    <c:forEach items="${list}" var="var">
     <li class="page_list_content">
     <a href="#" class="link_name"></a>
     <a href="javascript:if(confirm('确定要删除吗？')) location='<c:url value="FormServlet?id=${var.id}&action=delete"/>'" class="page_delete fa fa-times display"></a>
     <a onclick="myselfinfo(${var.id})" href="javascript:;" class="page_modify fa fa-edit display"></a>
       <div class="title_name">${var.title}</div>
         <div style="text-align: center;margin-top: 20%"><a onclick="show(${var.id})" class="btn bg-green operation_btn">查看公告详情</a></div>
       <div class="time">${var.informdata}</div>
         <input type="hidden" id="${var.id}" value="${var.content}"/>
     </li>
     </c:forEach>
    </ul>  
  </div>
 </div>
</div>
</body>
</html>
<script>
//设置框架
 $(function() { 
	$("#page_style").frame({
		hover_btn:'.Single_page_list li',
		menu_nav:'.operation',
		minStatue : false,
	});
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
		area: ['600px','400px'],
		fix: false, //不固定
		maxmin: true,
		shade:0.4,
		title: '查看信息',
		//content: '<table style="text-align:center;"><th style="text-align:center;"><h5 >个人信息</h5></th><tr><td>姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名：<input type="" name="" value=""></td></tr><tr><td>联系方式：<input type="text" name="" value=""></td></tr><tr><td>所在职责：<input type="text" name="" value=""></td></tr><tr><td>所管机房：<input type="text" name="" value=""></td></tr></table>'
		content:'<%=basePath%>FormServlet?action=updatebefore&id='+id
	});
}
function show(i){
	var textcontent = $("#"+i).val();

	layer.open({
   type: 1,
	title:'详情',
	area: ['60%','80%'],
	shadeClose: true,
    content:'<div style="padding: 20px;" class="page_info">'+textcontent+'</div>',
/* 	btn:['确认修改'], */
});
}



</script>
