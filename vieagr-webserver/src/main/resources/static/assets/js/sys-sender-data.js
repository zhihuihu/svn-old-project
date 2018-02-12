var layerLoad;

/**
 * 页面初始化加载
 */
(function(){
	initSysSenderList(1);
})();
/**
 * 送货人--添加
 */
$('#sys-sender-add-form').submit(function() {
	if(!$checkFormVal('#sys-sender-add-form')){
		layer.msg('数据没有填写完整，请检查', {icon: 2});
		return false;
	}
	layerLoad = layer.load();
	var sysSender = {
		sysSenderName : $('#sysSenderName').val(),
		sysSenderMobileNumber : $('#sysSenderMobileNumber').val(),
		sysSenderImgUrl : $('#sysSenderImgUrl').attr('src')
	};
	$.ajax({
		url : $api.sysSender.sysSenderAdd,
		type : "POST",
		dataType : "JSON",
		data : {
			"jsonStr" : JSON.stringify(sysSender)
		},
		beforeSend : function () {
			layerLoad = layer.load();
		},
		success : function(data) {
			if(!$checkRemouteStatus(data)){
				layer.close(layerLoad);
				return;
			}
			layer.msg(data.msg, {icon: 1});
			$('#sys-sender-add-form')[0].reset();
			$('#sysSenderImgUrl').attr('src',$assets.headChooseIcon);
			initSysSenderList(1);
			layer.close(layerLoad);
		},
		error : function() {
			layer.close(layerLoad);
			layer.msg('网络异常，请稍后再试', {icon: 2});
		}
	});
	return false;
});

/**
 * 送货人--列表查询
 * @param currentPage
 */
function initSysSenderList(currentPage){
	var sysSender = {
		currentPage : currentPage,
		pageSize : 10,
		searchName: $('#sysSenderSearchName').val()
	}
	$.ajax({
		url : $api.sysSender.selectSysSenderList,
		type : "POST",
		dataType : "JSON",
		data : {
			"jsonStr" : JSON.stringify(sysSender)
		},
		success : function(data) {
			if(!$checkRemouteStatus(data)){
				layer.close(layerLoad);
				return;
			}
			layui.use('laytpl', function() {
				var laytpl = layui.laytpl;
				laytpl(sysSenderListTpl.innerHTML).render(data, function(html) {
					$('#sys-sender-list-body').html(html)
				});
			});
			layui.use('laypage', function() {
				layui.laypage({
					cont: $('#sys-sender-list-body-page'),
					pages: data.totalPage,
					groups: 2,
					curr: data.currentPage,
					skip: true,
					jump: function (obj,first) {
						if(!first){
							initSysSenderList(obj.curr);
						}
					}
				});
			});
			layer.close(layerLoad);
		},
		error : function() {
			layer.close(layerLoad);
			layer.msg('网络异常，请稍后再试', {icon: 2});
		}
	});
};

/**
 * 送货人--搜索查询
 */
$('#sys-sender-search-form').submit(function(e){
	e.preventDefault();
	initSysSenderList(1);
});

/**
 * 车辆--启用禁用状态修改
 */
$('#sys-sender-list-body').on('click','.btn-sys-sender-states',function(){
	var sysSender = {
		sysSenderId : $(this).attr('sysSenderId')
	};
	$.ajax({
		url : $api.sysSender.updateSysSenderState,
		type : "POST",
		dataType : "JSON",
		data : {
			"jsonStr" : JSON.stringify(sysSender)
		},
		beforeSend : function () {
			layerLoad = layer.load();
		},
		success : function(data) {
			if(!$checkRemouteStatus(data)){
				layer.close(layerLoad);
				return;
			}
			layer.msg(data.msg, {icon: 1});
			initSysSenderList(1);
			layer.close(layerLoad);
		},
		error : function() {
			layer.close(layerLoad);
			layer.msg('网络异常，请稍后再试', {icon: 2});
		}
	});
});

/**
 * 送货人--修改弹出层
 */
