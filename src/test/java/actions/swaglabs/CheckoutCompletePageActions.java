package actions.swaglabs;

import locators.swaglabs.CheckoutCompletePageLocators;
import org.openqa.selenium.support.PageFactory;
import utils.HelperClass;

public class CheckoutCompletePageActions {
    CheckoutCompletePageLocators checkoutCompletePageLocators = null;

    public CheckoutCompletePageActions() {
        this.checkoutCompletePageLocators = new CheckoutCompletePageLocators();
        PageFactory.initElements(HelperClass.getDriver(), checkoutCompletePageLocators);
    }

    public boolean isCheckoutCompletePageDisplayed() {
        return checkoutCompletePageLocators.checkoutCompletePage.isDisplayed();
    }

    public void clickOnBackHomeButton() {
        checkoutCompletePageLocators.backHomeButton.click();
    }
}
