package actions.swaglabs;

import org.openqa.selenium.support.PageFactory;

import locators.swaglabs.MenuPageLocators;
import utils.HelperClass;

public class MenuPageActions {
    MenuPageLocators menuPageLocators = null; 

    public MenuPageActions() {
        this.menuPageLocators = new MenuPageLocators();
        PageFactory.initElements(HelperClass.getDriver(), menuPageLocators);
    }

    public void clickHamburgerMenu() {
        menuPageLocators.hamburgerMenuButton.click();
    }

    public void clickCloseMenu() {
        menuPageLocators.closeMenuButton.click();
    }

    public void clickAllItems() {
        menuPageLocators.allItemsLink.click();
    }

    public void clickAbout() {
        menuPageLocators.aboutLink.click();
    }

    public void clickLogout() {
        menuPageLocators.logoutLink.click();
    }

    public void clickResetAppState() {
        menuPageLocators.resetAppStateLink.click();
    }

    public boolean isMenuDisplayed() {
        return menuPageLocators.hamburgerMenuButton.isDisplayed();
    }

    public boolean isMenuSidebarDisplayed() {
        return menuPageLocators.closeMenuButton.isDisplayed();
    }

    public boolean isAllItemsLinkDisplayed() {
        return menuPageLocators.allItemsLink.isDisplayed();
    }

    public boolean isAboutLinkDisplayed() {
        return menuPageLocators.aboutLink.isDisplayed();
    }

    public boolean isLogoutLinkDisplayed() {
        return menuPageLocators.logoutLink.isDisplayed();
    }

    public boolean isResetAppStateLinkDisplayed() {
        return menuPageLocators.resetAppStateLink.isDisplayed();
    }

    public boolean isCloseMenuButtonDisplayed() {
        return menuPageLocators.closeMenuButton.isDisplayed();
    }
}
