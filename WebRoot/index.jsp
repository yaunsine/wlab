<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�û���Ϣ����ϵͳ</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta content="text/html;charset=gb2312">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.idinput{
			width:300px;
			height:40px;
			text-indent:5px;
			font-size:16px;
		}
		.pwdinput{
			width:300px;
			height:40px;
			text-indent:5px;
			font-size:16px;
		}
		.loginbtn{
			width:300px;
			height:40px;
			background-color: #E7E7E7;
		}
		.fm{
			background-color: #99CC99;
			height:500px;
		}
		.logintable{
			margin:auto;
			padding-top:120px;
		}
		td{
			height:70px;
		}
		.intro{
			float:left;
			font-size:32px;	
			color:white;
			margin-left:300px;
			margin-top:120px;
			writing-mode: vertical-rl;
		}
		.title{
			color:white;
			font-weight:bold;
			border-bottom: 2px solid white;
		}
		.copyright{
			padding-top:40px;
			text-align: center;
		}
		.icon{
		padding-top:100px;
			text-align: center;
		}
		.icon img{
			width:100px;
		}
	</style>
	
  </head>
 
  <body>
    <form action="servlet/RServlet" name="login" class="fm" method="post">
    	<div class="intro">�� �� �� Ϣ �� �� ϵ ͳ</div>
    	<table class="logintable">
    		<tbody>
    			<tr>
    				<td><div class="title">�˺ŵ�¼����</div></td>
    				
    			</tr>
    			<tr>
    				<td><input class="idinput" name="idinput" placeholder="�������˺�" type="text"></td>
    				<td></td>
    			</tr>
    			<tr>
    				<td><input class="pwdinput" name="pwdinput" placeholder="����������" type="text"></td>
    				<td></td>
    			</tr>
    			<tr>
    				<td><input class="loginbtn" type="submit" name="loginbtn" value="��¼"></td>
    			</tr>
    		</tbody>
    	</table>
    </form>
    <div class="icon"><img alt="" src="mn1.png"></div>
    <div class="copyright">�û���Ϣ����</div>
    <div class="copyright">LYS-2019&copy;</div>
  </body>
</html>
