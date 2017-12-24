package com.ioii.bookstore.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.ioii.bookstore.common.TransactionManager;

@WebFilter("/do/*")
public class TransactionFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		try {
			TransactionManager.begin();
			chain.doFilter(req, res);
			TransactionManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			TransactionManager.rollback();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
