package actions.swaglabs;

import locators.swaglabs.CheckoutOverviewPageLocators;
import org.openqa.selenium.support.PageFactory;
import utils.HelperClass;

public class CheckoutOverviewPageActions {
    CheckoutOverviewPageLocators checkoutOverviewPageLocators = null;

    public CheckoutOverviewPageActions() {
        this.checkoutOverviewPageLocators = new CheckoutOverviewPageLocators();
        PageFactory.initElements(HelperClass.getDriver(), checkoutOverviewPageLocators);
    }

    public boolean isCheckoutOverviewPageDisplayed() {
        return checkoutOverviewPageLocators.checkoutOverviewPage.isDisplayed();
    }

    public void clickOnFinishButton() {
        checkoutOverviewPageLocators.finishButton.click();
    }

    public void clickOnCancelButton() {
        checkoutOverviewPageLocators.cancelButton.click();
    }
}
