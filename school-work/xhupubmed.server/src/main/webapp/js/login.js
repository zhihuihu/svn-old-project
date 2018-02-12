/**
 * Created by huzhihui on 2016/3/26.
 */
$(function(){

});
$('.login-form-content').submit(function(){
    admin_login();
    return false;
});
function admin_login(){
    doLogin();
};

function doLogin() {
    var layerLoad = layer.load(2);
    var sysUser = {
        sysUserLoginName:$('#sysUserLoginName').val(),
        sysUserPassword:$('#sysUserPassword').val()
    };
    var dataInBean = {
        sysUser:sysUser
    };
    $.ajax({
        url:server_url.sysUser.doLogin,
        type:'POST',
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            layer.close(layerLoad);
            if(data.state == true){
                layer.msg("登录成功",{icon:1});
                setTimeout(function(){
                    window.location.href='index.html';
                },2000);
            }else{
                layer.tips('登录名或密码输入错误', '#line-name');
            }
        },
        error:function(){
            layer.close(layerLoad);
        }
    });
};