package com.dy.weike.entity;

import java.io.Serializable;

/**
 * 课程-书籍类
 * @author d-y
 *
 */
public class ClassBook implements Serializable {	
    /**
	 * 创建课程-书籍类的序列化ID
	 */
	private static final long serialVersionUID = 6470613132249689742L;
	/**
	 * 课程ID
	 */
	private int classId;
	/**
	 * 书籍ID 
	 */
    private int bookId;
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	} 
}
