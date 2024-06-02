package stepdefinitions.dummyapi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteUserSteps {

    private static final Logger logger = LoggerFactory.getLogger(DeleteUserSteps.class);

    private Response response;
    private String baseUrl = "https://dummyapi.io/data/v1/"; // Base URL for your API
    private String appId = "662dd4bdfce0ef07531de25b"; // Your personal app-id
    private String userId = "60d0fe4f5311236168a109ce"; // Assuming this is the user ID for updates and verifications

    @Given("API environment DUMMYAPI is set up for DeleteUser and user is unauthenticated")
    public void api_environment_dummyapi_is_set_up_for_delete_user_user_is_unauthenticated() {
        RestAssured.baseURI = baseUrl;
        RestAssured.useRelaxedHTTPSValidation(); // Tambahkan ini untuk melewati pengecekan SSL
        logger.info("Base URI set to: " + baseUrl);
    }

    @Given("API environment DUMMYAPI is set up for DeleteUser and user is authenticated with permission to access API")
    public void api_environment_dummyapi_is_set_up_for_delete_user_user_is_authenticated_with_permission_to_access_api() {
        RestAssured.baseURI = baseUrl;
        RestAssured.useRelaxedHTTPSValidation(); // Tambahkan ini untuk melewati pengecekan SSL
        logger.info("Base URI set to: " + baseUrl);
        logger.info("App ID set to: " + appId);
    }

    @When("user sends a DELETE request with an unregistered app-id and user id")
    public void user_sends_a_delete_request_with_an_unregistered_app_id_and_user_id() {
        response = given()
            .header("app-id", "662dd4bdfce0ef1111de25b") // Unregistered app-id
            .when()
            .delete("/user/" + userId);
        response.then().log().all(); // Log response for debugging
    }

    @When("user sends a DELETE request with a malformed app-id and user id")
    public void user_sends_a_delete_request_with_a_malformed_app_id_and_user_id() {
        response = given()
            .header("app-id", "afafyaf18r89ah10121") // Malformed app-id
            .when()
            .delete("/user/" + userId);
        response.then().log().all(); // Log response for debugging
    }

    @When("user sends a DELETE request with no app-id and a valid user id")
    public void user_sends_a_delete_request_with_no_app_id_and_a_valid_user_id() {
        response = given()
            .when()
            .delete("/user/" + userId);
        response.then().log().all(); // Log response for debugging
    }

    @When("user sends a DELETE request with a valid registered user id")
    public void user_sends_a_delete_request_with_a_valid_registered_user_id() {
        response = given()
            .header("app-id", appId)
            .when()
            .delete("/user/" + userId);
        response.then().log().all(); // Log response for debugging
    }

    @When("user sends a DELETE request with an unregistered user id")
    public void user_sends_a_delete_request_with_an_unregistered_user_id() {
        String unregisteredUserId = "662dd4bdfce0ef07531de25b"; // Unregistered user id
        response = given()
            .header("app-id", appId)
            .when()
            .delete("/user/" + unregisteredUserId);
        response.then().log().all(); // Log response for debugging
    }

    @When("user sends a DELETE request with an invalid formatted user id")
    public void user_sends_a_delete_request_with_an_invalid_formatted_user_id() {
        String invalidUserId = "adasdbuh22108313ras0"; // Invalid formatted user id
        response = given()
            .header("app-id", appId)
            .when()
            .delete("/user/" + invalidUserId);
        response.then().log().all(); // Log response for debugging
    }

    @Then("response indicates app-id does not exist with a 403 Forbidden status; database remains unchanged")
    public void response_indicates_app_id_does_not_exist_with_a_403_forbidden_status_database_remains_unchanged() {
        response.then().statusCode(403).body("error", equalTo("APP_ID_NOT_EXIST"));
    }

    @Then("response indicates missing app-id with a 403 Forbidden status; database remains unchanged")
    public void response_indicates_missing_app_id_with_a_403_forbidden_status_database_remains_unchanged() {
        response.then().statusCode(403).body("error", equalTo("APP_ID_MISSING"));
    }

    @Then("response body shows the user id was successfully deleted, 200 OK status; database reflects user deletion")
    public void response_body_shows_the_user_id_was_successfully_deleted_200_ok_status_database_reflects_user_deletion() {
        response.then().statusCode(200).contentType(ContentType.JSON);
    }

    @Then("response indicates resource not found with a 404 Not Found status; database remains unchanged")
    public void response_indicates_resource_not_found_with_a_404_not_found_status_database_remains_unchanged() {
        response.then().statusCode(404).body("error", equalTo("RESOURCE_NOT_FOUND"));
    }

    @Then("response indicates invalid parameters with a 400 Bad Request status; database remains unchanged")
    public void response_indicates_invalid_parameters_with_a_400_bad_request_status_database_remains_unchanged() {
        response.then().statusCode(400).body("error", equalTo("INVALID_PARAMETERS"));
    }
}
