<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改社区评论信息</title>

    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <script type="text/javascript">

        function add() {

            var maintext = $("#maintext").val();

            if (isEmpty(maintext)){
                $("#msg").html("正文不可为空");
                return;
            }

            $("#AddSt").submit();

        }

        //专用方法：判断为空

        function isEmpty(str) {
            if (str == null || str.trim() == ""){
                return true;
            }
            return false;

        }

    </script>
</head>
<body>
<div style="display: flex;align-items: center;margin-left: 30px;">
    <a href="${pageContext.request.contextPath}/AcommunitypinglunServlet">
        <img src="${pageContext.request.contextPath}/imgs/icon/back.png" style="width: 30px;height: 30px">
    </a>
</div>
<div class="container" style="padding: 5px 30px;">
    <h3>修改社区评论信息</h3>
    <form id="AddSt" action="${pageContext.request.contextPath}/AcommunitypinglunUpdateServlet" method="post" enctype="multipart/form-data" >
       <input type="hidden" name="id" id="id" value="${communitypinglun.id}">

        <div class="form-group">
            <label for="maintext">正文：</label>
            <textarea name="maintext" id="maintext" cols="80" rows="20" >${communitypinglun.maintext}</textarea>
        </div>


        <div class="form-group">
            <label for="myfile">图片：</label>
            <input type="file"  id="myfile" name="myfile" multiple>
<c:forEach items="${communitypinglunpicture}" var = "item" varStatus="s">
    <img src="${item}" style="width: 30px;height: 30px;margin: 4px;">
</c:forEach>

        </div>

        <span class="msg" id="msg" style="color: red" >${errMsg}</span>
        <div class="form-group" style="text-align: center">
            <button class="btn btn-primary" type="button" onclick="add()"  >修改</button>
        </div>
    </form>
</div>
</body>
</html>
