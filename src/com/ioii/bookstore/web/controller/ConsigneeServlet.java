package com.ioii.bookstore.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ioii.bookstore.model.entity.Account;
import com.ioii.bookstore.model.entity.Consignee;
import com.ioii.bookstore.model.service.ServiceFactory;

@WebServlet("/do/consignee")
public class ConsigneeServlet extends HttpServlet {
	private static final long serialVersionUID = -361018187476820304L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		String province = req.getParameter("province");
		String city = req.getParameter("city");
		String street = req.getParameter("street");
		Consignee csn = new Consignee();
		csn.setCity(city);
		csn.setFullName(name);
		csn.setExtra(street);
		csn.setProvince(province);
		csn.setTel(tel);
		Account account = (Account) req.getSession().getAttribute("user");
		System.out.println("account id:"+account.getId());
		csn.setAccountId(account.getId());
		int row = ServiceFactory.getService("consignee").save(csn);
		if(row > 0){
			account.getConsignees().add(csn);
		}
		req.setAttribute("manager_iframe", "pages/order/cart.jsp");
		getServletContext().getRequestDispatcher("/pages/manager.jsp")
		.forward(req, resp);
	}
}
