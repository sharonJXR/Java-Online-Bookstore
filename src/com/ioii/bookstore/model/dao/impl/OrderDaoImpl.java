package com.ioii.bookstore.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.ioii.bookstore.common.JdbcTemplate;
import com.ioii.bookstore.common.JdbcTemplate.PreparedStatementSetter;
import com.ioii.bookstore.common.JdbcTemplate.RowCallBackHandler;
import com.ioii.bookstore.model.entity.Consignee;
import com.ioii.bookstore.model.entity.Order;

public class OrderDaoImpl extends CommonDaoImpl<Order> {

	@Override
	public int save(final Order t) {
		int id = JdbcTemplate.update(
				"insert into orders(CONSIGNEE_ID,SHOPPED_DATE) values(?,?)", 
				new JdbcTemplate.PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement pstmt) throws SQLException {
						pstmt.setInt(1, t.getConsignee().getId());
						pstmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
					}
				});
		return id;
	}

	@Override
	public List<Order> findByConditions(final String... conditions) {
		return JdbcTemplate.query(
				"select * from orders where consignee_id in (select id from consignees where account_id=?)",
				new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement pstmt) throws SQLException {
						pstmt.setInt(1, Integer.parseInt(conditions[0]));
					}
				},
				createHandler());
	}

	private RowCallBackHandler<Order> createHandler() {
		return new RowCallBackHandler<Order>(){
			@Override
			public Order processRow(ResultSet rs) throws SQLException {
				Order order = new Order();
				order.setConsignee(new Consignee());
				order.getConsignee().setId(rs.getInt("consignee_id"));
				order.setDescription(rs.getString("description"));
				order.setId(rs.getInt("id"));
				order.setShoppedDate(rs.getTimestamp("shopped_Date"));
				order.setStatus(rs.getString("status"));
				return order;
			}
			
		};
	}

	
}
