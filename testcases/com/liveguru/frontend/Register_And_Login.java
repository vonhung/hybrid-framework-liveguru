package com.liveguru.frontend;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.PageGeneratorManager;
import pageObjects.liveGuru.RegisterPageObject;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Register_And_Login extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	String emailAddress, password;

	@Parameters({ "browser", "url" })

	@BeforeClass

	public void initBrowser(String browserName, String appURL) {
		log.info("Pre-Condition - Open browser '" + browserName + "' and navigate to '" + appURL + "'");
		driver = getBrowserDriver(browserName, appURL);
		driver.manage().window().maximize();
		homePage = PageGeneratorManager.getHomePage(driver);
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
		registerPage.inputFirstName("Nhung");
		registerPage.inputLastName("Auto");
		registerPage.inputEmailAddress(emailAddress);
		registerPage.inputPassword(password);
		registerPage.inputConfirmPassword(password);
		log.info("TC_O1_Step 04: Click Register");
		registerPage.clickOnRegisterButton();
		log.info("TC_O1_Step 05: Verify text displayed after registered successfully");
		verifyTrue(homePage.isRegisteredSuccessfully());
		
		

	}
	@Test
	public void TC_02_Verify_Account() {
		log.info("TC_O2_Step 01: Open My Account page");
		log.info("TC_O2_Step 02: Open Account Information page");
		log.info("TC_O2_Step 03: Verify first name, last name and email of account");
		
	}
	@Test
	public void TC_03_Login_Success() {
		log.info("TC_O3_Step 02: Click on Account");
		log.info("TC_O3_Step 02: Click on Logout");
		log.info("TC_O3_Step 03: Click on Account");
		log.info("TC_O3_Step 04: Click on Log In");
		log.info("TC_O3_Step 05: Verify dashboard header text displayed");
	}

	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

}
