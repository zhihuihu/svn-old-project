package com.dy.weike.service.inter;

import com.dy.weike.entity.Book;
import com.dy.weike.service.IBaseService;

public interface IBookService extends IBaseService<Book> {
	
	/**
	 * 通过关键字查找
	 * @param b
	 * @return
	 */
	Object selectByKeyword(Book b);

}
