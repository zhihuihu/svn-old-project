/**
 * Created by huzhihui on 2016/9/30.
 */

/**
 * 全局列表json
 * @type {{}}
 */
var TAB_JSON = {
    list: [
        {
            listName: '首页', /*tab名称*/
            listUrl: 'html/main.html', /*页面路径*/
            listUuid: 'uuid-main', /*tab唯一标识*/
            listIcon: 'am-icon-home', /*左侧显示图标*/
            listRightIcon: '', /*右侧显示图标*/
            listNumber: '', /*右侧显示数字数据*/
            listNumberColor: 'am-badge am-badge-secondary', /*右侧显示数字数据样式*/
            isHtml: true/*是否是页面，false为折叠tab*/
        },
        {
            listName: '系统管理',
            listUrl: '',
            listUuid: 'uuid-system-management',
            listIcon: 'am-icon-odnoklassniki',
            listRightIcon: 'am-icon-angle-right',
            listNumber: '',
            listNumberColor: '',
            isHtml: false,
            subList: [
                {
                    listName: '用户管理',
                    listUrl: 'html/sys-user-data.html',
                    listUuid: 'uuid-sys-user-data',
                    listIcon: 'am-icon-user-secret',
                    listRightIcon: '',
                    listNumber: '',
                    listNumberColor: 'admin-icon-yellow',
                    isHtml: true
                },
                {
                    listName: '客户管理',
                    listUrl: 'html/sys-customer-data.html',
                    listUuid: 'uuid-sys-customer-data',
                    listIcon: 'am-icon-user-plus',
                    listRightIcon: '',
                    listNumber: '',
                    listNumberColor: 'admin-icon-yellow',
                    isHtml: true
                },
                {
                    listName: '车辆管理',
                    listUrl: 'html/sys-vehicles-data.html',
                    listUuid: 'uuid-sys-vehicles-data',
                    listIcon: 'am-icon-bus',
                    listRightIcon: '',
                    listNumber: '',
                    listNumberColor: 'admin-icon-yellow',
                    isHtml: true
                },
                {
                    listName: '模版订单管理',
                    listUrl: 'html/model-order-create.html',
                    listUuid: 'uuid-create-model-order-data',
                    listIcon: 'am-icon-modx',
                    listRightIcon: '',
                    listNumber: '',
                    listNumberColor: 'admin-icon-yellow',
                    isHtml: true
                },
                {
                    listName: '定价分组管理',
                    listUrl: 'html/customer-group-manager.html',
                    listUuid: 'uuid-customer-group-manager-data',
                    listIcon: 'am-icon-users',
                    listRightIcon: '',
                    listNumber: '',
                    listNumberColor: 'admin-icon-yellow',
                    isHtml: true
                },
                {
                    listName: '商品定价管理',
                    listUrl: 'html/customer-group-product-price-manager.html',
                    listUuid: 'uuid-customer-group-product-price-manager-data',
                    listIcon: 'am-icon-money',
                    listRightIcon: '',
                    listNumber: '',
                    listNumberColor: 'admin-icon-yellow',
                    isHtml: true
                }/*,
                 {
                 listName: '送货人管理',
                 listUrl: 'html/sys-sender-data.html',
                 listUuid: 'uuid-sys-sender-data',
                 listIcon: 'am-icon-truck',
                 listRightIcon: '',
                 listNumber: '',
                 listNumberColor: 'admin-icon-yellow',
                 isHtml: true
                 }*/
            ]
        },
        {
            listName: '商品管理',
            listUrl: '',
            listUuid: 'uuid-product',
            listIcon: 'am-icon-envira',
            listRightIcon: 'am-icon-angle-right',
            listNumber: '',
            listNumberColor: '',
            isHtml: false,
            subList: [
                {
                    listName: '商品类型管理',
                    listUrl: 'html/sys-product-type-data.html',
                    listUuid: 'uuid-sys-product-type-data',
                    listIcon: 'am-icon-truck',
                    listRightIcon: '',
                    listNumber: '',
                    listNumberColor: 'admin-icon-yellow',
                    isHtml: true
                },
                {
                    listName: '增加商品',
                    listUrl: 'html/sys-product-add-data.html',
                    listUuid: 'uuid-sys-product-add-data',
                    listIcon: 'am-icon-product-hunt',
                    listRightIcon: '',
                    listNumber: '',
                    listNumberColor: 'admin-icon-yellow',
                    isHtml: true
                },
                {
                    listName: '商品查询修改',
                    listUrl: 'html/sys-product-edit-data.html',
                    listUuid: 'uuid-sys-product-edit-data',
                    listIcon: 'am-icon-cogs',
                    listRightIcon: '',
                    listNumber: '',
                    listNumberColor: 'admin-icon-yellow',
                    isHtml: true
                }
            ]
        },
        {
            listName: '订单创建', /*tab名称*/
            listUrl: 'html/order-create.html', /*页面路径*/
            listUuid: 'uuid-order-create', /*tab唯一标识*/
            listIcon: 'am-icon-product-hunt', /*左侧显示图标*/
            listRightIcon: '', /*右侧显示图标*/
            listNumber: '', /*右侧显示数字数据*/
            listNumberColor: 'am-badge am-badge-secondary', /*右侧显示数字数据样式*/
            isHtml: true/*是否是页面，false为折叠tab*/
        },
        {
            listName: '订单列表', /*tab名称*/
            listUrl: 'html/order-list.html', /*页面路径*/
            listUuid: 'uuid-order-list', /*tab唯一标识*/
            listIcon: 'am-icon-th-list', /*左侧显示图标*/
            listRightIcon: '', /*右侧显示图标*/
            listNumber: '', /*右侧显示数字数据*/
            listNumberColor: 'am-badge am-badge-secondary', /*右侧显示数字数据样式*/
            isHtml: true/*是否是页面，false为折叠tab*/
        },
        {
            listName: '销售统计',
            listUrl: '',
            listUuid: 'uuid-sales-statistics',
            listIcon: 'am-icon-balance-scale',
            listRightIcon: 'am-icon-angle-right',
            listNumber: '',
            listNumberColor: '',
            isHtml: false,
            subList: [
                {
                    listName: '成本分析', /*tab名称*/
                    listUrl: 'html/cost-analysis.html', /*页面路径*/
                    listUuid: 'uuid-index-page', /*tab唯一标识*/
                    listIcon: 'am-icon-circle-o-notch', /*左侧显示图标*/
                    listRightIcon: '', /*右侧显示图标*/
                    listNumber: '', /*右侧显示数字数据*/
                    listNumberColor: 'am-badge am-badge-secondary', /*右侧显示数字数据样式*/
                    isHtml: true/*是否是页面，false为折叠tab*/
                }
            ]
        },
        {
            listName: '官网管理',
            listUrl: '',
            listUuid: 'uuid-index',
            listIcon: 'am-icon-snapchat',
            listRightIcon: 'am-icon-angle-right',
            listNumber: '',
            listNumberColor: '',
            isHtml: false,
            subList: [
                {
                    listName: '首页轮播', /*tab名称*/
                    listUrl: 'html/index-page.html', /*页面路径*/
                    listUuid: 'uuid-index-page', /*tab唯一标识*/
                    listIcon: 'am-icon-envira', /*左侧显示图标*/
                    listRightIcon: '', /*右侧显示图标*/
                    listNumber: '', /*右侧显示数字数据*/
                    listNumberColor: 'am-badge am-badge-secondary', /*右侧显示数字数据样式*/
                    isHtml: true/*是否是页面，false为折叠tab*/
                },
                {
                    listName: '产品展示', /*tab名称*/
                    listUrl: 'html/index-product-list-page.html', /*页面路径*/
                    listUuid: 'uuid-index-product-list-page', /*tab唯一标识*/
                    listIcon: 'am-icon-hand-peace-o', /*左侧显示图标*/
                    listRightIcon: '', /*右侧显示图标*/
                    listNumber: '', /*右侧显示数字数据*/
                    listNumberColor: 'am-badge am-badge-secondary', /*右侧显示数字数据样式*/
                    isHtml: true/*是否是页面，false为折叠tab*/
                }
            ]
        }

    ]
};

