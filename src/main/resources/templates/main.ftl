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
<#--<div class="layui-header-ctm layui-bg-blue">-->
<#--<div>layui 后台布局</div>-->
<#--<!-- 头部区域（可配合layui已有的水平导航） &ndash;&gt;-->
<#--</div>-->

    <div class="layui-body-ctm">
        <fieldset class="layui-elem-field">
            <legend>劳动关系协调员(师)</legend>
            <div class="layui-field-box">
                已学[20]    总题量[2039]
            </div>
        </fieldset>
        <!-- 内容主体区域 -->
        <table class="layui-table" lay-skin="line">
            <colgroup>
                <col>
                <col width="100">
            </colgroup>
            <tbody>
            <tr>
                <td><a href="http://www.baidu.com">劳动关系协调员(三级)</a></td>
                <td><a href="http://www.baidu.com" class="layui-btn layui-btn-warm layui-btn-sm">购买</a></td>
            </tr>
            <tr>
                <td><a href="javascript:;">劳动关系协调师(二级)</a></td>
                <td><a href="javascript:;" class="layui-btn layui-btn-warm layui-btn-sm">购买</a></td>
            </tr>
            <tr>
                <td><a href="javascript:;">劳动关系协调师(一级)</a></td>
                <td><a href="javascript:;" class="layui-btn layui-btn-warm layui-btn-sm">购买</a></td>
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