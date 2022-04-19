package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputEmailAddress(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXT_BOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXT_BOX, emailAddress);		
	}

	public void inputPassword(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXT_BOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXT_BOX, password);		
	}		

	public DashboardPageObject clickOnLogInButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);	
		return PageGeneratorManager.getDashboardPageObject(driver)
;
	}

}
