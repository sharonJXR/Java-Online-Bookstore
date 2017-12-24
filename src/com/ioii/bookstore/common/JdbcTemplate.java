package com.ioii.bookstore.common;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class JdbcTemplate {
	public static <T> List<T> query(String sql, RowCallBackHandler<T> handler) {
		return query(sql, null, handler);
	}

	public static <T> List<T> query(String sql, PreparedStatementSetter setter,
			RowCallBackHandler<T> handler) {
		ResultSet rs = null;
		List<T> list = null;
		try {
			rs = query(sql, setter);
			if (handler != null) {
				list = new ArrayList<>();
				while (rs.next()) {
					list.add(handler.processRow(rs));
				}
			}
		} catch (SQLException e) {
			throw new JdbcTemplateException(e);
		} finally {
			DBUtil.release(rs);
		}
		return list;
	}

	public static <T> T singleQuery(String sql, RowCallBackHandler<T> handler) {
		return singleQuery(sql, null, handler);
	}

	public static <T> T singleQuery(String sql, PreparedStatementSetter setter,
			RowCallBackHandler<T> handler) {
		ResultSet rs = null;
		try {
			rs = query(sql, setter);
			if (handler != null && rs.next()) {
				return handler.processRow(rs);
			}
		} catch (SQLException e) {
			throw new JdbcTemplateException(e);
		} finally {
			DBUtil.release(rs);
		}
		return null;
	}

	private static ResultSet query(String sql, PreparedStatementSetter setter)
			throws SQLException {
		PreparedStatement pstmt = ConnectionManager.getConnection()
				.prepareStatement(sql);
		if (null != setter)
			setter.setValues(pstmt);
		return pstmt.executeQuery();
	}

	public static int[] batch(String sql, PreparedStatementSetter...setters) {
		PreparedStatement pstmt = null;
		try {
			pstmt = ConnectionManager.getConnection().prepareStatement(sql);
			for (PreparedStatementSetter setter : setters){
				setter.setValues(pstmt);
				pstmt.addBatch();
			}
			return pstmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new JdbcTemplateException(e);
		} finally {
			DBUtil.release(pstmt);
		}
	}

	public static int update(String sql, PreparedStatementSetter setter) {
		PreparedStatement pstmt = null;
		boolean isInsert = sql.toLowerCase().startsWith("insert");
		try {
			pstmt = ConnectionManager.getConnection().prepareStatement(sql);
			if (null != setter) {
				setter.setValues(pstmt);
			}
			int row = pstmt.executeUpdate();
			if (isInsert) {
				return getPrimaryKey(sql);
			}
			return row;
		} catch (SQLException e) {
			throw new JdbcTemplateException(e);
		} finally {
			DBUtil.release(pstmt);
		}
	}

	private static int getPrimaryKey(String sql) {
		String tableName = getTableName(sql);
		String seqName = "seq_" + tableName + "_id";
		ResultSet rs = null;
		try {
			rs = ConnectionManager.getConnection()
					.prepareStatement("select " + seqName + ".currval from dual")
					.executeQuery();
			if(rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			DBUtil.release(rs);
		}

		return 0;
	}

	private static String getTableName(String sql) {
		Matcher m = Pattern.compile("(?i)insert\\s+(into\\s+)?[^\\(\\s]+")
				.matcher(sql);
		while (m.find()) {
			return m.group().replaceAll("(?i)insert\\s+(into\\s+)?", "");
		}
		return null;
	}

	public static class JdbcTemplateException extends RuntimeException {
		private static final long serialVersionUID = -7127691293598353977L;

		public JdbcTemplateException() {
			super();
		}

		public JdbcTemplateException(String message, Throwable cause,
				boolean enableSuppression, boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
		}

		public JdbcTemplateException(String message, Throwable cause) {
			super(message, cause);
		}

		public JdbcTemplateException(String message) {
			super(message);
		}

		public JdbcTemplateException(Throwable cause) {
			super(cause);
		}

	}

	public static interface PreparedStatementSetter {
		void setValues(PreparedStatement pstmt) throws SQLException;
	}

	public static interface RowCallBackHandler<T> {
		T processRow(ResultSet rs) throws SQLException;
	}
}
