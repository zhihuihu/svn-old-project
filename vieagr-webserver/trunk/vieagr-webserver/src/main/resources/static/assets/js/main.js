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
	classiFicationGetCount();
	getToDayOrderInfo(1);
	showChartForOrderTotal();
	
	$('#order-send-time').datetimepicker({
		language:  'zh-CN',
		format : 'yyyy-mm-dd',
		autoclose : true,
		minView : 2
	});
    $('#customer-expost-month').datetimepicker({
        language:  'zh-CN',
        format : 'yyyy-mm',
        autoclose : true,
        startView : 3,
        minView : 3
    });
    $('#customer-expost-date-start').datetimepicker({
        language:  'zh-CN',
        format : 'yyyy-mm-dd',
        autoclose : true,
        minView : 2
    });
    $('#customer-expost-date-end').datetimepicker({
        language:  'zh-CN',
        format : 'yyyy-mm-dd',
        autoclose : true,
        minView : 2
    });
	
	getTomorrowDateForExcel();
	/**
	 * 汇总单下载
	 * 分拣单下载
	 */
	$("#summary-order-download, #sorting-order-download").on("click", function(){
		if($("#order-send-time").val().length <= 0){
			layer.tips('请选择送货日期', $(this));
			return;
		}
		$.AMUI.progress.configure({ ease: 'ease', speed: 500});
		var progress = $.AMUI.progress;
		progress.start();
		var downloadExcelForm = $("#download-excel-form");
		var orderType = $(this).attr("excel-type");
		$("#excel-type").val(orderType);
		if(orderType == "summaryOrder"){
			$("#sys-vehicles-id").val($("#summarySysVehiclesId").val());
		}else{
			$("#sys-vehicles-id").val($("#sortingSysVehiclesId").val());
		}
		
		downloadExcelForm.attr("action", $api.index.downLoadExcelForSysOrder);
		downloadExcelForm.submit();
		progress.done();
	});

	//
    $('#customer-export-tab').tabs();

    //按照月份导出顾客购买详情
	$('#customerExportMonth').on('click',function(){
		if($('#customer-expost-month').val().length <= 0){
            layer.msg('请选择导出月份', {icon: 2});
            return;
		}
		if($('#customer-choose-month').val() == '-1'){
            layer.msg('请选择顾客', {icon: 2});
            return;
		}
		/**
		 * 月份导出表单赋值
		 */
		$("#customer-export-month-form").attr("action", $api.index.downLoadCustomerOrdersByMonthDate);
		/**
		 * 提交
		 */
		$("#customer-export-month-form").submit();
	});

    //按照时间段导出顾客购买详情
    $('#customerExportDate').on('click',function(){
    	if($('#customer-expost-date-start').val().length <= 0){
            layer.msg('请选择导出开始时间', {icon: 2});
            return;
        }
        if($('#customer-expost-date-end').val().length <= 0){
            layer.msg('请选择导出结束时间', {icon: 2});
            return;
        }
        if($('#customer-expost-date-start').val()>$('#customer-expost-date-end').val()){
            layer.msg('开始时间大于了结束时间，请重新选择', {icon: 2});
            return;
		}
        if($('#customer-choose-date').val() == '-1'){
            layer.msg('请选择顾客', {icon: 2});
            return;
        }
		/**
		 * 月份导出表单赋值
		 */
		$("#customer-export-date-form").attr("action", $api.index.downLoadCustomerOrdersByDetailsDate);
		/**
		 * 提交
		 */
		$("#customer-export-date-form").submit();
    });



});

/**
 *获取所有订单，当日订单，所有商品，所有顾客的数目
 * @returns
 */
function classiFicationGetCount(){
	$.ajax({
		url : $api.index.classificationGetCount,
		type : "GET",
		dataType : "JSON",
		beforeSend : function () {
			layerLoad = layer.load();
		},
		success : function(data) {
			var msg = data.msg;
			if(msg){
				layer.close(layerLoad);
				$("#order-count").html(msg.orderCount);
				$("#today-order-count").html(msg.toDayOrderCount);
				$("#customer-count").html(msg.customerCount);
				$("#product-count").html(msg.productCount);
			}
		},
		error : function() {
			layer.close(layerLoad);
			layer.msg('网络异常，请稍后再试', {icon: 2});
		}
	});
}

/**
 * 获取今日待配送订单
 * @param currentPage
 * @param pageSize
 * @returns
 */
