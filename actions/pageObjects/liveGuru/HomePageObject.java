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

	public ProductListPageObject clickOnMobile() {
		waitForElementVisible(driver,HomePageUI.MOBILE_MENU);
		clickToElement(driver, HomePageUI.MOBILE_MENU);
		return PageGeneratorManager.getProductListPageObject(driver);
	}

	public SearchPageObject clickOnAdvanceSearchLink() {
		waitForElementVisible(driver,HomePageUI.QUICK_SEARCH_LINK);
		clickToElement(driver, HomePageUI.QUICK_SEARCH_LINK);
		return PageGeneratorManager.getSearchPageObject(driver);
		
	}

}
