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
 <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <script src="js/css3-mediaqueries.js"  type="text/javascript"></script>
<title>添加教师</title>
</head>
<body>
${msg}
<center>
<div class="margin add_administrator" id="page_style">
    <div class="add_style add_administrator_style"style="width: 100%;overflow:auto;">
     <div class="title_name">添加教师</div>
     <form action="AdminServlet?action=addtea" method="post" name="form1" id="form1" >
     <input type="hidden" name="role" value="教师" />
        <input type="hidden" name="single" value="不通过" />
    <ul >
     <li class="clearfix">
     <label class="label_name col-xs-3 col-lg-3"><i>*</i>教师姓名：</label>
     <div class="formControls col-xs-6">
     <input type="text" class="input-text col-xs-12" value="" placeholder="" id="tname" name="tname" datatype="*2-16" nullmsg="教师名不能为空"/></div>
    <div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
     <li class="clearfix">
     <label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>初始密码：</label>
	 <div class="formControls col-xs-6">
	 <input type="password" placeholder="密码" id="tpwd"name="tpwd" autocomplete="off"  class="input-text col-xs-12" datatype="*6-20" nullmsg="密码不能为空"/>
	</div>
     <div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
     <li class="clearfix">
       <label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>确认密码：</label>
       <div class="formControls  col-xs-6">
	<input type="password" placeholder="确认新密码" autocomplete="off" class="input-text Validform_error col-xs-12"  datatype="*6-20" nullmsg="请再输入一次新密码！" recheck="userpassword" id="tpwd2" name="tpwd2"/>
	</div>
	  <div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
     
     <li class="clearfix">
      <label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>性&nbsp;别：</label>
      <div class="formControls  skin-minimal col-xs-6">
            <label><input name="tsex" type="radio" id="tsex"class="ace"value="男"/><span class="lbl">男</span></label>&nbsp;&nbsp;
            <label><input name="tsex" type="radio" id="tsex"class="ace"value="女"/><span class="lbl">女</span></label>
	  </div>
     </li>
      
      
      
     <li class="clearfix">
      <label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>添加邮箱：</label>
      <div class="formControls col-xs-6"> <span class="select-box" >
	<input type="text" placeholder="请添加邮箱" autocomplete="off" class="input-text Validform_error col-xs-12"  datatype="*6-20" recheck="old" id="temail" name="temail"/>
		 </span>
         </div>
     </li>
     
      <li class="clearfix"><label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>选择教学科目：</label>
          <select name="depart"class="formControls col-xs-6" id="depart"> 
        <option value="">请选择主要教学科目</option>
           <c:forEach items="${list2}" var="list">
         <option >${list.subject}</option>
        </c:forEach>
         </select>
         <div class="col-4"> <span class="Validform_checktip"></span></div>
         </li>
     
      <li class="clearfix"><label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>选择辅导机构：</label>
        <select name="organize" class="formControls col-xs-6"id="organize"> 
        <option value="">请选择辅导机构</option>
        <c:forEach items="${list}" var="list">
         <option >${list.organizationname}</option>
        </c:forEach>
        </select>
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
</center>
</body>
</html>
<script>
function check(){
  if(tname.value==""){
      alert("请输入教师姓名");
      tname.focus();
      return;
   }if(tsex.value==""){
      alert("请选择教师性别");
      tsex.focus();
      return;
   }
   if(tpwd.value==""){
      alert("请输入密码");
      tpwd.focus();
      return;
   }
   if(tpwd2.value==""){
      alert("请再次输入密码");
      tpwd2.focus();
      return;
   }if(temail.value==""){
      alert("请填写教师邮箱！");
      temail.focus();
      return;
   } 
    if(depart.value==""){
      alert("请选择主要教学科目");
      depart.focus();
      return;
   }if(organize.value==""){
      alert("请选择辅导机构");
      organize.focus();
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