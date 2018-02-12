var layerLoad;

/**
 * 当前页的记录
 */
var currentPageNow = 1;

/**
 * 页面初始化加载
 */
(function(){
	initSysVehiclesList();
	initSysCustomerList(1);
})();

/**
 * 系统车辆option初始化
 */
function initSysVehiclesList(){
	$.ajax({
		url : $api.sysVehicles.selectListToOption,
		type : "GET",
		dataType : "JSON",
		data : {
		},
		beforeSend : function () {
			layerLoad = layer.load();
		},
		success : function(data) {
			if(!$checkRemouteStatus(data)){
				layer.close(layerLoad);
				return;
			}
			var optionHtml = '';
			for(var i=0;i<data.msg.length;i++){
				optionHtml += '<option value="'+data.msg[i].sysVehiclesId+'">'+data.msg[i].sysVehiclesPlateNumber+'</option>';
			}
			$('#betVehiclesCustomerVehiclesId').html(optionHtml);
			$('#betVehiclesCustomerVehiclesIdUpdate').html(optionHtml);
			layer.close(layerLoad);
		},
		error : function() {
			layer.close(layerLoad);
			layer.msg('网络异常，请稍后再试', {icon: 2});
		}
	});
};

$('#sys-customer-form-add').submit(function(e){
	e.preventDefault();
	if(!$checkFormVal('#sys-vehicles-add-form')){
		layer.msg('数据没有填写完整，请检查', {icon: 2});
		return false;
	}
	var sysCustomer = {
		sysCustomerType : $('#sysCustomerType').val(),
		sysCustomerName : $('#sysCustomerName').val(),
		sysCustomerMobileNumber : $('#sysCustomerMobileNumber').val(),
		sysCustomerQqNumber : $('#sysCustomerQqNumber').val(),
		sysCustomerStoreName : $('#sysCustomerStoreName').val(),
		sysCustomerStoreAddress : $('#sysCustomerStoreAddress').val(),
		sysCustomerImgUrl : $('#sysCustomerImgUrl').attr('src')
	};
	var betVehiclesCustomer = {
		betVehiclesCustomerVehiclesId : $('#betVehiclesCustomerVehiclesId').val()	
	};
	var jsonObj = {
		sysCustomer : sysCustomer,
		betVehiclesCustomer : betVehiclesCustomer
	}
	$.ajax({
		url : $api.sysCustomer.sysCustomerAdd,
		type : "POST",
		dataType : "JSON",
		data : {
			"jsonStr" : JSON.stringify(jsonObj)
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
			initSysCustomerList(1);
			$('#sys-customer-form-add')[0].reset();
			$('#sysCustomerImgUrl').attr('src',$assets.headChooseIcon);
			layer.close(layerLoad);
		},
		error : function() {
			layer.close(layerLoad);
			layer.msg('网络异常，请稍后再试', {icon: 2});
		}
	});
});

/**
 * 列表初始化
 * @param currentPage
 */
