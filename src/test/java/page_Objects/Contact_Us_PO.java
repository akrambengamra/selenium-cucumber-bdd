package page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Contact_Us_PO extends Base_PO {

	private @FindBy(xpath = "//input[@name='first_name']") WebElement first_name_TextField;

	private @FindBy(xpath = "//input[@name='last_name']") WebElement last_name_TextField;

	private @FindBy(xpath = "//input[@name='email']") WebElement email_TextField;

	private @FindBy(xpath = "//textarea[@name='message']") WebElement message_TextField;

	private @FindBy(xpath = "//input[@value='SUBMIT']") WebElement submit_Button;

	private @FindBy(xpath = "//div[@id='contact_reply']/h1") WebElement submission_Message;

	public Contact_Us_PO() {
		super();
	}

	public void navigateTo_WebDriverUniversity_ContactUs_Page() {
		navigate_To_URL("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
	}

	public void setFirstname(String firstname) {

		sendKeys(first_name_TextField, firstname);
	}

	public void setLastname(String lastname) {

		sendKeys(last_name_TextField, lastname);
	}

	public void setEmail(String email) {
		sendKeys(email_TextField, email);
	}

	public void setMessage(String message) {

		sendKeys(message_TextField, message);
	}

	public void setUniqueFirstname() {

		sendKeys(first_name_TextField, "AutoFN" + generateRandomNumber(5));
	}

	public void setUniqueLastname() {

		sendKeys(last_name_TextField, "AutoLN" + generateRandomNumber(5));
	}

	public void setUniqueEmail() {
		sendKeys(email_TextField, "AutoEmail" + generateRandomNumber(10) + "@mail.com");
	}

	public void setUniqueMessage() {

		sendKeys(message_TextField, "Hello world " + generateRandomString(20));
	}

	public void clickOn_submit_btn() {
		waitWebElementAndClick(submit_Button);
	}

	public void validate_Successful_SubmissionMessage_Text() {
		wait_For_WebElement_Visibility(submission_Message);
		Assert.assertEquals(submission_Message.getText(), "Thank You for your Message!");
	}
}
