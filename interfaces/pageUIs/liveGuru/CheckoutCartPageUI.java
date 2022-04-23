package pageUIs.liveGuru;

public class CheckoutCartPageUI {
	public static final String ADD_TO_CART_SUCCESS_MESSAGE = "//li[@class='success-msg']//span[text()='%s was added to your shopping cart.']";
	public static final String DIDSCOUNT_CODE_TEXTBOX = "//input[@id='coupon_code']";
	public static final String APPLY_BUTTON = "//button[@value='Apply']";
	public static final String DISCOUNT_AMOUNT = "//td[contains(text(),'Discount (%s)')]/parent::tr//span[@class='price' and text()='-$%s']";
	
}
