package pageUIs.liveGuru;

public class CartPageUI {
	public static final String ADD_TO_CART_SUCCESS_MESSAGE = "//li[@class='success-msg']//span[text()='%s was added to your shopping cart.']";
	public static final String DIDSCOUNT_CODE_TEXTBOX = "//input[@id='coupon_code']";
	public static final String APPLY_BUTTON = "//button[@value='Apply']";
	public static final String DISCOUNT_AMOUNT = "//td[contains(text(),'Discount (%s)')]/parent::tr//span[@class='price' and text()='-$%s']";
	public static final String QTY_INPUT_FIELD = "//input[@class='input-text qty']";
	public static final String QTY_UPDATE_BUTTON = "//td[@class='product-cart-actions']/button[@name='update_cart_action']";
	public static final String OVER_QTY_CART_ERROR_MESSAGE = "//li[@class='error-msg']//span[text()='Some of the products cannot be ordered in requested quantity.']";
	public static final String OVER_QTY_ITEM_ERROR_MESSAGE = "//p[@class='item-msg error' and contains(string(),'* The maximum quantity allowed for purchase is %s.')]";
	public static final String EMPTY_CART_BUTTON = "//button[@id='empty_cart_button']";
	public static final String EMTY_CART_MESSAGE = "//h1[text()='Shopping Cart is Empty']//parent::div[@class='page-title']//following-sibling::div//p[text()='You have no items in your shopping cart.']";
	public static final String MOBILE_MENU = "//div[@id='header-nav']//a[text()='Mobile']";
	public static final String STATE_DROPDOWN_SELECTION = "//select[@id='region_id']";
	public static final String ZIPCODE_INPUT_FIELD = "//input[@name='estimate_postcode']";
	public static final String ESTIMATE_BUTTON = "//button[@title='Estimate']";
	public static final String SHIPPING_COST_RADIO_BUTTON = "//input[@name='estimate_method']";
	public static final String UPDATE_TOTAL_BUTTON = "//button[@title='Update Total']";
	public static final String PROCEED_TO_CHECKOUT_BUTTON = "//div[@class='cart-totals']//button[@title='Proceed to Checkout']";
	public static final String FLATRATE_SHIPPING_PRICE = "//label[@for='s_method_flatrate_flatrate']/span";
	public static final String CART_SUBTOTAL = "//td[contains(text(),'Subtotal')]/parent::tr//span[@class='price']";
	public static final String CART_SHIPPING_PRICE = "//td[contains(text(),'Shipping & Handling (Flat Rate - Fixed)')]/parent::tr//span[@class='price']";
	public static final String CART_GRAND_TOTAL = "//strong[text()='Grand Total']/parent::td/following-sibling::td//span[@class='price']";

	
	
}
