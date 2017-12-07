<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${base}/layui-v2.2.3/css/layui.css" media="all">
    <link rel="stylesheet" href="${base}/css/qbank.css">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->

</head>
<body>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
<script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
<script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<!-- 内容 -->
<div class="layui-layout layui-layout-admin">
    <div class="layui-header-ctm">
        <#--<div>layui 后台布局</div>-->
        <!-- 头部区域（可配合layui已有的水平导航） -->
    </div>

    <div class="layui-body-ctm">
        <#--<fieldset class="layui-elem-field layui-field-title">-->
            <#--<legend>表单集合演示</legend>-->
        <#--</fieldset>-->
        <!-- 内容主体区域 -->
        <table class="layui-table">
            <colgroup>
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>昵称</th>
                <th>加入时间</th>
                <th>签名</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>贤心</td>
                <td>2016-11-29</td>
                <td>人生就像是一场修行</td>
            </tr>
            <tr>
                <td>许闲心</td>
                <td>2016-11-28</td>
                <td>于千万人之中遇见你所遇见的人，于千万年之中，时间的无涯的荒野里…</td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="layui-footer-ctm layui-bg-gray" style="text-align: center;">
        <!-- 底部固定区域 -->
    <#--© layui.com - 底部固定区域-->
        <span class="layui-breadcrumb" lay-separator=" " style="text-align: center;">
          <a href=""><i class="layui-icon">&#xe6b2;</i>题 库</a>
          <a href=""><i class="layui-icon">&#xe705;</i>资 料</a>
          <a href=""><i class="layui-icon">&#xe735;</i>专 区</a>
          <a href=""><i class="layui-icon">&#xe612;</i>我 的</a>
        </span>
    </div>
</div>


<script src="${base}/layui-v2.2.3/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function () {
        var element = layui.element;

        //...
    });
</script>

</body>
</html>