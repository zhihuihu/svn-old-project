/**
 * 用户列表ctrl
 */

 $(document).ready(function(){
 	console.log('user Ctrl');
 	//获取用户列表
	getUserList();
	toEdit();
 	function getUserList(){
 		$.ajax({
 			url:'http://localhost:8080/leisure/admin/user/list',
 			type:'GET',
 			dataType:'json',
 			success:function(res){
 				console.log(res);
 				var data = {
 					res:res
 				};
 				var UserHtml = template('userItemTemplate',data);
 				$('#userTr').append(UserHtml);
 			}

 		})
 	}

 	function toEdit(){
 		$(document).on('click','.toEdit',function(){
 			localStorage.setItem("userId",$(this).attr('id'));
 			localStorage.setItem("userEmail",$(this).parent().parent().find('.user-email').html());
 			localStorage.setItem("userPassword",$(this).parent().parent().find('.user-password').html());
 			localStorage.setItem("userMainContent",$(this).parent().parent().find('.user-main-content').html());
 			$(this).attr('href','edit.html');

 		})
 	}
 	$(document).on('click','.toDelete',function(){
 		console.log('todelete');
 		var deleteId = $(this).attr('id');
 		$.ajax({
 			url:"http://localhost:8080/leisure/admin/user/delete",
 			type:'POST',
 			data:{userId:deleteId},
 			dataType:'json',
 			success:function(res){
 				if( res.state == true ){
 					console.log( res );
 					window.location.reload();
 				}
 			}
 		})
 	})

 	$(document).on('click','.toUse',function(){
 		console.log('qidong')
 		var startUserId = $(this).attr('id');
 		$.ajax({
 			url:"http://localhost:8080/leisure/admin/user/start",
 			type:'POST',
 			data:{userId:startUserId},
 			dataType:'json',
 			success:function(res){
 				if( res.state == true ){
 					console.log( res );
 					window.location.reload();
 				}
 			}
 		})

 	})
 })