# Web Automation and API Testing with Selenium, Cucumber, and Rest-Assured

## Description

This project performs functional testing of various features on the SauceDemo Swag Labs website and also tests the user controller API program on the DummyAPI website. The project uses Selenium to automate interactions with the browser and Cucumber to write test scenarios in Gherkin syntax. For API testing, it utilizes Rest-Assured.

## Technologies & Tools

- **Repository Management**: Git
- **IDE**: Visual Studio Code
- **CLI**: Command Prompt (CMD) / PowerShell (Windows)
- **Build Tools**: [![Maven](https://img.shields.io/badge/Maven-3.8.3-blue)](https://maven.apache.org/)
- **Programming Language**: [![Java](https://img.shields.io/badge/Java-17.0.10%202024--01--16%20LTS-red)](https://www.java.com/)
- **Unit Testing**: JUnit 4
- **Automation Testing Tools**: Cucumber Java & JUnit (Version 7.17.0)
- **WebDriverManager**: Version 5.4.0
- **GlueGen**: Version 2.3.2
- **Selenium**: Version 4.20.0
- **SLF4J (Simple Logging Facade for Java)**: Version 2.0.7
- **Rest-Assured for API Testing**: Version 4.5.1

## Installation

### Prerequisites

1. **Java Development Kit (JDK)**
   - Ensure you have JDK installed. You can download it from the [Oracle official site](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

2. **Maven**
   - Ensure you have Apache Maven installed. You can download it from the [Maven official site](https://maven.apache.org/download.cgi).

3. **Cucumber**
   - If you are using Eclipse, you need to install the Cucumber plugin.

### Step-by-Step Installation Guide

1. **Clone Repository**
   - Open Command Prompt and navigate to the directory where you want to clone the repository.
   - Run the following command:
     ```sh
     git clone https://github.com/frddyy/b11-web-and-api-automation-testing.git
     ```

2. **Install Cucumber Plugin in Eclipse**
   - Open Eclipse.
   - Go to `Help` > `Eclipse Marketplace`.
   - In the `Find` field, type `Cucumber`.
   - Click `Go`, and from the search results, click `Install` next to `Cucumber Eclipse Plugin`.
   - Follow the instructions to complete the installation and restart Eclipse if necessary.

3. **Navigate to Project Directory**
   - In Command Prompt, navigate to the cloned repository directory:
     ```sh
     cd b11-web-and-api-automation-testing
     ```

4. **Run Project**
   - Run the following command to execute tests using Maven:
     ```sh
     mvn test
     ```

## Project Structure

```
├── src/
│   ├── driver/
│   ├── test/
│   │   └── java/
│   │       └── actions/
│   │           └── swaglabs/
│   │               ├── CartPageActions.java
│   │               ├── CheckoutCompletePageActions.java
│   │               ├── CheckoutInfoPageActions.java
│   │               ├── CheckoutOverviewPageActions.java
│   │               ├── HomePageActions.java
│   │               ├── LoginPageActions.java
│   │               ├── MenuPageActions.java
│   │               ├── ProductDetailsPageActions.java
│   │       └── locators/
│   │           └── swaglabs/
│   │               ├── CartPageLocators.java
│   │               ├── CheckoutCompletePageLocators.java
│   │               ├── CheckoutInfoPageLocators.java
│   │               ├── CheckoutOverviewPageLocators.java
│   │               ├── HomePageLocators.java
│   │               ├── LoginPageLocators.java
│   │               ├── MenuPageLocators.java
│   │               ├── ProductDetailsPageLocators.java
│   │       └── runner/
│   │           ├── CucumberRunnerTest.java
│   │       └── stepdefinitions/
│   │           └── dummyapi/
│   │               ├── CreateUserSteps.java
│   │               ├── DeleteUserSteps.java
│   │               ├── GetUserByIdSteps.java
│   │               ├── UpdateUserSteps.java
│   │           └── swaglabs/
│   │               ├── Hooks.java
│   │       └── utils/
│   │           ├── HelperClass.java
│   └── resources/
│       └── dummyapi/
│           ├── CreateUser.feature
│           ├── DeleteUser.feature
│           ├── GetUserById.feature
│           ├── UpdateUser.feature
│       └── swaglabs/
│           ├── CartPage.feature
│           ├── CheckoutPage.feature
│           ├── DashboardPage.feature
│           ├── EndToEnd.feature
│           ├── LoginPage.feature
│           ├── MenuPage.feature
│           ├── ProductDetailsPage.feature
├── target/
├── .gitignore
├── pom.xml
└── README.md
```

### Adding Test Script

1. **Create Cucumber Feature File**
   - Create a feature file in the directory `src/test/resources`.
   - Example: `LoginPage.feature`.

2. **Create Locator Class**
   - Create a locator class for the elements on the page to be tested and save it in the directory `src/test/java/locators`.
   - Example:
     ```java
     package locators;

     import org.openqa.selenium.WebElement;
     import org.openqa.selenium.support.FindBy;
     import org.openqa.selenium.support.PageFactory;

     public class LoginPageLocators {
         @FindBy(id = "user-name")
         public WebElement usernameField;

         public LoginPageLocators() {
             PageFactory.initElements(HelperClass.getDriver(), this);
         }
     }
     ```

3. **Create Actions Class**
   - Create an actions class that uses the locator class created earlier and save it in the directory `src/test/java/actions`.
   - In this file, don't forget to initialize the driver by adding the following code:
     ```java
     public class LoginPageActions {
         LoginPageLocators loginPageLocators = null;

         public LoginPageActions() {
             this.loginPageLocators = new LoginPageLocators();
             PageFactory.initElements(HelperClass.getDriver(), loginPageLocators);
         }

         public void enterUsername(String username) {
             loginPageLocators.usernameField.sendKeys(username);
         }
     }
     ```

4. **Create Step Definitions**
   - Create step definitions based on the Gherkin file created and save it in the directory `src/test/java/stepdefinitions`.
   - Example:
     ```java
     package stepdefinitions;

     import actions.LoginPageActions;
     import io.cucumber.java.en.When;

     public class LoginSteps {
         LoginPageActions loginPageActions = new LoginPageActions();

         @When("^user enters username \"([^\"]*)\"$")
         public void user_enters_username(String username) {
             loginPageActions.enterUsername(username);
         }
     }
     ```

By following the above steps, test scripts can be added to the project.

## How to Run / Test Runner

1. Open terminal or command prompt and navigate to the project directory.

```
cd b11-web-and-api-automation-testing
```

2. To install the project, run the command `mvn install`.
3. Run the command `mvn test` to execute the tests.
4. After the tests are completed, the test reports will be generated. To access the test reports in HTML format, open the following file using a web browser (If using VSCode, you can use the "Open with Live Server" feature): `target/HtmlReports/report.html`

## Authors

- Aini Diah Rahmawati - [211524033]
- Ghessa Theniana - [211524042]
- Mochamad Ferdy Fauzan - [211524049]