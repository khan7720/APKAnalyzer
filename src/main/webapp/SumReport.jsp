<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="./css/logo.png">

    <title>历史数据</title>

   <!-- Bootstrap core CSS -->
    <link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="./css/grid.css" rel="stylesheet">
	<script type="text/javascript" src="./echarts.js"></script>
  </head>

  <body>
    <div class="container">

      <div class="page-header" style="display: inline-block;">
        <h1>历史数据总结    <span class="label label-success">Summary</span></h1>
        <p class="lead">通过本系统后台分析工具FastDroid所分析生成的多维度报告   <span class="glyphicon glyphicon-check" aria-hidden="true"></span></p>
      </div>

      <h3>APK基本信息</h3>
      <p>了解APK的基本信息，包括<strong>代码量、权限、API及污染流</strong>等基础数据。</p>
	  <table class="table table-striped">
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
     

      <h3>权限信息</h3>
      <p>了解该Android应用的权限信息，<strong>可分为安装时权限、运行时权限和特殊权限。</strong>按照风险可划分为低中高三级别。</p>
      <table class="table table-striped">
	    	<tr>
	    		<td class="info" width="10%" >序号</td>
			    <td class="info" width="60%">权限名称</td>
			    <td class="info" width="30%">权限等级</td>
	    	</tr>
	  </table>
      <table id="plist" class="table table-striped"></table>


      <h3>API信息</h3>
      <p>了解该Android应用的API信息，<strong>包括名称、调用函数和处于污染流中的什么位置</strong>。</p>
	  <table class="table table-striped">
    	<tr>
    		<td class="info" width="5%" >序号</td>
		    <td class="info" width="70%">API名称</td>
		    <td class="info" width="19%">调用函数</td>
		    <td class="info" width="6%">TF位置</td>
    	</tr>
	  </table>
      <table id="alist" class="table table-striped"></table>

           
      <h3>图表展示<span class="label label-success">Chart</span></h3>

    </div> <!-- /container -->
    

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
     
</body><div id="edge-translate-notifier-container" class="edge-translate-notifier-center"></div></html>