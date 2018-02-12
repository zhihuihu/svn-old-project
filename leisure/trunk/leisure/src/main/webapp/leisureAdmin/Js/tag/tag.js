/**
 * 管理员标签
 */

 $(document).ready(function(){
 	console.log('tagIndex');

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
  				$('#tagTable').append(tagListHtml);

 			}
 		})

 	}
 })