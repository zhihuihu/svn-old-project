/**
 * Created by huzhihui on 2016/11/2.
 */
var layerLoad;

/**
 * 页面初始化加载
 */
(function() {
	initSysCustomerList(1);
	$.fn.datetimepicker.dates['zh-CN'] = {
		    days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
		    daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
		    daysMin:  ["日", "一", "二", "三", "四", "五", "六", "日"],
		    months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
		    monthsShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
		    today: "今日",
		    suffix: [],
		    meridiem: ["上午", "下午"]
	};
})();

/**
 * 列表初始化
 * @param currentPage
 */
$()
function initSysCustomerList(currentPage) {
	var sysCustomer = {
		currentPage : currentPage,
		pageSize : 10,
		searchName : $('#sysCustomerSearchName').val()
	}
	$.ajax({
		url : $api.sysCustomer.selectCustomerOrderByOrderTotal,
		type : "POST",
		dataType : "JSON",
		data : {
			"jsonStr" : JSON.stringify(sysCustomer)
		},
		beforeSend : function() {
			layerLoad = layer.load();
		},
		success : function(data) {
			if (!$checkRemouteStatus(data)) {
				layer.close(layerLoad);
				return;
			}
			layui.use('laytpl', function() {
				var laytpl = layui.laytpl;
				laytpl(sysCustomerListTpl.innerHTML).render(data,
						function(html) {
							$('#sys-customer-list-body').html(html)
						});
			});
			layui.use('laypage', function() {
				layui.laypage({
					cont : $('#sys-customer-list-body-page'),
					pages : data.totalPage,
					groups : 2,
					curr : data.currentPage,
					skip : true,
					jump : function(obj, first) {
						if (!first) {
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

/**
 * 顾客--搜索
 */
$('#sys-customer-form-search').submit(function(e) {
	e.preventDefault();
	initSysCustomerList(1);
});

$('#choose-customer-message').click(function(){
	if($(this).parent().hasClass('choose-customer-normal')){
		$(this).parent().css("height",'350px');
		$('#choose-customer').removeClass('choose-customer-normal');
		$('#choose-customer').addClass('choose-customer-active');
		$('#choose-product-js').css('height','75px');
		$('#choose-product-js').css('padding-top','3px');
	}else{
		$(this).parent().css("overflow",'none');
		$(this).parent().css("height",'50px');
		$('#choose-customer').removeClass('choose-customer-active');
		$('#choose-customer').addClass('choose-customer-normal');
		$('#choose-product-js').css('height','0px');
		$('#choose-product-js').css('padding-top','0px');
	}
});

/**
 * 确定顾客
 */
$('#sys-customer-list-body').on('click','.btn-sys-customer-sure',function(){
	var sysCustomerId = $(this).attr('sysCustomerId');
	var sysCustomerName = $(this).attr('sysCustomerName');
	var sysCustomerImgUrl = $(this).attr('sysCustomerImgUrl');
	if(checkCustomerOwnModelOrder(sysCustomerId)){
		return;
	}
	$('#choose-customer').removeClass('am-hide');
	if($('#choose-customer-id').val() != ''){
		layer.confirm('您是否要切换订单顾客？', {
			btn : [ '确定', '取消' ]
		}, function() {
			if(sysCustomerImgUrl.indexOf('null') == -1){
				$('#choose-customer-img').attr('src',sysCustomerImgUrl);
			}else{
				$('#choose-customer-img').attr('src','../assets/i/head-icon.png');
			}
			$('#choose-customer-id').val(sysCustomerId);
			$('#choose-customer-name').html(sysCustomerName);
			$('#do-not-say-1').collapse('close');
			initProductList(1);
			layer.closeAll('dialog');
		}, function() {
		});
	}else{
		if(sysCustomerImgUrl.indexOf('null') == -1){
			$('#choose-customer-img').attr('src',sysCustomerImgUrl);
		}else{
			$('#choose-customer-img').attr('src','../assets/i/head-icon.png');
		}
		$('#choose-customer-id').val($(this).attr('sysCustomerId'));
		$('#choose-customer-name').html($(this).attr('sysCustomerName'));
		$('#do-not-say-1').collapse('close');
		initProductList(1);
	}
	$('#product-list-tab').removeClass('am-hide');
});

/**
 * 商品列表展示
 * @param currentPage
 */
function initProductList(currentPage){
	var serOrderQuery = {
		currentPage : currentPage,
		pageSize : 30,
		searchName : $('#sysProductSearchName').val()
	}
	$.ajax({
		url : $api.sysProduct.selectSysProductList,
		type : "POST",
		dataType : "JSON",
		data : {
			"jsonStr" : JSON.stringify(serOrderQuery)
		},
		beforeSend : function() {
			layerLoad = layer.load();
		},
		success : function(data) {
			if (!$checkRemouteStatus(data)) {
				layer.close(layerLoad);
				return;
			}
			layui.use('laytpl', function() {
				var laytpl = layui.laytpl;
				laytpl(sysProductListTpl.innerHTML).render(data,
						function(html) {
							$('#product-list-body').html(html)
						});
			});
			layui.use('laypage', function() {
				layui.laypage({
					cont : $('#sys-product-list-body-page'),
					pages : data.totalPage,
					groups : 2,
					curr : data.currentPage,
					skip : true,
					jump : function(obj, first) {
						if (!first) {
							initProductList(obj.curr);
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
 *	购物车添加
 */
$('#product-list-body').on('click','.list-product-sure',function(){
	$(this).removeClass('am-btn-primary');
	$(this).addClass('am-btn-danger');
	var sysProductId = $(this).attr('sysProductId');
	if($('.have-choose-'+$(this).attr('sysProductId')).length != 0){
		layer.msg('你已经添加了该商品',{icon:2});
		return;
	}
	$('#choose-list-total').html(parseInt($('#choose-list-total').html()) + 1);
	var appendHtml = '<div sysProductId="'+sysProductId+'" class="c-product-msg have-choose-'+sysProductId+'"> ' +
		'<table> ' +
		'<tr> ' +
		'<td><acronym class=" c-product-msg-name am-text-truncate c-product-msg-name-'+sysProductId+'" title="'+$('.list-'+sysProductId+'-name').html()+'">'+$('.list-'+sysProductId+'-name').html()+'</acronym></td> ' +
		'<td><input type="text" class="c-product-msg-number c-product-msg-number-already am-form-field c-product-msg-number-'+sysProductId+'" value="'+$('.list-'+sysProductId+'-number').val()+'"></td> ' +
		'<td><input style="border-left: none;border-right: none;" type="text" class="c-product-msg-number c-product-msg-price-already am-form-field c-product-msg-price-'+sysProductId+'" value="'+$('.list-'+sysProductId+'-price').html()+'"></td> ' +
		'<td><div class=" c-product-msg-name am-text-truncate c-product-msg-unitname-'+sysProductId+'">'+$('.list-'+sysProductId+'-unitname').html()+'</div></td> ' +
		'<td><input type="text" class="am-form-field c-product-msg-bz c-product-msg-bz-'+sysProductId+'"></td>' +
		'<td><button  class="am-btn am-btn-secondary am-btn-xs choose-list-btn-delete" sysProductId="'+sysProductId+'"><i class="am-icon-close"></i></button></td> ' +
		'</tr> ' +
		'</table> ' +
		'</div>';
	$('#choose-product-list').append(appendHtml);
});

$('body').on('keyup','.c-product-msg-number-already',function(){
	this.value=this.value.replace(/[^0-9.]/g,'');
});
$('body').on('keyup','.c-product-msg-price-already',function(){
	this.value=this.value.replace(/[^0-9.]/g,'');
});

/**
 * 购物车商品删除
 */
$('#choose-product-list').on('click','.choose-list-btn-delete',function(){
	var sysProductId = $(this).attr('sysProductId');
	$('.have-choose-'+$(this).attr('sysProductId')).remove();
	$('#choose-list-total').html(parseInt($('#choose-list-total').html()) - 1);
	$('.list-product-sure').each(function(){
		if($(this).attr('sysProductId') == sysProductId){
			$(this).removeClass('am-btn-danger');
			$(this).addClass('am-btn-primary');
		}
	});
});

/**
 * 商品搜索
 */
$('#sys-product-form-search').submit(function(e){
	e.preventDefault();
	initProductList(1);
});

$('#product-list-js').on('click',function(){
	var products = [];
	$('.c-product-msg').each(function(index){
		var sysProductId = $(this).attr('sysProductId');
		var prod = {
			sysProductId : sysProductId,
			sysProductCount : $('.c-product-msg-number-' + sysProductId).val(),
			sysProductSalePrice : $('.c-product-msg-price-' + sysProductId).val(),
			betOrderProductUnivalentRemark : $('.c-product-msg-bz-' + sysProductId).val()
		};
		products.push(prod);
	});
	if(products.length <= 0){
		layer.msg('请选择商品后再提交订单',{icon:2});
		return;
	}
	var serOrderParam = {//订单数据创建
		serOrderType : $('#orderType').val(),
		serOrderCustomerId : $('#choose-customer-id').val(),
		products : products
	};
	$.ajax({
		url : $api.order.saveTempSerOrder,
		type : "POST",
		dataType : "JSON",
		data : {
			"jsonStr" : JSON.stringify(serOrderParam)
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
			layer.close(layerLoad);
			setTimeout('window.location.reload();',2000);
		},
		error : function() {
			layer.close(layerLoad);
			layer.msg('网络异常，请稍后再试', {icon: 2});
		}
	});
});

/**
 * 商品搜索
 */
$('#sysProductSearchName').bind('input propertychange', function() {  
	initProductList(1);
});

function getDateStr(AddDayCount) {
	var dd = new Date();
	dd.setDate(dd.getDate()+AddDayCount);//获取AddDayCount天后的日期
	var y = dd.getFullYear();
	var tempMoth = dd.getMonth()+1;
	var m = tempMoth < 10 ? "0" + tempMoth : tempMoth; // 月
	var d = dd.getDate() < 10 ? "0" + dd.getDate() : dd.getDate();
	return y+"-"+m+"-"+d;
}

/**
 * 
 */
$(function() {
	$('#serOrderSendTime').val(getDateStr(1));
	$('#serOrderSendTime').datetimepicker({
		format : 'yyyy-mm-dd',
		pickerPosition : 'top-left',
		autoclose : true,
		language:  'zh-CN',
		minView : 2
	});
});

/**
 * 查询顾客是否有模版订单
 * @param customerId
 */
function checkCustomerOwnModelOrder(serOrderCustomerId){
	var state = false;//
	var serOrderParam = {
		'serOrderCustomerId':serOrderCustomerId	
	};
	$.ajax({
		url : $api.order.judgeTempIsExist,
		type : "POST",
		dataType : "JSON",
		async: false,
		data : {
			"jsonStr" : JSON.stringify(serOrderParam)
		},
		beforeSend : function () {
			layerLoad = layer.load();
		},
		success : function(data) {
			if(!$checkRemouteStatus(data)){
				layer.close(layerLoad);
				return;
			}
			layer.close(layerLoad);
			if(data.msg.length > 6){//代表存在了模版订单
				state = true;
				layer.open({
					type : 1,
					title : '订单信息详情',
					area : 'auto',
					maxWidth : '1000px',
					content : $('#order-model-update'),
					cancel : function(){
						//initOrderList(1);
					}
				});
				initOderDetails(data.msg);
			}
		},
		error : function() {
			layer.close(layerLoad);
			layer.msg('网络异常，请稍后再试', {icon: 2});
		}
	});
	return state;
};

/**
 * 单条订单详情查询--
 * @param serOrderNumber
 */
function initOderDetails(serOrderNumber){
	var serOrder = {
		serOrderNumber : serOrderNumber
	}
	$('#order-add-product').attr('serOrderNumber',serOrderNumber);
	$.ajax({
		url : $api.order.selectOrderByOrderNumber,
		type : "POST",
		dataType : "JSON",
		data : {
			jsonStr : JSON.stringify(serOrder)
		},
		beforeSend : function () {
			layerLoad = layer.load();
		},
		success : function(data) {
			if(!$checkRemouteStatus(data)){
				layer.close(layerLoad);
				return;
			}
			layer.close(layerLoad);
			layui.use('laytpl', function() {
				var laytpl = layui.laytpl;
				laytpl(sysOrderDetailListTpl.innerHTML).render(data, function(html) {
					$('#update-product-list-body').html(html)
				});
			});
		},
		error : function() {
			layer.close(layerLoad);
			layer.msg('网络异常，请稍后再试', {icon: 2});
		}
	});
};

/**
 * 订单详情中的价格数量修改
 */
$('#update-product-list-body').on('click','.btn-order-list-update',function(){
	var betOrderProductId = $(this).attr('betOrderProductId');
	var serOrderParam = {
		orderNumber : $(this).attr('serOrderNumber'),
		betOrderProductId : betOrderProductId,
		updatePrice : $('.update-order-product-price-'+betOrderProductId).val(),
		betOrderProductProductCount : $('.update-order-product-number-'+betOrderProductId).val()
	};
	$.ajax({
		url : $api.order.updateProductSalePriceByOrderNumber,
		type : "POST",
		dataType : "JSON",
		data : {
			jsonStr : JSON.stringify(serOrderParam)
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
			layer.close(layerLoad);
		},
		error : function() {
			layer.close(layerLoad);
			layer.msg('网络异常，请稍后再试', {icon: 2});
		}
	});
});

/**
 * 订单详情中的--一条商品的删除
 */
$('#update-product-list-body').on('click','.btn-order-list-delete',function(){
	var betOrderProductId = $(this).attr('betOrderProductId');
	layer.confirm('您是否要删除该商品？', {
		btn: ['确定','取消'] //按钮
	}, function(){
		$.ajax({
			url : $api.order.deleteProductForOrder,
			type : "POST",
			dataType : "JSON",
			data : {
				betOrderProductId : betOrderProductId
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
				layer.close(layerLoad);
				$('.order-detail-tr-'+betOrderProductId).remove();
			},
			error : function() {
				layer.close(layerLoad);
				layer.msg('网络异常，请稍后再试', {icon: 2});
			}
		});
	}, function(){
	});
});

/**
 * 订单详情--统一点击修改价格数量
 */
$('body').on('click','#order-update-one',function(){
	var serOrderNumber = $(this).attr('serOrderNumber');
	layer.confirm('您是否要统一修改？', {
		btn: ['确定','取消'] //按钮
	}, function(){
		var betOrderProducts = [];
		$('.order-detail-tr').each(function(){
			var betOrderProductId = $(this).attr('betOrderProductId');
			var betOrderProduct = {
				betOrderProductId : betOrderProductId,
				betOrderProductProductCount : $('.update-order-product-number-'+ betOrderProductId).val(),
				betOrderProductProductSalePrice : $('.update-order-product-price-'+ betOrderProductId).val(),
				betOrderProductOrderNumber : serOrderNumber,
				betOrderProductUnivalentRemark : $('.update-order-product-bz-'+ betOrderProductId).val()
			};
			betOrderProducts.push(betOrderProduct);
		});
		var serOrderParam = {
			orderNumber : serOrderNumber,
			betOrderProducts : betOrderProducts
		};
		$.ajax({
			url : $api.order.updateSerTempOrder,
			type : "POST",
			dataType : "JSON",
			data : {
				jsonStr : JSON.stringify(serOrderParam)
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
				layer.close(layerLoad);
			},
			error : function() {
				layer.close(layerLoad);
				layer.msg('网络异常，请稍后再试', {icon: 2});
			}
		});
	}, function(){

	});
});

/**
 * 订单详情--点击增加商品
 */
$('body').on('click','#order-add-product',function(){
	var serOrderNumber=$(this).attr('serOrderNumber');
	var sysProductQuery = {
		orderNumber : serOrderNumber,
		currentPage : 1,
		pageSize : 50,
		searchName : $('#orderAddSearchName').val()
	}
	$.ajax({
		url : $api.sysProduct.productsListForOrderDetails,
		type : "POST",
		dataType : "JSON",
		data : {
			jsonStr : JSON.stringify(sysProductQuery)
		},
		beforeSend : function () {
			layerLoad = layer.load();
		},
		success : function(data) {
			if(!$checkRemouteStatus(data)){
				layer.close(layerLoad);
				return;
			}
			layer.close(layerLoad);
			layui.use('laytpl', function() {
				var laytpl = layui.laytpl;
				laytpl(orderAddProductListTpl.innerHTML).render(data, function(html) {
					$('#order-add-product-list-body').html(html)
				});
			});
			layer.open({
				type : 1,
				title : '订单--增加商品',
				area : 'auto',
				maxWidth : '1000px',
				content : $('#order-add-product-model'),
				cancel : function(){
					initOderDetails(serOrderNumber);
				}
			});
		},
		error : function() {
			layer.close(layerLoad);
			layer.msg('网络异常，请稍后再试', {icon: 2});
		}
	});
});

/**
 * 订单详情--添加商品--列表初始化
 */
function initOderAddProduct(serOrderNumber){
	var sysProductQuery = {
		orderNumber : serOrderNumber,
		currentPage : 1,
		pageSize : 50,
		searchName : $('#orderAddSearchName').val()
	}
	$.ajax({
		url : $api.sysProduct.productsListForOrderDetails,
		type : "POST",
		dataType : "JSON",
		data : {
			jsonStr : JSON.stringify(sysProductQuery)
		},
		beforeSend : function () {
			layerLoad = layer.load();
		},
		success : function(data) {
			if(!$checkRemouteStatus(data)){
				layer.close(layerLoad);
				return;
			}
			layer.close(layerLoad);
			layui.use('laytpl', function() {
				var laytpl = layui.laytpl;
				laytpl(orderAddProductListTpl.innerHTML).render(data, function(html) {
					$('#order-add-product-list-body').html(html)
				});
			});
		},
		error : function() {
			layer.close(layerLoad);
			layer.msg('网络异常，请稍后再试', {icon: 2});
		}
	});
};
/**
 * 订单详情--添加商品确定按钮
 */
$('body').on('click','.order-add-product-add-btn',function(){
	var sysProductId = $(this).attr('sysProductId');
	var orderNumber = $('#order-add-product').attr('serOrderNumber');
	var serOrderParam = {
		orderNumber : orderNumber,
		sysProductId : sysProductId,
		updatePrice : $('.order-add-product-price-'+ sysProductId).val(),
		betOrderProductProductCount : $('.order-add-product-number-' + sysProductId).val()
	};
	$.ajax({
		url : $api.order.insertProductForTempOrder,
		type : "POST",
		dataType : "JSON",
		data : {
			jsonStr : JSON.stringify(serOrderParam)
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
			$('.order-add-list-tr-'+ sysProductId).remove();
			layer.close(layerLoad);
		},
		error : function() {
			layer.close(layerLoad);
			layer.msg('网络异常，请稍后再试', {icon: 2});
		}
	});
});

/**
 * 订单详情--添加商品--商品搜索
 */
$('#order-add-product-search').submit(function(e){
	e.preventDefault();
	initOderAddProduct($('#order-add-product').attr('serOrderNumber'));
});
/**
 * 订单详情--添加商品--商品搜索
 */
$('#orderAddSearchName').bind('input propertychange', function() {
	initOderAddProduct($('#order-add-product').attr('serOrderNumber'));
});