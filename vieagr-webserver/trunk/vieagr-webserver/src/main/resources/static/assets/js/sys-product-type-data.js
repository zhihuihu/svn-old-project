/**
 * Created by huzhihui on 2016/11/22.
 */
$(function(){
    var layerLoad;
    
    /**
     * 当前页的记录
     */
    var currentPageNow = 1;
    
    /**
     * 商品类型--添加
     */
    $('#sys-product-type-add-form').submit(function() {
        if(!$checkFormVal('#sys-product-type-add-form')){
            layer.msg('数据没有填写完整，请检查', {icon: 2});
            return false;
        }
        layerLoad = layer.load();
        var sysProductType = {
            sysProductTypeName : $('#sysProductTypeName').val()
        };
        $.ajax({
            url : $api.productType.saveProductType,
            type : "POST",
            dataType : "JSON",
            data : {
                "jsonStr" : JSON.stringify(sysProductType)
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
                $('#sys-product-type-add-form')[0].reset();
                initProductTypeList(1);
                layer.close(layerLoad);
            },
    		error : function() {
    			layer.close(layerLoad);
    			layer.msg('网络异常，请稍后再试', {icon: 2});
    		}
        });
        return false;
    });

    initProductTypeList(1);
    /**
     * 商品类型--列表查询
     */
    function initProductTypeList(currentPage){
    	if(currentPage == 1){
    		currentPageNow = currentPage;
    	}
        var sysProductType = {
            currentPage : currentPage,
            pageSize : 10,
            searchName: $('#sysProductTypeSearchName').val()
        }
        $.ajax({
            url : $api.productType.selectProductTypeList,
            type : "POST",
            dataType : "JSON",
            data : {
                "jsonStr" : JSON.stringify(sysProductType)
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
                    laytpl(sysProductTypeListTpl.innerHTML).render(data, function(html) {
                        $('#sys-product-type-list-body').html(html)
                    });
                });
                layui.use('laypage', function() {
                    layui.laypage({
                        cont: $('#sys-product-type-list-body-page'),
                        pages: data.totalPage,
                        groups: 2,
                        curr: data.currentPage,
                        skip: true,
                        jump: function (obj,first) {
                            if(!first){
                            	currentPageNow = obj.curr;
                                initProductTypeList(obj.curr);
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
     * 商品类型--搜索查询
     */
    $('#sys-product-type-search-form').submit(function(e){
        e.preventDefault();
        initProductTypeList(1);
    });

    /**
     * 商品类型--启用禁用状态修改
     */
    $('#sys-product-type-list-body').on('click','.btn-sys-product-type-states',function(){
        var sysProductType = {
            sysProductTypeId : $(this).attr('sysProductTypeId')
        };
        $.ajax({
            url : $api.productType.updateSysProductTypeState,
            type : "POST",
            dataType : "JSON",
            data : {
                "jsonStr" : JSON.stringify(sysProductType)
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
                initProductTypeList(currentPageNow);
                layer.close(layerLoad);
            },
    		error : function() {
    			layer.close(layerLoad);
    			layer.msg('网络异常，请稍后再试', {icon: 2});
    		}
        });
    });

    /**
     * 商品类型--单个详情查询
     */
    $('#sys-product-type-list-body').on('click', '.btn-sys-product-type-update', function() {
        var sysProductType = {
            sysProductTypeId : $(this).attr('sysProductTypeId')
        };
        $.ajax({
            url : $api.productType.selectByPrimaryKey,
            type : "POST",
            dataType : "JSON",
            data : {
                "jsonStr" : JSON.stringify(sysProductType)
            },
            beforeSend : function () {
                layerLoad = layer.load();
            },
            success : function(data,e) {
                if(!$checkRemouteStatus(data)){
                    layer.close(layerLoad);
                    return;
                }
                $('#sysProductTypeIdUpdate').val(data.msg.sysProductTypeId);
                $('#sysProductTypeNameUpdate').val(data.msg.sysProductTypeName);
                layer.close(layerLoad);
            },
    		error : function() {
    			layer.close(layerLoad);
    			layer.msg('网络异常，请稍后再试', {icon: 2});
    		}
        });
        layer.open({
            type : 1,
            title : '商品类型信息修改',
            area : 'auto',
            maxWidth : '1000px',
            content : $('#sys-product-type-update-model'),
            cancel : function(){
                $('#sys-product-type-update-form')[0].reset();
            }
        });
    });

    /**
     * 商品类型--修改
     */
    $('#sys-product-type-update-form').submit(function(e){
        e.preventDefault();
        if(!$checkFormVal('#sys-product-type-update-form')){
            layer.msg('数据没有填写完整，请检查', {icon: 2});
            return false;
        }
        layerLoad = layer.load();
        var sysProductType = {
            sysProductTypeId : $('#sysProductTypeIdUpdate').val(),
            sysProductTypeName : $('#sysProductTypeNameUpdate').val()
        };
        $.ajax({
            url : $api.productType.updateProductType,
            type : "POST",
            dataType : "JSON",
            data : {
                "jsonStr" : JSON.stringify(sysProductType)
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
                $('#sys-product-type-update-form')[0].reset();
                layer.closeAll('page');
                initProductTypeList(currentPageNow);
                layer.close(layerLoad);
            },
    		error : function() {
    			layer.close(layerLoad);
    			layer.msg('网络异常，请稍后再试', {icon: 2});
    		}
        });
    });
});