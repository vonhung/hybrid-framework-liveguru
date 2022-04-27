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

	public void clickAddToCompare(String productName) {
		waitForElementVisible(driver, ProductListPageUI.ADD_TO_COMPARE_BUTTON,productName);
		clickToElement(driver, ProductListPageUI.ADD_TO_COMPARE_BUTTON,productName);		
	}

	public boolean isAddedToCompareMessageDisplayed(String productName) {
		waitForElementVisible(driver,ProductListPageUI.ADDED_TO_COMPARE_MESSAGE,productName);
		return isElementDisplayed(driver, ProductListPageUI.ADDED_TO_COMPARE_MESSAGE,productName);
	}

	public CompareProductPageObject clickOnCompareButton(String windowTitle) {
		waitForElementVisible(driver, ProductListPageUI.COMPARE_BUTTON);
		clickToElement(driver, ProductListPageUI.COMPARE_BUTTON);	
		switchToWindowByTitle(driver, windowTitle);
		return PageGeneratorManager.getCompareProductPage(driver);
	}

	public String getWindowId() {
		return driver.getWindowHandle();
	}

	public LoginPageObject clickOnAddToWishlist(String tvProductName) {
		waitForElementVisible(driver, ProductListPageUI.ADD_TO_WISHLIST_BUTTON,tvProductName);
		clickToElement(driver, ProductListPageUI.ADD_TO_WISHLIST_BUTTON,tvProductName);	
		return PageGeneratorManager.getLoginPageObject(driver);
	}
	

}
