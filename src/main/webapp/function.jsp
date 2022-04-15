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

    <title>Android污点分析 </title>

    <!-- Bootstrap core CSS -->
    <link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
     <link href="./css/IndexStyle.css" rel="stylesheet">
  

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
                            <li><a href="index.jsp">主页</a></li>
                            <li class="active"><a href="/TestProject/FunctionServlet">功能</a></li>
                            <li><a href="about.jsp">关于</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
			
			
			
            <div id="whole" class="inner cover" style="display:block">
                <br>
	    		<br>
	    		<br>
	    		<br>
	    		<br>
                <h3 class="cover-heading">平台最近分析记录   <span class="label label-success">New</span></h3>
                <h4 class="cover-heading">（点击可查看分析结果）</h4>
                <br>
	    		<br>
	    		<br>
           <div class="list-group">
			  <a href="/TestProject/ReportGenerateServlet?filename=${a1name}&currentID=${a1id}"><button type="button" class="list-group-item">应用名称：${a1name}--------------分析时间： ${a1time}</button></a>
			  <a href="/TestProject/ReportGenerateServlet?filename=${a2name}&currentID=${a2id}"><button type="button" class="list-group-item">应用名称：${a2name}--------------分析时间： ${a2time}</button></a>
			  <a href="/TestProject/ReportGenerateServlet?filename=${a3name}&currentID=${a3id}"><button type="button" class="list-group-item">应用名称：${a3name}--------------分析时间： ${a3time}</button></a>
			  <a href="/TestProject/ReportGenerateServlet?filename=${a4name}&currentID=${a4id}"><button type="button" class="list-group-item">应用名称：${a4name}--------------分析时间： ${a4time}</button></a>
			  <a href="/TestProject/ReportGenerateServlet?filename=${a5name}&currentID=${a5id}"><button type="button" class="list-group-item">应用名称：${a5name}--------------分析时间： ${a5time}</button></a>
			</div>                                                    
	    		<br>
	    		<br>
	    		<br>
	    		<br>
	    		<br>             
                <a href="/TestProject/SummaryGenerateServlet"><input type="submit" value="历史数据" class="btn btn-lg btn-default"></a>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
            </div>
            
             


            <div id="foot" class="mastfoot">
                <div class="inner">
                    <p>Powered by XDU</p>
                </div>
            </div>

        </div>

    </div>

</div>
</body>
</html>