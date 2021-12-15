layui.use(['table','layer'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    //角色列表展示
    var  tableIns = table.render({
        elem: '#accountList',
        url : '/account/find',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        toolbar: "#default",
        id : "accountListTable",
        cols : [[
            // {field: "id", title:'财产id',fixed:"true", width:80},
            {field: 'userId', title: '用户id', minWidth:50, align:"center"},
            {field: 'coinId', title: '币种id', minWidth:100, align:'center'},
            {field: 'status', title: '帐号状态', minWidth:100, align:'center'},
            {field: 'balanceAmount', title: '可用余额', minWidth:100, align:'center'},
            {field: 'freezeAmount', title: '冻结余额', minWidth:100, align:'center'},
            {field: 'rechargeAmount', title: '累计充值', minWidth:100, align:'center'},
            {field: 'withdrawalsAmount', title: '累计提现', minWidth:100, align:'center'},
            {field: 'created', title: '创建时间', align:'center',minWidth:150},
            {field: 'lastUpdateTime', title: '更新时间', align:'center',minWidth:150},
        ]]
    });

    // 多条件搜索
    $(".search_btn").on("click",function(){
        tableIns.reload({
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
                accountName: $("input[name='accountName']").val()
            }
        })
    });

});
