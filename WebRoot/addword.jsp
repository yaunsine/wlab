<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加单词</title>
    
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
			background-color: #2189FF;
			color:white;
			font-size:16px;
		}
		.label{
			width:180px;
			font-size:20px;
			font-weight:bold;
			margin-top:8px;
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
  
  <body>
  	<div class="all">
	  	<form action="servlet/AddWordServlet" method="post" class="myform" name="myform">
		  	<div class="label">单词：</div><input type="text" class="input" value="" name="newword"><br>
		  	<div class="label">释义：</div><input type="text" class="input" value="" name="meaning"><br>
		  	<div class="label">例句：</div><input type="text" class="input" value="" name="sentence"><br>
		  	<div class="btn"><input type="submit" class="modifybtn" value="添加单词"></div>
	  	</form>
  	</div>
  </body>
</html>
