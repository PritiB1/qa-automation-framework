package CucumberOptions;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Features",
glue = "StepDefinitions",
monochrome = true, dryRun = true)
	
public class TestRunner {

}
