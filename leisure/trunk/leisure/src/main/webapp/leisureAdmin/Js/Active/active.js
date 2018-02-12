/**
 * 管理员互动列表Ctrl
 */

$(document).ready(function(){
	console.log('enter activeCtrl');
	$.ajax({
		url:"http://127.0.0.1:8080/leisure/admin/active/list",
		type:'GET',
		dataType:'json',
		success:function(res){
			var data = {
				'res':res
			};
			var activeHtml = template('userItemTemplate',data);
			$('#activeTr').append(activeHtml);
			console.log( res );
		}
	})
	toEdit();
	function toEdit(){
		$(document).on('click','.toEdit',function(){
			console.log('click');
			localStorage.setItem('activeId',$(this).parent().parent().find('.activeId').html());
			localStorage.setItem('activeName',$(this).parent().parent().find('.activeName').html());
			localStorage.setItem('activeStartTime',$(this).parent().parent().find('.activeStartTime').html());
			localStorage.setItem('activeAddress',$(this).parent().parent().find('.activeAddress').html());
			localStorage.setItem('activeMainContent',$(this).parent().parent().find('.activeMainContent').html());
			$(this).attr('href','edit.html');
		})
	}
})