/**
 * Created by huzhihui on 2016/4/17.
 */
$(function(){
    init_search_page_function(1);
});

$(document).on('click','.btn-addOne',function () {
    $('#addInformationPushBtn').show();
})
$('#addInformationPushBtn').on('click', function () {
    var informationPushTitle = $('#informationPushTitle').val();
    var informationPushState = $('#informationPushState option:selected').val();
    var informationPushUrl = $('#informationPushUrl').val();
    var informationPushPeople = $('#informationPushPeople').val();
    var informationPushContent = $('#informationPushContent').val();
    var informationPush = {
        informationPushTitle: informationPushTitle,
        informationPushState: informationPushState,
        informationPushUrl: informationPushUrl,
        informationPushPeople: informationPushPeople,
        informationPushContent: informationPushContent
    };
    if(informationPushTitle == '' || informationPushContent == ''){
        layer.msg("请检查添加数据是否完整",{icon:2});
        return;
    }
    var dataInBean = {
        informationPush:informationPush
    };
    $.ajax({
        url:server_url.informationPush.doInsert,
        type:'POST',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            if(data.state == true){
                layer.msg('添加成功!',{time: 1000, icon:1});
                $('#addInformationPush').modal('hide');
                init_search_page_function(1);
            }
        }
    });
});


function init_search_page_function(currentPage){
    var informationPush = {

    };
    var dataInBean = {
        informationPush:informationPush,
        searchName:$('#searchName').val(),
        startTime:$('#startTime').val(),
        endTime:$('#endTime').val(),
        currentPage:currentPage,
        lineSize:6
    };
    $.ajax({
        url:server_url.informationPush.selectByAttributeAnd,
        type:'GET',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            var appendHtml = template('informationPush-template',data);
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

$(document).on('click','.informationPushManager-btn-delete',function(){
    var informationPushCuid = $(this).attr('informationPushCuid');
    layer.confirm('是否确定删除', {
        btn: ['确定','取消'] //按钮
    }, function(index){
        layer.close(index);
        doDelete(informationPushCuid)
    }, function(){
        layer.msg('操作取消成功', {icon: 1});
    });

});

function doDelete(informationPushCuid) {
    var informationPush = {
        informationPushCuid:informationPushCuid
    };
    var dataInBean = {
        informationPush:informationPush
    };
    $.ajax({
        url:server_url.informationPush.doDelete,
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
};

$(document).on('click','.informationPushManager-btn-details',function(){
    $('#addInformationPushBtn').hide();
    $('#addInformationPush').modal('show');
    var informationPushCuid = $(this).attr('informationPushCuid');
    selectByPrimaryKey(informationPushCuid);
});


function selectByPrimaryKey(informationPushCuid) {
    var informationPush = {
        informationPushCuid:informationPushCuid
    };
    var dataInBean = {
        informationPush:informationPush
    };
    $.ajax({
        url:server_url.informationPush.selectByPrimaryKey,
        type:'GET',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            if(data.state == true){
                $('#informationPushTitle').val(data.msg.informationPushTitle);
                $('#informationPushState').val(data.msg.informationPushState);
                $('#informationPushUrl').val(data.msg.informationPushUrl);
                $('#informationPushPeople').val(data.msg.informationPushPeople);
                $('#informationPushContent').val(data.msg.informationPushContent);
            }else{
                //layer.msg(data.msg,{icon:2});
            }
        }
    });
}