<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>我的食堂投诉</title>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
        integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

  <link href="${pageContext.request.contextPath}/css/assets/css/main.css" rel="stylesheet"/>

  <link href="${pageContext.request.contextPath}/css/assets/css/vendor/aos.css" rel="stylesheet"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">

  <style>
    body {
      background-color: rgb(247, 247, 247);
    }
    .layui-this>a:hover{background-color:rgb(40,43,51);color:#fff;}
  </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark  fixed-top" style="margin-bottom: 0 !important;">
  <div class="container-fluid" style="background-color: white;border-bottom: 2px solid #bfbfbf;padding: 6px 16px;">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/#" style="color: black">我的食堂投诉</a>

    <div class="navbar-collapse collapse" id="navbarColor02" style="">
      <ul class="navbar-nav mr-auto d-flex align-items-center">
        <li class="nav-item">
          <a class="nav-link" href="IndexServlet" style="color: darkred">首页</a>
        </li>

        <li class="nav-item">
          <a class="nav-link" href="UserGgServlet" style="color: darkred">公告</a>
        </li>
        <c:if test="${loginuser != null}">
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/StServlet" style="color: darkred">食堂信息</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/UserCommunityServlet" style="color: darkred">社区信息</a>
            </li>

          <c:if test="${loginuser.logintype.equals('师生用户')}">
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color: darkred !important;">
              个人中心</a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">

                <a class="dropdown-item" href="UserMyzhServlet">我的账户</a>
              <a class="dropdown-item" href="${pageContext.request.contextPath}/MyCommunityServlet">我发布的社区信息</a>
              <a class="dropdown-item" href="${pageContext.request.contextPath}/MystpinglunServlet">我的食堂评论</a>
              <a class="dropdown-item" href="${pageContext.request.contextPath}/MysttousuServlet">我的食堂投诉</a>
              <a class="dropdown-item" href="${pageContext.request.contextPath}/MymenupinglunServlet">我的菜品评论</a>
            </div>
          </li>
          </c:if>

          <c:if test="${loginuser.logintype.equals('食堂管理员')}">
            <li class="nav-item">
              <a class="nav-link" href="SIndexServlet" style="color: darkred">食堂管理后台</a>
            </li>
          </c:if>

          <c:if test="${loginuser.logintype.equals('系统管理员')}">
            <li class="nav-item">
              <a class="nav-link" href="AIndexServlet" style="color: darkred">系统管理后台</a>
            </li>
          </c:if>

          <li class="nav-item">
            <a class="nav-link" href="outServlet" style="color: darkred">退出</a>
          </li>

        </c:if>

        <c:if test="${loginuser == null}">
          <li class="nav-item">
            <a class="nav-link" href="login.jsp" style="color: darkred">登录</a>
          </li>
        </c:if>

      </ul>

    </div>

  </div>
</nav>


<div style="margin: 0 40px;">

  <section >
    <div style="width: 100%;display: flex;flex-wrap: wrap;flex-direction: row;background-color: white">
      <c:choose>
        <c:when test="${mytousus.size() == 0}">您没有发布食堂投诉信息喔~</c:when>
        <c:otherwise>
          <c:forEach items="${mytousus}" var="post" varStatus="s" >

            <div style="width: 100%;display: flex;flex-wrap: wrap;margin: 20px 10px;justify-content: center">
              <div style="width: 100%;display: flex;flex-direction: row;margin: 5px 0 ;">
                <img src="${loginuser.faceimg}" style="width: 40px;height: 40px;margin-right: 10px;">
               ${loginuser.username}
              </div>
              <div style="width: 100%;margin:5px 0 ;">投诉内容：${post.maintext}</div>

            </div>
            <div style="text-align: right"><a href="${pageContext.request.contextPath}/SttsHuifuServlet?id=${post.id}">查看食堂回复</a></div>
          <div style="width: 100%;height: 1px;background-color: #8a8a8a"></div>
          </c:forEach>
        </c:otherwise>
      </c:choose>

    </div>

  </section>

  <section class="pt-4 pb-5" data-aos="fade-up" id="example-carousel16">
    <hr/>
  </section>
</div>


<script src="${pageContext.request.contextPath}/css/assets/js/vendor/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/css/assets/js/vendor/popper.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/css/assets/js/vendor/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/css/assets/js/vendor/share.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/css/assets/js/functions.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/css/assets/js/vendor/aos.js" type="text/javascript"></script>
<script type="text/javascript">

  function add() {

    var maintext = $("#maintext").val();
    var pf = $("#pf").val();

    if (isEmpty(maintext)){
      $("#msg").html("评论内容不可为空");
      return;
    }
    if (isEmpty(pf)){
      $("#msg").html("评分不可为空");
      return;
    }

    $("#AddInform").submit();

  }

  //专用方法：判断为空

  function isEmpty(str) {
    if (str == null || str.trim() == ""){
      return true;
    }
    return false;

  }

</script>
</body>
</html>
