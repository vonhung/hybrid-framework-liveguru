package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.ProductListPageUI;

public class ProductListPageObject extends BasePage {
	WebDriver driver;

	public ProductListPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getCostOnPLP(String productName) {
		waitForElementVisible(driver, ProductListPageUI.PRODUCT_PRICE,productName);
		return getElementText(driver,ProductListPageUI.PRODUCT_PRICE, productName);
	}

	public ProductPageObject clickOnProductImage(String productName) {
		waitForElementVisible(driver,ProductListPageUI.PRODUCT_IMAGE_SELECTOR,productName);
		clickToElement(driver, ProductListPageUI.PRODUCT_IMAGE_SELECTOR,productName);
		return PageGeneratorManager.getProductPageObject(driver);
	}

}
