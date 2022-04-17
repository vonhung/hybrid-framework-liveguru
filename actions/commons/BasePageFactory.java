package commons;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	/* Browser */
	public void openPageUrl (WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	public String getPageTitle (WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageSource (WebDriver driver) {
		return driver.getPageSource();
	}
	
	public String getPageUrl (WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public Alert waitForAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, timeout); 
		return explicitWait.until(ExpectedConditions.alertIsPresent());
		
	}
	
	public void acceptAlert(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		alert.accept();
		
	}
	
	public void cancelAlert(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		alert.dismiss();
	}
	
	public void sendketAlert(WebDriver driver, String value) {
		alert = waitForAlertPresence(driver);
		alert.sendKeys(value);
	}
	
	public String getAlertText(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		return alert.getText();
	}
	
	public void switchToWindowByID (WebDriver driver, String parentID) {
		Set<String> allWindowsID = driver.getWindowHandles();
		for (String id : allWindowsID) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				break;
			}
			
		}
	}
	
	public void switchToWindowByTitle (WebDriver driver, String title) {
		Set<String> allWindowsID = driver.getWindowHandles();
		
		for (String id : allWindowsID) {
				driver.switchTo().window(id);
				String CurrentTitle = driver.getTitle();
				if (CurrentTitle.equals(title)) {
				break;
				}
		}
	}
	
	public void closeAllWindowExceptParent (WebDriver driver, String parentID) {
		Set<String> allWindowsID = driver.getWindowHandles();
		for (String id : allWindowsID) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		} 
		driver.switchTo().window(parentID);
	}
	
	public void sleepInSecond(long timeoutInSecond) {
		try {
			Thread.sleep(timeoutInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}}
	
	public void backToPage (WebDriver driver) {
		driver.navigate().back();
	}
	
	public void refreshCurrentPage (WebDriver driver) {
		driver.navigate().refresh();
	}
	
	
	public void forwardToPage (WebDriver driver) {
		driver.navigate().forward();
	}
	
	public By getByXpath(String locator) {
		return By.xpath(locator);	
	}
	/* Element */
	
	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}
	
	public void sendkeyToElement(WebDriver driver,WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	
	public String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}
	
	public boolean isElementDisplayed (WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}
	
	public void waitForElementVisible (WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public boolean isElementSelected (WebDriver driver, WebElement element) {
		return element.isSelected();
	}
	
	public void checktoChecboxOrRadio(WebDriver driver, WebElement element) {
		if(!isElementSelected(driver, element)) {
			element.click();
		}
	}
	
	private Alert alert;
	private long timeout = 10;
	private WebDriverWait explicitWait;
}
