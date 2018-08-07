
@account
Feature: Create Different new Account
  Create accounts like savings, current, fd, rd

 Scenario Outline: Create different account
    Given Customer details and opening balance
    When For valid customer with minimum opening balance <value>
    Then create new <accountType> account
    
 Examples: 
 
 	| accountType | value |
 	|	savings			|	1000	|
 	|	current			|	10000	|
 	|	  RD			  |	100	  |
 	|	  FD			  |	500	  |
 	