
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>食堂管理设置</title>
  <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
  <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

  <style>
    .layui-this>a:hover{background-color:rgb(40,43,51);color:#fff;}
  </style>
</head>
<body><div style="display: flex;justify-content: space-between;width: 100%;align-items: center;">
  <div style="display: flex;align-items: center;margin-left: 30px;">
    <img src="${pageContext.request.contextPath}/imgs/caozuo.png" style="width: 30px;height: 30px">
  </div>
  <div style="margin-right: 40px;">
    <a id="hiddenprint3" class="btn btn-primary"  href="${pageContext.request.contextPath}/admin/people/astadd.jsp">添加食堂</a>
  </div>
</div>
<form action="${pageContext.request.contextPath}/AStGlServlet" method="post"  id="forsearchform">
  <div style="position: absolute;top: 40px;background-color: #007BFF;display: flex;align-items: center;justify-content: space-between;right: 0px">
    <div style="width: 10px"></div>
    <div style="width: 300px;height: 50px;display: flex;justify-content: center;align-items: center;flex-direction: row;">
      <div style="width: 200px;display: flex;flex-direction: row;align-items: center">
        <input type="text" class="form-control" id="name" name="name" placeholder="食堂搜索">
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
  <c:when test="${sts.size() == 0}">
    <div style="margin: 80px auto;display: flex;justify-content: center;flex-wrap: wrap">
      <p style="display: flex;justify-content: center;width: 100%"><img src="${pageContext.request.contextPath}/imgs/null.png" style="width: 80px;height: 80px;"></p>
      <p style="width: 100%;text-align: center;color: #8a8a8a">还没有任何食堂信息喔~</p>
    </div>
  </c:when>
  <c:otherwise>

  <form id="delselectform" name="excel" action="#" method="post">
    <table border="1" class="table table-bordered table-hover">
      <tr class="success" style="font-size: 14px">
        <th>食堂编号</th>
        <th>食堂图片</th>
        <th>食堂名字</th>
        <th>食堂地点</th>
        <th>营业时间</th>
        <th>浏览量</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${sts}" var = "st" varStatus="s">
        <tr style="font-size: 14px">
          <td>${st.id}</td>

          <c:choose>
          <c:when test="${ not empty pictures[s.count-1][0]}">
            <td>
              <img src="${pageContext.request.contextPath}/${pictures[s.count-1][0]}" style="width: 40px;height: 40px;">
            </td>
          </c:when>
          <c:otherwise>
            <td><img src="${pageContext.request.contextPath}/imgs/null.png" style="width: 40px;height: 40px;">
            </td>
          </c:otherwise>
          </c:choose>

          <td>${st.name}</td>
          <td>${st.position}</td>
          <td>${st.yysj}</td>
          <td>${st.looknumber}</td>
          <td>
            <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/AStGlRyServlet?stid=${st.id}">食堂管理员</a>
            <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/AStGlUpdateServlet?stid=${st.id}">修改</a>&nbsp;
            <a class="btn btn-default btn-sm" href="javascript:delst(${st.id})">删除</a>
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
