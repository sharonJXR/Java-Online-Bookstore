package com.ioii.bookstore.model.entity;

import java.io.Serializable;

public class BookChapter implements Serializable {
	private static final long serialVersionUID = 4154336879657085514L;
	private int id;
	private String name;
	private int chapterId;
	private int bookId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getChapterId() {
		return chapterId;
	}

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
}
