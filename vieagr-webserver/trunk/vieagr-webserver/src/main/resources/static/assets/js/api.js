/**
 *
 */
//var $remote_url_pre = 'http://localhost:8888/vieagr-webserver/';
var $remote_url_pre = 'http://cms.wanxiangsc.cn/';

var $assets = {
    headChooseIcon: $remote_url_pre + 'assets/i/head-icon.png'
}

var $html = {
    index: $remote_url_pre + 'index.html',
    login: $remote_url_pre + 'login.html'
};

/**
 * system controller api
 */
var $api = {
    index: {
        getLoginUserInfo: $remote_url_pre + 'index/getLoginUserInfo', //登录后获取用户信息
        classificationGetCount: $remote_url_pre + 'index/classificationGetCount', //增加一个系统用户
        selectTomorrowOrderInfo: $remote_url_pre + 'index/selectTomorrowOrderInfo',//今日待配送订单
        downLoadExcelForSysOrder: $remote_url_pre + 'index/downLoadExcelForSysOrder',	//订单信息excel导出
        readChartData: $remote_url_pre + 'index/readChartData',//走势图数据准备
        downLoadSendOrderExcel: $remote_url_pre + 'index/downLoadSendOrderExcel',//送货人导出
        downLoadCustomerOrdersByMonthDate: $remote_url_pre + 'index/downLoadCustomerOrdersByMonthDate',//顾客下单数据按照月份导出
        downLoadCustomerOrdersByDetailsDate: $remote_url_pre + 'index/downLoadCustomerOrdersByDetailsDate',//顾客下单数据按照具体时间导出
        downLoadVehiclesBidAmountTotalExcel: $remote_url_pre + 'index/downLoadVehiclesBidAmountTotalExcel',//顾客下单数据按照具体时间导出
    },
    sysUser: {
        addOneSysUser: $remote_url_pre + 'sysUser/addOneSysUser', //增加一个系统用户
        selectSysUserList: $remote_url_pre + 'sysUser/selectSysUserList', //列表查询
        updateSysUserState: $remote_url_pre + 'sysUser/updateSysUserState',	//系统用户状态更改
        selectByPrimaryKey: $remote_url_pre + 'sysUser/selectByPrimaryKey',	//通过主键查询信息
        updateSysUser: $remote_url_pre + 'sysUser/updateSysUser', //更新用户信息
    },
    sysVehicles: {
        sysVehiclesAdd: $remote_url_pre + 'sysVehicles/sysVehiclesAdd',	//添加一个车辆信息
        selectSysVehiclesList: $remote_url_pre + 'sysVehicles/selectSysVehiclesList',	//列表查询
        updateSysVehiclesState: $remote_url_pre + 'sysVehicles/updateSysVehiclesState',	//启用禁用状态修改
        updateSysVehicles: $remote_url_pre + 'sysVehicles/updateSysVehicles',	//修改车辆信息
        selectByPrimaryKey: $remote_url_pre + 'sysVehicles/selectByPrimaryKey',	//通过主键查询信息
        selectListToOption: $remote_url_pre + 'sysVehicles/selectListToOption'	//option列表查询
    },
    sysSender: {
        sysSenderAdd: $remote_url_pre + 'sysSender/sysSenderAdd',	//添加一个送货人
        selectSysSenderList: $remote_url_pre + 'sysSender/selectSysSenderList',	//列表查询
        selectByPrimaryKey: $remote_url_pre + 'sysSender/selectByPrimaryKey',	//通过主键查询
        updateSysSenderState: $remote_url_pre + 'sysSender/updateSysSenderState',	//启用禁用状态修改
        updateSysSender: $remote_url_pre + 'sysSender/updateSysSender'	//修改送货人信息
    },
    sysCustomer: {
        sysCustomerAdd: $remote_url_pre + 'sysCustomer/sysCustomerAdd',	//添加一个客户
        selectSysCustomerList: $remote_url_pre + 'sysCustomer/selectSysCustomerList',	//列表查询
        selectByPrimaryKey: $remote_url_pre + 'sysCustomer/selectByPrimaryKey',	//通过主键查询
        updateSysCustomerState: $remote_url_pre + 'sysCustomer/updateSysCustomerState',	//启用禁用状态修改
        updateSysCustomer: $remote_url_pre + 'sysCustomer/updateSysCustomer',	//修改客户信息
        selectCustomerOrderByOrderTotal: $remote_url_pre + 'sysCustomer/selectCustomerOrderByOrderTotal',	//下订单顾客列表查询
        selectCustomerForInsertCustomerGroup: $remote_url_pre + 'sysCustomer/selectCustomerForInsertCustomerGroup',	//根据分组id查询顾客列表
        insertCustomerGroup: $remote_url_pre + 'sysCustomer/insertCustomerGroup',	//添加顾客分组
        insertCustomerIdByCustomerGroupId: $remote_url_pre + 'sysCustomer/insertCustomerIdByCustomerGroupId',	//根据顾客分组id添加顾客分组关联信息
        updateCustomerGroupById: $remote_url_pre + 'sysCustomer/updateCustomerGroupById',	//修改顾客分组信息
        updateCustomerIdByCustomerGroupId: $remote_url_pre + 'sysCustomer/updateCustomerIdByCustomerGroupId',	//根据顾客分组id修改顾客与顾客分组关联信息
        insertCustomerGroupProduct: $remote_url_pre + 'sysCustomer/insertCustomerGroupProduct',	//添加顾客分组的商品模板信息
        selectSysCustomerGroupList: $remote_url_pre + 'sysCustomer/selectSysCustomerGroupList',	//查询顾客的分组列表
        selectCustomerGroupProductByCustomerGroupId: $remote_url_pre +
        'sysCustomer/selectCustomerGroupProductByCustomerGroupId',	//根据分组id查询模板商品列表
        flushSysCcustomerGroupProductStaffPriceAndOrdinaryPrice: $remote_url_pre +
        'sysCustomer/flushSysCcustomerGroupProductStaffPriceAndOrdinaryPrice'	//修改模板商品的员工餐卖价和普通卖价

    },
    sysProduct: {
        sysProductAdd: $remote_url_pre + 'sysProduct/sysProductAdd',	//商品--添加
        selectSysProductDetailList: $remote_url_pre + 'sysProduct/selectSysProductDetailList',	//商品--列表查询
        selectByPrimaryKey: $remote_url_pre + 'sysProduct/selectByPrimaryKey',	//商品--主键查询
        updateSysProductState: $remote_url_pre + 'sysProduct/updateSysProductState',	//商品--启用禁用状态
        updateSysProduct: $remote_url_pre + 'sysProduct/updateSysProduct',	//商品--更新
        selectProductConsultOrder: $remote_url_pre + 'sysProduct/selectProductConsultOrder',	//商品--下单列表查询
        updateProductsPriceByList: $remote_url_pre + 'sysProduct/updateProductsPriceByList',	//商品列表统一修改多个商品价格
        productsListForOrderDetails: $remote_url_pre + 'sysProduct/productsListForOrderDetails',//订单详情中增加商品时的商品列表
        selectSysProductList: $remote_url_pre + 'sysProduct/selectSysProductList'	//订单详情中增加商品时的商品列表
    },
    login: {
        frontLogin: $remote_url_pre + 'login/frontLogin',	//前台登录
        checkUserIsLogin: $remote_url_pre + 'login/checkUserIsLogin',//检查用户是否登录
        frontLogout: $remote_url_pre + 'login/frontLogout'	//前台注销
    },
    order: {
        saveSerOrder: $remote_url_pre + 'order/saveSerOrder',	//保存一条订单
        selectSerOrderList: $remote_url_pre + 'order/selectSerOrderList',	//订单列表查询
        selectOrderStates: $remote_url_pre + 'order/selectOrderStates',	//订单状态枚举查询
        cacelOrderByOrderNumber: $remote_url_pre + 'order/cacelOrderByOrderNumber',	//取消订单
        selectOrderTypes: $remote_url_pre + 'order/selectOrderTypes',	//订单类型枚举查询
        selectOrderByOrderNumber: $remote_url_pre + 'order/selectOrderByOrderNumber',	//通过主键查询单条订单信息
        updateProductSalePriceByOrderNumber: $remote_url_pre + 'order/updateProductSalePriceByOrderNumber',	//在订单详情中修改商品卖价
        completeOrder: $remote_url_pre + 'order/completeOrder',	//完成订单
        updateManyOrderProductPriceForSelectList: $remote_url_pre + 'order/updateManyOrderProductPriceForSelectList',	//统一修改多条订单的商品价格的列表查询
        updateProductSalePrice: $remote_url_pre + 'order/updateProductSalePrice',	//统一修改订单某些商品卖价
        readOrderDetailsForStamp: $remote_url_pre + 'order/readOrderDetailsForStamp',	//单条订单打印详情
        readOrderDetailsListForStamp: $remote_url_pre + 'order/readOrderDetailsListForStamp',	//多个订单打印详情
        deleteProductForOrder: $remote_url_pre + 'order/deleteProductForOrder',	//删除一条订单中的商品
        insertProductForOrderDetails: $remote_url_pre + 'order/insertProductForOrderDetails',	//订单详情中增加商品
        unifiedUpdateProductSalePriceForOneOrder: $remote_url_pre + 'order/unifiedUpdateProductSalePriceForOneOrder',	//一条订单中统一修改里面的商品价格
        updateProductPriceForProductsAndOrders: $remote_url_pre + 'order/updateProductPriceForProductsAndOrders',	//多条订单多个商品统一修改多个商品价格
        saveTempSerOrder: $remote_url_pre + 'order/saveTempSerOrder',	//保存一条模板订单
        judgeTempIsExist: $remote_url_pre + 'order/judgeTempIsExist',	//判断该门店是否有模板订单
        updateSerTempOrder: $remote_url_pre + 'order/updateSerTempOrder',	//修改模板订单
        insertProductForTempOrder: $remote_url_pre + 'order/insertProductForTempOrder'	//模板订单中增加商品
    },
    productType: {
        saveProductType: $remote_url_pre + 'productType/saveProductType',	//增加一条商品类型
        selectProductTypeList: $remote_url_pre + 'productType/selectProductTypeList',	//商品单位列表查询
        updateProductType: $remote_url_pre + 'productType/updateProductType',	//修改一条商品类型
        selectByPrimaryKey: $remote_url_pre + 'productType/selectByPrimaryKey',	// 通过主键查询
        updateSysProductTypeState: $remote_url_pre + 'productType/updateSysProductTypeState',	//启用禁用状态更新
        selectProductTypeListForChoose: $remote_url_pre + 'productType/selectProductTypeListForChoose'	//列表填充查询
    },
    sysIndex: {
        createOrUpdateIndexImage: $remote_url_pre + 'sysIndex/createOrUpdateIndexImage',	//更新主页图片
        selectImagesByType: $remote_url_pre + 'sysIndex/selectImagesByType',	//通过类型获取列表
        selectByPrimaryKey: $remote_url_pre + 'sysIndex/selectByPrimaryKey',	//通过主键查询
        deleteByPrimaryKey: $remote_url_pre + 'sysIndex/deleteByPrimaryKey',	//通过主键删除
    }
};

