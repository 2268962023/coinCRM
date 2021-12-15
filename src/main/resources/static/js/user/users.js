layui.use(['table','layer'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    //角色列表展示
    var  tableIns = table.render({
        elem: '#userList',
        url : '/user/list',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 10,
        toolbar: "#toolbarDemo",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            // {field: "id", title:'编号',fixed:"true", width:80},
            {field: 'username', title: '账号', minWidth:50, align:"center"},
            {field: 'password', title: '密码', minWidth:100, align:'center'},
            {field: 'fullname', title: '姓名', align:'center',minWidth:150},
            {field: 'mobile', title: '手机号', align:'center',minWidth:150},
            {field: 'email', title: '邮箱', align:'center',minWidth:150},
            {field: 'status', title: '状态', align:'center',minWidth:150,templet:function(d)
                {
                    return formatterState(d.status);
                }},
            // {field: 'createBy', title: '创建人', align:'center',minWidth:150},
            // {field: 'modifyBy', title: '修改人', align:'center',minWidth:150},
            {field: 'created', title: '创建时间', align:'center',minWidth:150},
            {field: 'lastUpdateTime', title: '修改时间', align:'center',minWidth:150},
            {title: '操作', minWidth:150, templet:'#userListBar',fixed:"right",align:"center"}
        ]]
    });

    function formatterState(status){
        if(status==0) {
            return "<div style='color: yellow'>无效</div>";
        } else if(status==1) {
            return "<div style='color: green'>有效</div>";
        } else {
            return "<div style='color: red'>未知</div>";
        }
    }

    /**
     * 绑定搜索按钮的点击事件
     */
    $(".search_btn").click(function () {
        table.reload('userListTable', {
            where: { //设定异步数据接口的额外参数，任意设
                username: $("input[name='username']").val(), // 账号
                email: $("input[name='email']").val(), //邮箱
                mobile: $("input[name='mobile']").val() //手机号
            }
            ,page: {
                curr: 1 // 重新从第 1 页开始
            }
        }); // 只重载数据
    });


    /*头部工具栏*/
    //头工具栏事件
    table.on("toolbar(users)", function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);

        switch (obj.event) {
            case "add":
                openAddOrUpdateUserDialog();
                break;
            case "del":
                deleteUser(checkStatus.data);
                break;
        }
    });




    /**
     * 添加和修改
     * @param id
     */
    function openAddOrUpdateUserDialog(id) {
        var url = "/user/addOrUpdateUserPage";
        var title = "账户管理-账户添加";
        if(id){
            url = url + "?id="+id;
            title = "账户管理-账户更新";
        }
        layui.layer.open({
            title : title,
            type : 2,
            area:["650px","400px"],
            maxmin:true,
            content : url
        });
    }

    function deleteUser(data){

        if(data.length==0){
            layer.msg("请选择要删除的数据");
            return ;
        }
        layer.confirm("主人，你确定狠心删除数据吗?",{
            btn:["确认","取消"]
        },function(index){
            //关闭
            layer.close(index);
            //收集数据
            var ids="&ids=";
            for (var i = 0; i < data.length ; i++) {
                if(i< data.length -1){
                    ids=ids+data[i].id+"&ids=";
                }else{
                    ids=ids+data[i].id;
                }
            }
            //发送ajax删除数据
            $.post("/user/delete",ids,function(result){
                if(result.code==200){
                    //重新加载数据
                    tableIns.reload();
                }else{
                    //提示一下
                    layer.msg(result.msg,{icon:5 });
                }
            },"json");
        });
    }


    /*行内工具栏*/
    //监听行工具事件
    table.on("tool(users)", function(obj){
        var layEvent = obj.event;
        // 监听编辑事件
        if(layEvent === "edit") {
            openAddOrUpdateUserDialog(obj.data.id);
        }else if(layEvent === "del") {
            // 监听删除事件
            layer.confirm('确定删除当前用户？', {icon: 3, title: "用户管理"}, function (index) {
                $.post("/user/delete",{ids:obj.data.id},function (data) {
                    if(data.code==200){
                        layer.msg("操作成功！");
                        tableIns.reload();
                    }else{
                        layer.msg(data.msg, {icon: 5});
                    }
                });
            });
        }
    });



});