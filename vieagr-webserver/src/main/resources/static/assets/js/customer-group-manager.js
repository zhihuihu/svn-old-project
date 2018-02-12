/**
 * Created by huzhihui on 2017/8/23.
 */
$(function () {
    var globalCurrentPage = 1;
    init_sys_customer_group_list(1);
    //是否初始化顾客列表标志位
    var init_sys_customer_flag = true;
    //查看是否是增加或者修改   add update
    var init_sys_customer_type = 'add';
    /**
     * 选择顾客弹框
     */
    $('#choose-customer').on('click', function () {
        init_sys_customer_type = 'add';
        init_sys_customer_list(null);
    });

    /**
     * 选择顾客弹框
     */
    $('#choose-customer-update').on('click', function () {
        init_sys_customer_type = 'update';
        init_sys_customer_list($('#sysCustomerGroupIdUpdate').val());
    });

    /**
     * 查询顾客列表
     * @param sysCustomerGroupId
     */
    function init_sys_customer_list(sysCustomerGroupId) {
        if (!init_sys_customer_flag) {
            layer.open({
                type: 1,
                title: '选择分组顾客',
                area: 'auto',
                maxWidth: '1000px',
                content: $('#sys-customer-choose-model'),
                cancel: function () {

                }
            });
            return;
        } else {
            init_sys_customer_flag = false;
        }
        var jsonStr = {
            customerGroupId: sysCustomerGroupId,
            currentPage: 1,
            pageSize: 1000,
        }
        $.ajax({
            url: $api.sysCustomer.selectCustomerForInsertCustomerGroup,
            type: "POST",
            dataType: "JSON",
            data: {
                "jsonStr": JSON.stringify(jsonStr)
            },
            beforeSend: function () {
                layerLoad = layer.load();
            },
            success: function (data) {
                if (!$checkRemouteStatus(data)) {
                    layer.close(layerLoad);
                    return;
                }
                layer.close(layerLoad);
                layui.use('laytpl', function () {
                    var laytpl = layui.laytpl;
                    $('#sys-customer-choose-body').html(laytpl(sysCustomerChooseTpl.innerHTML).render(data));

                });
                layer.open({
                    type: 1,
                    title: '选择分组顾客',
                    area: 'auto',
                    maxWidth: '1000px',
                    content: $('#sys-customer-choose-model'),
                    cancel: function () {

                    }
                });
            },
            error: function () {
                layer.close(layerLoad);
                layer.msg('网络异常，请稍后再试', {icon: 2});
            }
        });
    }

    /**
     * 顾客分组信息分页查询
     * @param currentPage
     */
    function init_sys_customer_group_list(currentPage) {
        if (currentPage <= 1) {
            globalCurrentPage = 1;
        }
        var jsonStr = {
            currentPage: currentPage,
            pageSize: 10,
            sysCustomerGroupName: $('#sysCustomerGroupNameSearch').val()
        }
        $.ajax({
            url: $api.sysCustomer.selectSysCustomerGroupList,
            type: "POST",
            dataType: "JSON",
            data: {
                "jsonStr": JSON.stringify(jsonStr)
            },
            beforeSend: function () {
                layerLoad = layer.load();
            },
            success: function (data) {
                if (!$checkRemouteStatus(data)) {
                    layer.close(layerLoad);
                    return;
                }
                layui.use('laytpl', function () {
                    var laytpl = layui.laytpl;
                    laytpl(sysCustomerGroupListTpl.innerHTML).render(data, function (html) {
                        $('#sys-customer-group-list-body').html(html)
                    });
                });
                layui.use('laypage', function () {
                    layui.laypage({
                        cont: $('#sys-customer-group-list-body-page'),
                        pages: data.totalPage,
                        groups: 2,
                        curr: data.currentPage,
                        skip: true,
                        jump: function (obj, first) {
                            if (!first) {
                                globalCurrentPage = obj.curr;
                                init_sys_customer_group_list(obj.curr);
                            }
                        }
                    });
                });
                layer.close(layerLoad);
            },
            error: function () {
                layer.close(layerLoad);
                layer.msg('网络异常，请稍后再试', {icon: 2});
            }
        });
    };

    /**
     * 用户选择checkbox点击
     */
    $(document).on('click', '.choose-sys-customer', function () {
        var totalNumber = 0;
        if (init_sys_customer_type == 'add') {
            if ($(this).is(':checked')) {
                var appendHtml = '<span style="margin: 4px;" class="am-badge am-badge-warning am-radius add-show-customer-id add-show-customer-id-' + $(this).attr('sysCustomerId') + '" sysCustomerId="' + $(this).attr('sysCustomerId') + '">' + $(this).attr('sysCustomerName') + '</span>';
                $('.add-show-customer-body').append(appendHtml);
            } else {
                $('.add-show-customer-id-' + $(this).attr('sysCustomerId')).remove();
            }
            $('.add-show-customer-id').each(function () {
                totalNumber = totalNumber + 1;
            });
            $('.add-show-check-customer-number').html(totalNumber);
        } else {
            if ($(this).is(':checked')) {
                var appendHtml = '<span style="margin: 4px;" class="am-badge am-badge-warning am-radius update-show-customer-id update-show-customer-id-' + $(this).attr('sysCustomerId') + '" sysCustomerId="' + $(this).attr('sysCustomerId') + '">' + $(this).attr('sysCustomerName') + '</span>';
                $('.update-show-customer-body').append(appendHtml);
            } else {
                $('.update-show-customer-id-' + $(this).attr('sysCustomerId')).remove();
            }
            $('.update-show-customer-id').each(function () {
                totalNumber = totalNumber + 1;
            });
            $('.update-show-check-customer-number').html(totalNumber);
        }

    });
    /**
     * 添加一个分组
     */
    $('#add-sys-customer-group-form').submit(function (e) {
        e.preventDefault();
        if (!$checkFormVal('#add-sys-customer-group-form')) {
            layer.msg('数据没有填写完整，请检查', {icon: 2});
            return false;
        }
        var customerIds = [];
        $('.add-show-customer-id').each(function () {
            customerIds.push($(this).attr('sysCustomerId'));
        });
        if (customerIds.length == 0) {
            layer.msg('请选择顾客', {icon: 3});
            return;
        }
        var jsonStr = {
            customerGroupName: $('#sysCustomerGroupName').val(),
            customerIds: customerIds
        };
        $.ajax({
            url: $api.sysCustomer.insertCustomerGroup,
            type: "POST",
            dataType: "JSON",
            data: {
                "jsonStr": JSON.stringify(jsonStr)
            },
            beforeSend: function () {
                layerLoad = layer.load();
            },
            success: function (data) {
                if (!$checkRemouteStatus(data)) {
                    layer.close(layerLoad);
                    return;
                }
                $('#add-sys-customer-group-form')[0].reset();
                $('.add-show-customer-body').html('');
                $('.add-show-check-customer-number').html(0);
                init_sys_customer_group_list(1);
                init_sys_customer_flag = true;
                layer.close(layerLoad);
                layer.msg(data.msg, {icon: 1});


            },
            error: function () {
                layer.close(layerLoad);
                layer.msg('网络异常，请稍后再试', {icon: 2});
            }
        });
    });

    /**
     * 点击查询分组详情
     */
    $(document).on('click', '.btn-sys-customer-group-update', function () {
        $('.update-show-check-customer-number').html(0);
        $('.update-show-customer-body').html('');
        $('#sysCustomerGroupIdUpdate').val($(this).attr('sysCustomerGroupId'));
        $('#sysCustomerGroupNameUpdate').val($(this).attr('sysCustomerGroupName'));
        var jsonStr = {
            customerGroupId: $(this).attr('sysCustomerGroupId'),
            currentPage: 1,
            pageSize: 1000,
        }
        $.ajax({
            url: $api.sysCustomer.selectCustomerForInsertCustomerGroup,
            type: "POST",
            dataType: "JSON",
            data: {
                "jsonStr": JSON.stringify(jsonStr)
            },
            beforeSend: function () {
                layerLoad = layer.load();
            },
            success: function (data) {
                if (!$checkRemouteStatus(data)) {
                    layer.close(layerLoad);
                    return;
                }
                layer.close(layerLoad);
                var total_customer = 0;
                for (var i = 0; i < data.msg.length; i++) {
                    var currentData = data.msg[i];
                    if (currentData.isChangedType == 2) {
                        total_customer += 1;
                        var appendHtml = '<span style="margin: 4px;" class="am-badge am-badge-warning am-radius update-show-customer-id update-show-customer-id-' + currentData.sysCustomerId + '" sysCustomerId="' + currentData.sysCustomerId + '">' + currentData.sysCustomerName + '</span>';
                        $('.update-show-customer-body').append(appendHtml);
                    }
                }
                $('.update-show-check-customer-number').html(total_customer);
                layer.open({
                    type: 1,
                    title: '分组内容修改',
                    area: 'auto',
                    maxWidth: '1000px',
                    content: $('#sys-customer-group-update-model'),
                    cancel: function () {

                    }
                });
            },
            error: function () {
                layer.close(layerLoad);
                layer.msg('网络异常，请稍后再试', {icon: 2});
            }
        });

    })
    ;

    /**
     * 修改分组信息
     */
    $('#update-sys-customer-group-form').submit(function (e) {
        e.preventDefault();
        var customerIds = [];

        $('.update-show-customer-id').each(function () {
            customerIds.push($(this).attr('sysCustomerId'));
        });
        if (customerIds.length == 0) {
            layer.msg('请选择顾客', {icon: 3});
            return;
        }
        var jsonStr = {
            sysCustomerGroupId: $('#sysCustomerGroupIdUpdate').val(),
            sysCustomerGroupName: $('#sysCustomerGroupNameUpdate').val(),
            customerIds: customerIds
        }
        $.ajax({
            url: $api.sysCustomer.updateCustomerGroupById,
            type: "POST",
            dataType: "JSON",
            data: {
                "jsonStr": JSON.stringify(jsonStr)
            },
            beforeSend: function () {
                layerLoad = layer.load();
            },
            success: function (data) {
                if (!$checkRemouteStatus(data)) {
                    layer.close(layerLoad);
                    return;
                }
                $('#update-sys-customer-group-form')[0].reset();
                $('.update-show-customer-body').html('');
                $('.update-show-check-customer-number').html(0);
                init_sys_customer_group_list(globalCurrentPage);
                init_sys_customer_flag = true;
                layer.closeAll();
                layer.msg(data.msg, {icon: 1});
            },
            error: function () {
                layer.close(layerLoad);
                layer.msg('网络异常，请稍后再试', {icon: 2});
            }
        });
    });

    /**
     * 搜索
     */
    $('#sys-customer-group-search-form').submit(function (e) {
        e.preventDefault();
        init_sys_customer_group_list(1);
    });
});