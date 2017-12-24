package com.ioii.bookstore.model.entity;

import java.io.Serializable;

public class CartItem implements Serializable {
	private static final long serialVersionUID = 3611449065193934279L;
	private Book book;
	private int quantity = 1;

	public CartItem() {
	}

	public CartItem(Book book) {
		this.book = book;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotal() {
		return book.getSellingPrice() * quantity;
	}

}
