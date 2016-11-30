package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/AddWorkItem.feature",
glue = {"step_definitions"},
tags = {"~@wip"},
format = {
		"pretty", "html:target/cucumber", "json:target/cucumber-report.json" })
public class RunCakeTest {

}
