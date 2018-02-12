/**
 * 假日方案ctrl
 */

 $(document).ready(function(){

 	$.ajax({
 		url:'http://127.0.0.1:8080/leisure/admin/holiday/list',
 		type:'GET',
 		dataType:'json',
 		success:function(res){
 			if( res.state == true){
 				console.log(res);
 				var holidayPlanHtml = template('holidayPlanItemTemplate',res);
 				$('#holidayPlanTr').append(holidayPlanHtml);
 			}
 		}
 	})

 	$(document).on('click','.toAddProgram',function(){
 		localStorage.setItem('holidayPlanId', $(this).attr('id'));
 		console.log($(this).attr('id'));
 		window.location.href = "addPlanProgram.html";
 	})
 })