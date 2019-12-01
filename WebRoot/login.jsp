<%@ page language="java" import="java.util.*" pageEncoding="utf-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/Sellerber.js" type="text/javascript"></script>
<script src="js/shopFrame.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
 <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <script src="js/css3-mediaqueries.js"  type="text/javascript"></script>
<title>用户登录</title>
    <script type="text/javascript">  
        function huan(){  
            //获取这个元素  
            //将他的src指向为/tools/VerifyCodeServlet  
            var img = document.getElementById("imgcode");  
            //需要给出一个参数，这个参数每次都不同，才可以避过浏览器的缓存:a  
            img.src="<%=basePath%>VerifyCodeServlet?a="+new Date().getTime();  
        }  
        </script> 
</head>

<body class="login_style login-layout" >
${msg}
 <div class="loginbody">
  <div class="login-container">
 <div class="login_logo" ><img src="images/log.png"width="700xp" height="100px"/></div>
    <div class="position-relative">
     <div id="login_add" class="login-box widget-box no-border visible">
     
      <div class="widget-main">
      <h4 class="header blue lighter bigger">登录</h4>
      <div class="clearfix">
    
       <div class="add_login_cont Reg_log_style " style="margin-left:90px">
        <form action="loginServlet" method="post" id="form1">
        <input type="hidden" name="action" value="login" />
         <ul class="r_f">
         <li >
         <select name="role" id="role"class="frame_style form_error">
          <option value="">请选择角色${sessionScope.error}</option>
          <!-- <option value="超级管理员">超级管理员</option> -->
          <option value="管理员">管理员</option>
          <!-- <option value="学生">学生</option> -->
          <option value="教师">教师</option>
         </select>
         </li>
          <li class="frame_style form_error"><label class="user_icon"></label><input name="loginname" placeholder="请输入用户名" AUTOCOMPLETE="off"type="text" id="loginname"/></li>
          <li class="frame_style form_error"><label class="password_icon"></label><input name="loginpass" placeholder="请输入密码" type="password" id="userpwd"/></li>
	          <li class="frame_style form_error">
	          <label class="Codes_icon"></label><input name="verifyCode" type="text"  placeholder="验证码" id="Codes_text" class="Codes_text"/>
	              
	          <div class="Codes_region"> <img id="imgcode" src="<%=basePath%>VerifyCodeServlet"/>    <a href="javascript:huan()">换一张</a></div>
	         
	          </li> 
          
         </ul>       
      
       </div>
       <div class="login_Click_Actions" style="margin-right:70px">          
          <button type="button" class="button_width  btn btn-sm btn-primary"onclick="check()" id="login_btn">登录</button>
<!--           <p><label class="inline"><input type="checkbox" class="ace"><span class="lbl">保存密码</span></label></p> -->
          <a href="registServlet?action=departAndorganize"><button type="button" class="button_width  btn btn-sm btn-primary" id="login_btn">注册</button></a>
       </div>
      </div>
        </form>
      <div class="social-or-login center"><span class="">通知</span></div>
      <div class="margin-top color center">${error}</div>
      </div>
      <!-- <div class="Sellerber_bottom info" id="bottom">
  <span class="l_f" style="font-family: fantasy; font-weight: bold;">版权所有：河南双法学会数学教育委员会
</span>
  </div> -->
     </div>
     
   </div>
   
   </div>
   
   </div>
   
</body>
</html>
<script type="text/javascript">

function check(){
  if(role.value=="请选择角色"||role.value==""){
      alert("请选择角色！");
      role.focus();
      return;
   }
   if(loginname.value==""||loginname.value=="请输入用户名"){
      alert("请输入用户名");
      loginname.focus();
      return;
   }
   if(userpwd.value==""||userpwd.value=="请输入密码"){
      alert("请输入密码");
      userpwd.focus();
      return;
   }  
   if(Codes_text.value==""||Codes_text.value=="请输入验证码"){
      alert("请输入验证码");
      Codes_text.focus();
      return;
   }  
   return document.getElementById("form1").submit();
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
</script>

