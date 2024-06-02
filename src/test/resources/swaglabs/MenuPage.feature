Feature: Menu functionality in Swag Labs

  Background:
    Given User was on dashboard page

  @SidebarMenuAvailable @TC05
  Scenario: Open the Menu sidebar
    When User clicks the hamburger icon for the Menu sidebar
    Then The system should display the Menu sidebar with four options: All Items, About, Logout, Reset App State and X button to close the sidebar

  @CloseTheSidebar @TC06
  Scenario: Close the Menu sidebar using the X button
    When User clicks the hamburger icon for the Menu sidebar
    And User clicks the X button to close the sidebar
    Then The Menu sidebar should close
    And The system should display the previous current page

  @NavigateToAbout @TC09
  Scenario: Navigate to About from the Menu
    When User clicks the hamburger icon for the Menu sidebar
    And User clicks the About button
    Then User should be directed to the website information page at "https://saucelabs.com/"
