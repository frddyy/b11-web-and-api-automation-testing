Feature: Delete User API

  @FC'0.0.1
  Scenario: DeleteUser with unregistered app-id header
    Given API environment DUMMYAPI is set up for DeleteUser and user is unauthenticated
    When user sends a DELETE request with an unregistered app-id and user id
    Then response indicates app-id does not exist with a 403 Forbidden status; database remains unchanged
  
  @FC'0.0.2
  Scenario: DeleteUser with malformed app-id header
    Given API environment DUMMYAPI is set up for DeleteUser and user is unauthenticated
    When user sends a DELETE request with a malformed app-id and user id
    Then response indicates app-id does not exist with a 403 Forbidden status; database remains unchanged

  @FC'0.0.3
  Scenario: DeleteUser with missing app-id header
    Given API environment DUMMYAPI is set up for DeleteUser and user is unauthenticated
    When user sends a DELETE request with no app-id and a valid user id
    Then response indicates missing app-id with a 403 Forbidden status; database remains unchanged

  @FC'0.0.4
  Scenario: DeleteUser with valid and registered user id
    Given API environment DUMMYAPI is set up for DeleteUser and user is authenticated with permission to access API
    When user sends a DELETE request with a valid registered user id
    Then response body shows the user id was successfully deleted, 200 OK status; database reflects user deletion

  @FC'0.0.5
  Scenario: DeleteUser with valid but unregistered user id
    Given API environment DUMMYAPI is set up for DeleteUser and user is authenticated with permission to access API
    When user sends a DELETE request with an unregistered user id
    Then response indicates resource not found with a 404 Not Found status; database remains unchanged
