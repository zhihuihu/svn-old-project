package com.dy.weike.service.inter;

import com.dy.weike.entity.Exam;
import com.dy.weike.service.IBaseService;

public interface IExamService extends IBaseService<Exam> {
	
	Object selectByAttribute(Exam b);

}
