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

<title>教师注册</title>
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
 <div class="loginbody">
  <div class="login-container" >
   <div class="login_logo"style="margin-top:0px;margin-left:50px"><h1 style="padding-top:0px">教&nbsp师&nbsp系&nbsp统&nbsp注&nbsp册</h1></div>
    <div class="position-relative" >
     <div id="login_add"style="height:900px;width:800px;" class="login-box widget-box no-border visible">
     
      <div class="widget-main" style="height:900px">
      <h4 class="header blue lighter bigger">注册</h4>
      <div class="clearfix" style="height:900px">
      
       <div class="login_icon"><img src="images/login_bg.png" /></div>
       <div class="add_login_cont Reg_log_style ">
        <form action="registServlet?action=tearegist" method="post" id="form1"name="form1">
       <input type="hidden" name="role" value="教师" />
        <input type="hidden" name="single" value="不通过" />
         <ul class="r_f">
       
        
          <li class="frame_style form_error"><label class="user_icon"></label><input name="tname" placeholder="用户名" type="text" id="tname"/></li>
          <li ><label class="user_icon"></label>
          <select name="tsex" id="tsex"class="frame_style form_error"> 
          <option value="">请选择性别</option>
           <option value="男">男</option>
          <option value="女">女</option>
          </select>
          </li>
          <li class="frame_style form_error"><label class="password_icon"></label><input name="tpwd" placeholder="密码" type="password" id="tpwd"/></li>
          <li class="frame_style form_error"><label class="password_icon"></label><input name="spwd2" placeholder="重复输入密码" type="password" id="tpwd2"/></li>
	      <li class="frame_style form_error"><label class="password_icon"></label><input name="temail" id="temail"placeholder="请输入邮箱" type="text"/></li>
	          
	      <li><label class="user_icon"></label>
          <select name="depart" id="depart"class="frame_style form_error"> 
        <option value="">请选择主要教学科目</option>
           <c:forEach items="${list2}" var="list">
         <option >${list.subject}</option>
        </c:forEach>
               
         </select>
         </li>
     
      <li><label class="user_icon"></label>
          <select name="organize" id="organize"class="frame_style form_error"> 
        <option value="">请选择辅导机构</option>
        <c:forEach items="${list1}" var="record">
         <option >${record.organizationname}</option>
        </c:forEach>
         </select>
         </li>  
	    
	    <li class="frame_style form_error">
	          <label class="Codes_icon"></label><input name="verifyCode" type="text"  placeholder="验证码" id="Codes_text" class="Codes_text"/>
	              
	          <div class="Codes_region"> <img id="imgcode" src="VerifyCodeServlet"/>    <a href="javascript:huan()">换一张</a></div>
	         
	          </li> 
          
         </ul>       
      
       </div>
       <div class="login_Click_Actions">          
          <button type="button" onclick="check()" class="button_width  btn btn-sm btn-primary" id="login_btn">注册</button>
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
   }if(tpwd2.value==""){
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
   }if(Codes_text.value==""){
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
 /*******滚动条*******/

	/*时间*/
	laydate({
    elem: '#start',
    event: 'focus' 
});
 
</script>

