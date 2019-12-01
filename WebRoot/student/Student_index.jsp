<%@ page language="java" import="java.util.*" pageEncoding="Utf-8"%>
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
<link href="skin/blue/skin.css" rel="stylesheet" type="text/css" id="skin" />
<link href="css/Sellerber.css" type="text/css"  rel="stylesheet" />
<link href="css/bkg_ui.css" type="text/css" rel="stylesheet" />
<link href="font/css/font-awesome.min.css"  rel="stylesheet" type="text/css" />
<script src="js/jquery-1.9.1.min.js" type="text/javascript" ></script>
<script src="js/layer/layer.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/Sellerber.js" type="text/javascript"></script>
<script src="js/shopFrame.js" type="text/javascript"></script>
<script src="js/jquery.nicescroll.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script> 
 <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <script type="text/javascript" src="js/PIE/PIE_IE678.js"></script>
<title>华创教育报名系统</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<style type="text/css">#login{
    font-size: 35px;
    font-weight: blod;
  }
</style>
</head>
<!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <script type="text/javascript" src="js/PIE/PIE_IE678.js"></script>
 <![endif]-->
<body>
${msg}
 <div class="Sellerber" id="Sellerber">
 <!--顶部-->
  <div class="Sellerber_header apex clearfix" id="Sellerber_header">
   <div class="l_f logo"id="login"><img src="images/log.png"width="500xp" height="65px" /></div>
   <div class="r_f Columns_top clearfix">
     <div class="administrator l_f">
      <%--  <img src="images/${list[0].photo}" width="36px"/> --%><span class="user-info">欢迎你${sname},${role}</span><i class="glyph-icon fa  fa-caret-down"></i>
       <ul class="dropdown-menu">
        <li class="home"><a href="../StudentServlet?action=studentfindbyId&sname=${sname}"class="iframeurl"><i class="fa fa-user"></i><span class="menu-text">个人信息</span></a></li>
        <li><a href="javascript:;" id="Exit_system"><i class="fa fa-user-times"></i>退出</a></li>
       </ul>
     </div>
   </div>
  </div>
<!--左侧-->
  <div class="Sellerber_left menu" id="menuBar">
    <div class="show_btn" id="rightArrow"><span></span></div>
    <div class="side_title"><a title="隐藏" class="close_btn"><span></span></a></div>
    <div class="menu_style" id="menu_style">
    <div class="list_content">
    <div class="skin_select">
      <ul class="dropdown-menu dropdown-caret">
         <li><a class="colorpick-btn " href="javascript:ovid()"data-val="default" id="default"  style="background-color:#222A2D" ></a></li>
         <li><a class="colorpick-btn selected" href="javascript:ovid()" data-val="blue" style="background-color:#438EB9;" ></a></li>
         <li><a class="colorpick-btn" href="javascript:ovid()" data-val="green" style="background-color:#72B63F;" ></a></li>
         <li><a class="colorpick-btn" href="javascript:ovid()" data-val="blue" style="background-color:#D0D0D0;" ></a></li>
         <li><a class="colorpick-btn" href="javascript:ovid()" data-val="blue" style="background-color:#FF6868;" ></a></li>
        </ul>     
     </div>
     <div class="search_style">
        <form action="#" method="get" class="sidebar_form">
                    <div class="input-group">
                        <input type="text" name="q" class="form-control">
                        <span class="input-group-btn">
                            <a class="btn_flat" href="javascript:" onclick=""><i class="fa fa-search"></i></a>
                        </span>
                    </div>
                </form>
     </div>     
    <dl class="nav nav-list" id="menu_list">
     <dt class="shop_index nav_link " ><a href="javascript:void(0)" name="../StudentServlet?action=studentfindbyId&sname=${sname}" class="iframeurl" title=""><i class="fa fa-angle-double-right"></i><span class="menu-text">首页</span></a></dt>
     <dd class="submenu" style="height:0px; border:0px;"></dd>
    
      <dt class="nav_link"><a href="#" class="dropdown-toggle title_nav"><i class="fa fa-database"></i><span class="menu-text">成绩查询 </span><b class="arrow fa fa-angle-down"></b></a></dt>
    <dd class="submenu">
     <ul>
       <li class="home"><a href="javascript:void(0)" name="../ScoreServlet?action=stu_findAllScore&sname=${sname}" title="我的初试成绩" class="iframeurl"><i class="fa fa-angle-double-right"></i>我的成绩</a></li>
