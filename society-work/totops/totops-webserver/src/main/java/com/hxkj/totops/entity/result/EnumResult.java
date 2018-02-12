package com.hxkj.totops.entity.result;

/**
 * @ClassName: EnumResult 
 * @Description: 枚举返回json到页面的bean
 * @author huzhihui_c@qq.com
 * @date 2016年7月20日 上午10:56:30
 */
public class EnumResult {

	private int index;
	
	private String value;

	public EnumResult(int index,String value){
		this.index = index;
		this.value = value;
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
	
}
