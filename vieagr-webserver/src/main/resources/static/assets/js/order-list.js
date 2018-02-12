$(function(){
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
	
	$('#serOrderSendTime').datetimepicker({
		language:  'zh-CN',
		format : 'yyyy-mm-dd',
		autoclose : true,
		minView : 2
	});
	setTomorrowDateForOrderList();
	var layerLoad;

	/**
	 * 全选--订单
	 */
	$('#choose-all-check').on('click',function(){
		var flg = false;
		$('.order-checkbox-flg').each(function(index){
			flg = $(this).is(':checked');
			if(flg == false){
				return false;
			}
		});
		if(flg == false){
			$('#total-price-update').css('bottom','-1px');
			$('.order-checkbox-flg').each(function(index){
				if(!$(this).is(':checked')){
					$('#total-price-update-number').html(parseInt($('#total-price-update-number').html()) + 1);
					$(this).prop('checked',true);
				}
			});
		}else{
			$('#total-price-update').css('bottom','-41px');
			$('.order-checkbox-flg').prop('checked',false);
			$('#total-price-update-number').html('0');
		}


	});


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
				optionHtml = '' + optionHtml;
				$('#sysVehiclesId').append(optionHtml);
				layer.close(layerLoad);
			},
			error : function() {
				layer.close(layerLoad);
				layer.msg('网络异常，请稍后再试', {icon: 2});
			}
		});
	};
	initSysVehiclesList();
	//执行--订单列表初始化
	//initOrderList(1);

	/**
	 * 列表初始化
	 * @param currentPage
	 */
	function initOrderList(currentPage){
		$('#total-price-update-number').html('0');
		$('#total-price-update').css('bottom','-41px');
		var serOrder = {
			currentPage : currentPage,
			pageSize : 20,
			sysVehiclesId : $('#sysVehiclesId').val(),
			serOrderType : $('#serOrderType').val(),
			serOrderState : $('#orderState').val(),
			orderSendTime : $('#serOrderSendTime').val(),
			searchName: $('#sysOrderListSearchName').val()
		}
		$.ajax({
			url : $api.order.selectSerOrderList,
			type : "POST",
			dataType : "JSON",
			data : {
				"jsonStr" : JSON.stringify(serOrder)
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
					laytpl(sysOrderListTpl.innerHTML).render(data, function(html) {
						$('#sys-order-list-body').html(html)
					});
				});
				layui.use('laypage', function() {
					layui.laypage({
						cont: $('#sys-order-list-body-page'),
						pages: data.totalPage,
						groups: 2,
						curr: data.currentPage,
						skip: true,
						jump: function (obj,first) {
							if(!first){
								initOrderList(obj.curr);
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
	 * 订单状态枚举查询
	 */
	function initOrderState(){
		$.ajax({
			url : $api.order.selectOrderStates,
			type : "POST",
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
				var appendHtml = '';
				for(var i=0;i<data.msg.length;i++){
					appendHtml +='<option value="'+data.msg[i].key+'">'+data.msg[i].value+'</option>';
				}
				$('#orderState').html(appendHtml);
				$('#orderState').val(2);
				//执行列表查询
				initOrderList(1);
			},
			error : function() {
				layer.close(layerLoad);
				layer.msg('网络异常，请稍后再试', {icon: 2});
			}
		});
	};
	initOrderState();

	/**
	 * 订单类型查询
	 */
	function initOrderType(){
		$.ajax({
			url : $api.order.selectOrderTypes,
			type : "POST",
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
				var appendHtml = '';
				for(var i=0;i<data.msg.length;i++){
					appendHtml +='<option value="'+data.msg[i].key+'">'+data.msg[i].value+'</option>';
				}
				$('#serOrderType').html(appendHtml);
			},
			error : function() {
				layer.close(layerLoad);
				layer.msg('网络异常，请稍后再试', {icon: 2});
			}
		});
	};
	initOrderType();
	/**
	 * 搜索
	 */
	$('#sys-order-list-search-form').submit(function(e){
		e.preventDefault();
		initOrderList(1);
	});

	/**
	 * 取消订单
	 */
	$('#sys-order-list-body').on('click','.btn-order-list-cancel',function(){
		var serOrderNumber=$(this).attr('serOrderNumber');
		var serOrder = {
			serOrderNumber : serOrderNumber
		}
		layer.confirm('您是否要取消该订单？', {
			btn: ['确定','取消'] //按钮
		}, function(){
			$.ajax({
				url : $api.order.cacelOrderByOrderNumber,
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
					layer.msg(data.msg, {icon: 1});
					initOrderList(1);
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
	 * 点击完成订单
	 */
	$('#sys-order-list-body').on('click','.btn-order-list-complete',function(){
		var serOrderNumber=$(this).attr('serOrderNumber');
		var serOrder = {
			serOrderNumber : serOrderNumber
		}
		layer.confirm('您是否要完成该订单？', {
			btn: ['确定','取消'] //按钮
		}, function(){
			$.ajax({
				url : $api.order.completeOrder,
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
					layer.msg(data.msg, {icon: 1});
					initOrderList(1);
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
	 * 订单详情查询
	 */
	$('#sys-order-list-body').on('click','.btn-order-list-detail',function(){
		var flg = false;

		$('.order-checkbox-flg').each(function(index){
			flg = $(this).is(':checked');
			if(flg == true){
				return false;
			}
		});
		if(flg == true){
			layer.msg('请点击统一修改价格按钮修改',{icon:2});
			return;
		}
		var serOrderNumber=$(this).attr('serOrderNumber');
		var serOrder = {
			serOrderNumber : serOrderNumber
		}
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
				$('#order-update-one').attr('serOrderNumber',data.msg.serOrder.serOrderNumber);
				$('#order-add-product').attr('serOrderNumber',data.msg.serOrder.serOrderNumber);
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
			},
			error : function() {
				layer.close(layerLoad);
				layer.msg('网络异常，请稍后再试', {icon: 2});
			}
		});
	});

	/**
	 * 单条订单详情查询--
	 * @param serOrderNumber
     */
	function initOderDetails(serOrderNumber){
		var serOrder = {
			serOrderNumber : serOrderNumber
		}
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
	}

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
				url : $api.order.unifiedUpdateProductSalePriceForOneOrder,
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
			url : $api.order.insertProductForOrderDetails,
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


	//checkbox 列表的选中事件
	$('body').on('change','.order-checkbox-flg',function(){
		var flg = false;
		$('.order-checkbox-flg').each(function(index){
			flg = $(this).is(':checked');
			if(flg == true){
				return false;
			}
		});
		if(flg == true){
			$('#total-price-update').css('bottom','-1px');
		}else{
			$('#total-price-update').css('bottom','-41px');
		}
		if($(this).is(':checked')){
			$('#total-price-update-number').html(parseInt($('#total-price-update-number').html()) + 1);
		}else{
			$('#total-price-update-number').html(parseInt($('#total-price-update-number').html()) - 1);
		}
	});

	/**
	 * 多订单--修改价格弹框打开
	 */
	$('#total-price-update-btn').on('click',function(){
		var orderNumbers = [];
		$('.order-checkbox-flg').each(function(index){
			if($(this).is(':checked')){
				orderNumbers.push($(this).attr('serOrderNumber'));
			}
		});
		var serOrderQuery = {
			orderNumbers : orderNumbers
		}
		$.ajax({
			url : $api.order.updateManyOrderProductPriceForSelectList,
			type : "POST",
			dataType : "JSON",
			data : {
				jsonStr : JSON.stringify(serOrderQuery)
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
					laytpl(sysAllOrderDetailListTpl.innerHTML).render(data, function(html) {
						$('#all-update-product-list-body').html(html)
					});
				});
				layer.open({
					type : 1,
					title : '订单信息详情',
					area : 'auto',
					maxWidth : '1000px',
					content : $('#all-order-model-update'),
					cancel : function(){
						//initOrderList(1);
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
	 * 多订单--统一修改价格
	 */
	$('body').on('click','.all-btn-order-list-update',function(){
		var betOrderProductProductId = $(this).attr('betOrderProductProductId');
		var price = $('.all-update-order-product-price-' + betOrderProductProductId).val();
		var orderNumbers = [];
		$('.order-checkbox-flg').each(function(index){
			if($(this).is(':checked')){
				orderNumbers.push($(this).attr('serOrderNumber'));
			}
		});
		var serOrderParam = {
			sysProductId : betOrderProductProductId,
			updatePrice : price,
			orderNumbers : orderNumbers
		};
		$.ajax({
			url : $api.order.updateProductSalePrice,
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
	 * 多订单--统一修改全部价格
	 */
	$('body').on('click','#order-update-many',function(){
		layer.confirm('您是否要统一修改价格？', {
			btn: ['确定','取消'] //按钮
		}, function(){
			updateAllOrderProductPrice();
		}, function(){

		});
	});

	/**
	 * 多条订单多个商品统一修改多个商品价格
	 */
	function updateAllOrderProductPrice(){
		var orderNumbers = [];
		$('.order-checkbox-flg').each(function(index){
			if($(this).is(':checked')){
				orderNumbers.push($(this).attr('serOrderNumber'));
			}
		});
		var productIds = [];
		$('.many-order-list-tr').each(function(){
			productIds.push($(this).attr('betOrderProductProductId'));
		});
		var products = [];
		for(var i=0;i<productIds.length;i++){
			var betOrderProduct = {
				sysProductId : productIds[i],
				sysProductSalePrice : $('.all-update-order-product-price-' + productIds[i]).val()
			};
			products.push(betOrderProduct);
		}
		var serOrderParam = {
			orderNumbers : orderNumbers,
			products : products
		};
		$.ajax({
			url : $api.order.updateProductPriceForProductsAndOrders,
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
	};














	/**
	 * 订单详情的打印
	 */
	$('body').on('click','.btn-order-list-print',function(){
		var serOrderParam = {
			orderNumber : $(this).attr('serordernumber')
		};
		$.ajax({
			url : $api.order.readOrderDetailsForStamp,
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
				layer.close(layerLoad);
				var appendHtml = '';
                printOrderDetails(data.msg);
			},
			error : function() {
				layer.close(layerLoad);
				layer.msg('网络异常，请稍后再试', {icon: 2});
			}
		});

	});
	
	/**
	 * 全部打印
	 */
	$('#order-print-all').on('click',function(){
		var orderNumbers = [];
		$('.order-checkbox-flg').each(function(index){
			orderNumbers.push($(this).attr('serordernumber'));
		});
		var serOrderParam = {
			orderNumbers : orderNumbers
		};
		$.ajax({
			url : $api.order.readOrderDetailsListForStamp,
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
                $('#print-parent').html('');
				var appendHtml = '';
				var height = 0;
				for(var i=0;i<data.msg.length;i++){
                    height += parseInt(printOrderDetailsMore(data.msg[i]).substring(0,3));
				}
                layer.close(layerLoad);
                printTable('万象物流送货单打印',height + 'mm');
			},
			error : function() {
				layer.close(layerLoad);
				layer.msg('网络异常，请稍后再试', {icon: 2});
			}
		});
	});

    /**
	 * 无预览直接打印
     * @param data
     */
	function printOrderDetails(data){
        var appendHtmlPre = '';
        var height = '';
        if(data.products.length <= 16){
            appendHtmlPre = '<div class="print-div" style="height: 120mm; overflow: hidden"> ';
            height = '140mm';
		}else if(data.products.length <= 42){
            appendHtmlPre = '<div class="print-div" style="height: 260mm;"> ';
            height = '280mm';
		}else{
            appendHtmlPre = '<div class="print-div" style="height: 400mm;"> ';
            height = '420mm';
		}
		appendHtmlPre = appendHtmlPre +
			'<div class="print-div-header">四川万象农业有限公司--送货单</div> ' +
			'<div class="print-div-tele">配送电话：15202848939</div>'+
			'<div class="print-div-title"> ' +
			'<div class="print-div-title-left">客户名称：'+data.serOrder.sysCustomerName+'</div> ' +
			'<div class="print-div-title-right">送货日期：'+data.serOrder.serOrderSendTime+'</div> ' +
			'</div> ' +
			'<div class="print-div-table"><table class="print-table">' +
			'<thead> ' +
			'<tr> ' +
			'<th class="print-table-xh">序号</th> ' +
			'<th class="print-table-product-name">商品名</th> ' +
			'<th class="print-table-product-number">数量</th> ' +
			'<th class="print-table-product-price">单价（元）</th> ' +
			'<th class="print-table-product-total">金额（元）</th> ' +
			'<th class="print-table-product-bz">备注</th> ' +
			'</tr> ' +
			'</thead> ' +
			'<tbody>';
		var appendHtmlCenter = '';
        $.each(data.products,function(index,value){
            appendHtmlCenter += '<tr> ' +
                '<td>'+ (parseInt(index)+1) +'</td> ' +
                '<td>'+ value.betOrderProductProductName +'</td> ' +
                '<td>'+ value.betOrderProductProductCount +'（'+ value.betOrderProductProductUnitName +'）</td> ' +
                '<td>'+ value.betOrderProductProductSalePrice +'</td> ' +
                '<td>'+ value.betOrderProductProductTotal +'</td> ' +
                '<td></td> ' +
                '</tr> ';
        });

		var appendHtmlAfter = '</tbody> ' +
			'</table> ' +
			'</div> ' +
			'<div class="print-div-footer"> ' +
			'<div class="print-div-footer-money">合计金额：'+data.orderTotalPrice+'（元）</div> ' +
			'<div class="print-div-footer-div">送货人：<span style="font-size: 16px; font-weight: bold;">梁沅</span></div> ' +
			'<div class="print-div-footer-div">财务部：</div> ' +
			'<div class="print-div-footer-div">收货人：</div> ' +
			'</div> ' +
			'</div>';
		var appendHtml = appendHtmlPre + appendHtmlCenter + appendHtmlAfter;
		$('#print-parent').html(appendHtml);
        printTable('万象物流送货单打印',height);
	}

    /**
	 * 多订单打印
     * @param data
     */
	function printOrderDetailsMore(data){
        var appendHtmlPre = '';
        var height = '';
        if(data.products.length <= 16){
            appendHtmlPre = '<div class="print-div" style="height: 120mm;"> ';
            height = '140mm';
        }else if(data.products.length <= 42){
            appendHtmlPre = '<div class="print-div" style="height: 260mm;"> ';
            height = '280mm';
        }else{
            appendHtmlPre = '<div class="print-div" style="height: 400mm;"> ';
            height = '420mm';
        }
        appendHtmlPre = appendHtmlPre +
            '<div class="print-div-header">四川万象农业有限公司--送货单</div> ' +
            '<div class="print-div-tele">配送电话：15202848939</div>'+
            '<div class="print-div-title"> ' +
            '<div class="print-div-title-left">客户名称：'+data.serOrder.sysCustomerName+'</div> ' +
            '<div class="print-div-title-right">送货日期：'+data.serOrder.serOrderSendTime+'</div> ' +
            '</div> ' +
            '<div class="print-div-table"><table class="print-table">' +
            '<thead> ' +
            '<tr> ' +
            '<th class="print-table-xh">序号</th> ' +
            '<th class="print-table-product-name">商品名</th> ' +
            '<th class="print-table-product-number">数量</th> ' +
            '<th class="print-table-product-price">单价（元）</th> ' +
            '<th class="print-table-product-total">金额（元）</th> ' +
            '<th class="print-table-product-bz">备注</th> ' +
            '</tr> ' +
            '</thead> ' +
            '<tbody>';
        var appendHtmlCenter = '';
        $.each(data.products,function(index,value){
            appendHtmlCenter += '<tr> ' +
                '<td>'+ (parseInt(index)+1) +'</td> ' +
                '<td>'+ value.betOrderProductProductName +'</td> ' +
                '<td>'+ value.betOrderProductProductCount +'（'+ value.betOrderProductProductUnitName +'）</td> ' +
                '<td>'+ value.betOrderProductProductSalePrice +'</td> ' +
                '<td>'+ value.betOrderProductProductTotal +'</td> ' +
				'<td></td> ' +
                '</tr> ';
        });

        var appendHtmlAfter = '</tbody> ' +
            '</table> ' +
            '</div> ' +
            '<div class="print-div-footer"> ' +
            '<div class="print-div-footer-money">合计金额：'+data.orderTotalPrice+'（元）</div> ' +
            '<div class="print-div-footer-div">送货人：<span style="font-size: 16px; font-weight: bold;">梁沅</span></div> ' +
            '<div class="print-div-footer-div">财务部：</div> ' +
            '<div class="print-div-footer-div">收货人：</div> ' +
            '</div> ' +
            '</div>';
        var appendHtml = appendHtmlPre + appendHtmlCenter + appendHtmlAfter;
        $('#print-parent').append(appendHtml);
        return height;
	}
	

	/** （'+ data.serOrder.serOrderTypeName+'）
	 * 普通打印 行数<=25
	 * @param data
     */
	function addNormalPrint(data){
		var appendHtmlPre = '<div class="order-print"> ' +
			'<div class="order-print-header"> ' +
			'<p>四川万象农业有限公司--送货单</p> ' +
			'</div> ' +
			'<div class="order-print-title"> ' +
			'<div class="am-fl"> ' +
			'<p>客户名称：'+data.serOrder.sysCustomerName+'</p> ' +
			'</div> ' +
			'<div class="am-fr"> ' +
			'<p>送货日期：'+data.serOrder.serOrderSendTime+'</p> ' +
			'</div> ' +
			'<div style="clear: both;"></div> ' +
			'</div> ' +
			'<div class="order-print-table"> ' +
			'<table class="am-order-print-table"> ' +
			'<thead> ' +
			'<tr> ' +
			'<th class="am-table-xh">序号</th> ' +
			'<th class="am-table-product-name">商品名</th> ' +
			'<th class="am-table-product-number">数量</th> ' +
			'<th class="am-table-product-price">单价（元）</th> ' +
			'<th class="am-table-product-total">金额（元）</th> ' +
			'<th class="am-table-product-bz">备注</th> ' +
			'</tr> ' +
			'</thead> ' +
			'<tbody class="order-print-table-body"> ';
		var appendHtmlCenter = '';
		$.each(data.products,function(index,value){
			appendHtmlCenter += '<tr> ' +
				'<td>'+ (parseInt(index)+1) +'</td> ' +
				'<td>'+ value.betOrderProductProductName +'</td> ' +
				'<td>'+ value.betOrderProductProductCount +'（'+ value.betOrderProductProductUnitName +'）</td> ' +
				'<td>'+ value.betOrderProductProductSalePrice +'</td> ' +
				'<td>'+ value.betOrderProductProductTotal +'</td> ' +
				'<td></td> ' +
				'</tr> ';
		});
		var appendHtmlAfter = '</tbody> ' +
			'<!--修改的商品的列表显示--> ' +
			'</table> ' +
			'</div> ' +
			'<div class="order-print-footer am-g"> ' +
			'<div class="order-print-footer-div-money">合计金额：'+data.orderTotalPrice+'（元）</div> ' +
			'<div class="order-print-footer-div">送货人：</div> ' +
			'<div class="order-print-footer-div">财务部：</div> ' +
			'<div class="order-print-footer-div">收货人：</div> ' +
			/*'<div class="print-boss"><img src="../assets/i/boss.png"></div>' +*/
			'<div style="clear: both;"></div> ' +
			'</div> ' +
			'</div>';
		var appendHtml = appendHtmlPre + appendHtmlCenter + appendHtmlAfter;
		return appendHtml;
	};

	/**
	 * 多页打印 行数>25
	 * @param data
     */
	function addLongPrint(data){
		var appendHtmlPre = '<div class="order-print"> ' +
			'<div class="order-print-header"> ' +
			'<p>四川万象农业有限公司--送货单</p> ' +
			'</div> ' +
			'<div class="order-print-title"> ' +
			'<div class="am-fl"> ' +
			'<p>客户名称：'+data.serOrder.sysCustomerName+'</p> ' +
			'</div> ' +
			'<div class="am-fr"> ' +
			'<p>送货日期：'+data.serOrder.serOrderSendTime+'</p> ' +
			'</div> ' +
			'<div style="clear: both;"></div> ' +
			'</div> ' +
			'<div class="order-print-table"> ' +
			'<table class="am-order-print-table"> ' +
			'<thead> ' +
			'<tr> ' +
			'<th class="am-table-xh">序号</th> ' +
			'<th class="am-table-product-name">商品名</th> ' +
			'<th class="am-table-product-number">数量</th> ' +
			'<th class="am-table-product-price">单价（元）</th> ' +
			'<th class="am-table-product-total">金额（元）</th> ' +
			'<th class="am-table-product-bz">备注</th> ' +
			'</tr> ' +
			'</thead> ' +
			'<tbody class="order-print-table-body"> ';
		var appendHtmlCenter = [];
		var times = 0;
		if(data.products.length <=40){
			times = 2;
		}else{
			times = parseInt((data.products.length-40)%23 == 0 ? (data.products.length-40)/23 : (data.products.length-40)/23 + 1) + 2;
		}
		for(var i=0;i<times;i++){
			appendHtmlCenter[i] = '';
		}
		$.each(data.products,function(index,value){
			if(index<20){
				appendHtmlCenter[0] += '<tr> ' +
					'<td class="am-table-xh">'+ (parseInt(index)+1) +'</td> ' +
					'<td class="am-table-product-name">'+ value.betOrderProductProductName +'</td> ' +
					'<td class="am-table-product-number">'+ value.betOrderProductProductCount +'（'+ value.betOrderProductProductUnitName +'）</td> ' +
					'<td class="am-table-product-price">'+ value.betOrderProductProductSalePrice +'</td> ' +
					'<td class="am-table-product-total">'+ value.betOrderProductProductTotal +'</td> ' +
					'<td class="am-table-product-bz"></td> ' +
					'</tr> ';
			}else if(times > 2 && parseInt((index-20)/23) +1 < times){
				appendHtmlCenter[parseInt((index-20)/23) +1] += '<tr> ' +
					'<td class="am-table-xh">'+ (parseInt(index)+1) +'</td> ' +
					'<td class="am-table-product-name">'+ value.betOrderProductProductName +'</td> ' +
					'<td class="am-table-product-number">'+ value.betOrderProductProductCount +'（'+ value.betOrderProductProductUnitName +'）</td> ' +
					'<td class="am-table-product-price">'+ value.betOrderProductProductSalePrice +'</td> ' +
					'<td class="am-table-product-total">'+ value.betOrderProductProductTotal +'</td> ' +
					'<td class="am-table-product-bz"></td> ' +
					'</tr> ';
			}else{
				appendHtmlCenter[times-1] += '<tr> ' +
					'<td class="am-table-xh">'+ (parseInt(index)+1) +'</td> ' +
					'<td class="am-table-product-name">'+ value.betOrderProductProductName +'</td> ' +
					'<td class="am-table-product-number">'+ value.betOrderProductProductCount +'（'+ value.betOrderProductProductUnitName +'）</td> ' +
					'<td class="am-table-product-price">'+ value.betOrderProductProductSalePrice +'</td> ' +
					'<td class="am-table-product-total">'+ value.betOrderProductProductTotal +'</td> ' +
					'<td class="am-table-product-bz"></td> ' +
					'</tr> ';
			}
		});
		var appendHtmlCenterPre = '<div class="order-print order-print-center-pre"> ' +
		'<div class="order-print-table"> ' +
		'<table class="am-order-print-table"> ' +
		/*'<thead> ' +
		'<tr> ' +
		'<th class="am-table-xh">序号</th> ' +
		'<th class="am-table-product-name">商品名</th> ' +
		'<th class="am-table-product-number">数量</th> ' +
		'<th class="am-table-product-price">单价（元）</th> ' +
		'<th class="am-table-product-total">金额（元）</th> ' +
		'<th class="am-table-product-bz">备注</th> ' +
		'</tr> ' +
		'</thead> ' +*/
		'<tbody class="order-print-table-body"> ';
		var appendHtmlAfter = '</tbody> ' +
			'<!--修改的商品的列表显示--> ' +
			'</table> ' +
			'</div> ' +
			'</div>';
		var appendHtmlAfterEnd = '</tbody> ' +
		'<!--修改的商品的列表显示--> ' +
		'</table> ' +
		'</div> ' +
		'<div class="order-print-footer am-g"> ' +
		'<div class="order-print-footer-div-money">合计金额：'+data.orderTotalPrice+'（元）</div> ' +
		'<div class="order-print-footer-div">送货人：</div> ' +
		'<div class="order-print-footer-div">财务部：</div> ' +
		'<div class="order-print-footer-div">收货人：</div> ' +
		/*'<div class="print-boss"><img src="../assets/i/boss.png"></div>' +*/
		'<div style="clear: both;"></div> ' +
		'</div> ' +
		'</div>';
		for(var i=0;i<times;i++){
			if(i==0){
				appendHtmlCenter[i] = appendHtmlPre + appendHtmlCenter[i] + appendHtmlAfter;
			}else if(i==times-1){
				appendHtmlCenter[i] = appendHtmlCenterPre + appendHtmlCenter[i] + appendHtmlAfterEnd;
			}else{
				appendHtmlCenter[i] = appendHtmlCenterPre + appendHtmlCenter[i] + appendHtmlAfter;
			}
		}
		var appendHtml = '';
		for(var i=0;i<appendHtmlCenter.length;i++){
			appendHtml += appendHtmlCenter[i];
		}
		return appendHtml;
	};
	
	/**
	 * 订单列表导出电子送货单
	 */
	$("#sys-order-list-body").on("click", "a", function(){
		$("#send-order-number").val($(this).attr("serordernumber"));
		$("#down-send-order-excel").attr("action", $api.index.downLoadSendOrderExcel).submit();
	});
	
});

/**
 * 设置订单默认送货时间为明天
 * @returns
 */
function setTomorrowDateForOrderList(){
	var date = new Date(); 
	date.setDate(date.getDate()+1);//当前日期+几天 
	var year = date.getFullYear(); // 年
	var tempMoth = date.getMonth()+1;
	var month = tempMoth < 10 ? "0" + tempMoth : tempMoth; // 月
	var day = date.getDate() < 10 ? "0" + date.getDate() : date.getDate(); // 日
	$("#serOrderSendTime").val(year + "-" + month + "-" + day);
}

function aaaaaaa(a){
	console.debug(a);
}