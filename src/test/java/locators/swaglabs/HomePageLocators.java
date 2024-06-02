package locators.swaglabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {
    @FindBy(xpath = "//*[@id=\"header_container\"]/div[1]/div[2]/div")
    public WebElement headerPageTitle;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    public WebElement homePageTitle;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[1]/div[2]/div")
    public WebElement Dashboard;

    @FindBy(xpath = "//*[@id=\"inventory_container\"]")
    public WebElement Catalog;

    @FindBy(className = "inventory_item_name")
    public WebElement itemName;

    @FindBy(xpath = "//*[@id=\"item_4_img_link\"]/img")
    public WebElement itemImage;

    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")
    public WebElement itemPrice;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    public WebElement addToCartButtonProduct;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    public WebElement CartIcon;

    @FindBy(xpath = "//*[@id=\"remove-sauce-labs-backpack\"]")
    public WebElement removeButton;
    @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    public WebElement hamburgerMenu;

    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
    public WebElement logoutMenu;
}
