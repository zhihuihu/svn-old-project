<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>photocms server</title>
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
$(function(){
	var aa = {"specialContent":{"specialContentHot":"10"},"currentPage":1,"lineSize":10};
	$.ajax({
	    url : "http://localhost:8080/photocms.server/specialContent/getSpecialContentByAttributeAnd.html",//注意在这里的请求路径上面不能加上/否则就会出现400错误，无法找到请求路径
	    type : "POST",
	    dataType : "JSON",
	    data : {"dataInBean":JSON.stringify(aa)},
	    success : function(data) {
	        alert(data);
	    },
	    error : function() {
	        alert(JSON.stringify(aa));
	        alert("error");
	    },
	    fail : function() {
	        alert("fail");
	    }
	});
});

		
</script>
</head>
<body>
<center><h1>Welcome to photocms server index file</h1></center>
</body>
</html>