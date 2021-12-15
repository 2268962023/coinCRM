<!DOCTYPE html>
<html>
<head>
    <link href="/admin/css/other/center.css" rel="stylesheet"/>
    <style>
        .layui-form-item {
            margin-top: 17px !important;
            margin-bottom: 17px !important;
        }
    </style>
</head>
<body class="pear-container">
<div class="layui-row layui-col-space10">

        <div class="layui-col-md3">
            <div class="layui-card">
                <div class="layui-card-body" style="padding: 25px;">
                    <div class="text-center layui-text">
                        <div class="user-info-head" id="userInfoHead">
                            <img src="/admin/images/2.jpg" height="115px" id="avatar" width="115px">
                        </div>
                        <h2 style="padding-top: 20px;font-size: 20px;" ></h2>
                        <p style="padding-top: 8px;margin-top: 10px;font-size: 13.5px;">China ， 中国</p>
                    </div>
                </div>
                <div style="height: 45px;border-top: 1px whitesmoke solid;text-align: center;line-height: 45px;font-size: 13.5px;">
                    <span >今日事 ，今日毕</span>
                </div>
            </div>
        </div>
    <div class="layui-col-md9">
        <div class="layui-card">
            <div class="layui-card-header">个人信息</div>
            <div class="layui-card-body">
                <div class="layui-tab layui-tab-brief">
                    <div class="layui-tab-content">
                        <div class="layui-tab-item layui-show">
                            <form class="layui-form">
                                <div class="layui-form-item layui-hide">
                                    <label class="layui-form-label">编号</label>
                                    <div class="layui-input-block">
                                        <input autocomplete="off" class="layui-input" lay-verify="title"
                                               name="id" value="${sys_user.id}!''" placeholder="请输入标题"  type="text">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">账号</label>
                                    <div class="layui-input-block">
                                        <input autocomplete="off" class="layui-input" lay-verify="title" name="username"
                                               placeholder="请输入标题"
                                               readonly  type="text" value="${sys_user.username!''}">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">姓名</label>
                                    <div class="layui-input-block">
                                        <input autocomplete="off" class="layui-input" lay-verify="title"
                                               name="fullname" value="${sys_user.fullname}!''"
                                               placeholder="请输入标题"  type="text">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">邮箱</label>
                                    <div class="layui-input-block">
                                        <input autocomplete="off" class="layui-input" lay-verify="title" name="email"
                                               placeholder="请输入标题"  type="text" value="${sys_user.email}!''">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">电话</label>
                                    <div class="layui-input-block">
                                        <input autocomplete="off" class="layui-input" lay-verify="title" name="mobile"
                                           value="${sys_user.mobile}!''"    placeholder="请输入标题"  type="text">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <div class="layui-input-block">
                                        <button class="pear-btn pear-btn-primary pear-btn-sm" lay-filter="user-update"
                                                lay-submit>修改资料
                                        </button>
                                        <button class="pear-btn pear-btn-sm edit-password">更改密码</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</div>
    <div class="layui-col-md12">
        <div class="layui-card">
            <div class="layui-card-header">
                我的文章
            </div>
            <div class="layui-card-body">
                <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
                    <div class="layui-tab-content">
                        <div class="layui-tab-item layui-show">
                            <div class="layui-row layui-col-space10" style="margin: 15px;">
                                <div class="layui-col-md1">
                                    <img src="/admin/images/act.jpg"
                                         style="width: 100%;height: 100%;border-radius: 5px;"/>
                                </div>
                                <div class="layui-col-md11" style="height: 80px;">
                                    <div class="title">为什么程序员们愿意在GitHub上开源自己的成果给别人免费使用和学习？</div>
                                    <div class="content">
                                        “Git的精髓在于让所有人的贡献无缝合并。而GitHub的天才之处，在于理解了Git的精髓。”来一句我们程序员们接地气的话：分享是一种快乐~
                                    </div>
                                    <div class="comment">2020-06-12 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 评论 5 点赞 12 转发
                                        4
                                    </div>
                                </div>
                            </div>
                            <div class="layui-row layui-col-space10" style="margin: 15px;">
                                <div class="layui-col-md1">
                                    <img src="/admin/images/act.jpg"
                                         style="width: 100%;height: 100%;border-radius: 5px;"/>
                                </div>
                                <div class="layui-col-md11" style="height: 80px;">
                                    <div class="title">为什么程序员们愿意在GitHub上开源自己的成果给别人免费使用和学习？</div>
                                    <div class="content">
                                        “Git的精髓在于让所有人的贡献无缝合并。而GitHub的天才之处，在于理解了Git的精髓。”来一句我们程序员们接地气的话：分享是一种快乐~
                                    </div>
                                    <div class="comment">2020-06-12 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 评论 5 点赞 12 转发
                                        4
                                    </div>
                                </div>
                            </div>
                            <div class="layui-row layui-col-space10" style="margin: 15px;">
                                <div class="layui-col-md1">
                                    <img src="/admin/images/2.jpg"
                                         style="width: 100%;height: 100%;border-radius: 5px;"/>
                                </div>
                                <div class="layui-col-md11" style="height: 80px;">
                                    <div class="title">为什么程序员们愿意在GitHub上开源自己的成果给别人免费使用和学习？</div>
                                    <div class="content">
                                        “Git的精髓在于让所有人的贡献无缝合并。而GitHub的天才之处，在于理解了Git的精髓。”来一句我们程序员们接地气的话：分享是一种快乐~
                                    </div>
                                    <div class="comment">2020-06-12 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 评论 5 点赞 12 转发
                                        4
                                    </div>
                                </div>
                            </div>
                            <div class="layui-row layui-col-space10" style="margin: 15px;">
                                <div class="layui-col-md1">
                                    <img src="/admin/images/2.jpg" style="width: 100%;height: 100%;border-radius: 5px;"/>
                                </div>
                                <div class="layui-col-md11" style="height: 80px;">
                                    <div class="title">为什么程序员们愿意在GitHub上开源自己的成果给别人免费使用和学习？</div>
                                    <div class="content">
                                        “Git的精髓在于让所有人的贡献无缝合并。而GitHub的天才之处，在于理解了Git的精髓。”来一句我们程序员们接地气的话：分享是一种快乐~
                                    </div>
                                    <div class="comment">2020-06-12 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 评论 5 点赞 12 转发
                                        4
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
<#include "../../include.ftl"/>
<script>
    layui.use(['element', 'jquery', 'layer', 'form', 'convert'], function () {
        let $ = layui.jquery;
        let layer = layui.layer;
        let form = layui.form;
        let convert = layui.convert;

        $(".edit-password").click(function () {
            layer.open({
                type: 2,
                title: '修改密码',
                shade: 0.1,
                area: ['550px', '280px'],
                content: '/user/editPassword'
            });
            return false;
        })

        <#--let image = new Image();-->
        <#--image.src = "${ctx}/system/file/download/" + [[${userInfo.avatar}]];-->
        <#--image.onload = function () {-->
        <#--    $("#avatar").attr("src", convert.imageToBase64(image));-->
        <#--}-->

        <#--$("#avatar").click(function () {-->
        <#--    layer.open({-->
        <#--        type: 2,-->
        <#--        title: '更换图片',-->
        <#--        shade: 0.1,-->
        <#--        area: ["900px", "500px"],-->
        <#--        content: '/system/user/profile/' + [[${userInfo.userId}]],-->
        <#--        btn: ['确定', '取消'],-->
        <#--        yes: function (index, layero) {-->
        <#--            window['layui-layer-iframe' + index].submitForm();-->
        <#--        }-->
        <#--    });-->
        <#--});-->

        form.on('submit(user-update)', function (data) {
            $.ajax({
                url: '/system/user/updateInfo',
                data: JSON.stringify(data.field),
                dataType: 'json',
                contentType: 'application/json',
                type: 'put',
                success: function (result) {
                    if (result.success) {
                        layer.msg("修改成功", {icon: 1, time: 1000});
                    } else {
                        layer.msg("修改失败", {icon: 2, time: 1000});
                    }
                }
            })
            return false;
        });
    })
</script>
</body>
</html>
