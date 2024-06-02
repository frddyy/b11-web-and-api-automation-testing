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

    public void hamburgerClick() {
        homePageLocators.hamburgerMenu.click();
    }

    public void logoutClick(){
        homePageLocators.logoutMenu.click();
    }
}
