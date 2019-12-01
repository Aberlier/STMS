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
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
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
 <script src="js/dist/echarts.js" type="text/javascript"></script>
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
   <div class="personal_info">
   <div class="add_style clearfix border_style">
   <form id="user_info" action="StudentServlet?action=Studentupdateme&sname=${list[0].sname}" method="post">
    <div class="clearfix">   
        <div class="form-group clearfix col-xs-3">
        <label class="col-xs-3 label_name" for="form-field-1">ID号：</label>
         <div class="col-xs-9 line_height1"><span>${list[0].id}</span></div>         
          </div>
              <div class="form-group clearfix col-xs-3">
        <label class="col-xs-3 label_name" for="form-field-1">学生姓名：</label>
         <div class="col-xs-9 line_height1"><span>${list[0].sname}</span></div>         
          </div>
          <div class="form-group clearfix col-xs-3"><label class="col-xs-3 label_name" for="form-field-1">性别： </label>
          <div class="col-xs-9 line_height1">
            
            <c:if test="${list[0].sex=='男'}">
            <label><span class="lbl">男</span></label>&nbsp;&nbsp;
            </c:if>
             <c:if test="${list[0].sex=='女'}">
            <label><span class="lbl">女</span></label>
            </c:if>
          
           </div>
          </div>
          <div class="form-group clearfix col-xs-3"><label class="col-xs-3 label_name" for="form-field-1">年龄： </label>
          <div class="col-xs-9 line_height1"><input type="text" name="old" data-name="年龄" id="age" value="${list[0].old}" class="col-xs-7 text_info" disabled="disabled"/></div>
          </div>
          <div class="form-group clearfix col-xs-3"><label class="col-xs-3 label_name" for="form-field-1">审核状态： </label>
          <div class="col-xs-9 line_height1"><span>${list[0].single}</span></div>
          </div>
          <div class="form-group clearfix col-xs-3"><label class="col-xs-3 label_name" for="form-field-1">注册时间： </label>
          <div class="col-xs-9 line_height1"><span>${list[0].registdata}</span></div>
          </div>
           <div class="form-group clearfix col-xs-3"><label class="col-xs-3 label_name" for="form-field-1">出生日期： </label>
          <div class="col-xs-9 line_height1"> <span>${list[0].born}</span></div>
          </div>
           <div class="form-group clearfix col-xs-3"><label class="col-xs-3 label_name" for="form-field-1">所在地区： </label>
          <div class="col-xs-9 line_height1"> <input type="text" name="place" data-name="所在地区" id="place" value="${list[0].place}" class="col-xs-7 text_info" disabled="disabled"/></div>
          </div>
           <div class="form-group clearfix col-xs-3"><label class="col-xs-3 label_name" for="form-field-1">学校名称： </label>
          <div class="col-xs-9 line_height1"><input type="text" name="schoolname" data-name="学校名称" id="schoolname" value="${list[0].schoolname}" class="col-xs-7 text_info" disabled="disabled"/> </div>
          </div> 
          <div class="form-group clearfix col-xs-3"><label class="col-xs-3 label_name" for="form-field-1">辅导机构： </label>
          <div class="col-xs-9 line_height1"><input type="text" name="fudaoclass" data-name="辅导机构" id="fudaoclass" value="${list[0].fudaoclass}" class="col-xs-7 text_info" disabled="disabled"/> </div>
          </div> 
          <div class="form-group clearfix col-xs-3"><label class="col-xs-3 label_name" for="form-field-1">辅导教师： </label>
          <div class="col-xs-9 line_height1"><input type="text" name="fudaoteacher" data-name="辅导教师" id="fudaoteacher" value="${list[0].fudaoteacher}" class="col-xs-7 text_info" disabled="disabled"/></div>
          </div> 
          <div class="form-group clearfix col-xs-3"><label class="col-xs-3 label_name" for="form-field-1">家长姓名： </label>
          <div class="col-xs-9 line_height1"> <input type="text" name="parentsname" data-name="家长姓名" id="parentsname" value="${list[0].parentsname}" class="col-xs-7 text_info" disabled="disabled"/></div>
          </div>
          <div class="form-group clearfix col-xs-3"><label class="col-xs-3 label_name" for="form-field-1">家长电话： </label>
          <div class="col-xs-9 line_height1"><input type="text" name="parentstel" data-name="年龄" id="parentstel" value="${list[0].parentstel}" class="col-xs-7 text_info" disabled="disabled"/></div>
          </div>
           <div class="form-group clearfix col-xs-3"><label class="col-xs-3 label_name" for="form-field-1">登录次数： </label>
          <div class="col-xs-9 line_height1"> <span>${list[0].totlogin}</span></div>
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
 <form action="StudentServlet?action=updateme&sname=${list[0].sname}"method="post" id="form2">
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
 <form action="StudentServlet?action=updateme&sname=${list[0].sname}"method="post" id="form2">
      
         <div class="change_Pass_style display" id="resetPicture">
         
           <img src="images/${list[0].photo}" />
         </div>
         </form>
