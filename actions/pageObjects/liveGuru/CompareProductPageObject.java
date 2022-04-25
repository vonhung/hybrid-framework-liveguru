package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.CompareProductPageUI;

public class CompareProductPageObject extends BasePage {
	WebDriver driver;

	public CompareProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isHeadingCompareProductDisplayed() {
		waitForElementVisible(driver,CompareProductPageUI.COMPARE_POPUP_HEADING_TEXT);
		return isElementDisplayed(driver, CompareProductPageUI.COMPARE_POPUP_HEADING_TEXT);
	}

	public boolean isSelectedProductsDisplayed(String productName1, String productName2) {
		waitForElementVisible(driver,CompareProductPageUI.SELECTED_PRODUCT_NAME_IN_COMPARE,productName1,productName2);
		return isElementDisplayed(driver, CompareProductPageUI.SELECTED_PRODUCT_NAME_IN_COMPARE,productName1,productName2);
	}

	public void closeCompareWindonw(String parentId) {
		closeAllWindowExceptParent(driver,parentId);
	}

	public boolean isCompareWindowClosed() {
		// TODO Auto-generated method stub
		return false;
	}

}
