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
${msg}
<div class="margin" id="page_style" style="width:100%;overflow-x:scroll;">
   <div class="personal_info">
   <div class="add_style clearfix border_style">
   <form id="user_info" action="TeacherServlet?action=Teacherupdateme&tname=${list[0].tname}" method="post">
    <div class="clearfix">   
        <div class="form-group clearfix col-xs-3">
        <label class="col-xs-3 label_name" for="form-field-1">教师工号：</label>
         <div class="col-xs-9 line_height1"><span>${list[0].tno}</span><span style="color:red">(不可修改)</span></div>         
          </div>
              <div class="form-group clearfix col-xs-3">
        <label class="col-xs-3 label_name" for="form-field-1">教师姓名：</label>
         <div class="col-xs-9 line_height1"><span>${list[0].tname}</span><span style="color:red">(不可修改)</span></div>         
          </div>
          <div class="form-group clearfix col-xs-3"><label class="col-xs-3 label_name" for="form-field-1">教师性别： </label>
          <div class="col-xs-9 line_height1">
            
            <c:if test="${list[0].tsex=='男'}">
            <label><span class="lbl">男</span></label>&nbsp;&nbsp;
            </c:if>
             <c:if test="${list[0].tsex=='女'}">
            <label><span class="lbl">女</span></label>
            </c:if>
          
           </div>
          </div>
          <div class="form-group clearfix col-xs-3"><label class="col-xs-3 label_name" for="form-field-1">教师邮箱： </label>
          <div class="col-xs-9 line_height1"><input type="text" name="temail" data-name="年龄" id="age" value="${list[0].temail}" class="col-xs-7 text_info" disabled="disabled"/></div>
          </div>
          <%-- <div class="form-group clearfix col-xs-3"><label class="col-xs-3 label_name" for="form-field-1">教师密码： </label>
          <div class="col-xs-9 line_height1"><span>${list[0].tpwd}</span></div>
          </div> --%>
          <div class="form-group clearfix col-xs-3"><label class="col-xs-3 label_name" for="form-field-1">审核状态： </label>
          <div class="col-xs-9 line_height1"><span>${list[0].single}</span>审核</div>
          </div>
          <div class="form-group clearfix col-xs-3"><label class="col-xs-3 label_name" for="form-field-1">注册时间： </label>
          <div class="col-xs-9 line_height1"><span>${list[0].registdata}</span></div>
          </div>
           <div class="form-group clearfix col-xs-3"><label class="col-xs-3 label_name" for="form-field-1">任职专业： </label>
          <div class="col-xs-9 line_height1"> <input type="text" name="depart" data-name="任职专业" id="depart" value="${list[0].depart}" class="col-xs-7 text_info" disabled="disabled"/></div>
          </div>
          <div class="form-group clearfix col-xs-3"><label class="col-xs-3 label_name" for="form-field-1">登录次数： </label>
          <div class="col-xs-9 line_height1"> <span>${list[0].totlogin}</span></div>
          </div>
          <div class="form-group clearfix col-xs-3"><label class="col-xs-3 label_name" for="form-field-1">所属组织：</label>
          <div class="col-xs-9 line_height1"> <span>${list[0].organize}</span> <span style="color:red">(不可修改)</span></div>
          </div>
           <div class="form-group clearfix col-xs-3"><label class="col-xs-3 label_name" for="form-field-1">组织编号：</label>
          <div class="col-xs-9 line_height1"> <span>${list[0].oid}</span> <span style="color:red">(不可修改)</span></div>
          </div>
      
          
          </div>
        
           <div class="Button_operation clearfix"> 
                <input type="button" onclick="modify();" class="btn btn-danger operation_btn"  value="修改信息"/>
                <a href="javascript:ovid()" onclick="change_Password()" class="btn bg-green operation_btn">修改密码</a>	
                <input type="submit" id="save_info" class="btn bg-deep-blue operation_btn save"  value="保存修改"/>			     
			</div>
            </form>
            </div><div id="text_name"></div>
   </div>
  
 <!--修改密码样式-->
 <form action="TeacherServlet?action=updateme&tname=${list[0].tname}"method="post" id="form2">
         <div class="change_Pass_style display" id="change_Pass">
            <ul class="change_Password clearfix">
             <li>
             <label class="label_name">原&nbsp;&nbsp;密&nbsp;码</label><span class="change_text"><input name="password" value="${list[0].tpwd}"type="password" class="" id="password"></span></li>
             <li>
             <label class="label_name">新&nbsp;&nbsp;密&nbsp;码</label><span class="change_text"><input name="newpassword"  data-name="新密码" type="password" class="" id="Nes_pas"></span></li>
             <li>
             <label class="label_name">确认密码</label><span class="change_text"><input name="c_mew_pas" type="password" data-name="再次确认密码" class="" id="c_mew_pas"></span></li>              
            </ul>          
         </div>
         </form>
         
         <!--重传照片样式-->
 <form action="StudentServlet?action=updateme&tname=${list[0].tname}"method="post" id="form2">
      
         <div class="change_Pass_style display" id="resetPicture">
         
           <img src="images/${list[0].photo}" />
         </div>
         </form>
         
           <!--机构信息-->
   <div class="admin_recording clearfix">
      <div class="searchs  clearfix  operation">
 <label>机构信息：</label>

