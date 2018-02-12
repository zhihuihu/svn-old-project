/**
 * Created by huzhihui on 2016/4/18.
 */
$('#jqueryPage').createPage({
    pageCount : 1,
    current : 1,
    backFn : function(p){
    }
});

$(function () {
    init_search_page_function(1);
});

function init_search_page_function(currentPage){
    var post = {
    };
    var dataInBean = {
        post:post,
        searchName:$('#searchName').val(),
        startTime:$('#startTime').val(),
        endTime:$('#endTime').val(),
        currentPage:currentPage,
        lineSize:6
    };
    $.ajax({
        url:server_url.post.selectByAttributeAnd,
        type:'GET',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            var appendHtml = template('post-template',data);
            $('#jqueryPage').createPage({
                pageCount : data.pageCount,
                current : currentPage,
                backFn : function(p){
                    init_search_page_function(p)
                }
            });
            $('#appendBody').html(appendHtml);
        }
    });
};

$(document).on('click','#searchBtn',function(){
    init_search_page_function(1);
});

$(document).on('click','.btn-delete',function(){
    var postCuid = $(this).attr('postCuid');
    layer.confirm('是否确定删除', {
        btn: ['确定','取消'] //按钮
    }, function(index){
        layer.close(index);
        doDelete(postCuid);
    }, function(){
        layer.msg('操作取消成功', {icon: 1});
    });

});

function doDelete(postCuid) {
    var post = {
        postCuid:postCuid
    };
    var dataInBean = {
        post:post
    };
    $.ajax({
        url:server_url.post.doDelete,
        type:'GET',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
        	$('#showPostDetails').modal('hide');
            layer.msg('删除成功',{icon:1});
            init_search_page_function(1);
        }
    });
};

$(document).on('click','.btn-details',function () {
    selectByPrimaryKey($(this).attr('postCuid'));
})

function selectByPrimaryKey(postCuid){
    var post = {
        postCuid:postCuid
    };
    var dataInBean = {
        post:post
    };
    $.ajax({
        url:server_url.post.selectByPrimaryKey,
        type:'GET',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            var imgUrl = [];
            var appendImgUrl = [];
            if(data.msg.postUrl != null && data.msg.postUrl != ''){
                imgUrl = data.msg.postUrl.split(';');
            }
            for(var i=0;i<imgUrl.length;i++){
                appendImgUrl.push('<a target="_blank" style="max-height: 60px;float: left;" href="'+imgUrl[i]+'"><img style="max-height: 60px" src="'+imgUrl[i]+'"></a>&nbsp;')
            }
            $('#postTitle').val(data.msg.postTitle);
            $('#postUrl').html(appendImgUrl);
            $('#postName').val(data.msg.postName);
            $('#postContent').val(data.msg.postContent);
            $('#postRepliesNumber').val(data.msg.postRepliesNumber);
            $('#postFollowPeopleNumber').val(data.msg.postFollowPeopleNumber);
            $('#postCreateTime').val(data.msg.postCreateTime);
            $('#postUpdateTime').val(data.msg.postUpdateTime);
            $('#post-delete-btn').attr('postCuid',data.msg.postCuid);
        }
    });
}