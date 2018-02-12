/**
 * 标签编辑Ctrl
 */

 $(document).ready(function(){

 	$('#TagSubmit').click(function(){
 		console.log('tagEdit');
	 	var tagName = $('input[name=tagName]').val();
	 	var tagImage = $('input[name=tagImage]').val();
	 	var data = {
	 		'tagName':tagName,
	 		'tagImage':tagImage
	 	}; 	

	 	$.ajax({
	 		url:'http://127.0.0.1:8080/leisure/admin/tag/add',
	 		type:'POST',
	 		data:data,
	 		dataType:'json',
	 		success:function(res){
	 			console.log(res);
	 			if(res.state == true){
	 				alert('添加成功!!');
	 				window.location.href="index.html";
	 			}
	 		}
	 	})

 	})
 	
 })