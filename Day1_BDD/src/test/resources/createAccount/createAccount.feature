@account
Feature: Create New Account
  Create new account for valid customer details


  Scenario: For valid customer create new account
    Given customer details
    When valid customer
    And valid opening balance
    Then create new account
  
  Scenario: For Invalid customer
   For invalid customer details throw error message
    Given Customer details
    When Invalid Customer
    Then throw 'Invalid Customer' error message

	Scenario: For Invalid Opening Balance
	  Given Customer details and opening balance
	  When Invalid opening balance
	  Then throw 'Insufficient Balance' error message
    
    
	Scenario: Find account details
		Find account details for the given account number
		Given Account number
		When Valid Account number
		Then find account details
		
 Scenario: Withdraw Amount from Account
		Find account details for the given account number
		Given Account number 101 and Amount 1000
		When Find account and do withdraw
		Then Update the account details
		
 Scenario: Deposit Amount to Account
		Find account details for the given account number
		Given Account number 101 and Amount 1000
		When Find account and do deposit
		Then Update the account details
 

    

  
