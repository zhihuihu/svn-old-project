$('#login-form').submit(function(e){
	e.preventDefault();
	userLogin();
});

/**
 * 用户登录方法
 */
function userLogin(){
	var sysUser = {
		sysUserLoginName:$('#sysUserLoginName').val(),
		sysUserPassword:$('#sysUserPassword').val()
	};
	var parameterBeanString = {
		sysUser : sysUser
	};
	$.ajax({
		url:serverUrl.sysUser.userLogin,
		type:'POST',
		dataType:'json',
		success:function(data){
			if(false == data.msgState){
				layer.msg(data.msg,{icon:2,skin: 'layer-ext-moon'});
			}else{
				layer.msg(data.msg,{icon:1,skin: 'layer-ext-moon'});
			}
		},
		error:function(data){
			
		}
	});
}