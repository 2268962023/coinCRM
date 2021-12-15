<!DOCTYPE html>
<html>
<head>
    <title>财产查询</title>
    <#include "../include.ftl">
</head>
<body class="childrenBody">

<form class="layui-form" >
    <blockquote class="layui-elem-quote quoteBox">
        <form class="layui-form">
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" name="accountName"
                           class="layui-input
               searchVal" placeholder="用户名" />
                </div>
                <a class="layui-btn search_btn" data-type="reload"><i
                            class="layui-icon">&#xe615;</i> 搜索</a>
            </div>
        </form>
    </blockquote>
    <table id="accountList" class="layui-table"  lay-filter="account"></table>

</form>
<script type="text/javascript" src="/js/account/account.js"></script>
</body>
</html>