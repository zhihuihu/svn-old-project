package com.vieagr.distribution.base.config;

/**
 * 静态全局变量
 * @author master
 *
 */
public class Constant {
	/**
	 * 服务器保存图片的物理路径
	 */
	public static final String SERVER_FILE_IMAGE_PHYSICAL_URL_PRE = "server.file.image.physical.url.pre";
	/**
	 * 服务器网站访问路径
	 */
	public static final String SERVER_FILE_IMAGE_WEBSITE_URL_PRE = "server.file.image.website.url.pre";
	/**
	 * 系统启用或禁用
	 */
	public static final String SYSTEM_USED = "system_used";
	/**
	 * 系统删除或未删除
	 */
	public static final String SYSTEM_DELETE = "system_delete";
	/**
	 * 系统性别
	 */
	public static final String SYSTEM_SEX = "system_sex";
	/**
	 * 车辆等级
	 */
	public static final String SYS_VEHICLES_GRADE = "sys_vehicles_grade";
	/**
	 * 车辆类型
	 */
	public static final String SYS_VEHICLES_TYPE = "sys_vehicles_type";
	/**
	 * 用户类型
	 */
	public static final String SYS_USER_TYPE = "sys_user_type";
	/**
	 * 文件类型
	 */
	public static final String SYS_FILE_TYPE = "sys_file_type";
	/**
	 * 客户类型
	 */
	public static final String SYS_CUSTOMER_TYPE = "sys_customer_type";
	/**
	 * 客户等级
	 */
	public static final String SYS_CUSTOMER_GRADE = "sys_customer_grade";
	/**
	 * 订单类型
	 */
	public static final String SER_ORDER_TYPE = "ser_order_type";
	/**
	 * 订单状态
	 */
	public static final String SER_ORDER_STATE = "ser_order_state";
	/**
	 * 订单反馈状态
	 */
	public static final String SER_ORDER_RETURN_STATE = "ser_order_return_state";
	/**
	 * 送货单反馈状态
	 */
	public static final String SER_DELIVERY_RETURN_STATE = "ser_delivery_return_state";
	/**
	 * 登录状态
	 */
	public static final String LOGIN_STATE = "login_state";
	/**
	 * 日统计订单业务类型
	 */
	public static final String BILL_CENSUS = "bill_census";
	/**
	 * 登录之后Session里面登录用户的统一key前缀
	 */
	public static final String SESSION_USER_KEY = "sessionUserKey";
	/**
	 * 登录参数用户名为空
	 */
	public static final String LOGIN_USER_NAME_IS_NULL = "登录参数用户名为空";
	/**
	 * 登录参数用户密码为空
	 */
	public static final String LOGIN_USER_PASSWORD_IS_NULL = "登录参数密码为空";
	/**
	 * 登录参数用户类型为空
	 */
	public static final String LOGIN_USER_TYPE_IS_NULL = "登录参数用户类型为空";
	/**
	 * 返回成功状态码
	 */
	public static final String RESPONSE_CODE_SUCCESS = "000000";
	/**
	 * 返回失败状态码
	 */
	public static final String RESPONSE_CODE_ERROR = "111111";
	/**
	 * 成功状态返回
	 */
	public static final String RESPONSE_STATE_SUCCESS = "666666";
	/**
	 * 失败状态
	 */
	public static final String RESPONSE_STATE_ERROR = "555555";
	/**
	 * 返回成功状态信息
	 */
	public static final String RESPONSE_MESSAGE_SUCCESS = "操作成功";
	/**
	 * 返回失败状态信息
	 */
	public static final String RESPONSE_MESSAGE_ERROR = "系统繁忙";
	/**
	 * 登录时不保存登录信息
	 */
	public static final String IS_NOT_CACHE_COOKIE_FOR_LOGIN = "0";
	/**
	 * 登录时保存登录信息
	 */
	public static final String IS_CACHE_COOKIE_FOR_LOGIN = "1";
	/**
	 * 存入cookie的登录信息统一key
	 */
	public static final String LOGIN_INFO_CACHE_COOKIE_KEY = "loginInfoCacheCookieKey";
	/**
	 * 登录时cookie保存用户信息的时长
	 */
	public static final Integer IS_CACHE_COOKIE_USER_INFO_MAX_AGE = 60 * 60 * 24 *30;
	/**
	 * 要删除cookie时给相应cookie设置的时长
	 */
	public static final Integer DELETE_COOKIE_AGE = 0;
	/**
	 * 导出的excel文件为分拣单
	 */
	public static final String EXCEL_TYPE_SORTING_ORDER = "sortingOrder";
	/**
	 * 导出的excel文件为汇总单
	 */
	public static final String EXCEL_TYPE_SUMMARY_ORDER = "summaryOrder";
	/**
	 * 导出的分拣单excel表格名称
	 */
	public static final String EXCEL_SHEET_NAME_SORTING = "分拣单总汇";
	/**
	 * 导出的汇总单excel表格名称
	 */
	public static final String EXCEL_SHEET_NAME_SUMMARY = "汇总单总汇";
	/**
	 * 导出的excel表格每个单元格默认宽度
	 */
	public static final Integer EXCEL_SHEET_DEFAULT_COLUMN_WIDTH = 10;
	/**
	 * 导出的excel表格内容显示不够时是否自动换行
	 */
	public static final Boolean EXCEL_SHEET_WRAP_TEXT = true;
	/**
	 * 导出的excel表头字体大小
	 */
	public static final short EXCEL_SHEET_HEAD_FONT_SIZE = 12;
	/**
	 * 导出的送货单excel表头字体大小
	 */
	public static final short EXCEL_SNED_ORDER_SHEET_HEAD_FONT_SIZE = 16;
	/**
	 * 导出的送货单excel次表头字体大小
	 */
	public static final short EXCEL_SNED_ORDER_SHEET_HEAD_FONT_SIZE_SECOND = 13;
	/**
	 * 导出的送货单excel正文字体大小
	 */
	public static final short EXCEL_SNED_ORDER_SHEET_HEAD_FONT_SIZE_TEXT = 11;
	/**
	 * 导出的excel内容字体大小
	 */
	public static final short EXCEL_SHEET_BODY_FONT_SIZE = 11;
	/**
	 *	导出的excel表头字体类型
	 */
	public static final String EXCEL_SHEET_HEAD_FONT_TYPE = "黑体";
	/**
	 *	导出的excel内容字体类型
	 */
	public static final String EXCEL_SHEET_BODY_FONT_TYPE = "Arial";
	/**
	 * 系统返回成功状态码
	 */
	public static final String SYSTEM_RETURN_STATUS_SUCCESS = "200";
	/**
	 * 系统返回成功状态码
	 */
	public static final String SYSTEM_RETURN_STATUS_SERVER_ERROR = "500";
	/**
	 * 系统返回成功状态码
	 */
	public static final String SYSTEM_RETURN_STATUS_REQUEST_NOT_FOUND = "404";
	/**
	 * 查询失败，不存在该数据
	 */
	public static final String FIND_ERROR = "查询失败，不存在该数据";
	/**
	 * 修改成功
	 */
	public static final String UPDATE_SUCCESS = "修改成功";
	/**
	 * 修改失败
	 */
	public static final String UPDATE_ERROR = "修改失败";
	/**
	 * 数据格式错误
	 */
	public static final String DATA_ERROR = "数据格式错误";
	/**
	 * 增加用户失败返回消息
	 */
	public static final String ADD_USER_FOR_USER_NAME_ERROR = "用户名格式错误，请重新填写";
	/**
	 * 增加用户失败返回消息
	 */
	public static final String ADD_USER_FOR_USER_NAME_IS_USED = "用户名已被注册，请重新填写";
	/**
	 * 增加用户失败返回消息
	 */
	public static final String ADD_USER_FOR_PHONE_NUMBER_ERROR = "手机号码格式错误，请重新填写";
	/**
	 * 增加用户失败返回消息
	 */
	public static final String ADD_USER_FOR_PASSWORD_ERROR = "密码格式错误，请重新填写";
	/**
	 * 增加用户成功返回消息
	 */
	public static final String ADD_USER_SUCCESS = "新增系统用户成功";
	/**
	 * 禁用用户成功
	 */
	public static final String FORBIDDEN_USER_SUCCESS = "禁用用户成功";
	/**
	 * 启用用户成功
	 */
	public static final String START_USER_SUCCESS = "启用用户成功";
	/**
	 * 该车牌号已经添加，请重新输入
	 */
	public static final String ADD_VEHICLES_NUMBER_USED = "该车牌号已经添加，请重新输入";
	/**
	 * 新增送货车辆成功
	 */
	public static final String ADD_VEHICLES_SUCCESS = "新增送货车辆成功";
	/**
	 * 手机号码格式错误，请重新填写
	 */
	public static final String ADD_VEHICLES_FOR_PHONE_NUMBER_ERROR = "手机号码格式错误，请重新填写";
	/**
	 * 新增送货车辆失败，请重新再试
	 */
	public static final String ADD_VEHICLES_ERROR = "新增送货车辆失败，请重新再试";
	/**
	 * 禁用车辆成功
	 */
	public static final String FORBIDDEN_VEHICLES_SUCCESS = "禁用用户成功";
	/**
	 * 启用车辆成功
	 */
	public static final String START_VEHICLES_SUCCESS = "启用用户成功";
	/**
	 * 传入数据格式有误，请检查
	 */
	public static final String SYS_SENDER_DATA_ERROR = "传入数据格式有误，请检查";
	/**
	 * 禁用用户成功
	 */
	public static final String SYS_SENDER_FORBIDDEN_SUCCESS = "禁用用户成功";
	/**
	 * 启用用户成功
	 */
	public static final String SYS_SENDER_START_SUCCESS = "启用用户成功";
	/**
	 * 手机号码格式错误，请重新填写
	 */
	public static final String SYS_SENDER_MOBILE_ERROR = "手机号码格式错误，请重新填写";
	/**
	 * 送货人名重复，请重新填写
	 */
	public static final String SYS_SENDER_NAME_REP = "送货人名重复，请重新填写";
	/**
	 * 送货人增加成功
	 */
	public static final String SYS_SENDER_ADD_SUCCESS = "送货人增加成功";
	/**
	 * 送货人增加失败
	 */
	public static final String SYS_SENDER_ADD_ERROR = "送货人增加失败";
	/**
	 * 顾客增加成功
	 */
	public static final String SYS_CUSTOMER_ADD_SUCCESS = "顾客增加成功";
	/**
	 * 顾客增加失败
	 */
	public static final String SYS_CUSTOMER_ADD_ERROR = "顾客增加失败";
	/**
	 * 顾客名称格式错误
	 */
	public static final String SYS_CUSTOMER_ADD_NAME_ERROR = "顾客名称格式错误";
	/**
	 * 添加顾客时请先添加送货车辆
	 */
	public static final String SYS_CUSTOMER_VEHICLES_ERROR = "添加顾客时请先添加送货车辆";
	/**
	 * 顾客手机号码格式错误
	 */
	public static final String SYS_CUSTOMER_ADD_MOBILE_ERROR = "顾客手机号码格式错误";
	/**
	 * 顾客地址格式错误
	 */
	public static final String SYS_CUSTOMER_ADD_ADDRESS_ERROR = "顾客地址格式错误";
	/**
	 * 顾客门店名称格式错误
	 */
	public static final String SYS_CUSTOMER_ADD_STORY_NAME_ERROR = "顾客门店名称格式错误";
	/**
	 * 该顾客成功被启用
	 */
	public static final String SYS_CUSTOMER_STATE_START = "该顾客成功被启用";
	/**
	 * 该顾客成功被禁用
	 */
	public static final String SYS_CUSTOMER_STATE_END = "该顾客成功被禁用";
	/**
	 * 修改或者添加数据返回成功标志
	 */
	public static final Integer SAVE_OR_UPDATE_SUCCESS_CODE = 1;
	/**
	 * 修改或者添加数据返回失败标志
	 */
	public static final Integer SAVE_OR_UPDATE_ERROR_CODE = 0;
	/**
	 * 请先配置运送车辆
	 */
	public static final String SYS_CUSTOMER_ADD_CAR = "请先配置运送车辆";
	/**
	 * 商品名称重复
	 */
	public static final String SYS_PRODUCT_NAME_REPEAT = "商品名称重复";
	/**
	 * 商品名称格式错误
	 */
	public static final String SYS_PRODUCT_NAME_ERROR = "商品名称格式错误";
	/**
	 * 商品新增成功
	 */
	public static final String SYS_PRODUCT_ADD_SUCCESS = "商品新增成功";
	/**
	 * 商品单价错误
	 */
	public static final String SYS_PRODUCT_PRICE_ERROR = "商品单价错误";
	/**
	 * 商品新增失败，请检查数据是否正确
	 */
	public static final String SYS_PRODUCT_ADD_ERROR = "商品新增失败，请检查数据是否正确";
	/**
	 * 商品禁用成功
	 */
	public static final String SYS_PRODUCT_STATE_END = "商品禁用成功";
	/**
	 * 商品启用成功
	 */
	public static final String SYS_PRODUCT_STATE_START = "商品启用成功";
	/**
	 * 登录失效
	 */
	public static final String LOGIN_LOSE_EFFICACY = "登录失效，请重新登录";
	
