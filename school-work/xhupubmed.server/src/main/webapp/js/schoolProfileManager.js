/**
 * Created by huzhihui on 2016/4/19.
 */
$(function(){
    init_function(1);
})
$('#addOneSchoolProfile').on('click',function(){
    $('#showSchoolProfile').modal('show');
    $('.do-update').hide();
    $('.add-schoolProfile').show();
});
$(document).on('click','.add-schoolProfile',function(){
    var schoolProfileName = $('#schoolProfileName').val();
    var schoolProfileIsTop = $('#schoolProfileIsTop option:selected').val();
    var schoolProfileTag = $('#schoolProfileTag').val();
    var schoolProfileBaseProfile = $('#schoolProfileBaseProfile').val();
    var schoolProfileMainProfile = $('#schoolProfileMainProfile').val();
    var schoolProfileBestMajor = $('#schoolProfileBestMajor').val();
    var schoolProfileBestTeacher = $('#schoolProfileBestTeacher').val();
    var schoolProfile = {
        schoolProfileName:schoolProfileName,
        schoolProfileIsTop:schoolProfileIsTop,
        schoolProfileTag:schoolProfileTag,
        schoolProfileBaseProfile:schoolProfileBaseProfile,
        schoolProfileMainProfile:schoolProfileMainProfile,
        schoolProfileBestMajor:schoolProfileBestMajor,
        schoolProfileBestTeacher:schoolProfileBestTeacher
    };
    var dataInBean = {
        schoolProfile:schoolProfile
    }
    $.ajax({
        url:server_url.schoolProfile.doInsert,
        type:'POST',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            if(data.state == true){
                layer.msg('添加成功!',{time: 1000, icon:1});
                $('#showSchoolProfile').modal('hide');
                init_function(1);
            }
        }
    });
});

function init_function(currentPage){
    var schoolProfile = {

    };
    var dataInBean = {
        schoolProfile:schoolProfile,
        searchName:$('#searchName').val(),
        startTime:$('#startTime').val(),
        endTime:$('#endTime').val(),
        currentPage:currentPage,
        lineSize:6
    };
    $.ajax({
        url:server_url.schoolProfile.selectByAttributeAnd,
        type:'POST',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            var appendHtml = template('schoolProfile-template',data);
            $('#jqueryPage').createPage({
                pageCount : data.pageCount,
                current : currentPage,
                backFn : function(p){
                    init_function(p)
                }
            });
            $('#appendBody').html(appendHtml);
        }
    });
};


$(document).on('click','#searchBtn',function(){
    init_function(1);
});

$(document).on('click','.show-details',function(){
    $('.do-update').show();
    $('.add-schoolProfile').hide();
    var schoolProfileCuid = $(this).attr('schoolProfileCuid');
    show_details(schoolProfileCuid);
});


$(document).on('click', '.do-update', function () {
    var schoolProfileCuid = $(this).attr('schoolProfileCuid');
    layer.confirm('是否确定更新', {
        btn: ['确定','取消'] //按钮
    }, function(index){
        layer.close(index);
        do_update(schoolProfileCuid);
    }, function(){
        layer.msg('操作取消成功', {icon: 1});
    });
});
function show_details(schoolProfileCuid){
    var schoolProfile = {
        schoolProfileCuid:schoolProfileCuid
    };
    var dataInBean = {
        schoolProfile:schoolProfile
    }
    $.ajax({
        url:server_url.schoolProfile.selectByPrimaryKey,
        type:'POST',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            $('#schoolProfileName').val(data.msg.schoolProfileName);
            $('#schoolProfileIsTop').val(data.msg.schoolProfileIsTop);
            $('#schoolProfileTag').val(data.msg.schoolProfileTag);
            $('#schoolProfileBaseProfile').val(data.msg.schoolProfileBaseProfile);
            $('#schoolProfileMainProfile').val(data.msg.schoolProfileMainProfile);
            $('#schoolProfileBestMajor').val(data.msg.schoolProfileBestMajor);
            $('#schoolProfileBestTeacher').val(data.msg.schoolProfileBestTeacher);
            $('.do-update').attr('schoolProfileCuid',data.msg.schoolProfileCuid);
        }
    });
};

function do_update(schoolProfileCuid) {
    var schoolProfileName = $('#schoolProfileName').val();
    var schoolProfileIsTop = $('#schoolProfileIsTop option:selected').val();
    var schoolProfileTag = $('#schoolProfileTag').val();
    var schoolProfileBaseProfile = $('#schoolProfileBaseProfile').val();
    var schoolProfileMainProfile = $('#schoolProfileMainProfile').val();
    var schoolProfileBestMajor = $('#schoolProfileBestMajor').val();
    var schoolProfileBestTeacher = $('#schoolProfileBestTeacher').val();
    var schoolProfile = {
        schoolProfileCuid:schoolProfileCuid,
        schoolProfileName:schoolProfileName,
        schoolProfileIsTop:schoolProfileIsTop,
        schoolProfileTag:schoolProfileTag,
        schoolProfileBaseProfile:schoolProfileBaseProfile,
        schoolProfileMainProfile:schoolProfileMainProfile,
        schoolProfileBestMajor:schoolProfileBestMajor,
        schoolProfileBestTeacher:schoolProfileBestTeacher
    };
    var dataInBean = {
        schoolProfile:schoolProfile
    }
    $.ajax({
        url:server_url.schoolProfile.doUpdate,
        type:'POST',
        async:false,
        dataType:'json',
        data:{
            dataInBean:JSON.stringify(dataInBean)
        },
        success:function(data){
            if(data.state == true){
                layer.msg('更新成功!',{time: 1000, icon:1});
                $('#showSchoolProfile').modal('hide');
                init_function(1);
            }
        }
    });
};