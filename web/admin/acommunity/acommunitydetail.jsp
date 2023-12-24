<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>社区详情</title>
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
          <h2>原文</h2>

            <div style="width: 100%;display: flex;flex-wrap: wrap;margin: 20px 10px;justify-content: center">
              <div style="width: 100%;display: flex;flex-direction: row;margin: 5px 0 ;">
                <img src="${communitylist.user.faceimg}" style="width: 40px;height: 40px;margin-right: 10px;">
                ${communitylist.user.username} 标题：${communitylist.community.title}
              </div>
              <div style="width: 100%;margin:5px 0 ;">${communitylist.community.maintext}</div>
              <c:choose>
                <c:when test="${ !communitylist.communitypictures.equals('[]')  && !communitylist.communitypictures.isEmpty()}">
                  <c:forEach items="${communitylist.communitypictures}" var="communitypictures" varStatus="a" >
                    <img src="${pageContext.request.contextPath}/${communitypictures}" style="width: 80px;height: 80px;">
                  </c:forEach>

                </c:when>
                <c:otherwise>
                  没有图片噢~
                </c:otherwise>
              </c:choose>
            </div>

              <c:choose>

              <c:when test="${communitylist.communitypinglun.size() == 0}">没有回复信息喔~</c:when>
              <c:otherwise>
                <div style="width: 100%;">
                <c:forEach items="${communitylist.communitypinglun}" var="itemall" varStatus="b" >
                <div>
                  用户名：${itemall.user_username} : ${itemall.maintext}
                </div>
                  <c:choose>
                    <c:when test="${ !communitylist.communityitempictures[b.count-1].equals('[]')  && !communitylist.communityitempictures[b.count-1].isEmpty()}">
                      <c:forEach items="${communitylist.communityitempictures[b.count-1]}" var="e" varStatus="d" >
                        <img src="${pageContext.request.contextPath}/${e}" style="width: 80px;height: 80px;">
                      </c:forEach>

                    </c:when>
                    <c:otherwise>
                      没有图片噢~
                    </c:otherwise>
                  </c:choose>
                </c:forEach>
                </div>
              </c:otherwise>

              </c:choose>

          <div style="width: 100%;height: 1px;background-color: #8a8a8a"></div>

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
