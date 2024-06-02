package actions.swaglabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import locators.swaglabs.HomePageLocators;
import utils.HelperClass;

public class HomePageActions {
    HomePageLocators homePageLocators = null;

    public HomePageActions() {
        this.homePageLocators = new HomePageLocators();
        PageFactory.initElements(HelperClass.getDriver(),homePageLocators);
    }

    public WebElement getDashboard() {
        return(homePageLocators.Dashboard);
    }

    public String getItemName() {
        return (homePageLocators.itemName.getText());
    }

    public String getItemImageUrl() {
        return homePageLocators.itemImage.getAttribute("src");
    }

    public String getItemPrice() {
        return (homePageLocators.itemPrice.getText());
    }

    public WebElement getCatalog() {
        return(homePageLocators.Catalog);
    }

    public void addToCartButtonProduct() {
        homePageLocators.addToCartButtonProduct.click();
    }

    public WebElement getCart() {
        return(homePageLocators.CartIcon);
    }

    public void removeButton() {
        homePageLocators.removeButton.click();
    }

    public void hamburgerClick() {
        homePageLocators.hamburgerMenu.click();
    }

    public void logoutClick(){
        homePageLocators.logoutMenu.click();
    }
}
