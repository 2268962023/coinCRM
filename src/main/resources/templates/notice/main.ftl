<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../include.ftl"/>
</head>
<body class="pear-container">
<div class="layui-card">
    <div class="layui-card-body">
        <div class="col-sm-12 search-collapse">
            <form class="layui-form" id="formId">

                <div class="layui-form-item">
                    <label class="layui-form-label">标题：</label>
                    <div class="layui-input-inline">
                        <input class="layui-input" lay-required name="title" placeholder="请输入标题" type="text"/>
                    </div>
                    <div id="test6">
                        <label class="layui-form-label">时间</label>
                        <div class="layui-input-inline">
                            <input type="text" name="startTimes" readonly   id="test-startDate-1" class="layui-input" placeholder="yyyy-MM-dd HH:mm:ss">
                        </div>
                        <div class="layui-form-mid">
                            -
                        </div>
                        <div class="layui-input-inline">
                            <input type="text" name="endTimes" readonly   id="test-endDate-1" class="layui-input" placeholder="yyyy-MM-dd HH:mm:ss">
                        </div>
                    </div>

                    <button class="pear-btn pear-btn-md pear-btn-primary" lay-filter="notice-query" lay-submit>
                        <i class="layui-icon layui-icon-search"></i>
                        查询
                    </button>
                    <button class="pear-btn pear-btn-md" type="reset">
                        <i class="layui-icon layui-icon-refresh"></i>
                        重置
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="layui-card">
    <div class="layui-card-body">
        <table id="notice-table" lay-filter="notice-table"></table>

        <script id="notice-toolbar" type="text/html">
            <button
                    class="pear-btn pear-btn-primary pear-btn-md" lay-event="add">
                <i class="layui-icon layui-icon-add-1"></i>
                新增
            </button>
            <button
                    class="pear-btn pear-btn-md" lay-event="batchRemove">
                <i class="layui-icon layui-icon-delete"></i>
                删除
            </button>
        </script>

        <script id="notice-bar" type="text/html">
            <button
                    class="pear-btn pear-btn-primary pear-btn-sm" lay-event="edit"><i
                    class="layui-icon layui-icon-edit"></i>
            </button>
            <button
                    class="pear-btn pear-btn-danger pear-btn-sm" lay-event="remove"><i
                    class="layui-icon layui-icon-delete"></i>
            </button>
        </script>
    </div>
</div>

<script id="notice-accept" type="text/html">
    {{#if (d.acceptName==null || d.acceptName=='') { }}
    所有人
    {{# }else { }}
    {{d.acceptName}}
    {{# } }}
</script>

<script id="notice-type" type="text/html">
    {{#if (d.type === 'public') { }}
    公告
    {{# }else if(d.type === 'private') { }}
    私信
    {{# } }}
</script>

<script>
    layui.use(['table', 'form', 'jquery',], function () {
        let table = layui.table;
        let form = layui.form;
        let $ = layui.jquery;
        var laydate=layui.laydate;

        //日期范围
        laydate.render({
            elem: '#test6'
            //设置开始日期、日期日期的 input 选择器
            //数组格式为 2.6.6 开始新增，之前版本直接配置 true 或任意分割字符即可
            ,range: ['#test-startDate-1', '#test-endDate-1'],
            type: 'datetime'
        });


        var  tableIns = table.render({
            elem: '#notice-table',
            url : '/notice/list',
            page : true,
            skin: 'line',
            height : "full-125",
            limits : [10,15,20,25],
            limit : 10,
            cols : [[
                {type: 'checkbox'},
                {title: '标题', field: 'title', align: 'center', width: 110},
                {title: '简介', field: 'description', align: 'center', width: 110},
                {title: '作者', field: 'author', align: 'center', width: 90},
                {title: '文章状态', field: 'status', align: 'center',  width: 50},
                {title: '文章排序，越大越靠前', field: 'sort', align: 'center', width: 90},
                {title: '内容', field: 'content', align: 'center', width: 110},
                {title: '最后修改时间', field: 'last_update_time', align: 'center', width: 110},
                {title: '创建日期', field: 'created', align: 'center', width: 110},
            ]]
        });

        table.on('tool(notice-table)', function (obj) {
            if (obj.event === 'remove') {
                window.remove(obj);
            } else if (obj.event === 'edit') {
                window.edit(obj);
            }
        });

        table.on('toolbar(notice-table)', function (obj) {
            if (obj.event === 'add') {
                window.add();
            } else if (obj.event === 'refresh') {
                window.refresh();
            } else if (obj.event === 'batchRemove') {
                window.batchRemove(obj);
            }
        });
        //模糊查询
        form.on('submit(notice-query)', function (data) {
            tableIns.reload({
                where: data.field,
                page: {
                    curr: 1
                }
            });
            return false;
        });

        //
        // window.add = function () {
        //     layer.open({
        //         type: 2,
        //         title: '新增消息',
        //         shade: 0.1,
        //         area: ['550px', '500px'],
        //         content: prefix + 'add'
        //     });
        // }
        //
        // window.edit = function (obj) {
        //     layer.open({
        //         type: 2,
        //         title: '修改消息',
        //         shade: 0.1,
        //         area: ['550px', '500px'],
        //         content: prefix + 'edit?id=' + obj.data['id']
        //     });
        // }
        //
        // window.remove = function (obj) {
        //     layer.confirm('确定要删除该消息', {icon: 3, title: '提示'}, function (index) {
        //         layer.close(index);
        //         let loading = layer.load();
        //         $.ajax({
        //             url: prefix + "remove/" + obj.data['id'],
        //             dataType: 'json',
        //             type: 'delete',
        //             success: function (result) {
        //                 layer.close(loading);
        //                 if (result.success) {
        //                     layer.msg(result.msg, {icon: 1, time: 1000}, function () {
        //                         obj.del();
        //                     });
        //                 } else {
        //                     layer.msg(result.msg, {icon: 2, time: 1000});
        //                 }
        //             }
        //         })
        //     });
        // }
        //
        // window.batchRemove = function (obj) {
        //     let data = table.checkStatus(obj.config.id).data;
        //     if (data.length === 0) {
        //         layer.msg("未选中数据", {icon: 3, time: 1000});
        //         return false;
        //     }
        //     let ids = "";
        //     for (let i = 0; i < data.length; i++) {
        //         ids += data[i].id + ",";
        //     }
        //     ids = ids.substr(0, ids.length - 1);
        //     layer.confirm('确定要删除这些消息', {icon: 3, title: '提示'}, function (index) {
        //         layer.close(index);
        //         let loading = layer.load();
        //         $.ajax({
        //             url: prefix + "batchRemove",
        //             dataType: 'json',
        //             data: {"ids": ids},
        //             type: 'delete',
        //             success: function (result) {
        //                 layer.close(loading);
        //                 if (result.success) {
        //                     layer.msg(result.msg, {icon: 1, time: 1000}, function () {
        //                         table.reload('notice-table');
        //                     });
        //                 } else {
        //                     layer.msg(result.msg, {icon: 2, time: 1000});
        //                 }
        //             }
        //         })
        //     });
        // }
        //

    })
</script>
</body>
</html>