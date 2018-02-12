$(function(){
	/**
	 * 登录按钮点击事件
	 * 先判断是否登录，如果登录直接到主页面，
	 * 没有登录再判断cookie里面是否保存了登录信息
	 * 如果保存了则跳转到后台验证信息，通过直接
	 * 到主页面，
	 * 没有保存直接跳转到登录页面
	 */
	$("#index_login").on("click", function(){
		$.ajax({
			 type:"post",
			 url:$api.login.checkUserIsLogin,
			 dataType:'json',
			 success:function(data){
				 if(data.code == "000000"){
					 location.href = "admin.html";
				 }else{
					 var loginUserInfo = $.cookie("loginUserInfo");
						var a = $(this);
						if(loginUserInfo){
							$.ajax({
								 type:"post",
								 url:$api.login.frontLogin,
								 dataType:'json',
								 data:{
									 "jsonStr" : loginUserInfo
								 },
								 success:function(data){
									 if(data.code == "1"){
										 location.href = $remote_url_pre + "admin.html";
									 }else{
										 location.href = $remote_url_pre + "login.html";
									 }
								 }
							});
						}else{
							location.href = $remote_url_pre + "login.html";
						}
				 }
			 }
		});
	});
});