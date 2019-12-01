<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>添加学生</title>
</head>
<!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <script src="js/css3-mediaqueries.js"  type="text/javascript"></script>
  <![endif]-->
<body>
${msg}
<div class="margin add_administrator" id="page_style">
    <div class="add_style add_administrator_style"style="width: 100%;overflow:auto;">
    <div class="title_name">添加学生</div>
    <form action="AdminServlet?action=addstu" method="post" id="form1">
    <input type="hidden" name="single" value="不通过" />
    <input type="hidden" name="role" value="学生" />
    <ul >
     <li class="clearfix">
     <label class="label_name col-xs-3 col-lg-3"><i>*</i>学生姓名：</label>
     <div class="formControls col-xs-6">
     <input type="text" class="input-text col-xs-12" value="" placeholder="" id="sname" name="sname" datatype="*2-16" nullmsg="学生名不能为空"/></div>
    <div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
     <li class="clearfix">
     <label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>初始密码：</label>
	 <div class="formControls col-xs-6">
	 <input type="password" placeholder="密码" id="spwd"name="spwd" autocomplete="off"  class="input-text col-xs-12" datatype="*6-20" nullmsg="密码不能为空"/>
	</div>
     <div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
     <li class="clearfix">
       <label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>确认密码：</label>
       <div class="formControls  col-xs-6">
	<input type="password" placeholder="确认新密码" autocomplete="off" class="input-text Validform_error col-xs-12"  datatype="*6-20" nullmsg="请再输入一次新密码！" recheck="userpassword" id="newpassword2" name="newpassword2"/>
	</div>
	  <div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
     
     <li class="clearfix">
      <label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>性&nbsp;别：</label>
      <div class="formControls  skin-minimal col-xs-6">
            <label><input name="sex" type="radio" id="sex"class="ace"value="男"/><span class="lbl">男</span></label>&nbsp;&nbsp;
            <label><input name="sex" type="radio" id="sex"class="ace"value="女"/><span class="lbl">女</span></label>
	  </div>
     </li>
      
      
      
     <li class="clearfix">
      <label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>添加年龄：</label>
      <div class="formControls col-xs-6"> <span class="select-box" >
	<input type="text" placeholder="请添加年龄" autocomplete="off" class="input-text Validform_error col-xs-12"  datatype="*6-20" recheck="old" id="old" name="old"/>
		 </span>
         </div>
     </li>
     
      <li class="clearfix">
      <label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>选择班主任：</label>
      <div class="formControls col-xs-6" > <span class="select-box" >
		<select name="headmaster" id="headmaster"class="input-text Validform_error col-xs-12"> 
        <option value="">请选择班主任</option>
        <c:forEach items="${list}" var="list">
          <option >${list.tname}</option>
         </c:forEach>
         </select>
		 </span>
         </div>
     </li>
     
     <li class="clearfix">
      <label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>选择出生日期：</label>
      <div class="formControls col-xs-6">
      <input name="born" class="input-text Validform_error col-xs-12" placeholder="请选择出生日期"id="born" type="date" />
     </div>
     </li>
     <li class="clearfix">
      <label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>户籍所在地区：</label>
      <div class="formControls col-xs-6">
		<input name="place" placeholder="请输入户籍所在地" type="text" id="place"class="input-text Validform_error col-xs-12"/>
	  </div>
	 <div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
     <li class="clearfix">
      <label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>所在学校：</label>
      <div class="formControls col-xs-6">
		<input name="schoolname" placeholder="请输入您的学校名称" type="text" id="schoolname"class="input-text Validform_error col-xs-12"/>
	   </div>
		<div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
     <li class="clearfix">
     <label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>选择辅导机构：</label>
      <div class="formControls col-xs-6" > <span class="select-box" >
         <select name="fudaoclass"class="input-text Validform_error col-xs-12" id="fudaoclass"class="frame_style form_error">
           <option value="">请选择辅导机构</option>
           <c:forEach items="${list2}" var="record">
           <option >${record.organizationname}</option>
       	   </c:forEach>
         </select>${error}
         </span>
         </div>
         </li>
     <li class="clearfix">
      <label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>辅导老师：</label>
      <div class="formControls col-xs-6">
		<input name="fudaoteacher" placeholder="请输入您的辅导老师" type="text" id="fudaoteacher"class="input-text Validform_error col-xs-12"/>
	   </div>
		<div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
     <li class="clearfix">
      <label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>家长姓名：</label>
      <div class="formControls col-xs-6">
		<input name="parentsname" placeholder="请输入家长姓名" type="text" id="parentsname"class="input-text Validform_error col-xs-12"/>
	   </div>
		<div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
     <li class="clearfix">
      <label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>家长电话：</label>
      <div class="formControls col-xs-6">
		<input name="parentstel" placeholder="请输入家长联系电话" type="text" id="parentstel"class="input-text Validform_error col-xs-12"/>
	   </div>
		<div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
         <li class="clearfix">
			<div class="col-xs-3 col-lg-3">&nbsp;</div>
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
function check(){
  if(sname.value==""){
      alert("请输入学生姓名");
      sname.focus();
      return;
   }
   if(spwd.value==""){
      alert("请输入密码");
      spwd.focus();
      return;
   }
   if(newpassword2.value==""){
      alert("请再次输入密码");
      newpassword2.focus();
      return;
   }  
  
    if(sex.value==""){
      alert("请选择学生性别");
      sex.focus();
      return;
   }if(old.value==""){
      alert("请输入学生年龄");
      old.focus();
      return;
   }
if(headmaster.value==""){
      alert("请选择班主任");
      headmaster.focus();
      return;
   }  
   if(born.value==""){
      alert("请输入出生日期");
      born.focus();
      return;
   }if(place.value==""){
      alert("请输入户籍所在地");
      place.focus();
      return;
   } 
   if(schoolname.value==""){
      alert("请输入学校名称");
      schoolname.focus();
      return;
   }if(fudaoclass.value==""){
      alert("请选择辅导机构");
      fudaoclass.focus();
      return;
   }if(fudaoteacher.value==""){
      alert("请输入辅导教师");
      fudaoteacher.focus();
      return;
   }if(parentsname.value==""){
      alert("请输入家长姓名");
      parentsname.focus();
      return;
   }if(parentstel.value==""){
      alert("请输入家长电话");
      parentstel.focus();
      return;
   }          
   return document.getElementById("form1").submit();
 }
/*******滚动条*******/
$("body").niceScroll({  
	cursorcolor:"#888888",  
	cursoropacitymax:1,  
	touchbehavior:false,  
	cursorwidth:"5px",  
	cursorborder:"0",  
	cursorborderradius:"5px"  
});

//字数限制
function checkLength(which) {
	var maxChars = 100; //
	if(which.value.length > maxChars){
	   layer.open({
	   icon:2,
	   title:'提示框',
	   content:'您输入的字数超过限制!',	
    });
		// 超过限制的字数了就将 文本框中的内容按规定的字数 截取
		which.value = which.value.substring(0,maxChars);
		return false;
	}else{
		var curr = maxChars - which.value.length; //250 减去 当前输入的
		document.getElementById("sy").innerHTML = curr.toString();
		return true;
	}
};	
</script>
