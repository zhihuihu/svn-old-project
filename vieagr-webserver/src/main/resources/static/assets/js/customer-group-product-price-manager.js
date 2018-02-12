/**
 * Created by huzhihui on 2017/8/25.
 */
$(function () {

    var globalCurrentPage = 1;
    //页面载入执行查询
    init_sys_customer_group_list();
    /**
     * 顾客分组信息分页查询
     *
     */
    function init_sys_customer_group_list() {
        var jsonStr = {
            currentPage: 1,
            pageSize: 1000,
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
                    laytpl(customerGroupListTpl.innerHTML).render(data, function (html) {
                        $('#sys-customer-group-list-body').html(html)
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
     * 通过分组id查询分组内的顾客
     * @param sysCustomerGroupId
     */
    function init_sys_customer_by_group(sysCustomerGroupId) {
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
                var optionHtml = '';
                for (var i = 0; i < data.msg.length; i++) {
                    var currentData = data.msg[i];
                    if (currentData.isChangedType == 2) {
                        optionHtml += '<option value="' + currentData.sysCustomerId + '">' + currentData.sysCustomerName + '</option>';
                    }
                }
                optionHtml = '<option value="-1">请选择分组顾客</option>' + optionHtml;
                $('#currentChooseGroupCustomerId').html(optionHtml);
                layer.close(layerLoad);
            },
            error: function () {
                layer.close(layerLoad);
                layer.msg('网络异常，请稍后再试', {icon: 2});
            }
        });
    };

    /**
     * 分组的顾客改变时
     */
    $('#currentChooseGroupCustomerId').change(function () {
        if ($(this).val() == '-1' || !$(this).val()) {
            $('#sys-product-list-body,#sys-product-list-body-page').html('');
            return;
        }
        init_group_product(1);
    });

    /**
     * 点击选择分组弹框弹出
     */
    $(document).on('click', '.choose-sys-customer-group', function () {
        init_sys_customer_group_list();
        layer.open({
            type: 1,
            title: '选择分组',
            area: 'auto',
            maxWidth: '1000px',
            content: $('#choose-sys-customer-group-model'),
            cancel: function () {

            }
        });
    });

    /**
     * 分组搜索
     */
    $('#sys-customer-group-search-form').submit(function (e) {
        e.preventDefault();
        init_sys_customer_group_list();
    });

    /**
     * 选择分组
     */
    $(document).on('click', '.btn-sys-customer-group-choose', function () {
        $('#show-choose-sys-customer-group').attr('sysCustomerGroupId', $(this).attr('sysCustomerGroupId'));
        var appendHtml = '<span class="am-badge am-badge-warning am-radius">' + $(this).attr('sysCustomerGroupName') + '</span>';
        $('#show-choose-sys-customer-group').html(appendHtml);
        init_sys_customer_by_group($(this).attr('sysCustomerGroupId'));
        $('#sys-product-list-body,#sys-product-list-body-page').html('');
        layer.closeAll();
    });

    initProductTypeList();
    /**
     * 商品类型 -- 查询
     */
    function initProductTypeList() {
        $.ajax({
            url: $api.productType.selectProductTypeListForChoose,
            type: "POST",
            dataType: "JSON",
            data: {},
            beforeSend: function () {
                layerLoad = layer.load();
            },
            success: function (data) {
                if (!$checkRemouteStatus(data)) {
                    layer.close(layerLoad);
                    return;
                }
                var optionHtml = '';
                for (var i = 0; i < data.msg.length; i++) {
                    optionHtml += '<option value="' + data.msg[i].sysProductTypeId + '">' + data.msg[i].sysProductTypeName + '</option>';
                }
                $('#sysProductTypeSearchId').html('<option value="">全部</option>' + optionHtml);
                layer.close(layerLoad);
            },
            error: function () {
                layer.close(layerLoad);
                layer.msg('网络异常，请稍后再试', {icon: 2});
            }
        });
    };

    /**
     * 分组商品列表搜索
     */
    $('#sys-product-form-list-search').submit(function (e) {
        e.preventDefault();
        if (!$('#show-choose-sys-customer-group').attr('sysCustomerGroupId')) {
            layer.msg('请先选择分组哦', {icon: 2});
            return;
        }
        init_group_product(1);
    });

    /**
     * 分组商品查询
     * @param currentPage
     */
    function init_group_product(currentPage) {
    	if($('#currentChooseGroupCustomerId').val() == '-1' || !$('#currentChooseGroupCustomerId').val()){
    		layer.msg('请选择分组中的顾客哦', {icon: 2});
    		return;
    	}
        if (currentPage <= 1) {
            globalCurrentPage = 1;
        }
        var serOrderQuery = {
            currentPage: currentPage,
            pageSize: 10,
            sysProductTypeId: $('#sysProductTypeSearchId').val(),
            sysCustomerId: $('#currentChooseGroupCustomerId').val(),
            sysCustomerGroupId: $('#show-choose-sys-customer-group').attr('sysCustomerGroupId'),
            searchName: $('#sysProductSearchName').val()
        }
        $.ajax({
            url: $api.sysCustomer.selectCustomerGroupProductByCustomerGroupId,
            type: "POST",
            dataType: "JSON",
            data: {
                "jsonStr": JSON.stringify(serOrderQuery)
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
                    laytpl(groupProductListTpl.innerHTML).render(data,
                        function (html) {
                            $('#sys-product-list-body').html(html)
                        });
                });
                layui.use('laypage', function () {
                    layui.laypage({
                        cont: $('#sys-product-list-body-page'),
                        pages: data.totalPage,
                        groups: 2,
                        curr: data.currentPage,
                        skip: true,
                        jump: function (obj, first) {
                            if (!first) {
                                globalCurrentPage = obj.curr;
                                init_group_product(obj.curr);
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
     * 统一修改点击
     */
    $('#update-all-product-choose-btn').on('click', function () {
        if ($('.update-price-input').attr('disabled') == 'disabled') {
            /*$('#update-all-product-price-btn').removeClass('am-hide');*/
            $('.update-price-input').attr('disabled', false);
            $('.update-price-input').removeClass('update-price-input-disable');
            $('.update-price-input').addClass('update-price-input-able');
        } else {
            /*$('#update-all-product-price-btn').addClass('am-hide');*/
            $('.update-price-input').attr('disabled', 'disabled');
            $('.update-price-input').removeClass('update-price-input-able');
            $('.update-price-input').addClass('update-price-input-disable');
        }

    });

    /**
     * 单个修改弹框
     */
    $(document).on('click', '.btn-sys-customer-group-product-update', function () {
        $('#sysCustomerGroupProductIdUpdate').val($(this).attr('sysCustomerGroupProductId'));
        $('#sysCustomerGroupProductProductNameUpdate').val($(this).attr('sysCustomerGroupProductProductName'));
        $('#sysCustomerGroupProductProductStaffPriceUpdate').val($(this).attr('sysCustomerGroupProductProductStaffPrice'));
        $('#sysCustomerGroupProductProductOrdinaryPriceUpdate').val($(this).attr('sysCustomerGroupProductProductOrdinaryPrice'));
        layer.open({
            type: 1,
            title: '商品修改',
            area: 'auto',
            maxWidth: '1000px',
            content: $('#sys-customer-group-product-update-model'),
            cancel: function () {

            }
        });
    });
    /**
     * 单个修改
     */
    $('#update-sys-customer-group-product-form').submit(function (e) {
        e.preventDefault();
        var sysCustomerGroupProducts = [];
        var sysCustomerGroupProduct = {
            sysCustomerGroupProductId: $('#sysCustomerGroupProductIdUpdate').val(),
            sysCustomerGroupProductProductStaffPrice: $('#sysCustomerGroupProductProductStaffPriceUpdate').val(),
            sysCustomerGroupProductProductOrdinaryPrice: $('#sysCustomerGroupProductProductOrdinaryPriceUpdate').val(),
        }
        sysCustomerGroupProducts.push(sysCustomerGroupProduct);
        var jsonStr = {
            sysCustomerGroupProducts: sysCustomerGroupProducts
        }
        $.ajax({
            url: $api.sysCustomer.flushSysCcustomerGroupProductStaffPriceAndOrdinaryPrice,
            type: "POST",
            dataType: "JSON",
            data: {
                jsonStr: JSON.stringify(jsonStr)
            },
            beforeSend: function () {
                layerLoad = layer.load();
            },
            success: function (data) {
                if (!$checkRemouteStatus(data)) {
                    layer.close(layerLoad);
                    return;
                }
                layer.closeAll();
                layer.msg(data.msg, {icon: 1});
                init_group_product(globalCurrentPage);
            },
            error: function () {
                layer.close(layerLoad);
                layer.msg('网络异常，请稍后再试', {icon: 2});
            }
        });
    });
    /**
     * 统一修改确定
     */
    $('#update-all-product-price-btn').on('click', function () {
        if ($('.update-price-input-main').attr('disabled') == 'disabled') {
            layer.msg('请先点击统一修改按钮', {icon: 3});
            return;
        }
        var sysCustomerGroupProducts = [];
        $('.update-price-input-main').each(function () {
            var sysCustomerGroupProductId = $(this).attr('sysCustomerGroupProductId');
            var sysCustomerGroupProduct = {
                sysCustomerGroupProductId: sysCustomerGroupProductId,
                sysCustomerGroupProductProductStaffPrice: $('.update-sysCustomerGroupProductProductStaffPrice-input-' + sysCustomerGroupProductId).val(),
                sysCustomerGroupProductProductOrdinaryPrice: $('.update-sysCustomerGroupProductProductOrdinaryPrice-input-' + sysCustomerGroupProductId).val(),
            }
            sysCustomerGroupProducts.push(sysCustomerGroupProduct);
        });
        var jsonStr = {
            sysCustomerGroupProducts: sysCustomerGroupProducts
        }
        layer.confirm('您是否修改商品价格？', {
            btn: ['确定', '取消'] //按钮
        }, function () {
            $.ajax({
                url: $api.sysCustomer.flushSysCcustomerGroupProductStaffPriceAndOrdinaryPrice,
                type: "POST",
                dataType: "JSON",
                data: {
                    jsonStr: JSON.stringify(jsonStr)
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
                    layer.msg(data.msg, {icon: 1});
                    init_group_product(currentPageNow);
                },
                error: function () {
                    layer.close(layerLoad);
                    layer.msg('网络异常，请稍后再试', {icon: 2});
                }
            });
        }, function () {

        });
    });
});