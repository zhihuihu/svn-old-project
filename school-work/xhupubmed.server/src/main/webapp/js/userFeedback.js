/**
 * Created by huzhihui on 2016/5/8.
 */
$('#jqueryPage').createPage({
    pageCount : 1,
    current : 1,
    backFn : function(p){
    }
});

$(function () {
    init_search_page_function(1);
});

function init_search_page_function(currentPage){
    var keyLog = {
        keyLogState:10//只有10为用户的信息反馈
    };
    var dataInBean = {
        keyLog:keyLog,
        searchName:$('#searchName').val(),
        startTime:$('#startTime').val(),
        endTime:$('#endTime').val(),
        currentPage:currentPage,
        lineSize:6
    };
    $.ajax({
        url:server_url.keyLog.selectByAttributeAnd,
        type:'GET',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            var appendHtml = template('userFeedback-template',data);
            $('#jqueryPage').createPage({
                pageCount : data.pageCount,
                current : currentPage,
                backFn : function(p){
                    init_search_page_function(p)
                }
            });
            $('#appendBody').html(appendHtml);
        }
    });
};

$(document).on('click','#searchBtn',function(){
    init_search_page_function(1);
});

$(document).on('click','.btn-delete',function(){
    var keyLogCuid = $(this).attr('keyLogCuid');
    layer.confirm('是否确定删除', {
        btn: ['确定','取消'] //按钮
    }, function(index){
        layer.close(index);
        doDelete(keyLogCuid)
    }, function(){
        layer.msg('操作取消成功', {icon: 1});
    });

});

function doDelete(keyLogCuid) {
    var keyLog = {
        keyLogCuid:keyLogCuid
    };
    var dataInBean = {
        keyLog:keyLog
    };
    $.ajax({
        url:server_url.keyLog.doDelete,
        type:'GET',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            layer.msg('删除成功',{icon:1});
            init_search_page_function(1);
        }
    });
}

$(document).on('click','.btn-details',function(){
    var keyLogCuid = $(this).attr('keyLogCuid');
    $('#showKeyLogDetails').modal('show');
    selectByPrimaryKey(keyLogCuid);

});

function selectByPrimaryKey(keyLogCuid) {
    var keyLog = {
        keyLogCuid:keyLogCuid
    };
    var dataInBean = {
        keyLog:keyLog
    };
    $.ajax({
        url:server_url.keyLog.selectByPrimaryKey,
        type:'GET',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            if(data.state == true){
                $('#keyLogName').val(data.msg.keyLogName);
                $('#keyLogContent').val(data.msg.keyLogContent);
                $('#keyLogPeople').val(data.msg.keyLogPeople);
            }else{
                //layer.msg(data.msg,{icon:2});
            }
        }
    });
}