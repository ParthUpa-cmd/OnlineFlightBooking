package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.*;
import io.cucumber.junit.CucumberOptions;
import utils.DriverFactory;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"},
        plugin = {
                "pretty",
                "summary",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json",
                "utils.ExtentReportListener"
        },
        monochrome = true
)
public class TestRunner {
    @AfterClass
    public static void cleanUp() {
        DriverFactory.quitDriver();
    }
}
