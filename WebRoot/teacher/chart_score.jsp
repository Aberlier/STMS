<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:if test="${role!='教师' && role!='管理员'}"> 
<script>window.parent.parent.location.href='index.jsp';</script>
</c:if>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html style="height: 80%">
<head>

<%--<%@ include file="commonhead.jsp" %>--%>

</head>
<body class="zh_CN realnameRegPage"  style="height: 100%; margin: 0">

    <!-- 标题区 start -->	
    <ul id="tabsmenu" class="tabsmenu">
		<li class="active"><a class="mylink1" style='height:18px;font-family:"微软雅黑"'>成绩统计图</a>
		</li>
	</ul>
    <!-- 标题区 end-->
    
     <!-- 搜索区 start -->	
	    <form method="post" action="">
		<table style="white-space:nowrap;" width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
		       <td>
		             <table width="100%" border="0" cellpadding="10" cellspacing="0" bgcolor="#a8c7ce" style='text-align:left;height:30px'>
						    <tr>
							   <td bgcolor="#FFFFFF" style="">
								
	 
								   届数： <select id="jieshu" name="classname" class="myselect3">
								   			<option value="${d.classname}" <c:if test="${d.classname==classname}">selected='selected'</c:if>>${d.classname}</option>
										 </select> 
	
								   
							
								   <c:if test="${role=='教师'|| role=='管理员'}">
								    班级：<select id="sclassnum" name="sclassnum" class="myselect3">
								    			<option value="all">请选择班级</option>
											    <c:forEach items="${list2}" var="d" varStatus="status">
											       <option value="${d.classnum}" <c:if test="${d.classnum==sclassnum}">selected='selected'</c:if>>${d.classnum}</option>
											    </c:forEach>
									</select>&nbsp;&nbsp;
								   </c:if> 
								   
									考试：<select id="examselect" name="sclassnum" class="myselect3">
								   <option value="1">第一次模拟考试</option>
								   <option value="2">第二次模拟考试</option>
								   <option value="3">第三次模拟考试</option>
							   </select>
								     <input onmouseover="this.style.cursor='hand';" value="查询" type="button" onclick="loadChart()" class="form_submit"/>
							         
							   </td>   
			                </tr>
			           </table>
			       </td>
			    </tr>
		    </table>
		</form>
	    <!-- 搜索区 end-->

	<div id="tab1" class="tabcontent" style="height: 100%">
	
	
		
	    
	     <div id="container" style="height: 100%;width:100%;"></div>

	</div>

		
	


</body>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-gl/echarts-gl.min.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-stat/ecStat.min.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/dataTool.min.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/world.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/bmap.min.js"></script>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/simplex.js"></script>
<script type="text/javascript" src="js/shine.js"></script>
<script type="text/javascript">




	
var dom = document.getElementById("container");
var myChart = echarts.init(dom,'shine');
var app = {};
option = null;
var data={};

loadChart();

function loadChart(){
	getAjax();
	option = {
		title: {
			text: '成绩趋势图',
			subtext: '学生成绩趋势'
		},
		tooltip: {
			trigger: 'axis'
		},
		legend: {
			data:['平均分','优秀率','及格率']
		},
		toolbox: {
			show: true,
			feature: {
				dataZoom: {
					yAxisIndex: 'none'
				},
				dataView: {readOnly: false},
				magicType: {type: ['line', 'bar']},
				restore: {},
				saveAsImage: {}
			}
		},
		xAxis:  {
			type: 'category',
			boundaryGap: false,
			data: ['周一','周二','周三','周四','周五','周六','周日']
		},
		yAxis: {
			type: 'value',
			axisLabel: {
				formatter: '{value}分'
			}
		},
		series: [
			{
				name:'平均分',
				type:'line',
				data:[90, 80, 68, 78, 89, 99, 98],
				markPoint: {
					data: [
						{type: 'max', name: '最大值'},
						{type: 'min', name: '最小值'}
					]
				},
				markLine: {
					data: [
						{type: 'average', name: '平均值'}
					]
				}
			},
			{
				name:'优秀率',
				type:'line',
				data:[23, 34, 56, 45, 52, 34, 42],
				markPoint: {
					data: [
						{name: '周最低', value: -2, xAxis: 1, yAxis: -1.5}
					]
				},
				markLine: {
					data: [
						{type: 'average', name: '平均值'},
						[{
							symbol: 'none',
							x: '90%',
							yAxis: 'max'
						}, {
							symbol: 'circle',
							label: {
								normal: {
									position: 'start',
									formatter: '最大值'
								}
							},
							type: 'max',
							name: '最高点'
						}]
					]
				}
			},
			{
				name:'及格率',
				type:'line',
				data:[78, 65, 86, 78, 89, 56, 68],
				markPoint: {
					data: [
						{name: '周最低', value: -2, xAxis: 1, yAxis: -1.5}
					]
				},
				markLine: {
					data: [
						{type: 'average', name: '平均值'},
						[{
							symbol: 'none',
							x: '90%',
							yAxis: 'max'
						}, {
							symbol: 'circle',
							label: {
								normal: {
									position: 'start',
									formatter: '最大值'
								}
							},
							type: 'max',
							name: '最高点'
						}]
					]
				}
			}
		]
	};











if (option && typeof option === "object") {
    myChart.setOption(option, true);
}
// myChart.on('click', function (params) {
// //alert(JSON.stringify(data.departMap));
// //alert(params.name);
//    // window.open('gl?act=list_teacher&sdepartid='+data.departMap[params.name]);
//    location.href='gl?act=list_teacher&sdepartid='+data.departMap[params.name];
//
// });



}


function getAjax(){
	//alert($("#grade").val());
	$.ajax({
		type : "post",
		async : false, 
		url : "<%=basePath%>ScoreServlet?action=teaChartScore",
		data : {"tname":${tname}},
		dataType : "json", //返回数据形式为json
		success : function(result) {
			//请求成功时执行该函数内容，result即为服务器返回的json对象
			alert(JSON.stringify(result));
			if (result) {
			//	alert(JSON.stringify(result));
				data=result;
				
			}

		},
		error : function(errorMsg) {
			//请求失败时执行该函数
			alert("图表请求数据失败!");
			myChart.hideLoading();
		}
	});
}


</script>
</html>
