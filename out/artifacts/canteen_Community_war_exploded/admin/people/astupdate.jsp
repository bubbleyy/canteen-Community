<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改食堂</title>

    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <script type="text/javascript">

        function add() {

            var name = $("#name").val();
            var position = $("#position").val();
            var introduce =  $("#introduce").val();
            var yysj = $("#yysj").val();

            if (isEmpty(name)){
                $("#msg").html("名字不可为空");
                return;
            }
            if (isEmpty(position)){
                $("#msg").html("位置不可为空");
                return;
            }

            if (isEmpty(introduce)){
                $("#msg").html("介绍不可为空");
                return;
            }
            if (isEmpty(yysj)){
                $("#msg").html("营业时间不可为空");
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
    <a href="${pageContext.request.contextPath}/AStGlServlet">
        <img src="${pageContext.request.contextPath}/imgs/icon/back.png" style="width: 30px;height: 30px">
    </a>
</div>
<div class="container" style="padding: 5px 30px;">
    <h3>修改食堂页面</h3>
    <form id="AddSt" action="${pageContext.request.contextPath}/AStGlUpdateServlet" method="post" enctype="multipart/form-data" >
       <input type="hidden" name="id" id="id" value="${st.id}">
        <div class="form-group">
            <label for="name">食堂名称：</label>
            <input type="text" class="form-control" id="name" name="name" value="${st.name}">
        </div>

        <div class="form-group">
            <label for="position">食堂地点：</label>
            <input type="text" class="form-control" id="position" name="position" value="${st.position}">
        </div>

        <div class="form-group">
            <label for="myfile">食堂图片：</label>
            <input type="file"  id="myfile" name="myfile" multiple>
<c:forEach items="${stpicture}" var = "item" varStatus="s">
    <img src="${item}" style="width: 30px;height: 30px;margin: 4px;">
</c:forEach>

        </div>

        <div class="form-group">
            <label for="introduce">介绍：</label>
            <textarea name="introduce" id="introduce" cols="80" rows="20" >${st.introduce}</textarea>
        </div>

        <div class="form-group">
            <label for="yysj">营业时间：</label>
            <input type="text" class="form-control" id="yysj" name="yysj" value="${st.yysj}">
        </div>

        <span class="msg" id="msg" style="color: red" >${errMsg}</span>
        <div class="form-group" style="text-align: center">
            <button class="btn btn-primary" type="button" onclick="add()"  >添加</button>
        </div>
    </form>
</div>
</body>
</html>
