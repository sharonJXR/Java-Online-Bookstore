package com.ioii.bookstore.model.dao;

import java.util.WeakHashMap;

import com.ioii.bookstore.model.dao.impl.BookChapterDaoImpl;
import com.ioii.bookstore.model.dao.impl.BookDaoImpl;
import com.ioii.bookstore.model.dao.impl.ConsigneeDaoImpl;
import com.ioii.bookstore.model.dao.impl.OrderDaoImpl;
import com.ioii.bookstore.model.dao.impl.OrderItemDaoImpl;
import com.ioii.bookstore.model.dao.impl.UserDaoImpl;


@SuppressWarnings("rawtypes")
public final class DaoFactory {
	private final static WeakHashMap<String, ICommonDao> map = new WeakHashMap<>();
	
	public static ICommonDao getDao(String name){
		ICommonDao dao = map.get(name);
		if(dao != null)
			return dao;
		return createDao(name);
	}

	private synchronized static ICommonDao createDao(String name) {
		ICommonDao dao = null;
		if("book".equals(name)){
			dao = new BookDaoImpl();
			map.put(name, dao);
		}
		if("user".equals(name)){
			dao = new UserDaoImpl();
			map.put(name, dao);
		}
		if("consignee".equals(name)){
			dao = new ConsigneeDaoImpl();
			map.put(name, dao);
		}
		if("order".equals(name)){
			dao = new OrderDaoImpl();
			map.put(name, dao);
		}
		if("orderItem".equals(name)){
			dao = new OrderItemDaoImpl();
			map.put(name, dao);
		}
		if("bookChapter".equals(name)){
			dao = new BookChapterDaoImpl();
			map.put(name, dao);
		}
		return dao;
	}
}
