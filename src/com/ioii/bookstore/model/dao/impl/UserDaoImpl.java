package com.ioii.bookstore.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ioii.bookstore.common.JdbcTemplate;
import com.ioii.bookstore.model.entity.Account;

public class UserDaoImpl extends CommonDaoImpl<Account> {

	@Override
	public int save(final Account t) {
		int id = JdbcTemplate.update(
				"insert into accounts(account,password,email) values(?,?,?)",
				new JdbcTemplate.PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement pstmt) throws SQLException {
						pstmt.setString(1, t.getAccount());
						pstmt.setString(2, t.getPassword());
						pstmt.setString(3, t.getEmail());
					}
				});
		t.setId(id);
		return id;
	}

	@Override
	public Account findById(final int id) {
		return JdbcTemplate.singleQuery(
				"select * from accounts where id = ?", 
				new JdbcTemplate.PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement pstmt) throws SQLException {
						pstmt.setInt(1, id);
					}
				},
				createHandler());
	}

	@Override
	public List<Account> findByConditions(final String... conditions) {
		return JdbcTemplate.query(
				"select *from accounts where account=?", 
				new JdbcTemplate.PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement pstmt) throws SQLException {
						pstmt.setString(1, conditions[0]);
					}
				},
				createHandler());
	}

	private JdbcTemplate.RowCallBackHandler<Account> createHandler(){
		return new JdbcTemplate.RowCallBackHandler<Account>(){
			@Override
			public Account processRow(ResultSet rs) throws SQLException {
				Account account = new Account();
				account.setAccount(rs.getString("account"));
				account.setEmail(rs.getString("email"));
				account.setId(rs.getInt("id"));
				account.setPassword(rs.getString("password"));
				return account;
			}};
	}
	
}
