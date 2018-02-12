package com.hxkj.xhupubmed.core.utils;

import org.junit.Test;

public class PropertiesTest {

	@Test
	public void test01(){
		System.out.println(PropertiesUtils.getPropertiesValue("FILE_URL"));
		PropertiesUtils.getPropertiesValue("FILE_URL");
	}
}
