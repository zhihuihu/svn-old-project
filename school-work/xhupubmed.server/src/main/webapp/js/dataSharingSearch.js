/**
 * Created by huzhihui on 2016/5/10.
 */
$('#jqueryPage').createPage({
    pageCount : 1,
    current : 1,
    backFn : function(p){
    }
});

$(function () {
    init(1);
});

function init(currentPage){
    var dataSharing = {
    };
    var dataInBean = {
        dataSharing:dataSharing,
        startTime:$('#startTime').val(),
        endTime:$('#endTime').val(),
        searchName:$('#searchName').val(),
        currentPage:currentPage,
        lineSize:6
    };
    $.ajax({
        url:server_url.dataSharing.selectByAttributeAnd,
        type:'GET',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            var appendHtml = template('dataSharing-template',data);
            $('#jqueryPage').createPage({
                pageCount : data.pageCount,
                current : currentPage,
                backFn : function(p){
                    init(p)
                }
            });
            $('#appendBody').html(appendHtml);
        }
    });
};

$(document).on('click','#searchBtn',function(){
    init(1);
});

$(document).on('click','.btn-delete',function(){
    var dataSharingCuid = $(this).attr('dataSharingCuid');
    layer.confirm('是否确定删除', {
        btn: ['确定','取消'] //按钮
    }, function(index){
        layer.close(index);
        doDelete(dataSharingCuid)
    }, function(){
        layer.msg('操作取消成功', {icon: 1});
    });

});

function doDelete(dataSharingCuid) {
    var dataSharing = {
        dataSharingCuid:dataSharingCuid,
        dataSharingState:4
    };
    var dataInBean = {
        dataSharing:dataSharing
    };
    $.ajax({
        url:server_url.dataSharing.doUpdate,
        type:'GET',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            layer.msg('删除成功',{icon:1});
            $('#showPostDetails').modal('hide');
            init(1);
        }
    });
};

function doUpdate(dataSharingCuid) {
    var dataSharing = {
        dataSharingCuid:dataSharingCuid,
        dataSharingTitle:$('#dataSharingTitle').val(),
        dataSharingType: $('#dataSharingType option:selected').val(),
        dataSharingTag:$('#dataSharingTag').val(),
        dataSharingMainContent : $('#dataSharingMainContent').val(),
        dataSharingUrl : $('#dataSharingUrl').val()
    };
    var dataInBean = {
        dataSharing:dataSharing
    };
    $.ajax({
        url:server_url.dataSharing.doUpdate,
        type:'GET',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            layer.msg('更新成功',{icon:1});
            $('#showPostDetails').modal('hide');
            init(1);
        }
    });
};

function selectByPrimaryKey(dataSharingCuid) {
    var dataSharing = {
        dataSharingCuid:dataSharingCuid
    };
    var dataInBean = {
        dataSharing:dataSharing
    };
    $.ajax({
        url:server_url.dataSharing.selectByPrimaryKey,
        type:'GET',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            if(data.state == false){
                //layer.msg(data.msg,{icon:2});
                return;
            }
            appendDetailsData(data.msg);
        }
    });
};

function appendDetailsData(data){
    $('#dataSharingTitle').val(data.dataSharingTitle);
    $('#dataSharingType').val(data.dataSharingType);
    $('#dataSharingTag').val(data.dataSharingTag);
    $('#dataSharingMainContent').val(data.dataSharingMainContent);
    $('#dataSharingUrl').val(data.dataSharingUrl);
    $('#dataSharingCreateTime').val(data.dataSharingCreateTime);
    $('#dataSharing-delete-btn').attr('dataSharingCuid',data.dataSharingCuid);
    $('#dataSharing-btn-update').attr('dataSharingCuid',data.dataSharingCuid);
    $('#show-file').empty();
    if(data.dataSharingFileUrl1 != null && data.dataSharingFileUrl1 != ''){
        $('#show-file').append('<span class="file-name"><a target="_blank" href="'+data.dataSharingFileUrl1+'">查看分享文件</a></span>');
    }
    if(data.dataSharingFileUrl2 != null && data.dataSharingFileUrl2 != ''){
        $('#show-file').append('<span class="file-name"><a target="_blank" href="'+data.dataSharingFileUrl2+'">查看分享文件</a></span>');
    }
    if(data.dataSharingFileUrl3 != null && data.dataSharingFileUrl3 != ''){
        $('#show-file').append('<span class="file-name"><a target="_blank" href="'+data.dataSharingFileUrl3+'">查看分享文件</a></span>');
    }
    if(data.dataSharingFileUrl4 != null && data.dataSharingFileUrl4 != ''){
        $('#show-file').append('<span class="file-name"><a target="_blank" href="'+data.dataSharingFileUrl4+'">查看分享文件</a></span>');
    }
    $('#show-file').append();
};
$(document).on('click','.btn-details',function () {
    selectByPrimaryKey($(this).attr('dataSharingCuid'));
});

$(document).on('click','#dataSharing-btn-update',function () {
    doUpdate($(this).attr('dataSharingCuid'));
});