<%--        <li class="home"><a href="javascript:void(0)" name="../ScoreServlet?action=findAll_fushi&sname=${sname}" title="我的复试成绩" class="iframeurl"><i class="fa fa-angle-double-right"></i>我的复试成绩</a></li> --%>
       <li class="home"><a href="javascript:void(0)" name="../ScoreServlet?action=findAllScore&sname=${sname}" title="成绩分布" class="iframeurl"><i class="fa fa-angle-double-right"></i>成绩分布</a></li>
       </ul>
      </dd>
     
       <dt class="nav_link ">
     <a href="javascript:void(0)" class="dropdown-toggle title_nav"><i class="fa fa-file-text-o"></i><span class="menu-text">考试报名 </span><b class="arrow fa fa-angle-down"></b></a>
     </dt>
     <dd class="submenu">
       <ul>
         <li class="home"><a href="javascript:void(0)" name="../ExaminationServlet?action=addbaokao_before&sname=${sname}" title="填报信息" class="iframeurl"><i class="fa fa-angle-double-right"></i>填报信息</a></li>
          <li class="home"><a href="javascript:void(0)" name="../ExaminationServlet?action=findAll&sname=${sname}" title="我的报考" class="iframeurl"><i class="fa fa-angle-double-right"></i>我的报考</a></li>
         </ul>
    </dd>
     
     <%-- <dt class="nav_link ">
     <a href="javascript:void(0)" class="dropdown-toggle title_nav"><i class="fa fa-desktop"></i><span class="menu-text"> 上传资料 </span><b class="arrow fa fa-angle-down"></b></a>
     </dt>
     <dd class="submenu">
       <ul>
         <li class="home"><a href="javascript:void(0)" name="upload.jsp?sno=${sno}" title="上传文件" class="iframeurl"><i class="fa fa-angle-double-right"></i>上传文件</a></li>
          <li class="home"><a href="javascript:void(0)" name="upload_video.jsp?sno=${sno}" title="上传文件" class="iframeurl"><i class="fa fa-angle-double-right"></i>上传视频</a></li>
         </ul>
    </dd>
  <dt class="nav_link"><a href="#" class="dropdown-toggle title_nav"><i class="fa fa-database"></i><span class="menu-text"> 文件管理 </span><b class="arrow fa fa-angle-down"></b></a></dt>
    <dd class="submenu">
     <ul>
       <li class="home"><a href="javascript:void(0)" name="../UploadServlet?action=findAll&filetype=文本" title="文件列表" class="iframeurl"><i class="fa fa-angle-double-right"></i>文件列表</a></li>
       <li class="home"><a href="javascript:void(0)" name="../UploadServlet?action=findAll&filetype=视频" title="视频列表" class="iframeurl"><i class="fa fa-angle-double-right"></i>视频列表</a></li>
       </ul>
      </dd>
       <dt class="nav_link"><a href="#" class="dropdown-toggle title_nav"><i class="fa fa-credit-card"></i><span class="menu-text"> 留言管理 </span><b class="arrow fa fa-angle-down"></b></a></dt>
    <dd class="submenu">
     <ul>
       <li class="home"><a href="javascript:void(0)" name="addmessage.jsp" title="发布留言" class="iframeurl"><i class="fa fa-angle-double-right"></i>发布留言</a></li>
       <li class="home"><a href="javascript:void(0)" name="../MessageServlet?action=findAll" title="留言列表" class="iframeurl"><i class="fa fa-angle-double-right"></i>留言列表</a></li>
       <li class="home"><a href="javascript:void(0)" name="../MessageServlet?action=listmymessage&sno=${sno}" title="我的留言" class="iframeurl"><i class="fa fa-angle-double-right"></i>我的留言</a></li>
       </ul>
      </dd> --%>
      <dt class="nav_link"><a href="#" class="dropdown-toggle title_nav"><i class="fa  fa-th-list"></i><span class="menu-text"> 公告管理 </span><b class="arrow fa fa-angle-down"></b></a></dt>
    <dd class="submenu">
     <ul>
       <li class="home"><a href="javascript:void(0)" name="../FormServlet?action=findAll" title="品牌管理" class="iframeurl"><i class="fa fa-angle-double-right"></i>公告列表</a></li>
       </ul>
      </dd>   
    </dl>  
    </div>
  </div>
 </div>
