/**
 * 假日方案规划增加
 */

 $(document).ready(function(){

 	$('#submit').click(function(){
 		var address = $('#address').val();
 		var start = $('#start').val();
 		var end = $('#end').val();
 		var content = $('#content').val();
 		var name = $('#name').val();
 		var holidayPlanId = localStorage.getItem('holidayPlanId');
 		var data = {
 			'address':address,
 			'start':start,
 			'end':end,
 			'content':content,
 			'holidayPlanId':holidayPlanId,
 			'name':name
 		};
 		
 		$.ajax({
	 		url:'http://127.0.0.1:8080/leisure/admin/programplan/add',
	 		type:"GET",
	 		data:data,
	 		dataType:'json',
	 		success:function(res){
	 			if(res.state == true){
	 				alert('添加成功')
	 			}
	 			console.log(res);
	 		}
 		})

 	})
 })