<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>登录</title>
    <link rel="stylesheet" href="css/login.css" >

</head>
<body>
<form  id="LoginForm" action="loginServlet" method="post"  class="login">
    <div id="login_box" class="login-box">
        <h2>登录</h2>
        <div style="width: 100%;display: flex;flex-direction: row;flex-wrap: wrap">
            <input type="radio" name="logintype" checked="checked" value="师生用户" /><text style="font-size: 14px;">师生用户</text>
            <input type="radio" name="logintype" value="食堂管理员" /><text style="font-size: 14px;">食堂管理员</text>
            <input type="radio" name="logintype"  value="系统管理员" /><text style="font-size: 14px;">系统管理员</text>
        </div>
        <div id="input_box" style="width: 80%;text-align: center;margin: 10px 0;">
            <input id="username" type="text" name="username" placeholder="请输入账号" >
        </div>
        <div class="input_box" style="width: 80%;text-align: center;margin: 10px 0;">
            <input id="password" type="password" name="password"  placeholder="请输入密码" >
        </div>
        <span class="msg" id="msg" style="color: red;width: 100%;text-align: center;margin: 5px;" >${error}</span>
        <button href="javascript:login();" class="denglu" style="width: 80%;margin-top: 10px;">登录</button><br>
        <div style="color: white;padding-top: 20px;"><a href="register.jsp"  class="zhuce" style="width: 100%">注册师生用户</a><br></div>
    </div>

</form>


</body>



<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript">


    function login() {
        console.log("允许登录")
        var uname = $("#username").val();
        var upwd = $("#password").val();

        if (isEmpty(uname)){
            $("#msg").html("用户姓名不可为空");
            return;
        }
        if (isEmpty(upwd)){
            $("#msg").html("用户密码不可为空");
            return;
        }

        $("#LoginForm").submit();


    }

    //专用方法：判断为空

    function isEmpty(str) {
        if (str == null || str.trim() == ""){
            return true;
        }
        return false;

    }


</script>

</html>