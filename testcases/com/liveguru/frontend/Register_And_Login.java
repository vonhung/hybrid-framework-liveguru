package com.liveguru.frontend;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.PageGeneratorManager;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Register_And_Login extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;

	@Parameters({ "browser", "url" })

	@BeforeClass

	public void initBrowser(String browserName, String appURL) {
		log.info("Pre-Condition - Open browser '" + browserName + "' and navigate to '" + appURL + "'");
		driver = getBrowserDriver(browserName, appURL);
		driver.manage().window().maximize();
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void TC_01_Register_Account() {

	}
	@Test
	public void TC_02_Login_Account() {
		
	}

	@AfterClass
	public void afterClass() {
	}

}
