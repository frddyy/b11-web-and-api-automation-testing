Feature: Checkout functionality in Swag Labs
  Background:
    Given User has added item to cart
    And User has clicked on cart button and navigated to cart page

  Scenario: Verification checkout information page when there is item in the cart
    When User clicks the Checkout Button
    Then User navigate to Checkout Information page
    And There is checkout information title
    And There is checkout info field

  @CompleteCheckoutwithValidInformation @TC01
  Scenario: Complete Checkout with Valid Information
    When User clicks the Checkout Button
    And User enters field with valid data
#    Then User has navigated to checkout overview page
#    And There are card data item with their quantity
#    And There are information payment, shipping and price
#    And There is cancel and finish button