function initSysCustomerList(currentPage){
	if(currentPage == 1){
		currentPageNow = currentPage;
	}
	var sysCustomer = {
		currentPage : currentPage,
		pageSize : 10,
		searchName: $('#sysCustomerSearchName').val()
	}
	$.ajax({
		url : $api.sysCustomer.selectSysCustomerList,
		type : "POST",
		dataType : "JSON",
		data : {
			"jsonStr" : JSON.stringify(sysCustomer)
		},
		beforeSend : function () {
			layerLoad = layer.load();
		},
		success : function(data) {
			if(!$checkRemouteStatus(data)){
				layer.close(layerLoad);
				return;
			}
			layui.use('laytpl', function() {
				var laytpl = layui.laytpl;
				laytpl(sysCustomerListTpl.innerHTML).render(data, function(html) {
					$('#sys-customer-list-body').html(html)
				});
			});
			layui.use('laypage', function() {
				layui.laypage({
					cont: $('#sys-customer-list-body-page'),
					pages: data.totalPage,
					groups: 2,
					curr: data.currentPage,
					skip: true,
					jump: function (obj,first) {
						if(!first){
							currentPageNow = obj.curr;
							initSysCustomerList(obj.curr);
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

$('#sys-customer-form-search').submit(function(e){
	e.preventDefault();
	initSysCustomerList(1);
});

/**
 * 状态修改
 */
$('#sys-customer-list-body').on('click','.btn-sys-customer-states',function(){
	var sysCustomer = {
		sysCustomerId : $(this).attr('sysCustomerId')
	};
	$.ajax({
		url : $api.sysCustomer.updateSysCustomerState,
		type : "POST",
		dataType : "JSON",
		data : {
			"jsonStr" : JSON.stringify(sysCustomer)
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
			initSysCustomerList(currentPageNow);
			layer.close(layerLoad);
		},
		error : function() {
			layer.close(layerLoad);
			layer.msg('网络异常，请稍后再试', {icon: 2});
		}
	});
});

/**
 * 顾客--修改点击
 */
$('#sys-customer-list-body').on('click', '.btn-sys-customer-update', function() {
	$.ajax({
		url : $api.sysCustomer.selectByPrimaryKey,
		type : "POST",
		dataType : "JSON",
		data : {
			"sysCustomerId" : $(this).attr('sysCustomerId')
		},
		beforeSend : function () {
			layerLoad = layer.load();
		},
		success : function(data,e) {
			if(!$checkRemouteStatus(data)){
				layer.close(layerLoad);
				return;
			}
			$('#sysCustomerIdUpdate').val(data.msg.sysCustomer.sysCustomerId);
			if(data.msg.betVehiclesCustomer){
				$('#betVehiclesCustomerIdUpdate').val(data.msg.betVehiclesCustomer.betVehiclesCustomerId);
			}
			$('#sysCustomerTypeUpdate').val(data.msg.sysCustomer.sysCustomerType);
			if(data.msg.betVehiclesCustomer){
				$('#betVehiclesCustomerVehiclesIdUpdate').val(data.msg.betVehiclesCustomer.betVehiclesCustomerVehiclesId);
			}
			$('#sysCustomerNameUpdate').val(data.msg.sysCustomer.sysCustomerName);
			$('#sysCustomerMobileNumberUpdate').val(data.msg.sysCustomer.sysCustomerMobileNumber);
			$('#sysCustomerQqNumberUpdate').val(data.msg.sysCustomer.sysCustomerQqNumber);
			$('#sysCustomerStoreNameUpdate').val(data.msg.sysCustomer.sysCustomerStoreName);
			$('#sysCustomerStoreAddressUpdate').val(data.msg.sysCustomer.sysCustomerStoreAddress);
			if(data.msg.sysCustomer.sysCustomerImgUrl){
				$('#sysCustomerImgUrlUpdate').attr('src',data.fileUrlPre + data.msg.sysCustomer.sysCustomerImgUrl)
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
		title : '顾客信息修改',
		area : 'auto',
		maxWidth : '1000px',
		content : $('#sys-customer-update-model'),
		cancel : function(){
			$('#sys-customer-form-update')[0].reset();
			$('#sysCustomerImgUrlUpdate').attr('src',$assets.headChooseIcon);
		}
	});
});

/**
 * 修改--保存
 */
$('#sys-customer-form-update').submit(function(e){
	e.preventDefault();
	if(!$checkFormVal('#sys-customer-update-form')){
		layer.msg('数据没有填写完整，请检查', {icon: 2});
		return false;
	}
	var sysCustomer = {
		sysCustomerId : $('#sysCustomerIdUpdate').val(),
		sysCustomerType : $('#sysCustomerTypeUpdate').val(),
		sysCustomerName : $('#sysCustomerNameUpdate').val(),
		sysCustomerMobileNumber : $('#sysCustomerMobileNumberUpdate').val(),
		sysCustomerQqNumber : $('#sysCustomerQqNumberUpdate').val(),
		sysCustomerStoreName : $('#sysCustomerStoreNameUpdate').val(),
		sysCustomerStoreAddress : $('#sysCustomerStoreAddressUpdate').val(),
		sysCustomerImgUrl : $('#sysCustomerImgUrlUpdate').attr('src')
	};
	var betVehiclesCustomer = {
		betVehiclesCustomerId : $('#betVehiclesCustomerIdUpdate').val(),
		betVehiclesCustomerVehiclesId : $('#betVehiclesCustomerVehiclesIdUpdate').val()	
	};
	var jsonObj = {
		sysCustomer : sysCustomer,
		betVehiclesCustomer : betVehiclesCustomer
	}
	$.ajax({
		url : $api.sysCustomer.updateSysCustomer,
		type : "POST",
		dataType : "JSON",
		data : {
			"jsonStr" : JSON.stringify(jsonObj)
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
			$('#sys-customer-form-update')[0].reset();
			$('#sysCustomerImgUrlUpdate').attr('src',$assets.headChooseIcon);
			layer.closeAll('page');
			initSysCustomerList(currentPageNow);
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
$('#sysCustomerImgUrlChoose').on('click',function(){
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
	$initCropper('#sysCustomerImgUrl',headImagePopPage);
	//end 裁剪页面
});

/**
 * 修改--图片裁剪
 */
$('body').on('click','#sysCustomerImgUrlUpdateChoose',function(){
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
	$initCropper('#sysCustomerImgUrlUpdate',headImagePopPage);
	//end 裁剪页面
});
