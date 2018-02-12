package com.dy.weike.entity;

import java.io.Serializable;

/**
 * 推荐书籍类
 * @author d-y
 *
 */
public class Book implements Serializable {

	/**
	 * 创建书籍类序列化ID
	 */
	private static final long serialVersionUID = 655047894814219593L;
	/**
	 * 书籍ID
	 */
    private int bookId;
    /**
     * 书籍名称
     */
    private String bookName;
    /**
     * 书籍关键字
     */
    private String attribute35;
    /**
     * 书籍推荐理由
     */
    private String bookReason;
    /**
     * 书籍购买链接
     */
    private String bookUrl;
    /**
     * 书籍出版日期
     */
    private String bookData;
    /**
     * 书籍作者
     */
    private String bookAuthor;
    /**
     * 书籍出版社
     */
    private String bookPublish;
    /**
     * 书籍图片
     */
    private String bookImage;
    
    
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAttribute35() {
		return attribute35;
	}
	public void setAttribute35(String attribute35) {
		this.attribute35 = attribute35;
	}
	public String getBookReason() {
		return bookReason;
	}
	public void setBookReason(String bookReason) {
		this.bookReason = bookReason;
	}
	public String getBookUrl() {
		return bookUrl;
	}
	public void setBookUrl(String bookUrl) {
		this.bookUrl = bookUrl;
	}
	public String getBookData() {
		return bookData;
	}
	public void setBookData(String bookData) {
		this.bookData = bookData;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookPublish() {
		return bookPublish;
	}
	public void setBookPublish(String bookPublish) {
		this.bookPublish = bookPublish;
	}
	public String getBookImage() {
		return bookImage;
	}
	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}	
    
    

}
