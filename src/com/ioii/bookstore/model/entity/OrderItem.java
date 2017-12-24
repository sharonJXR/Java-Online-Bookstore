package com.ioii.bookstore.model.entity;

import java.io.Serializable;

public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1576133078330427998L;
	private int orderId;
	private Book book;
	private int quantity;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public float getTotal(){
		return quantity * book.getSellingPrice();
	}
}
