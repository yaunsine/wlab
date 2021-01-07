<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%@ page  isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改单词</title>
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- boostrap满足不同屏幕缩放 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 移动设备 -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
    integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta content="text/html;charset=gb2312;">
	<script type="text/javascript">
		window.onload=function(){
			/* var arr = getQueryString(); //获取地址栏参数
			myform.namevalue.value = arr[0];
			myform.pwdvalue.value = arr[1];
			myform.agevalue.value = arr[2];
			//myform.powvalue.value = arr[3];
			var selected = document.getElementById("selection"); */
		}
		function getQueryString() {
			var arr = new Array();
			var url = decodeURI(this.location.href);
			var regex1 = url.split("?");
			var regex2 = regex1[regex1.length-1].split("&");
			for(var x in regex2){
				arr[x] = regex2[x].split("=")[1];
			}
			return arr;
		}
	</script>
	<style>
		.input{
			height:40px;
			width:300px;
			margin-top:8px;
			text-indent:8px;
			font-size:18px;
			color:grey;
			font-weight:bold;
		}
		.modifybtn{
			width:120px;
			height:40px;
			margin-top:12px;
			background-color: #16BE44;
			color:white;
			font-size:16px;
		}
		.label{
			width:180px;
			font-size:20px;
			font-weight:bold;
			margin-top:8px;
		}
		.label font{
			color:#D1D3D6;
			font-weight:light;
		}
		.myform{
			margin:auto;
			width:400px;
		}
		.btn{
			margin-left:80px;
		}
		.all{
			margin:100px;
		}
		.selection{
			height:40px;
			margin-top:8px;
			font-size:18px;
			color:grey;
			font-weight:bold;
		}
	</style>
  </head>
  <%
  request.setCharacterEncoding("GB2312");
  String id = request.getParameter("id");
  request.setAttribute("id", id);
  String word = new String(request.getParameter("username").getBytes("GB2312"),"GB2312");
  String sentence = request.getParameter("password");
  String time = request.getParameter("age");
  String meaning = request.getParameter("meaning");
  request.setAttribute("word", word);
  request.setAttribute("sentence", sentence);
  request.setAttribute("time", time);
  request.setAttribute("meaning", meaning);
   %>
  <body>
  	<div class="all">
	  	<form action="servlet/ModifyServlet?id=${id}" method="post" class="myform" name="myform">
	  		<div class="form-group">
	  			<div class="label">单词（短语）：<font></font></div><input type="text" class="input"  value="${word}" name="namevalue"><br>
		  	
	  		</div>
		  	<div class="label">释义：</div><input type="text" class="input" value="${meaning}" name="meanvalue"><br>
		  	<div class="label">例句：</div><input type="text" class="input" value="${sentence}" name="pwdvalue"><br>
		  	<div class="label">提交时间：</div><input type="text" value="${time}" class="input" name="agevalue"><br>
		  	
		  	<div class="btn"><input type="submit" class="modifybtn" value="提交修改"></div>
	  	</form>
  	</div>
  </body>
</html>
