Feature: Swag Labs Dashboard Page

  Background:
    Given User was on dashboard page

  @F02TC0.0.1
  Scenario: Display product catalog on dashboard
    When Observe the catalog list display image catalog
    And Observe the catalog list display name catalog
    And Observe the catalog list display price catalog
    Then The page displays all product catalog lists

  @F02TC0.0.7
  Scenario: "Add to Cart" button is pressed, item added to cart page
    When User press the Add to Cart button in product
    Then The item is successfully added to the cart

  @F02TC0.0.8
  Scenario: "Add to Cart" button is pressed, button changes to remove
    When User clicks the Add to Cart button in product
    Then The Add to Cart button changes to Remove after the product is added to the cart