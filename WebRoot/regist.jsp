<%@ page language="java" import="java.util.*" pageEncoding="utf-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%  
HttpSession session = request.getSession();
session.invalidate();  
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/shop.css" type="text/css" rel="stylesheet" />
<link href="skin/default/skin.css" rel="stylesheet" type="text/css" id="skin" />
<link href="css/Sellerber.css" type="text/css"  rel="stylesheet" />
<link href="css/bkg_ui.css" type="text/css"  rel="stylesheet" />
<link href="font/css/font-awesome.min.css"  rel="stylesheet" type="text/css" />
<script src="js/jquery-1.9.1.min.js" type="text/javascript" ></script>
<script src="js/layer/layer.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/jquery.dataTables.bootstrap.js"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/Sellerber.js" type="text/javascript"></script>
<script src="js/shopFrame.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script src="js/laydate/laydate.js" type="text/javascript"></script>
 <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <script src="js/css3-mediaqueries.js"  type="text/javascript"></script>

<title>学生注册</title>
    <script type="text/javascript">  
          
        function huan(){  
            //获取这个元素  
            //将他的src指向为/tools/VerifyCodeServlet  
            var img = document.getElementById("imgcode");  
            //需要给出一个参数，这个参数每次都不同，才可以避过浏览器的缓存:a  
            img.src="VerifyCodeServlet?a="+new Date().getTime();  
        }  
        
        
        </script>  
   <style type="text/css">
       li{
			
		}
        </style>
</head>

<body class="login_style login-layout">
${msg}
 <div class="loginbody" >
  <div class="login-container" >
   <div class="login_logo" style="margin-top:0px;margin-left:50px"><h1 style="padding-top:0px">学&nbsp生&nbsp系&nbsp统&nbsp注&nbsp册</h1></div>
    <div class="position-relative" >
     <div id="login_add"style="height:900px;width:800px;" class="login-box widget-box no-border visible">
     
      <div class="widget-main" style="height:900px">
      <h4 class="header blue lighter bigger">注册</h4>
      <div class="clearfix" style="height:900px">
      
       <div class="login_icon"><img src="images/login_bg.png" /></div>
       <div class="add_login_cont Reg_log_style ">
        <form action="registServlet?action=sturegist" method="post" name="form1" id="form1">
        <input type="hidden" name="role" value="学生"/>
        <input type="hidden" name="single" value="不通过" />
         <ul class="r_f">
       
         <li>
         <select name="headmaster" id="headmaster"class="frame_style form_error">
           <option >请选择班主任</option>
           <c:forEach items="${list}" var="record">
           <option >${record.tname}</option>
       	   </c:forEach>
         </select>${error}
         </li>
          <li class="frame_style form_error"><label class="user_icon"></label><input name="sname" placeholder="用户名" type="text" id="sname"/></li>
          <li ><label class="user_icon"></label>
          <select name="sex" id="sex"class="frame_style form_error"> 
          <option >请选择性别</option>
           <option value="男">男</option>
          <option value="女">女</option>
          </select>
          </li>
          <li class="frame_style form_error"><label class="password_icon"></label><input name="spwd" placeholder="密码" type="password" id="spwd"/></li>
          <li class="frame_style form_error"><label class="password_icon"></label><input name="spwd2" placeholder="重复输入密码" type="password" id="spwd2"/></li>	          
	      <li class="frame_style form_error"><label class="password_icon"></label><input name="old" placeholder="请输入年龄" type="text" id="old"/></li>
         <li class="frame_style form_error" style=""><label class="label_name"></label><input name="born" class="inline laydate-icon " placeholder="请选择出生日期"id="born" type="text"  style=" margin-right:10px; height:auto; float:left; width:150px;" /></li>
        <li class="frame_style form_error"><label class="Codes_icon"></label><input name="place" placeholder="请输入户籍所在地区" type="text" id="place"/></li> 
        
        <li class="frame_style form_error" ><label class="Codes_icon"></label><input name="schoolname" placeholder="请输入您的学校名称" type="text" id="schoolname"/></li> 
