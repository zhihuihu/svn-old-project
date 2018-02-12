/**
 * Created by huzhihui on 2016/4/19.
 */
$('#addOneAdmin').on('click',function(){
    $('#showAdminDetails').modal('show');
    $('#i-btn-insert').show();
    $('#i-btn-update').hide();
    $('#i-btn-delete').hide();
    $('#sysUserLoginName').attr('disabled',false);
});

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
    var layerLoad = layer.load(2);
    var sysUser = {
        sysUserType:1
    };
    var dataInBean = {
        sysUser:sysUser,
        searchName:$('#searchName').val(),
        startTime:$('#startTime').val(),
        endTime:$('#endTime').val(),
        currentPage:currentPage,
        lineSize:6
    };
    $.ajax({
        url:server_url.sysUser.selectByAttributeAnd,
        type:'GET',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            var appendHtml = template('admin-template',data);
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
    layer.close(layerLoad);
};

$(document).on('click','#searchBtn',function(){
    init_search_page_function(1);
});

$(document).on('click','.btn-delete',function(){
    $('#i-btn-insert').hide();
    $('#i-btn-update').show();
    $('#i-btn-delete').show();
    $('#sysUserLoginName').attr('disabled',true);
    var sysUserCuid = $(this).attr('sysUserCuid');
    layer.confirm('是否确定删除', {
        btn: ['确定','取消'] //按钮
    }, function(index){
        layer.close(index);
        doDelete(sysUserCuid);
        init_search_page_function();
    }, function(){
        layer.msg('操作取消成功', {icon: 1});
    });

});

function doDelete(sysUserCuid) {
    var layerLoad = layer.load(2);
    var sysUser = {
        sysUserCuid:sysUserCuid,
        sysUserState:4
    };
    var dataInBean = {
        sysUser:sysUser
    };
    $.ajax({
        url:server_url.sysUser.doUpdate,
        type:'GET',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            layer.msg('删除成功',{icon:1});
            $('#showAdminDetails').modal('hide');
            init_search_page_function(1);
        }
    });
    layer.close(layerLoad);
};

$(document).on('click','.btn-details',function () {
    $('#i-btn-insert').hide();
    $('#i-btn-update').show();
    $('#i-btn-delete').show();
    $('#sysUserLoginName').attr('disabled',true);
    selectByPrimaryKey($(this).attr('sysUserCuid'));
})

/**
 * 资料更新方法
 */
$(document).on('click','#i-btn-update',function () {
    var sysUserCuid = $(this).attr('sysUserCuid');
    layer.confirm('是否确定更新资料', {
        btn: ['确定','取消'] //按钮
    }, function(index){
        layer.close(index);
        doUpdate(sysUserCuid);
        $('#showAdminDetails').modal('hide');
        init_search_page_function();
    }, function(){
        layer.msg('操作取消成功', {icon: 1});
    });
});

/**
 * 查询详情的方法
 * @param sysUserCuid
 */
function selectByPrimaryKey(sysUserCuid){
    var sysUser = {
        sysUserCuid:sysUserCuid
    };
    var dataInBean = {
        sysUser:sysUser
    };
    $.ajax({
        url:server_url.sysUser.selectByPrimaryKey,
        type:'GET',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            $('#sysUserName').val(data.msg.sysUserName);
            $('#sysUserRealName').val(data.msg.sysUserRealName);
            $('#sysUserLoginName').val(data.msg.sysUserLoginName);
            $('#sysUserPassword').val(data.msg.sysUserPassword);
            $('#sysUserEmail').val(data.msg.sysUserEmail);
            $('#sysUserTele').val(data.msg.sysUserTele);
            $('#sysUserAddress').val(data.msg.sysUserAddress);
            $('#i-btn-update').attr('sysUserCuid',data.msg.sysUserCuid);
            $('#i-btn-delete').attr('sysUserCuid',data.msg.sysUserCuid);
        }
    });
};

/**
 * 更新方法
 * @param sysUserCuid
 */
function doUpdate(sysUserCuid) {

    var sysUser = {
        sysUserCuid:sysUserCuid,
        sysUserRealName:$('#sysUserRealName').val(),
        sysUserPassword:$('#sysUserPassword').val(),
        sysUserEmail:$('#sysUserEmail').val(),
        sysUserTele:$('#sysUserTele').val(),
        sysUserAddress:$('#sysUserAddress').val()
    };
    var dataInBean = {
        sysUser:sysUser
    };
    $.ajax({
        url:server_url.sysUser.doUpdate,
        type:'GET',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            layer.msg('更新成功',{icon:1});
            init();
        }
    });
};

$(document).on('click','#i-btn-insert',function () {
    doInsert();
});

function doInsert() {
    var sysUser = {
        sysUserRealName:$('#sysUserRealName').val(),
        sysUserLoginName:$('#sysUserLoginName').val(),
        sysUserPassword:$('#sysUserPassword').val(),
        sysUserEmail:$('#sysUserEmail').val(),
        sysUserTele:$('#sysUserTele').val(),
        sysUserAddress:$('#sysUserAddress').val()
    };
    var dataInBean = {
        sysUser:sysUser
    };
    $.ajax({
        url:server_url.sysUser.doInsert,
        type:'GET',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            if(data.state == true){
                layer.msg(data.msg,{icon:1});
                $('#showAdminDetails').modal('hide');
                init_search_page_function();
            }else{
                layer.msg(data.msg,{icon:2});
            }
        }
    });
}