package actions;

import locators.CartPageLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.HelperClass;

public class CartPageActions {
    CartPageLocators cartPageLocators = null;

    public CartPageActions() {
        this.cartPageLocators = new CartPageLocators();
        PageFactory.initElements(HelperClass.getDriver(),cartPageLocators);
    }

    public void cartButtonClick() {
        cartPageLocators.cartButton.click();
    }

    public WebElement getCartPage(){
        return(cartPageLocators.CartPage);
    }

    public void addToCartButtonClick() {
        cartPageLocators.addToCartButton.click();
    }

    public void checkoutButtonClick() {
        cartPageLocators.checkoutButton.click();
    }

    public WebElement getCheckoutPage(){
        return(cartPageLocators.CheckoutPage);
    }

}
