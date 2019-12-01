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
<title>管理系统</title>
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
   <div class="r_f Columns_top clearfix" >
     <div class="administrator l_f" style="right:20%;width:70%">
       <!-- <img src="images/avatar.png"  width="36px"/> --><span class="user-info" >欢迎你${loginname},${role}</span>
       <ul class="dropdown-menu">
        <li><a href="javaScript::" id="Exit_system"><i class="fa fa-user-times"></i>退出</a></li>
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
         <li><a class="colorpick-btn" href="javascript:ovid()"data-val="default"  id="default" style="background-color:#222A2D" ></a></li>
         <li><a class="colorpick-btn  selected" href="javascript:ovid()" data-val="blue" style="background-color:#438EB9;" ></a></li>
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
     <dt class="shop_index nav_link " ><a href="javascript:void(0)" name="../AdminServlet?action=superadmin_findbyId&adminname=${loginname}" class="iframeurl" title=""><i class="fa fa-angle-double-right"></i><span class="menu-text">管理员首页</span></a></dt>
     <dd class="submenu" style="height:0px; border:0px;"></dd>
     <dt class="nav_link ">
     <a href="javascript:void(0)" class="dropdown-toggle title_nav"><i class="fa fa-desktop"></i><span class="menu-text"> 角色管理 </span><b class="arrow fa fa-angle-down"></b></a>
     </dt>
     <dd class="submenu">
       <ul>
         <li class="home"><a href="javascript:void(0)" name="../AdminServlet?action=findAll_stu" title="学生管理" class="iframeurl"><i class="fa fa-angle-double-right"></i>学生管理</a></li>
         <li class="home"><a href="javascript:void(0)" name="../AdminServlet?action=findAll_tea" title="教师管理" class="iframeurl"><i class="fa fa-angle-double-right"></i>教师管理</a></li>
         <li class="home"><a href="javascript:void(0)" name="../AdminServlet?action=findAll_adm" title="管理员管理" class="iframeurl"><i class="fa fa-angle-double-right"></i>管理员账户管理</a></li>
         </ul>
      </dd>
 
 <dt class="nav_link ">
     <a href="javascript:void(0)" class="dropdown-toggle title_nav"><i class="fa fa-desktop"></i><span class="menu-text"> 报考管理</span><b class="arrow fa fa-angle-down"></b></a>
     </dt>
     <dd class="submenu">
       <ul>
         <li class="home"><a href="javascript:void(0)" name="../StudentServlet?action=admin_findAll_baokao" title="" class="iframeurl"><i class="fa fa-angle-double-right"></i>报考列表</a></li>
       </ul>
     </dd>
 
      <dt class="nav_link "><a href="javascript:void(0)" class="dropdown-toggle title_nav"><i class="fa fa-desktop"></i><span class="menu-text"> 培训机构管理 </span><b class="arrow fa fa-angle-down"></b></a></dt>
     <dd class="submenu">
       <ul>
         <li class="home"><a href="javascript:void(0)" name="../OrganizationServlet?action=findAll" title="培训机构列表" class="iframeurl"><i class="fa fa-angle-double-right"></i>培训机构列表</a></li>
         </ul>
      </dd>
        
     <dt class="nav_link "><a href="javascript:void(0)" class="dropdown-toggle title_nav"><i class="fa fa-desktop"></i><span class="menu-text"> 获奖管理 </span><b class="arrow fa fa-angle-down"></b></a></dt>
     <dd class="submenu">
       <ul>
