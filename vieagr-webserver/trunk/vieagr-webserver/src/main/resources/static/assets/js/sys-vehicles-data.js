var layerLoad;

/**
 * 页面初始化加载
 */
(function(){
	initSysVehiclesList(1);
})();
/**
 * 车辆--添加
 */
$('#sys-vehicles-add-form').submit(function() {
	if(!$checkFormVal('#sys-vehicles-add-form')){
		layer.msg('数据没有填写完整，请检查', {icon: 2});
		return false;
	}
	layerLoad = layer.load();
	var sysVehicles = {
		sysVehiclesType : $('#sysVehiclesType').val(),
		sysVehiclesPlateNumber : $('#sysVehiclesPlateNumber').val(),
		sysVehiclesRegisterName : $('#sysVehiclesRegisterName').val(),
		sysVehiclesRegisterMobile : $('#sysVehiclesRegisterMobile').val(),
		sysVehiclesDesc : $('#sysVehiclesDesc').val(),
		sysVehiclesImgUrl : $('#sysVehiclesImgUrl').attr('src')
	};
	$.ajax({
		url : $api.sysVehicles.sysVehiclesAdd,
		type : "POST",
		dataType : "JSON",
		data : {
			"jsonStr" : JSON.stringify(sysVehicles)
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
			$('#sys-vehicles-add-form')[0].reset();
			$('#sysVehiclesImgUrl').attr('src',$assets.headChooseIcon);
			initSysVehiclesList(1);
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
 * 加载数据列表
 * @param currentPage
 */
function initSysVehiclesList(currentPage){
	var sysVehicles = {
		currentPage : currentPage,
		pageSize : 10,
		searchName: $('#sysVehiclesSearchName').val()
	}
	$.ajax({
		url : $api.sysVehicles.selectSysVehiclesList,
		type : "POST",
		dataType : "JSON",
		data : {
			"jsonStr" : JSON.stringify(sysVehicles)
		},
		success : function(data) {
			if(!$checkRemouteStatus(data)){
				layer.close(layerLoad);
				return;
			}
			layui.use('laytpl', function() {
				var laytpl = layui.laytpl;
				laytpl(sysVehiclesListTpl.innerHTML).render(data, function(html) {
					$('#sys-vehicles-list-body').html(html)
				});
			});
			layui.use('laypage', function() {
				layui.laypage({
					cont: $('#sys-vehicles-list-body-page'),
					pages: data.totalPage,
					groups: 2,
					curr: data.currentPage,
					skip: true,
					jump: function (obj,first) {
						if(!first){
							initSysVehiclesList(obj.curr);
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
}

/**
 * 车辆--搜索查询
 */
$('#sys-vehicles-search-form').submit(function(e){
	e.preventDefault();
	initSysVehiclesList(1);
});

/**
 * 车辆--启用禁用状态修改
 */
$('#sys-vehicles-list-body').on('click','.btn-sys-vehicles-states',function(){
	var sysVehicles = {
		sysVehiclesId : $(this).attr('sysVehiclesId')
	};
	$.ajax({
		url : $api.sysVehicles.updateSysVehiclesState,
		type : "POST",
		dataType : "JSON",
		data : {
			"jsonStr" : JSON.stringify(sysVehicles)
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
			initSysVehiclesList(1);
			layer.close(layerLoad);
		},
		error : function() {
			layer.close(layerLoad);
			layer.msg('网络异常，请稍后再试', {icon: 2});
		}
	});
});

$('#sys-vehicles-list-body').on('click', '.btn-sys-vehicles-update', function() {
	$.ajax({
		url : $api.sysVehicles.selectByPrimaryKey,
		type : "POST",
		dataType : "JSON",
		data : {
			"sysVehiclesId" : $(this).attr('sysVehiclesId')
		},
		beforeSend : function () {
			layerLoad = layer.load();
		},
		success : function(data,e) {
			if(!$checkRemouteStatus(data)){
				layer.close(layerLoad);
				return;
			}
			$('#sysVehiclesIdUpdate').val(data.msg.sysVehiclesId);
			$('#sysVehiclesTypeUpdate').val(data.msg.sysVehiclesType);
			$('#sysVehiclesPlateNumberUpdate').val(data.msg.sysVehiclesPlateNumber);
			$('#sysVehiclesRegisterNameUpdate').val(data.msg.sysVehiclesRegisterName);
			$('#sysVehiclesRegisterMobileUpdate').val(data.msg.sysVehiclesRegisterMobile);
			$('#sysVehiclesDescUpdate').val(data.msg.sysVehiclesDesc);
			if(data.msg.sysVehiclesImgUrl){
				$('#sysVehiclesImgUrlUpdate').attr('src',data.fileUrlPre + data.msg.sysVehiclesImgUrl)
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
		title : '车辆信息修改',
		area : 'auto',
		maxWidth : '1000px',
		content : $('#sys-vehicles-update-model'),
		cancel : function(){
			$('#sys-vehicles-update-form')[0].reset();
			$('#sysVehiclesImgUrlUpdate').attr('src',$assets.headChooseIcon);
		}
	});
});

$('#sys-vehicles-update-form').submit(function(e){
	e.preventDefault();
	if(!$checkFormVal('#sys-vehicles-update-form')){
		layer.msg('数据没有填写完整，请检查', {icon: 2});
		return false;
	}
	layerLoad = layer.load();
	var sysVehicles = {
		sysVehiclesId : $('#sysVehiclesIdUpdate').val(),
		sysVehiclesType : $('#sysVehiclesTypeUpdate').val(),
		sysVehiclesPlateNumber : $('#sysVehiclesPlateNumberUpdate').val(),
		sysVehiclesRegisterName : $('#sysVehiclesRegisterNameUpdate').val(),
		sysVehiclesRegisterMobile : $('#sysVehiclesRegisterMobileUpdate').val(),
		sysVehiclesDesc : $('#sysVehiclesDescUpdate').val(),
		sysVehiclesImgUrl : $('#sysVehiclesImgUrlUpdate').attr('src')
	};
	$.ajax({
		url : $api.sysVehicles.updateSysVehicles,
		type : "POST",
		dataType : "JSON",
		data : {
			"jsonStr" : JSON.stringify(sysVehicles)
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
			$('#sys-vehicles-add-form')[0].reset();
			$('#sysVehiclesImgUrlUpdate').attr('src',$assets.headChooseIcon);
			layer.closeAll('page');
			initSysVehiclesList(1);
			layer.close(layerLoad);
		},
		error : function() {
			layer.close(layerLoad);
			layer.msg('网络异常，请稍后再试', {icon: 2});
		}
	});
});

/**
 * 新增--图片裁剪
 */
$('#sysVehiclesImgUrlChoose').on('click',function(){
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
	$initCropper('#sysVehiclesImgUrl',headImagePopPage);
	//end 裁剪页面
});

/**
 * 修改--图片裁剪
 */
$('body').on('click','#sysVehiclesImgUrlUpdateChoose',function(){
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
	$initCropper('#sysVehiclesImgUrlUpdate',headImagePopPage);
	//end 裁剪页面
});