$('#sys-sender-list-body').on('click', '.btn-sys-sender-update', function() {
	$.ajax({
		url : $api.sysSender.selectByPrimaryKey,
		type : "POST",
		dataType : "JSON",
		data : {
			"sysSenderId" : $(this).attr('sysSenderId')
		},
		beforeSend : function () {
			layerLoad = layer.load();
		},
		success : function(data,e) {
			if(!$checkRemouteStatus(data)){
				layer.close(layerLoad);
				return;
			}
			$('#sysSenderIdUpdate').val(data.msg.sysSenderId);
			$('#sysSenderNameUpdate').val(data.msg.sysSenderName);
			$('#sysSenderMobileNumberUpdate').val(data.msg.sysSenderMobileNumber);
			if(data.msg.sysSenderImgUrl){
				$('#sysSenderImgUrlUpdate').attr('src',data.fileUrlPre + data.msg.sysSenderImgUrl)
			}
			layer.close(layerLoad);
		},
		error : function() {
			layer.close(layerLoad);
			layer.msg('网络异常，请稍后再试', {icon: 2});
		}
	});
	layer.open({
		type : 1,
		title : '送货人信息修改',
		area : 'auto',
		maxWidth : '1000px',
		content : $('#sys-sender-update-model'),
		cancel : function(){
			$('#sys-sender-update-form')[0].reset();
			$('#sysSenderImgUrlUpdate').attr('src',$assets.headChooseIcon);
		}
	});
});

/**
 * 送货人--修改
 */
$('#sys-sender-update-form').submit(function() {
	if(!$checkFormVal('#sys-sender-add-form')){
		layer.msg('数据没有填写完整，请检查', {icon: 2});
		return false;
	}
	layerLoad = layer.load();
	var sysSender = {
		sysSenderId : $('#sysSenderIdUpdate').val(),
		sysSenderName : $('#sysSenderNameUpdate').val(),
		sysSenderMobileNumber : $('#sysSenderMobileNumberUpdate').val(),
		sysSenderImgUrl: $('#sysSenderImgUrlUpdate').attr('src')
	};
	$.ajax({
		url : $api.sysSender.updateSysSender,
		type : "POST",
		dataType : "JSON",
		data : {
			"jsonStr" : JSON.stringify(sysSender)
		},
		beforeSend : function () {
			layerLoad = layer.load();
		},
		success : function(data) {
			if(!$checkRemouteStatus(data)){
				layer.close(layerLoad);
				return;
			}
			layer.msg(data.msg, {icon: 1});
			$('#sys-sender-update-form')[0].reset();
			$('#sysSenderImgUrlUpdate').attr('src',$assets.headChooseIcon);
			layer.closeAll('page');
			initSysSenderList(1);
			layer.close(layerLoad);
		},
		error : function() {
			layer.close(layerLoad);
			layer.msg('网络异常，请稍后再试', {icon: 2});
		}
	});
	return false;
});

/**
 * 新增--图片裁剪
 */
$('#sysSenderImgUrlChoose').on('click',function(){
	//初始化裁剪页面
	var headImagePopPage = layer.open({
		type : 1,
		title : '车辆头像选择',
		area : 'auto',
		maxWidth : '1000px',
		content : $getCropperHtml('imgUrlChooseDiv'),
		cancel : function(){
		}
	});
	$initCropper('#sysSenderImgUrl',headImagePopPage);
	//end 裁剪页面
});

/**
 * 修改--图片裁剪
 */
$('body').on('click','#sysSenderImgUrlUpdateChoose',function(){
	//初始化裁剪页面
	var headImagePopPage = layer.open({
		type : 1,
		title : '车辆头像选择',
		area : 'auto',
		maxWidth : '1000px',
		content : $getCropperHtml('imgUrlChooseDiv'),
		cancel : function(){
		}
	});
	$initCropper('#sysSenderImgUrlUpdate',headImagePopPage);
	//end 裁剪页面
});