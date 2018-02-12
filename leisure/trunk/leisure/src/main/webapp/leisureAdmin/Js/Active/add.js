/**
 *  活动添加AddCtrl
 */
 $(document).ready(function(){
 	'use strict';
 	$(document).on('click','#activeSubmit',function(){
 		var activeName = $('input[name=activeName]').val();
		var activeAddress = $('input[name=activeAddress]').val();
		var activeMainContent = $('input[name=activeMainContent]').val();
		var activeStartTime = $('input[name=activeStartTime]').val();
		var activeEndTime = $('input[name=activeEndTime]').val();
		var activeLog = $('input[name=activeLog]').val();
		var activeLat = $('input[name=activeLat]').val();
		var activeIconUrl = $('input[name=activeIconUrl]').val();
		activeIconUrl = "http://192.168.191.1:8080/leisureImage/"+activeIconUrl.slice(-5);
		console.log(activeIconUrl);
		var data = {
			'activeName':activeName,
			'activeAddress':activeAddress,
			'activeMainContent':activeMainContent,
			'activeStartTime':activeStartTime,
			'activeEndTime':activeEndTime,
			'activeLog':activeLog,
			'activeLat':activeLat,
			'activeIconUrl':activeIconUrl
		};

		$.ajax({
			url:'http://127.0.0.1:8080/leisure/admin/active/add',
			data:data,
			type:'GET',
			dataType:'json',
			success:function(res){
				console.log(res);
				if(res.state === true){
					confirm("添加成功！");
					window.location.href="index.html";
				}
			}
		});
 	});
 });