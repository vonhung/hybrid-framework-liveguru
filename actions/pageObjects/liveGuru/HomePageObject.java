package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnAccount() {
		waitForElementVisible(driver, HomePageUI.ACCOUNT_MENU_LINK);
		clickToElement(driver, HomePageUI.ACCOUNT_MENU_LINK);
		
	}

	public RegisterPageObject clickOnRegisterMenu() {
		waitForElementVisible(driver, HomePageUI.REGISTER_MEMU_LINK);
		clickToElement(driver, HomePageUI.REGISTER_MEMU_LINK);
		return PageGeneratorManager.getRegisterPageObject(driver);
	}
	
	public boolean isRegisteredSuccessfully() {
		waitForElementVisible(driver,HomePageUI.REGISTER_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, HomePageUI.REGISTER_SUCCESS_MESSAGE);
	}

}
