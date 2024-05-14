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

    //Action get title header page ketika "successfully login"
    public String getTitleHeaderPage() {
        return(homePageLocators.headerPageTitle.getText());
    }

    public WebElement getDashboard() {
        return(homePageLocators.Dashboard);
    }

    public WebElement getProfileButton() {
        return(homePageLocators.profileButton);
    }

    public WebElement getLogoutButton() {
        return(homePageLocators.logoutButton);
    }


    //Action get title header page ketika "successfully login"
    public String getTittlePage() {
        return(homePageLocators.homePageTitle.getText());
    }


}
