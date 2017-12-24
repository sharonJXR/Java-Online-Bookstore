package com.ioii.bookstore.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ioii.bookstore.common.JdbcTemplate;
import com.ioii.bookstore.common.JdbcTemplate.PreparedStatementSetter;
import com.ioii.bookstore.common.JdbcTemplate.RowCallBackHandler;
import com.ioii.bookstore.model.entity.Book;
import com.ioii.bookstore.model.entity.OrderItem;

public class OrderItemDaoImpl extends CommonDaoImpl<OrderItem> {

	@Override
	public int[] betch(OrderItem... instances) {
		return JdbcTemplate.batch(
				"insert into order_items(ORDER_ID,BOOK_ID,QUANTITY) values(?,?,?)", 
				createSetter(instances));
	}
	
	

	@Override
	public List<OrderItem> findByConditions(final String... conditions) {
		return JdbcTemplate.query(
				"select * from order_items where order_id=?", 
				new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement pstmt) throws SQLException {
						pstmt.setInt(1, Integer.parseInt(conditions[0]));
					}
				}, 
				createHandler());
	}



	private RowCallBackHandler<OrderItem> createHandler() {
		return new RowCallBackHandler<OrderItem>(){
			@Override
			public OrderItem processRow(ResultSet rs) throws SQLException {
				OrderItem item = new OrderItem();
				item.setOrderId(rs.getInt("order_Id"));
				item.setQuantity(rs.getInt("quantity"));
				item.setBook(new Book());
				item.getBook().setId(rs.getInt("book_id"));
				return item;
			}};
	}



	private PreparedStatementSetter[] createSetter(final OrderItem[] instances) {
		PreparedStatementSetter[] setters = new PreparedStatementSetter[instances.length];
		for(int i=0,len=instances.length; i<len; i++){
			final OrderItem item = instances[i];
			setters[i] = new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement pstmt) throws SQLException {
					pstmt.setInt(1, item.getOrderId());
					pstmt.setInt(2, item.getBook().getId());
					pstmt.setInt(3, item.getQuantity());
				}
			};
		}
		return setters;
	}
	
}
