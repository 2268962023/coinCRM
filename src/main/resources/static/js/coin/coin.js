layui.use(['table','layer','laydate'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    var laydate = layui.laydate;
    laydate.render({
        elem: '#createdBegin'
    });
    laydate.render({
        elem: '#createdEnd'
    });


    //角色列表展示
    var  tableIns = table.render({
        elem: '#typeList',
        url : '/coin/find',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        toolbar: "#toolbarDemo",
        id : "coinTypeListTable",
        cols : [[
            {type: "checkbox", fixed:"center"},
            {field: 'name', title: '币种名称', minWidth:100, align:'center'},
            {field: 'img', title: '币种logo', align:'center',minWidth:150},
            {field: 'type', title: '币种系列', align:'center',templet:function(d){
                    return formatterState(d.type);
                }},
            {field: 'wallet', title: '货币类型', align:'center',templet:function(d){
                    return formatterDevResult(d.wallet);
                }},
            {field: 'minAmount', title: '最小提现数量', align:'center',minWidth:150},
            {field: 'maxAmount', title: '最大提现数据', align:'center',minWidth:150},
            {field: 'minFeeNum', title: '最低收取手续费', align:'center',minWidth:150},
            {field: 'created', title: '创建时间', align:'center',minWidth:150},
            {field: 'lastUpdateTime', title: '更新时间', align:'center',minWidth:150},
            {title: '操作', templet:'#coinListBar',fixed:"right",align:"center", minWidth:150}
        ]]
    });

    function formatterState(type){
        if(type=='xnb') {
            return "<div style='color: orangered'>人民币</div>";
        } else if(type=='ethToken') {
            return "<div style='color: green'>以太坊代币</div>";
        } else if (type=='eth'){
            return "<div style='color: green'>以太坊</div>";
        } else {
        return "<div style='color: blueviolet'>比特币系列</div>";
    }}

    function formatterDevResult(wallet) {
        if(wallet == 'rgb'){
            return "<div style='color: blueviolet'>认购币</div>"
        }else if (wallet == 'qbb') {
            return "<div style='color: blueviolet'>钱包币</div>"
        }
    }

    // 多条件搜索
    $(".search_btn").on("click",function(){
        tableIns.reload({
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
                name: $("input[name='name']").val(),
                createdBegin: $("input[name='createdBegin']").val(),
                createdEnd: $("input[name='createdEnd']").val(),
                wallet:$("#wallet").val()
            }
        })
    });

    table.on('toolbar(type)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        switch(obj.event){
            case 'add':
                openAddOrUpdateRolePage();
                break;
            case 'del':
                deleteCoinType(checkStatus.data);
                break;

        };
    });

    function openAddOrUpdateRolePage(id) {
        var title="<h2>货币类型--添加</h2>";
        var url="/coin/toAddOrUpdate";
        //判断添加或者修改
        if(id){
            title="<h2>货币类型--更新</h2>";
            url=url+"?id="+id;
        }
        //弹出层
        layer.open({
            title:title,
            type:2,
            content:url,
            area:["500px","420px"],
            maxmin:true
        })
    }

    function deleteCoinType(data) {
        if(data.length == 0){
            layer.msg("请选择删除的数据");
            return ;
        }

        layer.confirm("你确定要删除这些数据吗?",{

            btn:["确认","取消"],

        },function(index){
            //关闭询问框
            layer.close(index);
            //收集数据
            var ids=[];
            //遍历
            for(var x in data){
                ids.push(data[x].id);
            }
            //发送请求删除数据
            //发送ajax删除
            $.ajax({
                type:"post",
                url:"/coinTypes/dels",
                data:{"ids":ids.toString()},
                dataType:"json",
                success:function(result){
                    if(result.code==200){
                        layer.msg("删除OK",{icon : 6 });
                        //重新加载一下数据
                        tableIns.reload();
                    }else{
                        //提示
                        layer.msg(result.msg,{icon : 5});
                    }
                }
            });
        });
    }

    /*绑定行内工具栏*/
    table.on('tool(type)', function(obj){

        var data = obj.data;

        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr;

        if(layEvent === 'del'){ //删除
            layer.confirm("你确定要删除这些数据吗?",{
                btn:["确认","取消"],
            },function(index){
                //关闭询问框
                layer.close(index);
                //发送ajax删除
                $.ajax({
                    type:"post",
                    url:"/coinTypes/dels",
                    data:{"ids":data.id},
                    dataType:"json",
                    success:function(result){
                        if(result.code==200){
                            layer.msg("删除OK",{icon : 6 });
                            //重新加载一下数据
                            tableIns.reload();
                        }else{
                            //提示
                            layer.msg(result.msg,{icon : 5});
                        }
                    }
                });
            });
        } else if(layEvent === 'edit'){ //编辑
            openAddOrUpdateRolePage(data.id);
        }
    });


});