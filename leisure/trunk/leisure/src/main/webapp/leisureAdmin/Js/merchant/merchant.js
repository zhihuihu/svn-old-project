/**
 *  商家列表获取ctrl
 */

 $(document).ready(function(){
 	getMerchantList();
 	function getMerchantList(){

 		$.ajax({
 			url:"http://localhost:8080/leisure/admin/merchant/list",
 			type:'GET',
 			dataType:'json',
 			success:function(res){
 					var data = {
 						'res':res
 					};
 					var merchantListHtml = template('merchantListTemplate',data);
 					$('#merchantTable').append(merchantListHtml);
 					console.log(res); 				
 			}
 		})
 	}

 	$(document).on('click','.toEdit',function(){
 		localStorage.setItem("merchantId",$(this).attr('id'));
 		localStorage.setItem("merchantName",$(this).parent().parent().find('.merchantName').html());
 		window.location.href="edit.html";

 	})
 })