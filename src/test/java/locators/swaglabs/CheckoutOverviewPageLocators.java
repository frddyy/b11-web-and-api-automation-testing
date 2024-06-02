package locators.swaglabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPageLocators {
    @FindBy(id = "checkout_summary_container")
    public WebElement checkoutOverviewPage;

    @FindBy(id = "finish")
    public WebElement finishButton;

    @FindBy(id = "cancel")
    public WebElement cancelButton;
}
