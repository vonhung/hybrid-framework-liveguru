package pageUIs.liveGuru;

public class ProductListPageUI {
	public static final String PRODUCT_PRICE = "//a[text()='%s']//ancestor::div[@class='product-info']//span[@class='price']";
	public static final String PRODUCT_IMAGE_SELECTOR = "//a[text()='%s']//ancestor::li[@class='item last']//a[@class='product-image']";
	public static final String ADD_TO_COMPARE_BUTTON = "//a[text()='%s']//ancestor::div[@class='product-info']//a[@class='link-compare']";
	public static final String ADDED_TO_COMPARE_MESSAGE = "//li[@class='success-msg']//span[text()='The product %s has been added to comparison list.']";
	public static final String COMPARE_BUTTON = "//button[@title='Compare']";

}
