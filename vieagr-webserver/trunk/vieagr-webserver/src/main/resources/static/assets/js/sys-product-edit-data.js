var layerLoad;

/**
 * 当前页的记录
 */
var currentPageNow = 1;

/**
 * 页面初始化加载
 */
(function () {
    initSysProductList(1);
    initProductTypeList();
})();

function initSysProductList(currentPage) {
    if (currentPage == 1) {
        currentPageNow = currentPage;
    }
    var sysProduct = {
        currentPage: currentPage,
        pageSize: 10,
        searchName: $('#sysProductSearchName').val(),
        sysProductProductTypeId: $('#sysProductTypeSearchId').val()
    }
    $.ajax({
        url: $api.sysProduct.selectSysProductDetailList,
        type: "POST",
        dataType: "JSON",
        data: {
            "jsonStr": JSON.stringify(sysProduct)
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
                laytpl(sysProductListTpl.innerHTML).render(data, function (html) {
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
                            currentPageNow = obj.curr;
                            initSysProductList(obj.curr);
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
 * 搜索
 */
$('#sys-product-form-list-search').submit(function (e) {
    e.preventDefault();
    initSysProductList(1);
});

/**
 * 详情查询
 */
$('#sys-product-list-body').on('click', '.btn-sys-product-update', function () {
    $.ajax({
        url: $api.sysProduct.selectByPrimaryKey,
        type: "POST",
        dataType: "JSON",
        data: {
            "sysProductId": $(this).attr('sysProductId')
        },
        beforeSend: function () {
            layerLoad = layer.load();
        },
        success: function (data, e) {
            if (!$checkRemouteStatus(data)) {
                layer.close(layerLoad);
                return;
            }
            $('#sysProductProductTypeIdUpdate').val(data.msg.sysProductProductTypeId);
            $('#sysProductIdUpdate').val(data.msg.sysProductId);
            $('#sysProductNameUpdate').val(data.msg.sysProductName);
            $('#sysProductStaffBidPriceUpdate').val(data.msg.sysProductStaffBidPrice);
            $('#sysProductOrdinaryBidPriceUpdate').val(data.msg.sysProductOrdinaryBidPrice);
            $('#sysProductPriceUpdate').val(data.msg.sysProductPrice);
            $('#sysProductUnitNameUpdate').val(data.msg.sysProductUnitName);
            if (data.msg.sysProductImgUrl) {
                $('#sysProductImgUrlUpdate').attr('src', data.fileUrlPre + data.msg.sysProductImgUrl)
            }
            layer.close(layerLoad);
        },
        error: function () {
            layer.close(layerLoad);
            layer.msg('网络异常，请稍后再试', {icon: 2});
        }
    });
    layer.open({
        type: 1,
        title: '商品详情查看',
        area: 'auto',
        maxWidth: '1000px',
        content: $('#sys-product-update-model'),
        cancel: function () {
            $('#sys-product-form-update')[0].reset();
            $('#sysProductImgUrlUpdate').attr('src', $assets.headChooseIcon);
        }
    });
});

/**
 * 修改--图片裁剪
 */
$('#sysProductImgUrlUpdateChoose').on('click', function () {
    //初始化裁剪页面
    var headImagePopPage = layer.open({
        type: 1,
        title: '车辆头像选择',
        area: 'auto',
        maxWidth: '1000px',
        content: $getCropperHtml('imgUrlChooseDiv'),
        cancel: function () {
        }
    });
    $initCropper('#sysProductImgUrlUpdate', headImagePopPage, {width: 280, height: 160}, '1.75 / 1');
    //end 裁剪页面
});

/**
 * 商品--修改
 */
$('#sys-product-form-update').submit(function (e) {
    e.preventDefault();
    if (!$checkFormVal('#sys-product-form-add')) {
        layer.msg('数据没有填写完整，请检查', {icon: 2});
        return false;
    }
    var sysProduct = {
        sysProductId: $('#sysProductIdUpdate').val(),
        sysProductName: $('#sysProductNameUpdate').val(),
        sysProductProductTypeId: $('#sysProductProductTypeIdUpdate').val(),
        sysProductStaffBidPrice: $('#sysProductStaffBidPriceUpdate').val(),
        sysProductOrdinaryBidPrice: $('#sysProductOrdinaryBidPriceUpdate').val(),
        sysProductPrice: $('#sysProductPriceUpdate').val(),
        sysProductUnitName: $('#sysProductUnitNameUpdate').val(),
        sysProductImgUrl: $('#sysProductImgUrlUpdate').attr('src')
    };
    $.ajax({
        url: $api.sysProduct.updateSysProduct,
        type: "POST",
        dataType: "JSON",
        data: {
            "jsonStr": JSON.stringify(sysProduct)
        },
        beforeSend: function () {
            layerLoad = layer.load();
        },
        success: function (data) {
            if (!$checkRemouteStatus(data)) {
                layer.close(layerLoad);
                return;
            }
            if (data.code == '111111') {
                layer.msg(data.msg, {icon: 2});
            } else {
                layer.msg(data.msg, {icon: 1});
                $('#sys-product-form-update')[0].reset();
                initSysProductList(currentPageNow);
                $('#sysProductImgUrlUpdate').attr('src', $assets.headChooseIcon);
                layer.closeAll('page');
            }
            layer.close(layerLoad);
        },
        error: function () {
            layer.close(layerLoad);
            layer.msg('网络异常，请稍后再试', {icon: 2});
        }
    });
});

/**
 * 商品--启用禁用状态修改
 */
$('#sys-product-list-body').on('click', '.btn-sys-product-states', function () {
    $.ajax({
        url: $api.sysProduct.updateSysProductState,
        type: "POST",
        dataType: "JSON",
        data: {
            "sysProductId": $(this).attr('sysProductId')
        },
        beforeSend: function () {
            layerLoad = layer.load();
        },
        success: function (data) {
            if (!$checkRemouteStatus(data)) {
                layer.close(layerLoad);
                return;
            }
            if (data.code == '111111') {
                layer.msg(data.msg, {icon: 2});
            } else {
                layer.msg(data.msg, {icon: 1});
                initSysProductList(currentPageNow);
            }
            layer.close(layerLoad);
        },
        error: function () {
            layer.close(layerLoad);
            layer.msg('网络异常，请稍后再试', {icon: 2});
        }
    });
});

$('#sysProductSearchName').bind('input propertychange', function () {
    initSysProductList(1);
});

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
 * 统一修改确定
 */
$('#update-all-product-price-btn').on('click', function () {
    if ($('.update-price-input-main').attr('disabled') == 'disabled') {
        layer.msg('请先点击统一修改按钮', {icon: 3});
        return;
    }
    var sysProductIds = [];
    var sysProductStaffBidPrice = [];
    var sysProductOrdinaryBidPrice = [];
    var sysProductPrices = [];
    $('.update-price-input-main').each(function () {
        var sysProductId = $(this).attr('sysProductId');
        sysProductIds.push(sysProductId);
        sysProductStaffBidPrice.push($('.update-staff-bid-price-input-' + sysProductId).val());
        sysProductOrdinaryBidPrice.push($('.update-ordinary-bid-price-input-' + sysProductId).val());
        sysProductPrices.push($(this).val());
    });
    var sysProductParam = {
        sysProductIds: sysProductIds,
        sysProductStaffBidPrice: sysProductStaffBidPrice,
        sysProductOrdinaryBidPrice: sysProductOrdinaryBidPrice,
        sysProductPrices: sysProductPrices
    }
    layer.confirm('您是否修改商品价格？', {
        btn: ['确定', '取消'] //按钮
    }, function () {
        $.ajax({
            url: $api.sysProduct.updateProductsPriceByList,
            type: "POST",
            dataType: "JSON",
            data: {
                jsonStr: JSON.stringify(sysProductParam)
            },
            beforeSend: function () {
                layerLoad = layer.load();
            },
            success: function (data) {
                if (!$checkRemouteStatus(data)) {
                    layer.close(layerLoad);
                    return;
                }
                layer.msg(data.msg, {icon: 1});
                initSysProductList(currentPageNow);
            },
            error: function () {
                layer.close(layerLoad);
                layer.msg('网络异常，请稍后再试', {icon: 2});
            }
        });
    }, function () {

    });
});

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
            $('#sysProductProductTypeId').html(optionHtml);
            $('#sysProductProductTypeIdUpdate').html(optionHtml);
            $('#sysProductTypeSearchId').html('<option value="null">全部</option>' + optionHtml);
            layer.close(layerLoad);
        },
        error: function () {
            layer.close(layerLoad);
            layer.msg('网络异常，请稍后再试', {icon: 2});
        }
    });
};