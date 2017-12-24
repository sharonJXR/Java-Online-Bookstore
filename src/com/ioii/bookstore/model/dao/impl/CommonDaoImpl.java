package com.ioii.bookstore.model.dao.impl;

import java.util.List;

import com.ioii.bookstore.model.dao.ICommonDao;

public abstract class CommonDaoImpl<T extends java.io.Serializable> implements ICommonDao<T> {

	@Override
	public int[] betch(@SuppressWarnings("unchecked") T... instances) {
		return null;
	}

	@Override
	public int save(T t) {
		return 0;
	}

	@Override
	public int udpate(T t) {
		return 0;
	}

	@Override
	public int delete(int id) {
		return 0;
	}

	@Override
	public int delete(T t) {
		return 0;
	}

	@Override
	public T findById(int id) {
		return null;
	}

	@Override
	public List<T> findAll() {
		return null;
	}

	@Override
	public List<T> findByInstance(T t) {
		return null;
	}

	@Override
	public List<T> find(int start, int count, String order) {
		return null;
	}

	@Override
	public List<T> findByConditions(String... conditions) {
		return null;
	}

	
}
