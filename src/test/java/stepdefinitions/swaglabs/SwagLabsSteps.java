package stepdefinitions.swaglabs;

import java.util.List;

import org.junit.Assert;

import actions.swaglabs.CartPageActions;
import actions.swaglabs.HomePageActions;
import actions.swaglabs.LoginPageActions;
import actions.swaglabs.ProductDetailsPageActions;
import actions.swaglabs.MenuPageActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.HelperClass;

public class SwagLabsSteps {
	
	LoginPageActions objLogin = new LoginPageActions();
	HomePageActions objHomePage = new HomePageActions();
	CartPageActions objCartPage = new CartPageActions();
	ProductDetailsPageActions objProductDetailsPage = new ProductDetailsPageActions();
	MenuPageActions objMenuPageActions = new MenuPageActions();

	String url = "https://www.saucedemo.com/";
	String catalogDescription, detailsName, detailsDescription, detailsPrice;
	int previousItemCount = 0;

	@Given("User is on Swag Labs Login page")
	public void user_is_on_swag_lab_login_page() {
		//navigate to url website
		HelperClass.openPage(url);
	}

	@When("User has opened swag labs browser")
	public void user_has_opened_swag_labs_browser() throws InterruptedException {
		String currentUrl = HelperClass.getCurrentUrl();
		Assert.assertEquals(url, currentUrl);
		Thread.sleep(2000);
	}

	@Then("There are fields for inputting username and password")
	public void there_are_fields_for_inputting_username_and_password() {
		Assert.assertTrue(objLogin.isPasswordFieldDisplayed());
		Assert.assertTrue(objLogin.isUsernameFieldDisplayed());
	}

	@Then("There is a Login Button")
	public void there_is_a_login_button() {
		Assert.assertTrue(objLogin.isButtonEnable());
	}

	@Then("There is a Swag Labs logo name")
	public void there_is_a_swag_labs_logo_name() {
		Assert.assertTrue(objLogin.isLogoDisplayed());
	}

	@When("User enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) {
		// login to application
		objLogin.loginStep(username, password);
	}

	@Then("User should be logged in successfully")
	public void user_should_be_able_to_login_successfully_and_new_page_open() {
		Assert.assertTrue(objHomePage.getDashboard().isDisplayed());
	}

	@Then("User should see an error message {string}")
	public void user_should_be_able_to_see_a_error_message(String errorMessage) {
		System.out.println(objLogin.getErrorMessage());
		Assert.assertEquals(errorMessage, objLogin.getErrorMessage());
	}

	@Given("User was on dashboard page")
    public void user_was_on_dashboard_page() {
        user_is_on_swag_lab_login_page();
        user_enters_username_as_and_password_as("standard_user", "secret_sauce");
        user_should_be_able_to_login_successfully_and_new_page_open();
		catalogDescription = objProductDetailsPage.getProductDescriptionOnCatalog().getText();
		// previousItemCount = objProductDetailsPage.getItemCount();
    }


