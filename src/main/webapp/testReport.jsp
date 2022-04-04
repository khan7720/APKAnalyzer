<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%">
    <head>
        <meta charset="utf-8">
    </head>
    <body style="height: 100%; margin: 0">
    	<div >
    		<h1 align="center">分析结果</h1>
	    	<table align="center" width="760px" border="1px" bordercolor="pink" cellspacing="0" cellpadding="10">
	    		<tbody>
		    		<tr>
		    		 <td>应用名称</td><td>${ApknameToShow}</td>
		    		</tr>
		    		<tr>
		    		 <td>APK大小</td><td>${ApkSizeToShow} KB</td>
		    		</tr>
		    		<tr>                                                                
		    		 <td>代码数量</td><td>${CodeSizeToShow} 行</td>
		    		</tr>
		    		<tr>
		    		 <td>CFG构造时间</td><td>${CFGTimeToShow} S</td>
		    		</tr>
		    		<tr>
		    		 <td>FastDroid分析时间</td><td>${FastDroidTimeToShow} S</td>
		    		</tr>
		    		<tr>
		    		 <td>已分析类</td><td>${AnalysedClassToShow}</td>
		    		</tr>
		    		<tr>
		    		 <td>已分析方法</td><td>${AnalysedMethodToShow}</td>
		    		</tr>
		    		<tr>
		    		 <td>已分析语句</td><td>${AnalysedStatementToShow}</td>
		    		</tr>
		    		<tr>
		    		 <td>污染流数</td><td>${TaintFlowToShow}</td>
		    		</tr>
		    		<tr>
		    		 <td>可能的污染流数</td><td>${MayTaintFlowToShow}</td>
		    		</tr>
		    		<tr>
		    		 <td>开始分析时间</td><td>${StartTimeToShow}</td>
		    		</tr>
		    		<tr>
		    		 <td>权限</td><td>${PermissionToShow}</td>
		    		</tr>
		    		<tr>
		    		 <td>API</td><td>${APIToShow}</td>
		    		</tr>
	    		</tbody>
	    	</table>
		</div>
        <div id="container" style="height: 300px; width:300px; margin:0 auto"></div>

        
        <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts@5.3.1/dist/echarts.min.js"></script>
        <script type="text/javascript">
var dom = document.getElementById("container");
var myChart = echarts.init(dom);
var app = {};

var option;



option = {
  tooltip: {
    trigger: 'item'
  },
  legend: {
    top: '5%',
    left: 'center'
  },
  series: [
    {
      name: '权限信息',
      type: 'pie',
      radius: ['40%', '70%'],
      avoidLabelOverlap: false,
      animation:false,
      itemStyle: {
        borderRadius: 10,
        borderColor: '#fff',
        borderWidth: 2
      },
      label: {
        show: false,
        position: 'center'
      },
      emphasis: {
        label: {
          show: true,
          fontSize: '40',
          fontWeight: 'bold'
        }
      },
      labelLine: {
        show: false
      },
      data: [
        { value: 2, name: '危险权限',itemStyle:{color:'red'} },
        { value: 1, name: '正常权限',itemStyle:{color:'green'} },
        { value: 1, name: '特殊权限',itemStyle:{color:'yellow'} },
      ]
    }
    
    
  ]
};

if (option && typeof option === 'object') {
    myChart.setOption(option);
}

        </script>
    </body>
</html>