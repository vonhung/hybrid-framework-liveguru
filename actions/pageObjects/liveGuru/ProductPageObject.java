package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.ProductPageUI;

public class ProductPageObject extends BasePage {
	WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getCostOnPDP() {
		waitForElementVisible(driver, ProductPageUI.PRODUCT_PRICE);
		return getElementText(driver,ProductPageUI.PRODUCT_PRICE);
	}

	public CheckoutCartPageObject clickAddToCartButton() {
		waitForElementVisible(driver, ProductPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, ProductPageUI.ADD_TO_CART_BUTTON);
		return PageGeneratorManager.getCheckoutCartPage(driver);
	}

}
