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
    var replies = {
    };
    var dataInBean = {
        replies:replies,
        searchName:$('#searchName').val(),
        startTime:$('#startTime').val(),
        endTime:$('#endTime').val(),
        currentPage:currentPage,
        lineSize:6
    };
    $.ajax({
        url:server_url.replies.selectByAttributeAnd,
        type:'GET',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            var appendHtml = template('reply-template',data);
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
    var repliesCuid = $(this).attr('repliesCuid');
    layer.confirm('是否确定删除', {
        btn: ['确定','取消'] //按钮
    }, function(index){
        layer.close(index);
        doDelete(repliesCuid)
    }, function(){
        layer.msg('操作取消成功', {icon: 1});
    });

});

function doDelete(repliesCuid) {
    var replies = {
        repliesCuid:repliesCuid
    };
    var dataInBean = {
        replies:replies
    };
    $.ajax({
        url:server_url.replies.doDelete,
        type:'GET',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
        	$('#showReplyDetails').modal('hide');
            layer.msg('删除成功',{icon:1});
            init_search_page_function(1);
        }
    });
};

$(document).on('click','.btn-details',function () {
    selectByPrimaryKey($(this).attr('repliesCuid'));
})

function selectByPrimaryKey(repliesCuid){
    var replies = {
        repliesCuid:repliesCuid
    };
    var dataInBean = {
        replies:replies
    };
    $.ajax({
        url:server_url.replies.selectByPrimaryKey,
        type:'GET',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            var imgUrl = [];
            var appendImgUrl = [];
            if(data.msg.repliesTitle != null && data.msg.repliesTitle != ''){
                imgUrl = data.msg.repliesTitle.split(';');
            }
            for(var i=0;i<imgUrl.length;i++){
                appendImgUrl.push('<a target="_blank" style="max-height: 60px;float: left;" href="'+imgUrl[i]+'"><img style="max-height: 60px" src="'+imgUrl[i]+'"></a>&nbsp;')
            }
            $('#postTitle').val(data.msg.post.postTitle);
            $('#sysUserLoginName').val(data.msg.sysUser.sysUserLoginName);
            $('#repliesTitle').html(appendImgUrl);
            $('#repliesContent').val(data.msg.repliesContent);
            $('#repliesCreateTime').val(data.msg.repliesCreateTime);
            $('#replies-delete-btn').attr('repliesCuid',data.msg.repliesCuid);
        }
    });
}