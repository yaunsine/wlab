<%--
  Created by IntelliJ IDEA.
  User: GRG
  Date: 2019-10-29
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        img {
            width: 5em;
            height: 5em;
            border-radius: 100%;
        }
    </style>
</head>
<body>
    <div class="checkImage" id="checkImage">
    <h1>图片显示在这</h1>
<%--    　　　　　　//这里路径一定要对--%>
    <img alt="" src="${request.contextPath}/CheckImg" />
</div>
</body>
</html>
