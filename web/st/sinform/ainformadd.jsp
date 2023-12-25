<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>添加公告</title>

    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <script type="text/javascript">

        function add() {

            var title = $("#title").val();
            var type = $("#type").val();
            var maintext =  $("#maintext").val();

            if (isEmpty(title)){
                $("#msg").html("标题不可为空");
                return;
            }
            if (isEmpty(type)){
                $("#msg").html("类型不可为空");
                return;
            }
            if (isEmpty(maintext)){
                $("#msg").html("正文不可为空");
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
</head>
<body>
<div style="display: flex;align-items: center;margin-left: 30px;">
    <a href="${pageContext.request.contextPath}/SInformServlet">
        <img src="${pageContext.request.contextPath}/imgs/icon/back.png" style="width: 30px;height: 30px">
    </a>
</div>
<div class="container" style="padding: 5px 30px;">
    <h3>添加公告页面</h3>
    <form id="AddInform" action="${pageContext.request.contextPath}/SInformAddServlet" method="post" enctype="multipart/form-data" >
        <div class="form-group">
            <label for="title">标题：</label>
            <input type="text" class="form-control" id="title" name="title" >
        </div>

        <div class="form-group">
            <label for="type">类型：</label>
            <input type="text" class="form-control" id="type" name="type" placeholder="如：通知">
        </div>

        <div class="form-group">
            <label for="myfile">公告图片：</label>
            <input type="file"  id="myfile" name="myfile" multiple>
        </div>

        <div class="form-group">
            <label for="maintext">正文：</label>
            <textarea name="maintext" id="maintext" cols="80" rows="20" ></textarea>
        </div>

        <span class="msg" id="msg" style="color: red" >${errMsg}</span>
        <div class="form-group" style="text-align: center">
            <button class="btn btn-primary" type="button" onclick="add()"  >添加</button>
        </div>
    </form>
</div>
</body>
</html>
