package com.ioii.bookstore.model.service.imple;

import java.util.List;

import com.ioii.bookstore.model.dao.DaoFactory;
import com.ioii.bookstore.model.entity.Book;
@SuppressWarnings("unchecked")
public class BookServiceImpl extends CommonServiceImpl<Book> {

	@Override
	public List<Book> findAll() {
		return DaoFactory.getDao("book").findAll();
	}

	@Override
	public Book findById(int id) {
		Book book = (Book) DaoFactory.getDao("book").findById(id);
		book.setChapters(DaoFactory.getDao("bookChapter").findByConditions(id+""));
		return book;
	}
	
}
