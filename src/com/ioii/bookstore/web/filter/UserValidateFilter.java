package com.ioii.bookstore.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns={
	"/pages/manager.jsp","/pages/order/order.jsp","/pages/user/*",
	"/do/order","/do/consignee"
})
public class UserValidateFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest reqt, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) reqt;
		HttpServletResponse resp = (HttpServletResponse) res;
		if(req.getSession().getAttribute("user") == null){
			resp.sendRedirect(req.getServletContext().getContextPath()+"/pages/login_register.jsp");
		}else{
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
