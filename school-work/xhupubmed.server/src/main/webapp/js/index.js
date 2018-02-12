/**
 * Created by huzhihui on 2016/3/26.
 */
$(function(){
    header_time();
    init();
    $('#menu-list').metisMenu({
        /*toggle: false,
        activeClass: 'li-choose'*/
    });
});


var myApp = angular.module('myApp', ['ui.router']);

myApp.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.when("", "/indexContent");

    $stateProvider
        .state("indexContent", {
            url: "/indexContent",
            templateUrl: "html/indexContent.html"
        })
        .state("dataContent", {/**/
            url: "/dataContent",
            templateUrl: "html/dataContent.html"
        })
        .state("postManager", {/*用户帖子管理*/
            url: "/postManager",
            templateUrl: "html/postManager.html"
        })
        .state("replyManager", {/*帖子回复管理*/
            url: "/replyManager",
            templateUrl: "html/replyManager.html"
        })
        .state("sysUserManager", {/*普通用户管理*/
            url: "/sysUserManager",
            templateUrl: "html/sysUserManager.html"
        })
        .state("editSelf", {/*管理员自己资料管理*/
            url: "/editSelf",
            templateUrl: "html/editSelf.html"
        })
        .state("adminManager", {/*管理员管理*/
            url: "/adminManager",
            templateUrl: "html/adminManager.html"
        })
        .state("schoolProfileManager", {/*学校简介管理*/
            url: "/schoolProfileManager",
            templateUrl: "html/schoolProfileManager.html"
        })
        .state("schoolInformationManager", {/*学校详情管理*/
            url: "/schoolInformationManager",
            templateUrl: "html/schoolInformationManager.html"
        })
        .state("dataSharingSearch", {/*分享信息搜索*/
            url: "/dataSharingSearch",
            templateUrl: "html/dataSharingSearch.html"
        })
        .state("dataSharingAdd", {/*管理员增加分享信息*/
            url: "/dataSharingAdd",
            templateUrl: "html/dataSharingAdd.html"
        })
        .state("informationPushManager", {/*考研信息推送管理*/
            url: "/informationPushManager",
            templateUrl: "html/informationPushManager.html"
        })
        .state("userFeedback", {/*考研信息推送管理*/
            url: "/userFeedback",
            templateUrl: "html/userFeedback.html"
        });
});

function header_time(){
    var timee = new Date();
    var hh = timee.getHours();
    var mm = timee.getMinutes();
    var ss = timee.getSeconds();
    var yy= timee.getFullYear();
    var MM= timee.getMonth()+1;
    var rr= timee.getDate();
    var ww= timee.getDay();
    var days= ["日","一","二","三","四","五","六" ]
    var n=yy+"年" +MM +"月" + rr+"日" + "星期"+days[ww];
    var d=hh+"时"+mm+"分"+ss+"秒";
    $('.header-time').html(n+d);
    setTimeout(header_time,1000);
};

function show_head(indexPage){
	setTimeout("location.reload(true);", 100);
    /*if(indexPage == 1){
        $('#show-page-head').html('系统运行状况');
        setTimeout("location.reload(true);", 300);
        location.reload(true);
    }else if(indexPage == 2){
        $('#show-page-head').html('考研信息推送管理');
        location.reload(true);
    }else if(indexPage == 3){
        $('#show-page-head').html('用户反馈查看');
        location.reload(true);
    }else if(indexPage == 4){
        $('#show-page-head').html('发布帖子管理');
        location.reload(true);
    }else if(indexPage == 5){
        $('#show-page-head').html('帖子回复管理');
        location.reload(true);
    }else if(indexPage == 6){
        $('#show-page-head').html('普通用户管理');
        location.reload(true);
    }else if(indexPage == 7){
        $('#show-page-head').html('个人基本信息维护');
        location.reload(true);
    }else if(indexPage == 8){
        $('#show-page-head').html('系统管理员信息管理');
        location.reload(true);
    }else if(indexPage == 9){
        $('#show-page-head').html('共享信息查看');
        location.reload(true);
    }else if(indexPage == 10){
        $('#show-page-head').html('发布共享信息');
        location.reload(true);
    }else if(indexPage == 11){
        $('#show-page-head').html('学校管理');
        location.reload(true);
    }else if(indexPage == 12){
        $('#show-page-head').html('学校详情属性管理');
        location.reload(true);
    }else if(indexPage == 13){
        $('#show-page-head').html('系统运行状况');
        location.reload(true);
    }else if(indexPage == 14){
        $('#show-page-head').html('系统运行状况');
        location.reload(true);
    }else if(indexPage == 15){
        $('#show-page-head').html('系统运行状况');
        location.reload(true);
    }*/
};

function reflesh_head_show(){
    
};

$(document).on('click','#login-out',function(){
    login_out();
});
function login_out(){
    layer.confirm('是否确定退出', {
        btn: ['确定','取消'],icon: 3, title:'提示' //按钮
    }, function(){
        var layerLoad = layer.load(2);
        $.ajax({
            url:server_url.sysUser.doLoginOut,
            type:'GET',
            async:false,
            dataType:'json',
            data:{
            },
            success:function(data){
                layer.close(layerLoad);
                if(data.state == true){
                    layer.msg('退出成功', {icon: 1});
                    setTimeout('window.location.href="login.html"',2000);
                }else{
                    layer.msg(data.msg,{icon:2});
                }
            }
        });
    }, function(){
    });
};
function init() {
    $.ajax({
        url:server_url.sysUser.selectMydata,
        type:'GET',
        async:false,
        dataType:'json',
        data:{
        },
        success:function(data){
            if(data.state == true){
                $('#admin-name').html(data.sysUserLoginName);
            }else{
                layer.msg(data.msg,{icon:2});
                setTimeout('window.location.href="login.html"',2000);
            }
        }
    });
};