<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<script type="text/javascript" charset="utf-8" src="ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript">
	 UE.getEditor('content');
	 UE.getEditor('department_message');
	 UE.getEditor('part_message');
	 function getContent(){
	      var c1=UE.getEditor('content_target').getContentTxt();
	      //var c2=UE.getEditor('content_target').getContent();
	      $("#content").val(c1);
	 }
</script>

<link href="css/common/style.css" type="text/css" rel="stylesheet">
<link href="css/common/right.css" type="text/css" rel="stylesheet" >


<style type="text/css">
.style1,span,body,.button{font-size:14px;font-family:"微软雅黑";}
*{font-family:"微软雅黑";}


.myleft1{height:40px;width:15%;background-color:#d3eaef;text-align:center}
.myright1{text-align:left;padding-left:10px;background-color:#FFFFFF;}
.mycolspan1{text-align:center;background-color:#FFFFFF;height:40px}

.myinput1{height:22px;width:300px;margin-right:15px;font-family:"微软雅黑";}
.myselect1{height:28px;width:303px;font-size:14px;font-family:"微软雅黑";margin-right:15px}

a.mylink1{background-color:#eb7300;}

.myinput2{height:22px;width:180px;margin-right:15px;font-family:"微软雅黑";}
.myselect2{height:28px;width:183px;font-size:14px;font-family:"微软雅黑";margin-right:15px}
.myinput3{height:22px;width:120px;margin-right:10px;font-family:"微软雅黑";}
.myselect3{height:28px;width:123px;font-size:14px;font-family:"微软雅黑";margin-right:10px}

.error{color:red;display:inline}

</style>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${webtitle}</title>


<script language="javascript" src="res/ajax.js"></script>
<script language="javascript" src="res/Common.js"></script>
<script language="javascript" src="res/jquery.min.js"></script>
<script language="javascript" src="res/tips.js"></script>
<script language="javascript" src="res/Float.js"></script>
<script src="res/jquery.artDialog.js"></script>
<link href="res/default.css" rel="stylesheet" >
<script src="res/iframeTools.js"></script>

<script language="JavaScript" defer="defer" type="text/javascript" src="datepicker/WdatePicker.js"></script>


<!-- 
<script src="artdialog6/jquery-1.10.2.js"></script>
<link rel="stylesheet" href="artdialog6/ui-dialog.css">
<script src="artdialog6/dialog-min.js"></script>
-->


<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/jquery.message.cn.js"></script>


<script type="text/javascript" charset="utf-8" src="js/front.js"></script>


<script type="text/javascript">

	<c:if test="${act!='list_teacher' && act!='list_student' && act!='list_topic' && act!='list_topic_nopass' && act!='list_student_nosel' && act!='list_major' && act!='list_major_gl' && act!='list_banji' && act!='list_meet_count' && act!='list_meet'}">
	$().ready(function() {
	
		var inputForm = $("#inputForm");
		<c:forEach items="${fields}" var="f">
		    var ${f} = $("#${f}");
		</c:forEach>
		<c:if test="${pagename=='edit_teacher'}">
		var zdids=$("input[name='zdids']");
		</c:if>
		
		<c:if test="${pagename=='edit_meet'}">
		var students=$("input[name='students']");
		</c:if>
	    
		var savebutton= $("#savebutton");
		inputForm.validate({
			rules: {
			
			      <c:choose>
	                  <c:when test="${pagename=='editpwd'}">
			                oldpassword: {
								required: true,
								minlength: 6
							},
							newpassword1: {
			                    required: true,
			                    minlength: 6
			                },
							newpassword2: {
			                    required: true,
			                    minlength: 6,
			                    equalTo: "#newpassword1"
			                }
	                  </c:when>
	                  <c:otherwise>
			               <c:forEach items="${fields}" var="f" varStatus="status">
				                ${f}: {
								   required: true
								   <c:if test="${pagename=='edit_meet'}">
							          <c:if test="${f=='content'}">
							               ,maxlength: 80
							          </c:if> 
							       </c:if> 
								   
							    }<c:if test="${status.last==false}">,</c:if> 
							    
							    
				           </c:forEach> 
				           <c:if test="${pagename=='edit_teacher'}">
				               ,zdids: {
								   required: true
							    }  
							</c:if> 
							<c:if test="${pagename=='edit_meet'}">
				               ,students: {
								   required: true
							    }  
							</c:if> 
							<c:if test="${pagename=='edit_banji'}">
				               ,sort: {
				                    required: true,
				                    number: true,
								    decimal: {
									   integer: 12,
									   fraction: 0
								    } 
				               }
							</c:if>                                                                  
	                  </c:otherwise>
	              </c:choose>
			},
			
			submitHandler: function(form) { //通过之后回调,AJAX提交
			      <c:if test="${pagename=='edit_meet'}">
			       //if(v1("attach1","现场照片")){
			       if($("#attach1").val()==""){
			            $("#attach1").val("images/nopic.png");
			       }
			      </c:if> 
			      
			       $.ajax({
							type: "POST",
							url: "${url}",
							dataType: "json", 
							data:inputForm.serialize(),
							beforeSend: function() {
							   savebutton.attr({"disabled":"disabled"});
					        },
							success: function (data) {
							     <c:if test="${pagename=='pass_topic' || pagename=='assign_wish'}">
								     if(data.code=="0"){
								           art.dialog({title: '系统提示',time: 3,icon: 'error',content: data.msg});	
								     }else{
								           art.dialog({title: '系统提示',time: 1,icon: 'succeed',content: data.msg,close:function(){art.dialog.open.origin.location.reload();}});	   
									 }
							     </c:if>
							     <c:if test="${pagename!='pass_topic'}">
							         if(data.code=="0"){
								           art.dialog({title: '系统提示',time: 3,icon: 'error',content: data.msg});	
								     }else{
								           art.dialog({title: '系统提示',time: 1,icon: 'succeed',content: data.msg,close:function(){location.href=data.url;}});	   
									 }
							     </c:if>
							},
							complete: function() {
							   savebutton.removeAttr("disabled");
					        }
			
					});  
					
				  <c:if test="${pagename=='edit_meet'}">
			       //}
			      </c:if> 
					
			}
			
		});
	
	});
	</c:if>



	//通用不带确认提交
	function ajax_do(url,formid,buttonid,refresh){
	   $.ajax({
					type: "POST",
					url: url,
					dataType: "json", 
					data: $("#"+formid).serialize(),
					beforeSend: function() {
						$("#"+buttonid).attr({"disabled":"disabled"});
					},
					success: function (data) {
					    if(data.code=="1"){
					        if(refresh=='1'){
					           art.dialog({title: '系统提示',time: 1,icon: 'succeed',content: data.msg,close:function(){art.dialog.open.origin.location.reload();}});
					        }else{
					           art.dialog({title: '系统提示',time: 1,icon: 'succeed',content: data.msg,close:function(){location.href=data.url;}});
					        }	     
						}else{
							art.dialog({title: '系统提示',time: 3,icon: 'warning',content: data.msg});	
						}
					},
					complete: function() {
					   $("#"+buttonid).removeAttr("disabled");
			        }	
			});
	}


	//弹出确定的通用处理操作
	function confirm_ajax_do(act,msg,url,id){
	   $.dialog( 
		   { 
		     content: '<span>确定要'+msg+'？</span>',
			 icon: 'warning',
			 ok: function () {
				   $.ajax({
							type: "POST",
							url: url,
							dataType: "json", 
							data: $("#inputForm").serialize(),
							success: function (data) {
							
							    if(act=="lock_teacher" || act=="lock_student"){
							        if(data.code=="1"){
							            if($("#status"+id).html()=="禁用"){
							               $("#status"+id).css("color","green");
							               $("#status"+id).html("正常");
							               
							               $("#linka"+id).css("display","none");
							               $("#linkb"+id).css("display","");
							            }else{
							               $("#status"+id).css("color","red");
							               $("#status"+id).html("禁用");
							               
							               $("#linka"+id).css("display","");
							               $("#linkb"+id).css("display","none");
							            }
							        }
							        
							    }else if(act=="del_teacher" || act=="del_student" || act=="del_topic_major" || act=="del_topic" || act=="del_wish" || act=="del_meet"){
							        if(data.code=="1"){
										art.dialog({title: '系统提示',time: 1,icon: 'succeed',content: data.msg,close:function(){location.href=data.url;}});	     
									}else{
										art.dialog({title: '系统提示',time: 3,icon: 'warning',content: data.msg});	
									}
	
							    }else if(act=="select_topic" || act=="unpass_topic" || act=="choose_student" || act=="del_banji" || act=="cancel_luqu"){
							        if(data.code=="1"){
										art.dialog({title: '系统提示',time: 1,icon: 'succeed',content: "<span>"+data.msg+"</span>",close:function(){art.dialog.open.origin.location.reload();}});	     
									}else{
										art.dialog({title: '系统提示',time: 3,icon: 'warning',content: "<span>"+data.msg+"</span>"});	
									}
	
							    }else{
								    if(data.code=="1"){
										art.dialog({title: '系统提示',time: 1,icon: 'succeed',content: data.msg});	   
									}else{
										art.dialog({title: '系统提示',time: 3,icon: 'warning',content: data.msg});	
									}
							    }
	
							}	
					});
			 },
			 cancel: true 
		   });
	
	}

	//JS验证单选框
	function valRadio(name,tip){
	   var cbs = document.getElementsByName(name);  
	   var b = false;  
	   for(var i=0;i<cbs.length;i++){  
			if(cbs[i].checked){            
				return true;  
			}  
	   }
	   if(!b){  
			art.dialog({title: '系统提示',time: 2,left: '50%',top: '0%',icon: 'warning',content: '<span>请选择'+tip+'！</span>'}); 
			return false;  
	   }  
	}


	//查看某位教师的指导专业
	function show_zd_major(id,tname){
	   var myDialog = art.dialog({title: tname+" 指导的专业",time: 3});
	   $.ajax({
				type: "POST",
				url: "show_zd_major.jsp?id="+id,	
				data:$('#inputForm').serialize(),
				success: function (data) {
					myDialog.content(data);// 填充对话框内容
				}					
	   });
	}

	//查看某个选题的限选专业
	function show_topic_major(id){
	   var myDialog = art.dialog({title: "限选专业",time: 10,fixed: true});
	   $.ajax({
				type: "POST",
				url: "show_topic_major.jsp?id="+id,	
				data:$('#inputForm').serialize(),
				success: function (data) {
					myDialog.content(data);// 填充对话框内容
				}					
	   });
	}
	
	//获取题目列表
	function get_topic_list(){
	  $.ajax({
				type: "POST",
				url: "get_topic_list.jsp",	
				data:$('#inputForm').serialize(),
				success: function (data) { 
					$("#topicid").html(data);
				}					
	   });
	}
	
	
	//获取老师某一专业的指学生列表
	function get_major_zd_students(studentslist){
	   
	   $.ajax({
				type: "POST",
				url: "get_major_zd_students.jsp",	
				data:$('#inputForm').serialize(),
				success: function (data) { 
				    //alert(data);
					$("#"+studentslist).html(data);
				}					
	   });
	}



   //保存信息
   function savepost(type){
   
      if(type=='topic'){ 
          var savebutton=$("#savebutton");
	      if(v1("title","题目名称") && valRadio("cate","选题类别") && valRadio("ly","课题来源") && valRadio("cg","成果类别") && v1("content","主要研究内容") && valRadio("zdids","限选专业")){            
			 $.ajax({
						type: "POST",
						url: "teacher?act=apply_topic_do",	
						dataType: "json",
						data:$('#form2').serialize(),
						beforeSend: function() {
						   savebutton.attr({"disabled":"disabled"});
				        },
						success: function (data) {
						     if(data.code=="0"){
						           art.dialog({title: '系统提示',time: 3,icon: 'error',content: "<span>"+data.msg+"</span>"});	
						     }else{
						           art.dialog({title: '系统提示',time: 1,icon: 'succeed',content: "<span>"+data.msg+"</span>",close:function(){location.href=data.url;}});	   
							 }
						},
						complete: function() {
						   savebutton.removeAttr("disabled");
				        }					
				});
			 
          }   
	  }else if(type=='edit_topic'){ 
	      var savebutton=$("#savebutton");
          if(v1("title","题目名称") && valRadio("cate","选题类别") && valRadio("ly","课题来源") && valRadio("cg","成果类别") && v1("content","主要研究内容")){            
			   $.ajax({
						type: "POST",
						url: "teacher?act=apply_topic_do",	
						dataType: "json",
						data:$('#form2').serialize(),
						beforeSend: function() {
						   savebutton.attr({"disabled":"disabled"});
				        },
						success: function (data) {
						     if(data.code=="0"){
						           art.dialog({title: '系统提示',time: 3,icon: 'error',content: "<span>"+data.msg+"</span>"});	
						     }else{
							    
							    <c:if test="${admin.role=='教师' || admin.role=='专业管理员' || admin.role=='系部管理员' || admin.role=='超级管理员'}"> 
						           art.dialog({title: '系统提示',time: 1,icon: 'succeed',content: "<span>"+data.msg+"</span>",close:function(){art.dialog.open.origin.location.reload();}});	   
							    </c:if>
							 
							 }
						},
						complete: function() {
						   savebutton.removeAttr("disabled");
				        }					
				});
			 
          }
	         
	  }else if(type=='config'){
	      var savebutton=$("#savebutton"); 
	      <c:if test="${r.attr!='mode' && r.attr!='curgrade'}">
	         if(v1("v1","开始时间") && v1("v2","结束时间")){
	      </c:if>
	         $.ajax({
						type: "POST",
						url: "edit_config.jsp?act=save_config",	
						dataType: "json",
						data:$('#form2').serialize(),
						beforeSend: function() {
						   savebutton.attr({"disabled":"disabled"});
				        },
						success: function (data) {
						     if(data.code=="0"){
						           art.dialog({title: '系统提示',time: 3,icon: 'error',content: "<span>"+data.msg+"</span>"});	
						     }else{
						           art.dialog({title: '系统提示',time: 1,icon: 'succeed',content: "<span>"+data.msg+"</span>",close:function(){art.dialog.open.origin.location.reload();}});	   
							 }
						},
						complete: function() {
						   savebutton.removeAttr("disabled");
				        }					
				});
	      <c:if test="${r.attr!='mode' && r.attr!='curgrade'}">
	         }
	      </c:if>
	      
	  }else if(type=='pwd'){ 	 
            if(v1("oldpwd","原始密码") && v1("newpwd1","新密码") && v1("newpwd2","确认新密码")){            

				$.ajax({
						type: "POST",
						url: "pwd_p.php",	
						data:$('#form2').serialize(),
						success: function (data) {
							    
								if(data=="修改成功"){
									 art.dialog({title: '系统提示',time: 1,icon: 'succeed',content: data});
									 window.location.href='pwd.php';	 
								}else{
									art.dialog({title: '系统提示',time: 1,icon: 'error',content: data});
									
								}
								
						}					
				});
            } 
	  }else if(type=='admin'){ 
	      if(v1("adm_name","用户名") && v1("adm_pwd","登陆密码")){            
			  $.ajax({
						type: "POST",
						url: "editadmin_p.php",	
						data:$('#form2').serialize(),
						success: function (data) {
							    
								if(data=="1"){
									 art.dialog({title: '系统提示',time: 1,icon: 'succeed',content: '操作成功！'});
									 window.location.href='listadmin.php';	 
								}else{
									art.dialog({title: '系统提示',time: 1,icon: 'error',content: '操作失败！'});
									
								}
								
						}					
				});
          }  
	  }
	  
 
   }
   

   //打开子窗口
   function show(url,title,width,height){
	  $.dialog.open(url, {padding: 0,title: title, width:width,height: height, fixed: true}); 
   }
   
   //打开子窗口
   function show2(url,title,width,height){
	  $.dialog.open(url, {padding: 0,title: title, width:width,height: height, fixed: true,close:function(){art.dialog.open.origin.location.reload();}}); 
   }


</script>