function getToDayOrderInfo(currentPage){
	var serOrderQuery = {
		"currentPage" : currentPage,
		"pageSize" : 3
	};
	$.ajax({
		url : $api.index.selectTomorrowOrderInfo,
		type : "POST",
		dataType : "JSON",
		data : {"jsonStr" : JSON.stringify(serOrderQuery)},
		beforeSend : function () {
			layerLoad = layer.load();
		},
		success : function(data) {
			var msg = data.msg;
			if(msg instanceof Array){
				layer.close(layerLoad);
				var tBody = $("#today-order-list");
				tBody.html("");
				for (var i = 0; i < msg.length; i++) {
					var tempTr = '<tr><td>'+msg[i].serOrderNumber+'</td><td>'+
						msg[i].sysCustomerName+'</td><td>'+msg[i].serOrderTypeName+'</td><td>'+
						msg[i].sysVehiclesPlateNumber+'</td></tr>';
					tBody.append(tempTr);
				}
				var trLength = tBody.find("tr").length;
				var tempTotalPage = null;
				if(data.totalPage != 1){
					tempTotalPage = 3;
				}else{
					tempTotalPage = data.totalPage <= data.currentPage ? 4 : 3;
				}
				
				if(trLength < tempTotalPage){
					for (var i = 0; i < tempTotalPage - trLength; i++) {
						var tempTr = '<tr><td>---</td><td>---</td><td>---</td><td>---</td></tr>';
						tBody.append(tempTr);
					}
				}
			}
			layui.use('laypage', function() {
				layui.laypage({
					cont : $('#index-order-info-page'),
					pages : data.totalPage,
					curr : data.currentPage,
					jump : function(obj, first) {
						if (!first) {
							getToDayOrderInfo(obj.curr);
						}
					}
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
 * 趋势图加载数据
 * @returns
 */
function showChartForOrderTotal(){
	$.ajax({
		url : $api.index.readChartData,
		type : "GET",
		dataType : "JSON",
		beforeSend : function () {
			layerLoad = layer.load();
		},
		success : function(data) {
			var msg = data.msg;
			if(msg && msg.series){
				msg.credits = {
				    enabled: false
				};
				$('#highcharts-container').highcharts(msg);
			}
		},
		error : function() {
			layer.close(layerLoad);
			layer.msg('网络异常，请稍后再试', {icon: 2});
		}
	});
}

/**
 * 设置导出excel的送货日期为当天的第二天
 * 和送货单的日期为第二天
 * @returns
 */
function getTomorrowDateForExcel(){
	var date = new Date(); 
	date.setDate(date.getDate()+1);//当前日期+几天 
	var year = date.getFullYear(); // 年
	var tempMoth = date.getMonth()+1;
	var month = tempMoth < 10 ? "0" + tempMoth : tempMoth; // 月
	var day = date.getDate() < 10 ? "0" + date.getDate() : date.getDate(); // 日
	$("#order-send-time").val(year + "-" + month + "-" + day);
	$("#tomorrow-wait-send").html(year + "-" + month + "-" + day);
};

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
			var optionHtml = '';
			for(var i=0;i<data.msg.length;i++){
				optionHtml += '<option value="'+data.msg[i].sysVehiclesId+'">'+data.msg[i].sysVehiclesPlateNumber+'</option>';
			}
			optionHtml = '<option value="-1">全部车辆</option>' + optionHtml;
			$('#summarySysVehiclesId').html(optionHtml);
			$('#sortingSysVehiclesId').html(optionHtml);
			layer.close(layerLoad);
		},
		error : function() {
			layer.close(layerLoad);
			layer.msg('网络异常，请稍后再试', {icon: 2});
		}
	});
};
initSysVehiclesList();

/**
 * 系统顾客信息初始化
 */
function initSysCustomerList(){
	var jsonStr = {
        currentPage: 1,
        pageSize: 1000
	}
    $.ajax({
        url : $api.sysCustomer.selectSysCustomerList,
        type : "POST",
        dataType : "JSON",
        data : {
            jsonStr: JSON.stringify(jsonStr)
        },
        beforeSend : function () {
            layerLoad = layer.load();
        },
        success : function(data) {
            var optionHtml = '';
            for(var i=0;i<data.msg.length;i++){
                optionHtml += '<option value="'+data.msg[i].sysCustomer.sysCustomerId+'">'+data.msg[i].sysCustomer.sysCustomerName+'</option>';
            }
            optionHtml = '<option value="-1">请选择顾客</option>' + optionHtml;
            $('#customer-choose-month').html(optionHtml);
            $('#customer-choose-date').html(optionHtml);
            layer.close(layerLoad);
        },
        error : function() {
            layer.close(layerLoad);
            layer.msg('网络异常，请稍后再试', {icon: 2});
        }
    });
};
initSysCustomerList();