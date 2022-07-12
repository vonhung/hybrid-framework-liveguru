package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.ProductReviewPageUI;

public class ProductReviewPageObject extends BasePage {
	WebDriver driver;

	public ProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void sendkeyToReviewDetailsField(String inputValue) {
		waitForElementVisible(driver, ProductReviewPageUI.REVIEW_DETAILS_FIELD);
		sendkeyToElement(driver, ProductReviewPageUI.REVIEW_DETAILS_FIELD,inputValue );							
	}
	

	public void sendkeyToSummayField(String inputValue) {
		waitForElementVisible(driver, ProductReviewPageUI.REVIEW_SUMMARY);
		sendkeyToElement(driver, ProductReviewPageUI.REVIEW_SUMMARY,inputValue);					
	}

	public void sendkeyToNickNameField(String inputValue) {
		waitForElementVisible(driver, ProductReviewPageUI.NICK_NAME);
		sendkeyToElement(driver, ProductReviewPageUI.NICK_NAME,inputValue );					
	}


	public void clickOnSubmitReviewButton() {
		waitForElementVisible(driver,ProductReviewPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, ProductReviewPageUI.SUBMIT_REVIEW_BUTTON);			
	}

	public boolean isValidationMessageShown(String fieldName) {
		waitForElementVisible(driver, ProductReviewPageUI.REQUIRED_FIELD_VALIDATION_MESSAGE,fieldName );
		return isElementDisplayed(driver, ProductReviewPageUI.REQUIRED_FIELD_VALIDATION_MESSAGE,fieldName);
	}

	public void selectRatingRrate(String selectedrating) {
		waitForElementVisible(driver,ProductReviewPageUI.RATING_RADIO_BUTTON,selectedrating);
		checktoChecboxOrRadio(driver, ProductReviewPageUI.RATING_RADIO_BUTTON,selectedrating);	
	}

	public boolean isReviewAcceptedMessageShown() {
		waitForElementVisible(driver,ProductReviewPageUI.REVIEW_ACCEPTED_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, ProductReviewPageUI.REVIEW_ACCEPTED_SUCCESS_MESSAGE);
	}

	public WishlistPageObject clickOnGoToWishlistLink() {
		waitForElementVisible(driver,ProductReviewPageUI.GO_TO_WISHLIST_LINK);
		clickToElement(driver, ProductReviewPageUI.GO_TO_WISHLIST_LINK);		
		return PageGeneratorManager.getWishlistPage(driver);
	}


}
