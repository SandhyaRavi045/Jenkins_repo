package org.cap.dao;

import org.cap.exception.AccountNotFound;
import org.cap.model.Account;

public interface IAccountDao {

	public boolean addAccount(Account account);
	public Account findAccount(int accountNo);
	public Account withdraw(int accountNo, double amount_withdraw);
	public Account updateBalance(int accountNo, double amount);
	public Account deposit(int accountNo, double amount_withdraw) throws AccountNotFound;
}