	/**
	 * 一周数据分析走势图X轴数据个数
	 */
	public static final Integer CHART_WEEK_OF_COUNT = 0;
	
	/**
	 * 订单金额统计走势图标题
	 */
	public static final String CHART_OF_TITLE = "订单金额统计";
	
	/**
	 * 订单金额统计走势图Y轴标题
	 */
	public static final String CHART_OF_Y_TITLE = "amount of money";
	
	/**
	 * 订单今日走势图折线名称
	 */
	public static final String CHART_OF_LINE_NAME = "订单";
	
	/**
	 * 异常捕获时返回的状态码
	 */
	public static final String EXCEPTION_OF_STATUS = "500";
	
	/**
	 * 异常捕获时返回的响应码
	 */
	public static final String EXCEPTION_OF_CODE = "555555";
	
	/**
	 * 异常捕获时返回的消息
	 */
	public static final String EXCEPTION_OF_MESSAGE = "服务器繁忙，请稍后重试";
	
	/**
	 * 拦截器返回未登陆的响应码
	 */
	public static final String INTERCEPTOR_OF_NOT_LOGIN_CODE = "999999";
	
	/**
	 * 统一修改价格集合数量不统一
	 */
	public static final String UPDATE_PRODUCT_BY_LIST_FOR_SIZE_ERROR = "统一修改商品价格集合数量不统一";
	
