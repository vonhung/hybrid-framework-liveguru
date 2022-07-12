package com.liveguru.frontend;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageObjects.liveGuru.DashboardPageObject;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LogOutSuccessPageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.AccountInfoPageObject;
import pageObjects.liveGuru.PageGeneratorManager;
import pageObjects.liveGuru.RegisterPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Register_And_Login extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	DashboardPageObject dashboardPage;
	AccountInfoPageObject accountInfoPage;
	LoginPageObject logInPage;
	LogOutSuccessPageObject logOutSucccessPage;
	String firstName, lastName;
	static String emailAddress;
	static String password;

	@Parameters({ "browser", "url" })

	@BeforeClass

	public void initBrowser(String browserName, String appURL) {
		log.info("Pre-Condition - Open browser '" + browserName + "' and navigate to '" + appURL + "'");
		driver = getBrowserDriver(browserName, appURL);
		driver.manage().window().maximize();
		homePage = PageGeneratorManager.getHomePage(driver);
		firstName = "Nhung";
		lastName = "Auto";
		emailAddress = randomEmailGenerator();
		password = "123456";
		

	}
	
	@Test
	public void TC_01_Register_Account() {
		log.info("TC_O1_Step 01: Click on Account");
		homePage.clickOnAccount();
		log.info("TC_O1_Step 02: Click on Register");
		registerPage = homePage.clickOnRegisterMenu();
		log.info("TC_O1_Step 03: Input valid data to form");
		registerPage.inputFirstName(firstName);
		registerPage.inputLastName(lastName);
		registerPage.inputEmailAddress(emailAddress);
		registerPage.inputPassword(password);
		registerPage.inputConfirmPassword(password);
		log.info("TC_O1_Step 04: Click Register");
		dashboardPage = registerPage.clickOnRegisterButton();
		log.info("TC_O1_Step 05: Verify text displayed after registered successfully");
		verifyTrue(homePage.isRegisteredSuccessfully());
		
	}
	@Test
	public void TC_02_Verify_Account() {
		log.info("TC_O2_Step 01: Open Account Information page");
		accountInfoPage =  dashboardPage.clickOnAccountInformationLink();
		log.info("TC_O2_Step 03: Verify first name, last name and email of account");
		verifyEquals(accountInfoPage.getFirstName(), firstName);
		verifyEquals(accountInfoPage.getLastName(), lastName);
		verifyEquals(accountInfoPage.getEmailAddress(), emailAddress);
		
	}
	@Test
	public void TC_03_Login_Success() {
		log.info("TC_O3_Step 01: Click on Account");
		accountInfoPage.clickOnAccountMenuLink();
		log.info("TC_O3_Step 02: Click on Logout");
		logOutSucccessPage = accountInfoPage.clickOnLogOut();
		log.info("TC_O3_Step 03: Click on Account");
		logOutSucccessPage.clickOnAccountMenuLink();
		log.info("TC_O3_Step 04: Click on Log In");
		logInPage = logOutSucccessPage.clickOnLogInMenuLink();
		log.info("TC_O3_Step 05: Input Email and Password");
		logInPage.inputEmailAddress(emailAddress);
		logInPage.inputPassword(password);
		log.info("TC_O3_Step 06: Click on Log In button");
		dashboardPage = logInPage.clickOnLogInButton();
		log.info("TC_O3_Step 07: Verify dashboard header text displayed");
		verifyTrue(dashboardPage.isDashboardHeaderTextDisplayed(firstName,lastName));
		
	}
	
	@DataProvider (name = "registerAccountDataProvider")
	public static Object[][] Account_Data_Provider(){
		Object[][] accountData = new Object[][] {{emailAddress,password}};
		System.out.println("Registered Account is: " + emailAddress + " and password is: " + password);
		return accountData;
	}

	@AfterClass
	public void cleanBrowser() {
	//	driver.quit();
	}

}
