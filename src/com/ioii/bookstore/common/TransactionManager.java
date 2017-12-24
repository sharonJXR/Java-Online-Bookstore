package com.ioii.bookstore.common;

import java.sql.SQLException;

public final class TransactionManager {

	public static void begin(){
		try {
			ConnectionManager.getConnection().setAutoCommit(false);
		} catch (SQLException e) {
			throw new TransactionException(e);
		}
	}
	
	public static void commit(){
		try {
			ConnectionManager.getConnection().commit();
		} catch (SQLException e) {
			throw new TransactionException(e);
		}finally{
			ConnectionManager.release();
		}
	}
	
	public static void rollback(){
		try {
			ConnectionManager.getConnection().rollback();
		} catch (SQLException e) {
			throw new TransactionException(e);
		}finally{
			ConnectionManager.release();
		}
	}
	
	public static class TransactionException extends RuntimeException{
		private static final long serialVersionUID = -7659193562710793737L;

		public TransactionException() {
		}

		public TransactionException(String message, Throwable cause,
				boolean enableSuppression, boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
		}

		public TransactionException(String message, Throwable cause) {
			super(message, cause);
		}

		public TransactionException(String message) {
			super(message);
		}

		public TransactionException(Throwable cause) {
			super(cause);
		}
		
	}
}
