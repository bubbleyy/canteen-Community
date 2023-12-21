<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <link rel="apple-touch-icon" sizes="76x76" href="/assets/img/favicon.ico">
    <link rel="icon" type="image/png" href="/assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>公告</title>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <link href="${pageContext.request.contextPath}/css/assets/css/main.css" rel="stylesheet"/>

    <link href="${pageContext.request.contextPath}/css/assets/css/vendor/aos.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">


    <style type="text/css">
        body {
            background-color: rgb(247, 247, 247);
        }
    </style>

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">公告</a>
        <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarColor02"
                aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="navbar-collapse collapse" id="navbarColor02" style="">
            <ul class="navbar-nav mr-auto d-flex align-items-center">
                <li class="nav-item">
                    <a class="nav-link" href="IndexServlet">首页</a>
                </li>
            </ul>

        </div>

    </div>
    <form action="UserGgServlet" method="post"  id="forsearchform">
        <div style="position: absolute;top: 5px;background-color: #007BFF;display: flex;align-items: center;justify-content: space-between;right: 0px">
            <div style="width: 10px"></div>
            <div style="width: 300px;height: 50px;display: flex;justify-content: center;align-items: center;flex-direction: row;">
                <div style="width: 200px;display: flex;flex-direction: row;align-items: center">
                    <input type="text" class="form-control" id="name" name="name" placeholder="公告搜索">
                </div>
                <div style="width: 80px;margin-left: 10px;cursor: pointer" id="forsearch">
                    <img src="../imgs/icon/search.png" style="width: 30px;height: 30px;">
                </div>

            </div>
        </div>
    </form>
</nav>

<div style="height: 70px;width: 100%;"></div>


<main class="container">

    <h3 class="h5 mb-4 font-weight-bold">公告栏</h3>
       <c:choose>
            <c:when test="${gonggaos.size() == 0}">没有公告喔~</c:when>
            <c:otherwise>
                <c:forEach items="${gonggaos}" var="post">
                <section style="margin: 5px 0;" data-aos="fade-up" id="example-carousel423">
                    <div style="margin: 20px 0;background-color: white;border-radius: 10px;box-shadow: 0 0 10px whitesmoke;padding: 20px;display: flex;flex-direction: row;align-items: center;width: 100%;flex-wrap: wrap">

                    <div style="display: flex;flex-direction: row;align-items: center;justify-content: space-between;width: 100%;margin: 10px">
                        <div style="width: 300px"><a href="UserGgDetailServlet?id=${post.id}" style="color:#333333;">${post.title}</a></div>
                        <img src="../imgs/icon/right.png" style="width: 20px;height: 20px;">
                    </div>
                        <hr />
                    </div>
                </section>

                </c:forEach>
            </c:otherwise>
        </c:choose>

</main>


<script src="${pageContext.request.contextPath}/css/assets/js/vendor/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/css/assets/js/vendor/popper.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/css/assets/js/vendor/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/css/assets/js/vendor/share.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/css/assets/js/functions.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/css/assets/js/vendor/aos.js" type="text/javascript"></script>

<noscript>
    <style>
        *[data-aos] {
            display: block !important;
            opacity: 1 !important;
            visibility: visible !important;
        }
    </style>
</noscript>
<script>
    AOS.init({
        duration: 700
    });
</script>

<script>
    AOS.init({
        disable: function () {
            var maxWidth = 1200;
            return window.innerWidth < maxWidth;
        }
    });
</script>

<script>
    $('.carousel').on('slide.bs.carousel', function (event) {
        var height = $(event.relatedTarget).height();
        var $innerCarousel = $(event.target).find('.carousel-inner');
        $innerCarousel.animate({
            height: height
        });
    });
</script>

<script>
    $(function () {
        $('[data-toggle="popover"]').popover()
    })
    $('.popover-dismiss').popover({
        trigger: 'focus'
    })
</script>

<script>
    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    })
</script>

<%--提交搜索表单--%>
<script>
    $(document).ready(function () {

            $("#forsearch").click(function () {

                    $("#forsearchform").submit();
                }
            );
        }
    )
</script>

</body>
</html>
