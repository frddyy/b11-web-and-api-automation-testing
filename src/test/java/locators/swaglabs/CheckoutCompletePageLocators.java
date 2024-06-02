package locators.swaglabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePageLocators {
    @FindBy(id = "checkout_complete_container")
    public WebElement checkoutCompletePage;

    @FindBy(id = "back-to-products")
    public WebElement backHomeButton;
}
