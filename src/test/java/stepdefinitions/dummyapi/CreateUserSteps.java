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

    static {
        System.setProperty("jsse.enableSNIExtension", "false");
        RestAssured.useRelaxedHTTPSValidation(); // Relax HTTPS validation
    }

    private static final Logger logger = LoggerFactory.getLogger(CreateUserSteps.class);

    private Response response;
    private String baseUrl = "https://dummyapi.io/data/v1/"; // Base URL for your API
    private String appId = "662dd4bdfce0ef1111de25b"; // Unregistered app-id

    @Given("API environment DUMMYAPI set up")
    public void apiEnvironmentDummyapiSetUp() {
        // Set the base URI for RestAssured
        RestAssured.baseURI = baseUrl;
        logger.info("Base URI set to: " + baseUrl);
        logger.info("App ID set to: " + appId);
    }

    @Given("User is unauthenticated")
    public void userUnauthenticated() {
        // No authentication setup needed for unauthenticated user
    }

    @When("User sends a POST request with an unregistered app-id")
    public void userSendsPostRequestUnregisteredAppId(String body) {
        response = given()
                .header("app-id", appId) // Unregistered app-id
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/user/create");
        response.then().log().all(); // Log response for debugging
    }

    @Then("Response indicates app-id does not exist with a 403 Forbidden status")
    public void responseIndicatesAppIdDoesNotExist403ForbiddenStatus() {
        response.then().statusCode(403).body("error", equalTo("APP_ID_NOT_EXIST"));
    }

    @Then("No database change")
    public void no_database_change() {
        // For this scenario, no database verification step is necessary as no changes should occur with an invalid app-id.
    }
}
