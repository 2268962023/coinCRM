<!DOCTYPE html>
<html>
<head>
    <title></title>
    <#include "../include.ftl">
</head>
    <body class="childrenBody">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body">
                    <form class="layui-form" >

                        <div class="layui-form-item layui-row">
                            <div class="layui-col-xs6">
                                <label class="layui-form-label">客户ID</label>
                                <div class="layui-input-block">
                                    <input type="text" class="layui-input"
                                           name="id" id="id"
                                           value="${(user.id)!"0"}" readonly="readonly">
                                </div>
                            </div>
                            <div class="layui-col-xs6">
                                <label class="layui-form-label">用户名</label>
                                <div class="layui-input-block">
                                    <input type="text" class="layui-input"
                                           name="username" id="username"
                                           value="${(user.username)!"admin"}" readonly="readonly">
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item layui-row">
                            <div class="layui-col-xs6">
                                <label class="layui-form-label">手机号码</label>
                                <div class="layui-input-block">
                                    <input type="text" class="layui-input"
                                           name="mobile" id="mobile"
                                           value="${(user.mobile)!"未记录"}" readonly="readonly">
                                </div>
                            </div>
                            <div class="layui-col-xs6">
                                <label class="layui-form-label">真实姓名</label>
                                <div class="layui-input-block">
                                    <input type="text" class="layui-input"
                                            name="realName" id="realName"
                                           value="${(user.realName)!"未实名"}"  readonly="readonly">
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item layui-row">
                            <div class="layui-col-xs6">
                                <label class="layui-form-label">证件类型</label>
                                <div class="layui-input-block">
                                    <input type="text" class="layui-input"
                                           name="idCardType" id="idCardType"
                                           value="${(user.idCardType)?string("身份证","其它")!"无"}"  readonly="readonly">
                                </div>
                            </div>
                            <div class="layui-col-xs6">
                                <label class="layui-form-label">证件号码</label>
                                <div class="layui-input-block">
                                    <input type="text" class="layui-input"
                                           name="idCard" id="idCard" value="${(user.idCard)!"未实名"}"
                                           readonly="readonly">
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item layui-row">
                            <div class="layui-col-xs6">
                                <label class="layui-form-label">邮箱</label>
                                <div class="layui-input-block">
                                    <input type="text" class="layui-input"
                                           name="email" id="email"
                                           value="${(user.email)!"未绑定"}"  readonly="readonly">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
