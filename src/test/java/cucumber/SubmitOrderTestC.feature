@Regression
Feature: Purchase from Ecommerce

  Background:
    Given I landed on Ecommerce Page

  Scenario Outline: Positive Order Flow
    Given I login with username "<name>" and password "<password>"
    When I add the product "<productName>" to the cart
    And I checkout the product "<productName>" and submit the order
    Then "Thankyou for the order." message should be displayed on the Confirmation Page

    Examples:
      | name                  | password   | productName      |
      | balaarun009@gmail.com | Arunn#007  | ADIDAS ORIGINAL  |