</div>
        <table id="sample_table" class="table table_list table_striped table-bordered dataTable no-footer" style="width:100%;">
           <thead>
			<tr>
             
			  <th width="5%">机构名称</th>
			  <th width="3%">机构编号</th>
			  <th width="5%">创立时间</th>
              <th width="5%">负责人</th>
              <th width="5%">联系电话</th>
              <th width="4%">地址</th> 
              <th width="3%">操作</th>        
             </tr>
		    </thead>
            <tbody>
            <c:forEach items="${list2}" var="list">
             <tr>
            
             <td>${list.organizationname}</td>
             <td>${list.oid}</td>
             <td>${list.addtime}</td>
             <td>${list.operson}</td>
             <td>${list.otel}</td>
             <td>${list.oaddress}</td>
             <td> <a title="编辑"onclick="myselfinfo(${list.oid})"href="javascript:;" class="btn button_btn bg-deep-blue">编辑</a>        </td>
             </tr>
            </c:forEach>
            <tr >
				<td align="center" colspan="10" bgcolor="#ffffff" >	
		   	 <ul class="pagination"style="margin-left:85%">
			    <li <c:if test="${page.currPage eq '1'}"> class="disabled"</c:if>><a <c:if test="${page.currPage ne '1'}">href="TeacherServlet?action=teacherfindbyId&tname=${list[0].tname}&currPage=${page.currPage -1}"</c:if>>上一页</a></li>
			    <c:if test="${page.totalPage eq '0'}"><li> class="active"<a href="TeacherServlet?action=teacherfindbyId&tname=${list[0].tname}&currPage=1">1</a></li></c:if>
			    <c:forEach begin="1" end="${page.totalPage }" var="var">
			    	<li <c:if test="${var eq page.currPage}"> class="active"</c:if>><a href="TeacherServlet?action=teacherfindbyId&tname=${list[0].tname}&currPage=${var}">${var}</a></li>
			    </c:forEach>
			    <li  <c:if test="${page.currPage eq page.totalPage }"> class="disabled"</c:if>><a <c:if test="${page.currPage ne page.totalPage }">href="TeacherServlet?action=teacherfindbyId&tname=${list[0].tname}&currPage=${page.currPage +1}"</c:if>>下一页</a></li>
			  </ul>	
         		</td>
			</tr>
            </tbody>
         </table>   
   </div>
</div>
</body>
</html>
<script>
function myselfinfo(oid){
	layer.open({
		type: 2,
		area: ['600px','400px'],
		fix: false, //不固定
		maxmin: true,
		shade:0.4,
		title: '查看信息',
		//content: '<table style="text-align:center;"><th style="text-align:center;"><h5 >个人信息</h5></th><tr><td>姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名：<input type="" name="" value=""></td></tr><tr><td>联系方式：<input type="text" name="" value=""></td></tr><tr><td>所在职责：<input type="text" name="" value=""></td></tr><tr><td>所管机房：<input type="text" name="" value=""></td></tr></table>'
		content:'<%=basePath%>TeacherServlet?action=updatebefore_o&oid='+oid
	});
}


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

/****重新上传照片****/
function resetPicture(photo){
	layer.open({
    type: 1,
	title:'查看照片',
	area: ['500px','500px'],
	shadeClose: true,
	content:'<img src="images/${list[0].photo}" />',
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
