<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"  %>
<%@ page import="com.test.demo.apiBean" %>
<%@ page import="com.test.demo.permissionBean"  %>
<%  ArrayList<permissionBean> plist = (ArrayList<permissionBean>)request.getAttribute("plist");%>
<%  ArrayList<apiBean> alist = (ArrayList<apiBean>)request.getAttribute("alist");%>
<%  String api1 = (String)request.getAttribute("SourceName");%>
<%  String caller1 = (String)request.getAttribute("SourceCaller");%>
<%  String api2 = (String)request.getAttribute("SinkName");%>
<%  String caller2 = (String)request.getAttribute("SinkCaller");%>
<%  String permission1 = (String)request.getAttribute("Permission1");%>
<%  String permission2 = (String)request.getAttribute("Permission2");%>
<%  int apiSize = alist.size();%>
<!DOCTYPE html>
<html lang="zh-CN"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="./css/logo.png">

    <title>分析结果</title>

   <!-- Bootstrap core CSS -->
    <link href="https://fastly.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.35/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="https://fastly.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.35/examples/grid/grid.css" rel="stylesheet">
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts@5.3.2/dist/echarts.min.js"></script>
  </head>

  <body onload="checkTF()">
  
	  <script type="text/javascript">
	  	function checkTF(){	if (<%=apiSize%>==0) document.getElementById('container6').remove();     }
	  </script>
    <div class="container">

      <div class="page-header" style="display: inline-block;">
        <h1>分析结果    <span class="label label-success">Report</span></h1>
        <p class="lead">通过本系统后台分析工具FastDroid所分析生成的多维度报告   <span class="glyphicon glyphicon-check" aria-hidden="true"></span></p>
      </div>
      <div style="display: inline-block;margin-left:300px">
      <a href="/TestProject/DownloadServlet?filename=${filename}&currentID=${currentID}"><input type="button" value="下载报告" class="btn btn-lg btn-primary" style="display: inline-block;"></a>
      </div>

      <h3>APK基本信息</h3>
      <p>了解APK的基本信息，包括<strong>代码量、权限、API及污染流</strong>等基础数据。</p>
	  <table class="table table-striped">
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
	      <script>
		    var strs='';
		    <% for(int i=0;i<plist.size();i++){
		    	permissionBean pb = plist.get(i);%>
		    	var str='';
		    	str+='<td>'+'<%=i+1%>'+'</td>';
		    	str+='<td>'+'<%=pb.getPname()%>'+'</td>';
		    	str+='<td>'+'<%=pb.getPlevel()%>'+'</td>';
				strs+='<tr>'+str+'</tr>';
		    <%}%>
		    document.getElementById("plist").innerHTML=strs;
	      </script>

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
      <script>
	    var strs='';
	    <% for(int i=0;i<alist.size();i++){
	    	apiBean ab = alist.get(i);%>
	    	var str='';
	    	str+='<td>'+'<%=i+1%>'+'</td>';
	    	str+='<td>'+'<%=ab.getAname()%>'+'</td>';
	    	str+='<td>'+'<%=ab.getCaller()%>'+'</td>';
	    	str+='<td>'+'<%=ab.getRouteType()%>'+'</td>';
			strs+='<tr>'+str+'</tr>';
	    <%}%>
	    document.getElementById("alist").innerHTML=strs;
      </script>
           
      <h3>图表展示<span class="label label-success">Chart</span></h3>

    </div> <!-- /container -->
    

    
     
        <div id="container1" style="height: 300px; width:300px; margin:0 auto"></div>
        
        


        <div style="text-align: center;">
        <div id="container2" style="height: 300px; width:300px; margin:0 auto;display: inline-block;"></div>
		<div id="container3" style="height: 300px; width:300px; margin:0 auto;display: inline-block;"></div>
		</div>
		
      
        
		<div style="text-align: center;">
		<div id="container4" style="height: 300px; width:300px; margin:0 auto;display: inline-block;"></div>
		<div id="container5" style="height: 300px; width:300px; margin:0 auto;display: inline-block;"></div>
		</div>
		<div id="container6" style="height: 700px; width:700px; margin:0 auto"></div>
		
        
        
        <script type="text/javascript">
var dom = document.getElementById("container1");
var myChart = echarts.init(dom);
var app = {};

var option;



