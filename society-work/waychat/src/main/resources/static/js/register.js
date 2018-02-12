$('#register-form').submit(function(e){
	e.preventDefault();
	checkUserLoginName();
});

/**
 * 用户登录方法
 */
function userRegister(){
	var sysUser = {
		sysUserLoginName:$('#sysUserLoginName').val(),
		sysUserPassword:$('#sysUserPassword').val()
	};
	var parameterBeanString = {
		sysUser : sysUser
	};
	$.ajax({
		url:serverUrl.sysUser.userRegister,
		type:'POST',
		data:{
			parameterBeanString : JSON.stringify(parameterBeanString)
		},
		dataType:'json',
		success:function(data){
			if(false == data.msgState){
				layer.msg(data.msg,{icon:2,skin: 'layer-ext-moon'});
			}else{
				layer.msg(data.msg,{icon:1,skin: 'layer-ext-moon'},function(){
					window.location = serverHtmlUrl.sysUser.login;
				});
			}
		},
		error:function(data){
			
		}
	});
};

function checkUserLoginName(){
	var sysUser = {
			sysUserLoginName:$('#sysUserLoginName').val()
		};
		var parameterBeanString = {
			sysUser : sysUser
		};
		$.ajax({
			url:serverUrl.sysUser.checkUserLoginName,
			type:'POST',
			data:{
				parameterBeanString : JSON.stringify(parameterBeanString)
			},
			dataType:'json',
			success:function(data){
				if(false == data.msgState){
					layer.msg(data.msg,{icon:2,skin: 'layer-ext-moon'});
				}else{
					userRegister();
				}
			},
			error:function(data){
				
			}
		});
};