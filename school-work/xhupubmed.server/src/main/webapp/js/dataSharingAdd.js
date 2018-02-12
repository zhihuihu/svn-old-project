/**
 * Created by huzhihui on 2016/5/10.
 */
var file_number = 0;
var formData = new FormData();
$('#choose-file').on('change',function(){
    var files = this.files;
    for(var i=0;i<files.length;i++){
        if($('.file-name').length >=4){
            layer.msg('文件选择已经超过最大量',{icon:2});
            return;
        }
        formData.append('file_name'+file_number++,files[i]);
        $('#show-file').append('<span class="file-name">'+files[i].name+'<span class="icon icon-trash delete-file" file_name="file_name'+(file_number-1)+'"></span></span>');
    }
});
$(function () {
});

$(document).on('click','.delete-file',function () {
    formData.delete($(this).attr('file_name'));
    $(this).parent().remove();
});

$(document).on('click','.btn-insert',function () {
    if($('#dataSharingTitle').val() == '' || $('#dataSharingTitle').val() == ''){
        layer.msg('请检查输入是否完全',{icon:2});
        return;
    }
    doInsert();
});

function doInsert() {
    var layerLoad = layer.load(2);
    var dataSharing = {
        dataSharingTitle:$('#dataSharingTitle').val(),
        dataSharingType:$('#dataSharingType option:selected').val(),
        dataSharingTag:$('#dataSharingTag').val(),
        dataSharingUrl:$('#dataSharingUrl').val(),
        dataSharingMainContent:$('#dataSharingMainContent').val()
    };
    formData.append('dataSharing',JSON.stringify(dataSharing));
    $.ajax({
        url:server_url.dataSharing.doInsert,
        type:'POST',
        contentType : false,
        processData : false,
        dataType:'json',
        data:formData,
        success:function(data){
            layer.close(layerLoad);
            if(data.state == true){
                layer.msg(data.msg,{icon:1});
                formData = new FormData();
                $('#show-file').html('');
            }else{
                layer.msg(data.msg,{icon:2});
            }
        }
    });


}