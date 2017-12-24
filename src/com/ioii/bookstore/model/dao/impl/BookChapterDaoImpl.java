package com.ioii.bookstore.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ioii.bookstore.common.JdbcTemplate;
import com.ioii.bookstore.common.JdbcTemplate.PreparedStatementSetter;
import com.ioii.bookstore.common.JdbcTemplate.RowCallBackHandler;
import com.ioii.bookstore.model.entity.BookChapter;

public class BookChapterDaoImpl extends CommonDaoImpl<BookChapter> {

	@Override
	public List<BookChapter> findByConditions(final String... conditions) {
		return JdbcTemplate.query(
				"select * from book_chapters where book_id = ?", 
				new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement pstmt) throws SQLException {
						pstmt.setInt(1, Integer.parseInt(conditions[0]));
					}
				}, 
				createHandler());
	}

	private RowCallBackHandler<BookChapter> createHandler() {
		return new RowCallBackHandler<BookChapter>(){
			@Override
			public BookChapter processRow(ResultSet rs) throws SQLException {
				BookChapter chapter = new BookChapter();
				chapter.setBookId(rs.getInt("book_Id"));
				chapter.setChapterId(rs.getInt("chapter_Id"));
				chapter.setId(rs.getInt("id"));
				chapter.setName(rs.getString("name"));
				return chapter;
			}
			
		};
	}

	
}
