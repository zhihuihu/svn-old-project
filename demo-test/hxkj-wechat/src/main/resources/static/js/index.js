
$('#main-image-btn').on('click',function(){
	var formData = new FormData();
    var mainImage = $('#main-image')[0].files[0];
    var parameterBeanString = {
    	'indexPage':{
    		'indexPageCuid':'34fe3075-8668-4c30-bc77-82279fdced44',
    		'indexPageMainImageUrl':'www.baidu.com'
    	}	
    };
    formData.append("mainImage",mainImage);
    formData.append('parameterBeanString',JSON.stringify(parameterBeanString));
    $.ajax({
       url : 'admin/indexPage/updateMainImage',
       type : 'POST',
       timeout : 5000,
       contentType : false,
       processData : false,
       dataType : "json",
       data : formData,
       success : function(data) {
          alert(data.msg);
       },
       error : function(e) {
          alert(e.msg);
       }
    });
});

/*var parameterBeanString = {
	'token' : 'b02f1e20-a6ac-41b1-8170-80a8d177a2af',
	'indexPage' : {
		'indexPageCuid' : '32124234342342'
	}
};*/

/*var parameterBeanString = {
	'token' : 'b02f1e20-a6ac-41b1-8170-80a8d177a2af',
	'pinLife' : {
		'pinLifeSmallListParentId' : '32124234342342'
	}
};*/

var parameterBeanString = {
	'token' : 'b02f1e20-a6ac-41b1-8170-80a8d177a2af',
	'pinLife' : {
		'pinLifeLeftTypeName' : '健康生活'
	}
};

var parameterBeanString = {
	'token' : 'b02f1e20-a6ac-41b1-8170-80a8d177a2af',
	'indexPage' : {
		'indexPageCuid' : '32124234342342'
	}
};

$('#json-btn').on('click',function(){
	
	var sysUser = {
		'userName':'huzhihui',
		'userPassword':'1234567'
	};
	
	$.ajax({
        url:'common/testJson',
        type:'POST',
        contentType:'application/json',
        dataType:'json',
        data:JSON.stringify(sysUser),
        success:function (datas) {
           
        },
        error:function () {
           
        }
     })
});