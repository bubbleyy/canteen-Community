<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>${st.name}</title>
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
    <a class="navbar-brand" href="${pageContext.request.contextPath}/IndexServlet" style="color: black">${st.name}</a>

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

  <section style="margin-top: 40px" >
    <div style="width: 100%;height: 650px;border-radius: 10px;display: flex;flex-direction: row;align-items: center">
       <div style="width: 30%;height: 600px;margin: 0 5%;">
         <p>食堂名称 ${st.name}</p>
         <p>地点 ${st.position}</p>
         <p>营业时间 ${st.yysj}</p>
         <p>浏览量 ${st.looknumber}</p>
         <p>介绍 ${st.introduce}</p>
         <c:if test="${logintype.equals('师生用户')}">
         <a href="${pageContext.request.contextPath}/StTousuAddServlet?stid=${st.id}">点击投诉</a>
         </c:if>
<c:choose>
  <c:when test="${logintype.equals('师生用户')&& !stuserpinglun}">

         <div  style="width: 100%">
           <h3>评论食堂</h3>
           <form id="AddInform" action="${pageContext.request.contextPath}/StPingLunAddServlet" method="post" enctype="multipart/form-data" >
             <input type="hidden" name="id" id="id" value="${st.id}">
             <div class="form-group">
               <label for="maintext">评论内容：</label>
               <textarea name="maintext" id="maintext" cols="40" rows="10" ></textarea>
             </div>

             <div class="form-group">
               <label for="pf">星级：</label>
               <input type="number" maxlength="5" max="5" min="1" class="form-control" id="pf" name="pf" >
             </div>

             <div class="form-group">
               <label for="myfile">评论图片：</label>
               <input type="file"  id="myfile" name="myfile" multiple>
             </div>

             <span class="msg" id="errMsg" style="color: red" >${errMsg}</span>
             <div class="form-group" style="text-align: center">
               <button class="btn btn-primary" type="button" onclick="add()"  >评论</button>
             </div>
           </form>
         </div>

  </c:when>
  <c:otherwise>
     <c:if  test="${stuserpinglun && logintype.equals('师生用户')}">
        <p>您已评论过该食堂</p>
     </c:if>
    <c:if  test="${!logintype.equals('师生用户')}">
      <p>您没有权限评论该食堂</p>
    </c:if>
  </c:otherwise>
</c:choose>
       </div>
      <div  style="width: 50%;height: 600px;margin: 0 5%;overflow: scroll">
        <p>食堂图片</p>
        <c:forEach items="${stpictures}" var = "item" varStatus="s">
          <img src="${item}" style="width: 100%;height: auto;margin: 4px;">
        </c:forEach>

      </div>
    </div>
  </section>

  <section style="margin-top: 40px" >
    <div style="width: 100%;height: 450px;border-radius: 10px;position: relative;">
      <img src="${stpictures[0]}" style="width: 100%;height: 100%;border-radius: 10px;
  object-fit: cover;"  >
      <div style="z-index: 100;position: absolute;width: 100%;bottom: 100px;display: flex;justify-content: center;flex-wrap: wrap">
        <div style="color: white;font-size: 40px;font-weight: bolder;margin-right: 20px;width: 100%;text-align: center">找到您喜欢的菜品</div>
        <form   action="SMenuSearchServlet" method="GET" style="width: 100%;display: flex;flex-direction: row;width: 100%;justify-content: center;margin: 20px 0;align-items: center">
          <input type="hidden" id="stid" value="${st.id}">
          <div  style= "color: white;margin-right: 20px;">输入菜品名称</div>
          <input type="text" step="1"  class="measureDate" id="menuname" name="menuname" placeholder="请输入菜品名称">
          <button type="submit" style="padding: 10px 30px;border-radius: 10px;background-color: white;color: black;height: auto;margin-left: 20px;">查看</button>
        </form>
        <div style="color: red;width: 100%;text-align: center;font-size: 14px;" id="msg" >${msg}</div>
        <div style="color: white;width: 100%;text-align: center;font-size: 14px;">*输入跳转对应菜品</div>
      </div>
    </div>
  </section>

  <section style="margin: 20px 0;" >
    <hr/>
  </section>
  <section >
    <h3 >公告</h3>
    <div style="width: 100%;height: 200px;overflow: scroll;background-color: white">
    <c:choose>
      <c:when test="${gonggaos.size() == 0}">没有公告喔~</c:when>
      <c:otherwise>
        <c:forEach items="${gonggaos}" var="post">

              <div style="display: flex;flex-direction: row;align-items: center;justify-content: space-between;width: 90%;margin: 10px 30px;">
                <div style="width: 300px"><a href="${pageContext.request.contextPath}/UserGgdetailServlet?id=${post.id}" style="color:#333333;">${post.title}</a></div>
                <img src="${pageContext.request.contextPath}/imgs/icon/right.png" style="width: 20px;height: 20px;">
              </div>
              <hr />

        </c:forEach>
      </c:otherwise>
    </c:choose>
    </div>

  </section>

  <section style="margin: 20px 0;" >
    <hr/>
  </section>

  <section >
    <h3 >菜品</h3>
    <div style="width: 100%;display: flex;flex-wrap: wrap;flex-direction: row;background-color: white">
      <c:choose>
        <c:when test="${menus.size() == 0}">没有菜品信息喔~</c:when>
        <c:otherwise>
          <c:forEach items="${menus}" var="post" varStatus="s" >
            <a href="${pageContext.request.contextPath}/MenuDetailServlet?id=${post.id}">
            <div style="width: 120px;display: flex;flex-wrap: wrap;margin: 20px 10px;justify-content: center">

              <c:choose>
                <c:when test="${ not empty stcppictures[s.count-1][0]}">
                  <img src="${stcppictures[s.count - 1][0]}"  style="width: 100px;height: 80px;border-radius: 10px;">

                </c:when>
                <c:otherwise>
                  <img src="${pageContext.request.contextPath}/imgs/null.png"  style="width: 100px;height: 80px;border-radius: 10px;">

                </c:otherwise>
              </c:choose>

              <div style="width: 100%;height: 8px;"></div>
              <div style="width: 100%;text-align: center;font-size: 14px;">菜品名：${post.name}</div>
              <div style="width: 100%;text-align: center;font-size: 14px;">摊位：${post.tw}</div>
            </div>
            </a>
          </c:forEach>
        </c:otherwise>
      </c:choose>

    </div>

  </section>

  <section >
    <hr/>
  </section>

  <section >
    <h3 >食堂评论</h3>
    <div style="width: 100%;display: flex;flex-wrap: wrap;flex-direction: row;background-color: white">
      <c:choose>
        <c:when test="${userpingluns.size() == 0}">没有评论信息喔~</c:when>
        <c:otherwise>
          <c:forEach items="${userpingluns}" var="post" varStatus="s" >

            <div style="width: 100%;display: flex;flex-wrap: wrap;margin: 20px 10px;justify-content: center">
              <div style="width: 100%;display: flex;flex-direction: row;margin: 5px 0 ;">
                <img src="${post.user.faceimg}" style="width: 40px;height: 40px;margin-right: 10px;">
               ${post.user.username} ${post.stpinglun.pf}星
              </div>
              <div style="width: 100%;margin:5px 0 ;">评论内容：${post.stpinglun.maintext}</div>

            </div>
            <div style="text-align: right"><a href="${pageContext.request.contextPath}/StpinglunHuifuServlet?id=${post.stpinglun.id}">查看食堂回复</a></div>
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
