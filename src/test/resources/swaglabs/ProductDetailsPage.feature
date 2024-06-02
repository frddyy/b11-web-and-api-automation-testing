Feature: Product Details functionality in Swag Labs

  Background:
    Given User was on dashboard page
    When User clicks on a product image
    Then User navigate to the product details page

  @ProductDescriptionAvailable @TC04
  Scenario: Verify Product Information Page displays correct product description
    When User views the product description
    Then The product description displayed should match the description in the catalog

  @AddProductToTheCart @TC06
  Scenario: Adding a product to the cart
    When User clicks the Add to Cart button
    Then The product should be added to the cart
    And  A notification should indicate the item count in the cart has increased

  @BackToProductCatalog @TC09
  Scenario: Navigate back to the product list
    When User clicks the Back to Product button
    Then User should be navigated back to the dashboard