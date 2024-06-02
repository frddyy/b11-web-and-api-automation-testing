Feature: Update User API Tests

  Background:
    Given API environment DUMMYAPI is set up

  @F02TC0.0.1
  Scenario: Update user by Id with an app-id header that is provided but not registered in the system
    Given user is unauthenticated
    When user sends a PUT request with an unregistered app-id and user id with body
    """
    {
        "firstName": "John",
        "lastName": "Doe"
    }
    """
    Then response indicates app-id does not exist with a 403 Forbidden status
    And no database change

  @F02TC0.0.3
  Scenario: Update user by Id without providing an app-id header
    Given user is unauthenticated
    When user sends a PUT request with no app-id and a valid user id with body
    """
    {
        "firstName": "John",
        "lastName": "Doe"
    }
    """
    Then response indicates missing app-id with a 403 Forbidden status
    And no database change

  @F02TC0.0.4
  Scenario: Update user by Id with all fields filled with valid data
    Given user is authenticated with permission to access API
    When user sends a PUT request with a valid registered user id and body
    """
    {
        "title": "mr",
        "firstName": "Aini",
        "lastName": "DIah",
        "gender": "other",
        "dateOfBirth": "2003-08-25",
        "phone": "+1234567890",
        "picture": "https://example.com/profile.jpg",
        "location": {
            "street": "123 Main Street",
            "city": "New York",
            "state": "New York",
            "country": "United States",
            "timezone": "+7:00"
        }
    }
    """
    Then response body shows JSON data of the user with a 200 OK status
    And database condition indicates data changed

  @F02TC0.0.7
  Scenario: Update user by Id with the lastName field filled with valid data
    Given user is authenticated with permission to access API
    When user sends a PUT request with a valid registered user id and body
    """
    {
        "lastName": "Fatmawati"
    }
    """
    Then response body shows JSON data of the user with a 200 OK status
    And database condition indicates lastName changed

  @F02TC0.0.10
  Scenario: Update user by Id with the phone field filled with valid data
    Given user is authenticated with permission to access API
    When user sends a PUT request with a valid registered user id and body
    """
    {
        "phone": "+6285609435"
    }
    """
    Then response body shows JSON data of the user with a 200 OK status
    And database condition indicates phone changed
