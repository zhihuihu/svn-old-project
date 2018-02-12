<%--
  Created by IntelliJ IDEA.
  User: huzhihui
  Date: 2016/4/25
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="base_component/jquery-2.1.4/jquery.min.js"></script>
    <script type="text/javascript" src="js/demo.js"></script>
    <title>接口测试文档</title>
</head>
<body>
<button id="btn1">管理员登录接口测试</button><hr>
主页测试
<input type="file" name="indexPageFile" id="indexPageFile">
<button id="btn2">主页图片的上传</button><<hr>
缩略图<input type="file" name="mingpinthuiThumbUrl"><br>
主图1<input type="file" name="mingpinthuiMainImageUrl1"><br>
<button id="btn3">名品汇提交</button>
<hr>
<button id="btn4">删除一个名品汇</button>
<button id="btn5">获取,名品汇分页查询</button>
<hr>
图片<input type="file" name="pingLifeMainUrl"><br>
<button id="btn6">新增或者更新品生活</button>
<button id="btn7">通过主键查询品生活</button>
<button id="btn8">通过主键删除品生活</button>
<button id="btn9">新增普通类型的品生活</button>
<button id="btn10">分页查询通过属性</button>
<button id="btn11">通过主键更新</button>
<hr>
<button id="btn12">增加一个富文本内容</button>
<button id="btn13">修改富文本内容</button>
</body>
</html>
