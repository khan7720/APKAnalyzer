<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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



  </head>

  <body>

    <div class="container">
      <div class="header clearfix">
        <nav>
          <ul class="nav nav-pills pull-right">
            <li role="presentation" ><a href="Home.html">主页 <span class="glyphicon glyphicon-home" aria-hidden="true"></span></a></li>
            <li role="presentation" class="active"><a href="/TestProject/FunctionServlet">历史 <span class="glyphicon glyphicon-time" aria-hidden="true"></span></a></li>
            <li role="presentation"><a href="about.html">关于 <span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span></a></li>
          </ul>
        </nav>
       <h3 class="text-muted"><a href="Home.html">Android污点分析</a><img src="./css/logo.png" width="30" height="30"/></h3>
        
      </div>

      <div class="jumbotron">
	      <h3 class="cover-heading">平台最近分析记录   <span class="label label-success">New</span></h3>
	      <h4 class="cover-heading">（点击可查看分析结果）</h4>
	      <br>
	      <br>
			<table class="table table-striped">
				<tr>
					<td class="info" >APK名称</td>
					<td class="info" >分析时间</td>
				</tr>
			</table>
			<table class="table table-striped">
				<c:forEach items="${requestScope.list}" var="list" varStatus="s">
					<tr>
						<td class="default"><a href="/TestProject/ReportGenerateServlet?filename=${list.apkName}&currentID=${list.apkID}">${list.apkName}</a></td>
						<td class="default">${list.startTime}</td>
					</tr>
				</c:forEach>
			</table>

			<form action="/TestProject/FunctionServlet">
				<table class="table">
					<tr>
						<c:forEach items="${requestScope.pages}" var="pages" varStatus="s">
							<td>
								<button type="submit" name="currentPage" value="${pages}" class="btn btn-link">
									${pages}</button>
							</td>
						</c:forEach>
					</tr>
				</table>
			</form>



			<br>
	    		<br>          
                <a href="/TestProject/SummaryGenerateServlet"><input type="submit" value="历史数据" class="btn btn-lg btn-primary"></a>
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


</body><div id="edge-translate-notifier-container" class="edge-translate-notifier-center"></div></html>