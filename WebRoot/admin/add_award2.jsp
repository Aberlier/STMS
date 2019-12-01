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
<link href="css/Sellerber.css" type="text/css"  rel="stylesheet" />
<link href="css/bkg_ui.css" type="text/css"  rel="stylesheet" />
<link href="font/css/font-awesome.min.css"  rel="stylesheet" type="text/css" />
<script src="js/jquery-1.9.1.min.js" type="text/javascript" ></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script src="js/shopFrame.js" type="text/javascript"></script>
<script src="js/Sellerber.js" type="text/javascript"></script>
<script src="js/layer/layer.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/jquery.dataTables.bootstrap.js"></script>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<script src="js/css3-mediaqueries.js"  type="text/javascript"></script>
<title>添加奖项</title>
</head>
<body>
 <form action="ExaminationServlet?action=addAward2" method="post" id="form-admin-add">
   <input type="hidden" value="${sid}" name="sid"/>
<div id="ad_sort" >
 <div class="add_style">
  
     <ul>
    <li class="clearfix">
      <label class="label_name col-xs-4 col-lg-4"><i class="c-red">*</i>请选择奖项类型：</label>
      <div class="formControls col-xs-6"> <span class="select-box" style="width:150px;">
				<select class="select input-text col-xs-10" name="award"id="award" size="1">
					<option >请选择奖项类型</option>
					 <c:forEach items="${list}" var="record">
         			 <option >${record.award}</option>
                     </c:forEach>
				</select>
				</span>
         </div>
     </li>
   
   <li class="clearfix" style="margin-left:250px"><span class="cont_style col-xs-9"><input  value="保存"type="button" onclick="submitClick()" id="form-field-1" class="" />&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input name="spwd" value="重置"type="reset" id="form-field-1" class="" /></span></li>
  </ul>
 </div>
</div>
</form>
</body>
</html>
<script>
/*******滚动条*******/
$("body").niceScroll({  
	cursorcolor:"#888888",  
	cursoropacitymax:1,  
	touchbehavior:false,  
	cursorwidth:"5px",  
	cursorborder:"0",  
	cursorborderradius:"5px"  
});
function submitClick() {
if(award.value==""){
      alert("请输入奖项名称");
      award.focus();
      return;
   }
    $("#form1").submit();
    window.parent.location.reload();
    parent.layer.close(index);
}
</script>

