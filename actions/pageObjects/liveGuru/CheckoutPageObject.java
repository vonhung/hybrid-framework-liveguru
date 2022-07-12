package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.CheckoutPageUI;

public class CheckoutPageObject extends BasePage {
	WebDriver driver;

	public CheckoutPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterAddressAtBilling(String billingAddress) {
		waitForElementVisible(driver, CheckoutPageUI.BILLING_ADDRESS_INPUT);
		sendkeyToElement(driver, CheckoutPageUI.BILLING_ADDRESS_INPUT, billingAddress);	
		
	}

	public void enterCityAtBilling(String billingCity) {
		waitForElementVisible(driver, CheckoutPageUI.BILLING_CITY_INPUT);
		sendkeyToElement(driver, CheckoutPageUI.BILLING_CITY_INPUT, billingCity);			
	}

	public void selectDropdownStateAtBilling(String stateName) {
		waitForElementVisible(driver,CheckoutPageUI.STATE_DROPDOWN_SELECTION);
		selectDropdownByText(driver, CheckoutPageUI.STATE_DROPDOWN_SELECTION, stateName);
	}		
	
	public void enterZipCode(String zipCode) {
		waitForElementVisible(driver, CheckoutPageUI.ZIP_CODE_INPUT);
		sendkeyToElement(driver, CheckoutPageUI.ZIP_CODE_INPUT, zipCode);		
	}
	public void enterMobileNumberAtBilling(String mobileNo) {
		waitForElementVisible(driver, CheckoutPageUI.BILLING_MOBILE_INPUT);
		sendkeyToElement(driver, CheckoutPageUI.BILLING_MOBILE_INPUT, mobileNo);		
	}

	public void selectOptionShipToThisAddress() {
		waitForElementVisible(driver, CheckoutPageUI.SHIP_TO_THIS_ADDRESS_OPTION);
		checktoChecboxOrRadio(driver, CheckoutPageUI.SHIP_TO_THIS_ADDRESS_OPTION);			
	}

	public void clickContinueButton(String stepName) {
		waitForElementVisible(driver, CheckoutPageUI.CONTINUE_BUTTON, stepName);		
		clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON, stepName);
	}

	public void selectCheckMoneyOrderRadioButton() {
		waitForElementVisible(driver, CheckoutPageUI.CHECK_MONEY_ORDER_BUTTON);	
		checktoChecboxOrRadio(driver, CheckoutPageUI.CHECK_MONEY_ORDER_BUTTON);
	}

	public OrderPageObject clickToPlaceOrder() {
		waitForElementVisible(driver, CheckoutPageUI.PLACE_ORDER_BUTTON);		
		clickToElement(driver, CheckoutPageUI.PLACE_ORDER_BUTTON);
		return PageGeneratorManager.getOrderPageObject(driver);
	}




}
