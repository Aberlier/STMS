<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/shop.css" type="text/css" rel="stylesheet" />
<link href="css/Sellerber.css" type="text/css"  rel="stylesheet" />
<link href="css/bkg_ui.css" type="text/css"  rel="stylesheet" />
<link href="font/css/font-awesome.min.css"  rel="stylesheet" type="text/css" />
<script src="js/jquery-1.9.1.min.js" type="text/javascript" ></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script src="js/shopFrame.js" type="text/javascript"></script>
<script src="js/Sellerber.js" type="text/javascript"></script>
<script src="js/layer/layer.js" type="text/javascript"></script>
 <script src="js/laydate/laydate.js" type="text/javascript"></script>
 <script type="text/javascript" src="js/json2.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/jquery.dataTables.bootstrap.js"></script>
<title>个人信息</title>
</head>
<!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <script src="js/css3-mediaqueries.js"  type="text/javascript"></script>
  <![endif]-->
<body>
<div class="margin" id="page_style">
${msg }
   <div class="personal_info">
   <div class="add_style clearfix border_style">
   <form id="user_info" action="loginServlet?action=adminupdateme&adminname=${list[0].adminname}" method="post">
    <div class="clearfix">   
        <div class="form-group clearfix col-xs-3">
        <label class="col-xs-3 label_name" for="form-field-1">编号：</label>
         <div class="col-xs-9 line_height1"><span>${list[0].id}</span></div>         
          </div>
              <div class="form-group clearfix col-xs-3">
        <label class="col-xs-3 label_name" for="form-field-1">姓名：</label>
         <div class="col-xs-9 line_height1"><input type="text" name="adminname" data-name="真实姓名" id="adminname" value="${list[0].adminname}" class="col-xs-7 text_info" disabled="disabled"></div>         
          </div>
         
          <div class="form-group clearfix col-xs-3"><label class="col-xs-3 label_name" for="form-field-1">角色： </label>
          <div class="col-xs-9 line_height1"><input type="text" name="temail" data-name="年龄" id="age" value="${list[0].role}" class="col-xs-7 text_info" disabled="disabled"></div>
          </div>        
          <div class="form-group clearfix col-xs-3"><label class="col-xs-3 label_name" for="form-field-1">登录次数： </label>
          <div class="col-xs-9 line_height1"><span>${list[0].totlogin}</span></div>
          </div>
 
          </div>
        
           <div class="Button_operation clearfix"> 
                
                <a href="javascript:ovid()" onclick="change_Password()" class="btn bg-green operation_btn">修改密码</a>	
                <input type="submit" id="save_info" class="btn bg-deep-blue operation_btn save"  value="保存修改"/>			     
			</div>
            </form>
            </div><div id="text_name"></div>
   </div>
  
 <!--修改密码样式-->
 <form action="AdminServlet?action=admin_updateme_pass&adminname=${list[0].adminname}"method="post" id="form2">
         <div class="change_Pass_style display" id="change_Pass">
            <ul class="change_Password clearfix">
             <li>
             <label class="label_name">原&nbsp;&nbsp;密&nbsp;码</label><span class="change_text"><input name="password" value="${list[0].tpwd}"type="password" class="" id="password"></span></li>
             <li>
             <label class="label_name">新&nbsp;&nbsp;密&nbsp;码</label><span class="change_text"><input name="newadminpass"  data-name="新密码" type="password" class="" id="Nes_pas"></span></li>
             <li>
             <label class="label_name">确认密码</label><span class="change_text"><input name="c_mew_pas" type="password" data-name="再次确认密码" class="" id="c_mew_pas"></span></li>              
            </ul>          
         </div>
         </form>
</body>
</html>
<script>
/****修改密码****/
function change_Password(){
	layer.open({
    type: 1,
	title:'修改密码',
	area: ['300px','300px'],
	shadeClose: true,
	content: $('#change_Pass'),
	btn:['确认修改'],
	yes:function(index, layero){		
	 var num=0;
     var str="";
	 var $paddword=/^[a-z0-9_-]{5,18}$/;
	
     $("input[type$='password']").each(function(n){
          if($(this).val()=="")
          {
               
			   layer.alert(str+=""+$(this).attr("data-name")+"不能为空！\r\n",{
                title: '提示框',				
				icon:0,								
          }); 
		    num++;
            return false;            
          } 
		 });
	       if(num>0){  return false;}	
	      if(!$("#c_mew_pas").val || $("#c_mew_pas").val() != $("#Nes_pas").val() )
        {
            layer.alert('密码不一致!',{
              title: '提示框',				
				icon:0,
			    
			 });
			 return false;
        }   
		 else{	
		 document.getElementById("form2").submit();
			  layer.alert('修改成功！',{
               title: '提示框',				
			icon:1,		
			  }); 
			  layer.close(index);      
		  }	 
	}
    });
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
	/*时间*/
	laydate({
    elem: '#start',
    event: 'focus' 
});
/********个人信息操作*******/
function modify(){
	 $('.text_info').attr("disabled", false);
	 $('.text_info').addClass("add");
	  $('#page_style').find('.add_style').addClass("hover");
	  $('#page_style').find('.save').css({'display':'block'});
	};
$("#save_info").click(function(){
	    var num=0;
		 var str="";
		 
     $(".xinxi input[type$='text']").each(function(n){
          if($(this).val()=="")
          {
               
			   layer.alert(str+=""+$(this).attr("name")+"不能为空！\r\n",{
                title: '提示框',				
				icon:0,								
          }); 
		    num++;
            return false;            
          } 
		 });
		  if(num>0){  return false;}	 	
          else{
			  var sex = $("input[name='form-field-radio']:checked").serialize();
		      var params=$('#user_info input').serialize(); //序列化表单的值
			  alert(params);
			  $.post(
			      "TeacherServlet?action=Teacherupdateme&tno=${list[0].tno}",
				  {
				   username:$("#username").val(),
				   surname:$("#surname").val(),
				   sex:$("input[name='form-field-radio']:checked").val(),
				   age:$("#age").val(),
				   mailbox:$("#mailbox").val(),
				   phone:$("#phone").val()
				   },
					function(data){
				     // $("#text_name").html(data)
                    //   console.log(data.time);
				  }, "text")
				  
			  /* $.ajax({
				   type:"post",
				   url:"user_json.php",
				   dataType:"json",
				   data:params,
				   success:User_Info  		  
				  });
				  function User_Info(json){
					  var str="姓名:"+json.username+"<br />";
						  str+="年龄:"+json.age+"<br />";
						  str+="性别:"+json.sex+"<br />";
						  str+="工作:"+json.mailbox+"<br />";
						  str+="追加测试:"+json.phone;						  
						  $("#text_name").html(str);				  					  				  
					 }*/
			   layer.alert('修改成功！',{
               title: '提示框',				
			   icon:1,			   		
			  });
			  $('#page_style').find('.add_style').removeClass("hover");
			  $('#page_style').find('.text_info').removeClass("add").attr("disabled", true);
			  $('#page_style').find('.save').css({'display':'none'});
			   layer.close();			
		  }
});
/********************/
$(function(){
	$("#sample_table tbody>tr:odd").addClass("odd");
	$("#sample_table tbody>tr:even").addClass("even");
	$("#sample_table tbody>tr").click(function(){	
	$(this).addClass("selected").siblings().removeClass("selected").end()
	})
	});
</script>

