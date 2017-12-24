package com.ioii.bookstore.model.service.imple;

import java.util.List;

import com.ioii.bookstore.model.dao.DaoFactory;
import com.ioii.bookstore.model.entity.Book;
import com.ioii.bookstore.model.entity.Consignee;
import com.ioii.bookstore.model.entity.Order;
import com.ioii.bookstore.model.entity.OrderItem;

public class OrderServiceImpl extends CommonServiceImpl<Order> {

	@Override
	public int save(Order t) {
		int id = DaoFactory.getDao("order").save(t);
		t.setId(id);
		int size = t.getItems().size();
		OrderItem[] items = new OrderItem[size];
		for(int i=0; i<size; i++){
			items[i] = t.getItems().get(i);
			items[i].setOrderId(id);
		}
		int[] arr = DaoFactory.getDao("orderItem").betch(items);
		return id;
	}

	@Override
	public List<Order> findByConditions(String... conditions) {
		List<Order> list = DaoFactory.getDao("order").findByConditions(conditions);
		for(Order order : list){
			List<OrderItem> items = DaoFactory.getDao("orderItem").findByConditions(order.getId()+"");
			for(OrderItem item : items){
				item.setBook((Book)DaoFactory.getDao("book").findById(item.getBook().getId()));
			}
			order.setItems(items);
			order.setConsignee((Consignee) DaoFactory.getDao("consignee").findById(order.getConsignee().getId()));
		}
		return list;
	}
	
	
}
