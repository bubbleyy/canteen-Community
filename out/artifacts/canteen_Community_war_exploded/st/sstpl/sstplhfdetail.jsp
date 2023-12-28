<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>食堂评论回复详情</title>
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

<div style="margin: 0 40px;">

  <section >
    <div style="width: 100%;display: flex;flex-wrap: wrap;flex-direction: row;background-color: white">

      <div style="width: 100%;display: flex;flex-wrap: wrap;margin: 20px 10px;justify-content: center">
        <div style="width: 100%;display: flex;flex-direction: row;margin: 5px 0 ;">
          <img src="${user.faceimg}" style="width: 40px;height: 40px;margin-right: 10px;">
          ${user.username} ${stpinglun.pf}星
        </div>
        <div style="width: 100%;margin:5px 0 ;">评论内容：${stpinglun.maintext}</div>

      </div>
      <div style="width: 100%;height: 1px;background-color: #8a8a8a"></div>

    </div>

  </section>

  <section class="pt-4 pb-5" data-aos="fade-up" id="example-carousel167">
    <hr/>
  </section>

  <section >
    <h2>回复内容</h2>
    <div style="width: 100%;display: flex;flex-wrap: wrap;flex-direction: row;background-color: white">
      <c:choose>
        <c:when test="${stpinglunhuifus.size() == 0}">该食堂还没有回复信息噢~</c:when>
        <c:otherwise>
          <c:forEach items="${stpinglunhuifus}" var="post" varStatus="s" >

            <div style="width: 100%;display: flex;flex-wrap: wrap;margin: 20px 10px;justify-content: center">
              <div style="width: 100%;display: flex;flex-direction: row;margin: 5px 0 ;">
                <img src="${stfaceimg[0]}" style="width: 40px;height: 40px;margin-right: 10px;">
                  ${st.name} <c:if test="${post.status.equals('未读')}"><div style="padding: 5px;background-color: darkgreen;color: white">写者未读</div></c:if>
                <c:if test="${post.status.equals('已读')}"><div style="padding: 5px;background-color: #8a8a8a;color: white">写者已读</div></c:if>
              </div>
              <div style="width: 100%;margin:5px 0 ;">回复内容：${post.maintext}</div>

            </div>
            <c:if test="${logintype.equals('师生用户')}">
              <c:if test="${post.status.equals('未读') && user.username.equals(loginuser.username)}">
                <div style="text-align: right"><a href="${pageContext.request.contextPath}/StpinglunHuifuStatusServlet?id=${post.id}&&stpl_id=${post.stpl_id}">我已阅读</a></div>
              </c:if>
            </c:if>
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

</body>
</html>
