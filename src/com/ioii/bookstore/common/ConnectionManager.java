package com.ioii.bookstore.common;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public final class ConnectionManager {
	private final static ThreadLocal<Connection> LOCAL = new ThreadLocal<>();
	private static DataSource dataSource;

	public static void setDataSource(DataSource dataSource) {
		ConnectionManager.dataSource = dataSource;
	}

	public static Connection getConnection() throws SQLException {
		Connection conn = LOCAL.get();
		if(null != conn)
			return conn;
		conn = dataSource.getConnection();
		LOCAL.set(conn);
		return conn;
	}

	public static void release(){
		Connection conn = LOCAL.get();
		if(null != conn){
			DBUtil.release(conn);
			LOCAL.remove();
		}
	}
	
}
