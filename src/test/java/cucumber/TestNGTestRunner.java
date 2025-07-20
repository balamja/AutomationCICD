package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/cucumber",
    glue = "mjaacademy.stepDefinitions",          // ✅ correct spelling
    monochrome = true,
    tags ="@Regression",
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber.html"
        
    }
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
    // No need to write any code here. Cucumber will pick everything automatically.
}
