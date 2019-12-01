<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<script type="text/javascript" src="js/Validform/Validform.min.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script src="js/shopFrame.js" type="text/javascript"></script>
<script src="js/Sellerber.js" type="text/javascript"></script>
<script src="js/layer/layer.js" type="text/javascript"></script>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <script src="js/css3-mediaqueries.js"  type="text/javascript"></script>
<title>添加考试</title>
</head>
<!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <script src="js/css3-mediaqueries.js"  type="text/javascript"></script>
  <![endif]-->
<body>
${msg}
<div class="margin add_administrator" id="page_style">
    <div class="add_style add_administrator_style" style="width: 100%;overflow:auto;">
    <div class="title_name">填写考试信息</div>
    <form action="ExaminationServlet?action=addExam&adminname=${adminname}" method="post" id="form1">
     <input  type="hidden" name="examclass" value="1"/>
     <ul>
     <li class="clearfix">
     <label class="label_name col-xs-2 col-lg-2"><i>*</i>请填写考试名称：</label>
     <div class="formControls col-xs-6">
     <input type="text" class="input-text col-xs-6" placeholder="请填写考试名称" id="ename" name="ename" datatype="*2-16" nullmsg="名称不能为空"/></div>
    <div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
     
     
    <li class="clearfix">
			<label class="label_name col-xs-2 col-lg-2">报名&nbsp;时间	：</label>
			<div class="formControls col-xs-6">
				<input type="date"class="input-text col-xs-6" name="signuptime" id="signuptime"/>
			</div>
	</li>
	<li class="clearfix">
			<label class="label_name col-xs-2 col-lg-2">考试&nbsp;时间	：</label>
			<div class="formControls col-xs-6">
				<input type="date" name="examtime" class="input-text col-xs-6" id="examtime"/>
			</div>
	</li>
	<li class="clearfix">
			<label class="label_name col-xs-2 col-lg-2">报名截止&nbsp;时间	：</label>
			<div class="formControls col-xs-6">
				<input type="date" name="signdowntime" class="input-text col-xs-6" id="signdowntime"/>
			</div>
	</li>
	
         <li class="clearfix">
			<div class="col-xs-2 col-lg-2">&nbsp;</div>
			<div class="col-xs-6">
	  <input class="btn button_btn bg-deep-blue " onclick="check()"type="button" id="Add_Administrator" value="提交"/>
      <input name="reset" type="reset" class="btn button_btn btn-gray" value="取消重置"/>
			</div>
		</li>
    </ul>
    </form>
    </div>
    <div class="split_line"></div>
    <div class="Notice_style l_f">
      
    </div>
</div>
</body>
</html>
<script>
$("body").niceScroll({  
	cursorcolor:"#888888",  
	cursoropacitymax:1,  
	touchbehavior:false,  
	cursorwidth:"5px",  
	cursorborder:"0",  
	cursorborderradius:"5px"  
});
function check(){
  if(ename.value==""){
      alert("请输入考试名称");
      ename.focus();
      return;
   }
   if(signuptime.value==""){
      alert("请选择学生注册时间");
      signuptime.focus();
      return;
   }if(examtime.value==""){
      alert("请选择考试时间");
      examtime.focus();
      return;
   }if(signdowntime.value==""){
      alert("请选择注册停止时间");
      signdowntime.focus();
      return;
   }
         
   return document.getElementById("form1").submit();
 }
</script>