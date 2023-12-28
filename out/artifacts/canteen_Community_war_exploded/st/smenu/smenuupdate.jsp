<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改菜品</title>

    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <script type="text/javascript">

        function add() {

            var name = $("#name").val();
            var tw = $("#tw").val();
            var money = $("#money").val();
            var type = $("#type").val();
            var cuxiao = $("#cuxiao").val();
            var introduce =  $("#introduce").val();

            if (isEmpty(name)){
                $("#msg").html("名称不可为空");
                return;
            }
            if (isEmpty(tw)){
                $("#msg").html("摊位不可为空");
                return;
            }
            if (isEmpty(money)){
                $("#msg").html("价格不可为空");
                return;
            }
            if (isEmpty(type)){
                $("#msg").html("类型不可为空");
                return;
            }
            if (isEmpty(cuxiao)){
                $("#msg").html("促销说明不可为空");
                return;
            }
            if (isEmpty(introduce)){
                $("#msg").html("介绍不可为空");
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
    <h3>修改菜品页面</h3>
    <form id="AddInform" action="${pageContext.request.contextPath}/SMenuUpdateServlet" method="post" enctype="multipart/form-data" >
        <input type="hidden" name="id" id="id" value="${menu.id}">
        <div class="form-group">
            <label for="name">名称：</label>
            <input type="text" class="form-control" id="name" name="name" value="${menu.name}">
        </div>

        <div class="form-group">
            <label for="tw">摊位：</label>
            <input type="text" class="form-control" id="tw" name="tw" placeholder="如：五谷鱼粉" value="${menu.tw}">
        </div>

        <div class="form-group">
            <label for="money">价格：</label>
            <input type="text" class="form-control" id="money" name="money" placeholder="如：16/份" value="${menu.money}">
        </div>

        <div class="form-group">
            <label for="type">类型：</label>
            <input type="text" class="form-control" id="type" name="type" placeholder="如：日常售价" value="${menu.type}">
        </div>

        <div class="form-group">
            <label for="cuxiao">促销说明：</label>
            <input type="text" class="form-control" id="cuxiao" name="cuxiao" placeholder="有则填，无则填否" value="${menu.cuxiao}">
        </div>

        <div class="form-group">
            <label for="myfile">菜品图片：</label>
            <input type="file"  id="myfile" name="myfile" multiple>
            <c:forEach items="${stmenupictures}" var = "item" varStatus="s">
                <img src="${item}" style="width: 30px;height: 30px;margin: 4px;">
            </c:forEach>
        </div>

        <div class="form-group">
            <label for="introduce">菜品介绍：</label>
            <textarea name="introduce" id="introduce" cols="80" rows="20" >${menu.introduce}</textarea>
        </div>

        <span class="msg" id="msg" style="color: red" >${errMsg}</span>
        <div class="form-group" style="text-align: center">
            <button class="btn btn-primary" type="button" onclick="add()"  >添加</button>
        </div>
    </form>
</div>
</body>
</html>
