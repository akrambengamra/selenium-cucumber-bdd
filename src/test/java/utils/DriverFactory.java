package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

	public static WebDriver getDriver() {

		if (webDriver.get() == null) {
			webDriver.set(createDriver());
		}
		return webDriver.get();
	}

	private static WebDriver createDriver() {
		WebDriver driver = null;

		switch (getBrowserType()) {
		case "chrome": {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver(chromeOptions);
			break;
		}
		case "firefox": {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new FirefoxDriver(firefoxOptions);
			break;
		}
		}
		driver.manage().window().maximize();
		return driver;
	}

	private static String getBrowserType() {
		String browserType = null;

		try {
			Properties properties = new Properties();
			FileInputStream file = new FileInputStream("src/test/resources/configs/configFile.properties");
			properties.load(file);
			browserType = properties.getProperty("browser").toLowerCase().trim();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return browserType;
	}

	public static void cleanupDriver() {
		if (null != webDriver.get()) {
			webDriver.get().quit(); // First quit WebDriver session gracefully
			webDriver.remove(); // Remove WebDriver reference from the ThreadLocal variable.
		}
	}
}
