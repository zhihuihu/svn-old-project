package com.dy.weike.service.inter;

import com.dy.weike.entity.Ask;
import com.dy.weike.service.IBaseService;

public interface IAskService extends IBaseService<Ask> {
	/**
	 * 通过bean的属性查找
	 * @param b
	 * @return
	 */
	Object selectByAttribute(Ask b);
	Object selectByAttributeByAskerId(Ask b);
	

}
