/**
 * Created by huzhihui on 2016/4/19.
 */
var schoolProfileCuid = '';
var schoolProfileName = '';
$('#addOneSchoolInformation').on('click',function(){
    if(!schoolProfileCuid || schoolProfileCuid == ''){
        layer.msg('没有选择学校哦,不能进行数据添加',{icon:2});
        return;
    }
    $('#schoolProfileName').val(schoolProfileName);
    $('#showSchoolInformationDetails').modal('show');
    $('#add-schoolInformation').show();
    $('.do-update').hide();
});
$(function(){
    checkSchoolProfileCuid();
    init_function(1);
});


function UrlSearch()
{
    var name,value;
    var str=location.href; //取得整个地址栏
    var num=str.indexOf("?")
    str=str.substr(num+1); //取得所有参数   stringvar.substr(start [, length ]

    var arr=str.split("&"); //各个参数放到数组里
    for(var i=0;i < arr.length;i++){
        num=arr[i].indexOf("=");
        if(num>0){
            name=arr[i].substring(0,num);
            value=arr[i].substr(num+1);
            this[name]=value;
        }
    }
}

function checkSchoolProfileCuid(){
    var Request=new UrlSearch(); //实例化
    schoolProfileCuid = Request.schoolProfileCuid;
    schoolProfileName = decodeURI(Request.schoolProfileName);
    if(!schoolProfileCuid){
        layer.msg('没有选择学校哦,不能进行数据添加',{icon:2});
    }
};

$(document).on('click','#add-schoolInformation',function(){
    var schoolInformationTitle = $('#schoolInformationTitle').val();
    var schoolInformationTag = $('#schoolInformationTag').val();
    var schoolInformationType = $('#schoolInformationType option:selected').val();
    var schoolInformationMainContent = $('#schoolInformationMainContent').val();
    var schoolInformationNotes = $('#schoolInformationNotes').val();
    var schoolInformationIsTop = $('#schoolInformationIsTop option:selected').val();
    var schoolInformation = {
        schoolProfileCuid:schoolProfileCuid,
        schoolInformationTitle:schoolInformationTitle,
        schoolInformationTag:schoolInformationTag,
        schoolInformationType:schoolInformationType,
        schoolInformationMainContent:schoolInformationMainContent,
        schoolInformationNotes:schoolInformationNotes,
        schoolInformationIsTop:schoolInformationIsTop
    };
    var dataInBean = {
        schoolInformation:schoolInformation
    }
    $.ajax({
        url:server_url.schoolInformation.doInsert,
        type:'POST',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            if(data.state == true){
                layer.msg('添加成功!',{time: 2000, icon:1});
                $('#showSchoolInformationDetails').modal('hide')
            }
        }
    });
});

function init_function(currentPage){
    var layerLoad = layer.load(2);
    var schoolInformation = {

    };
    var dataInBean = {
        schoolInformation:schoolInformation,
        searchName:$('#searchName').val(),
        startTime:$('#startTime').val(),
        endTime:$('#endTime').val(),
        currentPage:currentPage,
        lineSize:6
    };
    $.ajax({
        url:server_url.schoolInformation.selectByAttributeAnd,
        type:'POST',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            var appendHtml = template('schoolInformation-template',data);
            $('#jqueryPage').createPage({
                pageCount : data.pageCount,
                current : currentPage,
                backFn : function(p){
                    init_function(p)
                }
            });
            $('#appendBody').html(appendHtml);
            layer.close(layerLoad);
        }
    });
};


$(document).on('click','#searchBtn',function(){
    init_function(1);
});

function showDetails(schoolInformationCuid){
    var schoolInformation = {
        schoolInformationCuid:schoolInformationCuid
    };
    var dataInBean = {
        schoolInformation:schoolInformation
    }
    $.ajax({
        url:server_url.schoolInformation.selectByPrimaryKey,
        type:'POST',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            $('#schoolProfileName').val(data.msg.schoolProfile.schoolProfileName);
            $('#schoolInformationTitle').val(data.msg.schoolInformationTitle);
            $('#schoolInformationTag').val(data.msg.schoolInformationTag);
            $('#schoolInformationType').val(data.msg.schoolInformationType);
            $('#schoolInformationMainContent').val(data.msg.schoolInformationMainContent);
            $('#schoolInformationNotes').val(data.msg.schoolInformationNotes);
            $('#schoolInformationIsTop').val(data.msg.schoolInformationIsTop);
            $('.do-update').attr('schoolInformationCuid',data.msg.schoolInformationCuid);
        }
    });
};

$(document).on('click','.showDetails',function(){
    $('#add-schoolInformation').hide();
    $('.do-update').show();
    showDetails($(this).attr('schoolInformationCuid'));
});

$(document).on('click','.do-delete',function(){
    var schoolInformationCuid = $(this).attr('schoolInformationCuid');
    layer.confirm('是否确定删除', {
        btn: ['确定','取消'] //按钮
    }, function(index){
        layer.close(index);
        do_delete(schoolInformationCuid);
    }, function(){
        layer.msg('操作取消成功', {icon: 1});
    });
});

$(document).on('click','.do-update',function(){
    var schoolInformationCuid = $(this).attr('schoolInformationCuid');
    layer.confirm('是否确定更新', {
        btn: ['确定','取消'] //按钮
    }, function(index){
        layer.close(index);
        do_update(schoolInformationCuid);
    }, function(){
        layer.msg('操作取消成功', {icon: 1});
    });
});

function do_update(schoolInformationCuid) {
    var layerLoad = layer.load(2);
    var schoolInformationTitle = $('#schoolInformationTitle').val();
    var schoolInformationTag = $('#schoolInformationTag').val();
    var schoolInformationType = $('#schoolInformationType option:selected').val();
    var schoolInformationMainContent = $('#schoolInformationMainContent').val();
    var schoolInformationNotes = $('#schoolInformationNotes').val();
    var schoolInformationIsTop = $('#schoolInformationIsTop option:selected').val();
    var schoolInformation = {
        schoolInformationCuid:schoolInformationCuid,
        schoolInformationTitle:schoolInformationTitle,
        schoolInformationTag:schoolInformationTag,
        schoolInformationType:schoolInformationType,
        schoolInformationMainContent:schoolInformationMainContent,
        schoolInformationNotes:schoolInformationNotes,
        schoolInformationIsTop:schoolInformationIsTop
    };
    var dataInBean = {
        schoolInformation:schoolInformation
    }
    $.ajax({
        url:server_url.schoolInformation.doUpdate,
        type:'POST',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            layer.close(layerLoad);
            layer.msg('更新成功', {icon: 1});
            $('#showSchoolInformationDetails').modal('hide');
            init_function(1);

        },
        error:function () {
            layer.close(layerLoad);
        }
    });
};

function do_delete(schoolInformationCuid) {
    var layerLoad = layer.load(2);
    var schoolInformation = {
        schoolInformationCuid:schoolInformationCuid,
        schoolInformationState:4
    };
    var dataInBean = {
        schoolInformation:schoolInformation
    }
    $.ajax({
        url:server_url.schoolInformation.doUpdate,
        type:'POST',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            layer.close(layerLoad);
            layer.msg('删除成功', {icon: 1});
            init_function(1);

        },
        error:function () {
            layer.close(layerLoad);
        }
    });
};