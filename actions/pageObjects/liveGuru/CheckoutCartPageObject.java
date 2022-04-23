package pageObjects.liveGuru;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.liveGuru.CheckoutCartPageUI;
import pageUIs.liveGuru.ProductPageUI;

public class CheckoutCartPageObject extends BasePage {
	WebDriver driver;

	public CheckoutCartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getCostOnPDP() {
		waitForElementVisible(driver, ProductPageUI.PRODUCT_PRICE);
		return getElementText(driver,ProductPageUI.PRODUCT_PRICE);
	}

	public boolean isProductAddedToCart(String productName) {
		waitForElementVisible(driver, CheckoutCartPageUI.ADD_TO_CART_SUCCESS_MESSAGE,productName);
		return isElementDisplayed(driver, CheckoutCartPageUI.ADD_TO_CART_SUCCESS_MESSAGE,productName);
	}

	public void sendkeyToDiscountCodesField(String discountCode) {
		waitForElementVisible(driver, CheckoutCartPageUI.DIDSCOUNT_CODE_TEXTBOX);
		sendkeyToElement(driver, CheckoutCartPageUI.DIDSCOUNT_CODE_TEXTBOX, discountCode);
	}

	public void clickOnApplyLink() {
		waitForElementVisible(driver, CheckoutCartPageUI.APPLY_BUTTON);
		clickToElement(driver, CheckoutCartPageUI.APPLY_BUTTON);
		
	}

	public boolean isDiscountAmountDisplayed(String discountCode, String discountAmount) {
		waitForElementVisible(driver, CheckoutCartPageUI.DISCOUNT_AMOUNT, discountCode, discountAmount);
		return isElementDisplayed(driver, CheckoutCartPageUI.DISCOUNT_AMOUNT, discountCode, discountAmount) ;
	}

	public String calculateDiscountAmount(String productCostPDP, Integer discountPercentage) {
		BigDecimal discountAmount;
		Float rawCost, rawDiscountAmount ;
		rawCost = Float.parseFloat(productCostPDP.substring(1, productCostPDP.length()));
		rawDiscountAmount  = (rawCost * discountPercentage)/100;
		discountAmount = new BigDecimal(rawDiscountAmount).setScale(2, RoundingMode.HALF_UP);
		System.out.println("productCostPDP: "+productCostPDP);
		System.out.println("RawCost: "+rawCost);
		System.out.println("rawDiscountAmount: "+rawDiscountAmount);
		System.out.println("discountAmount: "+discountAmount);
	
		return discountAmount.toString();
	}

}
