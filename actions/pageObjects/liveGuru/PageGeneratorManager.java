package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	private PageGeneratorManager() {
	}
	private static HomePageObject homePage;	

	private static ProductPageObject productPage;	
	
	public static HomePageObject getHomePage (WebDriver driver) {
		if (homePage == null) {
			homePage = new HomePageObject(driver);
		}
			return homePage;
	}
	public static ProductPageObject getProductPage (WebDriver driver) {
		if (productPage == null) {
			productPage = new ProductPageObject(driver);
		}
		return productPage;
	}
}
