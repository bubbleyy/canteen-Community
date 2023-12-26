<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>食堂投诉管理</title>
  <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
  <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

  <style>
    .layui-this>a:hover{background-color:rgb(40,43,51);color:#fff;}
  </style>
</head>
<body>

<div class="container">

<c:choose>
  <c:when test="${sttss.size() == 0}">
    <div style="margin: 80px auto;display: flex;justify-content: center;flex-wrap: wrap">
      <p style="display: flex;justify-content: center;width: 100%"><img src="${pageContext.request.contextPath}/imgs/null.png" style="width: 80px;height: 80px;"></p>
      <p style="width: 100%;text-align: center;color: #8a8a8a">还没有任何食堂投诉信息喔~</p>
    </div>
  </c:when>
  <c:otherwise>

  <form id="delselectform" name="excel" action="#" method="post">
    <table border="1" class="table table-bordered table-hover">
      <tr class="success" style="font-size: 14px">
        <th>投诉编号</th>
        <th>投诉图片</th>
        <th>投诉用户名</th>
        <th>投诉内容</th>
        <th>状态</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${sttss}" var = "stts" varStatus="s">
        <tr style="font-size: 14px">
          <td>${stts.id}</td>

          <c:choose>
          <c:when test="${ not empty sttspictures[s.count-1][0]}">
            <td>
              <img src="${pageContext.request.contextPath}/${sttspictures[s.count-1][0]}" style="width: 40px;height: 40px;">
            </td>
          </c:when>
          <c:otherwise>
            <td><img src="${pageContext.request.contextPath}/imgs/null.png" style="width: 40px;height: 40px;">
            </td>
          </c:otherwise>
          </c:choose>

          <td>${stts.user_username}</td>
          <td>${stts.maintext}</td>

          <c:choose>
            <c:when test="${statuslist[s.count - 1].equals('已回')}">
              <td><div style="padding: 5px;background-color: green;color: white;font-size: 14px;">已回</div></td>
            </c:when>
            <c:otherwise>
              <td><div style="padding: 5px;background-color: darkred;color: white;font-size: 14px;">未回</div></td>
            </c:otherwise>
          </c:choose>
          <td>
            <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/SsttsHuifuDetailServlet?id=${stts.id}">查看详情</a>&nbsp;
            <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/SsttshfAddServlet?id=${stts.id}">回复</a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </form>
  </c:otherwise>
</c:choose>
</div>

</body>
</html>
