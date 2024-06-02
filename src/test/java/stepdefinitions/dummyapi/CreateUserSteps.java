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

public class CreateUserSteps {

    private static final Logger logger = LoggerFactory.getLogger(CreateUserSteps.class);

    private Response response;
    private String baseUrl = "https://dummyapi.io/data/v1/"; // Base URL for your API
    private String appId = "662dd4bdfce0ef07531de25b"; // Your personal app-id
    private String userPayload = "{"
            + "\"title\": \"mr\","
            + "\"firstName\": \"dafa\","
            + "\"lastName\": \"ahmad\","
            + "\"gender\": \"male\","
            + "\"email\": \"dafaahmad@gmail.com\","
            + "\"dateOfBirth\": \"1900-02-02\","
            + "\"phone\": \"0852145899\","
            + "\"picture\": \"https://example.com/dafaahmad.jpg\","
            + "\"location\": {"
            + "\"street\": \"892, Grande Rue\","
            + "\"city\": \"Besançon\","
            + "\"state\": \"Seine-et-Marne\","
            + "\"country\": \"France\","
            + "\"timezone\": \"+09:00\""
            + "}"
            + "}";

    @Given("API environment DUMMYAPI is set up for CreateUser and user is unauthenticated")
    public void api_environment_dummyapi_is_set_up_for_create_user_user_is_unauthenticated() {
        RestAssured.baseURI = baseUrl;
        RestAssured.useRelaxedHTTPSValidation(); // Tambahkan ini untuk melewati pengecekan SSL
        logger.info("Base URI set to: " + baseUrl);
    }

    @Given("API environment DUMMYAPI is set up for CreateUser and user is authenticated with permission to access API")
    public void api_environment_dummyapi_is_set_up_for_create_user_user_is_authenticated_with_permission_to_access_api() {
        RestAssured.baseURI = baseUrl;
        RestAssured.useRelaxedHTTPSValidation(); // Tambahkan ini untuk melewati pengecekan SSL
        logger.info("Base URI set to: " + baseUrl);
        logger.info("App ID set to: " + appId);
    }

    @When("user sends a POST request with an unregistered app-id")
    public void user_sends_a_post_request_with_an_unregistered_app_id() {
        response = given()
            .header("app-id", "662dd4bdfce0ef1111de25b") // Unregistered app-id
            .contentType(ContentType.JSON)
            .body(userPayload)
            .when()
            .post("/user/create");
        response.then().log().all(); // Log response for debugging
    }

    @When("user sends a POST request with a malformed app-id")
    public void user_sends_a_post_request_with_a_malformed_app_id() {
        response = given()
            .header("app-id", "afafyaf18r89ah10121") // Malformed app-id
            .contentType(ContentType.JSON)
            .body(userPayload)
            .when()
            .post("/user/create");
        response.then().log().all(); // Log response for debugging
    }

    @When("user sends a POST request with no app-id and a valid data user")
    public void user_sends_a_post_request_with_no_app_id_and_a_valid_data_user() {
        response = given()
            .contentType(ContentType.JSON)
            .body(userPayload)
            .when()
            .post("/user/create");
        response.then().log().all(); // Log response for debugging
    }

    @When("user sends a POST request with a valid data user")
    public void user_sends_a_post_request_with_a_valid_data_user() {
        response = given()
            .header("app-id", appId)
            .contentType(ContentType.JSON)
            .body(userPayload)
            .when()
            .post("/user/create");
        response.then().log().all(); // Log response for debugging
    }

    @When("user sends a POST request with a valid data user with firstName already registered")
    public void user_sends_a_post_request_with_a_valid_data_user_with_firstname_already_registered() {
        String userPayloadWithSameFirstName = "{"
                + "\"title\": \"mr\","
                + "\"firstName\": \"dafa\","
                + "\"lastName\": \"away\","
                + "\"gender\": \"male\","
                + "\"email\": \"dafaaway@gmail.com\","
                + "\"dateOfBirth\": \"1900-02-02\","
                + "\"phone\": \"0852145899\","
                + "\"picture\": \"https://example.com/dafaahmad.jpg\","
                + "\"location\": {"
                + "\"street\": \"892, Grande Rue\","
                + "\"city\": \"Besançon\","
                + "\"state\": \"Seine-et-Marne\","
                + "\"country\": \"France\","
                + "\"timezone\": \"+09:00\""
                + "}"
                + "}";

        response = given()
            .header("app-id", appId)
            .contentType(ContentType.JSON)
            .body(userPayloadWithSameFirstName)
            .when()
            .post("/user/create");
        response.then().log().all(); // Log response for debugging
    }

    @Then("response indicates app-id does not exist with a 403 Forbidden status; no database change")
    public void response_indicates_app_id_does_not_exist_with_a_403_forbidden_status_no_database_change() {
        response.then().statusCode(403).body("error", equalTo("APP_ID_NOT_EXIST"));
    }

    @Then("response indicates missing app-id with a 403 Forbidden status; no database change")
    public void response_indicates_missing_app_id_with_a_403_forbidden_status_no_database_change() {
        response.then().statusCode(403).body("error", equalTo("APP_ID_MISSING"));
    }

    @Then("response body shows JSON data of the user, 200 OK status; database change")
    public void response_body_shows_json_data_of_the_user_200_ok_status_database_change() {
        response.then().statusCode(200).contentType(ContentType.JSON);
    }
}
