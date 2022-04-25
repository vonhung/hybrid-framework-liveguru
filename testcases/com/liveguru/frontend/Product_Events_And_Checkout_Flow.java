package com.liveguru.frontend;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageObjects.liveGuru.DashboardPageObject;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LogOutSuccessPageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.AccountInfoPageObject;
import pageObjects.liveGuru.CheckoutCartPageObject;
import pageObjects.liveGuru.CompareProductPageObject;
import pageObjects.liveGuru.PageGeneratorManager;
import pageObjects.liveGuru.ProductListPageObject;
import pageObjects.liveGuru.ProductPageObject;
import pageObjects.liveGuru.RegisterPageObject;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Product_Events_And_Checkout_Flow extends BaseTest {

	WebDriver driver;
	String productName, productCostPLP, productCostPDP, discountCode, discountAmount, requestQty, maximumQty;
	String productName1, productName2, windowTitle, plpWindowId;
	Integer discountPercentage;

	@Parameters({ "browser", "url" })

	@BeforeClass

	public void initBrowser(String browserName, String appURL) {
		log.info("Pre-Condition - Open browser '" + browserName + "' and navigate to '" + appURL + "'");
		driver = getBrowserDriver(browserName, appURL);
		driver.manage().window().maximize();
		homePage = PageGeneratorManager.getHomePage(driver);
		productName = "Sony Xperia";
		productName1 = "Samsung Galaxy";
		productName2 = "IPhone";
		discountCode = "GURU50";
		discountPercentage = 5;
		requestQty = "501";
		maximumQty = "500";
		windowTitle = "Compare Products";
			
	}

	@Test
	public void TC_04_Verify_Product_Cost_In_PLP_And_PDP() {
		log.info("TC_O4_Step 01: Click on Mobile");
		productListPage = homePage.clickOnMobile();
		log.info("TC_O4_Step 02: Get Cost of Soni Xperia mobile on product list page (PLP)");
		productCostPLP = productListPage.getCostOnPLP(productName);
		log.info("TC_O4_Step 03: Click on Soni Xperia slot");
		productPage = productListPage.clickOnProductImage(productName);
		log.info("TC_O4_Step 04: Get Cost of Soni Xperia on product details page (PDP)");
		productCostPDP = productPage.getCostOnPDP();
		log.info("TC_O4_Step 05: Compare cost in PLP and PDP");
		verifyEquals(productCostPLP, productCostPDP);
	
		

	}
	@Test
	public void TC_05_Verify_Discount_Coupon() {
		log.info("TC_O5_Step 01: Click on Add To Cart button");
		checkoutCartPage = productPage.clickAddToCartButton();
		log.info("TC_O5_Step 02: Verify product added to cart");
		verifyTrue(checkoutCartPage.isProductAddedToCart(productName));
		log.info("TC_O5_Step 03: Sendkey to Discount Codes textbox");
		checkoutCartPage.sendkeyToDiscountCodesField(discountCode);
		log.info("TC_O5_Step 04: Click Apply");
		checkoutCartPage.clickOnApplyLink();
		log.info("TC_O5_Step 05: Verify discount amount displayed ");
		discountAmount = checkoutCartPage.calculateDiscountAmount(productCostPDP,discountPercentage);
		verifyTrue(checkoutCartPage.isDiscountAmountDisplayed(discountCode, discountAmount));
		
	}
	
	@Test
	public void TC_06_Verify_Max_Qty_Available_To_Add() {
		log.info("TC_O6_Step 01: Sendkey to Qty field");
		checkoutCartPage.sendKeyToQty(requestQty);
		log.info("TC_O6_Step 02: Click Update button");
		checkoutCartPage.clickOnUpdateQtyButton();
		log.info("TC_O6_Step 03: Verify error message");
		verifyTrue(checkoutCartPage.isCartErrorMessageDisplayed());
		verifyTrue(checkoutCartPage.isItemErrorMessageDisplayed(maximumQty));
		log.info("TC_O6_Step 04: Click Empty Cart");
		checkoutCartPage.clickOnEmptyCartButton();
		log.info("TC_O6_Step 05: Verify Empty Cart");
		verifyTrue(checkoutCartPage.isEmptyCartMessageDisplayed());
		
	}
	@Test
	public void TC_07_Verify_Compare_Products() {
		log.info("TC_O7_Step 01: Click on Mobile");
		productListPage = checkoutCartPage.clickOnMobile();
		plpWindowId  = productListPage.getWindowId();
		log.info("TC_O7_Step 02: Click on Add To Compare for Sony Xperia");
		productListPage.clickAddToCompare(productName1);
		log.info("TC_O7_Step 02: Verify Added To Compare for Sony Xperia");
		verifyTrue(productListPage.isAddedToCompareMessageDisplayed(productName1));
		log.info("TC_O7_Step 03: Click on Add To Compare for iPhone");
		productListPage.clickAddToCompare(productName2);
		log.info("TC_O7_Step 04: Verify Added To Compare for iPhone");
		verifyTrue(productListPage.isAddedToCompareMessageDisplayed(productName2));
		log.info("TC_O7_Step 05: Click on Compare button");
		compareProductPage = productListPage.clickOnCompareButton(windowTitle);
		log.info("TC_O7_Step 06: Verify Popup Window shown with heading Compare Product");
		verifyTrue(compareProductPage.isHeadingCompareProductDisplayed());
		log.info("TC_O7_Step 07: Verify selected products in popup");
		verifyTrue(compareProductPage.isSelectedProductsDisplayed(productName1,productName2));
		log.info("TC_O7_Step 08: Close compare popup window");
		compareProductPage.closeCompareWindonw(plpWindowId);
		
	}
	//@Test
	public void TC_08_Veirfy_Share_Wishlist() {
		log.info("TC_O3_Step 01: Click on Account");
		
		
	}
	//@Test
	public void TC_09_Veirfy_Share_Wishlist() {
		log.info("TC_O3_Step 01: Click on Account");
		
		
	}
	//@Test
	public void TC_10_Veirfy_Purchase() {
		log.info("TC_O3_Step 01: Click on Account");
		
		
	}
	//@Test
	public void TC_11_Veirfy_Add_Your_Review() {
		log.info("TC_O3_Step 01: Click on Account");
		
		
	}
	
	
	HomePageObject homePage;
	RegisterPageObject registerPage;
	DashboardPageObject dashboardPage;
	AccountInfoPageObject accountInfoPage;
	LoginPageObject logInPage;
	LogOutSuccessPageObject logOutSucccessPage;
	ProductListPageObject productListPage;
	ProductPageObject productPage;
	CheckoutCartPageObject checkoutCartPage;
	CompareProductPageObject compareProductPage;

	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

}
