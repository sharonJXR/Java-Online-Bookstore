package com.ioii.bookstore.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
	private static final long serialVersionUID = 6088641504494966967L;
	private int id;
	private Consignee consignee;
	private Date shoppedDate;
	private String status;
	private String description;
	private List<OrderItem> items = new ArrayList<>();
	
	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Consignee getConsignee() {
		return consignee;
	}

	public void setConsignee(Consignee consignee) {
		this.consignee = consignee;
	}

	public Date getShoppedDate() {
		return shoppedDate;
	}

	public void setShoppedDate(Date shoppedDate) {
		this.shoppedDate = shoppedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public float getTotal(){
		float total = 0;
		for(OrderItem item : items){
			total += item.getTotal();
		}
		return total;
	}
}
