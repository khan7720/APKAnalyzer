<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="./css/logo.png">

    <title>Android污点分析</title>

    <!-- Bootstrap core CSS -->
    <link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link href="./css/Home.css" rel="stylesheet">

	<script type="text/javascript" src="./echarts.js"></script>

  </head>

  <body>

    <div class="container">
      <div class="header clearfix">
        <nav>
         <ul class="nav nav-pills pull-right">
            <li role="presentation" class="active"><a href="Home.html">主页 <span class="glyphicon glyphicon-home" aria-hidden="true"></span></a></li>
            <li role="presentation" ><a href="/TestProject/FunctionServlet">历史 <span class="glyphicon glyphicon-time" aria-hidden="true"></span></a></li>
            <li role="presentation" ><a href="about.html">关于 <span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span></a></li>
          </ul>
        </nav>
        <h3 class="text-muted"><a href="Home.html">Android污点分析</a><img src="./css/logo.png" width="30" height="30"/></h3>
        
      </div>

		
      <div  class="jumbotron">
      	<div id="loading" style="height: 500px; width:500px; margin:0 auto;display: none;"></div>   
      		<div id="whole">
        <h1 class="text-muted">运行结束</h1>
        <br>
        <br>
        <div class="alert alert-warning" role="alert"> ${filename} ${message}<span class="label label-info">结果</span></div> 
        <br>
        <br>
        <p class="lead">                               
				<a href="/TestProject/DownloadServlet?filename=${filename}&currentID=${currentID}"><input id="hide" type="submit" value="下载报告" class="btn btn-lg btn-success"></a>
   				<a href="/TestProject/ReportGenerateServlet?filename=${filename}&currentID=${currentID}"><input id="button" type="submit" value="查看结果" class="btn btn-lg btn-success"></a>
					 <script>
						function my(id){
							return document.getElementById(id);
						}
						my("hide").onclick=function(){
							my("whole").style.display="none";
							my("loading").style.display="inline-block";
						}
					</script> 
				</div>
      </div>

      <div class="row marketing">
        <div class="col-lg-6">
          <h4>权限信息</h4>
          <p>Android 将权限分为不同的类型，包括安装时权限、运行时权限和特殊权限。</p>

          <h4>API</h4>
          <p>Android应用程序编程接口是一些预先定义的可供调用的系统接口，应用程序可借此进行敏感操作。</p>

        </div>

        <div class="col-lg-6">      
          <h4>污点分析</h4>
          <p>污点分析是一种信息流分析技术,通过插桩、数据流分析等方法追踪程序中带污点标记的数据的传播以及泄露情况。</p>
          
          <h4>污染流</h4>
          <p>隐私数据从污点源经过污染变量到达泄露点的传播过程形成的数据流。</p>

        </div>
      </div>

      <footer class="footer">
        <p>© 2022 Powered by XDU</p>
      </footer>

    </div> <!-- /container -->
    
    <script type="text/javascript">
		var dom = document.getElementById("loading");
		var myChart = echarts.init(dom);
		var app = {};
		
		var option;
		
		
		
		option = {
		  title: {
		    text: '加载中，请稍候......',
		    x:'center',
		    textStyle:{
		        color:'green'
		      }
		  },
		  graphic: {
		    elements: [
		      {
		        type: 'group',
		        left: 'center',
		        top: 'center',
		        children: new Array(12).fill(0).map((val, i) => ({
		          type: 'rect',
		          x: i * 20,
		          shape: {
		            x: 0,
		            y: -40,
		            width: 10,
		            height: 80
		          },
		          style: {
		            fill: '#5470c6'
		          },
		          keyframeAnimation: {
		            duration: 1000,
		            delay: i * 200,
		            loop: true,
		            keyframes: [
		              {
		                percent: 0.5,
		                scaleY: 0.3,
		                easing: 'cubicIn'
		              },
		              {
		                percent: 1,
		                scaleY: 1,
		                easing: 'cubicOut'
		              }
		            ]
		          }
		        }))
		      }
		    ]
		  }
		};
		
		if (option && typeof option === 'object') {
		    myChart.setOption(option);
		}

        </script>


</body><div id="edge-translate-notifier-container" class="edge-translate-notifier-center"></div></html>