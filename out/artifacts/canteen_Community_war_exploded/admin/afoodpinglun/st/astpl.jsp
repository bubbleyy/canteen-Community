<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>食堂评论管理</title>
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
    <c:when test="${stpingluns.size() == 0}">
      <div style="margin: 80px auto;display: flex;justify-content: center;flex-wrap: wrap">
        <p style="display: flex;justify-content: center;width: 100%"><img src="${pageContext.request.contextPath}/imgs/null.png" style="width: 80px;height: 80px;"></p>
        <p style="width: 100%;text-align: center;color: #8a8a8a">还没有任何食堂评论信息喔~</p>
      </div>
    </c:when>
    <c:otherwise>

      <form id="delselectform" name="excel" action="#" method="post">
        <table border="1" class="table table-bordered table-hover">
          <tr class="success" style="font-size: 14px">
            <th>评论编号</th>
            <th>评论图片</th>
            <th>评论用户名</th>
            <th>评论内容</th>
            <th>评分</th>
            <th>操作</th>
          </tr>
          <c:forEach items="${stpingluns}" var = "stpinglun" varStatus="s">
            <tr style="font-size: 14px">
              <td>${stpinglun.id}</td>

              <c:choose>
                <c:when test="${ not empty stplpictures[s.count-1][0]}">
                  <td>
                    <img src="${pageContext.request.contextPath}/${stplpictures[s.count-1][0]}" style="width: 40px;height: 40px;">
                  </td>
                </c:when>
                <c:otherwise>
                  <td><img src="${pageContext.request.contextPath}/imgs/null.png" style="width: 40px;height: 40px;">
                  </td>
                </c:otherwise>
              </c:choose>

              <td>${stpinglun.user_username}</td>
              <td>${stpinglun.maintext}</td>
              <td>${stpinglun.pf}星</td>

              <td>
                <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/AstplUpdateServlet?id=${stpinglun.id}">修改</a>&nbsp;
                <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/AstpldeleteServlet?id=${stpinglun.id}">删除</a>
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
  $(document).ready(function () {

            $("#forsearch").click(function () {

                      $("#forsearchform").submit();
                    }
            );
          }
  )

  function delst(id) {
    if (confirm("您确定要删除此食堂吗")){
      document.getElementById("zhezhaoceng").style.display = 'flex'
      location.href="${pageContext.request.contextPath}/AStGlDeleteServlet?id="+id;
    }
  }

</script>
</body>
</html>
