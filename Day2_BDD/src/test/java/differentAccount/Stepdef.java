package differentAccount;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.cap.model.Account;
import org.cap.model.Address;
import org.cap.model.Customer;
import org.cap.service.AccountServiceImpl;
import org.cap.service.IAccountService;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdef {
	
	private Customer customer;
	private double openingBalance;
	private Account account;
	private IAccountService accountService;
	
	@Before
	public void setup() {
		customer=new Customer();
		accountService=new AccountServiceImpl();
	}

	@Given("^Customer details and opening balance$")
	public void customer_details_and_opening_balance() throws Throwable {
		
		customer.setFirstName("Motu");
		customer.setLastName("Patlu");
		Address address=new Address();
		address.setDoorNo("14");
		address.setCity("Bangalore");
		customer.setAddress(address);
		openingBalance=1000;
		
	    
	}

	@When("^For valid customer with minimum opening balance (\\d+)$")
	public void for_valid_customer_with_minimum_opening_balance(int amount) throws Throwable {
		
		this.openingBalance=amount;
   	}

	@Then("^create new savings account$")
	public void create_new_savings_account() throws Throwable {
	    account=accountService.createAccount(customer, openingBalance);
	    assertNotNull(account);
	    assertEquals("savings", account.getAccountType());
	}

	@Then("^create new current account$")
	public void create_new_current_account() throws Throwable {
		account=accountService.createAccount(customer, openingBalance);
	    assertNotNull(account);
	    assertEquals("current", account.getAccountType());
	}

	@Then("^create new RD account$")
	public void create_new_RD_account() throws Throwable {
		account=accountService.createAccount(customer, openingBalance);
	    assertNotNull(account);
	    assertEquals("rd", account.getAccountType());
	}

	@Then("^create new FD account$")
	public void create_new_FD_account() throws Throwable {
		account=accountService.createAccount(customer, openingBalance);
	    assertNotNull(account);
	    assertEquals("fd", account.getAccountType());
	}
}
