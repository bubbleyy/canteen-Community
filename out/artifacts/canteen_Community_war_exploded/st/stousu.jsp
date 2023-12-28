<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>食堂投诉</title>

    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <script type="text/javascript">

        function add() {

            var maintext = $("#maintext").val();

            if (isEmpty(maintext)){
                $("#msg").html("投诉内容不可为空");
                return;
            }

            document.getElementById("zhezhaoceng").style.display = 'flex'
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
    <a href="${pageContext.request.contextPath}/SMainServlet?stid=${stid}">
        <img src="${pageContext.request.contextPath}/imgs/icon/back.png" style="width: 30px;height: 30px">
    </a>
</div>
<div class="container" style="padding: 5px 30px;">
    <form id="AddInform" action="${pageContext.request.contextPath}/StTousuAddServlet" method="post" enctype="multipart/form-data" >
         <input type="hidden" name="id" id="id" value="${stid}">
        <div class="form-group">
            <label for="maintext">投诉内容：</label>
            <textarea name="maintext" id="maintext" cols="80" rows="20" ></textarea>
        </div>
        <div class="form-group">
            <label for="myfile">图片：</label>
            <input type="file"  id="myfile" name="myfile" multiple>
        </div>

        <span class="msg" id="msg" style="color: red" >${errMsg}</span>
        <div class="form-group" style="text-align: center">
            <button class="btn btn-primary" type="button" onclick="add()"  >发送</button>
        </div>
    </form>
</div>
<div style="width: 80px;height: 80px;background-color: black;opacity: 0.5;color: white;z-index: 100;display: none;margin: 20px auto;align-items: center;justify-content: center" id="zhezhaoceng">
    <text>投诉成功</text>
</div>
</body>
</html>
