<!DOCTYPE html>
<html>
<head>
    <#include "include.ftl"/>
   <link rel="stylesheet"  href="/admin/css/other/login.css"/>
</head>
<!-- 代 码 结 构 -->
<body background="/admin/images/login.svg">
<form action="javascript:void(0);" class="layui-form">
    <div class="layui-form-item">
        <img class="logo" src="/admin/images/logo.png"/>
        <div class="title">Math Admin</div>
    </div>
    <div class="layui-form-item">
        <input class="layui-input" hover name="username" placeholder="账 户 : admin " type="text" value="admin"/>
    </div>
    <div class="layui-form-item">
        <input class="layui-input" hover name="password" placeholder="密 码 : admin " type="password" value="123456"/>
    </div>
<#--    <div class="layui-form-item">-->
<#--        <input class="code layui-input layui-input-inline" hover name="captcha" placeholder="验证码 : "/>-->
<#--        <img class="codeImage" id="captchaImage" src="/system/captcha/generate"/>-->
<#--    </div>-->
    <div class="layui-form-item">
        <input lay-skin="primary" name="remember-me" title="记住密码" type="checkbox">
    </div>
    <div class="layui-form-item">
        <button class="pear-btn pear-btn-success login" lay-filter="login" lay-submit>
            登 入
        </button>
    </div>
</form>
<script src="/component/pear/module/jquery.cookie.js"></script>
<script>
    layui.use(['form', 'jquery', 'layer', 'button', 'popup','jquery_cookie'], function () {
        var form = layui.form,
            $ = layui.jquery,
            $ = layui.jquery_cookie($),
         layer = layui.layer,
         button = layui.button,
         popup = layui.popup,
         captchaPath = "system/captcha/generate";
        form.on('submit(login)', function (data) {
            let loader = layer.load();
            let btn = button.load({elem: '.login'});
            // 获取表单元素的值 （用户名 + 密码）
            var fieldData = data.field;
            //判断参数是否为空
            if (fieldData.username==undefined||fieldData.username.trim()==""){
                layer.msg("用户名称不能为空！");
                return false;
            }
            if (fieldData.password==undefined||fieldData.password.trim()==""){
                layer.msg("密码不能为空");
                return false;
            }

            $.ajax({
                url: '/user/toLogin',
                data: data.field,
                type: "post",
                dataType: 'json',
                success: function (result) {
                    layer.close(loader);
                     btn.stop(function () {
                        if (result.code==200) {
                            popup.success(result.msg, function () {

                                if($("input[type='checkbox']").is(":checked")){
                                    $.cookie("userId",result.userId,{expires:7});
                                }
                                location.href = "/user/index";
                            })
                        } else {
                            popup.failure(result.msg, function () {
                                document.getElementById("captchaImage").src = captchaPath + "?" + Math.random();
                            });
                        }
                    })
               }
            });
            return false;
        });
    });
</script>

</body>
</html>