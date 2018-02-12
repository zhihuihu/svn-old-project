package com.hxkj.photocms.test;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.hxkj.photocms.entity.DataInBean;
import com.hxkj.photocms.entity.DataType;
import com.hxkj.photocms.entity.Special;
import com.hxkj.photocms.entity.SpecialContent;
import com.hxkj.photocms.entity.SpecialType;
import com.hxkj.photocms.entity.SysUser;

/** 
 * Project Name:photocms.server 
 * ClassName:EntityTest
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月23日 上午11:42:28 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class EntityTest {

	@Test
	public void DataInBeanTestJson(){
		DataInBean dataInBean = new DataInBean();
		dataInBean.setDataType(new DataType());
		dataInBean.setSessionId("");
		dataInBean.setSpecial(new Special());
		dataInBean.setSpecialContent(new SpecialContent());
		dataInBean.setSpecialType(new SpecialType());
		dataInBean.setSysUser(new SysUser());
		System.out.println(JSON.toJSONString(dataInBean));
	}
}
