package com.dy.weike.service.inter;

import com.dy.weike.entity.Activity;
import com.dy.weike.service.IBaseService;

public interface IActivityService extends IBaseService<Activity> {
	/**
	 * 通过bean的属性查找
	 * @param b
	 * @return
	 */
	Object selectByAttibute(Activity b);
}