<!-- 图表 -->
<div class="dd_echarts">
   <div id="main" style="width:100%; height:550px;font-size:50%"></div>
  </div>
</body>
</html>
<script>
    var ajaxdata={};

    loadChart();


    function getAjax(){
        $.ajax({
            type : "post",
            async : false,
            url : "ScoreServlet?action=studentWelcomeChart",
            data : {'sname':'${list[0].sname}'},
            dataType : "json", //返回数据形式为json
            success : function(result) {
                if (result) {
                    	// alert(JSON.stringify(result));
                    ajaxdata=result;

                }

            },
            error : function(errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        });


    }

    function loadChart(){
        getAjax();
        /*********************/
        require.config({
            paths: {
                echarts: './js/dist'
            }
        });
        require(
            [
                'echarts',
                'echarts/theme/macarons',
                'echarts/chart/line',// 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
                'echarts/chart/bar'
                
            ],
            function (ec,theme) {
                var myChart = ec.init(document.getElementById('main'),theme);
                option = {
                    title : {
                        text: '每周考试记录',
                        subtext: '成绩记录'
                    },
                    tooltip : {
                        trigger: 'axis'
                    },
                    legend: {
                        data:['总分线','平均分线']
                    },
                    toolbox: {
                        show : true,
                        feature : {
                            mark : {show: true},
                            dataView : {show: true, readOnly: false},
                            magicType : {show: true, type: [ 'line','bar']},
                            restore : {show: true},
                            saveAsImage : {show: true}
                        }
                    },
                    calculable : true,
                    xAxis : [
                        {
                            type : 'category',
                            boundaryGap : false,
                            data : ajaxdata.examlist
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value',
                            axisLabel : {
                                formatter: '{value}分'
                            }
                        }
                    ],
                    series : [
                        {
                            name:'总分线',
                            type:'line',
                            data:ajaxdata.sumlist,
                            markPoint : {
                                data : [
                                    {type : 'max', name: '值'},
                                    {type : 'min', name: '值'}
                                ]
                            },
                            markLine : {
                                data : [
                                    {type : 'average', name: '平均值'}
                                ]
                            }
                        },

                        {
                            name:'平均分线',
                            type:'line',
                            data:ajaxdata.avglist,
                            markPoint : {
                                data : [
                                    {type : 'max', name: '值'},
                                    {type : 'min', name: '值'}
                                ]
                            },
                            markLine : {
                                data : [
                                    {type : 'average', name : '平均值'}
                                ]
                            }
                        }
                    ]
                };

                myChart.setOption(option);
            }
        );
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
	title:'重传照片',
	area: ['500px','500px'],
	shadeClose: true,
	content:'<img src="${list[0].photopath}" />',
/* 	btn:['确认修改'], */
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
