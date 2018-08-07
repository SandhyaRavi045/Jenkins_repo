package createAccount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.cap.dao.AccountDaoImpl;
import org.cap.dao.IAccountDao;
import org.cap.model.Account;
import org.cap.model.Address;
import org.cap.model.Customer;
import org.cap.service.AccountServiceImpl;
import org.cap.service.IAccountService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdef {
	
	private Customer customer;
	private double openingBalance;
	private IAccountService accountService;
	private int accountNo;
	private double amount_withdraw;
	@Mock
	private IAccountDao accountDao;
	
	
	

	@Before
	public void setup() {
		
		MockitoAnnotations.initMocks(this);
		customer=new Customer();
		openingBalance=1000;	
		accountService=new AccountServiceImpl(accountDao);
	
		
	}
	@Given("^customer details$")
	public void customer_details() throws Throwable {
	   customer.setFirstName("Motu");
	   customer.setLastName("Patlu");
	   Address address=new Address();
	   address.setDoorNo("14");
	   address.setCity("Bangalore");
	   customer.setAddress(address);
	   
	}

	@When("^valid customer$")
	public void valid_customer() throws Throwable {
	    
		assertNotNull(customer);
	}

	@When("^valid opening balance$")
	public void valid_opening_balance() throws Throwable {
	    assertTrue(openingBalance>0);
	}

	@Then("^create new account$")
	public void create_new_account() throws Throwable {
		
		Account account=new Account();
		account.setAccountNo(1);
		account.setOpeningBalance(1000);
		account.setCustomer(customer);
		
		Mockito.when(accountDao.addAccount(account)).thenReturn(true);
		
	   Account account2=accountService.createAccount(customer, openingBalance);
	   Mockito.verify(accountDao).addAccount(account);
	   
	   assertNotNull(account2);
	   assertEquals(openingBalance, account2.getOpeningBalance(),0.0);
	   assertEquals(1, account2.getAccountNo());
	}

	@Given("^Customer details$")
	public void customer_details1() throws Throwable {
		customer=null;
	}

	@When("^Invalid Customer$")
	public void invalid_Customer() throws Throwable {
		assertNull(customer);
	}

	@Then("^throw 'Invalid Customer' error message$")
	public void throw_Invalid_Customer_error_message() throws Throwable {
		try {
			 accountService.createAccount(customer, 3000);  
		   }
		   catch(Exception e) {
			   
		   }
	}

	@Given("^Customer details and opening balance$")
	public void customer_details_and_opening_balance() throws Throwable {
		openingBalance=100;
	}

	@When("^Invalid opening balance$")
	public void invalid_opening_balance() throws Throwable {
		 assertTrue(openingBalance<500);
	}

	@Then("^throw 'Insufficient Balance' error message$")
	public void throw_Insufficient_Balance_error_message() throws Throwable {
		try {
			 accountService.createAccount(customer, openingBalance);  
		   }
		   catch(Exception e) {
			   
		   }
	}
	
	@Given("^Account number$")
	public void account_number() throws Throwable {
	    accountNo=101;
	}

	@When("^Valid Account number$")
	public void valid_Account_number() throws Throwable {
	    
	}

	@Then("^find account details$")
	public void find_account_details() throws Throwable {
		Account account=new Account();
		account.setAccountNo(101);
		account.setCustomer(customer);
		account.setOpeningBalance(500);
		Mockito.when(accountDao.findAccount(accountNo)).thenReturn(account);
		Account account2=accountService.findAccount(accountNo);
		Mockito.verify(accountDao).findAccount(accountNo);
		assertEquals(account.getAccountNo(), account2.getAccountNo());
	}


	@Given("^Account number (\\d+) and Amount (\\d+)$")
	public void account_number_and_Amount(int accNo, double amount) throws Throwable {
	    this.accountNo=accNo;
	    this.amount_withdraw=amount;
	}

	@When("^Find account and do withdraw$")
	public void find_account_and_do_withdraw() throws Throwable {
		Account account=new Account();
		account.setAccountNo(101);
		account.setCustomer(customer);
		account.setOpeningBalance(10000);
		
		Mockito.when(accountDao.findAccount(101)).thenReturn(account);
		Mockito.when(accountDao.updateBalance(accountNo, 1000)).thenReturn(account);
		
		Account account2=accountService.withdraw(accountNo,amount_withdraw);
		
		Mockito.verify(accountDao).findAccount(101);
		
		//Mockito.verify(accountDao).updateBalance(accountNo, 9000);
		
		
		assertEquals(9000, account2.getOpeningBalance(),0.0);
	}

	@When("^Find account and do deposit$")
	public void find_account_and_do_deposit() throws Throwable {
		Account account=new Account();
		account.setAccountNo(this.accountNo);
		account.setCustomer(customer);
		account.setOpeningBalance(0);
		
		Mockito.when(accountDao.findAccount(this.accountNo)).thenReturn(account);
		Mockito.when(accountDao.updateBalance(accountNo, 1000)).thenReturn(account);
		
		Account account2=accountService.deposit(accountNo,amount_withdraw);
		
		Mockito.verify(accountDao).findAccount(101);
		
		//Mockito.verify(accountDao).updateBalance(accountNo, 9000);
		
		
		assertEquals(1000, account2.getOpeningBalance(),0.0);
	}
	
	@Then("^Update the account details$")
	public void update_the_account_details() throws Throwable {
		Account account=new Account();
		account.setAccountNo(101);
		account.setCustomer(customer);
	    account.setOpeningBalance(10000);
		Mockito.when(accountDao.updateBalance(accountNo, 1000)).thenReturn(account);
		Account account2=accountService.updateBalance(accountNo, 1000);
		
		assertEquals(10000, account2.getOpeningBalance(),0.0);
	}

}
