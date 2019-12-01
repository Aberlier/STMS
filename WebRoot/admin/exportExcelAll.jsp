<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>奖项列表</title>

</head>

<body>
<div class="margin Competence_style" id="page_style">
<div class="operation clearfix">
<button class="btn button_btn btn-danger" type="button" onclick="exportAll()"><i class="fa fa-trash-o"></i>批量导出</button>
   <div class="search  clearfix">

</div>
</div>
<div class="compete_list"style="width:800px">

       <table id="sample_table" class="table table_list table_striped table-bordered dataTable no-footer">
		 <thead>
			<tr>
			  <th class="center"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
			  <th>编号</th>
			  <th>考试名称</th>
              <th >班主任</th>
				<th>考试类型</th>
             </tr>
		    </thead>
             <tbody>
            <c:forEach items="${list}" var="exam" varStatus="index">
			  <tr>
				<td class="center"><label><input name="ckeckinput" value="${index.index}" type="checkbox" class="ace"/><span class="lbl"></span></label></td>
				<td>${exam.eid}</td>
				<td>${exam.ename}</td>
				  <td>${exam.headmaster}</td>
				  <td>${exam.type}</td>
			   </tr>
			  </c:forEach>
			  

		      </tbody>
	        </table>
	        
     </div>
</div>
<form style="display: none" id="form1" action="<%=basePath%>ScoreServlet" >
	<input name="action" value="exportExcelAll"/>
	<input id="ids" name="ids"/>
</form>

</body>
</html>
<script>


/****复选框选中******/
$('table th input:checkbox').on('click' , function(){
					var that = this;
					$(this).closest('table').find('tr > td:first-child input:checkbox')
					.each(function(){
						this.checked = that.checked;
						$(this).closest('tr').toggleClass('selected');
					});
						
				});
function exportAll() {
		obj = document.getElementsByName("ckeckinput");
		check_val = [];
		for(k in obj){
			if(obj[k].checked)
				check_val.push(obj[k].value);
		}
		 // alert(check_val);
		$("#ids").val(check_val.toString())
		$("#form1").submit();
}
</script>
