package com.ioii.bookstore.model.service;

import java.util.WeakHashMap;

import com.ioii.bookstore.model.service.imple.BookServiceImpl;
import com.ioii.bookstore.model.service.imple.ConsigneeServiceImpl;
import com.ioii.bookstore.model.service.imple.OrderServiceImpl;
import com.ioii.bookstore.model.service.imple.UserServiceImpl;

@SuppressWarnings("rawtypes")
public final class ServiceFactory {
	private final static WeakHashMap<String, ICommonService> map = new WeakHashMap<>();
	
	public static ICommonService getService(String name){
		ICommonService service = map.get(name);
		if(service != null)
			return service;
		return createService(name);
	}

	private synchronized static ICommonService createService(String name) {
		ICommonService service = null;
		if("book".equals(name)){
			service = new BookServiceImpl();
			map.put(name, service);
		}
		if("user".equals(name)){
			service = new UserServiceImpl();
			map.put(name, service);
		}
		if("consignee".equals(name)){
			service = new ConsigneeServiceImpl();
			map.put(name, service);
		}
		if("order".equals(name)){
			service = new OrderServiceImpl();
			map.put(name, service);
		}
		return service;
	}
}
