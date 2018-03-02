var layerLoad;

/**
 * 页面初始化加载
 */
(function () {
    initSysProductList(1);
    initProductTypeList();
})();

$('#sys-product-form-add').submit(function (e) {
    e.preventDefault();
    if (!$checkFormVal('#sys-product-form-add')) {
        layer.msg('数据没有填写完整，请检查', {icon: 2});
        return false;
    }
    var sysProduct = {
        sysProductName: $('#sysProductName').val(),
        sysProductProductTypeId: $('#sysProductProductTypeId').val(),
        sysProductStaffBidPrice: $('#sysProductStaffBidPrice').val(),
        sysProductOrdinaryBidPrice: $('#sysProductOrdinaryBidPrice').val(),
        sysProductPrice: $('#sysProductPrice').val(),
        sysProductUnitName: $('#sysProductUnitName').val(),
        sysProductImgUrl: $('#sysProductImgUrl').attr('src')
    };
    $.ajax({
        url: $api.sysProduct.sysProductAdd,
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
                $('#sys-product-form-add')[0].reset();
                initSysProductList(1);
                $('#sysProductImgUrl').attr('src', $assets.headChooseIcon);
            }
            layer.close(layerLoad);
        },
        error: function () {
            layer.close(layerLoad);
            layer.msg('网络异常，请稍后再试', {icon: 2});
        }
    });
});

function initSysProductList(currentPage) {
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
/**
 * 新增--图片裁剪
 */
$('#sysProductImgUrlChoose').on('click', function () {
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
    $initCropper('#sysProductImgUrl', headImagePopPage, {width: 280, height: 160}, '1.75 / 1');
    //end 裁剪页面
});

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