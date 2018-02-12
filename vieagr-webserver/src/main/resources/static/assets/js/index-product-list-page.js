var layerLoad;

var _currentFileObj;
var _currentSysIndexId = '';
var confirmUploadImagePop;

/**
 * 头像裁剪弹出层
 */
/*var headImagePopPage;*/
/**
 * form--增加一个主页产品展示图片
 */
$('#add-index-product-list').submit(function() {
    addIndexProductList();
	return false;
});

$(document).on('change','.sysIndexImageUrl-choose',function(){
    _currentSysIndexId = $(this).attr('sysIndexId');
    _currentFileObj = $(this)[0].files[0];
    $('#sysIndexImageUrl').attr('src', getObjectURL($(this)[0].files[0]));
    $(this).val('');
});

$(document).on('change','.sysIndexImageUrl-choose-update',function(){
    _currentSysIndexId = $(this).attr('sysIndexId');
    _currentFileObj = $(this)[0].files[0];
    $('#sysIndexImageUrlUpdate').attr('src', getObjectURL($(this)[0].files[0]));
    $(this).val('');
});

/**
 * 增加一个主页产品展示图片
 * 
 * @returns
 */
function addIndexProductList() {
	if(!$checkFormVal('#add-index-product-list')){
		layer.msg('数据没有填写完整，请检查', {icon: 2});
		return false;
	}
	var sysIndex = {
        sysIndexName : $('#sysIndexName').val(),
        sysIndexImageContent : $('#sysIndexImageContent').val(),
        sysIndexType : 2
	};
    var formData = new FormData();
    formData.append('file', _currentFileObj);
    formData.append('jsonStr',JSON.stringify(sysIndex));
	$.ajax({
		url : $api.sysIndex.createOrUpdateIndexImage,
		type : "POST",
		dataType : "JSON",
		data : formData,
		beforeSend : function () {
			layerLoad = layer.load();
		},
        contentType: false, // 注意这里应设为false
        processData: false,
        cache: false,
		success : function(data) {
			if(!$checkRemouteStatus(data)){
				layer.close(layerLoad);
				return;
			}
			if(data.code == '111111'){
				layer.msg(data.msg, {icon: 2});
			}else{
				layer.msg(data.msg, {icon: 1});
				$('#add-index-product-list')[0].reset();
				$('#sysIndexImageUrl').attr('src',$assets.headChooseIcon);
				initIndexProductList(1);
			}
			layer.close(layerLoad);
		},
		error : function() {
			layer.close(layerLoad);
			layer.msg('网络异常，请稍后再试', {icon: 2});
		}
	});
};

/**
 * 初始化页面加载
 */
(function() {
    initIndexProductList(1);
})();
/**
 * 列表加载
 * 
 * @param currentPage
 * @returns
 */