/**
 * 重定位到登录页面
 * @returns
 */
function $configToLogin() {
    window.location = $html.index;
};

/**
 * 添加 iframe tab方法
 * @param iframeUrl
 * @param tabName
 * @param iframeUuid
 * @returns
 */
function $addIframeTal(iframeUrl, tabName, iframeUuid) {
    var tabCounter = 0;
    var $tab = $('#admin-tab-body-index');
    var $nav = $tab.find('.am-tabs-nav');
    var $bd = $tab.find('.am-tabs-bd');
    var haveFlg = false;
    //判断是否打开了该标签页，不能重复打开标签页
    $('#admin-tab-body-index>ul>li').each(function (index) {
        if ($(this).attr('iframe-uuid') == iframeUuid) {
            $tab.tabs('open', index);
            haveFlg = true;
            return;
        }
    });
    if (haveFlg == true) {
        return;
    }

    //不存在该tab则新建tab
    var nav = '<li iframe-uuid="' + iframeUuid + '">'
        + '<span class="am-tab-refresh am-icon-refresh" iframe-url="'
        + iframeUrl + '" iframe-uuid="' + iframeUuid + '"></span>'
        + '<span class="am-icon-close"></span>'
        + '<a href="javascript: void(0)" iframe-uuid="' + iframeUuid + '">'
        + tabName + '</a></li>';
    var content = '<div class="am-tab-panel" style="height: 100%"><iframe  id="' + iframeUuid + '" src="'
        + iframeUrl
        + '" class="admin-iframe-html" style="width: 100%;height: 100%;"></iframe></div>';
    $nav.append(nav);
    $bd.append(content);
    $tab.tabs('refresh');
    layerLoad = layer.load();
    //$('#admin-tab-body-index').tabs('open',$('#admin-tab-body-index>ul>li').length -1);
    setTimeout(
        "$('#admin-tab-body-index').tabs('open',$('#admin-tab-body-index>ul>li').length -1);",
        50);
    $('#' + iframeUuid).load(function () {
        layer.close(layerLoad);
    });
};