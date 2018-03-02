/**
 * 官网内容管理js
 */


$(function () {
    var _currentFileObj;
    var _currentSysIndexId = '';
    var confirmUploadImagePop;
    /**
     * 图片选择弹框
     */
    $(document).on('change', '.hide-change-lb-btn', function () {
        _currentSysIndexId = $(this).attr('sysIndexId');
        _currentFileObj = $(this)[0].files[0];
        $('.final-upload-image').attr('src', getObjectURL($(this)[0].files[0]));
        $(this).val('');
        confirmUploadImagePop = layer.open({
            type: 1,
            title: '是否确认上传',
            area: ['500px', '350px'],
            maxWidth: '400px',
            content: $('.access-image-div'),
            cancel: function () {
            }
        });
    });

    /**
     * 上传图片
     */
    $(document).on('click', '.upload-btn,.update-sys-index-url', function () {
        if($(this).attr('sysIndexId')){
            _currentSysIndexId = $(this).attr('sysIndexId');
        }
        var jsonStr = {
            sysIndexId : _currentSysIndexId,
            sysIndexType : 1,
            sysIndexName : $('.sysIndexName-'+_currentSysIndexId).val()
        }
        var formData = new FormData();
        formData.append('file', _currentFileObj);
        formData.append('jsonStr',JSON.stringify(jsonStr));
        $.ajax({
            url: $api.sysIndex.createOrUpdateIndexImage,
            method: 'POST',
            data: formData,
            beforeSend : function () {
                layerLoad = layer.load();
            },
            contentType: false, // 注意这里应设为false
            processData: false,
            cache: false,
            success: function (data) {
                layer.close(layerLoad);
                layer.close(confirmUploadImagePop);
                layer.msg(data.msg, {icon: 1}, function(){
                    window.location.reload();
                });
            },
            error: function () {
                layer.close(layerLoad);
                layer.close(confirmUploadImagePop);
                layer.msg('网络异常，请稍后再试', {icon: 2});
            }
        })
    });

    /**
     * 查看图片大图
     */
    $(document).on('click', '.show-lb-btn', function () {
        window.open($(this).attr('src'));
    });

    initSysIndexList(1);
    /**
     * 列表初始化
     * @param currentPage
     */
    function initSysIndexList(currentPage){
        var sysProduct = {
            currentPage : currentPage,
            pageSize : 10,
            sysIndexType : 1
        }
        $.ajax({
            url : $api.sysIndex.selectImagesByType,
            type : "POST",
            dataType : "JSON",
            data : {
                "jsonStr" : JSON.stringify(sysProduct)
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
                    laytpl(sysIndexListTpl.innerHTML).render(data, function(html) {
                        $('#sys-index-list-body').html(html)
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
     * 获取image
     * @param file
     */
    function getObjectURL(file) {
        var url = null;
        if (window.createObjectURL != undefined) { // basic
            url = window.createObjectURL(file);
        } else if (window.URL != undefined) { // mozilla(firefox)
            url = window.URL.createObjectURL(file);
        } else if (window.webkitURL != undefined) { // webkit or chrome
            url = window.webkitURL.createObjectURL(file);
        }
        return url;
    }
})
