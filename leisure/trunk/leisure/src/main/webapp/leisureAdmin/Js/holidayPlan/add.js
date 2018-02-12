/**
 * holidayPlan  假日方案增加
 */

 $(document).ready(function(){
 	'use strict';
 	$('#addSubmit').click(function(){

 		var start = $('#start').val();
 		var end = $('#end').val();
 		var content = $('#content').val();
 		var name = $('#name').val();
 		var data = {
 			'start':start,
 			'end':end,
 			'content':content,
 			'name':name
 		};

 		$.ajax({
 			url:'http://127.0.0.1:8080/leisure/admin/holiday/add',
 			type:'GET',
 			data:data,
 			dataType:'json',
 			success:function(res){
 				if(res.state == true){
 					alert('添加成功');
 					window.location.href = "index.html";
 				}

 			}
 		});
 	});
 });