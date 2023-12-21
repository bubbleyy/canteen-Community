<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>我的订单列表</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        body{
            text-align: center;
        }
    </style>
</head>
<body>

<a id="hiddenprint1" class="btn btn-primary" style="display: flex;align-items: center;background-color: white;color: #952424;height: 40px" href="${pageContext.request.contextPath}/IndexServlet">返回主页</a>
<img src="${pageContext.request.contextPath}/${loginuser.faceimg}" >
<div>用户名：${loginuser.username}</div>
<div>密码：${password}</div>
<div>状态：
<c:if test="${loginuser.status.equals('正常')}">
    <div style="padding: 5px;background-color: green;color: white">正常</div>

</c:if>
    <c:if test="${loginuser.status.equals('异常')}">
        <div style="padding: 5px;background-color: darkred;color: white">异常</div>

    </c:if>
</div>
</body>
</html>
