/**
 * Created by huzhihui on 2016/10/17.
 */
$(function(){
	isRedirectMainView();
	/**
	 * form-登录
	 */
	$('#login-form').submit(function(e){
		if($("#userName").val().length ==0 ||
				$('#password').val().length == 0){
			return false;
		}
		e.preventDefault();
		var loginParam = {
				 'userName' : $("#userName").val(),
				 'password' : $('#password').val(),
				 'userType' : "2"
		}
		$.ajax({
			 type:"post",
			 url:$api.login.frontLogin,
			 dataType:'json',
			 data:{
				 "jsonStr" : JSON.stringify(loginParam)
			 },
			 beforeSend : function () {
				layerLoad = layer.load();
			},
			 success:function(data){
				 if(!$checkRemouteStatus(data)){
						layer.close(layerLoad);
						return;
					}
				if(data.code == "1"){
					if($("#rememberPassword").prop("checked")){
						$.cookie("loginUserInfo",'{"userName":'+'"'+loginParam.userName+'"'+
								', "password":'+'"'+loginParam.password+'"'+',"userType":"2"}', {expires:30});
					}
					location.href = "admin.html";
				}else{
					layer.close(layerLoad);
					layer.alert(data.message);
					return false;
				}
			 }
		});
		return false;
	});
	
	$("#forget_password").on("click", function(){
		
	});
});

/**
 * 若用户已经登录则
 * 在页面刷新的时候直接进入登录后主页
 */
function isRedirectMainView(){
	$.ajax({
		 type:"post",
		 url:$api.login.checkUserIsLogin,
		 dataType:'json',
		 success:function(data){
			 if(data.code == "000000"){
				 location.href = "admin.html";
			 }else{
				 return false;
			 }
		 }
	});
}