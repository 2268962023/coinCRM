<!DOCTYPE html>
<html>
<head>
    <title>实名认证</title>
    <#include "../include.ftl">
</head>
<body class="pear-container">
<div class="layui-card">
    <div class="layui-card-body">
        <form class="layui-form">
            <div class="layui-form-item">
                      <label class="layui-form-label">用户名</label>
                        <div class="layui-input-inline">
                            <input type="text" name="username" class="layui-input searchVal"  />
                        </div>
            <label class="layui-form-label">姓名</label>
                        <div class="layui-input-inline">

                            <input type="text" name="realName" class="layui-input searchVal"  />
                        </div>
            <label class="layui-form-label">手机号</label>
                        <div class="layui-input-inline">

                            <input type="text" name="mobile" class="layui-input searchVal"  />
                        </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">审核状态</label>
                <div class="layui-input-inline">
                    <select name="status"  id="status">
                        <option value="">选择状态</option>
                        <option value="0">待审核</option>
                        <option value="1">通过</option>
                        <option value="2" >拒绝</option>
                    </select>
                </div>
                <div class="layui-input-inline">
                    <a class="layui-btn search_btn" data-type="reload">
                        <i class="layui-icon">&#xe615;</i>
                        查询
                    </a>
                    <button class="pear-btn" type="reset">
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
        <table id="userAuthAuditRecordList" class="layui-tab"   lay-filter="userAuthAuditRecords"></table>
    </div>
</div>
</div>

<script type="text/javascript" src="/js/userAuthAuditRecord/user_auth_audit_record.js"></script>
</body>
</html>