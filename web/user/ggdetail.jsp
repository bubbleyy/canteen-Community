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
    <title>公告详情</title>
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
        <a class="navbar-brand" href="#">公告详情</a>
        <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarColor02"
                aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="navbar-collapse collapse" id="navbarColor02" style="">
            <ul class="navbar-nav mr-auto d-flex align-items-center">
                <li class="nav-item">
                    <a class="nav-link" href="UserGgServlet">返回</a>
                </li>
            </ul>

        </div>

    </div>
</nav>

<div style="height: 70px;width: 100%;"></div>

<main class="container">

    <section  data-aos="fade-up" id="example-carousel135">
    <div style="margin: 10px 0;background-color: white;border-radius: 10px;box-shadow: 0 0 10px whitesmoke;display: flex;padding: 30px;flex-wrap: wrap">
        <div style="width: 100%"><h3 style="font-weight: bold">${gonggao.title}</h3></div>
        <div style="width: 100%;display: flex;flex-direction: row"><div style="font-size: 14px;color: #8a8a8a;margin: 20px 10px;">${gonggao.type}</div><div style="font-size: 14px;color: #8a8a8a;margin: 20px 10px">${gonggao.createtime}</div></div>
       <div style="width: 100%;margin: 20px 0 ;">${gonggao.maintext}</div>
        <div style="width: 100%;text-align: right;font-size: 14px;color: #bfbfbf;margin-top: 10px;">浏览量：${gonggao.looknumber}</div>
        <div style="width: 100%;text-align: right;font-size: 14px;color: #bfbfbf;margin-top: 10px;">${gonggao.fromwho}</div>
    </div>
    </section>

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

</body>
</html>
