package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.DashboardPageUI;
import pageUIs.liveGuru.RegisterPageUI;

public class DashboardPageObject extends BasePage {
	WebDriver driver;

	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputFirstName(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.REGISTER_FIRST_NAME_TEXTBOX, firstName);
		
	}

	public void inputLastName(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.REGISTER_LAST_NAME_TEXTBOX, lastName);		
	}

	public void inputEmailAddress(String emailAddress) {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.REGISTER_EMAIL_TEXTBOX, emailAddress);		
	}

	public void inputPassword(String password) {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.REGISTER_PASSWORD_TEXTBOX, password);	
		
	}

	public void inputConfirmPassword(String password) {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.REGISTER_CONFIRM_PASSWORD_TEXTBOX, password);			
	}

	public HomePageObject clickOnRegisterButton() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);	
		return PageGeneratorManager.getHomePage(driver);
	}

	public AccountInfoPageObject clickOnAccountInformationLink() {
		waitForElementVisible(driver, DashboardPageUI.ACCOUNT_INFORMATION_MENU_LINK);
		clickToElement(driver, DashboardPageUI.ACCOUNT_INFORMATION_MENU_LINK);	
		return PageGeneratorManager.getAccountInfoPageObject(driver);
	}

	public boolean isDashboardHeaderTextDisplayed(String firstName, String lastName) {
		waitForElementVisible(driver,DashboardPageUI.DASHBOARD_PAGE_TITLE,firstName,lastName);
		return isElementDisplayed(driver, DashboardPageUI.DASHBOARD_PAGE_TITLE,firstName,lastName);
	}

	public HomePageObject clickToHomeLogo() {
		waitForElementVisible(driver, DashboardPageUI.HOME_LOGO);
		clickToElement(driver, DashboardPageUI.HOME_LOGO);	
		return PageGeneratorManager.getHomePage(driver);
	}

	

}
