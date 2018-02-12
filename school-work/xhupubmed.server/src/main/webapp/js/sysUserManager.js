/**
 * Created by huzhihui on 2016/4/18.
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
    var sysUser = {
        sysUserType:2
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
            var appendHtml = template('sysUser-template',data);
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
    var sysUserCuid = $(this).attr('sysUserCuid');
    layer.confirm('是否确定删除', {
        btn: ['确定','取消'] //按钮
    }, function(index){
        layer.close(index);
        doDelete(sysUserCuid)
    }, function(){
        layer.msg('操作取消成功', {icon: 1});
    });

});

function doDelete(sysUserCuid) {
    var sysUSer = {
        sysUserCuid:sysUserCuid,
        sysUserState:4
    };
    var dataInBean = {
        sysUSer:sysUSer
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
        	$('#showPostDetails').modal('hide');
            layer.msg('删除成功',{icon:1});
            init_search_page_function(1);
        }
    });
};

$(document).on('click','.btn-details',function () {
    selectByPrimaryKey($(this).attr('sysUserCuid'));
})

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
            $('#sysUserUrl').html('<a target="_blank" style="max-height: 60px;float: left;" href="'+data.msg.sysUserUrl+'"><img style="max-height: 60px" src="'+data.msg.sysUserUrl+'"></a>');
            $('#sysUserEmail').val(data.msg.sysUserEmail);
            $('#sysUserCollege').val(data.msg.sysUserCollege);
            $('#sysUserMagor').val(data.msg.sysUserMagor);
            $('#sysUserForSchool').val(data.msg.sysUserForSchool);
            $('#sysUserForMagor').val(data.msg.sysUserForMagor);
            $('#sysUserAddress').val(data.msg.sysUserAddress);
            $('#delete-sysUserCuid').attr('sysUserCuid',data.msg.sysUserCuid);
        }
    });
};

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