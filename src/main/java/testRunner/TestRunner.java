package testRunner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = "./Features",
        glue = "stepDefinitions",
        tags = "@testHudl",
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true
)

public class TestRunner {
}
