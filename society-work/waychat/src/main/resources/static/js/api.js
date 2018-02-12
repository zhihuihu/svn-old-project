//var urlPre = 'http://localhost:8080/';
var urlPre = 'http://192.168.0.22:8080/';
/**
 * 服务器请求json路径对象
 */
var serverUrl = {
	sysUser : {
		userLogin : urlPre + 'sysUser/userLogin',							//用户登录
		userRegister : urlPre + 'sysUser/userRegister',						//用户注册
		checkUserLoginName : urlPre + 'sysUser/checkUserLoginName'			//用户登录名校验
	}	
};
/**
 * 跳转页面的对象
 */
var serverHtmlUrl = {
	sysUser : {
		login : urlPre + 'sysUser/login',									//登录页面
		register : urlPre + 'sysUser/register'								//注册页面
	},
	index : urlPre + 'index'												//主页
};