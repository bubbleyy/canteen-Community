<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>食堂账户</title>

    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style type="text/css">
        body{
            text-align: center;
        }
    </style>
</head>
<body>

<img src="${pageContext.request.contextPath}/${stgly.faceimg}" style="width: 200px;height: 200px;" >
<div>用户名：${stgly.username}</div>
<div>密码：${stgly.password}</div>
<div style="margin: 0 50px;">状态：
<c:if test="${stgly.status.equals('正常')}">
    <div style="padding: 5px;background-color: green;color: white">正常</div>

</c:if>
    <c:if test="${stgly.status.equals('异常')}">
        <div style="padding: 5px;background-color: darkred;color: white">异常</div>

    </c:if>
</div>
<h2>管理的食堂信息</h2>

<p>食堂名称 ${st.name}</p>
<p>地点 ${st.position}</p>
<p>营业时间 ${st.yysj}</p>
<p>浏览量 ${st.looknumber}</p>
<p>介绍 ${st.introduce}</p>
</body>
</html>
