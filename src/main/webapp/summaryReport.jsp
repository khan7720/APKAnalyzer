<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%">
    <head>
        <meta charset="utf-8">
    </head>
    <body style="height: 100%; margin: 0">
    	<div >
    		<h1 align="center">平台历史分析结果汇总</h1>
	    	<table align="center" width="760px" border="1px" bordercolor="pink" cellspacing="0" cellpadding="10">
	    		<tbody>
		    		<tr>
		    		 <td>已分析应用数量</td><td>${ApkSum}</td>
		    		</tr>
		    		<tr>
		    		 <td>已分析代码数量</td><td>${CodeSum} 行</td>
		    		</tr>
		    		<tr>
		    		 <td>CFG总构造时间</td><td>${CFGTimeSum} S</td>
		    		</tr>
		    		<tr>
		    		 <td>CFG平均构造时间</td><td>${CFGAverage} S</td>
		    		</tr>
		    		<tr>
		    		 <td>FastDroid总分析时间</td><td>${FastDroidSum} S</td>
		    		</tr>
		    		<tr>
		    		 <td>FastDroid平均分析时间</td><td>${FastDroidAverage} S</td>
		    		</tr>
		    		<tr>
		    		 <td>平台已分析类总数</td><td>${ClassSum}</td>
		    		</tr>
		    		<tr>
		    		 <td>平台已分析方法总数</td><td>${MethodSum}</td>
		    		</tr>
		    		<tr>
		    		 <td>平台已分析语句总数</td><td>${StatementSum}</td>
		    		</tr>
		    		<tr>
		    		 <td>发现的污染流总数</td><td>${TaintSum}</td>
		    		</tr>
		    		<tr>
		    		 <td>发现的可能污染流总数</td><td>${MayTaintSum}</td>
		    		</tr>
		    		<tr>
		    		 <td>已探查到的权限总数</td><td>${PermissionSum}</td>
		    		</tr>
		    		<tr>
		    		 <td>已探查到的API总数</td><td>${APISum}</td>
		    		</tr>
	    		</tbody>
	    	</table>
		</div>
        <div id="container1" style="height: 300px; width:300px; margin:0 auto"></div>
        <div id="container2" style="height: 400px; width:600px; margin:0 auto"></div>
        <div id="container3" style="height: 400px; width:600px; margin:0 auto"></div>

        
        <script type="text/javascript" src="./echarts.js"></script>
        <script type="text/javascript">
var dom = document.getElementById("container1");
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
        { value: ${dangerousCount}, name: '危险权限',itemStyle:{color:'red'} },
        { value: ${signatureCount}, name: '正常权限',itemStyle:{color:'green'} },
        { value: ${normalCount}, name: '特殊权限',itemStyle:{color:'yellow'} },
        { value: ${othersCount}, name: '其他权限',itemStyle:{color:'grey'} },
      ]
    }
    
    
  ]
};

if (option && typeof option === 'object') {
    myChart.setOption(option);
}

        </script>
         <script type="text/javascript">
var dom = document.getElementById("container2");
var myChart = echarts.init(dom);
var app = {};

var option;



option = {
  xAxis: {
    type: 'category',
    data: ['CFG平均时间', 'CFG最大时间', 'CFG最短时间'],
    axisLabel:{ 
        interval:0,//横轴信息全部显示    
     rotate:-15,//-15度角倾斜显示     
    }
  },
  yAxis: {
    type: 'value'
  },         
  series: [
    {
      data: [${CFGAverage}, ${CFGMax}, ${CFGMin}],
      type: 'bar',
      showBackground: true,
      backgroundStyle: {
        color: 'rgba(180, 180, 180, 0.2)'
      },
      itemStyle:{
          normal:{
              color:'#4ad2ff'
          }
      },
    }
  ]
};

if (option && typeof option === 'object') {
    myChart.setOption(option);
}

        </script>
                 <script type="text/javascript">
var dom = document.getElementById("container3");
var myChart = echarts.init(dom);
var app = {};

var option;



option = {
  xAxis: {
    type: 'category',
    data: ['FastDroid平均时间', 'FastDroid最大时间', 'FastDroid最短时间'],
    axisLabel:{ 
        interval:0,//横轴信息全部显示    
     rotate:-15,//-15度角倾斜显示     
    }
  },
  yAxis: {
    type: 'value'
  },         
  series: [
    {
      data: [${FastDroidAverage}, ${FastDroidMax}, ${FastDroidMin}],
      type: 'bar',
      showBackground: true,
      backgroundStyle: {
        color: 'rgba(180, 180, 180, 0.2)'
      },
      itemStyle:{
          normal:{
              color:'#ffb6c1'
          }
      },
    }
  ]
};

if (option && typeof option === 'object') {
    myChart.setOption(option);
}

        </script>
    </body>
</html>