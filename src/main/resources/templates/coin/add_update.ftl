<!DOCTYPE html>
<html>
<head>
    <#include "../include.ftl">
</head>
<body class="childrenBody">
<form class="layui-form" style="width:80%;">
    <div class="layui-form-item layui-row layui-col-xs12">
        <input name="id" type="hidden" value="${(coinType.id)!}"/>
        <label class="layui-form-label">货币代码</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input"
                   lay-verify="required" name="code" id="code"  value="${(coinType.code)!}" placeholder="货币代码">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">货币描述</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input"
                   lay-verify="required" name="description" id="description" value="${(coinType.description)!}" placeholder="请输入货币描述">
        </div>
    </div>

    <br/>
    <div class="layui-form-item layui-row layui-col-xs12">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-lg" lay-submit=""
                    lay-filter="addOrUpdateCoinType">确认
            </button>
            <button class="layui-btn layui-btn-lg layui-btn-normal" id="closeBtn">取消</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="/js/coin/add_update.js"></script>
</body>
</html>