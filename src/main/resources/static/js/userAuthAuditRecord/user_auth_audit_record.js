layui.use(['table','layer'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;
    /**
     * 用户列表展示
     */
    var  tableIns = table.render({
        elem: '#userAuthAuditRecordList',
        url : '/user_auth_audit_record/list',
        page : true,
        height : "full-125",
        limits : [10,25,50,100,1000],
        limit : 10,
        skin: 'line',
        id : "userAuthAuditRecordListTable",
        cols : [[
            {field: "userId", title:'用户ID', width:180},
            {field: 'username', title: '用户名', minWidth:50, align:"center"},
            {field: 'mobile', title: '手机号', minWidth:100, align:'center'},
            {field: 'email', title: '邮箱', minWidth:100, align:'center'},
            {field: 'realName', title: '姓名', align:'center'},
            {field: 'idCard', title: '身份证号', align:'center'},
            {field: 'created', title: '时间', align:'center'},
            {field: 'authStatus', title: '实名认证状态', align:'cenSter',templet:function(d){
                    return formatterAuthStatus(d.authStatus);
                }},
            {field: 'status', title: '审核状态', align:'center',templet:function(d){
                    return formatterStatus(d.status);
                }}
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
    function formatterStatus(value){
        if(value==0) {
            return "<div style='color: yellow'>待审核</div>";
        } else if(value==1) {
            return "<div style='color: green'>通过</div>";
        }else if(value==2) {
            return "<div style='color: red'>拒绝</div>";
        }
    }


    /*实现搜索功能，页面重载*/
    $(".search_btn").click(function(){
        //这里以搜索为例
        tableIns.reload({
            where: { //设定异步数据接口的额外参数，任意设
                userId:$("input[name=userId]").val(),
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


});