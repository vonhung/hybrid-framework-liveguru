package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.OrderPageUI;

public class OrderPageObject extends BasePage {
	WebDriver driver;

	public OrderPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isOrderPlacedSuccessfully() {
		waitForElementVisible(driver, OrderPageUI.ORDER_PLACED_SUCCESSFUL_MESSAGE);
		return isElementDisplayed(driver, OrderPageUI.ORDER_PLACED_SUCCESSFUL_MESSAGE);
	}

	public boolean isOrderNumberGenerated() {
		waitForElementVisible(driver, OrderPageUI.ORDER_NUMBER_TEXT);
		String orderNumber = getElementText(driver, OrderPageUI.ORDER_NUMBER_TEXT);
		System.out.println("Order Number is: " + orderNumber);
		return isTextNotEmptyOrNull(orderNumber);
	}

	public HomePageObject clickOnHomepageIcon() {
		waitForElementVisible(driver, OrderPageUI.HOME_ICON);
		clickToElement(driver, OrderPageUI.HOME_ICON);
		return PageGeneratorManager.getHomePage(driver);
	}

}
