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
<script type="text/javascript" src="js/Validform/Validform.min.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script src="js/shopFrame.js" type="text/javascript"></script>
<script src="js/Sellerber.js" type="text/javascript"></script>
<script src="js/layer/layer.js" type="text/javascript"></script>
<script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <script src="js/css3-mediaqueries.js"  type="text/javascript"></script>
<title>添加学生</title>
</head>
<body>
<center>
<div class="margin add_administrator" id="page_style">
    <div class="add_style add_administrator_style">
    <div class="title_name">添加报考</div>
    <form action="StudentServlet?action=admin_add_baokao" method="post" id="form1">
    <input type="hidden" name="teasingle" value="未提交" />
    <input type="hidden" name="adminsingle" value="未审核" />
    <ul>
    <li class="clearfix">
      <label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>请选择年级:</label>
      <div class="formControls col-xs-6"> <span class="select-box" style="width:150px;">
				<select class="select input-text col-xs-12" name="myclass" id="myclass"size="1">
					<option value="">请选择年级</option>
					<c:forEach items="${list}" var="record">
					<option>${record.classname}</option>
					</c:forEach>
				</select>
				</span>
         </div>
     </li>
     <li class="clearfix">
     <label class="label_name col-xs-3 col-lg-3"><i>*</i>学生姓名：</label>
     <div class="formControls col-xs-6">
     <input type="text" class="input-text col-xs-12" value="" placeholder="请填写学生姓名" id="sname" name="sname" datatype="*2-16" nullmsg="学生名不能为空"/></div>
    <div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
     <li class="clearfix">
     <label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>学校：</label>
	 <div class="formControls col-xs-6">
	 <input type="text" placeholder="请输入学生学校" name="school" autocomplete="off" id="school"class="input-text col-xs-12" datatype="*6-20" nullmsg="密码不能为空"/>
	</div>
     <div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
     
     
    
     <li class="clearfix">
      <label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>户籍所在地：</label>
      <div class="formControls col-xs-6">
		<input name="place" placeholder="请输入您的所在地区" type="text" id="place"class="input-text Validform_error col-xs-12"  datatype="*6-20"/>
	  </div>
	 <div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
     <li class="clearfix">
      <label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>意向学校1：</label>
      <div class="formControls col-xs-6">
		<input name="intentionalschool1" placeholder="请输入学生意向学校1" type="text" id="intentionalschool1"class="input-text Validform_error col-xs-12"  datatype="*6-20"/>
	   </div>
		<div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
     
      <li class="clearfix">
     <label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>意向学校2：</label>
     <div class="formControls  col-xs-6">
	<input type="text" placeholder="请输入学生意向2" autocomplete="off" class="input-text Validform_error col-xs-12"  datatype="*6-20" recheck="userpassword" id="intentionalschool2" name="intentionalschool2"/>
	</div>
    <div class="col-4"> <span class="Validform_checktip"></span></div>
    </li>
     <li class="clearfix">
      <label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>辅导机构：</label>
      <div class="formControls col-xs-6">
      <select class="select input-text col-xs-12" name="fudaoclass" id="fudaoclass"size="1">
					<option value="">请选择辅导机构</option>
					<c:forEach items="${list2}" var="record">
					<option>${record.organizationname}</option>
					</c:forEach>
	</select>
      
<!-- 		<input name="fudaoclass" placeholder="请输入您的辅导机构名称" type="text" id="place"class="input-text Validform_error col-xs-12"  datatype="*6-20"/> -->
	   </div>
		<div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
     <li class="clearfix">
      <label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>辅导老师：</label>
      <div class="formControls col-xs-6">
		<input name="fudaoteacher" placeholder="请输入您的辅导老师" type="text" id="fudaoteacher"class="input-text Validform_error col-xs-12"  datatype="*6-20"/>
	   </div>
		<div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
     <li class="clearfix">
      <label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>家长姓名：</label>
      <div class="formControls col-xs-6">
		<input name="parentsname" placeholder="请输入家长姓名" type="text" id="parentsname"class="input-text Validform_error col-xs-12"  datatype="*6-20"/>
	   </div>
		<div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
     <li class="clearfix">
      <label class="label_name col-xs-3 col-lg-3"><i class="c-red">*</i>家长电话：</label>
      <div class="formControls col-xs-6">
		<input name="parentstel" placeholder="请输入家长联系电话" type="text" id="parentstel"class="input-text Validform_error col-xs-12"  datatype="*6-20"/>
	   </div>
		<div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
   
   
         <li class="clearfix">
			<div class="col-xs-3 col-lg-3">&nbsp;</div>
			<div class="col-xs-6">
	  <input class="btn button_btn bg-deep-blue " type="button" onclick="submitClick()" id="Add_Administrator" value="提交报考"/>
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

/*******滚动条*******/
$("body").niceScroll({  
	cursorcolor:"#888888",  
	cursoropacitymax:1,  
	touchbehavior:false,  
	cursorwidth:"5px",  
	cursorborder:"0",  
	cursorborderradius:"5px"  
});
function submitClick(){
if(myclass.value==""){
      alert("请选择年级");
      myclass.focus();
      return;
   }
  if(sname.value==""){
      alert("请输入学生姓名");
      sname.focus();
      return;
   }
   if(school.value==""){
      alert("请输入所在学校");
      school.focus();
      return;
   }if(place.value==""){
      alert("请输入户籍所在地");
      place.focus();
      return;
   }if(intentionalschool1.value==""){
      alert("请输入意向学校1名称");
      intentionalschool1.focus();
      return;
   } 
   if(intentionalschool2.value==""){
      alert("请输入意向学校2名称");
      intentionalschool2.focus();
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
</script>
