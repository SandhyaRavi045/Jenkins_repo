package org.cap.service;

import org.cap.dao.IAccountDao;
import org.cap.exception.AccountNotFound;
import org.cap.exception.InsufficientBalance;
import org.cap.exception.InvalidCustomer;
import org.cap.exception.InvalidOpeningBalance;
import org.cap.model.Account;
import org.cap.model.Customer;
import org.cap.util.AccountUtil;

public class AccountServiceImpl implements IAccountService {
	
	private IAccountDao accountDao;
	public  AccountServiceImpl() {
		
	}
public  AccountServiceImpl(IAccountDao accountDao2) {
		accountDao=accountDao2;
	}

	@Override
	public Account createAccount(Customer customer,double amount) throws InvalidCustomer, InvalidOpeningBalance {
		if(customer!=null) {
			if(amount >= 500) {
				Account account=new Account();
				account.setCustomer(customer);
				account.setAccountNo(AccountUtil.generateAccountNo());
				account.setOpeningBalance(amount);
				
				boolean flag=accountDao.addAccount(account);
				if(flag)
					return account;
				else
					return null;
			} else {
				throw new InvalidOpeningBalance("Sorry");
			}
		} else {
			throw new InvalidCustomer("Sorry! Customer value is null");
		}
		
	}
	@Override
	public Account findAccount(int accountNo) {
		
		return accountDao.findAccount(accountNo);
	}
	@Override
	public Account withdraw(int accountNo, double amount_withdraw) throws AccountNotFound, InsufficientBalance {
		
		Account account=accountDao.findAccount(accountNo);
		if(account==null)
			throw new AccountNotFound("Sorry! accountNo does not exist");
		if(amount_withdraw>account.getOpeningBalance())
			throw new InsufficientBalance("Sorry! Insufficient Balance");
		account.setOpeningBalance(account.getOpeningBalance()-amount_withdraw);
		return account;
		
		
	}
	@Override
	public Account updateBalance(int accountNo, double amount) {
		// TODO Auto-generated method stub
		return accountDao.updateBalance(accountNo, amount);
	}
	@Override
	public Account deposit(int accountNo, double amount_withdraw) throws AccountNotFound {
		Account account=accountDao.findAccount(accountNo);
		if(account==null)
			throw new AccountNotFound("Sorry! accountNo does not exist");
		account.setOpeningBalance(account.getOpeningBalance()+amount_withdraw);
		return account;
	}
}
