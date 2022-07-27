package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.HomePageUI;
import pageUIs.liveGuru.SearchPageUI;

public class SearchPageObject extends BasePage {
	WebDriver driver;

	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterSearchPriceRange(String priceFrom, String priceTo) {
		waitForElementVisible(driver, SearchPageUI.PRICE_FROM, SearchPageUI.PRICE_TO);
		sendkeyToElement(driver, SearchPageUI.PRICE_FROM, SearchPageUI.PRICE_TO, priceFrom, priceTo);
	}

	public void clickOnSearchButton() {
		waitForElementVisible(driver, SearchPageUI.SEARCH_BUTTON);		
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
	}

	public boolean isSearchResultReturned() {
		waitForElementVisible(driver, SearchPageUI.RESULT_MESSAGE);
		return isElementDisplayed(driver, SearchPageUI.RESULT_MESSAGE);
				
	}


	
}
