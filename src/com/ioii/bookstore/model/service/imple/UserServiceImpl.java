package com.ioii.bookstore.model.service.imple;

import java.util.List;

import com.ioii.bookstore.model.dao.DaoFactory;
import com.ioii.bookstore.model.entity.Account;
import com.ioii.bookstore.model.entity.Consignee;
import com.ioii.bookstore.model.service.ServiceFactory;
@SuppressWarnings("unchecked")
public class UserServiceImpl extends CommonServiceImpl<Account> {

	@Override
	public Account findById(int id) {
		Account account = (Account) DaoFactory.getDao("user").findById(id);
		List<Consignee> consignees = ServiceFactory.getService("consignee").findByConditions(account.getId()+"");
		account.setConsignees(consignees);
		return account;
	}

	@Override
	public int save(Account t) {
		return DaoFactory.getDao("user").save(t);
	}

	@Override
	public List<Account> findByConditions(String... conditions) {
		List<Account> list = (List<Account>)DaoFactory.getDao("user").findByConditions(conditions);
		for(Account account : list){
			List<Consignee> consignees = ServiceFactory.getService("consignee").findByConditions(account.getId()+"");
			account.setConsignees(consignees);
		}
		return list;
	}
	
	
	
}
