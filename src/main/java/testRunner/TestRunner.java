package testRunner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = "/Users/lalittewari/Documents/Projects/SeleniumCucumber/Features",
        glue = "stepDefinitions",
        tags = "@test"
)

public class TestRunner {
}
