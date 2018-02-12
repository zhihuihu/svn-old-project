/**
 * 修改用户信息
 */

/*
用户编辑ctrl

*/
 $(document).ready(function(){
 	var userEmail = localStorage.getItem("userEmail");
 	var userMainContent = localStorage.getItem("userMainContent");
 	var userPassword =  localStorage.getItem("userPassword");

 	console.log(userEmail);
 	$('#userEmail').val(userEmail);
 	$('#userMainContent').val(userMainContent);
 	$('#userPassWord').val(userPassword);
 	$(document).on('click','#submit',function(){
 		editUser();
 	})
 	function editUser(){
 		console.log('enter edit');
 		var userId = localStorage.getItem("userId");
 		var userPassword = $('#userPassWord').val();
 		var userLoginName = $('#userLoginName').val();
 		var userMainRange = $('#userMainContent').val();
 		var editData = {
 			userId:userId,
 			userPassword:userPassword,
 			userLoginName:userLoginName,
 			userMainRange:userMainRange
 		};

 		$.ajax({
 			url:"http://localhost:8080/leisure/admin/user/edit",
 			type:'POST',
 			data:editData,
 			dataType:'json',
 			success:function(res){
 				console.log(res);
 				if(res.state==true){
 					window.location.href="index.html";
 				}
 			}
 		})

 	}
 })