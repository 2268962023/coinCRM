layui.use(['table','layer'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;
    /**
     * 用户列表展示
     */
    var  tableIns = table.render({
        elem: '#userList',
        url : '/users/list',
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        cols : [[
            {field: "id", title:'用户ID', width:180},
            {field: 'username', title: '用户名', minWidth:50, align:"center"},
            {field: 'mobile', title: '手机号', minWidth:100, align:'center'},
            {field: 'realName', title: '姓名', align:'center'},
            {field: 'authStatus', title: '实名认证状态', align:'cenSter',templet:function(d){
                    return formatterAuthStatus(d.authStatus);
                }},
            {field: 'paypassSetting', title: '交易密码设置状态', align:'center',templet:function(d){
                    return formatterPaypassSetting(d.paypassSetting);
                }},
            {field: 'inviteCode', title: '邀请码', align:'center'},
            {field: 'status', title: '状态', align:'center',templet:function(d){
                    return formatterStatus(d.status);
                }},
            {field: 'created', title: '注册时间', align:'center'},
            {title: '操作', templet:'#userListBar',fixed:"right",align:"center", minWidth:150}
        ]]
    });

    function formatterAuthStatus(authStatus){
        if(authStatus==0) {
            return "<div style='color: red'>未认证</div>";
        } else if(authStatus==1) {
            return "<div style='color: green'>初级实名认证</div>";
        } else if(authStatus==2){
            return "<div style='color: dodgerblue'>高级实名认证</div>";
        }
    }
    function formatterPaypassSetting(value){
        if(value==0) {
            return "<div style='color: red'>未设置</div>";
        } else if(value==1) {
            return "<div style='color: green'>已设置</div>";
        }
    }
    function formatterStatus(value){
        if(value==0) {
            return "<div style='color: red'>禁用</div>";
        } else if(value==1) {
            return "<div style='color: green'>启用</div>";
        }
    }


    /*实现搜索功能，页面重载*/
    $(".search_btn").click(function(){
        //这里以搜索为例
        tableIns.reload({
            where: { //设定异步数据接口的额外参数，任意设
                userName: $("input[name=username]").val(),
                mobile:$("input[name=mobile]").val(),
                realName:$("input[name=realName]").val(),
                status: $("#status").val()
            }
            ,page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });

    table.on("tool(users)",function (obj) {
        alert(JSON.stringify(obj.data.id))
        openUserDialog(obj.data.id);
    });

    function openUserDialog(id) {
        layui.layer.open({
            title:"信息查询",
            type:2,
            area:["500px","500px"],
            content:"/users/toUserDataPage/"+id
        })
    }

});