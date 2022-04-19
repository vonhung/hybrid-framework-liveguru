package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.AccountInfoPageUI;

public class AccountInfoPageObject extends BasePage {
	WebDriver driver;

	public AccountInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getFirstName() {
		waitForElementVisible(driver, AccountInfoPageUI.FIRST_NAME_TEXTBOX);
		return getElementAttributeValue(driver, AccountInfoPageUI.FIRST_NAME_TEXTBOX, AccountInfoPageUI.TEXT_ATTRIBUTE_NAME);

		
	}

	public String getLastName() {
		waitForElementVisible(driver, AccountInfoPageUI.LAST_NAME_TEXTBOX);
		return getElementAttributeValue(driver, AccountInfoPageUI.LAST_NAME_TEXTBOX, AccountInfoPageUI.TEXT_ATTRIBUTE_NAME);
	}

	public String getEmailAddress() {
		waitForElementVisible(driver, AccountInfoPageUI.EMAIL_ADDRESS_TEXTBOX);
		return getElementAttributeValue(driver, AccountInfoPageUI.EMAIL_ADDRESS_TEXTBOX, AccountInfoPageUI.TEXT_ATTRIBUTE_NAME);
	}

	public void clickOnAccountMenuLink() {
		waitForElementVisible(driver, AccountInfoPageUI.ACCOUNT_MENU_LINK);
		clickToElement(driver, AccountInfoPageUI.ACCOUNT_MENU_LINK);		
	}

	public LogOutSuccessPageObject clickOnLogOut() {
		waitForElementVisible(driver,AccountInfoPageUI.LOG_OUT_MENU_LINK);
		clickToElement(driver, AccountInfoPageUI.LOG_OUT_MENU_LINK);
		return PageGeneratorManager.getLogOutSuccessPageObject(driver);
	}
	

}
