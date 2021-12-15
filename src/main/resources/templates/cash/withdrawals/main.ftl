<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="/admin/css/other/user.css}"/>
</head>
<body class="pear-container">
<div class="layui-card">
    <div class="layui-card-body">
        <form action="" class="layui-form" lay-filter="user-query-form">
            <div class="layui-form-item">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-inline">
                    <input class="layui-input" name="username" placeholder="" type="text">
                </div>
                <label class="layui-form-label">手机号码</label>
                <div class="layui-input-inline">
                    <input class="layui-input" name="phone" placeholder="" type="text">
                </div>
                <label class="layui-form-label">状态</label>
                <div class="layui-input-inline">
                    <select name="status">
                        <option selected value="10">请选择状态</option>
                        <option value="0">待审核</option>
                        <option value="1">审核通过</option>
                        <option value="2">拒绝</option>
                        <option value="3">充值成功</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">

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
                   <label class="layui-form-label">提现金额</label>

                   <div class="layui-input-inline">
                       <input class="layui-input" name="startNum" placeholder="" type="text">
                   </div>
                   <div class="layui-form-mid">-</div>
                   <div class="layui-input-inline">
                       <input class="layui-input" name="endNum" placeholder="" type="text">
                   </div>


                <div class="layui-input-inline">
                    <button class="pear-btn pear-btn-md pear-btn-primary" lay-filter="user-query" lay-submit>
                        <i class="layui-icon layui-icon-search"></i>
                        查询
                    </button>
                    <button class="pear-btn pear-btn-md" type="reset">
                        <i class="layui-icon layui-icon-refresh"></i>
                        重置
                    </button>
                </div>
            </div>

        </form>
    </div>
</div>

<div class="user-main user-collasped">
    <div class="layui-card">
        <div class="layui-card-body">
            <table id="user-table" class="layui-tab" lay-filter="user-table"></table>
        </div>
    </div>
</div>
</body>

<script id="user-bar" type="text/html">
    <button
            class="pear-btn pear-btn-primary pear-btn-sm" lay-event="edit"><i class="pear-icon pear-icon-edit"></i>
    </button>
    <button
            class="pear-btn pear-btn-danger pear-btn-sm" lay-event="remove"><i class="pear-icon pear-icon-ashbin"></i>
    </button>
</script>

