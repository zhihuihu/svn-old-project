/**
 * 商家编辑后台管理Ctrl
 */

$(document).ready(function(){

	var merchantId = localStorage.getItem("merchantId");
	var merchantName = localStorage.getItem("merchantName");
	console.log(merchantName);
	$('input[name = merchantName]').val(merchantName);
	$(document).on('click','#merchantEditSubmit',function(){
		//var merchantName = $('input[name = merchantName]').val();
		var merchantLog = $('input[name = merchantLog]').val();
		var merchantLat =$('input[name = merchantLat]').val();
		var Intro = $('textarea[name = merchantIntro]').val();

		//var merchantEndTime = $('input[name = merchantEndTime]').val();
		var data={
			'merchantId':merchantId,
			'merchantLog':merchantLog,
			'merchantLat':merchantLat,
			'Intro':Intro
		};

		$.ajax({
			url:"http://localhost:8080/leisure/admin/merchant/update",
			type:'POST',
			data:data,
			dataType:'json',
			success:function(res){
				if(res.state == true){
					console.log(res);
					window.location.href="index.html";
				}
			}

		})
	})
	
})