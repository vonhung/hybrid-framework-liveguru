package commons;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	protected final Log log;
	
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	
	private enum BROWSER {
		CHROME, FIREFOX, IE, SAFARI, EDGE_LEGACY, EDGE_CHROMIUM, H_CHROME, H_FIREFOX;
	}
	
//	private enum OS {
//		WINDOWS, MAC_OSX, LINUX;
//	}
//	
//	private enum PLATFORM {
//		ANDROID, IOS, WINDOW_PHONE;
//	}
	
	protected WebDriver getBrowserDriver(String browserName) {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		switch (browser) {
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
			driver = new FirefoxDriver();
			break;
		case CHROME:
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
			driver = new ChromeDriver();
			break;
		case EDGE_CHROMIUM:
			System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
			driver = new EdgeDriver();
			break;
		default:
			break;
		}
		return driver;
	}
	protected WebDriver getBrowserDriver(String browserName, String appURL) {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		switch (browser) {
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", projectPath + getSlash("browserDrivers") + "geckodriver");
			driver = new FirefoxDriver();
			break;
		case CHROME:
			System.setProperty("webdriver.chrome.driver", projectPath + getSlash("browserDrivers") + "chromedriver");
			driver = new ChromeDriver();
			break;
		case EDGE_CHROMIUM:
			System.setProperty("webdriver.edge.driver", projectPath + getSlash("browserDrivers") + "msedgedriver");
			driver = new EdgeDriver();
			break;
		default:
			break;
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(appURL);
		return driver;
	}
	protected String randomEmailGenerator() {
		Random rand = new Random();
		return "nhung_auto" + rand.nextInt(9999) + "@mailinator.com";
	}
	private String getSlash (String folderName) {
		String separator = File.separator;
		return separator +folderName + separator;
	}
	
	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}
	public WebDriver getWebDriver () {
		return this.driver;
	}
	@BeforeTest
	public void deleteAllFilesInReportNGScreenshot() {
		log.info("------------- START delete file in foldder -------------");
		
		try {
			String workingDir = System.getProperty("user.dir");
			String pathFolderDownload = workingDir + "/reportNGScreenshot";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i< listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					new File(listOfFiles[i].toString()).delete();
				}
				
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		log.info("------------- END delete file in foldder -------------");
	}
	
	
	
}
