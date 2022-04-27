package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;


public class PageGeneratorManager {
	
	private PageGeneratorManager() {
	}

	private static HomePageObject homePage;
	private static RegisterPageObject registerPage;
	private static LoginPageObject loginPage;
	private static DashboardPageObject dashboardPage;
	private static LogOutSuccessPageObject logOutSuccessPage;
//	private static SearchPageObject searchPage;	
	private static AccountInfoPageObject accountInfoPage;
	private static ProductPageObject productPage;
	private static ProductListPageObject productListPage;
	private static CheckoutCartPageObject checkoutCartPage;
	private static CompareProductPageObject compareProductPage;
	private static WishlistPageObject wishlistProductPage;
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
	public static DashboardPageObject getDashboardPageObject (WebDriver driver) {
		
		if (dashboardPage == null) {
			dashboardPage = new DashboardPageObject(driver);
		}
		return dashboardPage;
	}
	
	public static AccountInfoPageObject getAccountInfoPageObject(WebDriver driver) {

		if (accountInfoPage == null) {
			accountInfoPage = new AccountInfoPageObject(driver);
		}
		return accountInfoPage;
	}

	public static LogOutSuccessPageObject getLogOutSuccessPageObject(WebDriver driver) {

		if (logOutSuccessPage == null) {
			logOutSuccessPage = new LogOutSuccessPageObject(driver);
		}
		return logOutSuccessPage;
	}
	public static ProductPageObject getProductPageObject(WebDriver driver) {

		if (productPage == null) {
			productPage = new ProductPageObject(driver);
		}
		return productPage;
	}
	public static ProductListPageObject getProductListPageObject(WebDriver driver) {
		
		if (productListPage == null) {
			productListPage = new ProductListPageObject(driver);
		}
		return productListPage;
	}
	public static CheckoutCartPageObject getCheckoutCartPage(WebDriver driver) {
		
		if (checkoutCartPage == null) {
			checkoutCartPage = new CheckoutCartPageObject(driver);
		}
		return checkoutCartPage;
	}
	
	public static CompareProductPageObject getCompareProductPage(WebDriver driver) {
		
		if (compareProductPage == null) {
			compareProductPage = new CompareProductPageObject(driver);
		}
		return compareProductPage;
	}
	
	public static WishlistPageObject getWishlistPage(WebDriver driver) {
		
		if (wishlistProductPage == null) {
			wishlistProductPage = new WishlistPageObject(driver);
		}
		return wishlistProductPage;
	}

	
//	public static SearchPageObject getSearchPageObject (WebDriver driver) {
//		
//		if (searchPage == null) {
//			searchPage = new SearchPageObject(driver);
//		}
//		return searchPage;
//	}

//	public static OrderPageObject getOrderPageObject (WebDriver driver) {
//		
//		if (orderPage == null) {
//			orderPage = new OrderPageObject(driver);
//		}
//		return orderPage;
//	}
}
