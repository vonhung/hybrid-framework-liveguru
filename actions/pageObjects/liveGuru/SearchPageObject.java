package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.SearchPageUI;

public class SearchPageObject extends BasePage {
	WebDriver driver;

	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterSearchPriceFrom(String priceFrom) {
		waitForElementVisible(driver, SearchPageUI.PRICE_FROM);
		sendkeyToElement(driver, SearchPageUI.PRICE_FROM, priceFrom);
	}
	
	public void enterSearchPriceTo(String priceTo) {
		waitForElementVisible(driver, SearchPageUI.PRICE_TO);
		sendkeyToElement(driver,SearchPageUI.PRICE_TO, priceTo);
	}

	public void clickOnSearchButton() {
		waitForElementVisible(driver, SearchPageUI.SEARCH_BUTTON);		
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
	}

	public boolean isSearchResultReturned() {
		waitForElementVisible(driver, SearchPageUI.RESULT_MESSAGE);
		return isElementDisplayed(driver, SearchPageUI.RESULT_MESSAGE);
				
	}
	
	public void clickOnModifySearchLink() {
		waitForElementVisible(driver, SearchPageUI.MODIFY_SEARCH);		
		clickToElement(driver, SearchPageUI.MODIFY_SEARCH);
	}

	
}
