package com.ioii.bookstore.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ioii.bookstore.model.entity.Book;
import com.ioii.bookstore.model.service.ServiceFactory;

@WebServlet("/do/book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = -8886605921433466705L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String _id = req.getParameter("id");
		int id = 1;
		try {
			id = Integer.parseInt(_id);
		} catch (NumberFormatException e) {
		}
		Book book = (Book) ServiceFactory.getService("book").findById(id);
		req.setAttribute("book", book);
		getServletContext().getRequestDispatcher("/pages/book/detail.jsp").forward(req, resp);
	}
}
