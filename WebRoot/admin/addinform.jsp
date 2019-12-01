<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<script src="js/layer/layer.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/jquery.dataTables.bootstrap.js"></script>
<script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <script src="js/css3-mediaqueries.js"  type="text/javascript"></script>
<title>添加广告</title>
</head>
<body>
<!--添加分类-->
 <form action="../FormServlet?action=addinform" method="post" name="form1" id="form1">
<input type="hidden" name="action" value="updatestu"/>
<div id="ad_sort" >
 <div class="add_style">
  <ul>
   <li class="clearfix"><label class="label_name col-xs-2">标题：&nbsp;&nbsp;</label><span class="cont_style col-xs-9"><input name="title" type="text" id="title" class="col-xs-10 col-sm-5" style="width:450px"/></span></li>
  
     
     <li class="clearfix"><label class="label_name col-xs-2">内容：&nbsp;&nbsp;</label><span class="cont_style col-xs-9"><textarea type="text"id="content" name="content" rows="10" cols="90"class="col-xs-10 col-sm-5" style="width:450px"></textarea></span></li>
    <li class="clearfix" style="margin-left:250px"><span class="cont_style col-xs-9"><input name="spwd" value="保存"type="submit" id="form-field-1" class="" />&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input name="spwd" value="重置"type="reset" id="form-field-1" class="" /></span></li>
    
<!--       
<li class="clearfix"><label class="label_name col-xs-2">描&nbsp;&nbsp;述：&nbsp;&nbsp;</label><span class="cont_style col-xs-9"><textarea name="权限描述" class="form-control col-xs-12 col-sm-5" id="form_textarea" placeholder="" onkeyup="checkLength(this);"></textarea><span class="wordage">剩余字数：<span id="sy" style="color:Red;">200</span>字</span></span></li>
 --> 
  </ul>
 </div>
</div>
</form>
</body>
</html>
<script>
/*******滚动条*******/
$("body").niceScroll({  
	cursorcolor:"#888888",  
	cursoropacitymax:1,  
	touchbehavior:false,  
	cursorwidth:"5px",  
	cursorborder:"0",  
	cursorborderradius:"5px"  
});
function check(){
  if(title.value==""){
      alert("请输入标题");
      title.focus();
      return;
   }
   if(content.value==""){
      alert("请输入内容");
      content.focus();
      return;
   }
   return document.getElementById("form1").submit();
 }
</script>
