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
 <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <script src="js/css3-mediaqueries.js"  type="text/javascript"></script>
<title>添加管理员</title>
</head>
<!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <script src="js/css3-mediaqueries.js"  type="text/javascript"></script>
  <![endif]-->
<body>


<div class="margin add_administrator" id="page_style" style="width:100%;margin:0 auto;">
    <div class="add_style add_administrator_style">
    <div class="title_name">添加培训机构</div>
    <form action="../OrganizationServlet?action=addOrganization" method="post" id="form1">
    <ul>
     <li class="clearfix">
     <label class="label_name col-xs-4 col-lg-4"><i>*</i>机构名称：</label>
     <div class="formControls col-xs-6">
     <input type="text" class="input-text col-xs-12" value="" placeholder="" id="organizationname" name="organizationname" datatype="*2-16" nullmsg="机构名称不能为空"/></div>
    <div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
     <li class="clearfix">
     <label class="label_name col-xs-4 col-lg-4"><i class="c-red">*</i>机构编号：</label>
	 <div class="formControls col-xs-6">
	 <input type="text" placeholder="请填写机构编号" name="oid" id="oid"autocomplete="off" value="" class="input-text col-xs-12" datatype="*6-20" nullmsg="机构编号不能为空"/>
	</div>
     <div class="col-4"> <span class="Validform_checktip"></span></div>
     </li>
    
     <li class="clearfix">
      <label class="label_name col-xs-4 col-lg-4"><i class="c-red">*</i>机构负责人：</label>
      <div class="formControls col-xs-6">
	 <input type="text" placeholder="请填写机构负责人" name="operson" id="operson"autocomplete="off" value="" class="input-text col-xs-12" datatype="*6-20" nullmsg="机构负责人不能为空"/>
	</div>
     </li>
      <li class="clearfix">
      <label class="label_name col-xs-4 col-lg-4"><i class="c-red">*</i>负责人电话：</label>
      <div class="formControls col-xs-6">
	 <input type="text" placeholder="请填写负责人电话" name="otel"id="otel" autocomplete="off" value="" class="input-text col-xs-12" datatype="*6-20" nullmsg="机构负责人不能为空"/>
	</div>
     </li>
     
    
     
     <li class="clearfix">
      <label class="label_name col-xs-4 col-lg-4"><i class="c-red">*</i>请填写机构地址：</label>
      <div class="formControls col-xs-6">
		<input type="text" class="input-text col-xs-12" id="oaddress"placeholder="请填写机构地址"name="oaddress" datatype="m" nullmsg="机构地址不能为空"/>
	  </div>
	 <div class="col-4"> <span class="Validform_checktip"></span></div>
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
function check(){
  if(organizationname.value=="请输入辅导机构名称"||organizationname.value==""){
      alert("请输入辅导机构名称");
      organizationname.focus();
      return;
   }
   if(oid.value==""||oid.value=="请输入机构编号"){
      alert("请输入机构编号");
      oid.focus();
      return;
   }
   if(operson.value==""){
      alert("请输入机构负责人");
      operson.focus();
      return;
   }  
   if(otel.value==""){
      alert("请输入负责人联系电话");
      otel.focus();
      return;
   } 
    if(oaddress.value==""){
      alert("请输入负责人地址");
      oaddress.focus();
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
