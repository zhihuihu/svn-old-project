/**
 * Created by huzhihui on 2016/4/25.
 */
$(function () {
   $('#btn1').on('click',function () {
      var sysUser = {
         sysUserLoginName:'admin',
         sysUserPassword:'123456'
      };
      var dataInBean = {
         sysUser:sysUser,
         currentPage:1
      };
      $.ajax({
         url:'sysUser/doLogin',
         type:'POST',
         async:false,
         contentType:'application/json',
         dataType:'json',
         data:JSON.stringify(dataInBean),
         success:function (datas) {
            
         },
         error:function () {
            
         }
      })
   });

   $('#btn2').on('click',function () {
      var formData = new FormData();
      var file = $('#indexPageFile')[0].files[0];
      formData.append("indexPageFile",file);
      formData.append("indexPageCuid",'INDEX_PAGE2016042510');
      $.ajax({
         url : 'indexPage/doInsertOrUpdateMainPic',
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

   $('#btn3').on('click',function () {
      var formData = new FormData();
      var mingpinthuiThumbUrl = $('input[name="mingpinthuiThumbUrl"]')[0].files[0];
      var mingpinthuiMainImageUrl1 = $('input[name="mingpinthuiMainImageUrl1"]')[0].files[0];
      formData.append("mingpinthuiThumbUrl",mingpinthuiThumbUrl);
      formData.append("mingpinthuiMainImageUrl1",mingpinthuiMainImageUrl1);
      //formData.append("mingpinthuiCuid","MINGPINHUI2016042911");
      //formData.append("indexPageCuid",'INDEX_PAGE2016042510');
      $.ajax({
         url : 'mingpinhui/doInsertOrUpdateMingpinhui',
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

   $('#btn4').on('click',function () {
      var mingpinhui = {
         mingpinthuiCuid:'MINGPINHUI2016042911'
      }
      $.ajax({
         url : 'mingpinhui/doDeleteByPrimaryKey',
         type : 'POST',
         timeout : 5000,
         contentType:'application/json',
         dataType : "json",
         data : JSON.stringify(mingpinhui),
         success : function(data) {
            alert(data.msg);
         },
         error : function(e) {
            alert(e.msg);
         }
      });
   });


   $('#btn5').on('click',function () {
      var mingpinhui = {
         mingpinthuiCuid:'MINGPINHUI2016042911'
      }
      var dataInBean = {
         currentPage:1,
         pageSize:5,
         mingpinhui:mingpinhui
      }
      $.ajax({
         url : 'mingpinhui/selectByAttributeAnd',
         type : 'POST',
         timeout : 5000,
         contentType:'application/json',
         dataType : "json",
         data : JSON.stringify(dataInBean),
         success : function(data) {
            alert(data.msg);
         },
         error : function(e) {
            alert(e.msg);
         }
      });
   });

   $('#btn6').on('click',function () {
      var formData = new FormData();
      var pingLifeMainUrl = $('input[name="pingLifeMainUrl"]')[0].files[0];
      formData.append("pingLifeMainUrl",pingLifeMainUrl);
      //formData.append("pingLifeCuid","PING_LIFE2016042913");
      //formData.append("indexPageCuid",'INDEX_PAGE2016042510');
      $.ajax({
         url : 'pingLife/doInsertOrUpdateMainImage',
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

   $('#btn7').on('click',function () {
      var pingLife = {
         pingLifeCuid:'PING_LIFE2016042913'
      }
      $.ajax({
         url : 'pingLife/selectByPrimaryKey',
         type : 'POST',
         timeout : 5000,
         contentType:'application/json',
         dataType : "json",
         data : JSON.stringify(pingLife),
         success : function(data) {
            alert(data.msg);
         },
         error : function(e) {
            alert(e.msg);
         }
      });
   });

   $('#btn8').on('click',function () {
      var pingLife = {
         pingLifeCuid:'PING_LIFE2016042913'
      }
      $.ajax({
         url : 'pingLife/doDeleteByPrimaryKey',
         type : 'POST',
         timeout : 5000,
         contentType:'application/json',
         dataType : "json",
         data : JSON.stringify(pingLife),
         success : function(data) {
            alert(data.msg);
         },
         error : function(e) {
            alert(e.msg);
         }
      });
   });

   $('#btn9').on('click',function () {
      var pingLife = {
         pingLifeCategory:'健康生活',
         pingLifeCategoryCode:'JKSH',
         pingLifeTitleName:'测试标题',
         pingLifeType:2
      }
      $.ajax({
         url : 'pingLife/doInsertNorMal',
         type : 'POST',
         timeout : 5000,
         contentType:'application/json',
         dataType : "json",
         data : JSON.stringify(pingLife),
         success : function(data) {
            alert(data.msg);
         },
         error : function(e) {
            alert(e.msg);
         }
      });
   });

   $('#btn10').on('click',function () {
      var pingLife = {
         pingLifeType:2
      }
      var dataInBean = {
         currentPage:1,
         pageSize:5,
         pingLife:pingLife
      }
      $.ajax({
         url : 'pingLife/selectByAttributeAnd',
         type : 'POST',
         timeout : 5000,
         contentType:'application/json',
         dataType : "json",
         data : JSON.stringify(dataInBean),
         success : function(data) {
            alert(data.msg);
         },
         error : function(e) {
            alert(e.msg);
         }
      });
   });

   $('#btn11').on('click',function () {
      var pingLife = {
         pingLifeCuid:'PING_LIFE2016042920',
         pingLifeCategory:'健康生活',
         pingLifeCategoryCode:'JKSH',
         pingLifeTitleName:'测试标题33',
         pingLifeType:2
      }
      $.ajax({
         url : 'pingLife/doUpdateByPrimary',
         type : 'POST',
         timeout : 5000,
         contentType:'application/json',
         dataType : "json",
         data : JSON.stringify(pingLife),
         success : function(data) {
            alert(data.msg);
         },
         error : function(e) {
            alert(e.msg);
         }
      });
   });

   $('#btn12').on('click',function () {
      var richText = {
         pingLifeCuid:'PING_LIFE2016042920',
         richTextContent:'健康生活fsadfasdjasdlfjasdlkfjlkasdjflkasjflksadjfl'
      }
      $.ajax({
         url : 'richText/doInsert',
         type : 'POST',
         timeout : 5000,
         contentType:'application/json',
         dataType : "json",
         data : JSON.stringify(richText),
         success : function(data) {
            alert(data.msg);
         },
         error : function(e) {
            alert(e.msg);
         }
      });
   });


   $('#btn13').on('click',function () {
      var richText = {
         richTextCuid:'RICH_TEXT2016042922',
         pingLifeCuid:'PING_LIFE2016042920',
         richTextContent:'健康生活dfgsdfgsdfgdsfgdfsgdfgdfgdfgsdfgdsgfsadfasdjasdlfjasdlkfjlkasdjflkasjflksadjfl'
      }
      $.ajax({
         url : 'richText/doUpdateByPrimaryKey',
         type : 'POST',
         timeout : 5000,
         contentType:'application/json',
         dataType : "json",
         data : JSON.stringify(richText),
         success : function(data) {
            alert(data.msg);
         },
         error : function(e) {
            alert(e.msg);
         }
      });
   });
});
