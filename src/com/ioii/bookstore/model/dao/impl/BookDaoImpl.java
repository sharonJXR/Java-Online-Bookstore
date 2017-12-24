package com.ioii.bookstore.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ioii.bookstore.common.JdbcTemplate;
import com.ioii.bookstore.common.JdbcTemplate.PreparedStatementSetter;
import com.ioii.bookstore.common.JdbcTemplate.RowCallBackHandler;
import com.ioii.bookstore.model.entity.Book;

public class BookDaoImpl extends CommonDaoImpl<Book> {

	@Override
	public Book findById(final int id) {
		String sql = "select * from books where id=?";
		return JdbcTemplate.singleQuery(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, id);
			}
		}, createHandler());
	}

	private RowCallBackHandler<Book> createHandler() {
		return new RowCallBackHandler<Book>() {
			@Override
			public Book processRow(ResultSet rs) throws SQLException {
				Book book = new Book();
				book.setAuthor(rs.getString("author"));
				book.setAuthorIntroduction(rs.getString("author_introduction"));
				book.setBookConcern(rs.getString("book_concern"));
				book.setDescription(rs.getString("description"));
				book.setGrade(rs.getInt("grade"));
				book.setId(rs.getInt("id"));
				book.setImage(rs.getString("image"));
				book.setInstroduction(rs.getString("instroduction"));
				book.setIsbn(rs.getString("isbn"));
				book.setName(rs.getString("name"));
				book.setPublishingDate(rs.getTimestamp("publishing_date"));
				book.setPurchasePrice(rs.getFloat("purchase_price"));
				book.setSellingPrice(rs.getFloat("selling_price"));
				return book;
			}
		};
	}

	@Override
	public List<Book> findAll() {
		return JdbcTemplate.query("select *from books", createHandler());
	}

}
