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
                            <li class="active"><a href="index.jsp">主页</a></li>
                            <li><a href="/TestProject/FunctionServlet">功能</a></li>
                            <li><a href="about.jsp">关于</a></li>
                        </ul>
                    </nav>
                </div>
            </div>

            <div id="whole" class="inner cover">
                <h1 class="cover-heading">Android在线分析工具</h1>
                <p class="lead">即刻使用基于静态污点分析技术开发的FlowDroid、FastDroid工具对Android应用进行分析，获取可能潜藏的敏感行为、敏感权限并生成多维度的分析报告</p>
                  <form enctype="multipart/form-data" method="post" action="/TestProject/UploadServlet">
						<input type="file" name="myfile" class="masthead-brand">
					    <input type="submit" value="上传APK文件" class="btn btn-lg btn-default">	
					</form>
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