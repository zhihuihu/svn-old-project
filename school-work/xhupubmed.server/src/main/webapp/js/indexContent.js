/**
 * Created by huzhihui on 2016/5/21.
 */
$(function () {
    init();
});

function init(){
    var layerLoad = layer.load(2);
    $.ajax({
        url:server_url.publicData.selectBaseInfo,
        type:'GET',
        async:false,
        dataType:'json',
        data:{
        },
        success:function(data){
            layer.close(layerLoad);
            $('.text1').html(data.show1);
            $('.text2').html(data.show2);
            $('.text3').html(data.show3);
            $('.text4').html(data.show4);
            $('.text5').html(data.show5);
            $('.text6').html(data.show6);
            $('.text7').html(data.show7);
            $('.text8').html(data.show8);
            $('.text9').html(data.show9);
            $('.text10').html(data.show10);
            $('.text11').html(data.show11);
            $('.text12').html(data.show12);
        },
        error:function () {
            layer.close(layerLoad);
        }
    });
}