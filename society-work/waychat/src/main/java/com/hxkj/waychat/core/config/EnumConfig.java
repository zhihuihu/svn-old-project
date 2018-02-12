package com.hxkj.waychat.core.config;

/**
 * @ClassName: EnumConfig 
 * @Description: 枚举工具配置
 * @author huzhihui_c@qq.com
 * @date 2016年7月20日 上午10:00:11
 */
public enum EnumConfig {

	/**
	 * SYS_USER_TYPE:系统管理员
	 */
	SYS_USER_TYPE_ADMIN(1,"系统管理员",EnumConfig.SYS_USER_TYPE),
	/**
	 * SYS_USER_TYPE:普通用户
	 */
	SYS_USER_TYPE_NORMAL(2,"普通用户",EnumConfig.SYS_USER_TYPE);
	
	/**
	 * 用户类型
	 */
	public static final String SYS_USER_TYPE = "SYS_USER_TYPE";
	
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
