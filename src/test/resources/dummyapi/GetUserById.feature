Feature: Get User By Id API

  @F0.0.1
  Scenario: GetUserById with unregistered app-id header
    Given API environment DUMMYAPI is set up, user is unauthenticated.
    When user sends a GET request with an unregistered app-id and user id
    Then response indicates app-id does not exist with a 403 Forbidden status; no database change.

  @F0.0.2
  Scenario: GetUserById with malformed app-id header
    Given API environment DUMMYAPI is set up, user is unauthenticated.
    When user sends a GET request with a malformed app-id and user id
    Then response indicates app-id does not exist with a 403 Forbidden status; no database change.

  @F0.0.3
  Scenario: GetUserById with missing app-id header
    Given API environment DUMMYAPI is set up, user is unauthenticated.
    When user sends a GET request with no app-id and a valid user id
    Then response indicates missing app-id with a 403 Forbidden status; no database change.

  @F0.0.4
  Scenario: GetUserById with valid and registered user id
    Given API environment DUMMYAPI is set up, user is authenticated with permission to access API.
    When user sends a GET request with a valid registered user id
    Then response body shows JSON data of the user, 200 OK status; no database change.

  @F0.0.5
  Scenario: GetUserById with valid but unregistered user id
    Given API environment DUMMYAPI is set up, user is authenticated with permission to access API.
    When user sends a GET request with an unregistered user id
    Then response indicates resource not found with a 404 Not Found status; no database change.
