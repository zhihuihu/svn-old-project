var layerLoad;

/**
 * 头像裁剪弹出层
 */
/*var headImagePopPage;*/
/**
 * form--增加一个系统用户
 */
$('#add-one-sys-user').submit(function() {
	addOneSysUser();
	return false;
});

/**
 * 新增一个系统用户
 * 
 * @returns
 */
function addOneSysUser() {
	if(!$checkFormVal('#add-one-sys-user')){
		layer.msg('数据没有填写完整，请检查', {icon: 2});
		return false;
	}
	var sysUser = {
		sysUserType : $('#sysUserType').val(),
		sysUserName : $('#sysUserName').val(),
		sysUserMobileNumber : $('#sysUserMobileNumber').val(),
		sysUserPassword : $('#sysUserPassword').val(),
		sysUserImgUrl : $('#sysUserImgUrl').attr('src')
	};
	$.ajax({
		url : $api.sysUser.addOneSysUser,
		type : "POST",
		dataType : "JSON",
		data : {
			"jsonStr" : JSON.stringify(sysUser)
		},
		beforeSend : function () {
			layerLoad = layer.load();
		},
		success : function(data) {
			if(!$checkRemouteStatus(data)){
				layer.close(layerLoad);
				return;
			}
			if(data.code == '111111'){
				layer.msg(data.msg, {icon: 2});
			}else{
				layer.msg(data.msg, {icon: 1});
				$('#add-one-sys-user')[0].reset();
				$('#sysUserImgUrl').attr('src',$assets.headChooseIcon);
				initSysUserList(1);
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
	initSysUserList(1);
})();
/**
 * 列表加载
 * 
 * @param currentPage
 * @returns
 */
function initSysUserList(currentPage) {
	var sysUser = {
		currentPage : currentPage,
		pageSize : 10,
		searchName: $('#sysUserSearchName').val()
	}
	$.ajax({
		url : $api.sysUser.selectSysUserList,
		type : "POST",
		dataType : "JSON",
		data : {
			"jsonStr" : JSON.stringify(sysUser)
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
				laytpl(demo.innerHTML).render(data, function(html) {
					$('#sys-user-list-body').html(html)
				});
			});
			layui.use('laypage', function() {
				layui.laypage({
					cont: $('#sys-user-list-body-page'),
					pages: data.totalPage,
					groups: 2,
					curr: data.currentPage,
					skip: true,
					jump: function (obj,first) {
						if(!first){
							initSysUserList(obj.curr);
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
	initSysUserList(1);
	return false;
});

/**
 * 用户状态变更
 */
$('#sys-user-list-body').on('click','.btn-sys-user-states',function(){
	var sysUser = {
		sysUserId: $(this).attr('sysUserId')
	}
	$.ajax({
		url : $api.sysUser.updateSysUserState,
		type : "POST",
		dataType : "JSON",
		data : {
			"jsonStr" : JSON.stringify(sysUser)
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
			initSysUserList(1);
			layer.close(layerLoad);
		},
		error : function() {
			layer.close(layerLoad);
			layer.msg('网络异常，请稍后再试', {icon: 2});
		}
	});
});

$('#sys-user-list-body').on('click', '.btn-sys-user-update', function() {
	$.ajax({
		url : $api.sysUser.selectByPrimaryKey,
		type : "POST",
		dataType : "JSON",
		data : {
			"sysUserId" : $(this).attr('sysUserId')
		},
		beforeSend : function () {
			layerLoad = layer.load();
		},
		success : function(data,e) {
			if(!$checkRemouteStatus(data)){
				layer.close(layerLoad);
				return;
			}
			$('#sysUserIdUpdate').val(data.msg.sysUserId);
			$('#sysUserTypeUpdate').val(data.msg.sysUserType);
			$('#sysUserNameUpdate').val(data.msg.sysUserName);
			$('#sysUserMobileNumberUpdate').val(data.msg.sysUserMobileNumber);
			$('#sysUserPasswordUpdate').val(data.msg.sysUserPassword);
			if(data.msg.sysUserImgUrl){
				$('#sysUserImgUrlUpdate').attr('src',data.fileUrlPre + data.msg.sysUserImgUrl)
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
		content : $('#sys-user-update-model'),
		cancel : function(){
			$('#update-one-sys-user')[0].reset();
			$('#sysUserImgUrlUpdate').attr('src',$assets.headChooseIcon);
		}
	});
});

/**
 * 用户信息修改
 */
$('#update-one-sys-user').submit(function() {
	var sysUser = {
		sysUserId : $('#sysUserIdUpdate').val(),
		sysUserType : $('#sysUserTypeUpdate').val(),
		/*sysUserName : $('#sysUserNameUpdate').val(),*/
		sysUserMobileNumber : $('#sysUserMobileNumberUpdate').val(),
		sysUserPassword : $('#sysUserPasswordUpdate').val(),
		sysUserImgUrl : $('#sysUserImgUrlUpdate').attr('src')
	}
	$.ajax({
		url : $api.sysUser.updateSysUser,
		type : "POST",
		dataType : "JSON",
		data : {
			"jsonStr" : JSON.stringify(sysUser)
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
			layer.closeAll('page');
			$('#update-one-sys-user')[0].reset();
			$('#sysUserImgUrlUpdate').attr('src',$assets.headChooseIcon);
			initSysUserList(1);
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
 * 头像裁剪
 */
$('#sysUserImgUrlChoose').on('click',function(){
	//初始化裁剪页面
	var headImagePopPage = layer.open({
		type : 1,
		title : '用户头像选择',
		area : 'auto',
		maxWidth : '1000px',
		content : $getCropperHtml('sysUserImgUrlChooseDiv'),
		cancel : function(){
		}
	});
	$initCropper('#sysUserImgUrl',headImagePopPage);
	//end 裁剪页面
});

/**
 * 修改--头像裁剪
 */
$('body').on('click','#sysUserImgUrlUpdateChoose',function(){
	//初始化裁剪页面
	var headImagePopPage = layer.open({
		type : 1,
		title : '用户头像选择',
		area : 'auto',
		maxWidth : '1000px',
		content : $getCropperHtml('sysUserImgUrlChooseDiv'),
		cancel : function(){
		}
	});
	$initCropper('#sysUserImgUrlUpdate',headImagePopPage);
	//end 裁剪页面
});

