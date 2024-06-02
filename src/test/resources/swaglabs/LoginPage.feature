Feature: Login to Swag Labs

  Background:
    Given User is on Swag Labs Login page

  @ValidAccount @TC01
  Scenario: Login berhasil dengan akun yang valid
    When User enters username as "standard_user" and password as "secret_sauce"
    Then User should be logged in successfully

  @UsernameEmpty @TC02
  Scenario: Login gagal disebabkan username tidak diisi
    When User enters username as "" and password as "secret_sauce"
    Then User should see an error message "You need Username !"

  @PasswordEmpty @TC03
  Scenario: Login gagal disebabkan password tidak diisi
    When User enters username as "standard_user" and password as ""
    Then User should see an error message "You need Password !"

  @UsernameInvalid @TC04
  Scenario Outline: Login with invalid username
    When User enters username as "<username>" and password as "<password>"
    Then User should see an error message "<errorMessage>"

    Examples:
      | username      | password     | errorMessage                                                  | test case        |
      | super_user    | secret_sauce | Username and password do not match any user in this service ! | invalid username |

  @PasswordInvalid @TC05
  Scenario Outline: Login with invalid password
    When User enters username as "<username>" and password as "<password>"
    Then User should see an error message "<errorMessage>"

    Examples:
      | username      | password     | errorMessage                   | test case        |
      | standar_user  | admin123     | Username and password do not match any user in this service ! | invalid password |

  @EmptyUsernamePassword @TC06
  Scenario: Login with blank username and password
    When User enters username as "" and password as ""
    Then User should see an error message "You need Username & Password !"

  @Logout @TC07
  Scenario: User Logout
    Given User was on dashboard page
    When User click hamburger menu
    And User Click Logout
    Then User navigate to login page