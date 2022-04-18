package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
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

	public void clickOnRegisterButton() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);	
	}

	

}
