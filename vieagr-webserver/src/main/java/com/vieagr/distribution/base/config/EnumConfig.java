package com.vieagr.distribution.base.config;

/**
 * 枚举定义
 * @author master
 *
 */
public enum EnumConfig {
	
	/**
	 * 统一：1、启用，2、禁用
	 */
	SYSTEM_UNIFIED_STATE_START_USING(1, "启用", "system_used"), 
	
	SYSTEM_UNIFIED_STATE_END_USING(2, "禁用",  "system_used"),
	
	/*
	 * 统一：1、已删除，2、未删除
	 */
	SYSTEM_IS_NOT_DELETE(1, "未删除",  "system_delete"),
	
	SYSTEM_IS_DELETE(2, "已删除",  "system_delete"),
	
	/**
	 * 统一：1、男，2、女
	 */
	SYSTEM_SEX_MAN(1, "男",  "system_sex"), 
	
	SYSTEM_SEX_WOMAN(2, "女",  "system_sex"), 
	
	/**
	 * 车辆等级，1、普通型，2、豪华型
	 */
	SYS_VEHICLES_GRADE_ORDINARY(1, "普通型", "sys_vehicles_grade"), 
	
	SYS_VEHICLES_GRADE_LUXURIOUS(2, "豪华型", "sys_vehicles_grade"), 
	
	/**
	 * 车辆类型，小型货车，中型货车，大型货车，其他
	 */
	SYS_VEHICLES_TYPE_MINIVANS(1, "型货小车", "sys_vehicles_type"), 
	
	SYS_VEHICLES_TYPE_MEDIUM_TRUCK(2, "中型货车", "sys_vehicles_type"), 
	
	SYS_VEHICLES_TYPE_LARGE_TRUCK(3, "大型货车", "sys_vehicles_type"), 
	
	SYS_VEHICLES_TYPE_OTHER(4, "其他", "sys_vehicles_type"), 
	
	/**
	 * 用户类型，1、超级管理员，2、普通用户
	 */
	SYS_USER_TYPE_ADMINISTRATOR(1, "超级管理员", "sys_user_type"), 
	
	SYS_USER_TYPE_DOMESTIC(2, "普通用户", "sys_user_type"), 
	
	/**
	 * 系统文件类型，1、图片，2、excel表格，3、word文档，4、其他
	 */
	SYS_FILE_TYPE_IMAGE(1, "图片", "sys_file_type"), 
	
	SYS_FILE_TYPE_EXCEL(2, "excel表格", "sys_file_type"), 
	
	SYS_FILE_TYPE_WORD(3, "word文档", "sys_file_type"), 
	
	SYS_FILE_TYPE_OTHER(4, "其他", "sys_file_type"), 
	
	/**
	 * 客户类型，1、普通客户，2、VIP用户
	 */
	SYS_CUSTOMER_TYPE_COMMOM(1, "普通客户", "sys_customer_type"), 
	
	SYS_CUSTOMER_TYPE_VIP(2, "VIP客户", "sys_customer_type"), 
	
	/**
	 * 客户等级，1、小型买家客户，2中型买家客户，3、大型买家客户
	 */
	SYS_CUSTOMER_GRADE_MINIATURE(1, "小型买家客户", "sys_customer_grade"), 
	
	SYS_CUSTOMER_GRADE_MIDSIZE(2, "中型买家客户", "sys_customer_grade"), 
	
	SYS_CUSTOMER_GRADE_LARGE(3, "大型买家客户", "sys_customer_grade"), 
	
	/**
	 * 订单类型，1、普通订单，2、员工餐订单
	 */
	SER_ORDER_TYPE_ORDINARY(1, "普通订单", "ser_order_type"), 
	
	SER_ORDER_TYPE_STAFF_MEAL(2, "员工餐订单", "ser_order_type"), 
	
	SER_ORDER_TYPE_MODEL(3, "配送模板订单", "ser_order_type"), 
	
	/**
	 * 订单状态，1、待备货，2、待配送，3、配送中，4、已配送完成，5、配送遇到问题，6、已取消
	 */
//	SER_ORDER_STAT_TO_BE_READY(1, "待备货", "ser_order_state"), 
	
	SER_ORDER_STATE_TO_BE_DISTRIBUTION(2, "待配送", "ser_order_state"), 
	
//	SER_ORDER_STAT_DISTRIBUTION_IN(3, "配送中", "ser_order_state"), 
	
	SER_ORDER_STAT_COMPLETION_OF_DISTRIBUTION(4, "已配送完成", "ser_order_state"),
	
	SER_ORDER_STAT_PROBLEM_OF_DISTRIBUTION(5, "配送遇到问题", "ser_order_state"), 
	
	SER_ORDER_STAT_CANCEL(6, "已取消", "ser_order_state"), 

	/**
	 * 订单反馈状态，1、配送成功，2、配送失败，3、其他
	 */
	SER_ORDER_BACK_STATE_SUCCESS(1, "订单配送成功", "ser_order_return_state"), 
	
	SER_ORDER_BACK_STATE_ERROR(2, "订单配送失败", "ser_order_return_state"), 
	
	SER_ORDER_BACK_STATE_OTHER(3, "其他", "ser_order_return_state"), 
	
	/**
	 * 送货单反馈状态，1、客户成功收货，2、客户拒绝收货
	 */
	SER_DELIVER_BACK_STATE_SUCCESS(1, "客户成功收货", "ser_delivery_return_state"), 
	
	SER_DELIVER_BACK_STATE_ERROR(2 , "客户拒绝收货", "ser_delivery_return_state"),
	
	/**
	 * 登录状态返回，1、登录成功， 2、用户名或密码错误，3、用户类型错误
	 */
	LOGIN_SUCCESS(1, "登录成功", "login_state"),
	
	LOGIN_ERROR_FOR_INFO(2, "用户名或密码错误", "login_state"),
	
	LOGIN_ERROR_FOR_USER_YPPE(3, "用户类型错误", "login_state"),
	
	/**
	 * 日统计账单业务类型1、总统计、2客户统计'
	 */
	BILL_CENSUS_SERVICE_TYPE_TOTAL(1, "总统计", "bill_census"),
	
	BILL_CENSUS_SERVICE_TYPE_CUSTOMER(2, "客户统计", "bill_census");
	
	
	private Integer index;
	
	private String name;

	private String group;
	
    private EnumConfig(Integer index, String name, String group) {
    	this.index = index;
        this.name = name;
        this.group = group;
    }
	
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 根据枚举的索引，获取名称
	 * 
	 * @param index	枚举索引
	 * @return		返回索引对应的名称(name)
	 */
	public static String getName(Integer index, String group) {
        for (EnumConfig e : EnumConfig.values()) {
            if (e.getIndex().equals(index) && e.getGroup().equals(group)) {
                return e.name;
            }
        }
        return null;
    }
	
	/**
	 * 根据枚举的名称，获取索引
	 * 
	 * @param name	枚举名称
	 * @return		返回索引对应的索引(index)
	 */
	public static Integer getIndex(String name, String group){
		for (EnumConfig e : EnumConfig.values()) {
			if(e.getName().equals(name) && e.getGroup().equals(group)){
				return e.index;
			}
		}
		return null;
	}
}
