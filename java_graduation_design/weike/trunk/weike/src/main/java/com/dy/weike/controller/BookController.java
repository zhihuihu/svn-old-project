package com.dy.weike.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.weike.core.utils.TimeUtils;
import com.dy.weike.entity.Book;
import com.dy.weike.service.inter.IBookService;

@Controller
@RequestMapping(value="book")
public class BookController {
	
	@Resource
	private IBookService iBookService;
	
	/**
	 * 增加一条推荐书籍数据
	 * @param request
	 * @param token
	 * @param reportString
	 * @return
	 */
	@RequestMapping(value="insert")
	@ResponseBody
	public Object insert(HttpServletRequest request,String token,String reportString){
		Book book = new Book();
		book.setAttribute35("预留属性");
		book.setBookAuthor("1");
		book.setBookData(TimeUtils.getMySqlFormatTime());
		book.setBookName("计算机");
		book.setBookPublish("机械学院");
		book.setBookReason("实用");
		book.setBookUrl("url");
		iBookService.insert(book);
		return book;
	}
	

}
