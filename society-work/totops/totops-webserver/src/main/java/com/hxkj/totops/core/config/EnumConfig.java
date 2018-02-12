package com.hxkj.totops.core.config;

/**
 * @ClassName: EnumConfig 
 * @Description: 枚举工具配置
 * @author huzhihui_c@qq.com
 * @date 2016年7月20日 上午10:00:11
 */
public enum EnumConfig {

	/******************************分割线************************************/
	/**
	 * SYS_USER_TYPE:系统管理员
	 */
	SYS_USER_TYPE_ADMIN(1,"系统管理员",EnumConfig.SYS_USER_TYPE),
	/**
	 * SYS_USER_TYPE:普通用户
	 */
	SYS_USER_TYPE_NORMAL(2,"普通用户",EnumConfig.SYS_USER_TYPE),
	/**************SYS_USER_TYPE分割线*****************/
	
	
	
	/**
	 * INDEX_PAGE_TYPE_MAIN:主图类
	 */
	INDEX_PAGE_TYPE_MAIN(1,"主图类",EnumConfig.INDEX_PAGE_TYPE),
	/**
	 * INDEX_PAGE_TYPE_MID:中间
	 */
	INDEX_PAGE_TYPE_MID(2,"中间",EnumConfig.INDEX_PAGE_TYPE),
	/**
	 * INDEX_PAGE_TYPE_BOTTOM:底部
	 */
	INDEX_PAGE_TYPE_BOTTOM(3,"底部",EnumConfig.INDEX_PAGE_TYPE),
	/**************INDEX_PAGE_TYPE分割线*****************/
	
	
	/**
	 * PIN_LIFE_TYPE_LEFT:左边列表
	 */
	PIN_LIFE_TYPE_LEFT(1,"左边列表",EnumConfig.PIN_LIFE_TYPE),
	/**
	 * PIN_LIFE_TYPE_RIGHT_T:右上图片
	 */
	PIN_LIFE_TYPE_RIGHT_T(2,"右上图片",EnumConfig.PIN_LIFE_TYPE),
	/**
	 * PIN_LIFE_TYPE_RIGHT:右边列表
	 */
	PIN_LIFE_TYPE_RIGHT(3,"右边列表",EnumConfig.PIN_LIFE_TYPE),
	/**************PIN_LIFE_TYPE分割线*****************/
	
	
	/**
	 * MING_PIN_HUI_TYPE_ONE:名品汇底部列表类型
	 */
	MING_PIN_HUI_TYPE_ONE(1,"名品汇底部列表类型",EnumConfig.MING_PIN_HUI_TYPE),
	/**************MING_PIN_HUI_TYPE分割线*****************/
	
	
	/**
	 * SYS_FILE_TYPE:图片
	 */
	SYS_FILE_TYPE_IMAGE(1,"",EnumConfig.SYS_FILE_TYPE),
	/**
	 * SYS_FILE_TYPE:文件
	 */
	SYS_FILE_TYPE_FILE(2,"",EnumConfig.SYS_FILE_TYPE),
	/**
	 * SYS_FILE_TYPE:视频
	 */
	SYS_FILE_TYPE_VIDEO(3,"",EnumConfig.SYS_FILE_TYPE);
	/**************SYS_FILE_TYPE分割线*****************/
	
	
	
	/******************************分割线************************************/
	/**
	 * 用户类型
	 */
	public static final String SYS_USER_TYPE = "SYS_USER_TYPE";
	/**
	 * 主页信息类型
	 */
	public static final String INDEX_PAGE_TYPE = "INDEX_PAGE_TYPE";
	/**
	 * 品生活类型
	 */
	public static final String PIN_LIFE_TYPE = "PIN_LIFE_TYPE";
	/**
	 * 名品汇类型
	 */
	public static final String MING_PIN_HUI_TYPE = "MING_PIN_HUI_TYPE";
	/**
	 * 系统文件类型
	 */
	public static final String SYS_FILE_TYPE = "SYS_FILE_TYPE";
	/******************************分割线************************************/
	
	
	
	private int index;
	private String value;
	private String groupType;
	
	private EnumConfig(int index,String value,String groupType){
		this.index = index;
		this.value = value;
		this.groupType = groupType;
	}
	
	public static String getValue(int index,String groupType) {
        for (EnumConfig c : EnumConfig.values()) {
            if (c.getIndex() == index && c.getGroupType().equals(groupType)) {
                return c.value;
            }
        }
        return null;
    }
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getGroupType() {
		return groupType;
	}
	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}
	
	
}
