package org.cap.service;

import org.cap.model.Account;
import org.cap.model.Customer;
import org.cap.util.AccountUtil;

public class AccountServiceImpl implements IAccountService{

	@Override
	public Account createAccount(Customer customer, double amount) {
		
		Account account=null;
		if(customer!=null) {
			account=new Account();
			account.setCustomer(customer);
			if(amount > 0) {
				if(amount==1000) {
					account.setAccountType("savings");
					account.setOpeningBalance(amount);
				} else if(amount==10000) {
					account.setAccountType("current");
					account.setOpeningBalance(amount);
				} else if(amount==100) {
					account.setAccountType("rd");
					account.setOpeningBalance(amount);
				} else if(amount==500) {
					account.setAccountType("fd");
					account.setOpeningBalance(amount);
				}
				
			}
			account.setAccountNo(AccountUtil.generateAccountNo());
			return account;
		}
		return null;
	}

}