<!--          <li class="frame_style form_error"><label class="Codes_icon"></label><input name="fudaoclass" placeholder="请输入您的辅导机构名称" type="text" id="fudaoclass"/></li>  -->
      <li>
         <select name="fudaoclass" id="fudaoclass"class="frame_style form_error">
           <option value="">请选择辅导机构</option>
           <c:forEach items="${list2}" var="record">
           <option >${record.organizationname}</option>
       	   </c:forEach>
         </select>${error}
         </li>
       <li class="frame_style form_error"><label class="Codes_icon"></label><input name="fudaoteacher" placeholder="请输入您的辅导老师" type="text" id="fudaoteacher"/></li> 
        <li class="frame_style form_error"><label class="Codes_icon"></label><input name="parentsname" placeholder="请输入家长姓名" type="text" id="parentsname"/></li> 
         <li class="frame_style form_error"><label class="Codes_icon"></label><input name="parentstel" placeholder="请输入家长联系电话" type="text" id="parentstel"/></li> 
	    <li class="frame_style form_error">
	          <label class="Codes_icon"></label><input name="verifyCode" type="text"  placeholder="验证码" id="Codes_text" class="Codes_text"/>
	          <div class="Codes_region"> <img id="imgcode" src="VerifyCodeServlet"/>    <a href="javascript:huan()">换一张</a></div>
	          </li> 
         </ul>       
      
       </div>
       <div class="login_Click_Actions">          
          <button type="button" onclick="check()"class="button_width  btn btn-sm btn-primary" id="login_btn">注册</button>
          <a href="registServlet?action=departAndorganize"><button type="button" class="button_width  btn btn-sm btn-primary" id="login_btn">教师注册</button></a>
		<a href="<%=request.getContextPath()%>/login.jsp"><button type="button" class="button_width  btn btn-sm btn-primary" id="login_btn">登陆页面</button></a>       
       </div>
      </div>
      
        </form>
      
      </div>
     </div>
   </div>
   </div>
   </div>
</body>
</html>

<script type="text/javascript">

 function check(){
  if(headmaster.value=="请选择班主任"||headmaster.value==""){
      alert("请选择班主任！");
      headmaster.focus();
      return;
   }else if(sname.value==""){
      alert("请输入学生姓名");
      sname.focus();
      return;
   }
   else if(sex.value==""||sex.value=="请选择性别"){
      alert("请选择性别");
      sex.focus();
      return;
   }else if(spwd.value==""||spwd.value=="请输入密码"){
      alert("请输入密码");
      spwd.focus();
      return;
   }
   else if(old.value==""||old.value=="请选择年龄"){
      alert("请选择年龄");
      old.focus();
      return;
   }
   else if(born.value==""||born.value=="请选择出生日期"){
      alert("请选择出生日期");
      born.focus();
      return;
   }
   else if(place.value==""||place.value=="请输入您的所在地区"){
      alert("请选择出生地");
      born.focus();
      return;
   }
   else if(schoolname.value==""||place.value=="请输入您的学校名称区"){
      alert("请选择学校名称");
      schoolname.focus();
      return;
   }
   else if( fudaoclass.value==""||fudaoclass.value=="请输入您的辅导机构名称"){
      alert("请选择辅导机构");
       fudaoclass.focus();
      return;
   }
   else if(fudaoteacher.value==""||fudaoteacher.value=="请输入您的辅导老师"){
      alert("请选择辅导老师");
      fudaoteacher.focus();
      return;
   }
   
   else if( parentsname.value==""||parentsname.value=="请输入家长姓名"){
      alert("请填写父母姓名");
       fudaoclass.focus();
      return;
   }
   else if( parentstel.value==""||parentstel.value=="请输入家长联系电话"){
      alert("请填写父母电话");
       fudaoclass.focus();
      return;
   }
   else if( Codes_text.value==""||Codes_text.value=="验证码"){
      alert("请输入验证码");
       fudaoclass.focus();
      return;
   }
  else{
   
   return document.getElementById("form1").submit();
 }
 }

	
  $(document).ready(function(){
	 $("input[type='text'],input[type='password']").blur(function(){
        var $el = $(this);
        var $parent = $el.parent();
        $parent.attr('class','frame_style').removeClass(' form_error');
        if($el.val()==''){
            $parent.attr('class','frame_style').addClass(' form_error');
        }
    });
	$("input[type='text'],input[type='password']").focus(function(){		
		var $el = $(this);
        var $parent = $el.parent();
        $parent.attr('class','frame_style').removeClass(' form_errors');
        if($el.val()==''){
            $parent.attr('class','frame_style').addClass(' form_errors');
        } else{
			 $parent.attr('class','frame_style').removeClass(' form_errors');
		}
	});
 })
 /*******滚动条*******/

	/*时间*/
	laydate({
    elem: '#start',
    event: 'focus' 
});
 
</script>

