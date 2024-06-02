Feature: Create User API

  @F0.0.1
  Scenario: Create User with a header app-id that is not registered in the system
    Given API environment DUMMYAPI is set up for CreateUser and user is unauthenticated
    When user sends a POST request with an unregistered app-id
    Then response indicates app-id does not exist with a 403 Forbidden status; no database change
  
  @F0.0.2
  Scenario: Create User with a header app-id in an incorrect format
    Given API environment DUMMYAPI is set up for CreateUser and user is unauthenticated
    When user sends a POST request with a malformed app-id
    Then response indicates app-id does not exist with a 403 Forbidden status; no database change
  
  @F0.0.3
  Scenario: Create User without entering the header app-id
    Given API environment DUMMYAPI is set up for CreateUser and user is unauthenticated
    When user sends a POST request with no app-id and a valid data user
    Then response indicates missing app-id with a 403 Forbidden status; no database change

  @F0.0.4
  Scenario: Create user with all fields filled with valid data types
    Given API environment DUMMYAPI is set up for CreateUser and user is authenticated with permission to access API
    When user sends a POST request with a valid data user
    Then response body shows JSON data of the user, 200 OK status; database change

  @F0.0.5
  Scenario: Create user with the firstName already registered, but lastName and email not registered
    Given API environment DUMMYAPI is set up for CreateUser and user is authenticated with permission to access API
    When user sends a POST request with a valid data user
    Then response body shows JSON data of the user, 200 OK status; database change
