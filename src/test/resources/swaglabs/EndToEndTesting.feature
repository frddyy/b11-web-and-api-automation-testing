Feature: End To End Testing Swag Labs

  Background:
    Given User Successfully Login

  @EndToEndTesting
  Scenario: Add items
    When User clicks ADD cart button in items
    And User clicks cart page button
    And User in Checkout Information Page
    And User enters valid field data
    And User click continue
    Then User navigate to Page Checkout:Overview
    And User click finish
    Then User navigate to Page Checkout:Complete
    And User clicks Back Home button
    Then User navigate to Dashboard