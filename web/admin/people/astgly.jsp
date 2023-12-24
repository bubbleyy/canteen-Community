<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>食堂管理人员设置</title>
  <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
  <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

  <style>
    .layui-this>a:hover{background-color:rgb(40,43,51);color:#fff;}
  </style>
</head>
<body><div style="display: flex;justify-content: space-between;width: 100%;align-items: center;">
  <div style="display: flex;align-items: center;margin-left: 30px;">
    <a href="${pageContext.request.contextPath}/AStGlServlet">
    <img src="${pageContext.request.contextPath}/imgs/icon/back.png" style="width: 30px;height: 30px">
    </a>
  </div>
  <div style="margin-right: 40px;">
    <a id="hiddenprint3" class="btn btn-primary"  href="${pageContext.request.contextPath}/AStGlRyAddServlet?stid=${stid}">设置管理人员</a>
  </div>
</div>

<div style="height: 20px;width: 100%"></div>

<div class="container">

<c:choose>
  <c:when test="${stglies.size() == 0}">
    <div style="margin: 80px auto;display: flex;justify-content: center;flex-wrap: wrap">
      <p style="display: flex;justify-content: center;width: 100%"><img src="${pageContext.request.contextPath}/imgs/null.png" style="width: 80px;height: 80px;"></p>
      <p style="width: 100%;text-align: center;color: #8a8a8a">该食堂没有设置管理人员喔~</p>
    </div>
  </c:when>
  <c:otherwise>

  <form id="delselectform" name="excel" action="#" method="post">
    <table border="1" class="table table-bordered table-hover">
      <tr class="success" style="font-size: 14px">
        <th>用户名</th>
        <th>密码</th>
        <th>头像</th>
        <th>状态</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${stglies}" var = "stgly" varStatus="s">
        <tr style="font-size: 14px">
          <td>${stgly.username}</td>
          <td>${stgly.password}</td>
          <c:choose>
          <c:when test="${ not empty stgly.faceimg}">
            <td>
              <img src="${pageContext.request.contextPath}/${stgly.faceimg}" style="width: 40px;height: 40px;">
            </td>
          </c:when>
          <c:otherwise>
            <td><img src="${pageContext.request.contextPath}/imgs/null.png" style="width: 40px;height: 40px;">
            </td>
          </c:otherwise>
          </c:choose>

          <c:choose>
            <c:when test="${stgly.status.equals('正常')}">
              <td><div style="padding: 5px;background-color: green;color: white;font-size: 14px;">正常</div></td>
            </c:when>
            <c:otherwise>
              <td><div style="padding: 5px;background-color: darkred;color: white;font-size: 14px;">异常</div></td>
            </c:otherwise>
          </c:choose>

          <td>
            <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/AStGlRyUpdateServlet?stid=${stgly.st_id}&username=${stgly.username}">修改</a>&nbsp;
            <a class="btn btn-default btn-sm" href="javascript:delstgly('${stgly.username}','${stgly.st_id}')">删除</a>
            <c:choose>
            <c:when test="${stgly.status.equals('正常')}">
            <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/AStGlRyStatusServlet?stid=${stgly.st_id}&username=${stgly.username}&status=${'异常'}">转为异常</a>&nbsp;
          </c:when>
          <c:otherwise>
            <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/AStGlRyStatusServlet?stid=${stgly.st_id}&username=${stgly.username}&status=${'正常'}">转为正常</a>&nbsp;
          </c:otherwise>
          </c:choose>
          </td>
        </tr>
      </c:forEach>
    </table>
  </form>
  </c:otherwise>
</c:choose>
</div>
<div style="width: 80px;height: 80px;background-color: black;opacity: 0.5;color: white;z-index: 100;display: none;margin: 20px auto;align-items: center;justify-content: center" id="zhezhaoceng">
  <text>加载中</text>
</div>
<script>

  function delstgly(username,stid) {
    if (confirm("您确定要删除此食堂管理员吗")){
      document.getElementById("zhezhaoceng").style.display = 'flex'
      location.href="${pageContext.request.contextPath}/AStGlRyDeleteServlet?username="+username+"&stid="+stid;
    }
  }
</script>

</body>
</html>
