package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.LogOutSuccessPageUI;

public class LogOutSuccessPageObject extends BasePage {
	WebDriver driver;

	public LogOutSuccessPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnAccountMenuLink() {
		waitForElementVisible(driver, LogOutSuccessPageUI.ACCOUNT_MENU_LINK);
		clickToElement(driver, LogOutSuccessPageUI.ACCOUNT_MENU_LINK);		
	}

	public LoginPageObject clickOnLogInMenuLink() {
		waitForElementVisible(driver, LogOutSuccessPageUI.LOG_IN_MENU_LINK);
		clickToElement(driver, LogOutSuccessPageUI.LOG_IN_MENU_LINK);	
		return PageGeneratorManager.getLoginPageObject(driver);
	}

	

}
