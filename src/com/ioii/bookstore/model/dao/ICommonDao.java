package com.ioii.bookstore.model.dao;

import java.util.List;

public interface ICommonDao<T extends java.io.Serializable> {
	int save(T t);
	int udpate(T t);
	int[] betch(@SuppressWarnings("unchecked") T ...instances);
	int delete(int id);
	int delete(T t);
	T findById(int id);
	List<T> findAll();
	List<T> findByInstance(T t);
	List<T> find(int start,int count,String order);
	List<T> findByConditions(String...conditions);
}
