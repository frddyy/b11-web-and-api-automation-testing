Feature: Create User API Tests

  Background:
    Given API environment DUMMYAPI set up

  @F02TC0.0.1
  Scenario: Create user with a header app-id that is not registered in the system
    Given User is unauthenticated
    When User sends a POST request with an unregistered app-id
    """
    {
        "title": "mr",
        "firstName": "dafa",
        "lastName": "ahmad",
        "gender": "male",
        "email": "dafaahmad@gmail.com",
        "dateOfBirth": "1900-02-02",
        "phone": "0852145899",
        "picture": "https://example.com/dafaahmad.jpg",
        "location": {
            "street": "892, Grande Rue",
            "city": "Besançon",
            "state": "Seine-et-Marne",
            "country": "France",
            "timezone": "+09:00"
        }
    }
    """
    Then Response indicates app-id does not exist with a 403 Forbidden status
    And No database change