option = {
  title:{
	  show:true,
	  text:'权限信息',
	  x:'center'
  },
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
 title:{
	  show:true,
	  text:'apk大小',
	  x:'center'
  },
  xAxis: {
    type: 'category',
    data: ['此apk大小', '平均大小']
  },
  yAxis: {
    type: 'value'
  },
  series: [
    {
      data: [${ApkSizeToShow}, ${apkSizeAverage}],
      type: 'bar',
      showBackground: true,
      animation:false,
      backgroundStyle: {
        color: 'rgba(180, 180, 180, 0.2)'
      },
      itemStyle:{
          normal:{
              color:'#4ad2ff'
          }
      },
      label:{
    	  show:true
      }
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
 title:{
	  show:true,
	  text:'代码数量',
	  x:'center'
  },
  xAxis: {
    type: 'category',
    data: ['此apk代码量', '平均代码量']
  },
  yAxis: {
    type: 'value'
  },
  series: [
    {
      data: [${CodeSizeToShow}, ${codeSizeAverage}],
      type: 'bar',
      showBackground: true,
      animation:false,
      backgroundStyle: {
        color: 'rgba(180, 180, 180, 0.2)'
      },
      itemStyle:{
          normal:{
              color:'#ffb6c1'
          }
      },
      label:{
    	  show:true
      }
    }
  ]
};

if (option && typeof option === 'object') {
    myChart.setOption(option);
}

        </script>
        
         <script type="text/javascript">
var dom = document.getElementById("container4");
var myChart = echarts.init(dom);
var app = {};

var option;



option = {
 title:{
	  show:true,
	  text:'CFG构造时间',
	  x:'center'
  },
  xAxis: {
    type: 'category',
    data: ['本次时间', '平均时间']
  },
  yAxis: {
    type: 'value'
  },
  series: [
    {
      data: [${CFGTimeToShow}, ${CFGAverage}],
      type: 'bar',
      showBackground: true,
      animation:false,
      backgroundStyle: {
        color: 'rgba(180, 180, 180, 0.2)'
      },
      label:{
    	  show:true
      }
    }
  ]
};

if (option && typeof option === 'object') {
    myChart.setOption(option);
}

        </script>
                 <script type="text/javascript">
var dom = document.getElementById("container5");
var myChart = echarts.init(dom);
var app = {};

var option;



option = {
 title:{
	  show:true,
	  text:'FastDroid分析时间',
	  x:'center'
  },
  xAxis: {
    type: 'category',
    data: ['本次时间', '平均时间']
  },
  yAxis: {
    type: 'value'
  },
  series: [
    {
      data: [${FastDroidTimeToShow}, ${FastDroidAverage}],
      type: 'bar',
      showBackground: true,
      animation:false,
      backgroundStyle: {
        color: 'rgba(180, 180, 180, 0.2)'
      },
      label:{
    	  show:true
      }
    }
  ]
};

if (option && typeof option === 'object') {
    myChart.setOption(option);
}

        </script>
 <script type="text/javascript">
var dom = document.getElementById("container6");
var myChart = echarts.init(dom);
var app = {};

var option;



option = {
  title: {
    text: '污染流图',
    x:'center'
  },
  tooltip: {},
  animation: false,

  series: [
    {
      type: 'graph',
      layout: 'none',
      symbol: 'Rect',
      color:'none',
      roam: false,
      label: {
        show: true
      },
      edgeSymbol: ['circle', 'arrow'],
      edgeSymbolSize: [4, 10],
      edgeLabel: {
        fontSize: 20
      },
      itemStyle: {
      borderColor: "black",
      borderWidth: 2
      },
      data: [
        {
          id:'source',
          name: 'Source',
          symbol: 'circle',
          x: 300,
          y: 700,
          symbolSize: 50,
        },
        {id:'sink',
          name: 'Sink',
          symbol: 'circle',
          x: 1000,
          y: -150,
          symbolSize: 50
        },
        {id:'api1',
          name:'<%=api1%>',
          x: 400,
          y: 500,
          symbolSize: [150,60]
        },
        {id:'permission1',
          name: '<%=permission1%>',
          x: 500,
          y: 700,
          symbolSize: [100,50],
          itemStyle: {
          borderColor: "red",
          borderWidth: 3
          }
        },
        {id:'permission2',
          name: '<%=permission2%>',
          x: 800,
          y: -150,
          symbolSize: [100,50],
          itemStyle: {
          borderColor: "red",
          borderWidth: 3
          }
        },
        {id:'api2',
          name: '<%=api2%>',
          x: 900,
          y: 50,
          symbolSize: [150,60]
        },
        {id:'caller1',
          name: '<%=caller1%>',
          x: 400,
          y: 50,
          symbolSize: [150,60]
        },
        {id:'caller2',
          name: '<%=caller2%>',
          x: 900,
          y: 500,
          symbolSize: [150,60]
        }
      ],
      // links: [],
      links: [
        {
          source: 'source',
          target: 'api1',
          lineStyle: {
            curveness: 0.2
          }
        },
        {
          source:'caller2',
          target: 'api2',
        },
        {
          source: 'caller1',
          target: 'api1',
        },
        {
          source: 'caller1',
          target: 'caller2',
          label: {
            show: true
          },
          lineStyle: {
            curveness: -0.2
          }
        },
         {
          source: 'api2',
          target: 'sink',
          lineStyle: {
            curveness: -0.2
          }
        },
          {
          source: 'permission1',
          target: 'api1',
        },
          {
          source: 'permission2',
          target: 'api2',
        }
      ],
      lineStyle: {
        opacity: 0.9,
        width: 2,
        curveness: 0
      }
    }
  ]
};


if (option && typeof option === 'object') {
    myChart.setOption(option);
}

        </script>


    
  

</body><div id="edge-translate-notifier-container" class="edge-translate-notifier-center"></div></html>