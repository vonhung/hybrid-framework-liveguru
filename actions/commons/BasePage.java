package commons;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
	
	public static BasePage getBasePage() {
		return new BasePage();
	}
	
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
		explicitWait = new WebDriverWait(driver, longTimeout); 
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
	
	public WebElement getElement (WebDriver driver,String locator) {
		return driver.findElement(getByXpath(locator));
	}
	
	public WebElement getElement (WebDriver driver,String locator, String... params) {
		return driver.findElement(getByXpath(getDynamicLocator(locator, params)));
	}
	
	public List<WebElement> getElements (WebDriver driver,String locator) {
		return driver.findElements(getByXpath(locator));
	}
	
	public String getDynamicLocator (String xpathValue, String... values) {
		xpathValue = String.format(xpathValue, (Object[]) values);
		return xpathValue;
	}
	
	
	public void clickToElement(WebDriver driver,String locator, String... params) {
		getElement(driver,getDynamicLocator(locator, params)).click();
	}
	
	public void clickToElement(WebDriver driver,String locator) {
		getElement(driver, locator).click();
	}
	
	public void sendkeyToElement(WebDriver driver,String locator, String value) {
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}
	
	public void sendkeyToElement(WebDriver driver,String locator, String value, String... params) {
		locator = getDynamicLocator(locator, params);
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}
	
	public int getElementSize(WebDriver driver,String locator) {
		return getElements(driver, locator).size();
	}
	
	public int getElementSize(WebDriver driver,String locator, String...params ) {
		return getElements(driver, getDynamicLocator(locator, params)).size();
	}
	
	public void selectDropdownByText(WebDriver driver,String locator, String itemText) {
		select = new Select(getElement(driver, locator));
		select.selectByVisibleText(itemText);
	}
	
	public String getSelectedItemDropdown (WebDriver driver,String locator) {
		select = new Select(getElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}
	
	
	public boolean isDropdownMultiple (WebDriver driver,String locator) {
		select = new Select(getElement(driver, locator));
		return select.isMultiple();
	}
	
	public void selectItemInCustomDropdown (WebDriver driver, String parentXpath, String childXPath, String expectedItem) {
		getElement(driver, parentXpath).click();
		sleepInSecond(1);
		
		explicitWait = new WebDriverWait(driver, longTimeout);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXPath) ));
		
		for (WebElement item : allItems) {
			
			if (item.getText().trim().equals(expectedItem)) {
				if (!item.isDisplayed()) {
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);}
				
				item.click();
				break;
			}
			
		}
		
	}
	
	public String getElementAttributeValue(WebDriver driver, String locator, String attributeName) {
		return getElement(driver, locator).getAttribute(attributeName);
	}
	
	public String getElementAttributeValue(WebDriver driver, String locator, String attributeName, String...params ) {
		return getElement(driver, getDynamicLocator(locator, params)).getAttribute(attributeName);
	}
	
	
	public String getElementText(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}
	
	public String getElementText(WebDriver driver, String locator, String... params) {
		return getElement(driver, getDynamicLocator(locator, params)).getText();
		
	}
	
	public void checktoChecboxOrRadio(WebDriver driver, String locator) {
		if(!isElementSelected(driver, locator)) {
			getElement(driver, locator).click();
		}
	}
	
	public void checktoChecboxOrRadio(WebDriver driver, String locator, String... params) {
		if(!isElementSelected(driver, getDynamicLocator(locator, params))) {
			getElement(driver, getDynamicLocator(locator, params)).click();
		}
	}
	
	public void UnchecktoChecboxOrRadio(WebDriver driver, String locator) {
		if(isElementSelected(driver, locator)) {
			getElement(driver, locator).click();
		}
	}
	
	public void UnchecktoChecboxOrRadio(WebDriver driver, String locator, String... params) {
		if(isElementSelected(driver, getDynamicLocator(locator, params))) {
			getElement(driver, getDynamicLocator(locator, params)).click();
		}
	}
	
	public boolean isElementDisplayed (WebDriver driver, String locator) {
		return getElement(driver, locator).isDisplayed();
	}
	
	public boolean isElementDisplayed (WebDriver driver, String locator, String... params) {
		return getElement(driver, getDynamicLocator(locator, params)).isDisplayed();
	}
	
	public boolean isElementUndisplayed(WebDriver driver, String locator) {
		System.out.println("Start time =" + new Date().toString());
		overridGlobalTimeout(driver, shortTimeout);
		List<WebElement> elements = getElements(driver,locator);
		overridGlobalTimeout(driver, longTimeout);
		
		if (elements.size()==0) {
			System.out.println("Element not in DOM");
			System.out.println("End time = "+  new Date().toString());
			return true;
		} else if  (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visible on UI");
			System.out.println("End time = "+  new Date().toString());
			return true;
		} else {
			System.out.println("Element in DOM and visible on UI");
			System.out.println("End time = "+  new Date().toString());
			return false;
		}
	}

	public boolean isTextNotEmptyOrNull(String textToCheck) {
		if (textToCheck != null && !textToCheck.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void overridGlobalTimeout(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	
	public boolean isElementEnabled (WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}
	
	public boolean isElementSelected (WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}
	
	public WebDriver switchToIframeByElement(WebDriver driver, String locator) {
		 return driver.switchTo().frame(getElement(driver, locator));
	}
	
	public WebDriver switchToDefaultContent(WebDriver driver) {
		return driver.switchTo().defaultContent();
	}
	
	public void hoverToElement (WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
	}
	
	public void doubleClickToElement (WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();
	}
	
	public void rightClickToElement (WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();
	}
	
	public void dragAndDropElement (WebDriver driver, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
	}
	
	public void pressKeyToElement (WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator),key).perform();
	} 
	
	public void pressKeyToElement (WebDriver driver, String locator, Keys key, String... params) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, getDynamicLocator(locator, params)),key).perform();
	} 
	
	public Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	public void waitForElementVisible (WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitForElementVisible (WebDriver driver, String locator, String... params) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, params))));
	}
	
	public void waitForAllElementsVisible (WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}
	
	public void waitForElementClickable (WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	
	public void waitForElementClickable (WebDriver driver, String locator, String... params) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, params))));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locator, String... params) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLocator(locator, params))));
	}
	
	public Float parseRawPriceWithCurrecy(String rawPriceWithCurrency)
	{
			Float price;
			price = Float.parseFloat(rawPriceWithCurrency.substring(1, rawPriceWithCurrency.length()));
			return price;
	}
	
	private Alert alert;
	private Select select;
	private Actions  action;
	private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;
	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
}
