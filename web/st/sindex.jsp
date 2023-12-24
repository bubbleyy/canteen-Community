
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <!-- 头部区域 -->
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
          <dd style="text-align: center;">    <form class="tuichu" action="outServlet" method="post">
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
      <!-- 左侧导航区域 -->
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
                   data-url="#"
                   data-id="plxx"
                   data-title="评论信息"
                   class="site-demo-active"
                   data-type="tabAdd"
            >评论信息</a></dd>
            <dd><a href="javascript:;"
                   data-url="#"
                   data-id="tsxx"
                   data-title="投诉信息"
                   class="site-demo-active"
                   data-type="tabAdd"
            >投诉信息</a></dd>
          </dl>
        </li>
      </ul>

      <ul class="layui-nav layui-nav-tree" lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:;"><img src="../imgs/icon/shezhi.png" style="height: 20px;width:20px;margin-right: 5px;">菜品管理</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;"
                   data-url="#"
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
                   data-url="${pageContext.request.contextPath}/#"
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
                   data-url="${pageContext.request.contextPath}/#"
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
          ,offset: 'rt'
          ,anim: 5
          ,shadeClose: true
        });
      }
    });

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
      tabDeleteAll: function (ids) {
        $.each(ids, function (i, item) {
          element.tabDelete("demo", item);
        })
      },
    };

    $('.site-demo-active').on(
            'click',
            function () {
              var dataid = $(this);

              if ($(".layui-tab-title li[lay-id]").length <= 0) {
                active
                        .tabAdd(dataid.attr("data-url"), dataid
                                .attr("data-id"), dataid
                                .attr("data-title"));
              } else {
                var isData = false; //初始化一个标志，为false说明未打开该tab项 为true则说明已有
                $.each($(".layui-tab-title li[lay-id]"),
                        function () {
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