/**
 * 检查请求是否正常--需要引入layui
 * @param data
 * @returns {Boolean}
 */
function $checkRemouteStatus(data) {
    if (data.status == "500" || data.code == "555555") {//由于数据问题，服务器异常
        layui.use('layer', function () {
            var layer = layui.layer;
            layer.msg(data.msg, {icon: 5});
        });
        return false;
    } else if (data.code == "111111") {//发送数据等等不合格程序检测到返回状态
        layui.use('layer', function () {
            var layer = layui.layer;
            layer.msg(data.msg, {icon: 2});
        });
        return false;
    } else if (data.code == "999999") {//没有登录
        layui.use('layer', function () {
            var layer = layui.layer;
            layer.msg(data.msg, {icon: 5});
            setTimeout('window.parent.$configToLogin();', 2000);
        });
        return false;
    }
    return true;
}

/**
 * 检查form表单
 * @param formId
 * @returns
 */
function $checkFormVal(formId) {
    var flg = true;
    $(formId).find('input').each(function () {
        if ($(this).hasClass('am-field-error')) {
            flg = false;
            return;
        }
    });
    $(formId).find('textarea').each(function () {
        if ($(this).hasClass('am-field-error')) {
            flg = false;
            return;
        }
    });
    return flg;
}

/**
 * 添加一个iframe tab
 * @param iframeUrl    url
 * @param tabName    名称
 * @param iframeUuid    uuid
 * @returns
 */
function $addOneFrameTab(iframeUrl, tabName, iframeUuid) {
    window.parent.$addIframeTal(iframeUrl, tabName, iframeUuid);
}
