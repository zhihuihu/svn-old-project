package com.dy.weike.controllerClient;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.weike.core.utils.PageBeanUtils;
import com.dy.weike.entity.Book;
import com.dy.weike.service.inter.IBookService;

@Controller
@RequestMapping(value = "client/book")
public class BookClientController {
	
	@Resource
	private IBookService iBookService;
	
	@RequestMapping(value = "showBook")
	@ResponseBody
	public Object showBook(String keyword){
		Book book = new Book();
		book.setAttribute35(keyword);
	    Object bookExist = iBookService.selectByKeyword(book);	
	    if(bookExist != null){
			return PageBeanUtils.formatForNormalTrue("", bookExist);	    	
	    }
	    return PageBeanUtils.formatForNormalFalse("", "不存在相关书籍");
	}
	
	

}
