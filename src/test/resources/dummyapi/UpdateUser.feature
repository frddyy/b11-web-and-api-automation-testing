Feature: Update User API Tests

  Background:
    Given API environment DUMMYAPI is set up

  @Negative
  Scenario: Update user by Id with an app-id header that is provided but not registered in the system
    Given user is unauthenticated
    When user sends a PUT request with an unregistered app-id and user id
    Then response indicates app-id does not exist with a 403 Forbidden status
    And no database change

  @Negative
  Scenario: Update user by Id without providing an app-id header
    Given user is unauthenticated
    When user sends a PUT request with no app-id and a valid user id
    Then response indicates missing app-id with a 403 Forbidden status
    And no database change

  @Positive
  Scenario: Update user by Id with all fields filled with valid data
    Given user is authenticated with permission to access API
    When user sends a PUT request with a valid registered user id and valid data
    Then response body shows JSON data of the user with a 200 OK status
    And no database change

  @Positive
  Scenario: Update user by Id with the lastName field filled with valid data
    Given user is authenticated with permission to access API
    When user sends a PUT request with a valid registered user id and valid lastName field
    Then response body shows JSON data of the user with a 200 OK status
    And database condition indicates lastName changed

  @Positive
  Scenario: Update user by Id with the phone field filled with valid data
    Given user is authenticated with permission to access API
    When user sends a PUT request with a valid registered user id and valid phone field
    Then response body shows JSON data of the user with a 200 OK status
    And database condition indicates phone changed
