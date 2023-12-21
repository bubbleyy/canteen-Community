<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./layui/css/layui.css">
    <script src="../layui/layui.js"></script>
</head>
<body>
<div class="layui-carousel" style="height: 555px !important;" id="test1" lay-filter="test1">
    <div carousel-item="">
        <div> <img src="${pageContext.request.contextPath}/imgs/1.png" style="height: 555px;width: 100%;object-fit: cover" > </div>
        <div> <img src="${pageContext.request.contextPath}/imgs/2.jpeg" style="height: 555px;width: 100%;object-fit: cover" > </div>
        <div> <img src="${pageContext.request.contextPath}/imgs/3.jpeg" style="height: 555px;width: 100%;object-fit: cover" > </div>
    </div>
</div>

</body>
<script>
    layui.use(['carousel', 'form'], function(){

        //监听开关
        form.on('switch(autoplay)', function(){
            ins3.reload({
                autoplay: this.checked
            });
        });

        $('.demoSet').on('keyup', function(){
            var value = this.value
                ,options = {};
            if(!/^\d+$/.test(value)) return;

            options[this.name] = value;
            ins3.reload(options);
        });
    });

</script>
</html>
