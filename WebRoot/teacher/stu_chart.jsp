<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String sname=request.getParameter("sname");
    System.out.println(sname);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>$Title$</title>
</head>
<body>
<!-- 图表 -->
<div class="dd_echarts">
    <div id="main" style="width:100%; height:550px;font-size:50%"></div>
</div>
</body>
<script src="js/jquery-1.9.1.min.js" type="text/javascript" ></script>
<%--<script src="js/dist/echarts.js" type="text/javascript"></script>--%>
<script src="https://cdn.bootcss.com/echarts/4.2.1/echarts.js"></script>
<script src="js/jquery.dataTables.min.js"  type="text/javascript"></script>
<script src="js/jquery.dataTables.bootstrap.js" type="text/javascript"></script>
<script type="text/javascript">
    var ajaxdata={};
    var myChart = echarts.init(document.getElementById('main'));
    loadChart();


    function getAjax(){
        $.ajax({
            type : "post",
            async : false,
            url : "<%=basePath%>ScoreServlet?action=studentWelcomeChart",
            data : {'sname':'<%=sname%>'},
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


                // option = {
                //     title : {
                //         text: '每周考试记录',
                //         subtext: '成绩记录'
                //     },
                //     tooltip : {
                //         trigger: 'axis'
                //     },
                //     legend: {
                //         // data:['排名','平均分线']
                //         data:['排名']
                //     },
                //     toolbox: {
                //         show : true,
                //         feature : {
                //             mark : {show: true},
                //             dataView : {show: true, readOnly: false},
                //             magicType : {show: true, type: ['line', 'bar']},
                //             restore : {show: true},
                //             saveAsImage : {show: true}
                //         }
                //     },
                //     calculable : true,
                //     xAxis : [
                //         {
                //             axisLine:{onZero:false},
                //             type : 'category',
                //             boundaryGap : false,
                //             data : ajaxdata.examlist
                //         }
                //     ],
                //     yAxis : [
                //         {
                //             type : 'value',
                //             inverse: true,
                //             axisLabel : {
                //                 // formatter: '{value}分'
                //                 formatter: '{value}名'
                //             }
                //         }
                //     ],
                //     series : [
                //         {
                //             name:'名次',
                //             type:'line',
                //             data:ajaxdata.sumlist,
                //             markPoint : {
                //                 data : [
                //                     {type : 'max', name: '最大值'},
                //                     {type : 'min', name: '最小值'}
                //                 ]
                //             },
                //             markLine : {
                //                 data : [
                //                     {type : 'average', name: '平均值'}
                //                 ]
                //             }
                //         }
                //
                //     ]
                // };


        option = {
            title: {
                text: '每周考试记录',
                subtext: '考试名次'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data:['排名']
            },
            toolbox: {
                show: true,
                feature: {
                    dataZoom: {
                        yAxisIndex: 'none'
                    },
                    dataView: {readOnly: false},
                    magicType: {type: ['line']},
                    restore: {},
                    saveAsImage: {}
                }
            },
            xAxis:  {
                axisLine:{onZero:false},
                type: 'category',
                boundaryGap: false,
                data: ajaxdata.examlist
            },
            yAxis: {
                type: 'value',
                inverse: true,
                axisLabel: {
                    formatter: '{value}名'
                }
            },
            series: [
                {
                    name:'名次',
                    type:'line',
                    data:ajaxdata.sumlist,
                    markPoint: {
                        data: [
                            {name: '最好成绩', value: "最好成绩", type:'min',valueIndex:1}
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
                                        formatter: '最差名次'
                                    }
                                },
                                type: 'max',
                                name: '最好名次'
                            }]
                        ]
                    }
                }
            ]
        };

                myChart.setOption(option);
            // }
        // );
    }
</script>
</html>