<li class="home"><a href="javascript:void(0)" name="../ScoreServlet?action=adm_findAllScore" title="" class="iframeurl"><i class="fa fa-angle-double-right"></i>学生成绩</a></li>
<!--          <li class="home"><a href="javascript:void(0)" name="../ScoreServlet?action=adm_findAllScore2" title="" class="iframeurl"><i class="fa fa-angle-double-right"></i>学生复试成绩</a></li> -->
         <li class="home"><a href="javascript:void(0)" name="../AdminServlet?action=findAll_award" title="奖项设置" class="iframeurl"><i class="fa fa-angle-double-right"></i>奖项管理</a></li>
         <li class="home"><a href="javascript:void(0)" name="../ScoreServlet?action=toExportExcelAll" title="批量导出" class="iframeurl"><i class="fa fa-angle-double-right"></i>批量导出</a></li>
         </ul>
      </dd>
      
      
        
        <dt class="nav_link"><a href="#" class="dropdown-toggle title_nav"><i class="fa fa-credit-card"></i><span class="menu-text"> 考试管理 </span><b class="arrow fa fa-angle-down"></b></a></dt>
    <dd class="submenu">
     <ul>
       <li class="home"><a href="javascript:void(0)" name="../ExaminationServlet?action=add_exam_before&adminname=${loginname}" title="添加考试" class="iframeurl"><i class="fa fa-angle-double-right"></i>添加考试</a></li>
       <li class="home"><a href="javascript:void(0)" name="../ExaminationServlet?action=findAll_exam&adminname=${loginname}" title="考试列表" class="iframeurl"><i class="fa fa-angle-double-right"></i>考试列表</a></li>
       </ul>
    </dd>
        
        <dt class="nav_link "><a href="javascript:void(0)" class="dropdown-toggle title_nav"><i class="fa fa-desktop"></i><span class="menu-text">考试地点审核</span><b class="arrow fa fa-angle-down"></b></a></dt>
     <dd class="submenu">
       <ul>
         <li class="home"><a href="javascript:void(0)" name="../ExaminationServlet?action=findAll_ExamByWay&addpeople=${loginname}" title="考试地点列表" class="iframeurl"><i class="fa fa-angle-double-right"></i>考试地点列表</a></li>
         <li class="home"><a href="javascript:void(0)" name="../ExaminationServlet?action=add_ExamByWay_before&addpeople=${loginname}" title="添加考试地点" class="iframeurl"><i class="fa fa-angle-double-right"></i>添加考试地点</a></li>
         </ul>
      </dd>
        
  <!-- <dt class="nav_link"><a href="#" class="dropdown-toggle title_nav"><i class="fa fa-database"></i><span class="menu-text"> 文件管理 </span><b class="arrow fa fa-angle-down"></b></a></dt>
    <dd class="submenu">
     <ul>
       <li class="home"><a href="javascript:void(0)" name="../UploadServlet?action=adminfindAll&filetype=文本" title="文件列表" class="iframeurl"><i class="fa fa-angle-double-right"></i>文件列表</a></li>
       <li class="home"><a href="javascript:void(0)" name="../UploadServlet?action=adminfindAll&filetype=视频" title="视频列表" class="iframeurl"><i class="fa fa-angle-double-right"></i>视频列表</a></li>
       </ul>
      </dd>
      
      
      
    <dt class="nav_link"><a href="#" class="dropdown-toggle title_nav"><i class="fa fa-credit-card"></i><span class="menu-text"> 留言管理 </span><b class="arrow fa fa-angle-down"></b></a></dt>
    <dd class="submenu">
     <ul>
       <li class="home"><a href="javascript:void(0)" name="../MessageServlet?action=adminfindAll" title="留言列表" class="iframeurl"><i class="fa fa-angle-double-right"></i>留言列表</a></li>
       </ul>
    </dd> -->
      <dt class="nav_link"><a href="#" class="dropdown-toggle title_nav"><i class="fa  fa-th-list"></i><span class="menu-text"> 公告管理 </span><b class="arrow fa fa-angle-down"></b></a></dt>
    <dd class="submenu">
     <ul>
       <li class="home"><a href="javascript:void(0)" name="addinform.jsp" title="产品类表" class="iframeurl"><i class="fa fa-angle-double-right"></i>发布公告</a></li>
       <li class="home"><a href="javascript:void(0)" name="../FormServlet?action=adminfindAll" title="品牌管理" class="iframeurl"><i class="fa fa-angle-double-right"></i>公告列表</a></li>
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
        <li class="active home"><span title="我的桌面" data-href="index.jsp"><i class="fa fa-home home-icon"></i>首页</span></li>
      </ul>
      </div>
       <a id="js-tabNav-next" class="radius btn-default right_roll" href="javascript:;"><i class="fa fa-forward"></i></a>
       <div class="btn-group radius roll-right">
                    <a class="dropdown tabClose" data-toggle="dropdown" aria-expanded="false">
                        页签操作<i class="fa fa-caret-down" style="padding-left: 3px;"></i>
                    </a>
                    
                </div>
                <a href="javascript:void()" class="radius roll-right fullscreen"><i class="fa fa-arrows-alt"></i></a>
    </div>
  <!--具体内容-->  
  <div id="iframe_box" class="iframe_content">
  <div class="show_iframe" id="show_iframe">
       <iframe scrolling="yes" class="simei_iframe" frameborder="0" src="../FormServlet?action=adminfindAll" name="iframepage" data-href="index.jsp"></iframe>
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

