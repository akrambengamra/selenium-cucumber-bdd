package step_Definitions.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import static utils.DriverFactory.getDriver;

import java.sql.Timestamp;

import static utils.DriverFactory.cleanupDriver;;

public class Hooks {
	public WebDriver driver;

	   @Before
	    public void setup() {
	        getDriver();
	    }
	   
	   @AfterStep
	    public void captureExceptionImage(Scenario scenario) {
	        if (scenario.isFailed()) {
	            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	            String timeMilliseconds = Long.toString(timestamp.getTime());

	            byte[] screenshot = ((TakesScreenshot) getDriver())
	                    .getScreenshotAs(OutputType.BYTES);
	            scenario.attach(screenshot, "image/png", timeMilliseconds);
	        }
	    }

	    @After
	    public void tearDown() {
	        cleanupDriver();
	    }
}
