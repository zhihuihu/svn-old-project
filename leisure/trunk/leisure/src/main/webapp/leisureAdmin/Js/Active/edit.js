/**
 * 活动编辑Admin
 */


 $(document).ready(function(){
 	console.log('edit');

 	var activeId = localStorage.getItem('activeId');
 	var activeName = localStorage.getItem('activeName');
 	var activeAddress = localStorage.getItem('activeAddress');
 	var activeStartTime = localStorage.getItem('activeStartTime');
 	var activeMainContent = localStorage.getItem('activeMainContent');
 	$('input[name=activeName]').val(activeName);
 	$('input[name=activeAddress]').val(activeAddress);
 	$('input[name=activeStartTime]').val(activeStartTime);
 	$('input[name=activeMainContent]').val(activeMainContent);

 	$(document).on('click','#activeSubmit',function(){
 		var activeName = $('input[name=activeName]').val();
 		var activeAddress = $('input[name=activeAddress]').val();
 		var activeMainContent = $('input[name=activeMainContent]').val();
 		var activeStartTime = $('input[name=activeStartTime]').val();
 		var data = {
 			'activeId':activeId,
 			'activeName':activeName,
 			'activeAddress':activeAddress,
 			'activeMainContent':activeMainContent,
 			'activeStartTime':activeStartTime
 		}
 		$.ajax({
 			url:"http://127.0.0.1:8080/leisure/admin/active/update",
 			type:'GET',
 			data:data,
 			dataType:'json',
 			success:function(res){
 				console.log(res)
 				if(res.state == true){
 					window.location.href="index.html";
 				}
 			}
 		})
 	})
 })