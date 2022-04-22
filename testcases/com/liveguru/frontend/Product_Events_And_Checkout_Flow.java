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
import pageObjects.liveGuru.PageGeneratorManager;
import pageObjects.liveGuru.ProductListPageObject;
import pageObjects.liveGuru.ProductPageObject;
import pageObjects.liveGuru.RegisterPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Product_Events_And_Checkout_Flow extends BaseTest {

	WebDriver driver;
	String productName, productCostPLP, productCostPDP;

	@Parameters({ "browser", "url" })

	@BeforeClass

	public void initBrowser(String browserName, String appURL) {
		log.info("Pre-Condition - Open browser '" + browserName + "' and navigate to '" + appURL + "'");
		driver = getBrowserDriver(browserName, appURL);
		driver.manage().window().maximize();
		homePage = PageGeneratorManager.getHomePage(driver);
		productName = "Sony Xperia";

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
	//@Test
	public void TC_05_Verify_Discount_Coupon() {
		log.info("TC_O2_Step 01: Open Account Information page");
	
		
	}
	//@Test
	public void TC_06_Verify_Max_Qty_Available_To_Add() {
		log.info("TC_O3_Step 01: Click on Account");
	
		
	}
	//@Test
	public void TC_07_Verify_Compare_Products() {
		log.info("TC_O3_Step 01: Click on Account");
		
		
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

	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

}
