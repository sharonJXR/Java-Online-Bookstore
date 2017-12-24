package com.ioii.bookstore.model.service;

import java.io.Serializable;
import java.util.List;

public interface ICommonService<T extends Serializable> {
	List<T> findAll();
	T findById(int id);
	int save(T t);
	List<T> findByConditions(String...conditions);
}
