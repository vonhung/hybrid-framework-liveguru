package pageObjects.liveGuru;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.liveGuru.CartPageUI;
import pageUIs.liveGuru.ProductPageUI;

public class CartPageObject extends BasePage {
	WebDriver driver;

	public CartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getCostOnPDP() {
		waitForElementVisible(driver, ProductPageUI.PRODUCT_PRICE);
		return getElementText(driver, ProductPageUI.PRODUCT_PRICE);
	}

	public boolean isProductAddedToCart(String productName) {
		waitForElementVisible(driver, CartPageUI.ADD_TO_CART_SUCCESS_MESSAGE, productName);
		return isElementDisplayed(driver, CartPageUI.ADD_TO_CART_SUCCESS_MESSAGE, productName);
	}

	public void sendkeyToDiscountCodesField(String discountCode) {
		waitForElementVisible(driver, CartPageUI.DIDSCOUNT_CODE_TEXTBOX);
		sendkeyToElement(driver, CartPageUI.DIDSCOUNT_CODE_TEXTBOX, discountCode);
	}

	public void clickOnApplyLink() {
		waitForElementVisible(driver, CartPageUI.APPLY_BUTTON);
		clickToElement(driver, CartPageUI.APPLY_BUTTON);

	}

	public boolean isDiscountAmountDisplayed(String discountCode, String discountAmount) {
		waitForElementVisible(driver, CartPageUI.DISCOUNT_AMOUNT, discountCode, discountAmount);
		return isElementDisplayed(driver, CartPageUI.DISCOUNT_AMOUNT, discountCode, discountAmount);
	}

	public String calculateDiscountAmount(String productCostPDP, Integer discountPercentage) {
		BigDecimal discountAmount;
		Float rawCost, rawDiscountAmount;
		rawCost = Float.parseFloat(productCostPDP.substring(1, productCostPDP.length()));
		rawDiscountAmount = (rawCost * discountPercentage) / 100;
		discountAmount = new BigDecimal(rawDiscountAmount).setScale(2, RoundingMode.HALF_UP);
//		System.out.println("productCostPDP: "+productCostPDP);
//		System.out.println("RawCost: "+rawCost);
//		System.out.println("rawDiscountAmount: "+rawDiscountAmount);
//		System.out.println("discountAmount: "+discountAmount);

		return discountAmount.toString();
	}

	public void sendKeyToQty(String requestQty) {
		waitForElementVisible(driver, CartPageUI.QTY_INPUT_FIELD);
		sendkeyToElement(driver, CartPageUI.QTY_INPUT_FIELD, requestQty);
	}

	public void clickOnUpdateQtyButton() {
		waitForElementVisible(driver, CartPageUI.QTY_UPDATE_BUTTON);
		clickToElement(driver, CartPageUI.QTY_UPDATE_BUTTON);
	}

	public boolean isCartErrorMessageDisplayed() {
		waitForElementVisible(driver, CartPageUI.OVER_QTY_CART_ERROR_MESSAGE);
		return isElementDisplayed(driver, CartPageUI.OVER_QTY_CART_ERROR_MESSAGE);
	}

	public boolean isItemErrorMessageDisplayed(String maximumqQty) {
		waitForElementVisible(driver, CartPageUI.OVER_QTY_ITEM_ERROR_MESSAGE, maximumqQty);
		return isElementDisplayed(driver, CartPageUI.OVER_QTY_ITEM_ERROR_MESSAGE, maximumqQty);
	}

	public void clickOnEmptyCartButton() {
		waitForElementVisible(driver, CartPageUI.EMPTY_CART_BUTTON);
		clickToElement(driver, CartPageUI.EMPTY_CART_BUTTON);
	}

	public boolean isEmptyCartMessageDisplayed() {
		waitForElementVisible(driver, CartPageUI.EMTY_CART_MESSAGE);
		return isElementDisplayed(driver, CartPageUI.EMTY_CART_MESSAGE);
	}

	public ProductListPageObject clickOnMobile() {
		waitForElementVisible(driver, CartPageUI.MOBILE_MENU);
		clickToElement(driver, CartPageUI.MOBILE_MENU);
		return PageGeneratorManager.getProductListPageObject(driver);
	}

	public void selectDropdownState(String stateName) {
		waitForElementVisible(driver, CartPageUI.STATE_DROPDOWN_SELECTION);
		selectDropdownByText(driver, CartPageUI.STATE_DROPDOWN_SELECTION, stateName);
	}

	public void enterZipcode(String zipCode) {
		waitForElementVisible(driver, CartPageUI.ZIPCODE_INPUT_FIELD);
		sendkeyToElement(driver, CartPageUI.ZIPCODE_INPUT_FIELD, zipCode);
	}

	public void clickEstimateButton() {
		waitForElementVisible(driver, CartPageUI.ESTIMATE_BUTTON);
		clickToElement(driver, CartPageUI.ESTIMATE_BUTTON);
	}

	public boolean isShippingPriceGenerated(String expectedShippingPrice) {
		waitForElementVisible(driver, CartPageUI.FLATRATE_SHIPPING_PRICE);
		String generatedShippingPrice = getElementText(driver, CartPageUI.FLATRATE_SHIPPING_PRICE);
		if (generatedShippingPrice == expectedShippingPrice) {
			return true;
		} else
			return false;
	}

	public void selectShippingCostRadioButton() {
		waitForElementVisible(driver, CartPageUI.SHIPPING_COST_RADIO_BUTTON);
		checktoChecboxOrRadio(driver, CartPageUI.SHIPPING_COST_RADIO_BUTTON);
	}

	public void clickUpdateTotalButton() {
		waitForElementVisible(driver, CartPageUI.UPDATE_TOTAL_BUTTON);
		clickToElement(driver, CartPageUI.UPDATE_TOTAL_BUTTON);
	}

	public boolean isShippingIncludedInTotalPrice() {
		String rawSubtotal, rawCartShippingPrice, rawGrandTotal;
		Float subtotal, shippingPrice, grandTotal;
		waitForElementVisible(driver, CartPageUI.CART_SUBTOTAL);
		rawSubtotal = getElementText(driver, CartPageUI.CART_SUBTOTAL);
		subtotal = parseRawPriceWithCurrecy(rawSubtotal);
		waitForElementVisible(driver, CartPageUI.CART_SHIPPING_PRICE);
		rawCartShippingPrice = getElementText(driver, CartPageUI.CART_SHIPPING_PRICE);
		shippingPrice = parseRawPriceWithCurrecy(rawCartShippingPrice);
		waitForElementVisible(driver, CartPageUI.CART_GRAND_TOTAL);
		rawGrandTotal = getElementText(driver, CartPageUI.CART_GRAND_TOTAL);
		grandTotal = parseRawPriceWithCurrecy(rawGrandTotal);
		if (grandTotal == subtotal + shippingPrice) {
			return true;
		} else {
			return false;
		}
	}

	public CheckoutPageObject clickProceedToCheckoutButton() {
		waitForElementVisible(driver, CartPageUI.PROCEED_TO_CHECKOUT_BUTTON);
		clickToElement(driver, CartPageUI.PROCEED_TO_CHECKOUT_BUTTON);
		return PageGeneratorManager.getCheckoutPage(driver);
	}

}
