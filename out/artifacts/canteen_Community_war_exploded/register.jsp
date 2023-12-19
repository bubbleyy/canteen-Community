<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>师生注册页面</title>
</head>
<body>

<div style="width: 60%;height: 400px;margin:50px auto">
  <a href="IndexServlet" >返回首页</a>
  <hr/>
  <form  action="registerServlet" enctype="multipart/form-data" name="RegisterForm" id="RegisterForm"  method="post" class="form-horizontal" >
    <div class="form-group">
      <label for="userName" class="col-sm-2 control-label">*账号</label>
      <div class="col-sm-10">
        <input name="username"  class="form-control" id="username" placeholder="你的账号" />
      </div>
    </div>
    <div class="form-group">
      <label for="password" class="col-sm-2 control-label">*密码</label>
      <div class="col-sm-10">
        <input  name="password" class="form-control" id="password" placeholder="你的密码" />
      </div>
    </div>

    <div class="form-group">
      <label for="picture">*头像</label>
      <input type="file"  name="picture" id="picture" placeholder="请选择图片" >
    </div>

    <p style="color: red">${errMsg}</p>
    <div >
      <div class="col-sm-offset-2 col-sm-10">
        <button href="javascript:login();"  class="btn btn-default">注册</button>
      </div>
    </div>
  </form>
  <hr/>

</div>
</body>

<script type="text/javascript" src="js/jquery-3.4.1.js"></script>

<script type="text/javascript">

  function login() {

    var uname = $("#username").val();
    var upwd = $("#password").val();

    if (isEmpty(uname)){
      $("#msg").html("登录用户名不可为空");
      return;
    }

    if (isEmpty(upwd)){
      $("#msg").html("用户密码不可为空");
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
