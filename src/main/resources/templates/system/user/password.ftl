<!DOCTYPE html>
<html lang="en">
<head>
<#include "../../include.ftl"/>
</head>
<body>
<form action="" class="layui-form">
    <div class="mainBox">
        <div class="main-container">
            <div class="main-container">
                <div class="layui-form-item">
                    <label class="layui-form-label">旧密码</label>
                    <div class="layui-input-block">
                        <input autocomplete="off" class="layui-input"  name="oldPassword" placeholder="请输入标题" type="password">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">新密码</label>
                    <div class="layui-input-block">
                        <input autocomplete="off" class="layui-input" name="newPassword" placeholder="请输入标题" type="password">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">确认密码</label>
                    <div class="layui-input-block">
                        <input autocomplete="off" class="layui-input"  name="confirmPassword" placeholder="请输入标题" type="password">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="bottom">
        <div class="button-container">
            <button class="pear-btn pear-btn-primary pear-btn-sm" lay-filter="edit-password" lay-submit=""
                    type="submit">
                <i class="layui-icon layui-icon-ok"></i>
                提交
            </button>
            <button class="pear-btn pear-btn-sm" type="reset">
                <i class="layui-icon layui-icon-refresh"></i>
                重置
            </button>
        </div>
    </div>
</form>
<script>
    layui.use(['form', 'jquery', 'popup'], function () {
        let form = layui.form;
        let $ = layui.jquery;
        let popup = layui.popup;

        form.on('submit(edit-password)', function (data) {
            alert(JSON.stringify(data.field,))
            $.ajax({
                url: '/user/updatePwd',
                data:data.field,
                contentType: 'application/json',
                dataType: 'json',
                type: 'post',
                success: function (result) {
                    if (result.success) {
                        popup.success(result.msg, function () {
                            parent.layer.close(parent.layer.getFrameIndex(window.name));
                        });
                    } else {
                        popup.failure(result.msg);
                    }
                }
            })
            return false;
        });

    })
</script>
</body>
</html>