	/**
	 * 导出excel标题:序号
	 */
	public static final String DOWNLOAD_EXCEL_ORDER_SEQUENCE = "序号";
	
	/**
	 * 导出excel标题:商品名
	 */
	public static final String DOWNLOAD_EXCEL_ORDER_PRODUCT_NAME = "商品名";
	
	/**
	 * 导出excel:普通订单
	 */
	public static final String DOWNLOAD_EXCEL_ORDINARY_ORDER = "普通订单";
	
	/**
	 * 导出excel:员工餐订单
	 */
	public static final String DOWNLOAD_EXCEL_STAFF_ORDER = "员工餐订单";

	/**
	 * 导出分拣单excel标题:计量单位
	 */
	public static final String DOWNLOAD_EXCEL_SORTING_ORDER_UNIT = "计量单位";
	
	/**
	 * 导出汇总单excel标题:备注
	 */
	public static final String DOWNLOAD_EXCEL_SUMMARY_ORDER_REMARK = "备注";
	
	/**
	 * 导出汇总单excel标题:总量
	 */
	public static final String DOWNLOAD_EXCEL_SUMMARY_ORDER_TOTAL = "总量";
	
	/**
	 * 导出excel的商品列表
	 */
	public static final String DOWNLOAD_EXCEL_PRODUCT_INFOS = "poductInfos";
	
	/**
	 * 导出的送货单公共标题
	 */
	public static final String DOWNLOAD_SEND_ORDER_EXCEL_TITLE = "四川万象农业有限公司——";
	
	/**
	 * 导出送货单的送货人姓名
	 */
	public static final String DOWNLOAD_SEND_ORDER_EXCEL_SENDER_NAME = "梁沅";

	/**
	 * 导出送货单的送货人电话
	 */
	public static final String DOWNLOAD_SEND_ORDER_EXCEL_SENDER_MOBILE = "15202848939";
	
	/**
	 * 更新图片失败
	 */
	public static final String UPDATE_IMAGE_ERROR_ID_NULL = "更新图片失败";
}
