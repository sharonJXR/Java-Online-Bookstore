package com.ioii.bookstore.model.service.imple;

import java.io.Serializable;
import java.util.List;

import com.ioii.bookstore.model.service.ICommonService;

public abstract class CommonServiceImpl<T extends Serializable> implements ICommonService<T> {

	@Override
	public List<T> findAll() {
		return null;
	}

	@Override
	public T findById(int id) {
		return null;
	}

	@Override
	public int save(T t) {
		return 0;
	}

	@Override
	public List<T> findByConditions(String... conditions) {
		return null;
	}

}
