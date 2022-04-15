<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Android污点分析</title>

    <!-- Bootstrap core CSS -->
    <link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
     <link href="./css/IndexStyle.css" rel="stylesheet">
     <script type="text/javascript" src="./echarts.js"></script>

</head>

<body>

<div class="site-wrapper">

    <div class="site-wrapper-inner">

        <div class="cover-container">

            <div class="masthead clearfix">
                <div class="inner">
                    <h3 class="masthead-brand"><a href="index.jsp">Android污点分析</a></h3>
                    <nav>
                        <ul class="nav masthead-nav">
                            <li class="active"><a href="index.jsp">主页</a></li>
                            <li><a href="/TestProject/FunctionServlet">功能</a></li>
                            <li><a href="about.jsp">关于</a></li>
                        </ul>
                    </nav>
                </div>
            </div>

			<br>
			<br>
			<br>
			<br>
			<div id="loading" style="height: 500px; width:500px; margin:0 auto;display: none;"></div>
            <div id="whole" class="inner cover">          	
                <h1 class="cover-heading">Android在线分析工具</h1>
                <p class="lead">即刻使用基于静态污点分析技术开发的FlowDroid、FastDroid工具对Android应用进行分析，获取可能潜藏的敏感行为、敏感权限并生成多维度的分析报告</p>
                <p class="lead">
                  ${fileName} ${message} ${formatError}                  
                  
				<a href="/TestProject/CoreAnalyzeServlet?filename=${fileName}"><input id="hide" type="submit" value="开始分析" class="btn btn-lg btn-default"></a>
					
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

            <div id ="foot" class="mastfoot">
                <div class="inner">
                    <p>Powered by XDU</p>
                </div>
            </div>

        </div>

    </div>

</div>



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
        color:'pink'
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
</body>
</html>