/**
 * Created by huzhihui on 2017/8/23.
 */
$(function () {
    $.fn.datetimepicker.dates['zh-CN'] = {
        days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
        daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
        daysMin: ["日", "一", "二", "三", "四", "五", "六", "日"],
        months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
        monthsShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
        today: "今日",
        suffix: [],
        meridiem: ["上午", "下午"]
    };
    $('#cost-export-tab').tabs();
    $('#dayCostTime').datetimepicker({
        language: 'zh-CN',
        format: 'yyyy-mm-dd',
        autoclose: true,
        minView: 2
    });
    $('#monthCostTime').datetimepicker({
        language: 'zh-CN',
        format: 'yyyy-mm',
        autoclose: true,
        startView: 3,
        minView: 3
    });

    /**
     * 系统车辆option初始化
     */
    function initSysVehiclesList() {
        $.ajax({
            url: $api.sysVehicles.selectListToOption,
            type: "GET",
            dataType: "JSON",
            data: {},
            beforeSend: function () {
                layerLoad = layer.load();
            },
            success: function (data) {
                var optionHtml = '';
                for (var i = 0; i < data.msg.length; i++) {
                    optionHtml += '<option value="' + data.msg[i].sysVehiclesId + '">' + data.msg[i].sysVehiclesPlateNumber + '</option>';
                }
                optionHtml = '<option value="-1">请选择车牌号</option>' + optionHtml;
                $('#dayCostSysVehiclesId').html(optionHtml);
                $('#monthCostSysVehiclesId').html(optionHtml);
                layer.close(layerLoad);
            },
            error: function () {
                layer.close(layerLoad);
                layer.msg('网络异常，请稍后再试', {icon: 2});
            }
        });
    };
    initSysVehiclesList();

})