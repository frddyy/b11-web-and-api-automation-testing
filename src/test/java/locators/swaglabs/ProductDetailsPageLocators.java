package locators.swaglabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
  
public class ProductDetailsPageLocators {
    @FindBy(xpath = "//*[@id=\"header_container\"]/div[1]/div[2]/div")
    public WebElement Dashboard;

    @FindBy(xpath = "//*[@id=\"item_0_img_link\"]")
    public WebElement productDetailsImageBtn;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]")
    public WebElement productDetailsPage;

    @FindBy(xpath = "//*[@id=\"add-to-cart\"]" )
    public WebElement addToCartBtn;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
    public WebElement cartItemCount;

    @FindBy(xpath = "//*[@id=\"back-to-products\"]")
    public WebElement backButton;

    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[2]/div[2]/div[1]/div")
    public WebElement productDescriptionOnCatalog;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]")
    public WebElement productNameOnDetails;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]")
    public WebElement productDescriptionOnDetails;

    @FindBy(xpath = "//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]")
    public WebElement productPriceOnDetails;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]")
    public WebElement addedProductOnCart;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[1]")
    public WebElement addedProductQuantityOnCart;

    @FindBy(xpath = "//*[@id=\"item_0_title_link\"]/div")
    public WebElement addedProductNameOnCart;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[1]")
    public WebElement addedProductDescriptionOnCart;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")
    public WebElement addedProductPriceOnCart;
    
}
