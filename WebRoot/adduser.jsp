<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modify.jsp' starting page</title>
    
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
	  	<form action="servlet/AddServlet" method="post" class="myform" name="myform">
		  	<div class="label">�û�����</div><input type="text" class="input" value="" name="namevalue"><br>
		  	<div class="label">���룺</div><input type="text" class="input" value="" name="pwdvalue"><br>
		  	<div class="label">���䣺</div><input type="text" class="input" name="agevalue"><br>
		  	<div class="label">��ݵȼ���</div>
		  		<select class="selection" name="level">
		  			<option value="1">VIP�û�</option>
		  			<option value="2">��ͨ�û�</option>
		  		</select>
		  	<br>
		  	<div class="btn"><input type="submit" class="modifybtn" value="����û�"></div>
	  	</form>
  	</div>
  </body>
</html>
