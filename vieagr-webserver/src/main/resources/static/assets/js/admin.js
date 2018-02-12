$(function(){
	getLoginUserInfo();
	
	/**
	 * 切换用户
	 */
	$("#change-user-button").on("click", function(){
		$.ajax({
			url : $api.login.frontLogout,
			type : "GET",
			dataType : "JSON",
			beforeSend : function () {
				layerLoad = layer.load();
			},
			success : function(data) {
				if(!$checkRemouteStatus(data)){
					layer.close(layerLoad);
					return;
				}
				if(data.code == "000000"){
					location.href = $remote_url_pre + "login.html";
				}
			},
			error : function() {
				layer.close(layerLoad);
				layer.msg('网络异常，请稍后再试', {icon: 2});
			}
		});
	});
	
	/**
	 * 用户注销
	 */
	$("#logout-button").on("click", function(){
		$.ajax({
			url : $api.login.frontLogout,
			type : "GET",
			dataType : "JSON",
			beforeSend : function () {
				layerLoad = layer.load();
			},
			success : function(data) {
				if(!$checkRemouteStatus(data)){
					layer.close(layerLoad);
					return;
				}
				if(data.code == "000000"){
					location.href = $remote_url_pre;
				}
			},
			error : function() {
				layer.close(layerLoad);
				layer.msg('网络异常，请稍后再试', {icon: 2});
			}
		});
	});

});

/**
 * 获取登录用户的信息
 */
function getLoginUserInfo(){
	$.ajax({
		url : $api.index.getLoginUserInfo,
		type : "GET",
		dataType : "JSON",
		beforeSend : function () {
			layerLoad = layer.load();
		},
		success : function(data) {
			if(!$checkRemouteStatus(data)){
				layer.close(layerLoad);
				return;
			}
			var msg = data.msg;
			if(msg){
				layer.close(layerLoad);
				$("#login_user_name").html(msg.sysUserName);
			}
		},
		error : function() {
			layer.close(layerLoad);
			layer.msg('网络异常，请稍后再试', {icon: 2});
		}
	});
}
