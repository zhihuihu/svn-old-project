/**
 * Created by huzhihui on 2016/4/19.
 */
$(function () {
    init();
});

function init() {
    $.ajax({
        url:server_url.sysUser.selectMydata,
        type:'GET',
        async:false,
        dataType:'json',
        data:{
        },
        success:function(data){
            if(data.state == true){
                val_data(data.msg);
            }else{
                layer.msg(data.msg,{icon:2});
            }
        }
    });
};

function val_data(data) {
    $('#sysUserRealName').val(data.sysUserRealName);
    $('#sysUserLoginName').val(data.sysUserLoginName);
    $('#sysUserPassword').val(data.sysUserPassword);
    $('#sysUserEmail').val(data.sysUserEmail);
    $('#sysUserTele').val(data.sysUserTele);
    $('#sysUserAddress').val(data.sysUserAddress);
    $('#sysUserCuid').attr('sysUserCuid',data.sysUserCuid);
};

$(document).on('click','.btn-update',function () {
    var sysUserCuid = $(this).attr('sysUserCuid');
    layer.confirm('是否确定更新', {
        btn: ['确定','取消'] //按钮
    }, function(index){
        layer.close(index);
        doUpdate(sysUserCuid)
    }, function(){
        layer.msg('操作取消成功', {icon: 1});
    });
});

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