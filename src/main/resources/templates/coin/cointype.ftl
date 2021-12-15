<!DOCTYPE html>
<html>
<head>
    <title>币种类型管理</title>
    <#include "../include.ftl">
</head>
<body class="childrenBody">

<form class="layui-form" >
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form">
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" name="code" class="layui-input searchVal" placeholder="货币代码" />
                </div>
                <div class="layui-input-inline">
                    <input class="layui-input" name="createdBegin" id="createdBegin" type="text" placeholder="请选择创建日期开始区间">
                </div>
                ~
                <div class="layui-input-inline">
                    <input class="layui-input" name="createdEnd" id="createdEnd" type="text" placeholder="请选择创建日期结束日期">
                </div>

                <a class="layui-btn search_btn" data-type="reload"><i
                            class="layui-icon">&#xe615;</i> 搜索</a>
            </div>
        </form>
    </blockquote>
    <table id="typeList" class="layui-table"  lay-filter="type"></table>

    <script type="text/html" id="toolbarDemo">
        <div class="layui-btn-container">
            <a class="layui-btn layui-btn-normal addNews_btn" lay-event="add">
                <i class="layui-icon">&#xe608;</i>
                新增
            </a>
            <a class="layui-btn layui-btn-normal delNews_btn" lay-event="del">
                <i class="layui-icon">&#xe672;</i>
                删除
            </a>
        </div>
    </script>

    <!--操作-->
    <script id="coinListBar" type="text/html">
        <a class="layui-btn layui-btn-xs" id="edit" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
    </script>

</form>
<script type="text/javascript" src="/js/coin/cointype.js"></script>
</body>
</html>