<!DOCTYPE html>
<html lang="en">
<head>

    <link rel="stylesheet" href="${ctx}/admin/css/other/user.css}"/>
</head>
<body class="pear-container">
<div class="layui-card">
    <div class="layui-card-body">
        <form action="" class="layui-form" lay-filter="user-query-form">
            <div class="layui-form-item">
                <label class="layui-form-label">用户</label>
                <div class="layui-input-inline">
                    <input class="layui-input" name="realName" placeholder="" type="text">
                </div>
                <label class="layui-form-label">账号</label>
                <div class="layui-input-inline">
                    <input class="layui-input" name="username" placeholder="" type="text">
                </div>
                <button class="pear-btn pear-btn-md pear-btn-primary" lay-filter="user-query" lay-submit>
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
<div class="user-left user-collasped">
    <div class="layui-card">
        <div class="layui-card-body">
            <div class="button button-primary user-group" user-group=""> 全 部 用 户</div>
            <div class="button button-default user-group" user-group="-1"> 默 认 分 组</div>
            <div style="overflow: auto">
                <ul class="dept-tree" data-id="0" id="dept-tree"></ul>
            </div>
        </div>
    </div>
</div>
<div class="user-main user-collasped">
    <div class="layui-card">
        <div class="layui-card-body">
            <table id="user-table" lay-filter="user-table"></table>
        </div>
    </div>
</div>
</body>

<script id="user-toolbar" type="text/html">
    <button class="pear-btn pear-btn-primary pear-btn-md" lay-event="add">
        <i class="pear-icon pear-icon-add"></i>
        新增
    </button>
    <button  class="pear-btn pear-btn-md"
            lay-event="batchRemove">
        <i class="pear-icon pear-icon-ashbin"></i>
        删除
    </button>
    <button class="pear-btn pear-btn-md" lay-event="collasped">
        <i class="pear-icon pear-icon-modular"></i>
        高级
    </button>
</script>

<script id="user-bar" type="text/html">
    <button
            class="pear-btn pear-btn-primary pear-btn-sm" lay-event="edit"><i class="pear-icon pear-icon-edit"></i>
    </button>
    <button
            class="pear-btn pear-btn-danger pear-btn-sm" lay-event="remove"><i class="pear-icon pear-icon-ashbin"></i>
    </button>
</script>

<script id="user-enable" type="text/html">
    <input type="checkbox" name="enable" value="{{d.userId}}" lay-skin="switch" lay-text="启用|禁用"
           lay-filter="user-enable" {{ d.enable== true ? 'checked' : '' }} />