<!--内容-->
  <div class="Sellerber_content" id="contents">
    <div class="breadcrumbs" id="breadcrumbs">
       <a id="js-tabNav-prev" class="radius btn-default left_roll" href="javascript:;"><i class="fa fa-backward"></i></a>
       <div class="breadcrumb_style clearfix">
	  <ul class="breadcrumb clearfix" id="min_title_list">
        <li class="active home"><span title="通知" data-href="inform.jsp"><i class="fa fa-home home-icon"></i>首页</span></li>
      </ul>
      </div>
       <a id="js-tabNav-next" class="radius btn-default right_roll" href="javascript:;"><i class="fa fa-forward"></i></a>
       <div class="btn-group radius roll-right">
                    <a class="dropdown tabClose" data-toggle="dropdown" aria-expanded="false">
                        页签操作<i class="fa fa-caret-down" style="padding-left: 3px;"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-right" id="dropdown_menu">
                        <li><a class="tabReload" href="javascript:void();">刷新当前</a></li>
                        <li><a class="tabCloseCurrent" href="javascript:void();">关闭当前</a></li>
                        <li><a class="tabCloseAll" href="javascript:void();">全部关闭</a></li>
                        <li><a class="tabCloseOther" href="javascript:void();">除此之外全部关闭</a></li>
                    </ul>
                </div>
                <a href="javascript:void()" class="radius roll-right fullscreen"><i class="fa fa-arrows-alt"></i></a>
    </div>
  <!--具体内容-->  
  <div id="iframe_box" class="iframe_content">
  <div class="show_iframe" id="show_iframe">
       <iframe scrolling="yes" class="simei_iframe" frameborder="0" src="../FormServlet?action=findAll" name="iframepage" data-href="inform.jsp"></iframe>
       </div>
      </div>
  </div>
<!--底部-->
  <div class="Sellerber_bottom info" id="bottom">
  <span class="l_f">版权所有：河南双法学会数学教育委员会
</span>
  </div>
 </div>
</body>
</html>
<script>
//设置框架
 $(function() { 
	$("#Sellerber").frame({
		float : 'left',
		color_btn:'.skin_select',
		header:70,//顶部高度
		bottom:30,//底部高度
		menu:200,//菜单栏宽度
		Sellerber_menu:'.list_content',
		Sellerber_header:'.Sellerber_header',
	});
});
//时间设置
  function currentTime(){ 
   var weekday=new Array(7)
	weekday[0]="星期一"
	weekday[1]="星期二"
	weekday[2]="星期三"
	weekday[3]="星期四"
	weekday[4]="星期五"
	weekday[5]="星期六"
	weekday[6]="星期日"	
    var d=new Date(),str='';	
    str+=d.getFullYear()+'年'; 
    str+=d.getMonth() + 1+'月'; 
    str+=d.getDate()+'日'; 
    str+=d.getHours()+'时'; 
    str+=d.getMinutes()+'分'; 
    str+= d.getSeconds()+'秒'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
	str+=weekday[d.getDay()-1]; 
    return str; 
} 
setInterval(function(){$('#time').html(currentTime)},1000); 
$('#Exit_system').on('click', function(){
      layer.confirm('是否确定退出系统？', {
     btn: ['是','否'] ,//按钮
	 icon:2,
    }, 
	function(){
	  location.href="../login.jsp";
    },function(){
	 
        
    });
});
</script>
<script type="text/javascript">
$("#menu_style").niceScroll({  
	cursorcolor:"#888888",  
	cursoropacitymax:1,  
	touchbehavior:false,  
	cursorwidth:"5px",  
	cursorborder:"0",  
	cursorborderradius:"5px"  
}); 
</script>

