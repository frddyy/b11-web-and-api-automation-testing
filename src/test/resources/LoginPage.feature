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
    Then User should see an error message "Error Mandatory Checking When Username Not Filled"

  @PasswordEmpty @TC03
  Scenario: Login gagal disebabkan password tidak diisi
    When User enters username as "standard_user" and password as ""
    Then User should see an error message "Error Mandatory Checking When Username & Password Not Filled"
