package pageUIs.liveGuru;

public class ProductReviewPageUI {

	public static final String ADDED_TO_WISHLIST_MESSAGE = "//li[@class='success-msg']//span[text()='%s has been added to your wishlist. Click ']/a[text()='here']/parent::span[text()=' to continue shopping.']";
	public static final String REVIEW_DETAILS_FIELD = "//textarea[@id='review_field']";
	public static final String SUBMIT_REVIEW_BUTTON = "//button[@title='Submit Review']";
	public static final String REQUIRED_FIELD_VALIDATION_MESSAGE = "//label[@for='%s']/parent::li//div[text()='This is a required field.']";
	public static final String RATING_RADIO_BUTTON = "//input[@name='ratings[1]' and @value='%s']";
	public static final String REVIEW_ACCEPTED_SUCCESS_MESSAGE = "//li[@class='success-msg']//span['Your review has been accepted for moderation.']";
	public static final String REVIEW_SUMMARY = "//input[@id='summary_field']";
	public static final String NICK_NAME = "//input[@id='nickname_field']";
}
