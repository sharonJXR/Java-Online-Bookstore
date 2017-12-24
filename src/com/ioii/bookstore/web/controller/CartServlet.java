package com.ioii.bookstore.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ioii.bookstore.model.entity.Book;
import com.ioii.bookstore.model.service.Cart;
import com.ioii.bookstore.model.service.ServiceFactory;

@WebServlet("/do/cart")
public class CartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String _id = req.getParameter("id");
		int id = Integer.parseInt(_id);
		String op = req.getParameter("op");
		Cart cart = getCart(req);
		if("remove".equals(op)){
			cart.remove(id);
		}
		if("add".equals(op)){
			Book book = (Book)ServiceFactory.getService("book").findById(id);
			cart.add(book);
		}
		if("minus".equals(op)){
			Book book = (Book)ServiceFactory.getService("book").findById(id);
		  cart.minus(book);
		}
		String url = req.getHeader("referer");
		resp.sendRedirect(url);
	}

	private Cart  getCart(HttpServletRequest req) {
		Cart cart = (Cart) req.getSession().getAttribute("cart");
		if(null == cart){
			cart = new Cart();
			req.getSession().setAttribute("cart", cart);
		}
		return cart;
	}
}