function initIndexProductList(currentPage) {
	var jsonStr = {
		currentPage : currentPage,
		pageSize : 10,
        sysIndexType : 2
	}
	$.ajax({
		url : $api.sysIndex.selectImagesByType,
		type : "POST",
		dataType : "JSON",
		data : {
			"jsonStr" : JSON.stringify(jsonStr)
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
				laytpl(indexProductListTemplate.innerHTML).render(data, function(html) {
					$('#index-prod-list-body').html(html)
				});
			});
			layui.use('laypage', function() {
				layui.laypage({
					cont: $('#index-prod-list-body-page'),
					pages: data.totalPage,
					groups: 2,
					curr: data.currentPage,
					skip: true,
					jump: function (obj,first) {
						if(!first){
                            initIndexProductList(obj.curr);
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
 * 用户列表搜索框查询
 */
$('#sys-user-search-form').submit(function() {
	layerLoad = layer.load();
    initIndexProductList(1);
	return false;
});

/**
 * 数据删除
 */
$('#index-prod-list-body').on('click','.btn-sys-index-delete',function(){
	var jsonStr = {
        sysIndexId: $(this).attr('sysIndexId')
	}
	$.ajax({
		url : $api.sysIndex.deleteByPrimaryKey,
		type : "POST",
		dataType : "JSON",
		data : {
			"jsonStr" : JSON.stringify(jsonStr)
		},
		beforeSend : function () {
			layerLoad = layer.load();
		},
		success : function(data,e) {
			if(!$checkRemouteStatus(data)){
				layer.close(layerLoad);
				return;
			}
			layer.msg(data.msg, {icon: 1});
            initIndexProductList(1);
			layer.close(layerLoad);
		},
		error : function() {
			layer.close(layerLoad);
			layer.msg('网络异常，请稍后再试', {icon: 2});
		}
	});
});

$('#index-prod-list-body').on('click', '.btn-sys-index-update', function() {
	var jsonStr = {
		"sysIndexId" : $(this).attr('sysIndexId')
	};
	$.ajax({
		url : $api.sysIndex.selectByPrimaryKey,
		type : "POST",
		dataType : "JSON",
		data : {
			"jsonStr" : JSON.stringify(jsonStr)
		},
		beforeSend : function () {
			layerLoad = layer.load();
		},
		success : function(data,e) {
			if(!$checkRemouteStatus(data)){
				layer.close(layerLoad);
				return;
			}
			$('#sysIndexIdUpdate').val(data.msg.sysIndexId);
			$('#sysIndexNameUpdate').val(data.msg.sysIndexName);
			$('#sysIndexImageContentUpdate').val(data.msg.sysIndexImageContent);
			if(data.msg.sysIndexImageUrl){
				$('#sysIndexImageUrlUpdate').attr('src',data.fileUrlPre + data.msg.sysIndexImageUrl)
			}
			layer.close(layerLoad);
		},
		error : function() {
			layer.close(layerLoad);
			layer.msg('网络异常，请稍后再试', {icon: 2});
		}
	});
	layer.open({
		type : 1,
		title : '用户信息修改',
		area : 'auto',
		maxWidth : '1000px',
		content : $('#index-product-list-update-model'),
		cancel : function(){
			$('#update-index-product-list')[0].reset();
			$('#sysUserImgUrlUpdate').attr('src',$assets.headChooseIcon);
		}
	});
});

/**
 * 商品展示信息修改
 */
$('#update-index-product-list').submit(function() {
    if(!$checkFormVal('#add-index-product-list')){
        layer.msg('数据没有填写完整，请检查', {icon: 2});
        return false;
    }
    var sysIndex = {
        sysIndexId: $('#sysIndexIdUpdate').val(),
        sysIndexName : $('#sysIndexNameUpdate').val(),
        sysIndexImageContent : $('#sysIndexImageContentUpdate').val(),
        sysIndexType : 2
    };
    var formData = new FormData();
    formData.append('file', _currentFileObj);
    formData.append('jsonStr',JSON.stringify(sysIndex));
    $.ajax({
        url : $api.sysIndex.createOrUpdateIndexImage,
        type : "POST",
        dataType : "JSON",
        data : formData,
        beforeSend : function () {
            layerLoad = layer.load();
        },
        contentType: false, // 注意这里应设为false
        processData: false,
        cache: false,
        success : function(data) {
            if(!$checkRemouteStatus(data)){
                layer.close(layerLoad);
                return;
            }
            layer.closeAll('page');
            if(data.code == '111111'){
                layer.msg(data.msg, {icon: 2});
            }else{
                layer.msg(data.msg, {icon: 1});
                $('#add-index-product-list')[0].reset();
                $('#sysIndexImageUrl').attr('src',$assets.headChooseIcon);
                initIndexProductList(1);
            }
            layer.close(layerLoad);
        },
        error : function() {
            layer.close(layerLoad);
            layer.msg('网络异常，请稍后再试', {icon: 2});
        }
    });
	return false;
});

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
