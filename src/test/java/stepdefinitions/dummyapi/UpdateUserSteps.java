package stepdefinitions.dummyapi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateUserSteps {

    static {
        System.setProperty("jsse.enableSNIExtension", "false");
        RestAssured.useRelaxedHTTPSValidation(); // Relax HTTPS validation
    }

    private static final Logger logger = LoggerFactory.getLogger(UpdateUserSteps.class);

    private Response response;
    private String baseUrl = "https://dummyapi.io/data/v1/"; // Base URL for your API
    private String appId = "662dd4bdfce0ef07531de25b"; // Your personal app-id
    private String userId = "60d0fe4f5311236168a109d5"; // Assuming this is the user ID for updates and verifications

    // Store original user data
    private Map<String, Object> originalUserData;

    @Given("API environment DUMMYAPI is set up")
    public void api_environment_dummyapi_is_set_up() {
        // Set the base URI for RestAssured
        RestAssured.baseURI = baseUrl;
        logger.info("Base URI set to: " + baseUrl);
        logger.info("App ID set to: " + appId);
    }

    @Given("user is unauthenticated")
    public void user_is_unauthenticated() {
        // No authentication setup needed for unauthenticated user
    }

    @Given("user is authenticated with permission to access API")
    public void user_is_authenticated_with_permission_to_access_api() {
        // Logging for authentication
        logger.info("User authenticated with app-id: " + appId);
    }

    @When("user sends a PUT request with an unregistered app-id and user id with body")
    public void user_sends_a_put_request_with_an_unregistered_app_id_and_user_id_with_body(String body) {
        storeOriginalUserData();
        response = given()
            .header("app-id", "622dd9bdfce0af1111de25b") // Unregistered app-id
            .contentType(ContentType.JSON)
            .body(body)
            .when()
            .put("/user/" + userId);
        response.then().log().all(); // Log response for debugging
    }

    @When("user sends a PUT request with no app-id and a valid user id with body")
    public void user_sends_a_put_request_with_no_app_id_and_a_valid_user_id_with_body(String body) {
        storeOriginalUserData();
        response = given()
            .contentType(ContentType.JSON)
            .body(body)
            .when()
            .put("/user/" + userId);
        response.then().log().all(); // Log response for debugging
    }

    @When("user sends a PUT request with a valid registered user id and body")
    public void user_sends_a_put_request_with_a_valid_registered_user_id_and_body(String body) {
        storeOriginalUserData();
        logger.info("Sending PUT request with app-id: " + appId);
        response = given()
            .header("app-id", appId) // Ensure app-id is included in the request
            .contentType(ContentType.JSON)
            .body(body)
            .when()
            .put("/user/" + userId);
        response.then().log().all(); // Log response for debugging
    }

    @Then("response indicates app-id does not exist with a 403 Forbidden status")
    public void response_indicates_app_id_does_not_exist_with_a_403_forbidden_status() {
        response.then().statusCode(403).body("error", equalTo("APP_ID_NOT_EXIST"));
    }

    @Then("response indicates missing app-id with a 403 Forbidden status")
    public void response_indicates_missing_app_id_with_a_403_forbidden_status() {
        response.then().statusCode(403).body("error", equalTo("APP_ID_MISSING"));
    }

    @Then("response body shows JSON data of the user with a 200 OK status")
    public void response_body_shows_json_data_of_the_user_with_a_200_ok_status() {
        response.then().statusCode(200).contentType(ContentType.JSON);
    }

    @Then("no database change")
    public void no_database_change() {
        // Verify no database change by calling GET User API
        Response getUserResponse = given()
            .header("app-id", appId)
            .when()
            .get("/user/" + userId);
        getUserResponse.then().statusCode(200)
            .body("firstName", equalTo(originalUserData.get("firstName")))
            .body("lastName", equalTo(originalUserData.get("lastName")));
    }

    @Then("database condition indicates data changed")
    public void database_condition_indicates_data_changed() {
        // Verify the change in the database by calling GET User API
        Response getUserResponse = given()
            .header("app-id", appId)
            .when()
            .get("/user/" + userId);
        getUserResponse.then().statusCode(200)
            .body("title", equalTo("mr"))
            .body("firstName", equalTo("Aini"))
            .body("lastName", equalTo("DIah"))
            .body("gender", equalTo("other"))
            .body("dateOfBirth", equalTo("2003-08-25"))
            .body("phone", equalTo("+1234567890"))
            .body("picture", equalTo("https://example.com/profile.jpg"))
            .body("location.street", equalTo("123 Main Street"))
            .body("location.city", equalTo("New York"))
            .body("location.state", equalTo("New York"))
            .body("location.country", equalTo("United States"))
            .body("location.timezone", equalTo("+7:00"));
    }

    @Then("database condition indicates lastName changed")
    public void database_condition_indicates_lastName_changed() {
        // Verify lastName change in the database by calling GET User API
        Response getUserResponse = given()
            .header("app-id", appId)
            .when()
            .get("/user/" + userId);
        getUserResponse.then().statusCode(200).body("lastName", equalTo("Fatmawati"));
    }

    @Then("database condition indicates phone changed")
    public void database_condition_indicates_phone_changed() {
        // Verify phone change in the database by calling GET User API
        Response getUserResponse = given()
            .header("app-id", appId)
            .when()
            .get("/user/" + userId);
        getUserResponse.then().statusCode(200).body("phone", equalTo("+6285609435"));
    }

    private void storeOriginalUserData() {
        Response getUserResponse = given()
            .header("app-id", appId)
            .when()
            .get("/user/" + userId);
        originalUserData = getUserResponse.jsonPath().getMap("");
    }
}
