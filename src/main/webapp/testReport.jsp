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
<!DOCTYPE html>
<html style="height: 100%">
    <head>
        <meta charset="utf-8">
    </head>
    <body style="height: 100%; margin: 0">
    <script type="text/javascript" src="./echarts.js"></script>
            
    
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
	    	
	    	<h3 align="center">权限信息</h3>
	  <div>
	    <table align="center" width="760px" border="1px" bordercolor="pink" cellspacing="0" cellpadding="10">
	    	<tr>
	    		<td width="9.9%" align="center">序号</td>
			    <td width="57.4%" align="center">权限名称</td>
			    <td width="32.6%" align="center">权限等级</td>
	    	</tr>
	    </table>
	    <table id="plist" align="center" width="760px" border="1px" bordercolor="pink" cellspacing="0" cellpadding="10"></table>
    </div>	
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
    
    
    	    	<h3 align="center">API信息</h3>
	  <div>
	    <table align="center" width="1325px"  bordercolor="pink" cellspacing="0" cellpadding="10">
	    	<tr>
	    		<td width="35px" align="center">序号</td>
			    <td width="895px" align="center">API名称</td>
			    <td width="310px" align="center">调用函数</td>
			    <td width="85px" align="center">污染流位置</td>
	    	</tr>
	    </table>
	    <table id="alist" align="center" width="760px" border="1px" bordercolor="pink" cellspacing="0" cellpadding="10"></table>
    </div>	
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
    
    <br>
    <br>
    <br>
    <br>
	    
	    
	    
		</div>
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
	  text:'CFG分析时间',
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
    text: '函数调用图',
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
          name: 'Source',
          symbol: 'circle',
          x: 300,
          y: 700,
          symbolSize: 50,
        },
        {
          name: 'Sink',
          symbol: 'circle',
          x: 1000,
          y: -150,
          symbolSize: 50
        },
        {
          name:'<%=api1%>',
          x: 400,
          y: 500,
          symbolSize: [150,60]
        },
        {
          name: '<%=permission1%>',
          x: 500,
          y: 700,
          symbolSize: [100,50],
          itemStyle: {
          borderColor: "red",
          borderWidth: 3
          }
        },
        {
          name: '<%=permission2%>',
          x: 800,
          y: -150,
          symbolSize: [100,50],
          itemStyle: {
          borderColor: "red",
          borderWidth: 3
          }
        },
        {
          name: '<%=api2%>',
          x: 900,
          y: 50,
          symbolSize: [150,60]
        },
        {
          name: '<%=caller1%>',
          x: 400,
          y: 50,
          symbolSize: [150,60]
        },
        {
          name: '<%=caller2%>',
          x: 900,
          y: 500,
          symbolSize: [150,60]
        }
      ],
      // links: [],
      links: [
        {
          source: 'Source',
          target: '<%=api1%>',
          lineStyle: {
            curveness: 0.2
          }
        },
        {
          source:'<%=caller2%>',
          target: '<%=api2%>',
        },
        {
          source: '<%=caller1%>',
          target: '<%=api1%>',
        },
        {
          source: '<%=caller1%>',
          target: '<%=caller2%>',
          label: {
            show: true
          },
          lineStyle: {
            curveness: -0.2
          }
        },
         {
          source: '<%=api2%>',
          target: 'Sink',
          lineStyle: {
            curveness: -0.2
          }
        },
          {
          source: '<%=permission1%>',
          target: '<%=api1%>',
        },
          {
          source: '<%=permission2%>',
          target: '<%=api2%>',
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
    </body>
</html>