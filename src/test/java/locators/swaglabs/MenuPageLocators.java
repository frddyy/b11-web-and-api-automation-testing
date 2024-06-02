package locators.swaglabs;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPageLocators {
    @FindBy(id = "react-burger-menu-btn")
    public WebElement hamburgerMenuButton;

    @FindBy(id = "react-burger-cross-btn")
    public WebElement closeMenuButton;

    @FindBy(id = "inventory_sidebar_link")
    public WebElement allItemsLink;

    @FindBy(id = "about_sidebar_link")
    public WebElement aboutLink;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutLink;

    @FindBy(id = "reset_sidebar_link")
    public WebElement resetAppStateLink;
}
