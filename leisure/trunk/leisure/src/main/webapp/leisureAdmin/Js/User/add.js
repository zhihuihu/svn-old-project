/**
 * 用户增加ctrl
 */

 $(document).ready(function(){

 	$(document).on('click','#addSubmit',function(){
 		addUser();
 	})

 	function addUser(){

 		var userTele = $('input[name = addTele]').val();
 		var userEmail = $('input[name = addEmain').val();
 		var userPassword = $('input[name = addPassword]').val();

 		var addData = {
 			'Tele':userTele,
 			'Email':userEmail,
 			'Password':userPassword
 		};

 		$.ajax({
 			url:'http://localhost:8080/leisure/client/user/normal/register',
 			data:addData,
 			type:'GET',
 			dataType:'json',
 			success:function(res){
 				if( res.state == true ){
 					console.log( res );
 				}
 			}
 		})
 	}
 })