<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>社区信息管理</title>
  <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
  <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

  <style>
    .layui-this>a:hover{background-color:rgb(40,43,51);color:#fff;}
  </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/AcommunityxxsearchServlet" method="post"  id="forsearchform">
  <div style="position: absolute;top: 0;background-color: #007BFF;display: flex;align-items: center;justify-content: space-between;right: 0px">
    <div style="width: 10px"></div>
    <div style="width: 300px;height: 50px;display: flex;justify-content: center;align-items: center;flex-direction: row;">
      <div style="width: 200px;display: flex;flex-direction: row;align-items: center">
        <input type="text" class="form-control" id="name" name="name" placeholder="社区信息标题搜索">
      </div>
      <div style="width: 80px;margin-left: 10px;cursor: pointer;color: white" id="forsearch">
        搜索
      </div>

    </div>
  </div>
</form>

<div style="height: 60px;width: 100%"></div>

<div class="container">

<c:choose>
  <c:when test="${communities.size() == 0}">
    <div style="margin: 80px auto;display: flex;justify-content: center;flex-wrap: wrap">
      <p style="display: flex;justify-content: center;width: 100%"><img src="${pageContext.request.contextPath}/imgs/null.png" style="width: 80px;height: 80px;"></p>
      <p style="width: 100%;text-align: center;color: #8a8a8a">还没有任何社区信息喔~</p>
    </div>
  </c:when>
  <c:otherwise>

  <form id="delselectform" name="excel" action="#" method="post">
    <table border="1" class="table table-bordered table-hover">
      <tr class="success" style="font-size: 14px">
        <th>编号</th>
        <th>标题</th>
        <th>图片</th>
        <th>正文</th>
        <th>浏览量</th>
        <th>发布者用户名</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${communities}" var = "community" varStatus="s">
        <tr style="font-size: 14px">
          <td>${community.id}</td>
          <td>${community.title}</td>
          <c:choose>
          <c:when test="${!pictures[s.count-1][0].isEmpty()}">
            <td>
              <img src="${pageContext.request.contextPath}/${pictures[s.count-1][0]}" style="width: 40px;height: 40px;">
            </td>
          </c:when>
          <c:otherwise>
            <td><img src="${pageContext.request.contextPath}/imgs/null.png" style="width: 40px;height: 40px;">
            </td>
          </c:otherwise>
          </c:choose>

          <td>${community.maintext}</td>
          <td>${community.looknumber}</td>
          <td>${community.user_username}</td>
          <td>
            <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/AcommunitydetailServlet?id=${community.id}">查看原文</a>
            <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/AcommunityxxUpdateServlet?id=${community.id}">修改</a>&nbsp;
            <a class="btn btn-default btn-sm" href="javascript:delst(${community.id})">删除</a>
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
    if (confirm("您确定要删除此社区信息吗")){
      document.getElementById("zhezhaoceng").style.display = 'flex'
      location.href="${pageContext.request.contextPath}/AcommunityxxdeleteServlet?id="+id;
    }

  }

</script>
</body>
</html>
