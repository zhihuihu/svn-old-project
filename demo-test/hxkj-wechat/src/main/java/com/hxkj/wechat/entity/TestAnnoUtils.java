package com.hxkj.wechat.entity;

import java.lang.reflect.Field;

import com.hxkj.wechat.annotation.TestAnno;

public class TestAnnoUtils {
	public static void getFruitInfo(Class<?> clazz){
        
        String strFruitName=" 水果名称：";
        String strFruitColor=" 水果颜色：";
        String strFruitProvicer="供应商信息：";
        
        Field[] fields = clazz.getDeclaredFields();
        
        for(Field field :fields){
            if(field.isAnnotationPresent(TestAnno.class)){
            	TestAnno fruitName = (TestAnno) field.getAnnotation(TestAnno.class);
                strFruitName=strFruitName+fruitName.fruitColor();
                System.out.println(strFruitName);
            }
        }
    }
	
	public static void main(String[] args) {
		TestAnnoUtils.getFruitInfo(TestAnnoBean.class);
	}
}
