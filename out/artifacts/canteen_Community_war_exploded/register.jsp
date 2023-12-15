<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="Stylesheet" type="text/css" href="./css/register.css" charset="utf-8">
  <title>注册页面</title>
</head>
<body>

<form  id="RegisterForm" style="margin: auto;width: 300px" action="registerServlet" method="post">

  <h3>系统注册</h3>
  <input type="hidden" name="wisdom" value="common">
  <div>
    登录用户名：<input id="username" type="text" name="username"></div>
  <div>
    姓名：<input id="name" type="text" name="name"></div>
  <div>
    联系方式：<input id="phone" type="text" name="phone"></div>
  <div>
    部门：<input id="status" type="text" name="status"></div>
  <div>
    密码：<input id="password" type="password" name="password"></div>
  <div>
    确认密码：<input id="upassword" type="password" name="upassword"></div>

  <span class="msg" id="msg" style="color: red" ></span>
  <div class="zhucehudong">
    <button type="button" onclick="login()"  class="zhuce" >注册</button>
    <a href="login.html"><button type="button"  class="denglu" >前往登录</button></a>
  </div>

</form>

</body>

<script type="text/javascript" src="js/jquery-3.4.1.js"></script>

<script type="text/javascript">

  function login() {

    var uname = $("#username").val();
    var upwd = $("#password").val();
    var uuname = $("#name").val();
    var uphone =  $("#phone").val();
    var ustatus =  $("#status").val();
    var upwdagain = $("#upassword").val();

    if (isEmpty(uname)){
      $("#msg").html("登录用户名不可为空");
      return;
    }
    if (isEmpty(uuname)){
      $("#msg").html("用户姓名不可为空");
      return;
    }
    if (isEmpty(uphone)){
      $("#msg").html("联系方式不可为空");
      return;
    }
    if (isEmpty(ustatus)){
      $("#msg").html("部门不可为空");
      return;
    }

    if (isEmpty(upwd)){
      $("#msg").html("用户密码不可为空");
      return;
    }
    if (isEmpty(upwdagain)){
      $("#msg").html("确认密码不可为空");
      return;
    }
    if (upwd != upwdagain){
      $("#msg").html("两次密码不一致");
      return;
    }

    $("#RegisterForm").submit();


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

