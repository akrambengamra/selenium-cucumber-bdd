package page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PO extends Base_PO {

	private @FindBy(id = "text") WebElement username_textField;

	private @FindBy(id = "password") WebElement password_textField;

	private @FindBy(id = "login-button") WebElement login_btn;

	public Login_PO() {
		super();
	}

	public void navigateTo_WebDriverUniversity_Login_Page() {

		navigate_To_URL("https://www.webdriveruniversity.com/Login-Portal/index.html?");

	}

	public void setUsername(String username) {
		sendKeys(username_textField, username);
	}

	public void setPassword(String pwd) {
		sendKeys(password_textField, pwd);
	}

	public void clickOn_login_btn() {
		waitWebElementAndClick(login_btn);
	}

	public void Validate_SuccesfulLogin_Message() {
		waitForAlert_And_ValidateText("validation succeeded");
	}

	public void Validate_UnsuccessfulLogin_Message() {
		waitForAlert_And_ValidateText("validation failed");
	}
}
