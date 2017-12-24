package com.ioii.bookstore.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ioii.bookstore.common.JdbcTemplate;
import com.ioii.bookstore.common.JdbcTemplate.RowCallBackHandler;
import com.ioii.bookstore.model.entity.Consignee;

public class ConsigneeDaoImpl extends CommonDaoImpl<Consignee> {

	@Override
	public int save(final Consignee t) {
		int id = JdbcTemplate.update(
				"insert into consignees(ACCOUNT_ID,FULL_NAME,TEL,PROVINCE,CITY,EXTRA) values(?,?,?,?,?,?)", 
				new JdbcTemplate.PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement pstmt) throws SQLException {
						pstmt.setInt(1, t.getAccountId());
						pstmt.setString(2, t.getFullName());
						pstmt.setString(3, t.getTel());
						pstmt.setString(4, t.getProvince());
						pstmt.setString(5, t.getCity());
						pstmt.setString(6, t.getExtra());
					}
				});
		t.setId(id);
		return id;
	}

	@Override
	public Consignee findById(final int id) {
		return JdbcTemplate.singleQuery(
				"select *from consignees where id=?", 
				new JdbcTemplate.PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement pstmt) throws SQLException {
						pstmt.setInt(1, id);
					}
				}, createHandler());
	}

	private RowCallBackHandler<Consignee> createHandler() {
		return new JdbcTemplate.RowCallBackHandler<Consignee>() {
			@Override
			public Consignee processRow(ResultSet rs) throws SQLException {
				Consignee csn = new Consignee();
				csn.setAccountId(rs.getInt("account_id"));
				csn.setCity(rs.getString("city"));
				csn.setExtra(rs.getString("extra"));
				csn.setFullName(rs.getString("full_name"));
				csn.setId(rs.getInt("id"));
				csn.setProvince(rs.getString("province"));
				csn.setTel(rs.getString("tel"));
				return csn;
			}
		};
	}

	@Override
	public List<Consignee> findByConditions(final String... conditions) {
		return JdbcTemplate.query(
				"select * from consignees where account_id=?", 
				new JdbcTemplate.PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement pstmt) throws SQLException {
						pstmt.setInt(1, Integer.parseInt(conditions[0]));
					}
				}, createHandler());
	}

}