<#--<script id="user-enable" type="text/html">-->
<#--    <input type="checkbox" name="enable" value="{{d.userId}}" lay-skin="switch" lay-text="启用|禁用"-->
<#--           lay-filter="user-enable" {{ d.enable== true ? 'checked' : '' }} />-->
<#--</script>-->
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
    layui.use(['table', 'dtree', 'form', 'jquery', 'popup', 'common','laydate'], function () {
        let table = layui.table;
        let form = layui.form;
        let $ = layui.jquery;
        let dtree = layui.dtree;
        let popup = layui.popup;
        let common = layui.common;
        var laydate=layui.laydate;

        //日期范围
        laydate.render({
            elem: '#test6'
            //设置开始日期、日期日期的 input 选择器
            //数组格式为 2.6.6 开始新增，之前版本直接配置 true 或任意分割字符即可
            ,range: ['#test-startDate-1', '#test-endDate-1'],
            type: 'datetime'
    });


        let MODULE_PATH = "/cash";

        let cols = [
            [
                {type: 'checkbox'},
                {title: '用户名', field: 'username', align: 'center', width: 110},
                {title: '手机号', field: 'mobile', align: 'center', width: 110},
                {title: '充值金额', field: 'num', align: 'center', width: 90},
                {title: '手续费', field: 'fee', align: 'center',  width: 50},
                {title: '成交量（到账金额）', field: 'mum', align: 'center', width: 90},
                {title: '交易类型', field: 'type', align: 'center', width: 110},
                {title: '充值订单号', field: 'tradeno', align: 'center', width: 180},
                {title: '第三方订单号', field: 'outtradeno', align: 'center', width: 110},
                {title: '充值备注', field: 'remark', align: 'center', width: 110},
                {title: '审核备注', field: 'audit_remark', align: 'center', width: 110},
                {title: '当前审核级数', field: 'step', align: 'center', width: 110},
                {title: '状态', field: 'status', align: 'center', width: 110},
                {title: '创建时间', field: 'created', align: 'center', width: 110},
                {title: '更新时间', field: 'last_update_time', align: 'center', width: 110},
                {title: '银行卡账户名', field: 'name', align: 'center', width: 110},
                {title: '开户行', field: 'bank_name', align: 'center', width: 110},
                {title: '银行卡号', field: 'bank_card', align: 'center', width: 110},
                {title: '最后确认到账时间。', field: 'last_time', align: 'center', width: 110}
            ]
        ]

       var tableIns= table.render({
            elem: '#user-table',
            url: "/withdrawals/withdrawals",
            page: true,
            cols: cols,
            skin: 'line',
            height: 'full-125',
            text: {none: '暂无人员信息'},
            defaultToolbar: [{
                layEvent: 'refresh',
                icon: 'layui-icon-refresh',
                title: "刷新"
            }, 'filter', 'print', 'exports']
        });


        $.post("/coin/coin",function (data) {
            for (var i = 0; i < data.length; i++) {
                    $("#coin_id").append('<option value="'+data[i].id+'">'+data[i].name+'</option>');
            }
            // 重新渲染下拉框内容
            layui.form.render("select");

        });
        //模糊查询
        form.on('submit(user-query)', function (data) {
            tableIns.reload({
                where: data.field,
                page: {
                    curr: 1
                }
            });
            return false;
        });


        // dtree.render({
        //     elem: "#dept-tree",
        //     method: "get",
        //     url: "/system/dept/tree",
        //     dataFormat: "list",
        //     line: true,
        //     skin: "laySimple",
        //     icon: "-1",
        //     response: {treeId: "deptId", parentId: "parentId", title: "deptName"},
        // });
        //
        // dtree.on("node('dept-tree')", function (obj) {
        //     let field = form.val("user-query-form");
        //     field.deptId = obj.param.nodeId;
        //     window.refresh(field);
        // });
        //
        // $(".user-group").click(function () {
        //     let group = $(this).attr("user-group");
        //     let field = form.val("user-query-form");
        //     if (group === "-1") {
        //         field.deptId = group;
        //         $(this).removeClass("button-default");
        //         $(this).prev().removeClass("button-primary");
        //         $(this).prev().addClass("button-default");
        //         $(this).addClass("button-primary");
        //     } else {
        //         field.deptId = group;
        //         $(this).removeClass("button-default");
        //         $(this).next().removeClass("button-primary");
        //         $(this).next().addClass("button-default");
        //         $(this).addClass("button-primary");
        //     }
        //     window.refresh(field);
        // })
        //
        // table.on('tool(user-table)', function (obj) {
        //     if (obj.event === 'remove') {
        //         window.remove(obj);
        //     } else if (obj.event === 'edit') {
        //         window.edit(obj);
        //     }
        // });
        //
        // table.on('toolbar(user-table)', function (obj) {
        //     if (obj.event === 'add') {
        //         window.add();
        //     } else if (obj.event === 'refresh') {
        //         window.refresh();
        //     } else if (obj.event === 'batchRemove') {
        //         window.batchRemove(obj);
        //     } else if (obj.event == 'collasped') {
        //         $(".user-left").toggleClass("user-collasped");
        //         $(".user-main").toggleClass("user-collasped");
        //         table.resize();
        //     }
        // });
        //
        // form.on('submit(user-query)', function (data) {
        //     window.refresh(data.field);
        //     return false;
        // });
        //
        // form.on('switch(user-enable)', function (obj) {
        //     let operate;
        //     if (obj.elem.checked) {
        //         operate = "enable";
        //     } else {
        //         operate = "disable";
        //     }
        //     let loading = layer.load();
        //     $.ajax({
        //         url: '/system/user/' + operate,
        //         data: JSON.stringify({userId: this.value}),
        //         dataType: 'json',
        //         contentType: 'application/json',
        //         type: 'put',
        //         success: function (result) {
        //             layer.close(loading);
        //             if (result.success) {
        //                 popup.success(result.msg);
        //             } else {
        //                 popup.failure(result.msg);
        //             }
        //         }
        //     })
        // });
        //
        // window.add = function () {
        //     layer.open({
        //         type: 2,
        //         title: '新增',
        //         shade: 0.1,
        //         area: ['550px', '550px'],
        //         content: MODULE_PATH + 'add'
        //     });
        // }
        //
        // window.edit = function (obj) {
        //     layer.open({
        //         type: 2,
        //         title: '修改',
        //         shade: 0.1,
        //         area: ['550px', '500px'],
        //         content: MODULE_PATH + 'edit?userId=' + obj.data['userId']
        //     });
        // }
        //
        // window.remove = function (obj) {
        //     layer.confirm('确定要删除该用户', {icon: 3, title: '提示'}, function (index) {
        //         layer.close(index);
        //         let loading = layer.load();
        //         $.ajax({
        //             url: MODULE_PATH + "remove/" + obj.data['userId'],
        //             dataType: 'json',
        //             type: 'delete',
        //             success: function (result) {
        //                 layer.close(loading);
        //                 if (result.success) {
        //                     popup.success(result.msg, function () {
        //                         obj.del();
        //                     });
        //                 } else {
        //                     popup.failure(result.msg);
        //                 }
        //             }
        //         })
        //     });
        // }
        //
        // window.batchRemove = function (obj) {
        //     let ids = common.checkField(obj, 'userId');
        //     if (common.isEmpty(ids)) {
        //         popup.warning("未选中数据");
        //         return false;
        //     }
        //     layer.confirm('确定要删除选中用户', {icon: 3, title: '提示'}, function (index) {
        //         layer.close(index);
        //         let loading = layer.load();
        //         $.ajax({
        //             url: MODULE_PATH + "batchRemove/" + ids,
        //             dataType: 'json',
        //             type: 'delete',
        //             success: function (result) {
        //                 layer.close(loading);
        //                 if (result.success) {
        //                     popup.success(result.msg, function () {
        //                         table.reload('user-table');
        //                     })
        //                 } else {
        //                     popup.failure(result.msg);
        //                 }
        //             }
        //         })
        //     });
        // }


    })
</script>
</html>