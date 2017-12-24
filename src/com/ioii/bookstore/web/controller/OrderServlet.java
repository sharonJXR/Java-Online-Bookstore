package com.ioii.bookstore.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ioii.bookstore.model.entity.Account;
import com.ioii.bookstore.model.entity.CartItem;
import com.ioii.bookstore.model.entity.Consignee;
import com.ioii.bookstore.model.entity.Order;
import com.ioii.bookstore.model.entity.OrderItem;
import com.ioii.bookstore.model.service.Cart;
import com.ioii.bookstore.model.service.ServiceFactory;
@WebServlet("/do/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 7379321891697382565L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cart cart = (Cart) req.getSession().getAttribute("cart");
		if(cart == null || cart.getItems().isEmpty()){
			req.setAttribute("order_err", "Please choose book!");
			req.setAttribute("manager_iframe", "pages/order/cart.jsp");
			getServletContext().getRequestDispatcher("/pages/manager.jsp").forward(req, resp);
			return;
		}
		List<OrderItem> items = new ArrayList<>();
		for(CartItem item : cart.getItems()){
			OrderItem orderItem = new OrderItem();
			orderItem.setBook(item.getBook());
			orderItem.setQuantity(item.getQuantity());
			items.add(orderItem);
		}
		Order order = new Order();
		order.setConsignee(new Consignee());
		order.getConsignee().setId(Integer.parseInt(req.getParameter("consigneeId")));
		order.setItems(items);
		int id = ServiceFactory.getService("order").save(order);
		if(id > 0){
			req.getSession().removeAttribute("cart");
		}
		findOrdersByAccount(req, resp);
	}

	private void findOrdersByAccount(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		Account account = (Account) req.getSession().getAttribute("user");
		List<Order> orders = ServiceFactory.getService("order").findByConditions(account.getId()+"");
		req.getSession().setAttribute("orders", orders);
		req.setAttribute("manager_iframe", "pages/order/order.jsp");
		getServletContext().getRequestDispatcher("/pages/manager.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		findOrdersByAccount(req, resp);
	}
	
}
