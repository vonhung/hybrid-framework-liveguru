package com.liveguru.frontend;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageObjects.liveGuru.DashboardPageObject;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LogOutSuccessPageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.OrderPageObject;
import pageObjects.liveGuru.AccountInfoPageObject;
import pageObjects.liveGuru.CartPageObject;
import pageObjects.liveGuru.CheckoutPageObject;
import pageObjects.liveGuru.CompareProductPageObject;
import pageObjects.liveGuru.PageGeneratorManager;
import pageObjects.liveGuru.ProductListPageObject;
import pageObjects.liveGuru.ProductPageObject;
import pageObjects.liveGuru.ProductReviewPageObject;
import pageObjects.liveGuru.RegisterPageObject;
import pageObjects.liveGuru.WishlistPageObject;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Product_Events_And_Checkout_Flow extends BaseTest {

	WebDriver driver;
	String mobileProductName, productCostPLP, productCostPDP, discountCode, discountAmount, requestQty, maximumQty;
	String productName1, productName2, windowTitle, plpWindowId, tvProductName,tvProductName2, 
	shareReceiverEmail, shareMessage, emailAddress, password, orderNo;
	Integer discountPercentage;

	@Parameters({ "browser", "url" })
	@BeforeClass

	public void initBrowser(String browserName, String appURL) {
		log.info("Pre-Condition - Open browser '" + browserName + "' and navigate to '" + appURL + "'");
		driver = getBrowserDriver(browserName, appURL);
		driver.manage().window().maximize();
		homePage = PageGeneratorManager.getHomePage(driver);
		mobileProductName = "Sony Xperia";
		productName1 = "Samsung Galaxy";
		productName2 = "IPhone";
		discountCode = "GURU50";
		discountPercentage = 5;
		requestQty = "501";
		maximumQty = "500";
		windowTitle = "Compare Products";
		tvProductName  = "LG LCD";
		tvProductName2 = "Samsung LCD";
		shareReceiverEmail = randomEmailGenerator();
		shareMessage = "test only please ignore!";
	}

	@Test
	public void TC_04_Verify_Product_Cost_In_PLP_And_PDP() {
		log.info("TC_O4_Step 01: Click on Mobile");
		productListPage = homePage.clickOnMobile();
		log.info("TC_O4_Step 02: Get Cost of Soni Xperia mobile on product list page (PLP)");
		productCostPLP = productListPage.getCostOnPLP(mobileProductName);
		log.info("TC_O4_Step 03: Click on Soni Xperia slot");
		productPage = productListPage.clickOnProductImage(mobileProductName);
		log.info("TC_O4_Step 04: Get Cost of Soni Xperia on product details page (PDP)");
		productCostPDP = productPage.getCostOnPDP();
		log.info("TC_O4_Step 05: Compare cost in PLP and PDP");
		verifyEquals(productCostPLP, productCostPDP);
	
		

	}
	@Test
	public void TC_05_Verify_Discount_Coupon() {
		log.info("TC_O5_Step 01: Click on Add To Cart button");
		cartPage = productPage.clickAddToCartButton();
		log.info("TC_O5_Step 02: Verify product added to cart");
		verifyTrue(cartPage.isProductAddedToCart(mobileProductName));
		log.info("TC_O5_Step 03: Sendkey to Discount Codes textbox");
		cartPage.sendkeyToDiscountCodesField(discountCode);
		log.info("TC_O5_Step 04: Click Apply");
		cartPage.clickOnApplyLink();
		log.info("TC_O5_Step 05: Verify discount amount displayed ");
		discountAmount = cartPage.calculateDiscountAmount(productCostPDP,discountPercentage);
		verifyTrue(cartPage.isDiscountAmountDisplayed(discountCode, discountAmount));
		
	}
	
	@Test
	public void TC_06_Verify_Max_Qty_Available_To_Add() {
		log.info("TC_O6_Step 01: Sendkey to Qty field");
		cartPage.sendKeyToQty(requestQty);
		log.info("TC_O6_Step 02: Click Update button");
		cartPage.clickOnUpdateQtyButton();
		log.info("TC_O6_Step 03: Verify error message");
		verifyTrue(cartPage.isCartErrorMessageDisplayed());
		verifyTrue(cartPage.isItemErrorMessageDisplayed(maximumQty));
		log.info("TC_O6_Step 04: Click Empty Cart");
		cartPage.clickOnEmptyCartButton();
		log.info("TC_O6_Step 05: Verify Empty Cart");
		verifyTrue(cartPage.isEmptyCartMessageDisplayed());
		
	}
	@Test
	public void TC_07_Verify_Compare_Products() {
		log.info("TC_O7_Step 01: Click on Mobile");
		productListPage = cartPage.clickOnMobile();
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
	@Test (dataProviderClass = Register_And_Login.class, dataProvider = "registerAccountDataProvider")
	public void TC_08_Verify_Share_Wishlist(String emailAddress, String Password) {
		log.info("TC_O8_Step 01: Click on TV");
		productListPage.clickOnMenuTV();
		log.info("TC_O8_Step 02: Click on Add To Wishlist link");
		wishlistPage = productListPage.clickOnAddToWishlist(tvProductName);
//		log.info("TC_O8_Step 03: Enter Email Address");
//		logInPage.inputEmailAddress(emailAddress);
//		log.info("TC_O8_Step 04: Enter Password");
//		logInPage.inputPassword(password);
//		log.info("TC_O8_Step 05: Click Login button");
//		wishlistPage = logInPage.clickOnLogInButtonToWishlist();
//		log.info("TC_O8_Step 06: Click on TV");
//		productListPage = compareProductPage.clickOnMenuTV();
//		log.info("TC_O8_Step 07: Click on Add To Wishlist link");
//		logInPage = productListPage.clickOnAddToWishlist(tvProductName);
		log.info("TC_O8_Step 08: Verify message product added to wishlist");
		verifyTrue(wishlistPage.isAddedToWishlistMessageDisplayed(tvProductName));
		log.info("TC_O8_Step 10: Click Share wishlist button");
		wishlistPage.clickShareWishlishButton();
		log.info("TC_O8_Step 11: Enter receive email");
		wishlistPage.enterReceiveEmail(shareReceiverEmail);
		log.info("TC_O8_Step 12: Enter message");
		wishlistPage.enterShareMessage(shareMessage);
		log.info("TC_O8_Step 13: Click Share wishlist button");
		wishlistPage.clickShareWishlishButton();
		log.info("TC_O8_Step 14: Verify Share wishlist message");
		verifyTrue(wishlistPage.isSharedWishlistMessageDisplayed());
		log.info("TC_O8_Step 15: Click on My Wishlist menu link");
		wishlistPage.clickOnMyWishlistMenu();
		log.info("TC_O8_Step 16: Verify product name is displayed");
		verifyTrue(wishlistPage.isWishlistProductNameDisplayed(tvProductName));
	}
	@Test
	public void TC_09_Verify_Add_Your_Review() {
		log.info("TC_O9_Step 01: Click on TV");
		productListPage = wishlistPage.clickOnMenuTV();
		log.info("TC_O9_Step 02: Click on Product");
		productPage = productListPage.clickOnProductImage(tvProductName2);
		log.info("TC_O9_Step 03: Click on Add Your Review button");
		productReviewPage  = productPage.clickOnAddYourReviewButton();
		log.info("TC_O9_Step 04: Send empty value to the review fields: thought, summay, and nickname");
		productReviewPage.sendkeyToReviewDetailsField("");
		productReviewPage.sendkeyToSummayField("");
		productReviewPage.sendkeyToNickNameField("");
		log.info("TC_O9_Step 05: Click Submit Review button");
		productReviewPage.clickOnSubmitReviewButton();
		log.info("TC_O9_Step 06: Verify validatation messages shown");
		verifyTrue(productReviewPage.isValidationMessageShown("review_field"));
		verifyTrue(productReviewPage.isValidationMessageShown("summary_field"));
		verifyTrue(productReviewPage.isValidationMessageShown("nickname_field"));
		log.info("TC_O9_Step 07: Select the rating rate");
		productReviewPage.selectRatingRrate("4");
		log.info("TC_O9_Step 08: Send actual value to the review fields: thought, summay, and nickname");
		productReviewPage.sendkeyToReviewDetailsField("good product");
		productReviewPage.sendkeyToSummayField("good");
		productReviewPage.sendkeyToNickNameField("tester");
		log.info("TC_O9_Step 09: Click Submit Review button");
		productReviewPage.clickOnSubmitReviewButton();
		log.info("TC_O9_Step 10: Verify review accepted message shown");
		verifyTrue(productReviewPage.isReviewAcceptedMessageShown());

	}
	@Test
	public void TC_10_Verify_Purchase() {
		log.info("TC_10_Step 0: Click on Go to Wishlist link");
		wishlistPage = productReviewPage.clickOnGoToWishlistLink();
		log.info("TC_10_Step 0: Click Add To Cart");
		cartPage = wishlistPage.clickAddToCart();
		log.info("TC_10_Step 0: Verify Added message");
		verifyTrue(cartPage.isProductAddedToCart(tvProductName));
		log.info("TC_10_Step 0: Select dropdown State/Province New York");
		cartPage.selectDropdownState("New York");
		log.info("TC_10_Step 0: Enter Zipcode 543432");
		cartPage.enterZipcode("543432");
		log.info("TC_10_Step 0: Click Estimate");
		cartPage.clickEstimateButton();
		log.info("TC_10_Step 0: verify Flat Rate Shipping $5 is generated");
		verifyTrue(cartPage.isShippingPriceGenerated("$5.00"));
		log.info("TC_10_Step 0: Select Shipping Cost");
		cartPage.selectShippingCostRadioButton();
		log.info("TC_10_Step 0: Click Update Total");
		cartPage.clickUpdateTotalButton();
		log.info("TC_10_Step 0: Verify Total updated");
		verifyTrue(cartPage.isShippingIncludedInTotalPrice());
		log.info("TC_10_Step 0: Click Proceed to Checkout");
		checkoutPage = cartPage.clickProceedToCheckoutButton();
		log.info("TC_10_Step 0: Enter Billing Information");
		checkoutPage.enterAddressAtBilling("abc");
		checkoutPage.enterCityAtBilling("abc");
		checkoutPage.selectDropdownStateAtBilling("New York");
		checkoutPage.enterZipCode("543432");
		checkoutPage.enterMobileNumberAtBilling("abc");
		checkoutPage.selectOptionShipToThisAddress();
		log.info("TC_10_Step 0: Click Continue at billing");
		checkoutPage.clickContinueButton("billing");
		log.info("TC_10_Step 0: Click Continue at shippingMethod");
		checkoutPage.clickContinueButton("shippingMethod");
		log.info("TC_10_Step 0: In Payment Information, select Check/Money Order radio button");
		checkoutPage.selectCheckMoneyOrderRadioButton();
		log.info("TC_10_Step 0: Click Continue at payment");
		checkoutPage.clickContinueButton("payment");
		log.info("TC_10_Step 0: Click place order");
		orderPage = checkoutPage.clickToPlaceOrder();
		log.info("TC_10_Step 0: Verify if order is placed successfully");
		verifyTrue(orderPage.isOrderPlacedSuccessfully());
		log.info("TC_10_Step 0: Verify order number is generated - not null");
		verifyTrue(orderPage.isOrderNumberGenerated());
		
		
		
	}
	//@Test
	public void TC_11_Verify_Search_Functionality() {
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
	CartPageObject cartPage;
	CompareProductPageObject compareProductPage;
	WishlistPageObject wishlistPage;
	ProductReviewPageObject productReviewPage;
	CheckoutPageObject checkoutPage;
	OrderPageObject orderPage;

	@AfterClass
	public void cleanBrowser() {
	//	driver.quit();
	}

}
