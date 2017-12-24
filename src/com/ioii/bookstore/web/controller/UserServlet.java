package com.ioii.bookstore.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ioii.bookstore.model.entity.Account;
import com.ioii.bookstore.model.service.ServiceFactory;

@WebServlet("/do/user")
@SuppressWarnings({ "unused", "unchecked", "serial" })
public class UserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String op = req.getParameter("op");
		String name = req.getParameter("name").trim();
		String password = req.getParameter("password").trim();
		Account account = new Account();
		account.setAccount(name);
		account.setPassword(password);
		System.out.println(op);
		
	
		if("register".equals(op)){
			doRegister(req, resp, name,  account);
		}else if("login".equals(op)){
			doLogin(req,resp,account);
		}	
	
	}
	

	private void doLogin(HttpServletRequest req, HttpServletResponse resp,
			Account account) throws ServletException, IOException{
		List<Account> list = ServiceFactory.getService("user").findByConditions(account.getAccount());
		if(list.isEmpty() || !list.get(0).getPassword().equals(account.getPassword())){
			req.setAttribute("login_err", "Unknown username or bad password!");
			forward(req, resp,"/pages/login_register.jsp");
			return;
		}
		req.getSession().setAttribute("user", list.get(0));
		resp.sendRedirect(getServletContext().getContextPath()+"/index.jsp");
	}
	

	private void doRegister(HttpServletRequest req, HttpServletResponse resp,
			String name, Account account) throws ServletException, IOException {
		String confirm = req.getParameter("confirm").trim();
		String email = req.getParameter("email").trim();
		account.setEmail(email);	
		if("".equals(name)){
			req.setAttribute("name_err", "The username cannot be empty!");
			forward(req, resp,"/pages/login_register.jsp");
			return;
		}
		
		List<Account> list = ServiceFactory.getService("user").findByConditions(name);
		if(!list.isEmpty()){
			req.setAttribute("name_err", "The username has already existed!");
			forward(req, resp,"/pages/login_register.jsp");
			return;
		}
		int row = ServiceFactory.getService("user").save(account);
		req.getSession().setAttribute("user", account);
		resp.sendRedirect(getServletContext().getContextPath()+"/index.jsp");
	}

	private void forward(HttpServletRequest req, HttpServletResponse resp,String url)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher(url).forward(req, resp);
	}

	
	
}
