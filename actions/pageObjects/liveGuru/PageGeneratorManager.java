package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;


public class PageGeneratorManager {
	
	private PageGeneratorManager() {
	}
	private static HomePageObject homePage;	
	private static RegisterPageObject registerPage;	
	private static LoginPageObject loginPage;	
//	private static SearchPageObject searchPage;	
//	private static MyAccountPageObject myAccountPage;	
//	private static OrderPageObject orderPage;	
	
	public static HomePageObject getHomePage (WebDriver driver) {
		if (homePage == null) {
			homePage = new HomePageObject(driver);
		}
			return homePage;
	}
	public static RegisterPageObject getRegisterPageObject (WebDriver driver) {
		if (registerPage == null) {
			registerPage = new RegisterPageObject(driver);
		}
			return registerPage;
	}
	public static LoginPageObject getLoginPageObject (WebDriver driver) {
		
		if (loginPage == null) {
			loginPage = new LoginPageObject(driver);
		}
			return loginPage;
	}
//	public static SearchPageObject getSearchPageObject (WebDriver driver) {
//		
//		if (searchPage == null) {
//			searchPage = new SearchPageObject(driver);
//		}
//		return searchPage;
//	}
//	public static MyAccountPageObject getMyAccountPageObject (WebDriver driver) {
//		
//		if (myAccountPage == null) {
//			myAccountPage = new MyAccountPageObject(driver);
//		}
//		return myAccountPage;
//	}
//	public static OrderPageObject getOrderPageObject (WebDriver driver) {
//		
//		if (orderPage == null) {
//			orderPage = new OrderPageObject(driver);
//		}
//		return orderPage;
//	}
}