</script>
<#include "../../include.ftl"/>
<script id="user-sex" type="text/html">
    {{#if (d.sex == 0) { }}
    <span>男</span>
    {{# }else if(d.sex == 1){ }}
    <span>女</span>
    {{# } }}
</script>

<script id="user-login" type="text/html">
    {{#if (d.login == 0) { }}
    <span>在线</span>
    {{# }else if(d.sex == 1){ }}
    <span>离线</span>
    {{# } }}
</script>

<script>
    layui.use(['table', 'dtree', 'form', 'jquery', 'popup', 'common'], function () {
        let table = layui.table;
        let form = layui.form;
        let $ = layui.jquery;
        let dtree = layui.dtree;
        let popup = layui.popup;
        let common = layui.common;

        let MODULE_PATH = "/system/user/";

        let cols = [
            [
                {type: 'checkbox'},
                {title: '姓名', field: 'realName', align: 'center', width: 110},
                {title: '账号', field: 'username', align: 'center'},
                {title: '性别', field: 'sex', align: 'center', templet: '#user-sex', width: 60},
                {title: '电话', field: 'phone', align: 'center'},
                {title: '启用', field: 'enable', align: 'center', templet: '#user-enable', width: 120},
                {title: '注册时间', field: 'createTime', align: 'center'},
                {title: '操作', toolbar: '#user-bar', align: 'center', width: 130}
            ]
        ]

        table.render({
            elem: '#user-table',
            url: MODULE_PATH + 'data',
            page: true,
            cols: cols,
            skin: 'line',
            height: 'full-148',
            toolbar: '#user-toolbar',
            text: {none: '暂无人员信息'},
            defaultToolbar: [{
                layEvent: 'refresh',
                icon: 'layui-icon-refresh',
                title: "刷新"
            }, 'filter', 'print', 'exports']
        });

        dtree.render({
            elem: "#dept-tree",
            method: "get",
            url: "/system/dept/tree",
            dataFormat: "list",
            line: true,
            skin: "laySimple",
            icon: "-1",
            response: {treeId: "deptId", parentId: "parentId", title: "deptName"},
        });

        dtree.on("node('dept-tree')", function (obj) {
            let field = form.val("user-query-form");
            field.deptId = obj.param.nodeId;
            window.refresh(field);
        });

        $(".user-group").click(function () {
            let group = $(this).attr("user-group");
            let field = form.val("user-query-form");
            if (group === "-1") {
                field.deptId = group;
                $(this).removeClass("button-default");
                $(this).prev().removeClass("button-primary");
                $(this).prev().addClass("button-default");
                $(this).addClass("button-primary");
            } else {
                field.deptId = group;
                $(this).removeClass("button-default");
                $(this).next().removeClass("button-primary");
                $(this).next().addClass("button-default");
                $(this).addClass("button-primary");
            }
            window.refresh(field);
        })

        table.on('tool(user-table)', function (obj) {
            if (obj.event === 'remove') {
                window.remove(obj);
            } else if (obj.event === 'edit') {
                window.edit(obj);
            }
        });

        table.on('toolbar(user-table)', function (obj) {
            if (obj.event === 'add') {
                window.add();
            } else if (obj.event === 'refresh') {
                window.refresh();
            } else if (obj.event === 'batchRemove') {
                window.batchRemove(obj);
            } else if (obj.event == 'collasped') {
                $(".user-left").toggleClass("user-collasped");
                $(".user-main").toggleClass("user-collasped");
                table.resize();
            }
        });

        form.on('submit(user-query)', function (data) {
            window.refresh(data.field);
            return false;
        });

        form.on('switch(user-enable)', function (obj) {
            let operate;
            if (obj.elem.checked) {
                operate = "enable";
            } else {
                operate = "disable";
            }
            let loading = layer.load();
            $.ajax({
                url: '/system/user/' + operate,
                data: JSON.stringify({userId: this.value}),
                dataType: 'json',
                contentType: 'application/json',
                type: 'put',
                success: function (result) {
                    layer.close(loading);
                    if (result.success) {
                        popup.success(result.msg);
                    } else {
                        popup.failure(result.msg);
                    }
                }
            })
        });

        window.add = function () {
            layer.open({
                type: 2,
                title: '新增',
                shade: 0.1,
                area: ['550px', '550px'],
                content: MODULE_PATH + 'add'
            });
        }

        window.edit = function (obj) {
            layer.open({
                type: 2,
                title: '修改',
                shade: 0.1,
                area: ['550px', '500px'],
                content: MODULE_PATH + 'edit?userId=' + obj.data['userId']
            });
        }

        window.remove = function (obj) {
            layer.confirm('确定要删除该用户', {icon: 3, title: '提示'}, function (index) {
                layer.close(index);
                let loading = layer.load();
                $.ajax({
                    url: MODULE_PATH + "remove/" + obj.data['userId'],
                    dataType: 'json',
                    type: 'delete',
                    success: function (result) {
                        layer.close(loading);
                        if (result.success) {
                            popup.success(result.msg, function () {
                                obj.del();
                            });
                        } else {
                            popup.failure(result.msg);
                        }
                    }
                })
            });
        }

        window.batchRemove = function (obj) {
            let ids = common.checkField(obj, 'userId');
            if (common.isEmpty(ids)) {
                popup.warning("未选中数据");
                return false;
            }
            layer.confirm('确定要删除选中用户', {icon: 3, title: '提示'}, function (index) {
                layer.close(index);
                let loading = layer.load();
                $.ajax({
                    url: MODULE_PATH + "batchRemove/" + ids,
                    dataType: 'json',
                    type: 'delete',
                    success: function (result) {
                        layer.close(loading);
                        if (result.success) {
                            popup.success(result.msg, function () {
                                table.reload('user-table');
                            })
                        } else {
                            popup.failure(result.msg);
                        }
                    }
                })
            });
        }

        window.refresh = function (param) {
            table.reload('user-table', {where: param});
        }
    })
</script>
</html>