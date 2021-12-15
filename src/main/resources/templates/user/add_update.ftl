<!DOCTYPE html>
<html>
<head>
    <#include "../include.ftl">
</head>
<body class="childrenBody">
<form class="layui-form" style="width:80%;">
    <input name="id" type="hidden" value="${(sysUser.id)!}"/>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">账号</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input username"
                   lay-verify="required" name="username" id="userName"
                   value="${(sysUser.username)!}" placeholder="请输入账号">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input fullname"
                   lay-verify="required" name="fullname" id="fullname"
                   value="${(sysUser.fullname)!}" placeholder="请输入姓名">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input userEmail"
                   lay-verify="email" name="email"
                   value="${(sysUser.email)!}"
                   id="email"
                   placeholder="请输入邮箱">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">手机号</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input userMobile"
                   lay-verify="mobile" name="mobile"
                   value="${(sysUser.mobile)!}" id="phone" placeholder="请输入手机号">
        </div>
    </div>
    <div class="magb15 layui-col-md4 layui-col-xs12">
        <label class="layui-form-label">角色</label>
        <div class="layui-input-block">
            <select name="roleIds" xm-select="selectId">
            </select>
        </div>
    </div>
    <br/>
    <br/>
    <div class="layui-form-item layui-row layui-col-xs12">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-lg" lay-submit="" lay-filter="addOrUpdateUser">确认
            </button>
            <button class="layui-btn layui-btn-lg layui-btn-normal" id="closeBtn">取消
            </button>
        </div>
    </div>
</form>
<script type="text/javascript" src="/js/user/add_update.js"></script>
</body>
</html>