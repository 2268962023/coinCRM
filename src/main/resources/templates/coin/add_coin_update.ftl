<!DOCTYPE html>
<html>
<head>
    <#include "../include.ftl">
</head>
<body class="childrenBody">
<form class="layui-form" style="width:80%;">
    <div class="layui-form-item layui-row layui-col-xs12">
        <input name="id" type="hidden" value="${(coin.id)!}"/>
        <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">币种名称</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input"
                       lay-verify="required" name="name" id="name"  value="${(coin.name)!}" placeholder="币种名称">
            </div>
        </div>
        <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">最小提现数</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input"
                       lay-verify="required" name="minAmount" id="minAmount"  value="${(coin.minAmount)!}" placeholder="最小提现数">
            </div>
        </div>
        <div class="layui-form-item layui-row layui-col-xs12">
            <label class="layui-form-label">最小提现数</label>
            <div class="layui-input-block">

                <input type="text" class="layui-input"
                       lay-verify="required" name="maxAmount" id="maxAmount"  value="${(coin.maxAmount)!}" placeholder="最大提现数">
            </div>
        </div>
        <div class="layui-form-item layui-row layui-col-xs12">
            <label class="layui-form-label">币种系列</label>
            <div class="layui-input-block">
                <select name="type" id="type">
                    <option value="">请选择</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item layui-row layui-col-xs12">
            <label class="layui-form-label">币种类型</label>
            <div class="layui-input-block">
                <select name="wallet" id="wallet">
                    <option value="">请选择</option>
                </select>
            </div>
        </div>
    </div>



    <br/>
    <div class="layui-form-item layui-row layui-col-xs12">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-lg" lay-submit=""
                    lay-filter="addOrUpdateCoin">确认
            </button>
            <button class="layui-btn layui-btn-lg layui-btn-normal" id="closeBtn">取消</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="/js/coin/add_update.js"></script>
</body>
</html>