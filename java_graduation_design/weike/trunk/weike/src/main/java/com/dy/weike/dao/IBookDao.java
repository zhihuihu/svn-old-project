package com.dy.weike.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dy.weike.entity.Book;
/**
 * 推荐书籍db层
 * @author d-y
 *
 */
@Repository
public interface IBookDao extends IBaseDao<Book> {
	/**
	 * 通过关键字查找
	 * @param b
	 * @return
	 */
	List<Book> selectByKeyword(Book b);

}
