<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>添加食堂</title>

    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <script type="text/javascript">

        function add() {

            var name = $("#name").val();
            var position = $("#position").val();
            var myfile =  $("#myfile").val();
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
            if (isEmpty(myfile)){
                $("#msg").html("图片不可为空");
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
    <h3>添加食堂页面</h3>
    <form id="AddSt" action="${pageContext.request.contextPath}/AStGlAddServlet" method="post" enctype="multipart/form-data" >
        <div class="form-group">
            <label for="name">食堂名称：</label>
            <input type="text" class="form-control" id="name" name="name" >
        </div>

        <div class="form-group">
            <label for="position">食堂地点：</label>
            <input type="text" class="form-control" id="position" name="position" >
        </div>

        <div class="form-group">
            <label for="myfile">食堂图片：</label>
            <input type="file"  id="myfile" name="myfile" multiple>
        </div>

        <div class="form-group">
            <label for="introduce">介绍：</label>
            <textarea name="introduce" id="introduce" cols="80" rows="20" ></textarea>
        </div>

        <div class="form-group">
            <label for="yysj">营业时间：</label>
            <input type="text" class="form-control" id="yysj" name="yysj" >
        </div>

        <span class="msg" id="msg" style="color: red" >${errMsg}</span>
        <div class="form-group" style="text-align: center">
            <button class="btn btn-primary" type="button" onclick="add()"  >添加</button>
        </div>
    </form>
</div>
</body>
</html>
