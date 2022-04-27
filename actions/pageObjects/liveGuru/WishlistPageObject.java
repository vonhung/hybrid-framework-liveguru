package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.WishlistPageUI;

public class WishlistPageObject extends BasePage {
	WebDriver driver;

	public WishlistPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isAddedToWishlistMessageDisplayed(String productName) {
		waitForElementVisible(driver, WishlistPageUI.ADDED_TO_WISHLIST_MESSAGE, productName);
		return isElementDisplayed(driver, WishlistPageUI.ADDED_TO_WISHLIST_MESSAGE, productName);
	}

	public void clickShareWishlishButton() {
		waitForElementVisible(driver,WishlistPageUI.SHARE_WISHLIST_BUTTON);
		clickToElement(driver, WishlistPageUI.SHARE_WISHLIST_BUTTON);		
	}

	public void enterReceiveEmail(String emailAddress) {
		waitForElementVisible(driver, WishlistPageUI.EMAIL_TEXT_BOX);
		sendkeyToElement(driver, WishlistPageUI.EMAIL_TEXT_BOX, emailAddress);			
	}

	public void enterShareMessage(String message) {
		waitForElementVisible(driver, WishlistPageUI.SHARE_WISHLIST_MESSAGE);
		sendkeyToElement(driver, WishlistPageUI.SHARE_WISHLIST_MESSAGE, message);					
	}

	public boolean isSharedWishlistMessageDisplayed() {
		waitForElementVisible(driver, WishlistPageUI.SHARED_WISHLIST_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, WishlistPageUI.SHARED_WISHLIST_SUCCESS_MESSAGE);
	}

	public void clickOnMyWishlistMenu() {
		waitForElementVisible(driver,WishlistPageUI.MY_WISHLIST_MENU_LINK);
		clickToElement(driver, WishlistPageUI.MY_WISHLIST_MENU_LINK);			
	}


	public boolean isWishlistProductNameDisplayed(String productName) {
		waitForElementVisible(driver, WishlistPageUI.ADDED_WISHLIST_PRODUCT_NAME,productName );
		return isElementDisplayed(driver, WishlistPageUI.ADDED_WISHLIST_PRODUCT_NAME,productName);
	}



}
