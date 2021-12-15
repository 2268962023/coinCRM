layui.use(['form', 'layer'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;



    form.on("submit(addOrUpdateCoin)",function(obj){
        var index=layer.msg("数据正在加载中...",{icon: 16,time :false ,shade: 0.8});

        var url="/coin/save";

        if($("input[name=id]").val()){
            url="/coin/update"
        }

        $.ajax({
            type:"post",
            url:url,
            data:obj.field,
            dataType:"json",
            success:function (result){
                if(result.code==200){
                    //提示一下
                    layer.msg("添加OK",{icon: 6 });
                    //关闭加载层
                    layer.close(index);
                    //关闭iframe
                    layer.closeAll("iframe");
                    //刷新页面
                    window.parent.location.reload();
                }else{
                    layer.msg(result.msg,{icon : 5 });
                }
            }
        });
        //取消跳转
        return false;
    });


    $("#closeBtn").click(function(){
        //假设这是iframe页
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index); //再执行关闭
    });

});