package actions;


import locators.HomePageLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
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

    //Action get title header page ketika "successfully login"
    public String getTittlePage() {
        return(homePageLocators.homePageTitle.getText());
    }

    public void hamburgerClick() {
        homePageLocators.hamburgerMenu.click();
    }

    public void logoutClick(){
        homePageLocators.logoutMenu.click();
    }

}
