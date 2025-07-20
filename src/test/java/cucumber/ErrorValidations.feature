@teg
Feature: Error Validations
  I want to use this template for my feature file

 
  @ErrorValidations
  Scenario Outline: Positive Test of Submitting the Order
   Given I landed on Ecommerce Page 
   When Given I login with username "<name>" and password "<password>"
   Then   "Incorrect email or password." message is dsplayed

 Examples: 
      | name                   | password     |
      | balaarun009@gmail.com  | Arunn#01207  |
