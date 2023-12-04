package runners;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/spec/features"}, 
				glue = {"step_Definitions"},
                tags = "@contact-us", 
                monochrome = true, 
                dryRun = false,
                plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"})

public class MainRunner extends AbstractTestNGCucumberTests {
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
