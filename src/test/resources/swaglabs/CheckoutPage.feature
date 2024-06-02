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
    And User clicks on Continue button
    Then User navigates to Checkout Overview page
    And User clicks on Finish button
    Then User navigates to Checkout Complete page
    And User clicks on Back Home button
    Then User is navigated to the Dashboard

  @CancelCheckoutWithoutAnyInformation @TC09
  Scenario: Cancel Checkout without Any Information
    When User clicks the Checkout Button
    And User clicks on Cancel button
    Then User is navigated back to the Cart page

  @CompleteThenCancelCheckoutWithValidInfo @TC17
  Scenario: Complete and Then Cancel Checkout with Valid Info
    When User clicks the Checkout Button
    And User enters field with valid data
    And User clicks on Continue button
    And User clicks on Cancel button
    Then User is navigated back to the Cart page