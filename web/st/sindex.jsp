
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>食堂管理员主页</title>
  <link rel="stylesheet" href="../layui/css/layui.css">
  <style>
    .layui-this>a:hover{background-color:rgb(40,43,51);color:#fff;}
  </style>
</head>
<body>
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo layui-hide-xs layui-bg-black">
      <img src="../imgs/system.png" style="width: 30px;height: 30px;margin-right: 5px">
      食堂管理员主页
    </div>
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item layui-hide-xs"><span id="times"></span></li>

    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item layui-hide layui-show-md-inline-block">
        <a href="javascript:;">
          <img src="${pageContext.request.contextPath}/${loginuser.faceimg}" class="layui-nav-img">
          ${loginuser.username}
        </a>
        <dl class="layui-nav-child">
          <dd><a href="javascript:;">状态：${loginuser.status}</a></dd>
          <hr>
          <dd style="text-align: center;">    <form class="tuichu" action="${pageContext.request.contextPath}/outServlet" method="post">
            <input type="submit" value="退出登录">
          </form></dd>
        </dl>
      </li>
      <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
        <a href="javascript:;">
          <i class="layui-icon layui-icon-more-vertical"></i>
        </a>
      </li>
    </ul>
  </div>

  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <ul class="layui-nav layui-nav-tree" lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a href="${pageContext.request.contextPath}/IndexServlet">首页</a>
        </li>
      </ul>
      <ul class="layui-nav layui-nav-tree" lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:;"><img src="../imgs/mainguanli.png" style="height: 20px;width:20px;margin-right: 5px;">食堂评论与投诉</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;"
                   data-url="${pageContext.request.contextPath}/SstplServlet"
                   data-id="stplxx"
                   data-title="食堂评论信息"
                   class="site-demo-active"
                   data-type="tabAdd"
            >食堂评论信息</a></dd>
            <dd><a href="javascript:;"
                   data-url="${pageContext.request.contextPath}/SsttsServlet"
                   data-id="tsxx"
                   data-title="投诉信息"
                   class="site-demo-active"
                   data-type="tabAdd"
            >食堂投诉信息</a></dd>

            <dd><a href="javascript:;"
                   data-url="${pageContext.request.contextPath}/SmenuplServlet"
                   data-id="cpplxx"
                   data-title="菜品评论信息"
                   class="site-demo-active"
                   data-type="tabAdd"
            >菜品评论信息</a></dd>

          </dl>
        </li>
      </ul>

      <ul class="layui-nav layui-nav-tree" lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:;"><img src="../imgs/icon/shezhi.png" style="height: 20px;width:20px;margin-right: 5px;">菜品管理</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;"
                   data-url="${pageContext.request.contextPath}/SMenuServlet"
                   data-id="cpxx"
                   data-title="菜品信息"
                   class="site-demo-active"
                   data-type="tabAdd"
            >菜品信息</a></dd>
          </dl>

        </li>
      </ul>

      <ul class="layui-nav layui-nav-tree" lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:;"><img src="../imgs/icon/shezhi.png" style="height: 20px;width:20px;margin-right: 5px;">公告管理</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;"
                   data-url="${pageContext.request.contextPath}/SInformServlet"
                   data-id="ggxx"
                   data-title="公告信息"
                   class="site-demo-active"
                   data-type="tabAdd"
            >公告信息</a></dd>
          </dl>

        </li>
      </ul>

      <ul class="layui-nav layui-nav-tree" lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:;"><img src="../imgs/icon/shezhi.png" style="height: 20px;width:20px;margin-right: 5px;">账户管理</a>

          <dl class="layui-nav-child">

            <dd><a href="javascript:;"
                   data-url="${pageContext.request.contextPath}/SstzhServlet"
                   data-id="grzh"
                   data-title="个人账户"
                   class="site-demo-active"
                   data-type="tabAdd"
            >个人账户</a></dd>

          </dl>
        </li>
      </ul>


    </div>
  </div>

  <div class="layui-body">
    <div style="padding: 15px;">

      <div class="layui-row layui-col-space15" style="padding: 0px;height: 555px !important;">
        <div style="width: 99%" >
          <div class="layui-card">
            <div  style="margin: 0;line-height: 24px">
              <div class="layui-tab layui-tab-card layui-tab-brief" lay-allowclose="true" lay-filter="demo" style="width: 100%;height: auto">
                <ul class="layui-tab-title">
                  <li class="layui-this"><i class="layui-icon layui-icon-home" style="font-size:14px;color: #009688;font-weight: bold"></i>首页</li>
                </ul>
                <div class="layui-tab-content" style="height: 555px !important;">
                  <div class="layui-tab-item layui-show" style="text-align: center;height: 555px !important;">
                    <iframe src="swelcome.jsp" width="98%" style="height: 555px !important;" ></iframe>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

    </div>
  </div>


</div>
<script src="../layui/layui.js"></script>
<script>
  layui.use(['element', 'layer', 'util'], function(){
    var element = layui.element
            ,layer = layui.layer
            ,util = layui.util
            ,$ = layui.$;

    //头部事件
    util.event('lay-header-event', {
      //左侧菜单事件
      menuLeft: function(othis){
        layer.msg('展开左侧菜单的操作', {icon: 0});
      }
      ,menuRight: function(){
        layer.open({
          type: 1
          ,content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
          ,area: ['260px', '100%']
          ,offset: 'rt' //右上角
          ,anim: 5
          ,shadeClose: true
        });
      }
    });

    //时钟定时器
    setInterval(function () {
      let dateStr = "";
      let date = new Date();
      //单独的获取时间
      dateStr += date.getFullYear() + "年";
      dateStr += ((date.getMonth()+1)<10?"0"+(date.getMonth()+1):(date.getMonth()+1))+"月";
      dateStr += (date.getDate()<10?"0"+date.getDate():date.getDate())+"日";
      dateStr += (date.getHours()<10?"0"+date.getHours():date.getHours())+"时";
      dateStr += (date.getMinutes()<10?"0"+date.getMinutes():date.getMinutes())+"分";
      dateStr += (date.getSeconds()<10?"0"+date.getSeconds():date.getSeconds())+"秒";
      let xq = ["日","一","二","三","四","五","六"];
      dateStr += "    星期"+xq[date.getDay()];

      $("#times").text(dateStr);
    },1000);

    //触发事件
    var active = {
      tabAdd: function (url, id, title) {
        element.tabAdd('demo', {
          title: title,
          content: '<iframe data-frameid="' + id
                  + '" scrolling="auto" frameborder="0" src="'
                  + url + '" style="width:100%;height: 730px"></iframe>',
          id: id
        })
        element.render('tab');

      },
      tabChange: function (id) {
        element.tabChange('demo', id);
      },
      tabDelete: function (id) {
        element.tabDelete("demo", id);
      },
      tabDeleteAll: function (ids) {//删除所有
        $.each(ids, function (i, item) {
          element.tabDelete("demo", item); //ids是一个数组，里面存放了多个id，调用tabDelete方法分别删除
        })
      },
    };

    //当点击有site-demo-active属性的标签时，即左侧菜单栏中内容 ，触发点击事件
    $('.site-demo-active').on(
            'click',
            function () {
              var dataid = $(this);

              //这时会判断右侧.layui-tab-title属性下的有lay-id属性的li的数目，即已经打开的tab项数目
              if ($(".layui-tab-title li[lay-id]").length <= 0) {
                //如果比零小，则直接打开新的tab项
                active
                        .tabAdd(dataid.attr("data-url"), dataid
                                .attr("data-id"), dataid
                                .attr("data-title"));
              } else {
                //否则判断该tab项是否以及存在

                var isData = false;
                $.each($(".layui-tab-title li[lay-id]"),
                        function () {
                          //如果点击左侧菜单栏所传入的id 在右侧tab项中的lay-id属性可以找到，则说明该tab项已经打开
                          if ($(this).attr("lay-id") == dataid
                                  .attr("data-id")) {
                            isData = true;
                          }
                        })
                if (isData == false) {
                  //标志为false 新增一个tab项
                  active.tabAdd(dataid.attr("data-url"), dataid
                          .attr("data-id"), dataid
                          .attr("data-title"));
                }
              }
              active.tabChange(dataid.attr("data-id"));
            });

  });
</script>
</body>
</html>