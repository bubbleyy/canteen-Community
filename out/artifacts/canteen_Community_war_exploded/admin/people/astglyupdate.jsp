<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改食堂管理员</title>

    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <script type="text/javascript">

        function add() {

            var username = $("#username").val();
            var password = $("#password").val();

            if (isEmpty(username)){
                $("#msg").html("用户名不可为空");
                return;
            }
            if (isEmpty(password)){
                $("#msg").html("密码不可为空");
                return;
            }

            $("#AddStgly").submit();

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
    <a href="${pageContext.request.contextPath}/AStGlRyServlet?stid=${stid}">
        <img src="${pageContext.request.contextPath}/imgs/icon/back.png" style="width: 30px;height: 30px">
    </a>
</div>
<div class="container" style="padding: 5px 30px;">
    <h3>修改食堂管理员页面</h3>
    <form id="AddStgly" action="${pageContext.request.contextPath}/AStGlRyUpdateServlet" method="post" enctype="multipart/form-data" >
         <input name="stid" id="stid" type="hidden" value="${stid}" >
        <input name="glyname" id="glyname" type="hidden" value="${stgly.username}" >
        <div class="form-group">
            <label for="username">管理员用户名：</label>
            <input type="text" class="form-control" id="username" name="username" disabled value="${stgly.username}">
        </div>

        <div class="form-group">
            <label for="password">管理员密码：</label>
            <input type="text" class="form-control" id="password" name="password" value="${stgly.password}">
        </div>

        <div class="form-group">
            <label for="myfile">管理员头像：</label>
            <input type="file"  id="myfile" name="myfile" >
            <img src="${pageContext.request.contextPath}/${stgly.faceimg}" style="width: 60px;height: 60px;">
        </div>

        <span class="msg" id="msg" style="color: red" >${errMsg}</span>
        <div class="form-group" style="text-align: center">
            <button class="btn btn-primary" type="button" onclick="add()"  >设置</button>
        </div>
    </form>
</div>
</body>
</html>
