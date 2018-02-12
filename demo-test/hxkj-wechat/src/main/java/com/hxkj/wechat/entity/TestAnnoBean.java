package com.hxkj.wechat.entity;

import com.hxkj.wechat.annotation.TestAnno;
import com.hxkj.wechat.annotation.TestAnno.Color;

public class TestAnnoBean {

	@TestAnno(fruitColor=Color.RED)
	private String colorName;

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	
	public static void main(String[] args) {
		TestAnnoBean testAnnoBean = new TestAnnoBean();
		System.out.println(testAnnoBean.getColorName());
	}
}
