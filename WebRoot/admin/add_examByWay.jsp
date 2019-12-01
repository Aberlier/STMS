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
<title>添加管理员</title>
</head>
<body>


<div class="margin add_administrator" id="page_style" style="width:100%;margin:0 auto;">
    <div class="add_style add_administrator_style">
    <div class="title_name">添加考试路线</div>
    <form action="ExaminationServlet?action=add_ExamByWay" method="post" id="form1">
    <input type="hidden" value="${addpeople}" name="addpeople"/>
    <input type="hidden" value="0" name="sign"/>
    <ul>
     <li class="clearfix">
     <label class="label_name col-xs-4 col-lg-4"><i>*</i>选择辅导机构：</label>
     <select name="oname"  class="formControls col-xs-6"id="oname"class="frame_style form_error"> 
        <option>请选择辅导机构</option>
        <c:forEach items="${list2}" var="record">
         <option >${record.organizationname}</option>
        </c:forEach>
               
      </select>
    <div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
     
     <li class="clearfix">
     <label class="label_name col-xs-4 col-lg-4"><i class="c-red">*</i>选择考试批次：</label>
	 <select name="examname" class="formControls col-xs-6" id="examname"class="frame_style form_error"> 
        <option>请选择考试批次</option>
        <c:forEach items="${list}" var="record">
         <option >${record.ename}</option>
         </c:forEach>
      </select>
       
     <div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
    
     <li class="clearfix">
      <label class="label_name col-xs-4 col-lg-4"><i class="c-red">*</i>考试地点：</label>
      <div class="formControls col-xs-6">
	 <input type="text" placeholder="请填写考试地点" name="examplace"id="examplace" autocomplete="off" value="" class="input-text col-xs-12" datatype="*6-20" nullmsg="考试地点不能为空"/>
	</div>
     </li>
      <li class="clearfix">
      <label class="label_name col-xs-4 col-lg-4"><i class="c-red">*</i>乘车路线：</label>
      <div class="formControls col-xs-6">
	 <input type="text" placeholder="请填写乘车路线" name="busline" id="busline"autocomplete="off" value="" class="input-text col-xs-12" datatype="*6-20" nullmsg="乘车路线不能为空"/>
	</div>
     </li>
      
      <li class="clearfix">
		<div class="col-xs-4 col-lg-4">&nbsp;</div>
		<div class="col-xs-6">
	  <input class="btn button_btn bg-deep-blue " type="button" onclick="check()" id="Add_Administrator" value="点击添加"/>
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
  if(oname.value==""){
      alert("请选择辅导机构");
      oname.focus();
      return;
   }
   if(examname.value==""){
      alert("请选择考试批次");
      examname.focus();
      return;
   }if(examplace.value==""){
      alert("请输入考试地点");
      examplace.focus();
      return;
   }if(busline.value==""){
      alert("请输入乘车路线");
      busline.focus();
      return;
   }
         
   return document.getElementById("form1").submit();
 }
</script>
