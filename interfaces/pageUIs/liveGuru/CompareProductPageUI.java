package pageUIs.liveGuru;

public class CompareProductPageUI {
	public static final String REGISTER_FIRST_NAME_TEXTBOX = "//label[@for='firstname']//following-sibling::div/input";
	public static final String REGISTER_LAST_NAME_TEXTBOX = "//label[@for='lastname']//following-sibling::div/input";
	public static final String REGISTER_EMAIL_TEXTBOX = "//label[@for='email_address']//following-sibling::div/input";
	public static final String REGISTER_PASSWORD_TEXTBOX = "//label[@for='password']//following-sibling::div/input";
	public static final String REGISTER_CONFIRM_PASSWORD_TEXTBOX = "//label[@for='confirmation']//following-sibling::div/input";
	public static final String REGISTER_BUTTON = "//button [@title='Register']";
	public static final String COMPARE_POPUP_HEADING_TEXT = "//div[@class='page-title title-buttons']/h1[text()='Compare Products']";
	public static final String SELECTED_PRODUCT_NAME_IN_COMPARE = "//h2[@class='product-name']/a[text()='%s']";
	

}
