<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="jquery/1.7.2/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="jquery/jquery.form.js"></script>
<!-- <script type="text/javascript">
$(function() {
     $("#inputExcel").change(function(){
        initProvince();
        // 获得文件
        var file = $("#inputExcel").val();
        //　截取上传的文件后缀
        var extension = file.substring(file.lastIndexOf("."),file.length);
        // 验证上传文件后缀是否合法
        var strRegex = "(.xls|.xlsx)$";
        var re = new RegExp(strRegex);
        var flag;
        // 如果不合法，在页面上显示出相应的提示消息
        if (!re.test(extension.toLowerCase())) {
            layer.msg('文件名不合法，请上传Excel文件！', {
                icon : 2
            });
          return false;
        }
        if(extension == ".xls"){
            flag = 0;
        }
        if(extension == ".xlsx"){
            flag = 1;
        }
        var parms = new Object();
        // Excel版本flag
        parms["flag"] = flag;
        //如果你用不到以下参数的话就可以不用写
        parms["provinceNames"] = JSON.stringify(provinceNames);
        //parms["areaNames"] = JSON.stringify(areaNames);
        var options = {
        //这个url是后台的接口网址
                url: ctx+'/UploadHandleServlet?action=inportTitles&t=' + getNowDate(), 
                type: "post",   
                data: parms,
                dataType: "json",  
                success: function (result) {
                    var json = eval(result);
                    if (json[Cons.RESULT] == Cons.SUCCESS) {
                        layer.msg('导入成功！', {
                            icon : 1
                        });
                    }else if(json[Cons.RESULT] == null){
                        layer.msg(json[Cons.RESULT_MSG], {
                            icon : 2
                        });
                    }else if(json[Cons.RESULT] == "codeDuplication"){
                        layer.msg(json[Cons.RESULT_MSG], {
                            icon : 2
                        });
                    }else if(json[Cons.RESULT] == "telError"){
                        layer.msg(json[Cons.RESULT_MSG], {
                            icon : 2
                        });
                    }else if(json[Cons.RESULT] == "provinceError"){
                        layer.msg(json[Cons.RESULT_MSG], {
                            icon : 2
                        });
                    }else {
                        layer.msg('导入失败！', {
                        icon : 2
                    });
                    }
                    setTimeout('window.location.reload()',2000);
                } 
         }; 
        $("#form1").ajaxSubmit(options);
     }); 
 });
</script> -->
<body>
 
<!-- 导入excel表格
<form id="form1" action="" method="post" enctype="multipart/form-data"> 
	<table>  
	     <tr>  
	          <td>上传文件：</td>  
	          <td>
	          <input type="file" name="fileData" />
	          </td>  
	     </tr>
	</table>
</form>
<button id="inputExcel" >确定</button>
servlet/DownLoadServlet
上传的文件<a id="download" href=""></a> -->





<form action="${pageContext.request.contextPath}/UploadHandleServlet?action=inportTitles&headmaster=${headmaster}"
                      data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}" id="titleForm"
                      class="form-horizontal" role="form" enctype="multipart/form-data" method="post">
                 <div class="form-group">
                        <label class="control-label col-sm-3">考试批次：</label>
                        <div class="col-sm-5">
                            <select name="territory" id="territoryIdss" class="form-control">
                                <option value="0">请选择考试批次</option>
								<option value="1">第一次模拟考试</option>
								<option value="2">第二次模拟考试</option>
								<option value="3">第三次次模拟考试</option>
								<option value="4">第一次摸底考试</option>
								<option value="4">第一次周考</option>
								<option value="4">第二次周考</option>
								<option value="4">期中考试</option>
								<option value="5">期末考试</option>
								
                            </select>
                        </div>
                    </div>
                   
                    
                    <div class="form-group">
                        <label class="control-label col-sm-3">上传文件：</label>
                        <div class="col-sm-6">
                            <input id="articleImageFile" name="f1" type="file" class="form-control"
                                   style="width:100%; display: inline;"/>
                        </div>
                    </div>
                    <div class="form-inline">
                        <div class="col-sm-offset-9">
                            <input type="submit" class="btn btn-primary btn-sm" value="导入"/>
                        </div>
                    </div>

                </form>

</body>
</html>