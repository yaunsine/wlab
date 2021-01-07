<%@ page import="bean.*" %>
<%@ page import="dao.*" %>
<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page  isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>VIP用户管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta http-equiv=Content-Type content=text/html;charset=gb2312>
	<% 
  List list = (ArrayList)request.getAttribute("ulist"); 
  if(request.getAttribute("nameinput")!=null){
  	String nameinput = (String)request.getAttribute("nameinput");
  	session.setAttribute("nameinput", nameinput);
  }else{
  	
  }
  
  %>
	<script type="text/javascript">
		window.onload = function(){
		
			trlist = document.getElementsByTagName("tr");
			tdlist = document.getElementsByTagName("td");
			for(var i = 0;i<trlist.length;i++){
				if(i%2==0){
					trlist[i].style.backgroundColor = "#F0F0F0";
				}else{
					trlist[i].style.backgroundColor = "white";
				}
				tdlist[i].style.width = "200px";
			}
			//div0 = document.getElementsByTagName("div")[0];
			//div0.style.width = trlist[0].clientWidth;
			//div0.style.border = "1px solid red";
		}
		function deletetr(obj){
			var point_tr = obj.parentNode.parentNode;
			var uname = point_tr.getElementsByTagName("td");
			var loginname = document.getElementById("loginname").innerHTML;
			var username = uname[0].innerText;
			var flag = confirm('你是否要删除【'+username+'】？');
			if(flag==true){
				if(loginname == username){
					window.location.href="index.jsp";
				}
				var url = 'servlet/RServlet?uname='+username;
				_url = encodeURI(url);
				this.location.href = _url;
				document.getElementById("myform").submit();
				
			}
		}
		function modifytr(obj){
			var pointer = obj.parentNode.parentNode;
			var uname = pointer.getElementsByTagName("td");
			var username = uname[0].innerText;
			var password = uname[1].innerText;
			var age = uname[2].innerText;
			var flag = confirm('你是否要修改【'+username+'】？');
			if(flag==true){
			//window.location.href="modify.jsp";
				alert('<c:out value="${index}"></c:out>')
				var url = "/wlab/modify.jsp?username="+username+"&password="+password+"&age="+age;
				_url = encodeURI(url);
				this.location.href = _url;
			}
		}
		function clickdelete(){
			myform2.action = "servlet/RServlet";
		}
		function locatehref(){
			this.location.href = 'manager.jsp';
		}
	</script>
	<style type="text/css">
		.usertb{
			background-color: black;
			text-align: center;
		}
		.option1{
			font-weight:bold;
			background-color:black;
			color:white;
			width:200px;
		}
		.modify{
			background-color:#16BE44;
			color:white;
			width:80px;
		}
		.delete{
			background-color:red;
			color:white;
			width:80px;
		}
		.toprow{
			margin-bottom:5px;
			margin-left:0px;
		}
		.topinput{
			text-indent:6px;
			height:30px;
			width:200px;
			margin-left:680px;
		}
		.topbtn{
			width:60px;
			height:30px;
			background-color: #2189FF;
			color:white;
			margin-left:0px;
		}
		.slt{
			height:30px;
		}
		#loginname{
			color:#F8B62D;
		}
		.welcome{
			font-size:22px;
			font-weight:bold;
		}
		.hr1{
			background-color:black;
			height:2px;
			width:1022px;
			margin-left:0px;
		}
		.addbtn{
			height:30px;
			background-color: #2189FF;
			color:white;
			margin-left:0px;
		}
		.limit{
			width:1050px;
			margin:auto;
			margin-top:200px;
		}
	</style>
  </head>
  
  <body>
  	<div>
  	<div class="limit">
    <div class="welcome">
    欢迎您，VIP用户<font id="loginname"><%=session.getAttribute("nameinput") %></font><img alt="" src="会员.png"><br>
    </div>
    <hr class="hr1">
    
    <div class="toprow">
    <form method="post" action="servlet/queryServlet">
	    <input type="button" value="添加单词" class="addbtn" id="addbtn" name="addbtn" onclick="window.location.href='addword.jsp'">
	    <input placeholder="请输入用户名查询" class="topinput" id="topinput" name="topinput">
	    <input type="submit" value="查询" class="topbtn">
    </form>
    <!-- <select class="slt">
    	<option>按用户名</option>
    	<option>按年龄</option>
    	<option>按等级</option>
    </select> -->
    </div>
    <%-- <table class="usertb" id="usertb">
    	
    	<tr>
    		<td class="option1">用户名</td>
    		<td class="option1">密码</td>
    		<td class="option1">年龄</td>
    		<td class="option1">会员等级</td>
    		<td class="option1">操作</td>
    	</tr>
    	<%if(list.size()==0){ %>
    	<tr>
    		<td></td>
    		<td></td>
    		<td>查询不到任何用户信息! </td>
    		<td></td>
    		<td></td>
    	</tr>
    	<%}else{ %>
	    <%for(int i = 0;i<list.size();i++){ %>
	    	<tr>
	    		<% UserInfo user = (UserInfo)list.get(i); %>
	    		<td><%=user.getUsername() %></td>
	    		<td><%=user.getPassword() %></td>
	    		<td><%=user.getAge() %></td>
	    		<% if("vip".equals(user.getPower())){ %>
	    			<td>VIP用户</td>
	    		<% }else{ %>
	    			<td>普通用户</td>
	    		<% } %>
	    		<td>
		    			<button class="modify" type="button" onclick="modifytr(this)">修改</button>
		    			<button class="delete" type="button" onclick="deletetr(this)">删除</button>
	    		</td>
	    	</tr>
	    <% } }%>
    </table> --%>
    
    
    <table class="usertb" id="usertb">
    	<tr>
    		<td class="option1">单词</td>
    		<td class="option1">释义</td>
    		<td class="option1">例句</td>
    		<td class="option1">发布时间</td>
    		<td class="option1">执行操作</td>
    	</tr>
    	
    	<c:forEach items="${wlist}" var="word" varStatus="index">
    	<tr>
    		<td class="">${word.wtext}</td>
    		<td class="">${word.meaning}</td>
    		<td class="">${word.sentence}</td>
    		<td class="">${word.wtime}</td>
    		<td>
		    			<button class="modify" type="button" onclick="javascript:(function(e){window.location.href= encodeURI('/wlab/modify.jsp?username=${word.wtext}&password=${word.sentence}&age=${word.wtime}&id=${word.id}&meaning=${word.meaning}');})();">修改</button>
		    			<button class="delete" type="button" onclick="javascript:(function(e){window.location.href='servlet/RServlet?uname=${word.id}'})();">删除</button>
	    		</td>
    	</tr>
    	</c:forEach>
    	
    	<c:if test="empty ${wlist}">
    	<tr>
    		<td></td>
    		<td></td>
    		<td>查询不到任何用户信息! </td>
    		<td></td>
    		<td></td>
    	</tr>
    	
    	</c:if>
    	</table>
    </div>
    </div>
  </body>
</html>
