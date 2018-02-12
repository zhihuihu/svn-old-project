/**
 * 添加商家Ctrl

 */

 $(document).ready(function(){
 	console.log('add merchant');

 	$('#merchantAddSubmit').click(function(){
 		var merchantName = $('input[name=merchantName]').val();
 		var merchantAddress = $('input[name=merchantAddress]').val();
 		var merchantLog = $('input[name=merchantLog]').val();
 		var merchantLat = $('input[name=merchantLat]').val();
 		var merchantLinkName = $('input[name=merchantLinkName]').val();
 		var merchantTele = $('input[name=merchantTele]').val();
 		var merchantIntro = $('input[name=merchantIntro]').val();
 		var tagId = $('input[name=merchantTag]:checked').val();
 		var tagName = $('input[name=merchantTag]:checked').parent().find('span').html();
 		console.log(tagId);console.log(tagName);

 		var data = {
 			'merchantName':merchantName,
			'merchantAddress':merchantAddress,
			'merchantLog':merchantLog,
			'merchantLat':merchantLat,
			'merchantLinkName':merchantLinkName,
			'merchantTele':merchantTele,
			'merchantIntro':merchantIntro,
			'tagId':tagId,
			'tagName':tagName
 		};
 		$.ajax({
 			url:'http://127.0.0.1:8080/leisure/admin/merchant/add',
 			data:data,
 			dataType:'json',
 			type:'GET',
 			success:function(res){
 				console.log(res);
 				if(res.state == true){
 					alert('添加成功');
 					window.location.href="index.html";
 				}
 			}
 		})
 	})
 	getTag();
 	function getTag(){
 		$.ajax({
 			url:'http://127.0.0.1:8080/leisure/admin/tag/list',
 			type:'GET',
 			dataType:'json',
 			success:function(res){
 				console.log(res);
 				var data ={
 					'res':res
 				}
 				var tagListHtml = template('tagTemplate',data);
  				$('#tagTd').append(tagListHtml);

 			}
 		})

 	}
 })