Feature: Cart functionality in Swag Labs

  Background:
    Given User was on dashboard page

  @CartAvailableProduct @TC01
  Scenario: Verifying Cart Page with Items
    When User clicks ADD cart button
    And User clicks the Cart button
    Then User navigate to cart page

  @CartEmptyProduct @TC02
  Scenario: Verifying Cart Page with No Items
    When User clicks the Cart button
    Then User navigate to cart page

  @CheckoutOneItem @TC05
  Scenario: Checkout with One Item
    When User clicks ADD cart button
    And User clicks the Cart button
    Then User navigate to cart page
    When User clicks the Checkout Button
    Then User navigate to Checkout Information page
