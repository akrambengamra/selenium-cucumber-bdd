package page_Objects;

import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.DriverFactory;
import utils.Global_Vars;

public class Base_PO {

	public Base_PO() {

		PageFactory.initElements(getDriver(), this);
	}

	public WebDriver getDriver() {

		return DriverFactory.getDriver();
	}

	public void navigate_To_URL(String url) {

		getDriver().get(url);
	}

	public String generateRandomNumber(int length) {
		return RandomStringUtils.randomNumeric(length);
	}

	public String generateRandomString(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}

	public void sendKeys(By by, String textToType) {

		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
		wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
	}

	public void sendKeys(WebElement element, String textToType) {

		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
		wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
	}

	public void waitWebElementAndClick(By by) {

		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void waitWebElementAndClick(WebElement element) {

		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public void waitForAlert_And_ValidateText(String text) {

		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
		wait.until(ExpectedConditions.alertIsPresent());
		String alert_Message_text = getDriver().switchTo().alert().getText();
		Assert.assertEquals(alert_Message_text, text);
	}

	public void wait_For_WebElement_Visibility(By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}

	public void wait_For_WebElement_Visibility(WebElement submissionMsg) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
		wait.until(ExpectedConditions.visibilityOf(submissionMsg));

	}
}
