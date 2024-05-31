package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPageLocators {
    @FindBy(xpath = "//*[@id=\"header_container\"]/div[1]/div[2]/div")
    public WebElement Dashboard;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    public WebElement cartButton;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]")
    public WebElement CartPage;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    public WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"checkout\"]")
    public WebElement checkoutButton;

    @FindBy(xpath = "//*[@id=\"checkout_info_container\"]")
    public WebElement CheckoutPage;
}
