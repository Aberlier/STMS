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
    <title>Title</title>
</head>
<body>
<!-- 标题区 start -->
<ul id="tabsmenu" class="tabsmenu">
    <li class="active"><a class="mylink1" style='height:18px;font-family:"微软雅黑"'>成绩统计图</a>
    </li>
</ul>
<div id="main" style="width: 100%;height:600px;"></div>
</body>

<script src="js/jquery-1.9.1.min.js" type="text/javascript" ></script>
<script src="lib/echarts/echarts.js" type="text/javascript"></script>

<script type="text/javascript">

        var ajaxdata={};





    var myChart = echarts.init(document.getElementById('main'));
    loadChart();


    function getAjax(){
        $.ajax({
            type : "post",
            async : false,
            url : "<%=basePath%>ScoreServlet?action=stackBarData",
            data : {'tname':'${tname}'},
            dataType : "json", //返回数据形式为json
            success : function(result) {
                if (result) {
                    ajaxdata=result;
                    // myChart.setOption(option, true);
                }

            },
            error : function(errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        });

    }
    function loadChart() {
        getAjax();
        // option = {
        //     title: {
        //         text: '成绩趋势图',
        //         subtext: '学生成绩趋势'
        //     },
        //     tooltip: {
        //         trigger: 'axis'
        //     },
        //     legend: {
        //         data: ['平均分', '优秀率', '及格率']
        //     },
        //     toolbox: {
        //         show: true,
        //         feature: {
        //             dataZoom: {
        //                 yAxisIndex: 'none'
        //             },
        //             dataView: {readOnly: false},
        //             magicType: {type: ['line', 'bar']},
        //             restore: {},
        //             saveAsImage: {}
        //         }
        //     },
        //     xAxis: {
        //         type: 'category',
        //         boundaryGap: false,
        //         data: ajaxdata.resultExamList
        //     },
        //     yAxis: {
        //         type: 'value',
        //         axisLabel: {
        //             formatter: '{value}分'
        //         }
        //     },
        //     series: [
        //         {
        //             name: '平均分',
        //             type: 'line',
        //             data: ajaxdata.resultAvgList,
        //             markPoint: {
        //                 data: [
        //                     {type: 'max', name: '最大值'},
        //                     {type: 'min', name: '最小值'}
        //                 ]
        //             },
        //             markLine: {
        //                 data: [
        //                     {type: 'average', name: '平均值'}
        //                 ]
        //             }
        //         },
        //         {
        //             name: '优秀率',
        //             type: 'line',
        //             data: ajaxdata.resultYouxiulvList,
        //             markPoint: {
        //                 data: [
        //                     {name: '周最低', value: -2, xAxis: 1, yAxis: -1.5}
        //                 ]
        //             },
        //             markLine: {
        //                 data: [
        //                     {type: 'average', name: '平均值'},
        //                     [{
        //                         symbol: 'none',
        //                         x: '90%',
        //                         yAxis: 'max'
        //                     }, {
        //                         symbol: 'circle',
        //                         label: {
        //                             normal: {
        //                                 position: 'start',
        //                                 formatter: '最大值'
        //                             }
        //                         },
        //                         type: 'max',
        //                         name: '最高点'
        //                     }]
        //                 ]
        //             }
        //         },
        //         {
        //             name: '及格率',
        //             type: 'line',
        //             data: ajaxdata.resultJigelvList,
        //             markPoint: {
        //                 data: [
        //                     {name: '周最低', value: -2, xAxis: 1, yAxis: -1.5}
        //                 ]
        //             },
        //             markLine: {
        //                 data: [
        //                     {type: 'average', name: '平均值'},
        //                     [{
        //                         symbol: 'none',
        //                         x: '90%',
        //                         yAxis: 'max'
        //                     }, {
        //                         symbol: 'circle',
        //                         label: {
        //                             normal: {
        //                                 position: 'start',
        //                                 formatter: '最大值'
        //                             }
        //                         },
        //                         type: 'max',
        //                         name: '最高点'
        //                     }]
        //                 ]
        //             }
        //         }
        //     ]
        // };

        option = {
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            legend: {
                data: ['0~100', '101~200','201~300','301~400','401~500','501~600','601~800']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            yAxis:  {
                type: 'value'
            },
            xAxis: {
                type: 'category',
                data: ajaxdata.resultExamList
            },
            series: [
                {
                    name: '0~100',
                    type: 'bar',
                    stack: '人数',
                    label: {
                        normal: {
                            show: true,
                            position: 'insideRight'
                        }
                    },
                    data: ajaxdata.a0
                },
                {
                    name: '101~200',
                    type: 'bar',
                    stack: '人数',
                    label: {
                        normal: {
                            show: true,
                            position: 'insideRight'
                        }
                    },
                    data: ajaxdata.a5
                },
                {
                    name: '201~300',
                    type: 'bar',
                    stack: '人数',
                    label: {
                        normal: {
                            show: true,
                            position: 'insideRight'
                        }
                    },
                    data: ajaxdata.a6
                },
                {
                    name: '301~400',
                    type: 'bar',
                    stack: '人数',
                    label: {
                        normal: {
                            show: true,
                            position: 'insideRight'
                        }
                    },
                    data: ajaxdata.a7
                },
                {
                    name: '401~500',
                    type: 'bar',
                    stack: '人数',
                    label: {
                        normal: {
                            show: true,
                            position: 'insideRight'
                        }
                    },
                    data: ajaxdata.a8
                },
                {
                    name: '501~600',
                    type: 'bar',
                    stack: '人数',
                    label: {
                        normal: {
                            show: true,
                            position: 'insideRight'
                        }
                    },
                    data: ajaxdata.a9
                },
                {
                    name: '601~800',
                    type: 'bar',
                    stack: '人数',
                    label: {
                        normal: {
                            show: true,
                            position: 'insideRight'
                        }
                    },
                    data: ajaxdata.a10
                },

            ]
        };

        myChart.setOption(option);
    }

</script>
</html>
