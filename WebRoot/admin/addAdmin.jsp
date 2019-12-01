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

<script src="js/layer/layer.js" type="text/javascript"></script>
<title>添加管理员</title>
</head>
<!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <script src="js/css3-mediaqueries.js"  type="text/javascript"></script>
  <![endif]-->
<body>
${msg}
<div class="margin add_administrator" id="page_style">
    <div class="add_style add_administrator_style" style="width:100%;margin:0 auto;" >
    <div class="title_name">添加管理员</div>
    <form action="../AdminServlet?action=addAdmin" method="post" id="form1">
    <input type="hidden" value="管理员"name="role"/>
     <ul>
     <li class="clearfix">
     <label class="label_name col-xs-2 col-lg-2"><i>*</i>请填写管理员姓名：</label>
     <div class="formControls col-xs-6">
     <input type="text" class="input-text col-xs-12" placeholder="请填写管理员姓名" id="adminname" name="adminname" datatype="*2-16" nullmsg="名称不能为空"/></div>
    <div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
     <li class="clearfix">
     <label class="label_name col-xs-2 col-lg-2"><i>*</i>请选择管理员性别：</label>
     <div class="formControls col-xs-6">
     <select name="sex"class="input-text col-xs-12" id="sex"class="frame_style form_error"> 
          <option value="">请选择性别</option>
           <option value="男">男</option>
          <option value="女">女</option>
          </select>
          </div>
    <div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
     <li class="clearfix">
     <label class="label_name col-xs-2 col-lg-2"><i>*</i>请填写管理员密码：</label>
     <div class="formControls col-xs-6">
     <input type="text" class="input-text col-xs-12" placeholder="请填写管理员密码" id="adminpassword" name="adminpassword" datatype="*2-16" nullmsg="名称不能为空"/></div>
    <div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
     
     
      <li class="clearfix">
      <label class="label_name col-xs-2 col-lg-2"><i class="c-red">*</i>状&nbsp;态：</label>
      <div class="formControls col-xs-6"> <span class="select-box" style="width:150px;">
				<select class="select"class="input-text col-xs-12" name="sign"id="sign" size="1">
				<option value="">请选择状态</option>
					<option value="不通过">不通过</option>
					<option value="通过">通过</option>
					
				</select>
				</span>
         </div>
     </li>
    
     
    
         <li class="clearfix">
			<div class="col-xs-2 col-lg-2">&nbsp;</div>
			<div class="col-xs-6">
	  <input class="btn button_btn bg-deep-blue " type="button" onclick="check()" id="Add_Administrator" value="提交注册"/>
      <input name="reset" type="reset" class="btn button_btn btn-gray" value="取消重置" />
     
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
  if(adminname.value==""){
      alert("请输入管理员姓名");
      adminname.focus();
      return;
   }if(sex.value==""){
      alert("请选择性别");
      sex.focus();
      return;
   }
   if(adminpassword.value==""){
      alert("请输入管理员密码");
      adminpassword.focus();
      return;
   }if(sign.value==""){
      alert("请选择状态");
      sign.focus();
      return;
   }
   return document.getElementById("form1").submit();
 }
</script>