	@When("User click hamburger menu")
	public void user_click_hamburger_menu() {
		try {
			objHomePage.hamburgerClick();
			Thread.sleep(3000);  // Menambahkan waktu tunggu 3 detik
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User Click Logout")
	public void user_click_logout() {
		try {
			objHomePage.logoutClick();
			Thread.sleep(2000);  // Menambahkan waktu tunggu 2 detik
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("User navigate to login page")
	public void user_navigate_to_login_page() throws InterruptedException {
		String currentUrl = HelperClass.getCurrentUrl();
		Assert.assertEquals(url, currentUrl);
		Thread.sleep(2000);
	}

	// Fitur Cart
	@When("User clicks ADD cart button Sauce Labs Backpack")
	public void user_clicks_add_cart_button_sauce_labs_backpack()throws InterruptedException {
		objCartPage.addToCartButtonClickBackpack();
		Thread.sleep(2000);
	}

	@When("User clicks ADD cart button Sauce Labs Fleece Jacket")
	public void user_clicks_add_cart_button_sauce_labs_fleece_jacket() throws InterruptedException {
		objCartPage.addToCartButtonClickJacket();
		Thread.sleep(2000);
	}

	@When("User clicks the Cart button")
	public void user_clicks_the_cart_button() throws InterruptedException {
			Thread.sleep(2000);  // Menambahkan waktu tunggu 2 detik
	}

	@Then("User navigate to cart page")
	public void user_navigate_to_cart_page()throws InterruptedException {
		Assert.assertTrue(objCartPage.getCartPage().isDisplayed());
		Thread.sleep(2000);
	}

	@When("User clicks the Checkout Button")
	public void user_clicks_the_checkout_button() throws InterruptedException {
			objCartPage.checkoutButtonClick();
			Thread.sleep(2000);  // Menambahkan waktu tunggu 2 detik
	}

	@Then("User navigate to Checkout Information page")
	public void user_navigate_to_checkout_information_page() throws InterruptedException {
		Assert.assertTrue(objCartPage.getCheckoutPage().isDisplayed());
	}

	//Fitur Product Details

	@When("User clicks on a product image")
    public void user_clicks_on_a_product_image() {
        try {
            objProductDetailsPage.productDetailsButtonClick();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("User navigate to the product details page")
    public void user_navigate_to_the_product_details_page() throws InterruptedException {
        Assert.assertTrue(objProductDetailsPage.getProductDetailsPage().isDisplayed());
    }

	@When("User views the product description")
	public void user_views_the_product_description() {
		try {
			detailsName = objProductDetailsPage.getProductNameOnDetails().getText();
			detailsDescription = objProductDetailsPage.getProductDescriptionOnDetails().getText();
			detailsPrice = objProductDetailsPage.getProductPriceOnDetails().getText();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Then("The product description displayed should match the description in the catalog")
	public void the_product_description_displayed_should_match_the_description_in_the_catalog() {
		Assert.assertEquals(catalogDescription, detailsDescription);
	}

	@When("User clicks the Add to Cart button")
	public void user_clicks_the_add_to_cart_button() {
		try {
			user_views_the_product_description();
			objProductDetailsPage.addToCartButtonClick();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("The product should be added to the cart")
	public void the_product_should_be_added_to_the_cart() {
		user_clicks_the_cart_button();
        Assert.assertTrue(objProductDetailsPage.isProductInCart(detailsName, detailsDescription, detailsPrice));
    }
	
	@Then("A notification should indicate the item count in the cart has increased")
	public void a_notification_should_indicate_the_item_count_in_the_cart_has_increased() {
		Assert.assertTrue(objProductDetailsPage.getItemCount() > previousItemCount);
	}
	
	@When("User clicks the Back to Product button")
	public void user_click_the_back_to_product_button() {
		try {
			objProductDetailsPage.backButtonClick();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("User should be navigated back to the dashboard")
	public void user_should_be_navigated_back_to_the_dashboard() throws InterruptedException {
		Assert.assertTrue(objHomePage.getDashboard().isDisplayed());
	}
	
	//Fitur Menu

    @When("User clicks the hamburger icon for the Menu sidebar")
	public void user_clicks_the_hamburger_icon_for_the_menu_sidebar() {
		try {
			objMenuPageActions.clickHamburgerMenu();;
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Then("The system should display the Menu sidebar with four options: All Items, About, Logout, Reset App State and X button to close the sidebar")
	public void the_system_should_display_the_menu_sidebar_with_four_options_all_items_about_logout_reset_app_state_and_x_button_to_close_the_sidebar() {
		Assert.assertTrue(objMenuPageActions.isMenuSidebarDisplayed());
		Assert.assertTrue(objMenuPageActions.isAllItemsLinkDisplayed());
		Assert.assertTrue(objMenuPageActions.isAboutLinkDisplayed());
		Assert.assertTrue(objMenuPageActions.isLogoutLinkDisplayed());
		Assert.assertTrue(objMenuPageActions.isResetAppStateLinkDisplayed());
		Assert.assertTrue(objMenuPageActions.isCloseMenuButtonDisplayed());
	}

	@When("User clicks the About button")
    public void user_clicks_the_about_button() {
		try {
			objMenuPageActions.clickAbout();;
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

    @Then("User should be directed to the website information page at {string}")
	public void user_should_be_directed_to_the_website_information_page_at(String url) {
		String currentUrl = HelperClass.getCurrentUrl();
		Assert.assertEquals(url, currentUrl);
	}
	

    @Then("User clicks the X button to close the sidebar")
    public void user_clicks_the_x_button_to_close_the_sidebar() {
        objMenuPageActions.clickCloseMenu();
    }

    @Then("The Menu sidebar should close")
	public void the_menu_sidebar_should_close() {
		try {
			Thread.sleep(2000); // Add a short delay
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertFalse(objMenuPageActions.isMenuSidebarDisplayed());
	}



    @Then("The system should display the previous current page")
    public void the_system_should_display_the_previous_current_page() {
        Assert.assertTrue(objHomePage.getDashboard().isDisplayed());
    }


	// End to End Testing
	@Given("User Successfully Login")
	public void user__on_swag_lab_login_page() {
		user_is_on_swag_lab_login_page();
		user_enters_username_as_and_password_as("standard_user", "secret_sauce");
		user_should_be_able_to_login_successfully_and_new_page_open();
	}



}
